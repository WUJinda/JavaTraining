package Vue;
import Control.RectangleController;
import Model.RectangleModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observer;


public abstract class RectangleVue implements Observer{

    protected RectangleModel model;
    protected RectangleController controller;
    private JFrame rectangleJFrame ;
    private JTextField display = new JTextField ();
    private JButton upJButton = new JButton ("+");
    private JButton downJButton = new JButton ("-");

    RectangleVue (String label , RectangleModel model , RectangleController controller , int posX , int posY){
        this . model = model ;
        this . controller = controller ;
        rectangleJFrame = new JFrame(label);
        rectangleJFrame.add( new JLabel ( label ) , BorderLayout. NORTH );
        rectangleJFrame.add( display , BorderLayout . CENTER );
        JPanel panelbuttons = new JPanel ();
        panelbuttons .add( downJButton );
        panelbuttons .add( upJButton );
        rectangleJFrame .add( panelbuttons , BorderLayout . SOUTH );
        rectangleJFrame . setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
        model . addObserver ( this ); // Connexion entre la vue et le modele
        rectangleJFrame . setSize (200 ,200);
        rectangleJFrame . setLocation (posX , posY );
        rectangleJFrame . setVisible ( true );
    }

    public void setDisplay ( String s) {
        display . setText (s);
    }
    public double getDisplay () {
        double result = 0.0;
        try {
            result = Double . valueOf ( display . getText ()). doubleValue ();
        }
        catch ( NumberFormatException e ){}
        return result ;
    }
    public void addDisplayListener ( ActionListener a){
        display . addActionListener (a );
    }
    public void addUpListener ( ActionListener a){
        upJButton . addActionListener (a);
    }
    public void addDownListener ( ActionListener a){ downJButton . addActionListener (a );}


}

