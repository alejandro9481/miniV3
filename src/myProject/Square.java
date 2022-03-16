package myProject;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class Dado generate a Random value between 1 and 6
 * @author Alejandro Villamil
 * @author Javier Castrillon
 * @version v.1.0.0 date 09/12/2021
 */
public class Square extends JLabel {

    private static int SQUIARESIZE = 30;
    private static int MAXSQUIARE = 11;

    private int row, column, state;
    private ImageIcon image ;
    private String nameState;
    private boolean player, view;

    /**
     * Este es el controlador y lo que hace es definir la dimension del mismo
     * y guardar los parametros en las variables privadas
     * @param fila
     * @param columna
     * @param estado
     * @param imagen
     */
    public Square(int fila, int columna,int estado, ImageIcon imagen){
        setImage(imagen);
        this.column = columna;
        this.row = fila;
        this.state = estado;
        infoSquare(estado);

        this.setBackground(Color.blue);

        Dimension size = new Dimension(SQUIARESIZE, SQUIARESIZE);

        this.setPreferredSize(size);
        this.setBorder(null);
        //this.setFocusPainted(false);

        //Para repintar la imagen
        this.setIcon(getImage());
    }

    /**
     * Este metodo lo que hace es dar una imagen y el estado del "Square"
     * @param i
     */
    public String infoSquare(int i) {
        setState(i);
        switch (i) {
            case 0: nameState = "Sea";// →→→ neutral o el mar
                    position(); break;

            case 1: nameState = "Water";// →→→ cuando el tiro da en el agua
                this.image =  new ImageIcon("src/resources/"+i+".png")  ;break;

            case 2: nameState = "Touched";// →→→ cuando el tiro da en un barco
                this.image =  new ImageIcon("src/resources/"+i+".png")  ;break;

            case 3: nameState = "Sunken";// →→→ cuando unde el barco
                this.image =  new ImageIcon("src/resources/"+i+".png")  ;break;

            case 4: nameState = "Frame";break;// →→→ Marco del mapa

            case 5: nameState = "Ship";break;// →→→ Barcos en general

            default:
        }
        //set's
        setImage(image);

        return nameState;
    }

    /**
     * Este metodo ayuda a definir si estamos en el marco de la imagen o no
     * y si estamos en el marco pone las letras y numeros en el mismo
     */
    public void position(){
        //Como la imagen es de 330 x 330 va a entrar en una matriz 11 * 11

        //Para ir montando las imagenes en la posición
        BufferedImage bufferImage = null;
        try{
            bufferImage = ImageIO.read(new File("src/resources/sea.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");
        }

        if(column == 0 || row == 0){
            infoSquare(4);
            char c = '0';
            if(row != 0 && column == 0 ){//row = →←
                c = (char)(48+row);
            }else if(column != 0 && row == 0){//column = ↑↓
                c = (char)(64+column);
            }
            if(48+row == 58){
                this.setText("   "+10+" ");
            }else{
                this.setText("    "+c+" ");
            }

        }else{
            //Para establecer una pocisión en la imagen
            int x = column*SQUIARESIZE;
            int y = row*SQUIARESIZE;

            BufferedImage subImage = bufferImage.getSubimage(x, y, SQUIARESIZE, SQUIARESIZE);
            image = new ImageIcon(subImage);
            setImage(image);
        }


    }

    public static int getSquareSize() {return SQUIARESIZE;}

    public static int getMaxSquare() {return MAXSQUIARE;}

    public int getRow() { return row;}
    public void setRow(int row) {this.row = row;}

    public int getColumn(){ return column;}
    public void setColumn(int column){this.column = column;}

    public int getState() {return state;}
    public void setState(int state) {this.state = state;}

    public ImageIcon getImage() {return image;}
    public void setImage(ImageIcon image) { setIcon(image);this.image = image;}
}
