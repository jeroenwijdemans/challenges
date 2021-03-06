package nl.wijdemans.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class SingleRenderer extends Graphics2DRenderer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WindowFrame.class);



    public abstract void render(Graphics2D g2);

    @Override
    protected int sleepUntilNext() {
        return 60*1000;
    }

}
