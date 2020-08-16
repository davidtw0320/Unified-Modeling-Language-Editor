package Mode.Class;

import Mode.*;
import Shape.Shape;

import java.awt.event.*;
import java.util.*;
import java.awt.*;

public abstract class ClassMode extends Mode{

    public void mouseReleased(MouseEvent e, ArrayList<Shape> shapes, Point firstMouseLocation, Point lastMouseLocation, int[] shapeDepth, boolean isDragged) {
        if (isDragged) {
            createObject(shapes, shapeDepth, e);
        }
        else{
            createObject(shapes, shapeDepth, e);
        }
    }

    public abstract void createObject(ArrayList<Shape> shapes, int[] shapeDepth, MouseEvent e);
}