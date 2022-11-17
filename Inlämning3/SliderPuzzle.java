package Inlämning3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SliderPuzzle extends JFrame implements ActionListener {

    JPanel puzzlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    JButton gameButton = new JButton("NEW GAME");
    JButton nullButton = new JButton();

    List<JButton> buttonList = new ArrayList<>();

    public SliderPuzzle() {
        setLayout(new BorderLayout());
        add(puzzlePanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.NORTH);

        buttonPanel.add(gameButton);

        puzzlePanel.setLayout(new GridLayout(4,4));

        gameButton.addActionListener(this);

        nullButton.setBackground(Color.WHITE);
        buttonList.add(nullButton);
        for(int i = 1; i <= 15; i ++) {
            JButton button = new JButton(String.valueOf(i));
            button.setBackground(Color.WHITE);
            button.addActionListener(this);
            buttonList.add(button);
        }

        for(JButton button : buttonList) {
            puzzlePanel.add(button);
        }

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == gameButton) {
            Collections.shuffle(buttonList);
            puzzlePanel.removeAll();
            for(JButton button : buttonList) puzzlePanel.add(button);
            puzzlePanel.setLayout(new GridLayout(4,4));
            revalidate();
        }
    }
}
