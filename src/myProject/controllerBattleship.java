package myProject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class controllerBattleship /*implements runnable*/{
    private Square[][] mapOwn, mapShot;
    private Square proof ;
    private boolean up, down, left, right;

    /**
     * Este es el controlador
     * @param id
     */
    public controllerBattleship(int id){
        this.proof = new Square(0,0,0,null);
        this.mapOwn = new Square[proof.getMaxSquare()][proof.getMaxSquare()];
        this.mapShot = new Square[proof.getMaxSquare()][proof.getMaxSquare()];

        if(id == 0){
            /*setMapOwn(paintShipsMachine(getMapOwn()));*/
            setMapOwn(paint(getMapOwn()));
        }else{
            setMapOwn(paint(getMapOwn()));
        }
        setMapShot(paint(getMapShot()));

    }

    /**
     * Este metodo le da un valor a "other" para poder visualizar el mapa
     * pero solamente pone el oceano
     * @param other
     * @return other
     */
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

    /**
     * Este metodo le da un valor a "other" para poder visualizar el mapa
     * pero solamente pone los barcos aleatoriamente al mapa de la maquina
     * @param other
     * @return other
     */
    public Square[][] paintShipsMachine(Square[][] other){
        paint(other);

        int ship =4;

        for(int i=0; i<4; i++) {
            System.out.println("Rand:  "+randomNumber4());
            switch (ship) {
                case 1://barco de 1 espacio --
                    for(int j=0; j<4; j++) {
                        shipsInMap(other, randomNumber4(), ship, randomNumber10(), randomNumber10());
                    }
                    ship--;
                    break;

                case 2://barco de 2 espacio --
                    for(int j=0; j<3; j++) {
                        shipsInMap(other, randomNumber4(), ship, randomNumber10(), randomNumber10());
                    }
                    ship--;
                    break;

                case 3://barco de 3 espacio --
                    for(int j=0; j<2; j++) {
                        shipsInMap(other, randomNumber4(), ship, randomNumber10(), randomNumber10());
                    }

                    ship--;
                    break;

                case 4://barco de 4 espacio --
                    shipsInMap(other, randomNumber4(), ship, randomNumber10(), randomNumber10());
                    ship--;
                    break;

                default:
            }
        }
        return other;
    }

    public int verificationMain(Square[][] other,int x, int y, int numberShip){
        if((x >= (10-numberShip))  && (y >= (10-numberShip))){

        }
        return 1;
    }

    /*public void shipsInMap(Square[][] other, int direction, int ship, int x, int y) {
        //Para ir montando las imagenes en la posición
        BufferedImage[] image = null;
        try{
            image[0] = ImageIO.read(new File("src/resources/ships/ship_1.png"));
            image[1] = ImageIO.read(new File("src/resources/ships/ship_2.png"));
            image[2] = ImageIO.read(new File("src/resources/ships/ship_3.png"));
            image[3] = ImageIO.read(new File("src/resources/ships/ship_4.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");
        }

        int k = Square.getSquareSize();

        switch (direction) {
            case 1://Arriba -- UP
                switch (ship) {
                    case 1://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        break;

                    case 2://barco de 2 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        other[x][y-1] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*1, 0, k, k)));
                        break;

                    case 3://barco de 3 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        other[x][y-1] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*1, 0, k, k)));
                        other[x][y-2] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*2, 0, k, k)));
                        break;

                    case 4://barco de 4 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        other[x][y-1] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*1, 0, k, k)));
                        other[x][y-2] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*2, 0, k, k)));
                        other[x][y-3] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*3, 0, k, k)));
                        break;

                    default:
                }
                break;

            case 2://Izquierda -- LEFT
                switch (ship) {
                    case 1://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        break;

                    case 2://barco de 2 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        other[x-1][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*1, 0, k, k)));
                        break;

                    case 3://barco de 3 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        other[x-1][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*1, 0, k, k)));
                        other[x-2][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*2, 0, k, k)));
                        break;

                    case 4://barco de 4 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        other[x-1][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*1, 0, k, k)));
                        other[x-2][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*2, 0, k, k)));
                        other[x-3][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*3, 0, k, k)));
                        break;

                    default:
                }
                break;

            case 3://Abajo -- DOWN
                switch (ship) {
                    case 1://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        break;

                    case 2://barco de 2 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        other[x][y+1] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*1, 0, k, k)));
                        break;

                    case 3://barco de 3 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        other[x][y+1] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*1, 0, k, k)));
                        other[x][y+2] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*2, 0, k, k)));
                        break;

                    case 4://barco de 4 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        other[x][y+1] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*1, 0, k, k)));
                        other[x][y+2] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*2, 0, k, k)));
                        other[x][y+3] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*3, 0, k, k)));
                        break;

                    default:
                }
                break;

            case 4://Derecha -- RIGHT
                switch (ship) {
                    case 1://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        break;

                    case 2://barco de 2 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        other[x+1][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*1, 0, k, k)));
                        break;

                    case 3://barco de 3 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        other[x+1][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*1, 0, k, k)));
                        other[x+2][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*2, 0, k, k)));
                        break;

                    case 4://barco de 4 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*0, 0, k, k)));
                        other[x+1][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*1, 0, k, k)));
                        other[x+2][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*2, 0, k, k)));
                        other[x+3][y] = new Square( x, y,5,
                                new ImageIcon(image[ship-1].getSubimage(k*3, 0, k, k)));
                        break;

                    default:
                }
                break;

            default:
        }
    }*/

    /**
     * Este metodo le da un valor a "other" para poder visualizar el mapa
     * pero solamente pone el oceano
     * @param other
     * @param direction         Va del 1 al 4 y define la direccion del barco
     * @param ship              Va del 1 al 4 y define el tamano del barco
     * @param x                 coordenada x del mapa
     * @param y                 coordenada y del mapa
     */
    public void shipsInMap(Square[][] other, int direction, int ship, int x, int y) {
        //Para ir montando las imagenes en la posición
        BufferedImage image1 = null, image2 = null, image3 = null, image4 = null;
        try{
            image1 = ImageIO.read(new File("src/resources/ships/ship_1.png"));
            image2 = ImageIO.read(new File("src/resources/ships/ship_2.png"));
            image3 = ImageIO.read(new File("src/resources/ships/ship_3.png"));
            image4 = ImageIO.read(new File("src/resources/ships/ship_4.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");
        }

        int k = Square.getSquareSize();

        switch (direction) {
            case 1://Arriba -- UP
                switch (ship) {
                    case 1://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image1.getSubimage(k*0, 0, k, k)));
                        break;

                    case 2://barco de 2 espacio --
                        for(int j=0; j<2; j++) {
                            other[x][y-j] = new Square( x, y,5,
                                    new ImageIcon(image2.getSubimage(k*j, 0, k, k)));
                        }

                        break;

                    case 3://barco de 3 espacio --
                        for(int j=0; j<3; j++) {
                            other[x][y-j] = new Square( x, y,5,
                                    new ImageIcon(image3.getSubimage(k*j, 0, k, k)));
                        }
                        break;

                    case 4://barco de 4 espacio --
                        for(int j=0; j<4; j++) {
                            other[x][y-j] = new Square( x, y,5,
                                    new ImageIcon(image4.getSubimage(k*j, 0, k, k)));
                        }
                        break;

                    default:
                }
                break;

            case 2://Izquierda -- LEFT
                switch (ship) {
                    case 1://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image1.getSubimage(k*0, 0, k, k)));
                        break;

                    case 2://barco de 2 espacio --
                        for(int j=0; j<2; j++) {
                            other[x-j][y] = new Square( x, y,5,
                                    new ImageIcon(image2.getSubimage(k*j, 0, k, k)));
                        }
                        break;

                    case 3://barco de 3 espacio --
                        for(int j=0; j<3; j++) {
                            other[x-j][y] = new Square( x, y,5,
                                    new ImageIcon(image3.getSubimage(k*j, 0, k, k)));
                        }
                        break;

                    case 4://barco de 4 espacio --
                        for(int j=0; j<4; j++) {
                            other[x-j][y] = new Square( x, y,5,
                                    new ImageIcon(image4.getSubimage(k*j, 0, k, k)));
                        }
                        break;

                    default:
                }
                break;

            case 3://Abajo -- DOWN
                switch (ship) {
                    case 1://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image1.getSubimage(k*0, 0, k, k)));
                        break;

                    case 2://barco de 2 espacio --
                        for(int j=0; j<2; j++) {
                            other[x][y+j] = new Square( x, y,5,
                                    new ImageIcon(image2.getSubimage(k*j, 0, k, k)));
                        }
                        break;

                    case 3://barco de 3 espacio --
                        for(int j=0; j<3; j++) {
                            other[x][y+j] = new Square( x, y,5,
                                    new ImageIcon(image3.getSubimage(k*j, 0, k, k)));
                        }
                        break;

                    case 4://barco de 4 espacio --
                        for(int j=0; j<4; j++) {
                            other[x][y+j] = new Square( x, y,5,
                                    new ImageIcon(image4.getSubimage(k*j, 0, k, k)));
                        }
                        break;

                    default:
                }
                break;

            case 4://Derecha -- RIGHT
                switch (ship) {
                    case 1://barco de 1 espacio --
                        other[x][y] = new Square( x, y,5,
                                new ImageIcon(image1.getSubimage(k*0, 0, k, k)));
                        break;

                    case 2://barco de 2 espacio --
                        for(int j=0; j<2; j++) {
                            other[x+j][y] = new Square( x, y,5,
                                    new ImageIcon(image2.getSubimage(k*j, 0, k, k)));
                        }
                        break;

                    case 3://barco de 3 espacio --
                        for(int j=0; j<3; j++) {
                            other[x+j][y] = new Square( x, y,5,
                                    new ImageIcon(image3.getSubimage(k*j, 0, k, k)));
                        }
                        break;

                    case 4://barco de 4 espacio --
                        for(int j=0; j<4; j++) {
                            other[x+j][y] = new Square( x, y,5,
                                    new ImageIcon(image4.getSubimage(k*j, 0, k, k)));
                        }
                        break;

                    default:
                }
                break;

            default:
        }
    }

    public int randomNumber10(){
        Random aleatorio = new Random();
        int random = aleatorio.nextInt(10) + 1;
        return random;
    }

    public int randomNumber4(){
        Random aleatorio = new Random();
        int random = aleatorio.nextInt(4) + 1;
        return random;
    }
    /*@Override
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
    }*/

    public Square[][] getMapOwn() {return mapOwn;}
    public void setMapOwn(Square[][] mapOwn) {this.mapOwn = mapOwn;}

    public Square[][] getMapShot() {return mapShot;}
    public void setMapShot(Square[][] mapShot) {this.mapShot = mapShot;}

    public Square getProof() {return proof;}
    public void setProof(Square proof) {this.proof = proof;}
}
