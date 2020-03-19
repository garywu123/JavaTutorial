package example_game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author: garyw
 * @since: 2020/2/25
 * @projectName: JavaTutorial_2
 * @description: 创建井字游戏的客户端
 **/

public class TicTacToeClient extends Application implements TicTacToeConstants {

    // Indicate whether the player has the turn
    private boolean myTurn = false;

    // Indicate the token for the player
    private char myToken = ' ';

    // Indicate the token for the other player
    private char otherToken = ' ';

    // Create and Initialize cells
    private Cell[][] cell =new Cell[3][3];

    // Create and initialize a title label
    private Label lblTitle = new Label();

    // Create and initialize a statues label
    private Label lblStatue = new Label();

    // Indicate selected row and column by the current move
    private int rowSelected;
    private int columnSelected;

    // Input and ouput streams from/to server
    private DataInputStream fromServer;
    private DataOutputStream toServer;

    // Continue to play?
    private boolean continueToPlay = true;

    // Wait for the player to mark a cell
    private boolean waiting = true;

    // Host name or ip
    private String host = "localhost";


    @Override
    public void start(Stage stage) throws Exception {
        // Panel to hold cell
        GridPane pane = new GridPane();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pane.add(cell[i][j] = new Cell(i, j), j, i);
            }
        }

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(lblTitle);
        borderPane.setCenter(pane);
        borderPane.setBottom(lblStatue);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 320, 350);
        stage.setTitle("TicTacToeClient");
        stage.setScene(scene);
        stage.show();

        // Connect to the server
        connectToServer();

    }

    private void connectToServer() {

        try{
            Socket socket = new Socket(host, 9001);

            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 启动一个线程，判断自己是Player1还是2，然后读取服务器返回来的信息
        new Thread(()->{
            try{
                // Get notification from the server
                int player = fromServer.readInt();

                // Am I player 1 or player 2
                if (player == PLAYER1) {
                    myToken = 'X';
                    otherToken = '0';
                    Platform.runLater(() -> {
                        lblTitle.setText("Player 1 with token 'X' ");
                        lblStatue.setText("Waiting for player 2 to join...");
                    });

                    // Receive startup notification from the server
                    fromServer.readInt(); // Whatever read is ignored

                    // The other player has joined
                    Platform.runLater(()->{
                        lblStatue.setText("Player 2 has joined. I start first.");
                    });

                    // It is my turn
                    myTurn = true;
                }
                else if (player == PLAYER2) {
                    myToken = '0';
                    otherToken = 'X';
                    Platform.runLater(() -> {
                        lblTitle.setText("Player 2 with token '0' ");
                        lblStatue.setText("Waiting for player 1 to move.");
                    });
                }

                // Continue to play
                while (continueToPlay) {
                    if (player == PLAYER1) {
                        waitForPlayerAction();
                        sendMove();
                        receiveInfoFromServer();
                    }
                    else if (player == PLAYER2) {
                        receiveInfoFromServer();
                        waitForPlayerAction();
                        sendMove();
                    }
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void receiveInfoFromServer() throws IOException {
        // Receive game status
        int status = fromServer.readInt();

        if (status == PLAYER1_WON) {
            // Player 1 won, stop playing
            continueToPlay = false;
            if (myToken == 'x') {
                Platform.runLater(()->lblStatue.setText("I won! (X) "));
            }
            else if (myToken == '0') {
                Platform.runLater(() ->
                          lblStatue.setText("Player 1 (X) has won! "));
                receiveMove();
            }
        }
        else if (status == PLAYER2_WON) {
            // Player 1 won, stop playing
            continueToPlay = false;
            if (myToken == '0') {
                Platform.runLater(() -> lblStatue.setText("I won! (0) "));
            }
            else if (myToken == 'X') {
                Platform.runLater(() -> lblStatue.setText("Player 2 (0) has won! "));
                receiveMove();
            }
        }
        else if (status == DRAW) {
            // No winner, game is over
            continueToPlay = false;
            Platform.runLater(() ->
                    lblStatue.setText("Game is over, no winner!"));

            if (myToken == '0') {
                receiveMove();
            }
        }
        else{
            receiveMove();
            Platform.runLater(() -> lblStatue.setText("My turn"));
            myTurn = true; // It is my turn
        }
    }

    private void receiveMove() throws IOException {
        int row = fromServer.readInt();
        int column = fromServer.readInt();
        Platform.runLater(() ->
                cell[row][column].setToken(otherToken));
    }

    private void sendMove() throws IOException {
        toServer.writeInt(rowSelected);
        toServer.writeInt(columnSelected);
    }

    private void waitForPlayerAction() throws InterruptedException {
        while (waiting) {
            Thread.sleep(100);
            waiting = true;
        }
    }

    // 用于表示棋局的内部类
    public class Cell extends Pane {
        // 暗示cell上的纵横坐标
        private int row;
        private int column;

        // Token used for this cell
        private char token = ' ';

        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
            this.setPrefSize(2000, 2000);
            setStyle("-fx-border-color: black");
            this.setOnMouseClicked(e -> handleMouseClick());
        }

        private void handleMouseClick() {
            // 如果cell 没有被占用，player获取一个turn
            if (token == ' ' && myTurn) {
                setToken(myToken);
                myTurn = false;
                rowSelected = row;
                columnSelected = column;
                lblStatue.setText("Waiting for the other player to move");
                waiting = false;
            }
        }

        // Return token
        public char getToken(){
            return token;
        }

        public void setToken(char c) {
            token = c;
            repaint();
        }

        private void repaint() {
            if (token == 'X') {
                Line line1 = new Line(10, 10,
                  this.getWidth() - 10, this.getHeight() - 10);
                line1.endXProperty().bind(this.widthProperty().subtract(10));
                line1.endYProperty().bind(this.heightProperty().subtract(10));

                Line line2 = new Line(10,
              this.getHeight() - 10, this.getWidth() - 10, 10);
                line2.endXProperty().bind(this.widthProperty().subtract(10));

                this.getChildren().addAll(line1, line2);
            }
            else if (token == '0') {
                Ellipse ellipse = new Ellipse(this.getWidth() / 2,
                                              this.getHeight() / 2,
                                              this.getWidth() / 2 - 10,
                                              this.getHeight() / 2 - 10);
                ellipse.centerXProperty().bind(this.widthProperty().divide(2));
                ellipse.centerYProperty().bind(this.heightProperty().divide(2));
                ellipse.centerXProperty().bind(this.widthProperty().divide(2).subtract(10));
                ellipse.centerYProperty().bind(this.heightProperty().divide(2).subtract(10));

                getChildren().add(ellipse);
            }
        }
    }

}
