/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package milestonecalculator;

/**
 *
 * @author amatibag
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MilestoneCalculator {

    private JFrame frame;
    private JTextField textFieldM1;
    private JTextField textFieldM2;
    private JTextField textFieldTA;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MilestoneCalculator window = new MilestoneCalculator();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MilestoneCalculator() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblMilestone1 = new JLabel("Milestone 1 (0-25):");
        lblMilestone1.setBounds(50, 50, 150, 25);
        frame.getContentPane().add(lblMilestone1);

        textFieldM1 = new JTextField();
        textFieldM1.setBounds(200, 50, 150, 25);
        frame.getContentPane().add(textFieldM1);
        textFieldM1.setColumns(10);

        JLabel lblMilestone2 = new JLabel("Milestone 2 (0-40):");
        lblMilestone2.setBounds(50, 100, 150, 25);
        frame.getContentPane().add(lblMilestone2);

        textFieldM2 = new JTextField();
        textFieldM2.setBounds(200, 100, 150, 25);
        frame.getContentPane().add(textFieldM2);
        textFieldM2.setColumns(10);

        JLabel lblTerminalAssessment = new JLabel("Terminal Assessment (0-35):");
        lblTerminalAssessment.setBounds(50, 150, 200, 25);
        frame.getContentPane().add(lblTerminalAssessment);

        textFieldTA = new JTextField();
        textFieldTA.setBounds(250, 150, 100, 25);
        frame.getContentPane().add(textFieldTA);
        textFieldTA.setColumns(10);

        JButton btnCalculate = new JButton("Calculate Grade");
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });
        btnCalculate.setBounds(150, 200, 150, 25);
        frame.getContentPane().add(btnCalculate);
    }

    private Integer validateInput(String input, int maxValue) {
        try {
            int value = Integer.parseInt(input);
            if (value >= 0 && value <= maxValue) {
                return value;
            } else {
                showError("Value must be between 0 and " + maxValue + ".");
            }
        } catch (NumberFormatException e) {
            showError("Invalid input. Please enter a number.");
        }
        return null;
    }

    private void calculateGrade() {
        Integer m1 = validateInput(textFieldM1.getText(), 25);
        Integer m2 = validateInput(textFieldM2.getText(), 40);
        Integer ta = validateInput(textFieldTA.getText(), 35);

        if (m1 != null && m2 != null && ta != null) {
            int totalGrade = m1 + m2 + ta;
            JOptionPane.showMessageDialog(frame, "Your total grade is: " + totalGrade);
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Input Error", JOptionPane.ERROR_MESSAGE);
    }
}