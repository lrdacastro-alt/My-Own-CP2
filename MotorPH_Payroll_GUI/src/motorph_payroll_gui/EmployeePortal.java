package motorph_payroll_gui;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeePortal {

    //Load Employee Menu
    public static void show(Scanner scanner) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n===== EMPLOYEE MENU =====");
            System.out.println("[1] View Employee");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewEmployee(scanner);
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void viewEmployee(Scanner scanner) {
        System.out.print("\nEnter Employee #: ");
        String empNum = scanner.next();

        Employee emp = findEmployee(empNum);

        if (emp == null) {
            System.out.println("Employee #" + empNum + " not found.");
            return;
        }

        System.out.println("\n--- EMPLOYEE DETAILS ---");
        System.out.println(emp.getProfileSummary());
        System.out.println(emp.getSalaryDetails());
    }

    public static Employee findEmployee(String empNum) {
        String csvFile = "MotorPH_Payroll_GUI\\MotorPH_Employee Data - Employee Details.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = parseCSVLine(line);
                if (data[0].trim().equals(empNum.trim())) {
                    return new Employee(
                            data[0].trim(),  // employeeID
                            data[2].trim(),  // firstName
                            data[1].trim(),  // lastName
                            Double.parseDouble(data[18].trim().replace(",", "")),  // hourlyRate
                            data[3].trim()   // birthday
                    );
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
        return null;
    }

    private static String[] parseCSVLine(String line) {
        java.util.List<String> fields = new java.util.ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;

        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                fields.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        fields.add(sb.toString());
        return fields.toArray(new String[0]);
    }
}