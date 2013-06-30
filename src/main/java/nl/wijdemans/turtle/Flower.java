package nl.wijdemans.turtle;

import nl.wijdemans.util.SingleRender;
import nl.wijdemans.util.WindowFrame;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Flower {

    public static void main(String[] arg) {
        new Flower();
    }

    public Flower() {
        WindowFrame.Builder.withDimension(1200, 800)
                .withTitle("turtle flower")
                .withRenderer(new FlowerPainter())
                .build();
    }

    class FlowerPainter extends SingleRender {

        private static final int AMOUNT_OF_FLOWERS = 190;
        private static final int HORIZON_HEIGHT = 150;

        private final Color PURPLE = new Color(135, 23, 223);
        private final Color DARK_PINK = new Color(189, 11, 98);
        private final Color PINK = new Color(246, 109, 195);
        private final Color RED = new Color(189, 0, 4);
        private final Color GREEN = new Color(81, 195, 21);

        @Override
        public void render(Graphics2D g2) {

            drawLandscape(g2);

            Random random = new Random();
            List<FlowerHolder> flowers = new ArrayList<FlowerHolder>();
            for (int i = 0; i < AMOUNT_OF_FLOWERS; i++) {
                int y = (int) drawGuassianYValue(random);
                int x = random.nextInt(1200);

                flowers.add(new FlowerHolder(x, y));
            }

            Collections.sort(flowers);

            for (FlowerHolder flowerHolder : flowers) {
                drawFlowerAt(g2, flowerHolder.getX(), flowerHolder.getY());
            }

        }

        private double drawGuassianYValue(Random random) {
            double g = random.nextGaussian() / 3;
            g = Math.abs(g);
            if (g > 1.0) {
                return drawGuassianYValue(random);
            }
            return (800 - HORIZON_HEIGHT - 100) * g + HORIZON_HEIGHT;
        }

        class FlowerHolder implements Comparable<FlowerHolder> {

            private final int x;
            private final int y;

            public FlowerHolder(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int getX() {
                return x;
            }

            public int getY() {
                return y;
            }

            // don't paint over flowers that are closer
            @Override
            public int compareTo(FlowerHolder flowerHolder) {
                if (this.y > flowerHolder.getY()) {
                    return 1;
                }
                if (this.y == flowerHolder.getY()) {
                    return 0;
                }
                return -1;
            }
        }

        private void drawLandscape(Graphics2D g2) {
            g2.setColor(new Color(223, 248, 205));
            g2.fillRect(0, HORIZON_HEIGHT, 1500, 1000);

            g2.setColor(new Color(131, 240, 248));
            g2.fillRect(0, 0, 1500, HORIZON_HEIGHT);
        }

        private void drawFlowerAt(Graphics2D g2, int x, int y) {
            if (y < HORIZON_HEIGHT) {
                y = HORIZON_HEIGHT;
            }

            double size = ((800.0) / (800 - y) );
            size = Math.log(size) * 7;
            System.out.println("size " + size + " y: " + y);
            this.drawFlowerAtWithSize(g2, x, y, size);
        }

        private void drawFlowerAtWithSize(Graphics2D g2, int x, int y, double size) {
//            new FilledVerticalLine(448, 360), size / 10, size * 6, GREEN).draw(g2);
            createLeaf(x, y, size).draw(g2);

            new Circle(x - size, y - size, size * 3, PURPLE).draw(g2);
            new Circle(x + size, y - size, size * 3, PURPLE).draw(g2);
            new Circle(x - size, y + size, size * 3, PURPLE).draw(g2);
            new Circle(x + size, y + size, size * 3, PURPLE).draw(g2);

            new Circle(x, y - size, size * 2.5, DARK_PINK).draw(g2);
            new Circle(x, y + size, size * 2.5, DARK_PINK).draw(g2);
            new Circle(x - size, y, size * 2.5, DARK_PINK).draw(g2);
            new Circle(x + size, y, size * 2.5, DARK_PINK).draw(g2);

            new Circle(x - (size / 2), y - (size / 2), size * 2, PINK).draw(g2);
            new Circle(x + (size / 2), y - (size / 2), size * 2, PINK).draw(g2);
            new Circle(x - (size / 2), y + (size / 2), size * 2, PINK).draw(g2);
            new Circle(x + (size / 2), y + (size / 2), size * 2, PINK).draw(g2);

            new Circle(x, y, size * 1.5, RED).draw(g2);
        }

        FilledVerticalLine createLeaf(double x, double y, double size) {
            double think = size / 10;
            System.out.println("t: " + think);
            return new FilledVerticalLine(x - (think / 2), y + (think / 2), think, size * 6, GREEN);
        }

    }

}
