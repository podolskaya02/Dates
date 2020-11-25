package Pack.View;

import Pack.Controller.MouseListener;
import Pack.Model.Fields;

import javax.swing.*;
import java.text.ParseException;

import static javax.swing.GroupLayout.Alignment.*;

public class DatesFrame extends JFrame {

    public static JButton startButton;
    public static JButton stopButton;

    public DatesFrame() { // Создаем фрейм
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Добавляем меню
        MenuForFrame menu = new MenuForFrame();
        menu.setMenuBar();
        setJMenuBar(menu.jMenuBar);

        // Добавляем в окно поля и кнопки
        JLabel text = new JLabel("ИСХОДНАЯ ДАТА : ");
        Fields fields = new Fields();
        fields.getStartField();
        fields.getDateField();
        fields.getAreaText();
        startButton = new JButton("СТАРТ");
        stopButton = new JButton("СБРОС");

        // Подключаем слушатели
        MouseListener listener = new MouseListener();
        listener.addStartButtonListener();
        listener.addDataFieldListener();
        listener.addStopButtonListener();

        // Создаем сетку для менеджера положения
        Fields.dateField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Fields.textArea.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        // Определение менеджера расположения
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        // Создание горизонтальной группы
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(Fields.startField)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addComponent(text)
                                        .addComponent(Fields.dateField)
                                        .addComponent(Fields.scroll))
                                ))
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(startButton)
                        .addComponent(stopButton))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, startButton, stopButton);

        // Создание вертикальной группы
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(text)
                        .addComponent(Fields.startField)
                        .addComponent(startButton))
                .addGroup(layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(Fields.dateField))
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(Fields.scroll)))
                        .addComponent(stopButton))
        );

        setTitle("Game Dates");
        setLocation(450, 150);
        pack();
    }

}
