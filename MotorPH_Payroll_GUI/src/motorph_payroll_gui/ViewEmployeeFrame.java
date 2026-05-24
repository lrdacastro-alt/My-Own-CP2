package motorph_payroll_gui;

import javax.swing.*;
import java.awt.*;

public class ViewEmployeeFrame extends JFrame {

    public ViewEmployeeFrame() {
        setTitle("View Employee");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 350);
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
        JLabel titleLabel = new JLabel("View Employee", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        gbc.gridy = 0;
        mainPanel.add(titleLabel, gbc);

        // Employee # field
        JPanel searchPanel = new JPanel(new BorderLayout(8, 0));
        searchPanel.add(new JLabel("Employee #:"), BorderLayout.WEST);
        JTextField empNumField = new JTextField();
        searchPanel.add(empNumField, BorderLayout.CENTER);
        JButton searchBtn = new JButton("Search");
        searchPanel.add(searchBtn, BorderLayout.EAST);
        gbc.gridy = 1;
        mainPanel.add(searchPanel, gbc);

        // Result area
        JTextArea resultArea = new JTextArea(8, 20);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        resultArea.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        gbc.gridy = 2;
        mainPanel.add(scrollPane, gbc);

        getRootPane().setDefaultButton(searchBtn);

        // Search action
        searchBtn.addActionListener(e -> {
            String empNum = empNumField.getText().trim();
            if (empNum.isEmpty()) {
                resultArea.setText("Please enter an Employee #.");
                return;
            }
            Employee emp = EmployeePortal.findEmployee(empNum);
            if (emp == null) {
                resultArea.setText("Employee #" + empNum + " not found.");
            } else {
                resultArea.setText(emp.getProfileSummary() + "\n" + emp.getSalaryDetails());
            }
        });

        add(mainPanel);
    }
}