package blatt4.dekorierte_logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logging {
    public static void main(String[] args) {
        Logger log = new LeveledLogger(LogLevel.Info, new TimestampedLogger(new ConsoleLogger(new FileLogger("log.txt"))));
        log.info("Hello, world!"); // 2019-05-02T12:03:25.519 [Info]: Hello, world!
        log.warn("Some warning");  // 2019-05-02T12:03:25.678 [Warn]: Some warning
        log.trace("This will be filtered");  // no output
    }
}

enum LogLevel {
    Trace,
    Debug,
    Info,
    Warn,
    Error;
}

interface Logger {
    default void trace(String format, Object... args) {
        this.log(LogLevel.Trace, format, args);
    }
    default void debug(String format, Object... args) {
        this.log(LogLevel.Debug, format, args);
    }
    default void info(String format, Object... args) {
        this.log(LogLevel.Info, format, args);
    }
    default void warn(String format, Object... args) {
        this.log(LogLevel.Warn, format, args);
    }
    default void error(String format, Object... args) {
        this.log(LogLevel.Error, format, args);
    }
    default void setLogLevel(LogLevel level) {

    }
    void log(LogLevel level, String format, Object... args);
}

abstract class AbstractLoggingDecorator implements Logger {
    private Logger logger;

    public AbstractLoggingDecorator() {
        this(null);
    }

    public AbstractLoggingDecorator(Logger loggingInterface) {
        this.logger = loggingInterface;
    }

    @Override
    public void log(LogLevel level, String format, Object... args) {
        if(this.logger != null) {
            this.logger.log(level, format, args);
        }
    }
}

class ConsoleLogger extends AbstractLoggingDecorator {
    public ConsoleLogger() {
        super();
    }

    public ConsoleLogger(Logger loggingInterface) {
        super(loggingInterface);
    }

    @Override
    public void log(LogLevel level, String format, Object... args) {
        super.log(level, format, args);
        System.out.println(String.format(format, args));
    }
}

class FileLogger extends AbstractLoggingDecorator {
    FileWriter fileWriter;

    public FileLogger(String filePath) {
        this(filePath, null);
    }

    public FileLogger(String filePath, Logger loggingInterface) {
        super(loggingInterface);

        File file = new File(filePath);
        try {
            this.fileWriter = new FileWriter(file, true);
        } catch(IOException e) {
            this.fileWriter = null;
        }
    }

    @Override
    public void log(LogLevel level, String format, Object... args) {
        super.log(level, format, args);

        if(this.fileWriter != null) {
            try {
                this.fileWriter.append(String.format(format, args) + "\n");
                this.fileWriter.flush();
            } catch(IOException e) {
                System.out.println("FileLogger can not write to file!");
            }
        }
    }
}

class TimestampedLogger extends AbstractLoggingDecorator {
    public TimestampedLogger() {
        super();
    }

    public TimestampedLogger(Logger loggingInterface) {
        super(loggingInterface);
    }

    @Override
    public void log(LogLevel level, String format, Object... args) {
        LocalDateTime date = LocalDateTime.now();
        String timestamp = date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        super.log(level, timestamp + " " + format, args);
    }
}

class LeveledLogger extends AbstractLoggingDecorator {
    private LogLevel logLevel;

    public LeveledLogger(LogLevel level) {
        this(level, null);
    }

    public LeveledLogger(LogLevel level, Logger loggingInterface) {
        super(loggingInterface);

        this.logLevel = level;
    }

    @Override
    public void log(LogLevel level, String format, Object... args) {
        if(level.compareTo(this.logLevel) >= 0) {
            super.log(level, "[" + level.toString() + "]: " + format, args);
        }
    }
}