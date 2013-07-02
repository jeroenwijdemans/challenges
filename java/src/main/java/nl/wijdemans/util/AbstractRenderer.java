package nl.wijdemans.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public abstract class AbstractRenderer implements Renderer {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRenderer.class);

    @Override
    public void run(Canvas canvas, int width, int height) {
        BufferStrategy strategy = canvas.getBufferStrategy();

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();

        // Create off-screen drawing surface
        BufferedImage bufferedImage = gc.createCompatibleImage(width, height);

        // Objects needed for rendering...
        Graphics graphics = null;

        while (true) {
            try {


                render(bufferedImage);


                // Blit image and flip...
                graphics = strategy.getDrawGraphics();
                graphics.drawImage(bufferedImage, 0, 0, null);
                if (!strategy.contentsLost())
                    strategy.show();


                Thread.sleep(sleepUntilNext());
            } catch (InterruptedException e) {
                LOGGER.error("Error during sleep - ignoring this", e);
            }
            finally {
                if (graphics != null)
                    graphics.dispose();
            }

        }
    }

    abstract public void render(BufferedImage bufferedImage);

    protected abstract int sleepUntilNext();
}
