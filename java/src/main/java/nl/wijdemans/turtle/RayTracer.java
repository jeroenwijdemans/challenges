package nl.wijdemans.turtle;

import nl.wijdemans.util.AbstractRenderer;
import nl.wijdemans.util.SingleRenderer;
import nl.wijdemans.util.WindowFrame;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * http://www.raytracegroundup.com/downloads.html
 */
public class RayTracer {

    public static void main(String[] args) {
        new RayTracer();
    }

    public RayTracer() {
        WindowFrame.Builder.withDimension(1200, 800).withTitle("Raytracer")
                .withRenderer(new FloatingBall(new Model(1200, 800)))
                .build();
    }

    private class FloatingBall extends AbstractRenderer {

        private final Model model;

        public FloatingBall(Model model) {
            this.model = model;
        }

        @Override
        public void render(BufferedImage bufferedImage) {

            for (int x = 0; x < model.getWidth(); x++) {
                for (int y = 0; y < model.getHeight(); y++) {
                    bufferedImage.setRGB(x, y, shootRay(model.getCamera(), new Point(x, y)));
                }
            }

        }


        private int x = -2;
        private int y = 1;

        private int shootRay(Point camera, Point point) {
//            System.out.println(Color.BLUE.getRGB());
//            System.out.println(Color.RED.getRGB());
//            System.out.println(Color.BLACK.getRGB());


//            return Color.BLACK.getRGB();
//            int r = x-=100 -  y % 1000;
//            System.out.println(r);
            return Color.BLACK.getRGB();
        }

        @Override
        protected int sleepUntilNext() {
            return 10 * 1000 * 1000;
        }

    }

    class Model {

        private Point camera = new Point(600, -300);
        private final int width;
        private final int height;

        public Model(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public Point getCamera() {
            return camera;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }


    }

}
