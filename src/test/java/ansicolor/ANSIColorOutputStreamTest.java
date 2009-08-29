package ansicolor;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ANSIColorOutputStreamTest implements ANSIColor {

    private OutputStream out = new ByteArrayOutputStream();
    private ANSIDevice testDevice = new DebugDevice(out);
    private PrintStream ansi = new PrintStream(new ANSIColorOutputStream(out, testDevice));

    private String color(int col) {
        return "" + (char)ESC + "" + (char)BRACKET + "" + col + "" + (char)M;
    }

    @Test
    public void shoulPrintRegularString() {
        ansi.print("hello");
        assertEquals("hello", out.toString());
    }

    @Test
    public void shouldPrintRedStrings() {
        ansi.print(color(RED) + "hello" + color(RESET));
        assertEquals("{31}hello{0}", out.toString());
    }

    @Test
    public void shouldPrintRedBoldStrings() {
        ansi.print(color(RED) + color(BOLD) + "hello" + color(RESET));
        assertEquals("{31}{1}hello{0}", out.toString());
    }
}
