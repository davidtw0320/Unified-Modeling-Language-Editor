package Mode.Class;

import Shape.Shape;
import Shape.UMLObject.*;

import java.util.*;
import java.awt.event.*;

public class UseClassObjectMode extends ClassMode{
    public void createObject(ArrayList<Shape> shapes, int[] shapeDepth, MouseEvent e){
        shapes.add(new UseClassObject(e.getPoint(), shapeDepth[0], 160, 160));
        shapeDepth[0] -= 1;
    }
}