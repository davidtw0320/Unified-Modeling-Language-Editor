package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Shape.Shape;
import Shape.UMLObject.BasicObject;
import Shape.GroupShape;

import java.util.*;


public class Menu extends JMenuBar{
    private JMenu file, edit;
    private JMenuItem changeName, group, ungroup;
    private Canvas canvas;
    
    public Menu(Canvas canvas){
        this.canvas = canvas;
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        super.add(file);
        super.add(edit);

        changeName = new JMenuItem("Change object name");
        changeName.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                String objectName = JOptionPane.showInputDialog(canvas, "change object name:", "change object name", JOptionPane.QUESTION_MESSAGE); 
                ArrayList<Shape> selectedShapes = getSelectedShapes();
                if (selectedShapes.size() == 1 && objectName != null && selectedShapes.get(0) instanceof BasicObject)
                    ((BasicObject)(selectedShapes.get(0))).objectName = objectName;
                else if (selectedShapes.size() != 1 && objectName != null)
                    JOptionPane.showMessageDialog(canvas, "please select one object", "error", JOptionPane.ERROR_MESSAGE);
                canvas.repaint();
            }
        });

        group = new JMenuItem("Group objects");
        group.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                ArrayList<Shape> selectedShapes = getSelectedShapes();
                GroupShape groupShape = new GroupShape(getMinimumDepth(selectedShapes));
                if (selectedShapes.size() > 1){
                    for (Shape shape: selectedShapes){
                        groupShape.add(shape);
                        canvas.shapes.remove(shape);
                    }
                    canvas.shapes.add(groupShape);
                }
                else{
                    JOptionPane.showMessageDialog(canvas, "please select at least two objects", "error", JOptionPane.ERROR_MESSAGE);
                }
                canvas.repaint();
            }
        });

        ungroup = new JMenuItem("Ungroup objects");
        ungroup.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                ArrayList<Shape> selectedShapes = getSelectedShapes();
                if (selectedShapes.size() == 1){
                    Shape selectedShape = selectedShapes.get(0);
                    for (Shape shape : selectedShape.getChild()){
                        canvas.shapes.add(shape);
                    }
                    canvas.shapes.remove(selectedShape);
                }
                else{
                    JOptionPane.showMessageDialog(canvas, "please select one object", "error", JOptionPane.ERROR_MESSAGE);
                }
                canvas.repaint();
            }
        });

        edit.add(changeName);
        edit.add(group);
        edit.add(ungroup);
    }

    public ArrayList<Shape> getSelectedShapes(){
        ArrayList<Shape> selectedShapes = new ArrayList<>();
        for (Shape shape : canvas.shapes){
            if(shape.selected)
                selectedShapes.add(shape);
        }
        return selectedShapes;
    }

    public int getMinimumDepth(ArrayList<Shape> selectedShapes){
        int min = 100;
        for (Shape shape : selectedShapes){
            if(shape.depth < 100)
                min = shape.depth;
        }
        return min;
    }
}