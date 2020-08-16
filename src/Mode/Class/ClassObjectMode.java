package Mode.Class;

import Shape.Shape;
import Shape.UMLObject.*;

import java.util.*;
import java.awt.event.*;

public class ClassObjectMode extends ClassMode{
    public void createObject(ArrayList<Shape> shapes, int[] shapeDepth, MouseEvent e){
        shapes.add(new ClassObject(e.getPoint(), shapeDepth[0], 80, 160));
        shapeDepth[0] -= 1;
    }
}