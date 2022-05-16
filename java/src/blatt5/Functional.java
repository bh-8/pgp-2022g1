package blatt5;

public class Functional {
    public static final int BIN = 0;
    public static final int OCT = 1;
    public static final int DEC = 2;
    public static final int HEX = 3;

    public static void print(int number, int codec) {
        switch(codec){
            case BIN:
                System.out.format("0b%s\n", Integer.toBinaryString(number));
                return;
            case OCT:
                System.out.format("0o%s\n", Integer.toOctalString(number));
                return;
            case DEC:
                System.out.format("%d\n", number);
                return;
            case HEX:
                System.out.format("0x%s\n", Integer.toHexString(number));
                return;
            default:
                System.err.format("unknown codec '%d'\n", codec);
        }
    }

    public static void main(String[] args) {
        print(0, DEC);
        print(1337, BIN);
        print(1337, OCT);
        print(1337, DEC);
        print(1337, HEX);
    }

    /**
     * Kontext: Umgebung des Programms
     * Seiteneffekte: Änderung des Kontextes durch Funktionen
     */
}