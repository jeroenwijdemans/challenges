package nl.wijdemans.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public abstract class SingleRender implements Renderer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WindowFrame.class);

    @Override
    public void startRendering(Graphics2D g2) {

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2.setRenderingHints(rh);

        this.render(g2);

//        g2.setColor(Color.RED);
//        g2.drawString("The CustomCanvas is in the CENTER area", 10, 300 / 2);
//
//        g2.setColor(Color.BLUE);
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);
//
//        LOGGER.debug("repainting...");
//        g2.dispose();


    }

    public abstract void render(Graphics2D g2);
}
