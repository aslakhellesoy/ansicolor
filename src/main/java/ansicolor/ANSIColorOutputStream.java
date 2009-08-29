package ansicolor;

import ansicolor.windows.WindowsDevice;

import java.io.*;

public class ANSIColorOutputStream extends FilterOutputStream implements ANSIColor {

    // Stream states
    private static final int PLAIN = -1;
    private static final int COLOR_BUFFER_LENGTH = 2;

    private final ANSIDevice device;

    private int state = PLAIN;
    private int colorPos = COLOR_BUFFER_LENGTH - 1;
    private int[] colors = new int[COLOR_BUFFER_LENGTH];

    public static PrintStream ansifyStdout() {
        PrintStream ansiOut = new PrintStream(new ANSIColorOutputStream(System.out));
        System.setOut(ansiOut);
        return ansiOut;
    }

    public static PrintStream debugifyStdout() {
        PrintStream debugOut = new PrintStream(new ANSIColorOutputStream(System.out, new DebugDevice(System.out)));
        System.setOut(debugOut);
        return debugOut;
    }

    public ANSIColorOutputStream(OutputStream out) {
        this(out, new WindowsDevice());
    }

    public ANSIColorOutputStream(OutputStream out, ANSIDevice device) {
        super(out);
        this.device = device;
    }

    public void write(int b) throws IOException {
        if (b == ESC) {
            state = ESC;
        } else if (state == ESC && b == BRACKET) {
            state = BRACKET;
        } else if (state == BRACKET) {
            if (b != M) {
                if (colorPos < 0) {
                    throw new RuntimeException("Too many color bytes:");
                }
                colors[colorPos] = b;
                colorPos--;
            } else {
                flush();
                device.setAnsiColor(getAnsiColor());
                colorPos = COLOR_BUFFER_LENGTH - 1;
                state = PLAIN;
            }
        } else {
            super.write(b);
        }
    }

    public int getAnsiColor() {
        int ansiColor = 0;
        int multiplication = 1;
        for (int pos = colorPos + 1; pos < COLOR_BUFFER_LENGTH; pos++) {
            ansiColor += (colors[pos] - 48) * multiplication;
            multiplication *= 10;
        }
        return ansiColor;
    }
}