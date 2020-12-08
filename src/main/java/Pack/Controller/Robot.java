package Pack.Controller;

import Pack.Model.Fields;

import java.text.ParseException;
import java.util.Calendar;

public class Robot {

    public static String robotDate;
    public static Calendar calendar;

    void moveForStartField() throws ParseException { // Первый ход робота (обработка начальной даты игрока)
        calendar = Calendar.getInstance();
        calendar.setTime(Fields.simpleDateFormat.parse(MouseListener.startDate));
        robotMove();  // Рассчитываем ход робота
        robotDate = Fields.simpleDateFormat.format(calendar.getTime());
        Fields.textArea.append("Ход робота: "+ robotDate + Fields.newline);
        CheckDates.isUserLose(); // Проверяем, проиграл ли игрок
    }

    void moveForDateField() throws ParseException {
        calendar = Calendar.getInstance();
        calendar.setTime(Fields.simpleDateFormat.parse(MouseListener.date));
        robotMove(); // Рассчитываем ход робота
        robotDate = Fields.simpleDateFormat.format(calendar.getTime());
        Fields.textArea.append("Ход робота: "+ robotDate + Fields.newline);
        CheckDates.isUserLose(); // Проверяем, проиграл ли игрок
    }


    public void robotMove(){
        int numOfOptions = 4; // количество варинтов ходов для робота
        if (Fields.dateField.getDate() != null) calendar.setTime(Fields.dateField.getDate());
        else calendar.setTime(Fields.startField.getDate());

        if (calendar.get(Calendar.MONTH) == Calendar.DECEMBER && (calendar.get(Calendar.DAY_OF_MONTH) == 30)) calendar.add(Calendar.DATE, 1);
        else if (calendar.get(Calendar.MONTH) == Calendar.DECEMBER && (calendar.get(Calendar.DAY_OF_MONTH) == 29)) calendar.add(Calendar.DATE, 2);
        else {
            if (calendar.get(Calendar.MONTH) == Calendar.NOVEMBER) numOfOptions = 3;
            if (calendar.get(Calendar.MONTH) == Calendar.DECEMBER) numOfOptions = 2;
            int random = (int) (Math.random() * numOfOptions);
            switch (random) {
                case (0):
                    calendar.add(Calendar.DATE, 1);
                    break;
                case (1):
                    calendar.add(Calendar.DATE, 2);
                    break;
                case (2):
                    calendar.add(Calendar.MONTH, 1);
                    break;
                case (3):
                    calendar.add(Calendar.MONTH, 2);
                    break;
            }
        }
    }

}
