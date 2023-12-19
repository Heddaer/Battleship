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
import javax.swing.border.LineBorder;
import java.awt.*;

public class GamePanel extends JPanel {

    private JLabel title;
    private JLabel text;
    private JLabel shots;
    private JLabel hits;
    private JTextField totShots;
    private JTextField totHits;
    private JPanel gameBoard = new JPanel(new BorderLayout(5,5));
    private JButton[][] squares = new JButton[11][11];

    private Controller controller;


    public GamePanel(int height, int width, Controller controller){
        this.controller = controller;
        this.setSize(width,height);
        this.setLocation(0,0);
        this.setLayout(null);
        setUpTitle();
        setUpGameBoard();
    }

    public void setUpTitle(){

        title = new JLabel("Game Board!");
        title.setLocation(220,0);
        title.setSize(180, 30);
        title.setForeground(Color.blue);
        title.setFont(new Font("Serif",Font.PLAIN,16));
        this.add(title);

        text = new JLabel("Click to shoot... ");
        text.setLocation(220,10);
        text.setSize(180, 50);
        text.setForeground(Color.blue);
        text.setFont(new Font("Serif", Font.ITALIC, 14));
        this.add(text);

        shots = new JLabel("Shots:");
        shots.setLocation(535,270);
        shots.setSize(50,50);
        shots.setFont(new Font("Serif", Font.PLAIN, 14));
        shots.setForeground(Color.blue);
        this.add(shots);
        totShots = new JTextField();
        totShots.setEnabled(false);
        totShots.setLocation(530,300);
        totShots.setSize(50, 40);
        totShots.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(totShots);

        hits = new JLabel("Hits:");
        hits.setLocation(535,340);
        hits.setSize(50,50);
        hits.setFont(new Font("Serif", Font.PLAIN, 14));
        hits.setForeground(Color.blue);
        this.add(hits);
        totHits = new JTextField();
        totHits.setEnabled(false);
        totHits.setLocation(530,370);
        totHits.setSize(50,40);
        totHits.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(totHits);

    }

    private void setUpGameBoard() {

        final String rows = "0123456789";
        final String cols = "ABCDEFGHIJ";
        int colStart = 0;
        int colEnd = 1;
        int rowStart = 0;
        int rowEnd = 1;

        gameBoard.setSize(500,500);
        gameBoard.setLocation(20, 60);
        gameBoard.setLayout(new GridLayout(11,11));
        gameBoard.setBorder(new LineBorder(Color.BLACK,1));
        add(gameBoard);

        for (int r = 0; r < 11; r++) {
            for (int c = 0; c < 11; c++) {
                if ((c == 0) && (r != 0)){
                    squares[r][c] = new JButton(cols.substring(colStart++, colEnd++), null);
                    squares[r][c].setForeground(Color.blue);
                    squares[r][c].setFocusable(false); // ej säker på vad denna gör, men vill att knappen inte ska reagera på tryck
                    gameBoard.add(squares[r][c]);
                }
                else if ((r == 0) && (c != 0)){
                    squares[r][c] = new JButton(rows.substring(rowStart++, rowEnd++ ),null);
                    squares[r][c].setForeground(Color.blue);
                    squares[r][c].setFocusable(false);
                    gameBoard.add(squares[r][c]);
                }
                else{
                    squares[r][c] = new JButton("",null);
                    squares[r][c].setEnabled(true);
                    int finalC = c;
                    int finalR = r;
                    squares[r][c].addActionListener(l -> controller.shotPosition(finalR, finalC));
                    gameBoard.add(squares[r][c]);
                }
            }
        }
    }

    public void hit(int row, int col){

        squares[row][col].setText("X");
        squares[row][col].setEnabled(false);

    }
    public void miss(int row, int col){

        squares[row][col].setText("0");
        squares[row][col].setEnabled(false);
    }

    public void shipWindow(String name){
         JOptionPane.showMessageDialog(null, "Du träffade " + name);

    }

    public void sunkWindow(String name){
        JOptionPane.showMessageDialog(null, "Grattis! Du sänkte " + name);

    }

    public void clear(int row, int col){
        squares[row][col].setText("");
        squares[row][col].setEnabled(true);
    }

    public String getTotShots() {
        String totShots = this.totShots.getText();
        return totShots;
    }

    public void setTotShots(String totShots) {
        this.totShots.setText(totShots);
    }

    public void setTotHits(String totShots) {
        this.totHits.setText(totShots);
    }
}
