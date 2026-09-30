/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public class ExceptionInInitializerError
extends LinkageError {
    private static final long serialVersionUID = 1521711792217232256L;
    private Throwable exception;

    public ExceptionInInitializerError() {
        this.initCause(null);
    }

    public ExceptionInInitializerError(String string) {
        super(string);
        this.initCause(null);
    }

    public ExceptionInInitializerError(Throwable throwable) {
        this.exception = throwable;
        this.initCause(throwable);
    }

    public Throwable getException() {
        return this.exception;
    }

    public Throwable getCause() {
        return this.exception;
    }
}

