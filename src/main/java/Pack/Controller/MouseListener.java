package Pack.Controller;

import Pack.Model.Fields;
import Pack.View.DatesFrame;
import Pack.View.MessageDialog;

import java.text.ParseException;

public class MouseListener {

    public static String startDate;
    public static String date;
    private Robot robot = new Robot();

    public MouseListener(){}
    // Обрабатываем события кнопки "старт"
    public void addStartButtonListener() {
        DatesFrame.startButton.addActionListener(e -> {
            startDate = Fields.simpleDateFormat.format(Fields.startField.getDate());
            if (!startDate.contains("31.12")) { // Начальная дата не может быть окончательной
                Fields.textArea.append("Исходная дата: " + startDate + Fields.newline);
                DatesFrame.startButton.setEnabled(false);
                Fields.startField.setEditable(false);
                Fields.dateField.setEditable(true);
                Fields.dateField.getMonthView().setLowerBound(Fields.startField.getDate()); // Закрываем все даты до начальной
                try {
                    robot.moveForStartField(); // Первый ход робота
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
            else MessageDialog.wrongDateMessage();
        });
    }


    // Обрабатываем события поля dataField
    public void addDataFieldListener(){
        Fields.dateField.addActionListener(e -> {
            date = Fields.simpleDateFormat.format(Fields.dateField.getDate());
            if (CheckDates.userMove() == true) { // Если дата пользователя верна
                if (CheckDates.isUserWin() == false) { // И он еще не победил
                    Fields.textArea.append("Ваш ход: " + date + Fields.newline);
                    try {
                        robot.moveForDateField(); // Ход робота
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    // Обрабатываем события кнопки "сброс"
    public void addStopButtonListener(){
        DatesFrame.stopButton.addActionListener(e -> {
            Fields.textArea.setText("");
            DatesFrame.startButton.setEnabled(true);
            Fields.startField.setEditable(true);
            Fields.dateField.setDate(null);
            Fields.dateField.setEditable(false);
        });
    }

}
