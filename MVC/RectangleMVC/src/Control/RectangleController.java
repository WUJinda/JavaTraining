package Control;
import Model.RectangleModel;
import Vue.RectangleVue;
import Vue.RectangleVueTrace;


public class RectangleController {

    private RectangleModel model ;
    private RectangleVue view = null ;
    private RectangleVueTrace viewTrace = null;

    public RectangleController ( RectangleModel m) {
        model = m;
    }
    public void augmenteRectH (){
        model . setRectH (model . getRectH ()+1);

    }
    public void diminueRectH (){
        model . setRectH (model . getRectH ()-1);
    }
    public void fixeRectH ( int height ){
        model . setRectH ( height );

    }
    public void setView ( RectangleVue view ) {
        this . view = view ;
    }

    public void setTraceView (RectangleVueTrace viewTrace){
        this.viewTrace =  viewTrace;
    }

}
