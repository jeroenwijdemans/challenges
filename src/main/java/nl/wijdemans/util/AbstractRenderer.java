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
        Graphics2D graphics2D = null;
        Graphics graphics = null;

        while (true) {
            try {
                graphics2D = bufferedImage.createGraphics();

                prepareRendering(graphics2D);
                this.render(graphics2D);

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
                if (graphics2D != null)
                    graphics2D.dispose();
            }

        }
    }

    private void prepareRendering(Graphics2D g2) {
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2.setRenderingHints(rh);

        // display frames per second...
        g2.setFont(new Font("Courier New", Font.PLAIN, 12));
        g2.setColor(Color.GREEN);
        g2.drawString(String.format("Rendering: %s", sleepUntilNext()), 20, 20);

    }


    protected abstract int sleepUntilNext();
}
