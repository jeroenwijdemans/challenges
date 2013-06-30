package nl.wijdemans.turtle;

import java.awt.*;

public class FilledVerticalLine {

    private final Dimension dimension;
    private final double thickness;
    private final double length;
    private final Color color;

    public FilledVerticalLine(double x, double y, double thickness, double length, Color color) {
        this.dimension = new Dimension((int) x, (int) y);
        this.thickness = thickness;
        this.length = length;
        this.color = color;

    }

    public void draw(Graphics2D g2) {
        int t = (((int) thickness == 0) ? 1 : (int) thickness);
        final BasicStroke bs1 = new BasicStroke(t, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        g2.setStroke(bs1);
        g2.setColor(color);
        g2.drawRect((int) dimension.getWidth(), (int) dimension.getHeight(), t, (int) length);
    }
}
