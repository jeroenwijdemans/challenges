package nl.wijdemans.turtle;

import nl.wijdemans.util.Callback;
import nl.wijdemans.util.ContinuousRenderer;
import nl.wijdemans.util.SingleRender;
import nl.wijdemans.util.WindowFrame;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Tree {

    public static void main(String args[]) {
        new Tree();
    }

    public Tree() {
        WindowFrame.Builder.withDimension(1200, 900)
                .withTitle("Growing Tree")
                .withBackgroundColor(Color.WHITE)
                .withRenderer(new TreeRenderer())
                .build();

    }

    private class TreeTimeRenderer extends ContinuousRenderer {

        private int timeTick = 0;

        public TreeTimeRenderer() {
            super.sleep = 1000;
        }

        @Override
        public void render(Graphics2D g2) {
            Line trunk = new Line(600, 850, 200, new NormalizedVector(0, -1, 270));
            drawBranch(g2, trunk, timeTick++);
        }


        private void drawBranch(Graphics2D g2, Line v, int counter) {
            g2.setColor(Color.red);
            g2.drawLine((int) v.getX(), (int) v.getY(), (int) v.getEndX(), (int) v.getEndY());  //To change body of created methods use File | Settings | File Templates.

            if (counter > 0) {
                for (Line child : v.getChildren()) {
                    drawBranch(g2, child, counter-1);
                }
            }
        }

    }

    private class TreeRenderer extends SingleRender {

        private Graphics2D g2;

        @Override
        public void render(Graphics2D g2) {
            this.g2 = g2;

            Line trunk = new Line(600, 850, 200, new NormalizedVector(0, -1, 270));
            drawBranch(trunk, 12);
        }

        private void drawBranch(Line v, int counter) {
            g2.setColor(Color.red);
            g2.drawLine((int) v.getX(), (int) v.getY(), (int) v.getEndX(), (int) v.getEndY());  //To change body of created methods use File | Settings | File Templates.

            if (counter > 0) {
                for (Line child : v.getChildren()) {
                    drawBranch(child, counter-1);
                }
            }
        }

    }

    class NormalizedVector {
        private final double x;
        private final double y;
        private final double theta;

        public NormalizedVector(double x, double y, double theta) {
            this.x = x;
            this.y = y;
            this.theta = theta;
        }
    }

    class Line {
        final double x;
        final double y;
        final int power;
        private final NormalizedVector normalizedVector;

        Line(double x, double y, int power, NormalizedVector normalizedVector) {
            this.x = x;
            this.y = y;
            this.power = power;
            this.normalizedVector = normalizedVector;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getEndY() {
            return y + normalizedVector.y * power;
        }

        public double getEndX() {
            return x + normalizedVector.x * power;
        }

        static final double degToRad = Math.PI / 180;
        private final int degreesChange = 35;

        public List<Line> getChildren() {
            List<Line> children = new ArrayList<Line>();

            // how was it done again? Bit of Trigonometry here
            // http://books.google.nl/books?id=AP5wXYbn4CYC&pg=PA191&lpg=PA191&dq=trigonometric+functions+java+sin&source=bl&ots=lLJ-ISExvs&sig=ynGTRlAAv4Lq6lEEwz_vFhw3Ask&hl=en&sa=X&ei=poLQUdaxMMjWsga8uoCQBw&ved=0CDMQ6AEwATgK#v=onepage&q=trigonometric%20functions%20java%20sin&f=false
            double theta = (this.normalizedVector.theta - degreesChange) * degToRad;
            children.add(new Line(getEndX(), getEndY(), power * 3 / 4, new NormalizedVector(Math.cos(theta), Math.sin(theta), this.normalizedVector.theta - 20)));
            theta = (this.normalizedVector.theta + degreesChange) * degToRad;
            children.add(new Line(getEndX(), getEndY(), power * 3 / 4, new NormalizedVector(Math.cos(theta), Math.sin(theta), this.normalizedVector.theta + 20)));

            return children;
        }
    }
}
