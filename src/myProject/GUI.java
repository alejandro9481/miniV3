package myProject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUI extends JFrame {

    private Header headerProject;
    private BufferedImage bufferImage;
    private JPanel panelOwn, panelShot, panelInfo;

    private JFrame view = this;
    private Timer time;
    private Escucha listen;
    private JTextArea message;

    private controllerBattleship control = new controllerBattleship(0);

    /**
     * Constructor of GUI class
     */
    public GUI(){
        try {
            bufferImage = ImageIO.read(new File("src/resources/sea.png"));

            initGUI();

            //default window configuration
            this.setTitle("The Title app");
            this.setUndecorated(false);//false
            //this.setSize(200,100);
            this.pack();

            this.setResizable(false);//true
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");
        }
    }

    /**
     * Este metodo es usado para poner las configuraciones predeterminadas,
     * crear "Listener's" y los objeto "control" usado por el metodo "beginning"
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        //Set up JComponents
        headerProject = new Header("Table Own                    "+
                                    "                                 "+
                                    "                                 "+
                                    "Table Shot", Color.BLACK);

        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout
        //crear el escucha y el timer
        listen = new Escucha();
        time = new Timer(500, listen);
        view = this;

        panelInfo = new JPanel();

        message = new JTextArea(18,22);
        message.setEditable(false);
        message.setVisible(true);
        message.setText(" Press in one place from the 'Table Own' \n"+
                        " then press ??? = W   ??? = S   ??? = D   ??? = A\n\n"+
                        " This is for put the ship in the place \n"+
                        " selected in the map, and the keys is for\n"+
                        " the ship's direction\n"+
                        " The order to place the ships is:\n"+
                        " 1st 1 aircraft carrier ??? occupies 4 spaces\n"+
                        " 2nd 2 submarines ??? occupy 3 spaces each.\n"+
                        " 3rd 3 destroyers ??? occupy 2 spaces each.\n"+
                        " 4th 4 frigates ??? occupy 1 space each.\n");
        JScrollPane scroll = new JScrollPane(message);

        panelInfo.add(scroll);
        this.add(panelInfo,BorderLayout.CENTER);
        beginning();
    }

    /**
     * Este metodo es usado para poner las configuraciones predeterminadas,
     * crear "Listener's" y los objeto "control" usado por la clase "GUI"
     * Este es usado para la interfaz del juego
     */
    public void beginning(){
        //JPanel que se muestra al inicio del programa
        panelOwn = new JPanel();
        panelShot = new JPanel();

        //Determino la margen que van a tener los paneles
        panelOwn.setLayout(new GridLayout(control.getProof().getMaxSquare(), control.getProof().getMaxSquare()));
        panelShot.setLayout(new GridLayout(control.getProof().getMaxSquare(), control.getProof().getMaxSquare()));



        //Con este doble "for" se guarda lo del array[][] en los paneles
        for(int col=0; col<control.getProof().getMaxSquare(); col++) {
                for(int row=0; row<control.getProof().getMaxSquare(); row++) {
                //Para ir montando las imagenes en el centralPanel

                /*System.out.println("Fila: "+control.getMapOwn()[row][col].getRow()
                        +" Columna: "+control.getMapOwn()[row][col].getColumn()
                        +" Estado: "+control.getMapOwn()[row][col].getState());*/

                panelOwn.add(control.getMapOwn()[col][row]);
                panelShot.add(control.getMapShot()[col][row]);
            }
        }

        this.add(panelOwn, BorderLayout.WEST);
        this.add(panelShot, BorderLayout.EAST);
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha extends  MouseAdapter implements ActionListener {
        @Override
        public void mouseClicked(MouseEvent eventMouse) {
            // TODO Auto-generated method stub
            Square squareSelected = (Square) eventMouse.getSource();

            if(squareSelected.getState() == 0){

            }else if(squareSelected.getState() == 1){

            }else if(squareSelected.getState() == 2){

            }else if(squareSelected.getState() == 3){

            }else if(squareSelected.getState() == 4){

            }else if(squareSelected.getState() == 5){

            }
            revalidate();
            repaint();
        }
        @Override
        public void actionPerformed(ActionEvent eventAction) {
            /*if(eventAction.getSource() == salir){
            }else if(){
            }*/
        }
    }
}
