package Vue;
import Control.RectangleController;
import Model.RectangleModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class RectangleVueHauteur extends RectangleVue{
    public RectangleVueHauteur(RectangleModel model, RectangleController controller, int posX, int posY) {
        super(" Rectangle Hauteur ", model, controller, posX, posY);
        setDisplay (""+ model.getRectH ());
        addUpListener ( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.augmenteRectH ();
            }});
        addDownListener ( new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                controller.diminueRectH ();
            }});
        addDisplayListener (new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                int tempC = Double.valueOf(getDisplay ()).intValue();
                controller.fixeRectH ( tempC );
            }});
    }

    @Override
    public void update ( Observable s, Object o) {
        System.out.println("Hauter: " + model.getRectH());
        setDisplay (""+ model.getRectH ());
    }
}

