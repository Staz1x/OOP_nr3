package Övningsuppgifter.Del1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Övn3 extends JFrame implements ActionListener {

    JPanel questions = new JPanel();
    JPanel answers = new JPanel();
    JPanel checkboxes = new JPanel();
    JPanel amountBack = new JPanel();

    JTextField priceInput = new JTextField(10);
    JTextField amountPaidInput = new JTextField(10);

    JLabel priceInputLabel = new JLabel("Pris på varan");
    JLabel amountPaidInputLabel = new JLabel("Hur mycket betalar du");

    JLabel amountBackOutput = new JLabel("Du får tillbaka");

    JCheckBox fiveHundred = new JCheckBox("500 lappar", false);
    JCheckBox twoHundred = new JCheckBox("200 lappar", false);
    JCheckBox oneHundred = new JCheckBox("100 lappar", false);
    JCheckBox fifty = new JCheckBox("50 lappar", false);
    JCheckBox twenty = new JCheckBox("20 lappar", false);
    JCheckBox ten = new JCheckBox("10 kronor", true);
    JCheckBox five = new JCheckBox("5 kronor", true);
    JCheckBox two = new JCheckBox("2 kronor", true);
    JCheckBox one = new JCheckBox("1 kronor", true);

    public Övn3 () {
        setLayout(new BorderLayout());
        add(questions, BorderLayout.WEST);
        add(answers, BorderLayout.CENTER);
        add(checkboxes, BorderLayout.NORTH);
        add(amountBack, BorderLayout.SOUTH);

        questions.setLayout(new GridLayout(2,1));
        questions.add(priceInputLabel);
        questions.add(amountPaidInputLabel);

        answers.setLayout(new GridLayout(2,1));
        answers.add(priceInput);
        answers.add(amountPaidInput);

        checkboxes.setLayout(new GridLayout(5,2));
        checkboxes.add(fiveHundred);
        checkboxes.add(twoHundred);
        checkboxes.add(oneHundred);
        checkboxes.add(fifty);
        checkboxes.add(twenty);
        checkboxes.add(ten);
        checkboxes.add(five);
        checkboxes.add(two);
        checkboxes.add(one);

        amountBack.setLayout(new GridLayout(5,2));
        amountBack.add(amountBackOutput);

        priceInput.addActionListener(this);
        amountPaidInput.addActionListener(this);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == priceInput || e.getSource() == amountPaidInput) {
            int pris = Integer.parseInt(priceInput.getText());
            int betalat = Integer.parseInt(amountPaidInput.getText());
            int tillbaka = betalat - pris;

            if(fiveHundred.isSelected()) {

            }
        }
    }

    public static void main(String[] args) {
        Övn3 start3 = new Övn3();
    }


}
