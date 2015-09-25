import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class AppletClass extends Applet implements ActionListener{
    private TextField txtUser = new TextField(10);
    private TextField txtPass = new TextField(10);
    private TextField txtResult = new TextField(10);
    private Button btnSend = new Button("Send");

    public void init() {
        add(txtUser);
        add(txtPass);
        add(btnSend);
        add(txtResult);

        btnSend.addActionListener(this);
        txtResult.setEditable(false);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            URL url = new URL(getCodeBase(), "ServletClass");

            URLConnection con = url.openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/x-java-serialized-object");

            ObjectOutputStream out = new ObjectOutputStream(con.getOutputStream());
            out.writeObject(txtUser.getText());
            out.writeObject(txtPass.getText());
            out.flush();
            out.close();

            ObjectInputStream in = new ObjectInputStream(con.getInputStream());
            txtResult.setText((String) in.readObject());
        } catch(Exception ex) { txtResult.setText(ex.getMessage()); }
    }
}
