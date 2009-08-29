package ansicolor.windows;

import ansicolor.ANSIDevice;
import ansicolor.ANSIColor;

public class WindowsDevice implements ANSIDevice, ANSIColor {
    // Win Colors
    static final int W_BLACK = 0;
    static final int W_BLUE = 1;
    static final int W_GREEN = 2;
    static final int W_RED = 4;
    static final int W_INTENSITY = 8;
    static final int W_CYAN = W_BLUE | W_GREEN;
    static final int W_MAGENTA = W_BLUE | W_RED;
    static final int W_YELLOW = W_GREEN | W_RED;
    static final int W_WHITE = W_BLUE | W_GREEN | W_RED;
    static final int[] ANSI2WIN = new int[]{
            W_BLACK,
            W_RED,
            W_GREEN,
            W_YELLOW,
            W_BLUE,
            W_MAGENTA,
            W_CYAN,
            W_WHITE
    };

    private final Console console;
    private final int initialColor;
    private int intensity = W_BLACK; // Can be W_WHITE or W_INTENSITY;

    public WindowsDevice(Console console) {
        this.console = console;
        this.initialColor = console.getConsoleColor();
    }

    public WindowsDevice() {
        this(new WindowsConsole());
    }

    public void setAnsiColor(int ansiColor) {
        int winColor = console.getConsoleColor();

        if (ansiColor == BOLD) {
            intensity = W_INTENSITY;
        } else if (ansiColor == RESET) {
            intensity = W_BLACK;
            winColor = initialColor;
        } else if (BLACK <= ansiColor && ansiColor <= WHITE) {
            winColor = ANSI2WIN[ansiColor - BLACK];
        } else if (ansiColor == 90) {
            // Special case for gray (it's really white)
            winColor = W_WHITE;
            intensity = W_BLACK;
        }
        console.setConsoleColor(winColor | intensity);
    }
}

