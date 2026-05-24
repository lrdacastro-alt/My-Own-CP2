package motorph_payroll_gui;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("MotorPH Payroll System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500); // window size
        setLocationRelativeTo(null);
        setResizable(true); //can maximize

        // main window panel set color to gradient
        JPanel mainPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new GradientPaint(0, 0, new Color(180, 180, 255), getWidth(), getHeight(), new Color(255, 180, 180)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        int row = 0;

        // main window panel define padding
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(6, 0, 6, 0);

        // Logo
        ImageIcon logo = new ImageIcon("MotorPH_Payroll_GUI\\MotorPH_Home_Page.png");
        Image scaled = logo.getImage().getScaledInstance(320, 120, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaled));
        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.gridwidth = 2;
        mainPanel.add(logoLabel, gbc);

        // Title
        JLabel titleLabel = new JLabel("MotorPH Payroll System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);

        // Subtitle
        JLabel subtitleLabel = new JLabel("Project of CP2 Group 21 - S1101", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
        gbc.gridy = row++;
        mainPanel.add(subtitleLabel, gbc);

        // Panel for username/password
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 5, 8));
        formPanel.setOpaque(false);
        formPanel.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        formPanel.setPreferredSize(new Dimension(320, 70));
        formPanel.add(new JLabel("Username:"));
        usernameField = new JTextField(15);
        formPanel.add(usernameField);
        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        formPanel.add(passwordField);
        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.gridwidth = 2;
        mainPanel.add(formPanel, gbc);

        // Login Button
        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(16, 0, 0, 0);
        loginButton.setPreferredSize(new Dimension(120, 30));
        mainPanel.add(loginButton, gbc);

        // Error label
        JLabel errorLabel = new JLabel("", SwingConstants.CENTER);
        errorLabel.setForeground(Color.RED);
        gbc.gridy = row++;
        gbc.insets = new Insets(4, 0, 0, 0);
        mainPanel.add(errorLabel, gbc);

        getRootPane().setDefaultButton(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            UserPortal user = new UserPortal(username, password, "");

            if (user.authenticateUser()) {
                dispose();
                if (user.getRole().equals("Regular Employee")) {
                    new EmployeeMenuFrame().setVisible(true);
                }
                else if (user.getRole().equals("Payroll Staff")) {
                    new PayrollStaffMenuFrame().setVisible(true);
                }
            } else {
                errorLabel.setText("Invalid username or password.");
                passwordField.setText("");
            }
        });

        add(mainPanel);
    }
}