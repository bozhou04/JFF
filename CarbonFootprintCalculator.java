import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CarbonFootprintCalculator extends JFrame {
    private JTextField txtTransport, txtElectricity, txtFood;
    private JLabel lblResult;
    private double lastCalculatedFootprint = 0;

    public CarbonFootprintCalculator() {
        setTitle("Carbon Footprint Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("Transportation mode (kilometers):"));
        txtTransport = new JTextField();
        add(txtTransport);

        add(new JLabel("energy consumption (kilowatt-hours):"));
        txtElectricity = new JTextField();
        add(txtElectricity);

        add(new JLabel("food consumption (kilograms):"));
        txtFood = new JTextField();
        add(txtFood);

        JButton btnCalculate = new JButton("calculate carbon footprint");
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateFootprint();
            }
        });
        add(btnCalculate);

        lblResult = new JLabel("Results: ");
        add(lblResult);

        JButton btnShowAdvice = new JButton("Recommendations");
        btnShowAdvice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdviceBasedOnFootprint(lastCalculatedFootprint);
            }
        });
        add(btnShowAdvice);

        JButton btnOpenSDG13 = new JButton("Read more about SDG 13");
        btnOpenSDG13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSDG13();
            }
        });
        add(btnOpenSDG13);

        JButton btnExit = new JButton("Log out");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(btnExit);

        setVisible(true);
    }

    private void calculateFootprint() {
        try {
            double transport = Double.parseDouble(txtTransport.getText());
            double electricity = Double.parseDouble(txtElectricity.getText());
            double food = Double.parseDouble(txtFood.getText());

            lastCalculatedFootprint = transport * 0.21 + electricity * 0.5 + food * 0.13;
            lblResult.setText("Your carbon footprint is: " + lastCalculatedFootprint + " kilograms of CO2");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please insert a correct form of data.");
        }
    }

    private void showAdviceBasedOnFootprint(double footprint) {
        if (footprint <= 4000) {
            JOptionPane.showMessageDialog(this, "Your carbon footprint is considered below average, keep up the effort to further decrease your carbon footprint. Consider participating in more recycling activities and share your exeprience with your friends and family.");
        } else if (footprint <= 10000) {
            JOptionPane.showMessageDialog(this, "Your carbon footprint is considered average in the world. Consider joining carpool activity, use energy-efficient appliances and reduce the intake of meat products.");
        } else {
            JOptionPane.showMessageDialog(this, "Your carbon footprint is considered above average. Take into consideration to switch up your daily carbon usage. Switch off electric appliances and turn off water taps when not in used, consider the idea of taking public transportation and limit the intake of meat products.");
        }
    }

    private void openSDG13() {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI("https://sdgs.un.org/goals/goal13"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Unable to load.");
        }
    }
}
