package ansicolor;

import java.io.OutputStream;
import java.io.PrintStream;

public class DebugDevice implements ANSIDevice {
    private final PrintStream out;

    public DebugDevice(OutputStream out) {
        this.out = new PrintStream(out);
    }

    public void setAnsiColor(int ansiColor) {
        out.print("{" + ansiColor + "}");
    }
}
