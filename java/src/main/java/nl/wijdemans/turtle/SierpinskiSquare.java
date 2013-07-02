package nl.wijdemans.turtle;

import nl.wijdemans.util.ContinuousRenderer;
import nl.wijdemans.util.WindowFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class SierpinskiSquare {

    private static final Logger LOGGER = LoggerFactory.getLogger(SierpinskiSquare.class);

    public static void main(String arg[]) {
        new SierpinskiSquare();
    }

    public SierpinskiSquare() {
        WindowFrame.Builder.withDimension(1200, 900)
                .withTitle("Sierpiński Square")
                .withBackgroundColor(Color.WHITE)
                .withRenderer(new Triangle())
                .build();
    }

    private class Triangle extends ContinuousRenderer {

        private volatile int counter = 0;
        private final Color FILLED = new Color(114, 186, 85);
        private final Color TAKEN = new Color(0, 0, 0);

        @Override
        public void render(Graphics2D g2) {
            g2.setFont(new Font("Courier New", Font.PLAIN, 16));
            g2.setColor(Color.RED);
            g2.drawString(String.format("Sierpiński Square: t %s", counter), 300, 20);

            double side = 650;
            double startX = 100;
            double startY = 100;
            fillSquare(g2, startX, startY, side, FILLED);

            for (int c = 0; c < counter; c++) {
                for (int i = 0; i < Math.pow(3, c); i++) {
                    for (int j = 0; j < Math.pow(3, c); j++) {
                        double x = startX + side * i ;
                        double y = startY + side * j ;
                        LOGGER.trace("Calculate square (i,j) ({},{}) at (x,y) ({},{}) of counter {}", i, j, x, y, c);
                        if (i % 3 == 1 && j % 3 == 1) {
                            LOGGER.trace("Removing (i,j) ({},{}) at (x,y) ({},{}) with side {} of counter {}", i, j, x, y, side, c);
                            fillSquare(g2, x, y, side, TAKEN);
                        }
                    }
                }
                side = side / 3;
                LOGGER.trace("New side {}", side);
            }
            LOGGER.debug("Bumping version ...");
            counter++;
            LOGGER.debug("Counter is {}", counter);

        }

        private void fillSquare(Graphics2D g2, double x, double y, double side, Color color) {
            g2.setColor(color);
            g2.fillRect((int) x, (int) y, (int) (side), (int) (side));
        }

        @Override
        protected int sleepUntilNext() {
            return 1000;
        }
    }
}
