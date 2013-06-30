package nl.wijdemans.util;

import java.awt.*;

public class ContinuousRenderer implements Renderer {

    private final Callback callback;

    public ContinuousRenderer(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void startRendering(Graphics2D g2) {
        while (true) {
            try {
                Thread.sleep(250);
                callback.paint(g2);
            } catch (InterruptedException e) {
                throw new RuntimeException("Error - stopping", e);
            }
        }

    }
}
