package log;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log4j {
    private static final Logger logger = LogManager.getLogger(Log4j.class);

    public static void main(String[] args) {

        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        logger.info("Hello world");
        logger.info("we are in logger info mode");
        logger.warn("we are in logger warn mode");
        logger.error("we are in logger error mode");

    }
}
