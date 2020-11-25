package Pack.View;

import javax.swing.*;

public class MessageDialog {

    public static void wrongDateMessage(){
        JOptionPane optionPane = new JOptionPane();
        JOptionPane.showMessageDialog(optionPane,
                "<html><h2>Введена неверная дата!</h2><i>\n");
    }

    public static void winMessage(){
        JOptionPane optionPane = new JOptionPane();
        JOptionPane.showMessageDialog(optionPane,
                "<html><h2>Ты победил!</h2><i>\n");
    }

    public static void loseMessage(){
        JOptionPane optionPane = new JOptionPane();
        JOptionPane.showMessageDialog(optionPane,
                "<html><h2>Ты проиграл.</h2><i>\n");
    }
}
