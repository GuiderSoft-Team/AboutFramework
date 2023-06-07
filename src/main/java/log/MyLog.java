package log;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public interface MyLog<T extends Class<T>> {

    Logger logger = LogManager.getLogger(MyLog.class);;

    default void setupLogger(T t) {
        //Logger logger = LogManager.getLogger(t);
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

}
