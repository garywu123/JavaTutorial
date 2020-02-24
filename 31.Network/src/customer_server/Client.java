package customer_server;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author ：Gary Wu
 * @date ：Created in 15:15 2020/2/21
 * @description：客户端
 * @version: $
 */

public class Client extends Application {

    DataOutputStream toServer = null;
    DataInputStream fromServer = null;


    @Override
    public void start(Stage stage)  {
        BorderPane borderPaneForTextFile = new BorderPane();
        borderPaneForTextFile.setPadding(new Insets(5, 5, 5, 5));
        borderPaneForTextFile.setStyle("-fx-border-color: green");
        borderPaneForTextFile.setLeft(new Label("Enter a radius."));

        TextField textField = new TextField();
        textField.setAlignment(Pos.BOTTOM_RIGHT);
        borderPaneForTextFile.setCenter(textField);

        BorderPane mainPane = new BorderPane();
        // 用来展示结果的
        TextArea textArea = new TextArea();
        mainPane.setCenter(new ScrollPane(textArea));
        mainPane.setTop(borderPaneForTextFile);

        Parent root;
        Scene scene = new Scene(mainPane, 450, 200);
        stage.setTitle("Client");
        stage.setScene(scene);
        stage.show();

        textField.setOnAction(e -> {
            try{
                double radius = Double.parseDouble(textField.getText().trim());
                toServer.writeDouble(radius);
                toServer.flush();

                double area = fromServer.readDouble();

                textArea.appendText("Radius is " + radius + "\n");
                textArea.appendText("Area received from the server is "
                                            + area + '\n');
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        try{
            // 创建一个 socket
            Socket socket = new Socket("localhost", 9001);
            System.out.println("local post: " + socket.getPort());

            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
