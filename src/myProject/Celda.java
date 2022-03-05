package myProject;


import javax.swing.*;
import java.awt.*;

/**
 * Class Dado generate a Random value between 1 and 6
 * @author Alejandro Villamil
 * @author Javier Castrillon
 * @version v.1.0.0 date 09/12/2021
 */
public class Celda extends JButton {
    int fila;
    int columna;

    public Celda(int columna, int fila){
        this.columna = columna;
        this.fila = fila;
        this.setBackground(Color.blue);
    }

    public int getFila() { return fila;}
    public void setFila(int fila) {this.fila = fila;}

    public int getColumna(){ return columna;}
    public void setColumna(int columna){this.columna = columna;}
}
