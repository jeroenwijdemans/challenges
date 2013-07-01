package nl.wijdemans.util;

import java.awt.*;

public interface Renderer {

    void render(Graphics2D gg);

    void run(Canvas canvas, int width, int height );

}
