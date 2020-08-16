package Shape.UMLObject;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.*;

public class UseClassObject extends BasicObject {

    public UseClassObject(Point location, int depth, int width, int height){
        super(location, depth, width, height);
        initializePorts();
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(thickness+2));
        g2d.drawOval(location.x-width, location.y-height, width, height);
        g2d.setColor(Color.WHITE);
        g2d.fillOval(location.x-width, location.y-height, width, height);
        if (selected){
            showPorts(g2d);
        }
        if (objectName != null){
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font( "SansSerif", Font.BOLD, fontSize ));
            g2d.drawString(objectName, location.x-width*8/10, location.y-height/2);
        }
    }

    public Ellipse2D getBound() {
        return new Ellipse2D.Double(location.x-width, location.y-height, width, height);
    } 
}