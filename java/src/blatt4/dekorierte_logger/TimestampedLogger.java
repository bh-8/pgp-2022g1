package blatt4.dekorierte_logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampedLogger extends AbstractLoggingDecorator {
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