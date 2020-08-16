package Mode;

import Shape.Shape;

import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class SelectMode extends Mode{

    public void mouseReleased(MouseEvent e, ArrayList<Shape> shapes, Point firstMouseLocation, Point lastMouseLocation, int[] shapeDepth, boolean isDragged) {
        if (isDragged) {
            switchSelectMode(shapes, firstMouseLocation, lastMouseLocation);       
        }
        else{
            selectShape(shapes, e);       
        }
    }

    // switch mode C.1 or C.2
    public void switchSelectMode(ArrayList<Shape> shapes, Point firstMouseLocation, Point lastMouseLocation){
        if (isFirstLocationOnShape(shapes, firstMouseLocation)){
            moveShape(shapes, firstMouseLocation, lastMouseLocation);
        }
        else
            selectShapes(firstMouseLocation, lastMouseLocation, shapes);
    }

    // mode C.1
    public void selectShape(ArrayList<Shape> shapes, MouseEvent e){
        Shape tempShape;
        ArrayList<Shape> selectedShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.getBound().contains(e.getPoint())) {
                selectedShapes.add(shape); 
            }
        }
        if (!selectedShapes.isEmpty()){
            tempShape = selectedShapes.get(selectedShapes.size() - 1); 
            tempShape.selected = true;
            
        }
    }

    // mode C.2
    public Rectangle2D getSelectedArea(Point firstMouseLocation, Point lastMouseLocation){
        double x = Math.min(firstMouseLocation.getX(), lastMouseLocation.getX());
        double y = Math.min(firstMouseLocation.getY(), lastMouseLocation.getY());
        double width = Math.abs(lastMouseLocation.getX()-firstMouseLocation.getX());
        double height = Math.abs(lastMouseLocation.getY()-firstMouseLocation.getY());  
        return new Rectangle2D.Double(x, y, width, height);
    }

    public void selectShapes(Point firstMouseLocation, Point lastMouseLocation, ArrayList<Shape> shapes){
        Rectangle2D selectedArea = getSelectedArea(firstMouseLocation, lastMouseLocation);
        ArrayList<Shape> selectedShapes = new ArrayList<>();
        for (Shape shape : shapes) { 
            if (selectedArea.contains(shape.getBound().getBounds())) {
                selectedShapes.add(shape); 
            }
        }
        if (!selectedShapes.isEmpty()){
            for (Shape shape:selectedShapes){
                shape.selected = true;
            }
        }
    }

    // mode E
    public boolean isFirstLocationOnShape(ArrayList<Shape> shapes, Point firstMouseLocation){
        return isLocationOnShape(shapes, firstMouseLocation);
    }

    public void moveShape(ArrayList<Shape> shapes, Point firstMouseLocation, Point lastMouseLocation){
        Shape tempShape;
        ArrayList<Shape> selectedShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.getBound().contains(firstMouseLocation)) {
                selectedShapes.add(shape); 
            }
        }
        if (!selectedShapes.isEmpty()){
            tempShape = selectedShapes.get(selectedShapes.size() - 1); 
            double xMove = lastMouseLocation.getX() - firstMouseLocation.getX();
            double yMove = lastMouseLocation.getY() - firstMouseLocation.getY();
            tempShape.move(xMove, yMove);
        }
    }

    
}