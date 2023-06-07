package log;

public class Log4jWithInterface implements MyLog{

    public static void main(String[] args) {

        new Log4jWithInterface().log();

    }

    public void log(){
        setupLogger(this.getClass());
        logger.info("Hello world");
        logger.info("we are in logger info mode");
        logger.warn("we are in logger warn mode");
        logger.error("we are in logger error mode");
        logger.error("we are in logger error mode");
        logger.error("we are in logger error mode");
        logger.error("we are in logger error mode");
        logger.error("we are in logger error mode");
        logger.error("we are in logger error mode");

    }
}
