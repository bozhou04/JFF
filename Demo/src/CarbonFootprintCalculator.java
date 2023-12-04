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
        setTitle("碳足迹计算器");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("交通方式（公里）:"));
        txtTransport = new JTextField();
        add(txtTransport);

        add(new JLabel("电力消耗（千瓦时）:"));
        txtElectricity = new JTextField();
        add(txtElectricity);

        add(new JLabel("食物消费（千克）:"));
        txtFood = new JTextField();
        add(txtFood);

        JButton btnCalculate = new JButton("计算碳足迹");
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateFootprint();
            }
        });
        add(btnCalculate);

        lblResult = new JLabel("结果将显示在这里");
        add(lblResult);

        JButton btnShowAdvice = new JButton("显示建议");
        btnShowAdvice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdviceBasedOnFootprint(lastCalculatedFootprint);
            }
        });
        add(btnShowAdvice);

        JButton btnOpenGoogleScholar = new JButton("搜索谷歌学术");
        btnOpenGoogleScholar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGoogleScholar();
            }
        });
        add(btnOpenGoogleScholar);

        JButton btnExit = new JButton("退出");
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
            lblResult.setText("您的碳足迹是: " + lastCalculatedFootprint + " 千克CO2");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "请输入有效的数字。");
        }
    }

    private void showAdviceBasedOnFootprint(double footprint) {
        if (footprint <= 1000) {
            JOptionPane.showMessageDialog(this, "您的碳足迹较低，继续保持并尝试进一步减少碳排放。与家人、朋友分享您的环保习惯，参与环保活动。");
        } else if (footprint <= 3000) {
            JOptionPane.showMessageDialog(this, "您的碳足迹处于中等水平。建议减少私家车使用，注意节能减排，减少肉类消费。");
        } else {
            JOptionPane.showMessageDialog(this, "您的碳足迹较高。考虑改变出行方式，提高家庭能效，参与碳抵消项目，并在社区中推广环保意识。");
        }
    }

    private void openGoogleScholar() {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI("https://scholar.google.com"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "无法打开浏览器");
        }
    }
}
