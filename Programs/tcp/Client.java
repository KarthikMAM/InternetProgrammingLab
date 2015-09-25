import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket client = new Socket("localhost", 5500);

        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        DataInputStream in = new DataInputStream(client.getInputStream());

        out.writeUTF("hello");
        System.out.println(in.readUTF());

        client.close();
    }
}
