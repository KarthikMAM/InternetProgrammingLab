import java.io.*;
import java.net.*;

public class Get {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getByName("nptel.ssn.net"), 80);

        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println("GET / HTTP/1.0");
        out.println();
        out.flush();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result;
        while((result = in.readLine()) != null) {
            System.out.println(result);
        }
    }
}
