package Shape.UMLObject;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.*;

public class ClassObject extends BasicObject {
    
    public ClassObject(Point location, int depth, int width, int height){
        super(location, depth, width, height);
        initializePorts();
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawRect(location.x - width, location.y-height, width, height);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(location.x - width, location.y-height, width, height);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawRect(location.x - width, location.y-height, width, height*1/5);
        g2d.drawRect(location.x - width, location.y-height*2/5, width, height*2/5);
        g2d.drawRect(location.x - width, location.y-height*4/5, width, height*2/5);
        if (selected){
            showPorts(g2d);
        }
        if (objectName != null){
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font( "SansSerif", Font.BOLD, fontSize));
            g2d.drawString(objectName, location.x-width*8/10, location.y-height*9/10);
        }
    }

    public Rectangle2D getBound() {
        return new Rectangle2D.Double(location.x - width, location.y-height, width, height);
    } 
}