import java.io.*;
import java.net.*;

class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(5500);
        Socket client = server.accept();

        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        DataInputStream in = new DataInputStream(client.getInputStream());

        System.out.println(in.readUTF());
        out.writeUTF("welcome");

        client.close();
        server.close();
    }
}
