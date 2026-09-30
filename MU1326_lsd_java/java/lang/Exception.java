/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public class Exception
extends Throwable {
    private static final long serialVersionUID = -3387516993124229948L;

    public Exception() {
    }

    public Exception(String string) {
        super(string);
    }

    public Exception(String string, Throwable throwable) {
        super(string, throwable);
    }

    public Exception(Throwable throwable) {
        super(throwable);
    }
}

