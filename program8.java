import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class program8 extends JFrame {
    
    private JTextField principalField, rateField, yearsField;
    private JLabel resultLabel;

    public Program8() {
        setTitle("Investment Calculator");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Create UI Components
        add(new JLabel(" Principal Amount ($):"));
        principalField = new JTextField();
        add(principalField);

        add(new JLabel(" Annual Interest Rate (%):"));
        rateField = new JTextField();
        add(rateField);

        add(new JLabel(" Number of Years:"));
        yearsField = new JTextField();
        add(yearsField);

        JButton calcButton = new JButton("Calculate");
        add(calcButton);

        resultLabel = new JLabel(" Total Value: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(resultLabel);

        // Action Listener for Button
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double p = Double.parseDouble(principalField.getText());
                    double r = Double.parseDouble(rateField.getText()) / 100;
                    int t = Integer.parseInt(yearsField.getText());

                    // Compound Interest Formula: A = P(1 + r)^t
                    double amount = p * Math.pow(1 + r, t);
                    
                    resultLabel.setText(String.format(" Total Value: $%.2f", amount));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Program8.this, "Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        // Run GUI on Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(() -> {
            program8 calculator = new program8();
            calculator.setVisible(true);
        });
    }
}
