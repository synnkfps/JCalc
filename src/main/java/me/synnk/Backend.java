package me.synnk;


import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import static me.synnk.Main.result;

public class Backend {
    public static String backend = "";
    public static String operation = "";
    public static String secondaryBackend;
    public static Boolean needEval = false;
    public static Boolean waiting = false;
    public static void updateDisplay(String text) {

        // Waiting == false | means that the user still did not press any operation
        if (!waiting) {
            result.setText(result.getText() + text);
            if (result.getText().length() > 1 && result.getText().startsWith("0")) {
                result.setText(result.getText().substring(1));
            }
            backend = result.getText();
        }

        // Waiting == false | means that the user pressed any operation
        if (waiting) {
            result.setText(result.getText() + text);
            if (result.getText().length() > 1 && result.getText().startsWith("0")) {
                result.setText(result.getText().substring(1));
            }
            secondaryBackend = result.getText();
        }
    }

    public static void addToBackend() {
        backend = result.getText();
        result.setText("0");
        waiting = true;
    }

    public static void calculate() {
        // TODO: If user still did not press equals, means that they still want to calculate
        if (needEval) {
            Expression eval = new ExpressionBuilder(result.getText()).build();
            String eval_result = String.valueOf(eval.evaluate());
            if (eval_result.endsWith(".0")){
                eval_result = eval_result.replace(".0", "");
            }
            result.setText(eval_result);
        } else {
            switch (operation) {
                case "+":
                    if (String.valueOf(Float.parseFloat(backend) + Float.parseFloat(secondaryBackend)).endsWith(".0")) {
                        result.setText(String.valueOf(Integer.parseInt(backend) + Integer.parseInt(secondaryBackend)));
                    } else {
                        result.setText(String.valueOf(Float.parseFloat(backend) + Float.parseFloat(secondaryBackend)));
                    }
                    break;
                case "-":
                    if (String.valueOf(Float.parseFloat(backend) - Float.parseFloat(secondaryBackend)).endsWith(".0")) {
                        result.setText(String.valueOf(Integer.parseInt(backend) - Integer.parseInt(secondaryBackend)));
                    } else {
                        result.setText(String.valueOf(Float.parseFloat(backend) - Float.parseFloat(secondaryBackend)));
                    }
                    break;
                case "*":
                    if (String.valueOf(Float.parseFloat(backend) * Float.parseFloat(secondaryBackend)).endsWith(".0")) {
                        result.setText(String.valueOf(Integer.parseInt(backend) * Integer.parseInt(secondaryBackend)));
                    } else {
                        result.setText(String.valueOf(Float.parseFloat(backend) * Float.parseFloat(secondaryBackend)));
                    }
                    break;
                case "/":
                    if (String.valueOf(Float.parseFloat(backend) / Float.parseFloat(secondaryBackend)).endsWith(".0")) {
                        result.setText(String.valueOf(Integer.parseInt(backend) / Integer.parseInt(secondaryBackend)));
                    } else {
                        result.setText(String.valueOf(Float.parseFloat(backend) / Float.parseFloat(secondaryBackend)));
                    }
                    break;
                case "%":
                    if (String.valueOf((Float.parseFloat(backend) / 100F) * Float.parseFloat(secondaryBackend)).endsWith(".0")) {
                        result.setText(String.valueOf((Float.parseFloat(backend) / 100F) * Integer.parseInt(secondaryBackend)));
                    } else {
                        result.setText(String.valueOf((Float.parseFloat(backend) / 100F) * Float.parseFloat(secondaryBackend)));
                    }
                    break;
            }
        }
    }
}
