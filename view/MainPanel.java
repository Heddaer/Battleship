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

public class MainPanel extends JPanel {

    private GamePanel gamePanel;
    private ControlPanel controlPanel;
    private Controller controller;


    public MainPanel (int width, int height, Controller controller){
        super(null);
        this.controller = controller;
        this.setSize(width, height);
        gamePanel = new GamePanel(600,600, controller);
        add(gamePanel);
        controlPanel = new ControlPanel(400, 600, controller);
        add(controlPanel);

    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }
}
