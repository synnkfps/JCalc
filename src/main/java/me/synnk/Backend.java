package me.synnk;

import static me.synnk.Main.result;

public class Backend {
    public static String backend = "";
    public static String operation = "";
    public static String secondaryBackend;
    public static Boolean waiting = false;
    public static void updateDisplay(Integer integer) {
        // Waiting == false | means that the user still did not press any operation
        if (!waiting) {
            result.setText(result.getText() + integer);
            if (result.getText().length() > 1 && result.getText().startsWith("0")) {
                result.setText(result.getText().substring(1));
            }

            updateBackend();
        }

        // Waiting == false | means that the user pressed any operation
        if (waiting) {
            result.setText(result.getText() + integer);
            if (result.getText().length() > 1 && result.getText().startsWith("0")) {
                result.setText(result.getText().substring(1));
            }
            secondaryBackend = result.getText();
        }
    }
    public static void updateBackend() {
        backend = result.getText();
    }
    public static void addToBackend() {
        backend = result.getText();
        result.setText("0");
        waiting = true;
    }

    public static void calculate() {
        // DEBUG: Memory.msgBox(String.format("Backend: %s\nS
        // ec. Backend: %s", backend, secondaryBackend));
        if (operation.equals("+")) {
            result.setText(String.valueOf(Integer.parseInt(backend) + Integer.parseInt(secondaryBackend)));
        }
        if (operation.equals("-")) {
            result.setText(String.valueOf(Integer.parseInt(backend) - Integer.parseInt(secondaryBackend)));
        }
        if (operation.equals("*")) {
            result.setText(String.valueOf(Integer.parseInt(backend) * Integer.parseInt(secondaryBackend)));
        }
        if (operation.equals("/")) {
            result.setText(String.valueOf(Integer.parseInt(backend) / Integer.parseInt(secondaryBackend)));
        }
    }
}
