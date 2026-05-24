package motorph_payroll_gui;

import javax.swing.*;
import java.awt.*;

public class EmployeeMenuFrame extends JFrame {

    public EmployeeMenuFrame() {
        setTitle("Employee Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(true);

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

        // main window panel define padding
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(6, 0, 6, 0);
        gbc.gridx = 0;

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