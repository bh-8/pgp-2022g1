package blatt4.dekorierte_logger;

public class ConsoleLogger extends AbstractLoggingDecorator {
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