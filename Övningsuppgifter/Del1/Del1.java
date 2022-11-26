package Övningsuppgifter.Del1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Del1 extends JFrame implements ActionListener{

    JPanel panel;
    JButton changeImage;
    JLabel imageViewer;

    int toggle = 0;

    String path = "C:\\Users\\fogel\\Desktop\\Skola\\OOP\\Sprint 3\\Bilder\\m1.jpg";
    String path2 = "C:\\Users\\fogel\\Desktop\\Skola\\OOP\\Sprint 3\\Bilder\\m2.jpg";

    public Del1() {
        changeImage = new JButton("Nästa bild");
        imageViewer = new JLabel(new ImageIcon(path2));
        panel = new JPanel();

        panel.setLayout(new FlowLayout());
        panel.add(changeImage);
        panel.add(imageViewer);

        this.add(panel);

        changeImage.addActionListener((ActionListener) this);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (toggle == 0) {
            imageViewer.setIcon(new ImageIcon(path));
            toggle = 1;
        }
        else if (toggle == 1) {
            imageViewer.setIcon(new ImageIcon(path2));
            toggle = 0;
        }
    }

    public static void main(String[] args) {
        Del1 bildBytare = new Del1();
    }


}
