package blatt3.pgp_buttons;

import java.awt.*;
import java.util.Random;

public class RecolorPGPButton extends PGPButton {
    private Random random;

    public RecolorPGPButton(String label) {
        super(label);
        this.random = new Random();
    }

    @Override
    public void click() {
        Color c = new Color(
                this.random.nextInt(255),
                this.random.nextInt(255),
                this.random.nextInt(255));
        this.setBackground(c);
        System.out.println("Set color to (" + c.getRed() + ", " + c.getGreen() + ", " + c.getBlue() + ")!");
    }
}
