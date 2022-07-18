import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Main extends JFrame {
    private JPanel mainPanel;
    private JTextField result;

    private JButton Button0;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JButton Button4;
    private JButton Button5;
    private JButton Button6;
    private JButton Button7;
    private JButton Button8;
    private JButton Button9;

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
        Button0 = new JButton();
        Button1 = new JButton();
        Button2 = new JButton();
        Button3 = new JButton();
        Button4 = new JButton();
        Button5 = new JButton();
        Button6 = new JButton();
        Button7 = new JButton();
        Button8 = new JButton();
        Button9 = new JButton();

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

        // Memory
        JComboBox<String> memory_save = new JComboBox<>();
        JComboBox<String> memory_read = new JComboBox<>();
        JComboBox<String> memory_add_display_value = new JComboBox<>();

        // Spacers
        JPanel vSpacer1 = new JPanel(null);
        JPanel vSpacer2 = new JPanel(null);
        JPanel vSpacer3 = new JPanel(null);
        JPanel vSpacer4 = new JPanel(null);
        JPanel vSpacer5 = new JPanel(null);
        JPanel vSpacer6 = new JPanel(null);

        {
            mainPanel.setBorder(new CompoundBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "Calculator", TitledBorder.CENTER, TitledBorder.TOP, new Font("D\u0069alog", Font.ITALIC, 12), Color.black), mainPanel.getBorder()));
            mainPanel.addPropertyChangeListener(e -> {if ("\u0062order".equals(e.getPropertyName())) throw new RuntimeException();});
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
            });

            // Clear Memory
            ACButton.setText("AC");
            ACButton.setEnabled(false); // TODO
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
            mainPanel.add(sqrtButton, new GridBagConstraints(5, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Divide
            divide.setText("/");
            mainPanel.add(divide, new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // 1
            Button1.setText("1");
            mainPanel.add(Button1, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            Button1.addActionListener(e -> {
                result.setText(result.getText() + Button1.getText());
                if (result.getText().length() > 1 && result.getText().startsWith("0")) {
                    result.setText(result.getText().substring(1));
                }
            });

            // 2
            Button2.setText("2");
            mainPanel.add(Button2, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            Button2.addActionListener(e -> {
                result.setText(result.getText() + Button2.getText());
                if (result.getText().length() > 1 && result.getText().startsWith("0")) {
                    result.setText(result.getText().substring(1));
                }
            });

            // 3
            Button3.setText("3");
            mainPanel.add(Button3, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            Button3.addActionListener(e -> {
                result.setText(result.getText() + Button3.getText());
                if (result.getText().length() > 1 && result.getText().startsWith("0")) {
                    result.setText(result.getText().substring(1));
                }
            });


            // 4
            Button4.setText("4");
            mainPanel.add(Button4, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            Button4.addActionListener(e -> {
                result.setText(result.getText() + Button4.getText());
                if (result.getText().length() > 1 && result.getText().startsWith("0")) {
                    result.setText(result.getText().substring(1));
                }
            });

            // 5
            Button5.setText("5");
            mainPanel.add(Button5, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            Button5.addActionListener(e -> {
                result.setText(result.getText() + Button5.getText());
                if (result.getText().length() > 1 && result.getText().startsWith("0")) {
                    result.setText(result.getText().substring(1));
                }
            });

            // 6
            Button6.setText("6");
            mainPanel.add(Button6, new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            Button6.addActionListener(e -> {
                result.setText(result.getText() + Button6.getText());
                if (result.getText().length() > 1 && result.getText().startsWith("0")) {
                    result.setText(result.getText().substring(1));
                }
            });

            // 7
            Button7.setText("7");
            mainPanel.add(Button7, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            Button7.addActionListener(e -> {
                result.setText(result.getText() + Button7.getText());
                if (result.getText().length() > 1 && result.getText().startsWith("0")) {
                    result.setText(result.getText().substring(1));
                }
            });

            // 8
            Button8.setText("8");
            mainPanel.add(Button8, new GridBagConstraints(2, 10, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            Button8.addActionListener(e -> {
                result.setText(result.getText() + Button8.getText());
                if (result.getText().length() > 1 && result.getText().startsWith("0")) {
                    result.setText(result.getText().substring(1));
                }
            });

            // 9
            Button9.setText("9");
            mainPanel.add(Button9, new GridBagConstraints(3, 10, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            Button9.addActionListener(e -> {
                result.setText(result.getText() + Button9.getText());
                if (result.getText().length() > 1 && result.getText().startsWith("0")) {
                    result.setText(result.getText().substring(1));
                }
            });

            // 0
            Button0.setText("0");
            mainPanel.add(Button0, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            Button0.addActionListener(e -> {
                result.setText(result.getText() + Button0.getText());
                if (result.getText().length() > 1 && result.getText().startsWith("0")) {
                    result.setText(result.getText().substring(1));
                }
            });

            // Plus / Add
            add.setText("+");
            mainPanel.add(add, new GridBagConstraints(4, 12, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));


            // Subtract
            subtract.setText("-");
            mainPanel.add(subtract, new GridBagConstraints(4, 10, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Change Sign
            change_sign.setText("+/-");
            change_sign.setEnabled(false); // TODO
            mainPanel.add(change_sign, new GridBagConstraints(3, 12, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Percent
            percent.setText("%");
            mainPanel.add(percent, new GridBagConstraints(5, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Multiply
            multiply.setText("*");
            mainPanel.add(multiply, new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Dot
            decimal_point.setText(",");
            decimal_point.setEnabled(false); // TODO
            mainPanel.add(decimal_point, new GridBagConstraints(2, 12, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Memory Save
            memory_save.setModel(new DefaultComboBoxModel<>(new String[]{
                    "MS"
            }));
            memory_save.setEnabled(false); // TODO
            mainPanel.add(memory_save, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Read from Memory
            memory_read.setModel(new DefaultComboBoxModel<>(new String[]{
                    "MR"
            }));
            memory_read.setEnabled(false); // TODO
            mainPanel.add(memory_read, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            // Memory Add Display Value
            memory_add_display_value.setModel(new DefaultComboBoxModel<>(new String[]{
                    "M+"
            }));
            memory_add_display_value.setEnabled(false); // TODO
            mainPanel.add(memory_add_display_value, new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            mainPanel.add(vSpacer3, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
            mainPanel.add(vSpacer4, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
            mainPanel.add(vSpacer5, new GridBagConstraints(3, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
            mainPanel.add(vSpacer6, new GridBagConstraints(4, 11, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

            // Equals
            equals.setText("=");
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