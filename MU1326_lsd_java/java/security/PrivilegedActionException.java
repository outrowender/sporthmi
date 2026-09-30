/*
 * Decompiled with CFR 0.152.
 */
package java.security;

public class PrivilegedActionException
extends Exception {
    private static final long serialVersionUID = 4724086851538908602L;
    private Exception exception;

    public PrivilegedActionException(Exception exception) {
        super(null, exception);
        this.exception = exception;
    }

    public Exception getException() {
        return this.exception;
    }

    public String toString() {
        return String.valueOf(super.toString()) + ": " + this.exception;
    }

    public Throwable getCause() {
        return this.exception;
    }
}

