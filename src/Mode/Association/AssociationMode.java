package Mode.Association;

import Mode.*;
import Shape.UMLObject.*;
import Shape.Shape;
import Shape.Port;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public abstract class AssociationMode extends Mode{    

    public void mouseReleased(MouseEvent e, ArrayList<Shape> shapes, Point firstMouseLocation, Point lastMouseLocation, int[] shapeDepth, boolean isDragged) {
        if (isDragged) {
            createLine(shapes, firstMouseLocation, lastMouseLocation, shapeDepth);
        }
    }

    public Shape pointGetShape(ArrayList<Shape> shapes, Point point){
        ArrayList<Shape> selectedShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.getBound().contains(point)) {
                selectedShapes.add(shape); 
            }
        }
        if (!selectedShapes.isEmpty()){
            return selectedShapes.get(selectedShapes.size() - 1); 
        }
        return null;
    }

    public boolean canCreateLine(ArrayList<Shape> shapes, Point firstMouseLocation, Point lastMouseLocation){
        return isLocationOnShape(shapes, firstMouseLocation) && isLocationOnShape(shapes, lastMouseLocation) && pointGetShape(shapes, firstMouseLocation) != pointGetShape(shapes, lastMouseLocation) && pointGetShape(shapes, firstMouseLocation) instanceof BasicObject && pointGetShape(shapes, lastMouseLocation) instanceof BasicObject;
    }

    public int getPortNumber(ArrayList<Shape> shapes, Point point){
        int portNumber = 0;
        for (Port port: pointGetShape(shapes, point).ports){
            if (port.portArea.contains(point)) {
                portNumber = ((BasicObject)pointGetShape(shapes, point)).ports.indexOf(port);
            }
        }
        return portNumber; 
    }

    public abstract void createLine(ArrayList<Shape> shapes, Point firstMouseLocation, Point lastMouseLocation, int[] shapeDepth);

}