package Pack.Controller;

import Pack.View.DatesFrame;

import javax.swing.*;

class Main {
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            new DatesFrame().setVisible(true);
        });
    }
}