package Vue;

import Control.RectangleController;
import Model.RectangleModel;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class RectangleVueTrace implements Observer {

    protected RectangleModel model = null;
    protected RectangleController controller;
    private JFrame traceFrame ;
    RectanglePanel rectPanel = new RectanglePanel(20);

    public RectangleVueTrace(RectangleModel model, RectangleController controller) {
        this.model = model;
        this.controller = controller;
        traceFrame = new JFrame ( "Draw" );
        traceFrame.add(rectPanel);
        traceFrame . setSize (200 ,150);
        traceFrame . setLocation (100 , 400 );
        traceFrame.setVisible(true);
        model.addObserver (this ); // Connexion entre la vue et le modele
    }


    @Override
    public void update(Observable o, Object arg) {
        rectPanel.setVisible(false);
        rectPanel = new RectanglePanel(model.getRectH());
        traceFrame.add(rectPanel);
    }
}
