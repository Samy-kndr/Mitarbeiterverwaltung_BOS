import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BackgroundImage extends JFrame {

    public BackgroundImage() {
        setSize(400, 400);
        setVisible(true);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("4stars.png")));
        setLayout(new FlowLayout());
        //l1 = new JLabel("Here is a button");
        //b1 = new JButton("I am a button");
        //add(l1);
        //add(b1);
        setSize(1920,1080);
        setSize(1920,1080);
    }

}