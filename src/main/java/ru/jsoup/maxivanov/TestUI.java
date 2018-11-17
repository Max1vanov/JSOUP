package ru.jsoup.maxivanov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestUI {

    public static void main(String[] args) {
        Runnable run = new Runnable() {
            public void run() {
                JFrame frame = new JFrame(){};
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Dimension dimension = toolkit.getScreenSize();
                frame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 250, 500, 500);
                frame.setTitle("Vacancies");

                final JPanel panel = new JPanel();

                JButton button = new JButton("Поиск");
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(!panel.getBackground().equals(Color.BLACK)) {
                            panel.setBackground(Color.BLACK);
                        }else{
                            panel.setBackground(Color.WHITE);
                        }
                    }
                });

                JComboBox comboBox = new JComboBox();
                comboBox.insertItemAt("Стаж", 0);
                comboBox.addItem("1");
                comboBox.addItem("2");
                comboBox.addItem("3");

                frame.add(panel);
                panel.add(button);
                panel.add(new JCheckBox("Скрыть вокансии агенств"));
                panel.add(comboBox);

                frame.setVisible(true);
            }
        };

       EventQueue.invokeLater(run);
    }

    /*static JFrame getFrame() {
        JFrame frame = new JFrame(){};
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 250, 500, 500);
        frame.setTitle("Vacancies");
        //frame.setLocationByPlatform(true);
        return frame;
    }*/
}
