package Shape.UMLLine;

import java.awt.*;
import java.awt.geom.Path2D;

public class AssociationLine extends BasicLine{
    private Path2D icon;

    public AssociationLine(Point firstBasicObjectPortLocation, Point lastBasicObjectPortLocation, int depth){
        super(firstBasicObjectPortLocation, lastBasicObjectPortLocation, depth);
    }

    public void drawIcon(Graphics2D g2d){
        setIconPoint();
        icon = new Path2D.Double();
    	icon.moveTo(lastBasicObjectPortLocation.x, lastBasicObjectPortLocation.y);
        icon.lineTo(iconPoint1.x, iconPoint1.y);
        icon.moveTo(lastBasicObjectPortLocation.x, lastBasicObjectPortLocation.y);
        icon.lineTo(iconPoint2.x, iconPoint2.y);
        g2d.draw( icon );
		g2d.setColor(Color.BLACK);
		g2d.fill(icon);
    }

    public void draw(Graphics2D g2d) {
        drawLine(g2d);
        drawIcon(g2d);
    }

}