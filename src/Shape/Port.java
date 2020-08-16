package Shape;

import java.awt.*;
import java.awt.geom.Path2D;

public class Port {
    public Point location;
    public Path2D portArea;
    public int portsSize = 5;

    public Port(Point location, Path2D portArea){
        this.location = location;
        this.portArea = portArea;
    }

}