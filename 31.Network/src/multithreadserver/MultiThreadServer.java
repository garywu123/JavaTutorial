package multithreadserver;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


/**
 * @author ：Gary Wu
 * @date ：Created in 14:53 2020/2/23
 * @description：为多个客户端创建多个线程来处理信息
 * @version: $
 */

public class MultiThreadServer extends Application {

    private TextArea textArea = new TextArea();

    private int clientNo = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new javafx.scene.control.ScrollPane(textArea), 450, 200);
        stage.setTitle("MultiThreadServer");
        stage.setScene(scene);
        stage.show();

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(9001);
                textArea.appendText("MultiThread Server started at " + new Date() + '\n');

                while (true) {
                    Socket socket = serverSocket.accept(); // 监听来自客户端的连接，如果没有连接则不会执行下一步
                    clientNo++;
                    Platform.runLater(() -> {
                        textArea.appendText("Starting thread for client "
                                                    + clientNo + " at " + new Date() + '\n');

                        InetAddress inetAddress = socket.getInetAddress();
                        textArea.appendText("Client " + clientNo
                                                    + "'s host name is " + inetAddress.getHostName() + '\n');
                        textArea.appendText("Client "
                                                    + clientNo + "'s host name is " + inetAddress.getHostAddress() + '\n');
                    });
                    // 创建一个线程用于处理消息
                    new Thread(new HandleAClient(socket)).start();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    class HandleAClient implements Runnable{
        private Socket socket;

        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try{
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

                while (true) {
                    double radius = dataInputStream.readDouble();

                    double area = Math.PI * Math.pow(radius, 2);

                    dataOutputStream.writeDouble(area);

                    Platform.runLater(() -> {
                        textArea.appendText("Radius received from clients: " +
                                radius + '\n');
                        textArea.appendText("Area found: " + area + "\n");
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
