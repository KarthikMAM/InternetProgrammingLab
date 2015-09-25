import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ColorButtons extends Applet implements ActionListener{
    private Button red = new Button("red");
    private Button blue = new Button("blue");

    int left = 100;

    public void init() {
        Panel colors = new Panel(new GridLayout(2,2));
        colors.add(red);
        colors.add(blue);
        add(colors);

        red.addActionListener(this);
        blue.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        ((Button)e.getSource()).setBackground(Color.red);
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString("msg", ++left, 30);
    }

}
