package Shape.UMLObject;

import Shape.Shape;
import Shape.Port;

import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.*;

public abstract class BasicObject extends Shape{
    public Point location;
    private int PortObjectDistance = 4;
    protected int thickness = 2;
    private Path2D triangle;
    protected int width;
    protected int height;
    public String objectName;
    protected int fontSize = 10;
    
    public BasicObject(Point location, int depth, int width, int height){
        super(depth);
        this.location = location;
        this.width = width;
        this.height = height;
    }

    // port
    public Path2D getPortArea(Point point1, Point point2, Point point3){
        triangle = new Path2D.Double();
    	triangle.moveTo(point1.x, point1.y);
    	triangle.lineTo(point2.x, point2.y);
    	triangle.lineTo(point3.x, point3.y);
        triangle.closePath();
        return triangle;
    }

    public void initializePortAreaPoints(){
        portAreaPoints.add(new Point(location.x-width/2, location.y-height/2));
        portAreaPoints.add(new Point(location.x, location.y));
        portAreaPoints.add(new Point(location.x, location.y-height));
        portAreaPoints.add(new Point(location.x-width, location.y-height));
        portAreaPoints.add(new Point(location.x-width, location.y));
    }

    public void initializePorts(){
        initializePortAreaPoints();
        ports.add(new Port(new Point(location.x+thickness, location.y-height/2), getPortArea(portAreaPoints.get(0), portAreaPoints.get(1), portAreaPoints.get(2))));
        ports.add(new Port(new Point(location.x-width/2-PortObjectDistance, location.y-height-PortObjectDistance-thickness),getPortArea(portAreaPoints.get(0), portAreaPoints.get(2), portAreaPoints.get(3))));
        ports.add(new Port(new Point(location.x-width-PortObjectDistance-thickness, location.y-height/2),getPortArea(portAreaPoints.get(0), portAreaPoints.get(3), portAreaPoints.get(4))));
        ports.add(new Port(new Point(location.x-width/2, location.y+thickness), getPortArea(portAreaPoints.get(0), portAreaPoints.get(4), portAreaPoints.get(1))));
    }

    public void setPortAreaPoints(){
        for (Point portsAreaPoint:portAreaPoints){
            switch(portAreaPoints.indexOf(portsAreaPoint)){
                case 0:
                    portsAreaPoint.setLocation(location.x-width/2, location.y-height/2);
                    break;
                case 1:
                    portsAreaPoint.setLocation(location.x, location.y);
                    break;
                case 2:
                    portsAreaPoint.setLocation(location.x, location.y-height);
                    break;
                case 3:
                    portsAreaPoint.setLocation(location.x-width, location.y-height);
                    break;
                case 4:
                    portsAreaPoint.setLocation(location.x-width, location.y);
                    break;
            }
        }
    }

    public void setPorts(){
        setPortAreaPoints();
        for (Port port:ports){
            switch(ports.indexOf(port)){
                case 0:
                    port.location.setLocation(location.x+thickness, location.y-height/2);
                    port.portArea = getPortArea(portAreaPoints.get(0), portAreaPoints.get(1), portAreaPoints.get(2));
                    break;
                case 1:
                    port.location.setLocation(location.x-width/2-PortObjectDistance, location.y-height-PortObjectDistance-thickness);
                    port.portArea = getPortArea(portAreaPoints.get(0), portAreaPoints.get(2), portAreaPoints.get(3));
                    break;
                case 2:
                    port.location.setLocation(location.x-width-PortObjectDistance-thickness, location.y-height/2);
                    port.portArea = getPortArea(portAreaPoints.get(0), portAreaPoints.get(3), portAreaPoints.get(4));
                    break;
                case 3:
                    port.location.setLocation(location.x-width/2, location.y+thickness);
                    port.portArea = getPortArea(portAreaPoints.get(0), portAreaPoints.get(4), portAreaPoints.get(1));
                    break;
            }
        }
    }

    public void showPorts(Graphics2D g2d) {
        for ( Port port : ports){
            g2d.setColor(Color.BLACK);
            g2d.fillRect(port.location.x, port.location.y, port.portsSize, port.portsSize);
        }
    }

    // move
    public void move(double xMove, double yMove){
        location.x += (int) xMove;
        location.y += (int) yMove;
        setPorts();
    }

}