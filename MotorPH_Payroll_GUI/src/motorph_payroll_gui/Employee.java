/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorph_payroll_gui;

/**
 * @author Group 21
 */
public class Employee {


    private String employeeID;
    private String firstName;
    private String lastName;
    private double hourlyRate;
    private String birthday;

    public Employee(
                String employeeID,
                String firstName,
                String lastName,
                double hourlyRate,
                String birthday) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
        this.birthday = birthday;
    }

    public String getProfileSummary() {
        return "Employee ID : " + employeeID  + "\n" +
               "Name        : " + firstName + " " + lastName + "\n" +
               "Birthday    : " + birthday;
    }

    public String getSalaryDetails() {
        return "Hourly Rate: ₱" + String.format("%,.2f", hourlyRate);
    }

    public String getEmployeeID() { return employeeID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getHourlyRate() { return hourlyRate; }
}