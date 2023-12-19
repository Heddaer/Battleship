/*
 *  Namn: Hedda Eriksson
 *  Dator-id: ak9098
 *  Namn: Alicia Sondh
 *  Dator-id: Al1752
 *  Utbildning: Datateknik och Mobil IT: Högskoleingenjörsprogrammet
 *  Datum: 11/1 - 2022
 * */
package model;

public class Ships implements IShips{

    private String name;
    private int length;
    private String symbol;
    private int hits;
    private boolean isSunk = false;

    public Ships(String name, int length, String symbol){
        this.name = name;
        this.length = length;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getHits() {
        hits++;
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void setSunk(boolean sunk) {
        isSunk = sunk;
    }
}
