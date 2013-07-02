package nl.wijdemans.util;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Graphics2DRenderer extends AbstractRenderer {

    abstract public void render(Graphics2D gg);

    @Override
    public void render(BufferedImage bufferedImage) {
        Graphics2D graphics2D = null;
        try {
            graphics2D = bufferedImage.createGraphics();

            prepareRendering(graphics2D);
            this.render(graphics2D);
        } finally {
            if (graphics2D != null)
                graphics2D.dispose();

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

}
