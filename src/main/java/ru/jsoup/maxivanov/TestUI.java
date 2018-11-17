package ru.jsoup.maxivanov;

import com.sun.deploy.panel.JreDialog;
import org.jsoup.Jsoup;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TestUI {

    private JFrame frame;
    private JButton button;
    private JTextField searchQ;
    private JPanel panel;

    public TestUI() {
        initialize();
    }

    private void initialize(){
        frame = new JFrame();
        frame.setBounds(500,500,500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        searchQ = new JTextField();
        searchQ.setToolTipText("Search");
        searchQ.setBounds(20, 20, 460, 40);
        searchQ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(frame, "word: " + searchQ.getText());
                String url = null;
                try {
                    url = Jsoup.connect(Search.getURL(searchQ.getText())).get().html();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.out.println(url);
                ;
            }
        });


        button = new JButton();
        button.setText("Search");
        button.setBounds(200,80,100,50);


        frame.getContentPane().add(searchQ);
        frame.getContentPane().add(button);

        //frame.setVisible(true);
    }

    /*public static void main(String[] args) {
        Runnable run = new Runnable() {
            public void run() {
                JFrame frame = new JFrame() {
                };
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Dimension dimension = toolkit.getScreenSize();
                frame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 250, 500, 500);
                frame.setTitle("Vacancies");

                final JPanel panel = new JPanel();

                JButton button = new JButton("Поиск");
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!panel.getBackground().equals(Color.BLACK)) {
                            panel.setBackground(Color.BLACK);
                        } else {
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
    }*/

    public static void runGUI(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestUI ui = new TestUI();
                    ui.frame.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


}
