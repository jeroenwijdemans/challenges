package nl.wijdemans.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExitListener extends WindowAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExitListener.class);

    public void windowClosing(WindowEvent event) {
        LOGGER.info("Exiting system");
        System.exit(0);
    }

}