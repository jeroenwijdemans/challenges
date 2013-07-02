package nl.wijdemans.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class WindowFrame {

    private static final Logger LOGGER = LoggerFactory.getLogger(WindowFrame.class);

    private final Canvas canvas;
    private final Renderer renderer;

    public WindowFrame(Frame frame, Canvas canvas, Renderer renderer) {
        this.canvas = canvas;
        this.renderer = renderer;

        renderer.run(canvas, frame.getWidth(), frame.getHeight());
    }

//    private static class WindowPanel extends JPanel {
//
//        private final Renderer renderer;
//
//        public WindowPanel(Renderer renderer) {
//            this.renderer = renderer;
//        }
//
//        @Override
//        public void paint(Graphics graphics) {
//            super.paintComponent(graphics);
//            Graphics2D g2= (Graphics2D) graphics;
//
//            renderer.startRendering(g2);
//        }
//    }

    public static class Builder {

        private final Dimension dimension;
        private String title;
        private Color backgroundColor = Color.WHITE;
        private Renderer renderer;
//        private Container content;

        private Builder(Dimension dimension) {
            this.dimension = dimension;
        }

        public static Builder withDimension(Dimension dimension) {
            return new Builder(dimension);
        }

        public static Builder withDimension(int width, int height) {
            return withDimension(new Dimension(width, height));
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withBackgroundColor(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder withRenderer(Renderer renderer) {
            this.renderer = renderer;
            return this;

        }

        public WindowFrame build() {

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                LOGGER.error("Error setting native LAF.", e);
            }

            JFrame frame = new JFrame(title);
            frame.setIgnoreRepaint(true);

            frame.setBackground(backgroundColor);

            frame.setPreferredSize(dimension);
            frame.setSize(dimension);
            frame.pack();
            frame.addWindowListener(new ExitListener());


            Canvas canvas = new Canvas();
            canvas.setIgnoreRepaint(true);
            canvas.setSize(dimension);
            canvas.setBackground(backgroundColor);
            frame.add(canvas);


            frame.setVisible(true);
            frame.setResizable(false);

            frame.pack();


            canvas.createBufferStrategy(2);

            canvas.requestFocus();

            return new WindowFrame(frame, canvas, renderer);
        }

    }

}
