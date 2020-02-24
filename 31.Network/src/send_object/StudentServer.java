package send_object;

import javafx.application.Application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：Gary Wu
 * @date ：Created in 18:33 2020/2/23
 * @description：用于接收Client的Student对象
 * @version: $
 */

public class StudentServer {

    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public static void main(String[] args) {
        new StudentServer();
    }

    public StudentServer(){
        try{
            ServerSocket serverSocket = new ServerSocket(9001);
            System.out.println("Server Started...");

            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("student.date",true));

            while (true) {
                Socket socket = serverSocket.accept();

                objectInputStream = new ObjectInputStream(socket.getInputStream());

                Object object = objectInputStream.readObject();

                objectOutputStream.writeObject(object);
                System.out.println("A new student Object is stored...");
            }

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            try{
                objectInputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
