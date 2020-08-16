package Shape.UMLLine;

import Shape.Shape;

import java.awt.Graphics2D;
import java.awt.*;

public abstract class BasicLine extends Shape{
    protected Point firstBasicObjectPortLocation;
    protected Point lastBasicObjectPortLocation;
    protected int thickness = 2;
    private int iconSize = 10;
    protected Point iconPoint0;
    protected Point iconPoint1;
    protected Point iconPoint2;

    public BasicLine(Point firstBasicObjectPortLocation,Point lastBasicObjectPortLocation,int depth){
        super(depth);
        this.firstBasicObjectPortLocation = firstBasicObjectPortLocation;
        this.lastBasicObjectPortLocation = lastBasicObjectPortLocation;
    }

    public void drawLine(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawLine(firstBasicObjectPortLocation.x, firstBasicObjectPortLocation.y, lastBasicObjectPortLocation.x, lastBasicObjectPortLocation.y);
    }

    public void setIconPoint(){
        Point vector = new Point();
        vector = subtract(lastBasicObjectPortLocation, firstBasicObjectPortLocation);
        vector = divide(multiply(vector, iconSize),(int)firstBasicObjectPortLocation.distance(lastBasicObjectPortLocation));
        iconPoint0 = subtract(lastBasicObjectPortLocation, vector);
        Point verticalVector = new Point(vector.y/2, - vector.x/2);
        iconPoint1 = add(divide(add(iconPoint0, lastBasicObjectPortLocation),2),verticalVector);
        iconPoint2 = subtract(divide(add(iconPoint0, lastBasicObjectPortLocation),2),verticalVector);
    }

    public Point subtract(Point p1, Point p2) {
        return new Point(p1.x - p2.x, p1.y - p2.y);
    }

    public Point add(Point p1, Point p2) {
        return new Point(p1.x + p2.x, p1.y + p2.y);
    }

    public Point multiply(Point p1, int number) {
        return new Point(p1.x * number, p1.y * number);
    }

    public Point divide(Point p1, int number) {
        return new Point(p1.x/ number, p1.y/ number);
    }

}