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
    List<JButton> finishedPuzzleList = new ArrayList<>();

    public SliderPuzzle() {
        setLayout(new BorderLayout());
        add(puzzlePanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.NORTH);

        buttonPanel.add(gameButton);
        gameButton.addActionListener(this);
        puzzlePanel.setLayout(new GridLayout(4,4));
        nullButton.setBackground(Color.PINK);

        for(int i = 1; i <= 15; i ++) {
            JButton button = new JButton(String.valueOf(i));
            button.setBackground(Color.WHITE);
            button.addActionListener(this);
            buttonList.add(button);
            finishedPuzzleList.add(button);
        }
        buttonList.add(nullButton);
        finishedPuzzleList.add(nullButton);
        for(JButton button : buttonList) {
            puzzlePanel.add(button);
        }

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public int findNullButton() {
        int nullButtonPlace = 0;
        for(JButton button : buttonList) {
            if(button == nullButton) {
                nullButtonPlace = buttonList.indexOf(button);
            }
        }
        return nullButtonPlace;
    }
    public boolean canSwap(int nullButtonPlace, int clickedButtonPlace) {
        if(nullButtonPlace%4 == clickedButtonPlace%4) {
            if(Math.abs(nullButtonPlace/4 - clickedButtonPlace/4)==1)
                return true;
        }
        if(nullButtonPlace/4 == clickedButtonPlace/4) {
            if(Math.abs(nullButtonPlace - clickedButtonPlace) == 1)
                return true;
        }
        return false;
    }

    public boolean solved (List<JButton> buttonList){
        return buttonList.equals(finishedPuzzleList);
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
        else if(e.getSource() != nullButton) {
            if(canSwap(findNullButton(), buttonList.indexOf(e.getSource()))){
                Collections.swap(buttonList, findNullButton(), buttonList.indexOf(e.getSource()));
                for(JButton button : buttonList) puzzlePanel.add(button);
                puzzlePanel.setLayout(new GridLayout(4,4));
                revalidate();
                if(solved(buttonList)){
                    JOptionPane.showMessageDialog(null, "Huzzah! \nDu vann!");
                }
            }
        }
    }
}
