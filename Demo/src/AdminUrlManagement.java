import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.Desktop;
import java.net.URI;

public class AdminUrlManagement extends JFrame {
    private JTextField urlField;
    private JTextArea urlsArea;

    public AdminUrlManagement() {
        setTitle("Admin URL Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Enter URL:");
        urlField = new JTextField(20);
        urlsArea = new JTextArea(10, 30); // Initialize urlsArea
        urlsArea.setEditable(false);
        loadUrls();

        JButton uploadButton = new JButton("Upload");
        JButton deleteButton = new JButton("Delete URL");
        JButton openUrlButton = new JButton("Open URL"); // New button for opening URL
        JButton backButton = new JButton("Back");

        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = urlField.getText();
                saveUrl(url);
                loadUrls();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedUrl();
            }
        });

        openUrlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSelectedUrl();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBackToAdminInterface();
            }
        });

        add(label);
        add(urlField);
        add(uploadButton);
        add(deleteButton);
        add(openUrlButton); // Add the open URL button
        add(backButton);
        add(new JScrollPane(urlsArea));

        setVisible(true);
    }

    private void saveUrl(String url) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("urls.txt", true))) {
            writer.write(url);
            writer.newLine();
            writer.flush();
            urlField.setText("");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error uploading URL.");
        }
    }

    private void loadUrls() {
        urlsArea.setText("");
        try (BufferedReader reader = new BufferedReader(new FileReader("urls.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                urlsArea.append(line + "\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error loading URLs.");
        }
    }

    private void deleteSelectedUrl() {
        String selectedText = urlsArea.getSelectedText();
        if (selectedText != null && !selectedText.isEmpty()) {
            String content = urlsArea.getText();
            content = content.replace(selectedText, "");
            urlsArea.setText(content);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("urls.txt"))) {
                writer.write(content);
                writer.flush();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error deleting URL.");
            }
        }
    }

    private void openSelectedUrl() {
        String selectedUrl = urlsArea.getSelectedText();
        if (selectedUrl != null && !selectedUrl.isEmpty()) {
            try {
                Desktop.getDesktop().browse(new URI(selectedUrl));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error opening URL.");
            }
        }
    }

    private void goBackToAdminInterface() {
        new AdminInterface();
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdminUrlManagement();
            }
        });
    }
}
