import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import AdminInterface;
//import UserInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public LoginFrame() {
        setTitle("用户登录");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("用户名:"));
        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel("密码:"));
        txtPassword = new JPasswordField();
        add(txtPassword);

        JButton btnLogin = new JButton("登录");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
        add(btnLogin);

        setVisible(true);
    }

    
    private void performLogin() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if ((username.equals("user") && password.equals("password"))) {
            new UserInterface(); // Open User Interface
            this.dispose(); // Close Login Window
        } else if (username.equals("admin") && password.equals("password")) {
            new AdminInterface(); // Open Admin Interface
            this.dispose(); // Close Login Window
        } else {
            JOptionPane.showMessageDialog(this, "用户名或密码错误。");
        }
    }
}
     
