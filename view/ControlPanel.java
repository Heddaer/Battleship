/*
 *  Namn: Hedda Eriksson
 *  Dator-id: ak9098
 *  Namn: Alicia Sondh
 *  Dator-id: Al1752
 *  Utbildning: Datateknik och Mobil IT: Högskoleingenjörsprogrammet
 *  Datum: 11/1 - 2022
 * */
package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    private JLabel title;
    private JButton newGame;
    private JLabel historik;
    private JList<Object> historyList;
    private String inputName;
    private JLabel info;



    private Controller controller;

    public ControlPanel (int width, int height, Controller controller){
        this.controller = controller;
        this.setSize(width, height);
        this.setLocation(550,0);
        this.setLayout(null);
        setUp();
    }

    public void setUp(){

        title = new JLabel("MENU");
        title.setLocation(240,10);
        title.setSize(120, 30);
        title.setForeground(Color.blue);
        title.setFont(new Font("Serif", Font.PLAIN, 16));
        this.add(title);

        newGame = new JButton("New Game");
        newGame.setEnabled(true);
        newGame.setLocation(190,50);
        newGame.setSize(140,40);
        newGame.addActionListener(l -> controller.newGamePlayer());
        this.add(newGame);


        historik = new JLabel("High Scores! ");
        historik.setForeground(Color.blue);
        historik.setLocation(210,100);
        historik.setSize(180, 60);
        historik.setFont(new Font("Serif", Font.ITALIC, 20 ));
        this.add(historik);

        historyList = new JList<>();
        historyList.setLocation(120,145);
        historyList.setSize(300,230);
        historyList.setFont(new Font("Serif", Font.PLAIN, 18));
        this.add(historyList);

        info = new JLabel("<html> SPELREGLER: <br> 15 poäng krävs för att vinna <br> X = träff & 0 = miss <br> Ubåt = 1 ruta <br> Torped = 2 rutor <br> Jagare = 3 rutor <br> Kryssare = 4 rutor <br> Slagskepp = 5 rutor</html>");
        info.setHorizontalAlignment(SwingConstants.CENTER);
        info.setVerticalAlignment(SwingConstants.CENTER);
        info.setLocation(120,400);
        info.setSize(180, 150);
        info.setFont(new Font("Serif", Font.ITALIC, 14 ));
        this.add(info);

    }


    public String showWinWindow(String totShotsFired){
        inputName = JOptionPane.showInputDialog(null,"Enter name: " , "WINNER! Points: " + totShotsFired, JOptionPane.INFORMATION_MESSAGE);

        return inputName;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public JList<Object> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(Object[] historyList) {
        this.historyList.setListData(historyList);
    }
}
