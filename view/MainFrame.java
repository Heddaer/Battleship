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

public class MainFrame extends JFrame {

    private MainPanel mainPanel;
    private int width = 1000;
    private int height = 600;
    private Controller controller;

    public MainFrame (Controller controller){
        super("BATTLESHIP");
        this.controller = controller;
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // programmet avslutas när rutan stängs
        mainPanel = new MainPanel(width, height, controller);
        this.setContentPane(mainPanel);
        this.setVisible(true);

    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
