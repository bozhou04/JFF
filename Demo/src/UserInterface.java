import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;

public class UserInterface extends JFrame {
    private JTextField searchField;
    private JButton searchButton, openCalculatorButton, openUrlButton;
    private JTextArea resultArea;

    public UserInterface() {
        setTitle("User Interface");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Search URLs:");
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        openCalculatorButton = new JButton("Open Carbon Footprint Calculator");
        openUrlButton = new JButton("Open URL");
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = searchField.getText();
                searchUrls(keyword);
            }
        });

        openCalculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCarbonFootprintCalculator();
            }
        });

        openUrlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSelectedUrl();
            }
        });

        add(label);
        add(searchField);
        add(searchButton);
        add(openCalculatorButton);
        add(openUrlButton);
        add(new JScrollPane(resultArea));

        setVisible(true);
    }

    private void searchUrls(String keyword) {
        resultArea.setText("");
        try (BufferedReader reader = new BufferedReader(new FileReader("urls.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) {
                    resultArea.append(line + "\n");
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error searching URLs.");
        }
    }

    private void openCarbonFootprintCalculator() {
        new CarbonFootprintCalculator();
    }

    private void openSelectedUrl() {
        String selectedUrl = resultArea.getSelectedText();
        if (selectedUrl != null && !selectedUrl.isEmpty()) {
            try {
                Desktop.getDesktop().browse(new URI(selectedUrl));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error opening URL.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UserInterface();
            }
        });
    }
}
