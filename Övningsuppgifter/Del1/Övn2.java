package Övningsuppgifter.Del1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Övn2 extends JFrame implements ActionListener {

    JLabel milesNowLabel = new JLabel("Nuvarande mätarställning");
    JLabel milesLastYearLabel = new JLabel("Mätarställning för ett år sedan");
    JLabel litresLabel = new JLabel("Antal liter bensin förbrukade");

    JTextField milesNow = new JTextField(30);
    JTextField milesLastYear = new JTextField(30);
    JTextField litres = new JTextField(30);

    JLabel milesTravelled = new JLabel(" ");
    JLabel litresGasLabel = new JLabel(" ");
    JLabel milesPerLitre = new JLabel(" ");

    JPanel questions = new JPanel();
    JPanel answers = new JPanel();
    JPanel finalVerdict = new JPanel();

    Övn2() {

        setLayout(new BorderLayout());
        add(questions, BorderLayout.WEST);
        add(answers, BorderLayout.EAST);
        add(finalVerdict, BorderLayout.SOUTH);

        questions.setLayout(new GridLayout(3,1));
        questions.add(milesNowLabel);
        questions.add(milesLastYearLabel);
        questions.add(litresLabel);

        answers.setLayout(new GridLayout(3,1));
        answers.add(milesNow);
        answers.add(milesLastYear);
        answers.add(litres);

        finalVerdict.setLayout(new GridLayout(1,3));
        finalVerdict.add(milesTravelled);
        finalVerdict.add(litresGasLabel);
        finalVerdict.add(milesPerLitre);

        milesNow.addActionListener(this);
        milesLastYear.addActionListener(this);
        litres.addActionListener(this);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    protected static double litresGasPerMile (double l, double km) {
        return l/km;
    }
    protected static double drivenMiles (double mileageNow, double oldMileage) {
        return mileageNow - oldMileage;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==milesNow || e.getSource()==milesLastYear || e.getSource()==litres) {

            Scanner scMilesNow = new Scanner(milesNow.getText());
            Scanner scMilesLastYear = new Scanner(milesLastYear.getText());
            Scanner scLitres = new Scanner(litres.getText());

            if (scMilesNow.hasNextDouble() && scMilesLastYear.hasNextDouble() && scLitres.hasNextDouble()) {
                double inputMilesNow = scMilesNow.nextDouble();
                double inputMilesLastYear = scMilesLastYear.nextDouble();
                double inputLitres = scLitres.nextDouble();

                double drivenDistance = drivenMiles(inputMilesNow, inputMilesLastYear);
                milesTravelled.setText(String.format("Antal körda mil: %8.0f \n", drivenDistance));
                litresGasLabel.setText(String.format("Antal liter bensin: %7.1f \n", inputLitres));
                milesPerLitre.setText(String.format("Förbrukning per mil: %1.2f \n", litresGasPerMile(inputLitres, drivenDistance)));
            }
        }

   }

    public static void main(String[] args) {
        Övn2 start = new Övn2();
    }


}
