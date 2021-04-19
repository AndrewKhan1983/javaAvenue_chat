package server;

import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Socket socket;
        {
            try {
                ServerSocket serverSocket = new ServerSocket(8188);
                System.out.println("Сервер запущен");
                socket = serverSocket.accept(); // Ожидаем клиента
                System.out.println("Клиент подключился");
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                out.writeUTF("Клиент подключился");
                while (true){
                    String request = in.readUTF();
                    out.writeUTF(request.toUpperCase());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}