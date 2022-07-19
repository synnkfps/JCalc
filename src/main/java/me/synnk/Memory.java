package me.synnk;

import javax.swing.*;
import java.util.ArrayList;

public class Memory {
    static JTextField result = Main.result;
    static ArrayList<String> basicMemory = Main.basicMemory;
    static JComboBox<String> memory_read = Main.memory_read;
    static JComboBox<String> memory_save = Main.memory_save;
    static JComboBox<String> memory_add_display_value = Main.memory_add_display_value;
    
    // Copy Display System
    public static void copyDisplayToMemory() {
        if (basicMemory.size() == 0) {
            msgBox("The memory needs to have at least 1 value in it.\n");
        }
    }

    // Write Memory System
    public static void writeMemory(String input) {
        if (memory_read.isEnabled() && memory_add_display_value.isEnabled()) {
            System.out.print("Already enabled\n");
        } else {
            if (!result.getText().equals("0")) {
                memory_read.setEnabled(true);
                memory_add_display_value.setEnabled(true);
            }
        }

        if (basicMemory.contains(input)) {
            System.out.printf("%s is already in memory.\n", input);
        } else {
            try {
                if (!result.getText().equals("0")) {
                    basicMemory.add(input);

                    System.out.printf("Added %s to memory.\n", input);
                    memory_save.addItem(input);
                    memory_read.addItem(input);
                    memory_add_display_value.addItem(input);
                }
            } catch (Exception ignored) { }
        }

    }
    // Reset System
    public static void resetMemory() {
        if (basicMemory.size() == 0) {
            System.out.println("The memory is already empty.\n");
        }
        basicMemory.clear();
        // ms
        if (memory_save.getModel().getSize() <= 2) {
            System.out.println("Nothing to remove in MR");
        } else {

            try {
                memory_save.removeAllItems();
            } catch (NullPointerException ignored) {

            }
            memory_save.updateUI();
            memory_save.addItem("MS");
            memory_save.addItem("MRT");
        }

        // mr
        if (memory_read.getModel().getSize() <= 1) {
            System.out.println("Nothing to remove in MR");
        } else {

            try {
                memory_read.removeAllItems();
            } catch (NullPointerException ignored) {

            }
            memory_read.updateUI();
            memory_read.addItem("MR");
            memory_read.setEnabled(false);
        }

        // m+
        if (memory_add_display_value.getModel().getSize() <= 1) {
            System.out.println("Nothing to remove in M+");
        } else {

            try {
                memory_add_display_value.removeAllItems();
            } catch (NullPointerException ignored) {

            }
            memory_add_display_value.updateUI();
            memory_add_display_value.addItem("M+");
            memory_add_display_value.setEnabled(false);
        }

        // log
        System.out.print("Memory got reset.\n");

    }
    public static void msgBox(String text) {
        JOptionPane.showMessageDialog(null, text);
    }
    
}
