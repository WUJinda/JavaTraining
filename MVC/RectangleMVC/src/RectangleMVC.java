import Model.RectangleModel;
import Control.RectangleController;
import Vue.RectangleVue;
import Vue.RectangleVueHauteur;
import Vue.RectangleVueTrace;


public class RectangleMVC {

    public RectangleMVC(){
        RectangleModel rm = new RectangleModel();
        RectangleController rc = new RectangleController(rm);
        RectangleVueHauteur rv = new RectangleVueHauteur(rm,rc,100,200);
        RectangleVueTrace rvt = new RectangleVueTrace(rm, rc);

        rc.setView(rv);
        rc.setTraceView(rvt);
    }

    public static void main(String[] args) {
        new RectangleMVC();
    }
}
