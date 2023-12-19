/*
 *  Namn: Hedda Eriksson
 *  Dator-id: ak9098
 *  Namn: Alicia Sondh
 *  Dator-id: Al1752
 *  Utbildning: Datateknik och Mobil IT: Högskoleingenjörsprogrammet
 *  Datum: 11/1 - 2022
 * */
package model;

public class GameManager {

    private int shots = 0;
    private int hits = 0;
    private Player[] highScoreList;
    private Player currPlayer; // working object
    private int i = 10;
    private Game gameBoard;
    private Ships[] shipList;
    private String [][] game = new String[11][11];

    public GameManager(){
        highScoreList = new Player[100];
        currPlayer = new Player("no name", 0);
        gameBoard = new Game();
        shipList = gameBoard.getShips();

    }

    public Player[] setDefaultHighScore(){
        highScoreList[0] = new Player("player1", 100);
        highScoreList[1] = new Player("player2", 100);
        highScoreList[2] = new Player("player3", 100);
        highScoreList[3] = new Player("player4", 100);
        highScoreList[4] = new Player("player5", 100);
        highScoreList[5] = new Player("player6", 100);
        highScoreList[6] = new Player("player7", 100);
        highScoreList[7] = new Player("player8", 100);
        highScoreList[8] = new Player("player9", 100);
        highScoreList[9] = new Player("player10", 100);

        return highScoreList;
    }

    public void setNewGameBoard(int gameCounter) {

        if(gameCounter %2 == 0){                            //om jämnt tal använd denna spelplanen
            setGame(gameBoard.getSpelPlan1());
        }
        else{                                               //om udda tal använd denna
            setGame(gameBoard.getSpelPlan2());
        }
    }

    /*  addToHighScoreList
        Beskrivning: Lägg till nytt spel till high score om poängen kvalar in
        Parametrar: Parametern name kommer från en input av användaren med ett alias därav String och parametern score är en input från GUI:n
        med antal skott för vinst. Den är en string för att det är så den hanteras i GUI:n.
        Retur: Den returnerar highScoreList för att man ska kunna hämta den senaste versionen
    */
    public Player[] addToHighScoreList(String name, String score){

        if(Integer.parseInt(score) < highScoreList[9].getScore()){
            currPlayer = new Player(name, Integer.parseInt(score));
            highScoreList[9] = currPlayer;
            setHighScoreList(highScoreList);
            updateHighScoreList();
        }
        else{
            currPlayer = new Player(name, Integer.parseInt(score));
            highScoreList[i] = currPlayer;
            i++;
        }
        return highScoreList;
    }

    /* Räknar skott */
    public String setShotsFired() {
        shots= getShots();
        shots++;
        System.out.println(shots);
        return String.valueOf(shots);
    }

    /* Vid nytt spel, rensa rutan som räknar skott och hits*/
    public void clearShotField(){
     setHits(0);
     setShots(0);
    }

    /* rensa info om skeppens träffa och isSunk*/
    public void clearHitsOnShips() {
        for (int j = 0; j < shipList.length; j++) {
            shipList[j].setHits(0);
            shipList[j].setSunk(false);
        }
    }

    /* Räknar träffar */
    public String setHits() {
        hits++;
        return String.valueOf(hits);
    }

    /* Kolla om det är träff(true) eller miss(false)*/
    public boolean checkIndex(int row, int col){
        boolean hit = false;

        if (game[row][col] != ""){
            hit = true;
        }
        else {
            hit = false;
        }
        return hit;
    }

    /* Kolla vilken båt som träffades*/
    public String shotAtShip(int row, int col){
        String nameOfShip = "";
        int hit = 0;
        if (game[row][col] == "U"){
            nameOfShip = shipList[0].getName();
            hit = shipList[0].getHits();
            shipList[0].setHits(hit);
            if (hit == 1){
                shipList[0].setSunk(true);
            }

        }
        else if (game[row][col] == "T"){
            nameOfShip = shipList[1].getName();
            hit = shipList[1].getHits();
            shipList[1].setHits(hit);
            if (hit == 2){
                shipList[1].setSunk(true);
            }
        }
        else if (game[row][col] == "J"){
            nameOfShip = shipList[2].getName();
            hit = shipList[2].getHits();
            shipList[2].setHits(hit);
            if (hit == 3){
                shipList[2].setSunk(true);
            }
        }
        else if (game[row][col] == "K"){
            nameOfShip = shipList[3].getName();
            hit = shipList[3].getHits();
            shipList[3].setHits(hit);
            if (hit == 4){
                shipList[3].setSunk(true);
            }
        }
        else if (game[row][col] == "S"){
            nameOfShip = shipList[4].getName();
            hit = shipList[4].getHits();
            shipList[4].setHits(hit);
            if (hit == 5){
                shipList[4].setSunk(true);
            }
        }
        return nameOfShip;
    }

    /* sänk skeppet*/
    public boolean isSunk(String namn){
        int index= 0;
        for (int j = 0; j < shipList.length; j++) {
            if (namn == shipList[j].getName()){
                index = j;
            }
        }
        boolean isSunk = shipList[index].isSunk();

        return isSunk;
    }

    /* Swap metod för att ändra om placeringarna i listan*/
    public Player[] updateHighScoreList() {
        Player swap;
        for (int j = 9; j > 0; j--) {
            if (highScoreList[j].getScore() < highScoreList[j-1].getScore()){
                swap = highScoreList[j];
                highScoreList[j] = highScoreList[j-1];
                highScoreList[j-1] = swap;
            }
        }
        return highScoreList;
    }

    public String[][] getGame() {
        return game;
    }

    public void setGame(String[][] game) {
        this.game = game;
    }

    public Player[] getHighScoreList() {
        return highScoreList;
    }

    public void setHighScoreList(Player[] highScoreList) {
        this.highScoreList = highScoreList;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getShots() {
        return shots;
    }

}
