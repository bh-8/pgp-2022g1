package blatt3.pgp_buttons;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrintClickHistoryPGPButton extends PGPButton {
    private List<Date> timestamps;
    private SimpleDateFormat sdf;

    public PrintClickHistoryPGPButton(String label) {
        super(label);
        this.timestamps = new ArrayList<>();
        this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }

    @Override
    public void click() {
        this.timestamps.add(new Date());

        for(Date d : this.timestamps) {
            System.out.println("I was clicked at " + this.sdf.format(d) + "!");
        }
    }
}
