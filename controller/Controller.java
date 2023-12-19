/*
 *  Namn: Hedda Eriksson
 *  Dator-id: ak9098
 *  Namn: Alicia Sondh
 *  Dator-id: Al1752
 *  Utbildning: Datateknik och Mobil IT: Högskoleingenjörsprogrammet
 *  Datum: 11/1 - 2022
 * */
package controller;

import model.Game;
import view.MainFrame;
import model.GameManager;

public class Controller {

    private MainFrame view;
    private GameManager game;
    private boolean hitOrMiss = false;        // för att sätta träff eller miss på vald position
    private int counter = 0;
    private int gameCounter = 0;

    public Controller (){
        view = new MainFrame(this);
        game = new GameManager();
        view.getMainPanel().getControlPanel().setHistoryList(game.setDefaultHighScore());
        newGamePlayer();
    }
    /* newGamePlayer
    metod som rensar spelplanen och lägger till nytt spel
    */
    public void newGamePlayer() {
        gameCounter++;  // för varje nytt spel ökar counter med 1
        game.setNewGameBoard(gameCounter);
        game.clearShotField();
        game.clearHitsOnShips();
        view.getMainPanel().getGamePanel().setTotShots("0");
        view.getMainPanel().getGamePanel().setTotHits("0");
        for (int r = 1; r < 11 ; r++) {
            for (int c = 1; c < 11; c++) {
                view.getMainPanel().getGamePanel().clear(r,c);
            }
        }
    }

    public void shotPosition(int row, int col) {
        /*  hämta avlossade skott och sätt i GUI */
        String shotsFired = game.setShotsFired();
        view.getMainPanel().getGamePanel().setTotShots(shotsFired); // funkar ej
        /* Kollar om index stämmer för träff på skepp eller miss*/
        boolean hit = game.checkIndex(row, col);
        // lägg till x om träff
        if (hit){
            counter++;
            view.getMainPanel().getGamePanel().hit(row, col);
            /*Sätt antal träffar i GUI*/
            String hits = game.setHits();
            view.getMainPanel().getGamePanel().setTotHits(hits);
            /*metod för vilket skepp träffades*/
            popUpWindows(row, col);
            /* metod när man träffat alla (antal booleeans) pop up grattis spara till highscore */
            if (counter == 15){
             winSettings();
            }
        }
        else{
            view.getMainPanel().getGamePanel().miss(row, col);
        }
    }
    /*popUpWindow
    * Kollar om skeppet är sänkt och vilket skepp som träffades, sedan skickas infon till GUI
    * Parametrarna refererar till ett index på spelplanen */
    private void popUpWindows(int row, int col) {
        String nameOfShip = game.shotAtShip(row, col);
        boolean isSunk = game.isSunk(nameOfShip);
        if(isSunk){
            view.getMainPanel().getGamePanel().sunkWindow(nameOfShip);
        }
        else{
            view.getMainPanel().getGamePanel().shipWindow(nameOfShip);
        }
    }

    public void winSettings(){
        /* Visar en pop up ruta när man sänkt alla skepp*/
        String points = view.getMainPanel().getGamePanel().getTotShots();
        view.getMainPanel().getControlPanel().showWinWindow(points);
        /* Kolla om poäng platsar på high score list och lägg till*/
        String name = view.getMainPanel().getControlPanel().getInputName();
        game.addToHighScoreList(name, points);
        /* Metod som sorterar listan och sätter den i guin*/
        view.getMainPanel().getControlPanel().setHistoryList(game.getHighScoreList());
        counter = 0; // nollställs (används för att kolla när man vinner)


    }
    public boolean isHitOrMiss() {
        return hitOrMiss;
    }

    public void setHitOrMiss(boolean hitOrMiss) {
        this.hitOrMiss = hitOrMiss;
    }
}
