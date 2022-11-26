package Inlämning3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Puzzle extends JFrame implements ActionListener {

    JPanel puzzlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");
    JButton b6 = new JButton("6");
    JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    JButton b10 = new JButton("10");
    JButton b11 = new JButton("11");
    JButton b12 = new JButton("12");
    JButton b13 = new JButton("13");
    JButton b14 = new JButton("14");
    JButton b15 = new JButton("15");
    JButton b16 = new JButton(" ");
    JButton gameButton = new JButton("NEW GAME");

    //List<JButton> buttonList = new ArrayList<>();
    public Dimension buttonSize = new Dimension(40,40);

    public Puzzle() {
        setLayout(new BorderLayout());
        add(puzzlePanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.NORTH);

        buttonPanel.add(gameButton);
        puzzlePanel.setLayout(new GridLayout(4,4));
        puzzlePanel.add(b1);
        puzzlePanel.add(b2);
        puzzlePanel.add(b3);
        puzzlePanel.add(b4);
        puzzlePanel.add(b5);
        puzzlePanel.add(b6);
        puzzlePanel.add(b7);
        puzzlePanel.add(b8);
        puzzlePanel.add(b9);
        puzzlePanel.add(b10);
        puzzlePanel.add(b11);
        puzzlePanel.add(b12);
        puzzlePanel.add(b13);
        puzzlePanel.add(b14);
        puzzlePanel.add(b15);
        puzzlePanel.add(b16);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == gameButton) {

        }
    }
}
