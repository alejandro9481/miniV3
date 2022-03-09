package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class controllerBattleship {
    private Square[][] mapOwn, mapShot;
    private Square proof ;
    private int contRow =65,contCol=48;

    public controllerBattleship(){
        this.proof = new Square(0,0,0);
        this.mapOwn = new Square[proof.getMaxSquare()][proof.getMaxSquare()];
        this.mapShot = new Square[proof.getMaxSquare()][proof.getMaxSquare()];

        setMapOwn(paint(getMapOwn()));
        setMapShot(paint(getMapShot()));
    }

    public Square[][] paint(Square[][] other){
        Square otherSquare = new Square(0, 0,0);
        //Como la imagen es de 220 x 220 entra en una matriz 11 * 11
        other = new Square [otherSquare.getMaxSquare()][otherSquare.getMaxSquare()];

        //Con este doble "for" se separan los los segmentos de la imagen completa para mostrarlos
        for(int col=0; col<otherSquare.getMaxSquare(); col++) {
            for(int row=0; row<otherSquare.getMaxSquare(); row++) {
                // Horizontal, vertical
                int x = row,  y = col;

                //Para ir montando el mapa en "other"
                other[x][y] = new Square( x, y,0);

                //verificación de atributos
                /*System.out.println("Fila: "+other[x][y].getRow()
                                    +" Columna: "+other[x][y].getColumn()
                                    +" Estado: "+other[x][y].getState());*/
            }
        }
        return other;
    }

    public Square[][] getMapOwn() {return mapOwn;}
    public void setMapOwn(Square[][] mapOwn) {this.mapOwn = mapOwn;}

    public Square[][] getMapShot() {return mapShot;}
    public void setMapShot(Square[][] mapShot) {this.mapShot = mapShot;}

    public Square getProof() {return proof;}
    public void setProof(Square proof) {this.proof = proof;}
}
