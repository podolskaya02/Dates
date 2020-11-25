package Pack.Model;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fields {

    public static JXDatePicker startField;  // Поле для исходной даты
    public static JXDatePicker dateField;  // Поле с датой для хода игрока
    public static JTextArea textArea;     // Поле для записи ходов
    public static JScrollPane scroll;
    public final static String newline = "\n";
    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public void getStartField() {
        startField = new JXDatePicker();
        startField.setDate(Calendar.getInstance().getTime());
        startField.setFormats(simpleDateFormat);
    }

    public void getDateField() {
        dateField = new JXDatePicker();
        dateField.setDate(Calendar.getInstance().getTime());
        dateField.setFormats(simpleDateFormat);
        dateField.setDate(null);
        dateField.setEditable(false);
    }

    public void getAreaText(){
        textArea = new JTextArea(20, 31);
        Font font2 = new Font("Serif", Font.PLAIN, 14);
        textArea.setFont(font2);
        textArea.setEditable(false);
        scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }

}