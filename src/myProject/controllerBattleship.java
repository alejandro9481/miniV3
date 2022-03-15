package myProject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class controllerBattleship implements runnable{
    private Square[][] mapOwn, mapShot;
    private Square proof ;
    private boolean up, down, left, right;

    public controllerBattleship(){
        this.proof = new Square(0,0,0,null);
        this.mapOwn = new Square[proof.getMaxSquare()][proof.getMaxSquare()];
        this.mapShot = new Square[proof.getMaxSquare()][proof.getMaxSquare()];

        setMapOwn(paint(getMapOwn()));
        setMapShot(paint(getMapShot()));
    }

    public Square[][] paint(Square[][] other){
        Square otherSquare = new Square(0, 0,0,null);
        //Como la imagen es de 220 x 220 entra en una matriz 11 * 11
        other = new Square [otherSquare.getMaxSquare()][otherSquare.getMaxSquare()];

        //Con este doble "for" se separan los los segmentos de la imagen completa para mostrarlos
        for(int col=0; col<otherSquare.getMaxSquare(); col++) {
            for(int row=0; row<otherSquare.getMaxSquare(); row++) {
                // Horizontal, vertical
                int x = row,  y = col;

                //Para ir montando el mapa en "other"
                other[x][y] = new Square( x, y,0,null);

                //verificación de atributos
                /*System.out.println("Fila: "+other[x][y].getRow()
                                    +" Columna: "+other[x][y].getColumn()
                                    +" Estado: "+other[x][y].getState());*/
            }
        }
        return other;
    }

    public Square[][] paintShips(Square[][] other){
        //Para ir montando las imagenes en la posición
        BufferedImage[] bufferImage = null;
        try{
            bufferImage[0] = ImageIO.read(new File("src/resources/ships/ship_4.png"));
            bufferImage[1] = ImageIO.read(new File("src/resources/ships/ship_3.png"));
            bufferImage[2] = ImageIO.read(new File("src/resources/ships/ship_2.png"));
            bufferImage[3] = ImageIO.read(new File("src/resources/ships/ship_1.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");
        }

        paint(other);
        int x = randomNumber(),  y = randomNumber();
        int k = Square.getSquareSize();

        int cont =1;
        int row = cont*k;
        int column = cont*k;
        BufferedImage subImage = bufferImage[0].getSubimage(column, row, k, k);

        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));

        return other;
    }

    public int verificationMain(Square[][] other,int x, int y, int numberShip){
        if(x >= (10-numberShip)  && y >= (10-numberShip)){

        }else if(){

        }else if(){

        }else if(){

        }
        return 1;
    }

    public void shipsInMap(Square[][] other, int direction, int numberShip, int x, int y){
        switch (direction) {
            case 0://Arriba -- UP
                switch (numberShip) {
                    case 0://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    case 1://barco de 2 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        other[x][y+1] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    case 2://barco de 3 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    case 3://barco de 4 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    default:
                }
                break;

            case 1://Izquierda -- LEFT
                switch (direction) {
                    case 0://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    case 1://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    case 2://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    case 3://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    default:
                }
                break;

            case 2://Abajo -- DOWN
                switch (direction) {
                    case 0://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    case 1://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    case 2://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    case 3://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    default:
                }
                break;

            case 3://Derecha -- RIGHT
                switch (direction) {
                    case 0://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    case 1://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    case 2://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    case 3://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,new ImageIcon(subImage));
                        break;

                    default:
                }
                break;

            default:
        }
    }

    public int randomNumber(){
        Random aleatorio = new Random();
        int random = aleatorio.nextInt(10) + 1;
        return random;
    }
    @Override
    public void run() {
        while (rodar) {
            indexImagen = aleatorio.nextInt(16) + 1;
            imagen = new ImageIcon(getClass().getResource(GUI.PATH + indexImagen + ".png"));
            this.setIcon(imagen);
            try {
                Thread.sleep(aleatorio.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Square[][] getMapOwn() {return mapOwn;}
    public void setMapOwn(Square[][] mapOwn) {this.mapOwn = mapOwn;}

    public Square[][] getMapShot() {return mapShot;}
    public void setMapShot(Square[][] mapShot) {this.mapShot = mapShot;}

    public Square getProof() {return proof;}
    public void setProof(Square proof) {this.proof = proof;}
}
