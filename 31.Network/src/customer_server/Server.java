package customer_server;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author ：Gary Wu
 * @date ：Created in 16:52 2020/2/21
 * @description：
 * @version: $
 */

public class Server extends Application {
    @Override
    public void start(Stage primaryStage) {
        // 创建一个屏幕用来显示文字
        ScrollPane scrollPane = new ScrollPane();
        TextArea textArea = new TextArea();
        scrollPane.setContent(textArea);
        Scene scene = new Scene(scrollPane, 450, 200);

        primaryStage.setTitle("Server");
        primaryStage.setScene(scene); // 将屏幕放入stage中
        primaryStage.show();

        new Thread(() -> {
            try {
                // 2. 创建一个 ServerSocket
                ServerSocket serverSocket = new ServerSocket(9001);
                Platform.runLater(() -> textArea.appendText("Server started at " + new Date() + '\n'));
                // 3. 监听
                Socket socket = serverSocket.accept();

                // 4. 创建数据输入流和输出流
                InputStream in = socket.getInputStream();
                DataInputStream inputStreamFromClient = new DataInputStream(in);
                OutputStream out = socket.getOutputStream();
                DataOutputStream outputStreamToClient = new DataOutputStream(out);

                while (true) {
                    // 5. 收集来自socket来的数据
                    double rad = inputStreamFromClient.readDouble();

                    // 6. 计算
                    double area = Math.pow(rad, 2) * Math.PI;

                    outputStreamToClient.writeDouble(area);

                    Platform.runLater(() -> textArea.appendText("Radius received from client: " + rad + '\n'));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
