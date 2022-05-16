package blatt5;

public class Functional {
    public static final int BIN = 0;
    public static final int OCT = 1;
    public static final int DEC = 2;
    public static final int HEX = 3;

    public static String numFormat(int number, int codec) {
        switch(codec){
            case BIN:
                return String.format("0b%s\n", Integer.toBinaryString(number));
            case OCT:
                return String.format("0o%s\n", Integer.toOctalString(number));
            case DEC:
                return String.format("%d\n", number);
            case HEX:
                return String.format("0x%s\n", Integer.toHexString(number));
            default:
                return String.format("unknown codec '%d'\n", codec);
        }
    }

    public static void main(String[] args) {
        System.out.print(numFormat(0, DEC));
        System.out.print(numFormat(1337, BIN));
        System.out.print(numFormat(1337, OCT));
        System.out.print(numFormat(1337, DEC));
        System.out.print(numFormat(1337, HEX));
    }

    /**
     * Kontext: Umgebung des Programms
     * Seiteneffekte: Änderung des Kontextes durch Funktionen
     */
}