package example_game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author ：Gary Wu
 * @date ：Created in 21:06 2020/2/23
 * @description：服务器类，用来处理来自玩家的信息，然后计算比赛结果
 * @version: $
 */

public class TicTacToeServer extends Application
        implements TicTacToeConstants {

    private int sessionNo = 1; //Number of Session

    @Override
    public void start(Stage stage) throws Exception {
        TextArea taLogs = new TextArea();

        // 创建显示界面
        Scene scene = new Scene(new ScrollPane(), 450, 200);
        stage.setTitle("TicTacToServer");
        stage.setScene(scene);
        stage.show();

        new Thread(() -> {
            try{
                ServerSocket serverSocket = new ServerSocket(9001);
                Platform.runLater(() ->{
                    taLogs.appendText(new Date() +
                            "Server started at socket 9001 \n");
                });

                // 为两个玩家创建连接
                while (true) {
                    Platform.runLater(() -> taLogs.appendText(
                            new Date() + " : Wait for players to join session \n"
                    ));

                    Socket player1 = serverSocket.accept(); // 监听到玩家1

                    Platform.runLater(() -> {
                        taLogs.appendText(new Date() + ": Player 1 joined session...");

                        taLogs.appendText("Player 1's ip address "
                                          + player1.getInetAddress().getHostAddress() + '\n');
                    });

                    // 通知玩家1，已经成功连接服务器
                    new DataOutputStream(player1.getOutputStream()).writeInt(PLAYER1);

                    Socket player2 = serverSocket.accept();

                    Platform.runLater(() -> {
                        taLogs.appendText(new Date() +
                                                  " player 2 joined session " + sessionNo + '\n');
                        taLogs.appendText("Player 2's ip address "
                                                  + player2.getInetAddress().getHostAddress());
                    });

                    new DataOutputStream(player2.getOutputStream()).writeInt(PLAYER2);

                    // 显示session并增加session number
                    Platform.runLater(() -> {
                        taLogs.appendText(new Date() +
                                ": Start a thread for session " + sessionNo + '\n');
                    });

                    new Thread(new HandlerASession(player1, player2)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // 用来处理玩家进来的session所使用的内部类
    private class HandlerASession implements Runnable, TicTacToeConstants {

        private Socket player1;
        private Socket player2;

        // 定义一个棋盘
        private char[][] cell = new char[3][3];

        private DataInputStream fromPlayer1;
        private DataInputStream fromPlayer2;
        private DataOutputStream toPlayer1;
        private DataOutputStream toPlayer2;

        // 定义游戏是否结束
        private boolean continueToPlay = true;

        public HandlerASession(Socket player1, Socket player2) {
            this.player1 = player1;
            this.player2 = player2;

            // 初始化cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cell[i][j] = ' ';
                }
            }
        }

        @Override
        public void run(){
            try{
                // 创建输入输出流
                DataInputStream fromPlayer1 = new DataInputStream(player1.getInputStream());
                DataOutputStream toPlayer1 = new DataOutputStream(player1.getOutputStream());
                DataInputStream fromPlayer2 = new DataInputStream(player2.getInputStream());
                DataOutputStream toPlayer2 = new DataOutputStream(player2.getOutputStream());

                // 写一些内容告诉玩家1 可以开始
                toPlayer1.writeInt(1);

                // 持续服务玩家并告诉玩家目前游戏状态
                while (true) {
                    // 收到来自玩家1的信息
                    int row = fromPlayer1.readInt();
                    int column = fromPlayer1.readInt();
                    cell[row][column] = 'X';

                    // 检查玩家1是否胜利
                    if(isWon('X')){
                        toPlayer1.writeInt(PLAYER1_WON);
                        toPlayer2.writeInt(PLAYER1_WON);
                        sendMove(toPlayer2, row, column);
                        break; // 退出循环
                    }else if (isFull()){
                        toPlayer1.writeInt(DRAW);
                        toPlayer2.writeInt(DRAW);
                        sendMove(toPlayer2, row, column);
                        break;
                    }else{
                        // 通知玩家2继续游戏
                        toPlayer2.writeInt(CONTINUE);
                        sendMove(toPlayer2, row, column);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 发送给玩家目前的战局
        private void sendMove(
                DataOutputStream toPlayer, int row, int column) throws IOException {
            toPlayer.writeInt(row);
            toPlayer.writeInt(column);
        }

        // 判断棋盘是否满
        private boolean isFull(){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(cell[i][j] == ' '){
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isWon(char token){
            // 检查所有行
            for (int i = 0; i < 3; i++) {
                if ((cell[i][0] == token) &&
                        (cell[i][1] == token) &&
                        (cell[i][2] == token))
                {
                    return true;
                }
            }

            for (int j = 0; j < 3; j++) {
                if ((cell[0][j] == token)
                        && (cell[1][j] == token)
                        && (cell[2][j] == token)) {
                    return true;
                }
            }

            // 检查两个斜线
            if ((cell[0][0] == token)
                    && (cell[1][1] == token)
                    && (cell[2][2] == token)) {
                return true;
            }

            if ((cell[0][2] == token)
                    && (cell[1][1] == token)
                    && (cell[2][0] == token)) {
                return true;
            }

            return false;
        }
    }
}
