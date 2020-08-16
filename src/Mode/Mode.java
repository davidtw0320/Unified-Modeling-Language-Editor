package Mode;

import Shape.Shape;

import java.awt.*;
import java.util.*;
import java.awt.event.*;

public abstract class Mode{

    public abstract void mouseReleased(MouseEvent e, ArrayList<Shape> shapes, Point firstMouseLocation, Point lastMouseLocation, int[] shapeDepth, boolean isDragged);

    public boolean isLocationOnShape(ArrayList<Shape> shapes, Point location){
        boolean onShape = false;
        for (Shape shape : shapes) {
            if (shape.getBound().contains(location)) {
                onShape =  true;
            }
        }
        return onShape;
    }

}