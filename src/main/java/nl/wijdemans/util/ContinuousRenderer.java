package nl.wijdemans.util;

import java.awt.*;
import java.awt.image.BufferStrategy;

public abstract class ContinuousRenderer implements Renderer {

    public int sleep = 250;
    private int i = 0;

    public ContinuousRenderer() {
    }

    @Override
    public void startRendering(Graphics2D incomming) {

//        BufferStrategy bufferStrategy = canvas.getBufferStrategy();

        Graphics2D g2 = incomming;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHints(rh);

        while (true) {
            try {

                g2.setFont(new Font("Courier New", Font.PLAIN, 12));
                g2.setColor(Color.GREEN);
                g2.drawString(String.format("Round " + i++), 20, 20);

                Thread.sleep(sleep);
                render(g2);
            } catch (InterruptedException e) {
                throw new RuntimeException("Error - stopping", e);
            }
        }

    }

    public abstract void render(Graphics2D g2);

}
