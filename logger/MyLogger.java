package exam.logger;

import java.io.IOException;
import java.util.logging.*;

public class MyLogger {

    public static Logger myLoggerWithFileHandler() {
        Logger LOGGER = Logger.getLogger(MyLogger.class.getName());
        LOGGER.setUseParentHandlers(false);
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("C:\\Users\\1\\IdeaProjects\\javaStepIT4\\src\\log.log");
            MyFormatter formatter = new MyFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return LOGGER;
    }
}

class MyFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return record.getLevel() + ": " + record.getMessage() + "\n";
    }
}
