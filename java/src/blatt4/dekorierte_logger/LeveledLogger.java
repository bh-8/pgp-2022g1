package blatt4.dekorierte_logger;

public class LeveledLogger extends AbstractLoggingDecorator {
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