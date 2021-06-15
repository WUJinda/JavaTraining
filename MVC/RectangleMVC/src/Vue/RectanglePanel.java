package Vue;

import javax.swing.*;
import java.awt.*;

public class RectanglePanel extends JPanel {

    int height;

    public RectanglePanel(int height){
        super();
        this.height = height;
    }
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(10, 10, 20, height);
    }


    public void refaire(){
        this.repaint(0) ;
    }
}