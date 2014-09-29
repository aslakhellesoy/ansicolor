package ansicolor.windows;

import ansicolor.ANSIColorOutputStream;

import java.io.*;

class WindowsConsole implements Console {
    private static void setupShutdownHook(final WindowsConsole console) {
        final int initialColor = console.getConsoleColor();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                console.setConsoleColor(initialColor);
            }
        });
    }

    private static void loadEmbeddedLibrary() {
        System.load(extractDll());
    }

    public WindowsConsole() {
        loadEmbeddedLibrary();
        setupShutdownHook(this);
    }

    private static String extractDll() {
        try {
            File dll = File.createTempFile("WindowsConsole", ".dll");
            OutputStream dllOut = new BufferedOutputStream(new FileOutputStream(dll));
            String sourceDll;
            if (System.getProperty("os.arch") == "x86") {
              sourceDll = "/ansicolor/windows/WindowsConsole.dll";
            } else {
              sourceDll = "/ansicolor/windows/WindowsConsole64.dll";
            }
            InputStream in = ANSIColorOutputStream.class.getResourceAsStream(sourceDll);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                dllOut.write(buf, 0, len);
            }
            in.close();
            dllOut.close();
            return dll.getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException("Failed to extract dll", e);
        }
    }

    public native void setConsoleColor(int color);
    public native int getConsoleColor();
}
