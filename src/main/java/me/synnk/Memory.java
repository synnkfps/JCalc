package me.synnk;

import javax.swing.*;
import me.synnk.Main;

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
            } else { }
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
                } else { }
            } catch (Exception e) {
            }
        }

    }
    // Reset System
    public static void resetMemory() {
        if (basicMemory.size() == 0) {
            msgBox("The memory is already empty.\n");
        }
        basicMemory.clear();
        // ms
        memory_save.removeAllItems();
        memory_save.addItem("MS");
        memory_save.addItem("MRT");

        if (memory_read.getModel().getSize() <= 1) {
            System.out.println("Nothing to remove in MR");
        } else {

            try {
                memory_read.removeAllItems();
            } catch (NullPointerException e) {

            }
            memory_read.updateUI();
            memory_read.addItem("MR");
            memory_read.setEnabled(false);
        }

        if (memory_add_display_value.getModel().getSize() <= 1) {
            System.out.println("Nothing to remove in M+");
        } else {

            try {
                memory_add_display_value.removeAllItems();
            } catch (NullPointerException e) {

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
