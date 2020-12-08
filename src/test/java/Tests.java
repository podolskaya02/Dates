import Pack.Controller.CheckDates;
import Pack.Controller.MouseListener;
import Pack.Controller.Robot;
import Pack.Model.Fields;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

        private Fields fields = new Fields();

        @Test
        // Тест, проверяющий правильность хода игрока (включает в себя проверку метода isRightYear() )
        void userMoveTest() throws ParseException {
                fields.getDateField();
                Robot.calendar = Calendar.getInstance();
                Robot.calendar.setTime(Fields.simpleDateFormat.parse("01.01.2020"));

                // Верные варианты ходов игрока
                Fields.dateField.setDate(Fields.simpleDateFormat.parse("02.01.2020"));
                assertTrue(CheckDates.userMove());

                Fields.dateField.setDate(Fields.simpleDateFormat.parse("03.01.2020"));
                assertTrue(CheckDates.userMove());

                Fields.dateField.setDate(Fields.simpleDateFormat.parse("01.02.2020"));
                assertTrue(CheckDates.userMove());

                Fields.dateField.setDate(Fields.simpleDateFormat.parse("01.03.2020"));
                assertTrue(CheckDates.userMove());

                // Неверные варианты ходов игрока
                Fields.dateField.setDate(Fields.simpleDateFormat.parse("04.01.2020"));
                assertFalse(CheckDates.userMove());

                Fields.dateField.setDate(Fields.simpleDateFormat.parse("01.04.2020"));
                assertFalse(CheckDates.userMove());

                Fields.dateField.setDate(Fields.simpleDateFormat.parse("01.01.2021"));
                assertFalse(CheckDates.userMove());

                // Проверка метода isRightYear() (особый случай - запрет перехода с декабря на январь)
                Robot.calendar.setTime(Fields.simpleDateFormat.parse("30.12.2020"));
                Fields.dateField.setDate(Fields.simpleDateFormat.parse("01.01.2021"));
                assertFalse(CheckDates.userMove());
        }

        @Test
        // Тест, проверяющий победил ли пользователь
        void isUserWinTest(){
                fields.getAreaText();
                fields.getDateField();

                MouseListener.date = "31.12.2020";
                assertTrue(CheckDates.isUserWin());

                MouseListener.date = "31.11.2020";
                assertFalse(CheckDates.isUserWin());

                MouseListener.date = "01.01.2021";
                assertFalse(CheckDates.isUserWin());

                MouseListener.date = "тридцать первое декабря";
                assertFalse(CheckDates.isUserWin());

        }

        @Test
        //Tест проверяющий, проиграл ли пользователь
        void isUserLoseTest(){
                fields.getDateField();

                Robot.robotDate = "31.12.2020";
                assertTrue(CheckDates.isUserLose());

                Robot.robotDate = "31.11.2020";
                assertFalse(CheckDates.isUserLose());

                Robot.robotDate = "01.01.2021";
                assertFalse(CheckDates.isUserLose());

                Robot.robotDate = "тридцать первое декабря";
                assertFalse(CheckDates.isUserLose());

        }

        @Test
        // Тест, проверяющий ходы робота
        void robotMoveTest() throws ParseException {
                Robot robot = new Robot();
                fields.getDateField();
                Robot.calendar = Calendar.getInstance();

                Fields.dateField.setDate(Fields.simpleDateFormat.parse("30.12.2020"));
                robot.robotMove();
                assertEquals(31, Robot.calendar.get(Calendar.DAY_OF_MONTH));
                assertEquals(Calendar.DECEMBER, Robot.calendar.get(Calendar.MONTH));
                assertEquals(2020, Robot.calendar.get(Calendar.YEAR));

                Fields.dateField.setDate(Fields.simpleDateFormat.parse("29.12.2020"));
                robot.robotMove();
                assertEquals(31, Robot.calendar.get(Calendar.DAY_OF_MONTH));
                assertEquals(Calendar.DECEMBER, Robot.calendar.get(Calendar.MONTH));
                assertEquals(2020, Robot.calendar.get(Calendar.YEAR));

                Fields.dateField.setDate(Fields.simpleDateFormat.parse("20.11.2020"));
                robot.robotMove();
                assertTrue(((Calendar.NOVEMBER == Robot.calendar.get(Calendar.MONTH)) && Robot.calendar.get(Calendar.DAY_OF_MONTH) == 21)
                        || (Calendar.NOVEMBER == Robot.calendar.get(Calendar.MONTH) && Robot.calendar.get(Calendar.DAY_OF_MONTH) == 22)
                        || (Calendar.DECEMBER == Robot.calendar.get(Calendar.MONTH) && Robot.calendar.get(Calendar.DAY_OF_MONTH) == 20));

                Fields.dateField.setDate(Fields.simpleDateFormat.parse("13.07.2020"));
                robot.robotMove();
                assertTrue(((Calendar.JULY == Robot.calendar.get(Calendar.MONTH)) && Robot.calendar.get(Calendar.DAY_OF_MONTH) == 14)
                        || (Calendar.JULY == Robot.calendar.get(Calendar.MONTH) && Robot.calendar.get(Calendar.DAY_OF_MONTH) == 15)
                        || (Calendar.AUGUST == Robot.calendar.get(Calendar.MONTH) && Robot.calendar.get(Calendar.DAY_OF_MONTH) == 13)
                        || (Calendar.SEPTEMBER == Robot.calendar.get(Calendar.MONTH) && Robot.calendar.get(Calendar.DAY_OF_MONTH) == 13));
        }
}
