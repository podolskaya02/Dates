package Pack.View;

import javax.swing.*;
import java.awt.*;

class MenuForFrame extends Menu {

    JMenuBar jMenuBar = new JMenuBar();

    // Создаем меню
    void setMenuBar(){
        JOptionPane optionPane = new JOptionPane();
        jMenuBar = new JMenuBar();
        JMenuItem jMenuItem = new JMenuItem("Правила");
        jMenuBar.add(jMenuItem);
        jMenuItem.addActionListener(e-> JOptionPane.showMessageDialog(optionPane,
                "<html><h2>Правила игры</h2>" +
                        "Задается исходная дата.\n" +
                        "Каждый из игроков на своем ходе задает более позднюю дата, по следующему правилу:\n" +
                        "увеличивая на 1 или 2 день в месяце, либо месяц (но не то и другое сразу)\n" +
                        "Игрок задавший 31.12 - проигрывает.\n" +
                        "Ваша игра идет с роботом.\n" +
                        "Для того, чтобы задать дату, с которой начнется игра, выберите её в поле исходная дата.\n" +
                        "Далее нажмите старт.\n" +
                        "В следующем поле выбирайте дату, которая будет вашим ходом. Нажимайте enter для ввода.\n" +
                        "Для того, чтобы начать заново, нажмите сброс."));
    }

}
