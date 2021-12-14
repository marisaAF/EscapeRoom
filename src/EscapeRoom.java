import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscapeRoom {
    static double userInput;
    static JPanel panel;
    static JLabel showResults;
    static JButton tryAgain, clock, vendingMachine, table, waterFountain;
    static JTextField answerInput;
    Color panelBackground = new Color(16, 5, 14);
    Color buttonForeground = new Color(21, 19, 15);
    Color buttonBackground = new Color(220, 5, 96);

    public static void main(String[] args) {
        new EscapeRoom();
    }

    public EscapeRoom() {
        JFrame frame = new JFrame("Escape From the Asylum");
        frame.setSize(400, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        showResults = new JLabel("PLACEHOLDER TEXT");
        tryAgain = new JButton("Start Over");
        clock = new JButton("Clock");
        vendingMachine = new JButton("Vending Machine");
        table = new JButton("Table");
        waterFountain = new JButton("Water Fountain");
        panel = new JPanel();
        panel.setBackground(panelBackground);
        tryAgain.setForeground(buttonForeground);
        tryAgain.setBackground(buttonBackground);
        clock.setForeground(buttonForeground);
        clock.setBackground(buttonBackground);
        vendingMachine.setForeground(buttonForeground);
        vendingMachine.setBackground(buttonBackground);
        table.setForeground(buttonForeground);
        table.setBackground(buttonBackground);
        waterFountain.setForeground(buttonForeground);
        waterFountain.setBackground(buttonBackground);
        answerInput = new JTextField(10);


        clock.setBounds(70, 10, 250, 100);
        vendingMachine.setBounds(70, 120, 250, 100);
        table.setBounds(70, 230, 250, 100);
        waterFountain.setBounds(70, 340, 250, 100);
        tryAgain.setBounds(120, 480, 150, 25);
        answerInput.setBounds(75, 190, 150, 25);

        tryAgain.addActionListener(new CreateWayListener());

        //panel.add(tryAgain);
        panel.add(showResults);
        panel.add(clock);
        panel.add(vendingMachine);
        panel.add(table);
        panel.add(waterFountain);

        frame.add(panel);
        panel.setLayout(null);
        frame.setVisible(true);
    }

    public static void getUserInput() {
        userInput = Double.parseDouble(answerInput.getText());
    }

    private static class CreateWayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (clock.isSelected()) {
                clockWay();
            }
            if (vendingMachine.isSelected()) {
                vendingWay();
            }
            if (table.isSelected()) {
                tableWay();
            }
            if (waterFountain.isSelected()) {
                waterWay();
            }
            System.exit(0);
        }
    }

    //ClockMethod
    public static void clockWay() {
        panel.remove(vendingMachine);
        panel.remove(waterFountain);
        panel.remove(table);
        JOptionPane.showMessageDialog(null, " Using a decimal display the time!");
        if (userInput <= 8.30) {
            showResults.setText("You made it in time!");
        } else {
            showResults.setText("Too late. Try again tomorrow.");
            panel.add(tryAgain);
        }
        panel.updateUI();
    }

    //VendingMachineMethod
    public static void vendingWay() {
        panel.remove(clock);
        panel.remove(waterFountain);
        panel.remove(table);
        JOptionPane.showMessageDialog(null, " If there are four sheep, two dogs and one herds-men, how many feet are there? (decimal form)");
        if (userInput == 2.0) {
            showResults.setText("Correct, Claim your handcuff key");
        } else {
            showResults.setText(" Incorrect, you are still handcuffed.");
            panel.add(vendingMachine);
        }
        panel.updateUI();
    }

    //TableMethod
    public static void tableWay() {
        panel.remove(vendingMachine);
        panel.remove(waterFountain);
        panel.remove(clock);
        JOptionPane.showMessageDialog(null, " 7 people meet at a party. if each person shakes hands with evey other person, once, how many handshakes will there be? (decimal form)");
        if (userInput == 21.0) {
            showResults.setText("Good job you have found the key card!!");
        } else {
            showResults.setText(" You were wrong, Try again");
            panel.add(table);
        }
        panel.updateUI();
    }

    //WaterFountainMethod
    public static void waterWay() {
        panel.remove(vendingMachine);
        panel.remove(clock);
        panel.remove(table);
        JOptionPane.showMessageDialog(null, " What is the next number in the pattern-2,3,5,9,17? (decimal form)");
        if (userInput == 33.0) {
            showResults.setText("Great job, you have found your escape code!");
        } else {
            showResults.setText(" Wrong answer, hurry try again before the guard catches you.");
            panel.add(waterFountain);
        }
        panel.updateUI();
    }
}






