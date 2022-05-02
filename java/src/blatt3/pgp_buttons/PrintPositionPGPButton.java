package blatt3.pgp_buttons;

import java.awt.*;

public class PrintPositionPGPButton extends PGPButton {
    public PrintPositionPGPButton(String label) {
        super(label);
    }

    @Override
    public void click() {
        Point p = this.getLocation();
        System.out.println("I'm the button at (" + p.x + ", " + p.y + ")!");
    }
}

