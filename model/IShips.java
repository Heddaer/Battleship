/*
 *  Namn: Hedda Eriksson
 *  Dator-id: ak9098
 *  Namn: Alicia Sondh
 *  Dator-id: Al1752
 *  Utbildning: Datateknik och Mobil IT: Högskoleingenjörsprogrammet
 *  Datum: 11/1 - 2022
 * */
package model;

public interface IShips {

    Ships uBoat = new Ships("Ubåt", 1, "U");
    Ships torped = new Ships("Torped", 2, "T");
    Ships jagare = new Ships("Jagare", 3,"J");
    Ships kryssare = new Ships("Kryssare", 4, "K");
    Ships slagskepp = new Ships("Slagskepp", 5, "S");

}
