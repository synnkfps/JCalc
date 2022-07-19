package me.synnk;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class Main extends JFrame {
    private JPanel mainPanel;
    public static JTextField result;
    public static ArrayList<String> basicMemory = new ArrayList<>();

    // Memory
    public static JComboBox<String> memory_save = new JComboBox<>();
    public static JComboBox<String> memory_read = new JComboBox<>();
    public static JComboBox<String> memory_add_display_value = new JComboBox<>();

    private void initComponents() {
        mainPanel = new JPanel();
        result = new JTextField();

        // Display Actions
        JButton cButton = new JButton();
        JButton ACButton = new JButton();
        JButton backspace = new JButton();

        // Parenthesis
        JButton close_parenthesis = new JButton();
        JButton open_parenthesis = new JButton();

        // Numbers
        JButton button0 = new JButton();
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        JButton button4 = new JButton();
        JButton button5 = new JButton();
        JButton button6 = new JButton();
        JButton button7 = new JButton();
        JButton button8 = new JButton();
        JButton button9 = new JButton();

        // Action Buttons
        JButton add = new JButton();
        JButton subtract = new JButton();
        JButton multiply = new JButton();
        JButton divide = new JButton();
        JButton equals = new JButton();

        // Special Action Buttons
        JButton sqrtButton = new JButton();
        JButton percent = new JButton();
        JButton change_sign = new JButton();
        JButton decimal_point = new JButton();

        // Spacers
        JPanel vSpacer1 = new JPanel(null);
        JPanel vSpacer2 = new JPanel(null);
        JPanel vSpacer3 = new JPanel(null);
        JPanel vSpacer4 = new JPanel(null);
        JPanel vSpacer5 = new JPanel(null);
        JPanel vSpacer6 = new JPanel(null);

        {
            mainPanel.setBorder(new EmptyBorder(new Insets(3, 3, 5, 3)));
            mainPanel.setLayout(new GridBagLayout());
            mainPanel.add(vSpacer1, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

            // Result
            result.setHorizontalAlignment(JTextField.RIGHT);
            result.setFont(new Font("Arial Black", Font.BOLD, 28));
            result.setText("0");
            mainPanel.add(result, new GridBagConstraints(1, 0, 5, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 200, 40));

            // Clear Display
            cButton.setText("C");
            mainPanel.add(cButton, new GridBagConstraints(3, 2, 1, 1, -2.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            cButton.addActionListener(e -> {
                result.setText("0");
                if (Backend.operation != "") {
                    Backend.secondaryBackend = "";
                } else if (Backend.operation == "") {
                    Backend.secondaryBackend = "";
                    Backend.backend = "";

                }
            });

            // Clear All
            ACButton.setText("AC");
            ACButton.addActionListener(e -> {
                Memory.resetMemory();
                result.setText("0");
                Backend.backend = "";
                Backend.secondaryBackend = "";
            });
            mainPanel.add(ACButton, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Backspace
            backspace.setText("<-");
            mainPanel.add(backspace, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
            mainPanel.add(vSpacer2, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

            backspace.addActionListener(e -> {
                String r = result.getText();
                result.setText(r.replaceAll(".$", ""));
                if (result.getText().length() == 0 && !result.getText().startsWith("0")) {
                    result.setText("0");
                }
            });

            // Open Parenthesis
            open_parenthesis.setEnabled(false); // TODO
            open_parenthesis.setText("(");
            mainPanel.add(open_parenthesis, new GridBagConstraints(1, 4, 1, 1, -1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Close Parenthesis
            close_parenthesis.setText(")");
            close_parenthesis.setEnabled(false); // TODO
            mainPanel.add(close_parenthesis, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            //---- sqrtButton ----
            sqrtButton.setText("sqrt");
            sqrtButton.addActionListener(e -> {
                int parsed_result = Integer.parseInt(result.getText());

                result.setText(String.valueOf(Math.pow(parsed_result, 0.5d)));
            });
            mainPanel.add(sqrtButton, new GridBagConstraints(5, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // 1
            button1.setText("1");
            button1.addActionListener(e -> {
                Backend.updateDisplay(1);
            });
            mainPanel.add(button1, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));


            // 2
            button2.setText("2");
            button2.addActionListener(e -> {
                Backend.updateDisplay(2);
            });
            mainPanel.add(button2, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));


            // 3
            button3.setText("3");
            button3.addActionListener(e -> {
                Backend.updateDisplay(3);
            });
            mainPanel.add(button3, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));


            // 4
            button4.setText("4");
            button4.addActionListener(e -> {
                Backend.updateDisplay(4);
            });
            mainPanel.add(button4, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // 5
            button5.setText("5");
            button5.addActionListener(e -> {
                Backend.updateDisplay(5);
            });
            mainPanel.add(button5, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // 6
            button6.setText("6");
            button6.addActionListener(e -> {
                Backend.updateDisplay(6);
            });
            mainPanel.add(button6, new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));


            // 7
            button7.setText("7");
            button7.addActionListener(e -> {
                Backend.updateDisplay(7);
            });
            mainPanel.add(button7, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // 8
            button8.setText("8");
            button8.addActionListener(e -> {
                Backend.updateDisplay(8);
            });
            mainPanel.add(button8, new GridBagConstraints(2, 10, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // 9
            button9.setText("9");
            button9.addActionListener(e -> {
                Backend.updateDisplay(9);
            });
            mainPanel.add(button9, new GridBagConstraints(3, 10, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));


            // 0
            button0.setText("0");
            button0.addActionListener(e -> {
                Backend.updateDisplay(0);
            });
            mainPanel.add(button0, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Plus / Add
            add.setText("+");
            add.addActionListener(e -> {
                Backend.addToBackend();
                Backend.operation = "+";
            });
            mainPanel.add(add, new GridBagConstraints(4, 12, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Subtract
            subtract.setText("-");
            subtract.addActionListener(e -> {
                Backend.addToBackend();
                Backend.operation = "-";
            });
            mainPanel.add(subtract, new GridBagConstraints(4, 10, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Multiply
            multiply.setText("*");
            multiply.addActionListener(e -> {
                Backend.addToBackend();
                Backend.operation = "*";
            });
            mainPanel.add(multiply, new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Divide
            divide.setText("/");
            divide.addActionListener(e -> {
                Backend.addToBackend();
                Backend.operation = "/";
            });
            mainPanel.add(divide, new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Change Sign
            change_sign.setText("+/-");
            change_sign.addActionListener(e -> {
                int parsed_result = Integer.parseInt(result.getText());
                int math = parsed_result-(parsed_result * 2);

                result.setText(String.valueOf(math));
            });
            mainPanel.add(change_sign, new GridBagConstraints(3, 12, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Percent
            percent.setText("%");
            percent.addActionListener(e -> {
                Backend.addToBackend();
                Backend.operation = "%";
            });
            mainPanel.add(percent, new GridBagConstraints(5, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Dot
            decimal_point.setText(",");
            decimal_point.setEnabled(false); // TODO
            mainPanel.add(decimal_point, new GridBagConstraints(2, 12, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Memory Save
            memory_save.setModel(new DefaultComboBoxModel<>(new String[]{
                    "MS",
                    "MRT"
            }));

            memory_save.addActionListener(e -> { // Simple Lambda
                String selected = (String) memory_save.getSelectedItem();
                switch (selected) {
                    case "MS":
                            Memory.writeMemory(result.getText());
                        break;
                    case "MRT":
                            Memory.resetMemory();
                        break;
                    default:
                        // TODO: Replace current selected item with result.getText().

                        break;
                }
            });

            // memory_save.setEnabled(false); // TODO
            mainPanel.add(memory_save, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Read from Memory
            memory_read.setModel(new DefaultComboBoxModel<>(new String[]{
                    "MR"
            }));

            memory_read.addActionListener(e -> { // Simple Lambda
                String selected = (String) memory_read.getSelectedItem();
                switch (selected) {
                    case "MR":
                        break;
                    default:
                        Backend.secondaryBackend = memory_read.getSelectedItem().toString();
                        result.setText(Backend.secondaryBackend);
                        break;
                }
            });
            memory_read.setEnabled(false);
            mainPanel.add(memory_read, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Memory Add Display Value
            memory_add_display_value.setModel(new DefaultComboBoxModel<>(new String[]{
                    "M+"
            }));
            memory_add_display_value.addActionListener(e -> {
                String selected = (String) memory_read.getSelectedItem();
                switch (selected) {
                    case "M+":
                        Memory.copyDisplayToMemory();
                    break;
                }
            });
            memory_add_display_value.setEnabled(false);
            mainPanel.add(memory_add_display_value, new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            mainPanel.add(vSpacer3, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
            mainPanel.add(vSpacer4, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
            mainPanel.add(vSpacer5, new GridBagConstraints(3, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
            mainPanel.add(vSpacer6, new GridBagConstraints(4, 11, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

            // Equals
            equals.setText("=");
            equals.addActionListener(e -> {
                Backend.calculate();
            });
            mainPanel.add(equals, new GridBagConstraints(5, 10, 1, 3, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 30));
        }
    }

    public Main() {
        initComponents();
        this.setContentPane(mainPanel);
        this.setResizable(false);
        this.pack();
        this.setTitle("JMath");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}