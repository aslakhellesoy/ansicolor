package ansicolor;

public interface ANSIColor {
    static final int ESC     = 27;  // \e
    static final int BRACKET = 91;  // [
    static final int M       = 109; // m

    static final int RESET   = 0;
    static final int BOLD    = 1;
    static final int BLACK   = 30;
    static final int RED     = 31;
    static final int GREEN   = 32;
    static final int YELLOW  = 33;
    static final int BLUE    = 34;
    static final int MAGENTA = 35;
    static final int CYAN    = 36;
    static final int GRAY    = 37;
    static final int WHITE   = 37;
}
