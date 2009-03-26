package ansicolor.windows;

import org.junit.Test;
import ansicolor.ANSIDevice;
import ansicolor.ANSIColor;
import static junit.framework.Assert.*;

public class WindowsDeviceTest implements ANSIColor {
    private Console c = new TestConsole();
    private ANSIDevice d = new WindowsDevice(c);

    @Test
    public void shouldConvertRed() {
        d.setAnsiColor(RED);
        assertEquals(WindowsDevice.W_RED, c.getConsoleColor());
    }

    @Test
    public void shouldConvertRedBold() {
        d.setAnsiColor(RED);
        d.setAnsiColor(BOLD);
        assertEquals((WindowsDevice.W_RED | WindowsDevice.W_INTENSITY), c.getConsoleColor());
    }

    @Test
    public void shouldConvertGray() {
        d.setAnsiColor(90);
        assertEquals((WindowsDevice.W_WHITE), c.getConsoleColor());
    }
}
