package Pack.Controller;

import Pack.Model.Fields;
import Pack.View.MessageDialog;

import java.util.Calendar;
import java.util.Date;

public class CheckDates {
    // Класс проверяет даты: правильность выбора даты в соответсвиями с правилами, и является ли она окончательной

    public static boolean userMove(){ // Проверка хода игрока
        Calendar calendarForCheck = Calendar.getInstance();
        calendarForCheck.setTime(Robot.calendar.getTime());
        calendarForCheck.add(Calendar.DATE, 1); // Прибавлен один день к дате робота
        if (!Fields.dateField.getDate().equals(Date.from(calendarForCheck.getTime().toInstant()))) {
            calendarForCheck.add(Calendar.DATE, 1); // Прибавлено два дня к дате робота
            if (!Fields.dateField.getDate().equals(Date.from(calendarForCheck.getTime().toInstant()))){
                calendarForCheck.setTime(Robot.calendar.getTime());
                calendarForCheck.add(Calendar.MONTH, 1); // Прибавлен месяц к дате робота
                if (!Fields.dateField.getDate().equals(Date.from(calendarForCheck.getTime().toInstant()))){
                    calendarForCheck.add(Calendar.MONTH, 1); // Прибавлено два месяца к дате робота
                    if (!Fields.dateField.getDate().equals(Date.from(calendarForCheck.getTime().toInstant()))) {
                        MessageDialog.wrongDateMessage(); // Если выбор игрока не удовляет не одну из вариантов
                        return false;
                    }
                }
            }
        }
        return isRightYear(); // if (!isRightYear()) return false else return true
    }

    private static boolean isRightYear() { // Проверяет, чтобы игрок не перешел на другой год
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Fields.dateField.getDate());
        if (calendar.get(Calendar.YEAR) != Robot.calendar.get(Calendar.YEAR)) {
            MessageDialog.wrongDateMessage();
            return false;
        }
        return true;
    }

    public static boolean isUserWin() {
        if (MouseListener.date.contains("31.12")) {
            Fields.textArea.append("Ваш ход: " + MouseListener.date + Fields.newline);
            Fields.dateField.setEditable(false);
            MessageDialog.winMessage();
            return true;
        }
        return false;
    }

    public static boolean isUserLose() {
         if (Robot.robotDate.contains("31.12")) {
             MessageDialog.loseMessage();
             Fields.dateField.setEditable(false);
             return true;
         }
         return false;
    }
}
