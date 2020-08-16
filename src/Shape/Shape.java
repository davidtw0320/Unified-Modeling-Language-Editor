package Shape;

import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.*;

public abstract class Shape extends JComponent{
    public  int depth;
    public boolean selected = false;
    public ArrayList<Port> ports = new ArrayList<>();
    protected ArrayList<Point> portAreaPoints = new ArrayList<>();

    public Shape(int depth){
        this.depth = depth;
    }

    public abstract void draw(Graphics2D g2d);

    public RectangularShape getBound(){
        return new Rectangle2D.Double(0, 0, 0, 0);
    } 

    public void add(Shape shape){}

    public void remove(Shape shape){}

    public ArrayList<Shape> getChild(){
        ArrayList<Shape> children = new ArrayList<>();
        children.add(this);
        return children;
    }

    public void move(double xMove, double yMove){};
}