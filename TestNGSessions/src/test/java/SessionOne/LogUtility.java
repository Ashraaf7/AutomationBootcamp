    package SessionOne;

    import org.apache.logging.log4j.LogManager;
    import org.apache.logging.log4j.Logger;

    public class LogUtility {
        public final static Logger LOGGER = LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString());

    }
