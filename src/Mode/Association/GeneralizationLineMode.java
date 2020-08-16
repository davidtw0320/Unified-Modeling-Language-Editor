package Mode.Association;


import java.util.*;
import Shape.Shape;
import java.awt.*;
import Shape.UMLLine.*;

public class GeneralizationLineMode extends AssociationMode{
    public void createLine(ArrayList<Shape> shapes, Point firstMouseLocation, Point lastMouseLocation, int[] shapeDepth){
        if (canCreateLine(shapes, firstMouseLocation, lastMouseLocation)){
            Shape firstShape = pointGetShape(shapes, firstMouseLocation);
            Shape lastShape = pointGetShape(shapes, lastMouseLocation);
            Point firstShapePortLocation = firstShape.ports.get(getPortNumber(shapes, firstMouseLocation)).location;
            Point lastShapePortLocation = lastShape.ports.get(getPortNumber(shapes, lastMouseLocation)).location;
            shapes.add(new GeneralizationLine(firstShapePortLocation, lastShapePortLocation, shapeDepth[0]));
            }
        shapeDepth[0] -= 1;
    }
}