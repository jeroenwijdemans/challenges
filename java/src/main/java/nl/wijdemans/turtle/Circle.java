package nl.wijdemans.turtle;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle {

    private final Ellipse2D.Double circle;
    private final Color color;

    public Circle(double x, double y, int radius, Color color) {
        this(x, y, (double) radius, color);
    }

    public Circle(Dimension location, int radius, Color color) {
        this(location, (double) radius, color);
    }

    public Circle(Dimension location, double radius, Color color) {
        this.color = color;
        circle = new Ellipse2D.Double(location.getWidth() - radius / 2, location.getHeight() - radius / 2, radius, radius);
    }

    public Circle(double x, double y, double radius, Color color) {
        this.color = color;
        circle = new Ellipse2D.Double(x - radius / 2, y - radius / 2, radius, radius);
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(color);
        graphics2D.fill(circle);
    }

}
