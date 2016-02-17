package java4.fun.jsr344;

public class BinaryLiteralsInSwitch {

    public static void main(String... args) {

        int command = 12;

        final int input = command & 0b11100000;

        switch (input) {
            case 0b00100000:System.out.println(input);
            case 0b01000000:System.out.println(input);
            case 0b01100000:System.out.println(input);
            case 0b10100000:System.out.println(input);
            case 0b11000000:System.out.println(input);
            default:throw new IllegalArgumentException("O valor eh : " + input);
        }
    }
}
