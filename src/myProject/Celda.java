package myProject;


import javax.swing.*;
import java.awt.*;

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
