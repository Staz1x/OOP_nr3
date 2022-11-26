package FrånEclipse;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Program {

    public static void main(String[] args) {

        Model running = new Model(); //byt namn på "program"

        JFrame window = new JFrame();
        window.setTitle("Cache memory 2^n");
        window.setSize(new Dimension(600, 300));
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(600, 50));
        final JTextField inputNumber = new JTextField("0");
        inputNumber.setPreferredSize(new Dimension(100, 35));
        inputPanel.add(inputNumber, BorderLayout.CENTER);

        JPanel outputPanel = new JPanel();
        outputPanel.setPreferredSize(new Dimension(400, 150));
        final JLabel output = new JLabel("Result: ");
        output.setPreferredSize(new Dimension(300, 100));
        outputPanel.add(output, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(600, 50));
        JButton computeButton = new JButton("Compute 2^n");
        computeButton.setPreferredSize(new Dimension(120, 40));
        JButton clearButton = new JButton("Clear memory");
        clearButton.setPreferredSize(new Dimension(120, 40));
        JButton quitButton = new JButton("Quit");
        quitButton.setPreferredSize(new Dimension(120, 40));
        buttonPanel.add(computeButton, BorderLayout.WEST);
        buttonPanel.add(clearButton, BorderLayout.CENTER);
        buttonPanel.add(quitButton, BorderLayout.EAST);

        window.add(inputPanel, BorderLayout.NORTH);
        window.add(outputPanel, BorderLayout.CENTER);
        window.add(buttonPanel, BorderLayout.SOUTH);

        computeButton.addActionListener((new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                try {
                    output.setText("Result:    "+running.compute2Power(Integer.valueOf(inputNumber.getText())));
                }catch(IllegalArgumentException exc) {
                    output.setText("Input a positive number please!");
                }
            }
        }));

        clearButton.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                running.clearMemory();
                output.setText("Memory cleared");
            }
        }));

        quitButton.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                running.clearMemory();
                System.exit(0);
            }
        }));

        window.setVisible(true);

    }
}

