import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminInterface extends JFrame {
    private JButton openCalculatorButton, manageUrlButton;

    public AdminInterface() {
        setTitle("Admin Interface");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        openCalculatorButton = new JButton("Open Carbon Footprint Calculator");
        manageUrlButton = new JButton("Manage URL");

        openCalculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCarbonFootprintCalculator();
            }
        });

        manageUrlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openUrlManagement();
            }
        });

        add(openCalculatorButton);
        add(manageUrlButton);

        setVisible(true);
    }

    private void openCarbonFootprintCalculator() {
        new CarbonFootprintCalculator();
    }

    private void openUrlManagement() {
        new AdminUrlManagement();
        this.dispose(); // Close the current admin interface
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdminInterface();
            }
        });
    }
}
