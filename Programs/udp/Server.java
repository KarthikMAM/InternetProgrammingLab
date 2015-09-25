import java.net.*;
import java.io.*;

class Data implements Serializable {
    String msg;

    public Data(String msg) {
        this.msg = msg;
    }

    public static byte[] serialize(Data data) throws Exception{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new ObjectOutputStream(out).writeObject(data);
        return out.toByteArray();
    }

    public static Data deserialize(byte[] data) throws Exception{
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        return (Data) new ObjectInputStream(in).readObject();
    }
}

public class Server {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(5500);

        Data msg = null;
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(
                                        data,
                                        data.length,
                                        InetAddress.getByName("localhost"),
                                        5500);

        socket.receive(packet);
        msg = Data.deserialize(data);
        System.out.println(msg.msg);
        socket.send(packet);

        socket.close();
    }
}
