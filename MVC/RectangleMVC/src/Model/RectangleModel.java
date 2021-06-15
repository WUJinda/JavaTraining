package Model;
import java.util.Observable;

public class RectangleModel extends Observable{

    private int rectH = 20;

    public int getRectH (){
        return rectH ;
    }
    public void setRectH ( int height ){
        rectH = height ;
        setChanged ();
        notifyObservers ();
    }


}
