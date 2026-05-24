package motorph_payroll_gui;

import javax.swing.*;
import java.awt.*;

public class EmployeeMenuFrame extends JFrame {

    public EmployeeMenuFrame() {
        setTitle("Employee Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.gridx = 0;
        gbc.weightx = 1;

        // Title
        JLabel titleLabel = new JLabel("Employee Menu", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        gbc.gridy = 0;
        mainPanel.add(titleLabel, gbc);

        // View Employee Button
        JButton viewEmployeeBtn = new JButton("View Employee");
        gbc.gridy = 1;
        mainPanel.add(viewEmployeeBtn, gbc);

        // Logout Button
        JButton logoutBtn = new JButton("Logout");
        gbc.gridy = 2;
        mainPanel.add(logoutBtn, gbc);

        // Actions
        viewEmployeeBtn.addActionListener(e -> {
            new ViewEmployeeFrame().setVisible(true);
        });

        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginFrame().setVisible(true);
        });

        viewEmployeeBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    viewEmployeeBtn.doClick();
                }
            }
        });

        logoutBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    logoutBtn.doClick();
                }
            }
        });

        add(mainPanel);
    }
}