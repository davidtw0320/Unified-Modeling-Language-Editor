package GUI;

import Shape.Shape;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Canvas extends JPanel{
    public ArrayList<Shape> shapes = new ArrayList<>();
    private ArrayList<Point> mouseDraggedLocations = new ArrayList<>();
    private Point firstMouseLocation;
    private Point lastMouseLocation;
    public int[] shapeDepth = {100};

    public Canvas(ButtonPanel buttonPanel){
        setBackground(Color.white);
        setOpaque(true);
        
        addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                clearObjectsSelected(shapes);
                updateMouseFirstLastLocations(e);
                buttonPanel.buttonSet.get(buttonPanel.buttonIndex).mode.mouseReleased(e, shapes, firstMouseLocation, lastMouseLocation, shapeDepth, isDragged());
                repaint();
                clearMouseLocations();
            }
        });

        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                collectMouseLocations(e);
            }
        });

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Collections.sort( shapes, new Comparator<Shape>(){
            public int compare( Shape shape1, Shape shape2 )
            {
                return shape2.depth - shape1.depth;
            }
        });
        for (Shape shape : shapes) {
            shape.draw((Graphics2D) graphics);
        }
    }

    public void clearObjectsSelected(ArrayList<Shape> shapes){
        for (Shape shape : shapes) {
            shape.selected = false;
        }
    }
 
    public boolean isDragged(){
        if (mouseDraggedLocations.isEmpty())
            return false;
        else
            return true;
    }

    public void clearMouseLocations(){
        mouseDraggedLocations.clear();
    }

    public void collectMouseLocations(MouseEvent e){
        mouseDraggedLocations.add(e.getPoint());
    }

    public void updateMouseFirstLastLocations(MouseEvent e){
        if(isDragged()){
            firstMouseLocation = mouseDraggedLocations.get(0);
            lastMouseLocation = mouseDraggedLocations.get(mouseDraggedLocations.size()-1);
        }
        else{
            firstMouseLocation = e.getPoint();
            lastMouseLocation = e.getPoint();
        }
    }
 
}
