package blatt4.dekorierte_logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends AbstractLoggingDecorator {
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