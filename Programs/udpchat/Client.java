import java.io.*;
import java.net.*;

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

class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();

        Data msg = new Data("welcome");
        byte[] data = Data.serialize(msg);
        DatagramPacket packet = new DatagramPacket(
                                        data,
                                        data.length,
                                        InetAddress.getByName("localhost"),
                                        5500);

        socket.send(packet);

        socket.receive(packet);
        msg = Data.deserialize(data);
        System.out.println(msg.msg);
    }
}
