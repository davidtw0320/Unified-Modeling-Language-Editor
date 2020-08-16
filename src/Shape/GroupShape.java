package Shape;

import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.Rectangle2D;
import java.util.*;

public class GroupShape extends Shape{
    private ArrayList<Shape> children = new ArrayList<>();

    public GroupShape(int depth){
        super(depth);
    }

    public RectangularShape getBound(){
        Rectangle2D union = children.get(0).getBound().getFrame();
        for(Shape child :children){
            union = union.createUnion(child.getBound().getFrame());
        }
        return union.getBounds2D();
    }

    public void add(Shape shape){
        children.add(shape);
    }

    public void remove(Shape shape){
        children.remove(shape);
    }

    public ArrayList<Shape> getChild(){
        return children;
    }

    public void draw(Graphics2D g2d){
        Collections.sort( children, new Comparator<Shape>(){
            public int compare( Shape shape1, Shape shape2 )
            {
                return shape2.depth - shape1.depth;
            }
        });
        for(Shape child :children){
            if(!selected)
                child.selected = false;
            else
                child.selected = true;
            child.draw(g2d);
        }
    }

    public void move(double xMove, double yMove){
        for(Shape child :children){
            child.move(xMove, yMove);
        } 
    }


}