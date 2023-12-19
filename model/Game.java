/*
 *  Namn: Hedda Eriksson
 *  Dator-id: ak9098
 *  Namn: Alicia Sondh
 *  Dator-id: Al1752
 *  Utbildning: Datateknik och Mobil IT: Högskoleingenjörsprogrammet
 *  Datum: 11/1 - 2022
 * */
package model;

public class Game  {
    /*
    Spelplan
    • u-båtar, en ruta stort
    • torpedbåtar, 2 rutor stort
    • jagare, 3 rutor stort
    • kryssare, 4 rutor stort
    • slagskepp, 5 rutor stort */
    private Ships [] ships = {IShips.uBoat, IShips.torped, IShips.jagare, IShips.kryssare, IShips.slagskepp};
    public String [][] gameBoard = new String[11][11];

    public Game(){

    }

    public void clearGameBoard(){
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = "";
            }

        }
    }

    public String[][] getSpelPlan1(){

        clearGameBoard();
        gameBoard[3][5] = ships[0].getSymbol();
        gameBoard[2][9] = ships[1].getSymbol();
        gameBoard[2][10] = ships[1].getSymbol();
        gameBoard[7][2] = ships[2].getSymbol();
        gameBoard[6][2] = ships[2].getSymbol();
        gameBoard[5][2] = ships[2].getSymbol();
        gameBoard[9][8] = ships[3].getSymbol();
        gameBoard[9][7] = ships[3].getSymbol();
        gameBoard[9][6] = ships[3].getSymbol();
        gameBoard[9][5] = ships[3].getSymbol();
        gameBoard[1][1] = ships[4].getSymbol();
        gameBoard[1][2] = ships[4].getSymbol();
        gameBoard[1][3] = ships[4].getSymbol();
        gameBoard[1][4] = ships[4].getSymbol();
        gameBoard[1][5] = ships[4].getSymbol();

        return gameBoard;
    }

    public String[][] getSpelPlan2(){

        clearGameBoard();
        gameBoard[1][9] = ships[0].getSymbol();
        gameBoard[3][4] = ships[1].getSymbol();
        gameBoard[3][5] = ships[1].getSymbol();
        gameBoard[9][9] = ships[2].getSymbol();
        gameBoard[8][9] = ships[2].getSymbol();
        gameBoard[7][9] = ships[2].getSymbol();
        gameBoard[6][6] = ships[3].getSymbol();
        gameBoard[6][7] = ships[3].getSymbol();
        gameBoard[6][8] = ships[3].getSymbol();
        gameBoard[6][9] = ships[3].getSymbol();
        gameBoard[2][2] = ships[4].getSymbol();
        gameBoard[1][2] = ships[4].getSymbol();
        gameBoard[3][2] = ships[4].getSymbol();
        gameBoard[4][2] = ships[4].getSymbol();
        gameBoard[5][2] = ships[4].getSymbol();

        return gameBoard;
    }

    public String[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(String[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Ships[] getShips() {
        return ships;
    }

    public void setShips(Ships[] ships) {
        this.ships = ships;
    }
}


/* public String[][] createGameBoard(){
        // nollställ GameBoard metod
        for (int count = 0; count < 5; count++) {                          // 5 skepp att placera
            currentShip = ships[count];                                    // hämta aktuellt skepp
            // random position --> kolla så position är tom boolean --> om falskt nytt rand nummer
            boolean ok = false;
            int row = 0;
            int col = 0;
            while (!ok) {
                row = rand.nextInt((max - min) + 1) + min;          // hämta ett random nummer mellan 1 ->11 och använd som index för random placering lägg i row
                col = rand.nextInt((max - min) + 1) + min;          // samma som ovan med lägg i col
                System.out.println(row + "row");
                System.out.println(col + "col");

                if (spelPlan[row][col] == null) {
                    ok = true;
                } else {
                    ok = false;
                }
            }

            // random horisontellt vs vertikalt rand 0 eller 1
            int randNum = rand.nextInt(2);

            if (randNum == 0) {              //horisontellt
                placeHorizontal(row, col, currentShip);
            } else if (randNum == 1) {
                placeVertically(row, col, currentShip);
            }
        }
        return spelPlan;
    }  */

/* private void placeVertically(int row, int col, Ships currentShip) { // ändrar rader
        int numOfBoxes = currentShip.getLength();
        String symbol = currentShip.getSymbol();
        int okCount = 0;                                    // counter för att kolla om alla rutor är ok för placering
        boolean ok = false;                                 // är högerledet och vänsterledet ok
        boolean upOrDown = false;                           // antingen används höger ledet eller vänsterledet

        for (int i = 0; i < numOfBoxes; i++) {              //kollar högerled
            if ((spelPlan[row][col] == null) && (row < 11) && (row != 0)){
                row++;
                okCount++;
            }
        }
        if (okCount == numOfBoxes){
            ok = true;
            upOrDown = false;
        }
        if (okCount != numOfBoxes){                         //kollar vänsterled
            okCount = 0;
            for (int i = 0; i < numOfBoxes; i++) {
                if ((spelPlan[row][col] == null) && (row < 11) && (row != 0)) {
                    row--;
                    okCount++;
                }
            }
            if(okCount == numOfBoxes){
                ok = true;
                upOrDown = true;
            }
        }

        if(ok){                                                 //placera skepp om ok
            for (int i = 0; i < numOfBoxes; i++) {
                spelPlan[row][col] = symbol;
                if(!upOrDown){
                    row++;
                }
                else{
                    row--;
                }

            }
        }
        else{
            createGameBoard();
        }
        // kolla så att specifik båt får plats boolean --> om falskt nytt nummer
    }

    private void placeHorizontal(int row, int col, Ships currentShip) { // ändrar kolumner
        int numOfBoxes = currentShip.getLength();
        String symbol = currentShip.getSymbol();
        int okCount = 0;                                    // counter för att kolla om alla rutor är ok för placering
        int okCount1 = 0;
        boolean ok = false;                                 // är högerledet och vänsterledet ok
        boolean rightOrLeft = false;                        // antingen används höger ledet eller vänsterledet

        for (int i = 0; i < numOfBoxes; i++) {              //kollar högerled
            if ((spelPlan[row][col] == null) && (col < 10) && (col != 0)){
                col++;
                okCount++;
                System.out.println(okCount + "count första");
                System.out.println(col);
            }
        }
        if (okCount == numOfBoxes){
            System.out.println("horisontellt första true satsen");
            ok = true;
            rightOrLeft = false;
        }
        if (okCount != numOfBoxes){                         //kollar vänsterled
           // okCount1 = 0;
            for (int i = 0; i < numOfBoxes; i++) {
                if ((spelPlan[row][col] == null) && (col < 10) && (col != 0)) {
                    col--;
                    okCount1++;
                    System.out.println(okCount1 + "hej");
                }
            }
            if(okCount == numOfBoxes){
                ok = true;
                rightOrLeft = true;
                System.out.println("H andra true satsen");
            }
        }

        if(ok){                                                 //placera skepp om ok
            for (int i = 0; i < numOfBoxes; i++) {
                spelPlan[row][col] = symbol;
                if(!rightOrLeft){
                    col++;
                }
                else{
                    col--;
                }

            }
        }
        else{
            placeVertically(row, col, currentShip);
        }

        // kolla så att specifik båt får plats boolean --> om falskt nytt nummer

    } */

 /*   public void randomGameBoard(){
        int count = 0;
        for (int i = 0; i <= 4; i++) { // 15 positioner ska sättas
            System.out.println(count + "start");

            // hämta ett random nummer mellan 1 ->11 och använd som index för random placering lägg i row
            int row = rand.nextInt((max-min)+1) + min;
            // samma som ovan med lägg i col
            int col = rand.nextInt((max-min)+1) + min;
            // villkor --> kolla igenom så att det inte finns något på den positionen annars continue
            if (gameBoard[row][col] == null){
                if (count == 0){ // ubåt sätts bara en gång
                    gameBoard[row][col] = uBoat;
                    count++;
                    continue;
                }
                if (count == 1){ // placerar ut torped båt med två rutor
                    for (int r = 0; r <2; r++) {
                        hittadGranne = false;
                        gameBoard[row][col] = tBoat; // första index vet vi är ok
                        count++;
                        for (int c = 0; c <2; c++) {
                            while (!hittadGranne){
                                for (int offsetR = row-1; offsetR < row + 1; offsetR++) {
                                    for (int offsetC = col-1; offsetC < col + 1 ; offsetC++) {
                                        if((offsetR >= 1 && offsetR < gameBoard.length) && (offsetC >= 1 && offsetC < gameBoard[row].length) && (gameBoard[offsetR][offsetC] == null)){
                                            if (offsetR == row || offsetC == col ){ //hmmm
                                                row = offsetR;
                                                col = offsetC;
                                                hittadGranne = true;
                                            }

                                        }
                                        //kanske ett else villkor om alla grannar är fulla??
                                    }
                                }
                            }
                        }
                    }
                    if (count == 3){
                        continue;
                    }
                }
                if (count == 3){

                    for (int r = 0; r <=2; r++) {
                        hittadGranne = false;
                        gameBoard[row][col] = jagare;
                        count++;                     // öka count
                        for (int c = 0; c <=2; c++) {// 3 rutor första index vet vi är ok
                            while (!hittadGranne){     // loppa tills vi hittar tom granne
                                for (int offsetR = row-1; offsetR < row + 1; offsetR++) {
                                    for (int offsetC = col-1; offsetC < col + 1 ; offsetC++) {
                                        if((offsetR >= 1 && offsetR < gameBoard.length) && (offsetC >= 1 && offsetC < gameBoard[row].length) && (gameBoard[offsetR][offsetC] == null)){
                                            row = offsetR;
                                            col = offsetC;
                                            hittadGranne = true;
                                        }
                                        //kanske ett else villkor om alla grannar är fulla??
                                    }
                                }
                            }
                        }
                    }
                    if (count == 6){
                        continue;
                    }
                }
                if (count == 6){
                    for (int r = 0; r <4; r++) {
                        hittadGranne = false;
                        gameBoard[row][col] = kBoat; // första index vet vi är ok
                        count++;
                        System.out.println(count);
                        System.out.println("kboat");
                        for (int c = 0; c <4; c++) {
                            while (!hittadGranne){     // loppa tills vi hittar tom granne
                                for (int offsetR = row-1; offsetR < row + 1; offsetR++) {
                                    for (int offsetC = col-1; offsetC < col + 1 ; offsetC++) {
                                        if((offsetR >= 1 && offsetR < gameBoard.length) && (offsetC >= 1 && offsetC < gameBoard[row].length) && (gameBoard[offsetR][offsetC] == null)){
                                            row = offsetR;
                                            col = offsetC;
                                            hittadGranne = true;
                                        }
                                        //kanske ett else villkor om alla grannar är fulla??
                                    }
                                }
                            }
                        }
                    }
                    if (count == 10){
                        continue;
                    }
                }
                if (count == 10){
                    for (int r = 0; r <5; r++) {
                        hittadGranne = false;
                        gameBoard[row][col] = sBoat; // första index vet vi är ok
                        count++;                     // öka counter
                        for (int c = 0; c <5; c++) {
                            while (!hittadGranne){     // loppa tills vi hittar tom granne
                                for (int offsetR = row-1; offsetR < row + 1; offsetR++) {
                                    for (int offsetC = col-1; offsetC < col + 1 ; offsetC++) {
                                        if((offsetR >= 1 && offsetR < gameBoard.length) && (offsetC >= 1 && offsetC < gameBoard[row].length) && (gameBoard[offsetR][offsetC] == null)){
                                            row = offsetR;
                                            col = offsetC;
                                            hittadGranne = true;
                                        }
                                        //kanske ett else villkor om alla grannar är fulla??
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i <gameBoard.length ; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.println(gameBoard[i][j]);
            }

        }

    } */
