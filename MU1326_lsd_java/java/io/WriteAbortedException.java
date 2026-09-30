/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.ObjectStreamException;

public class WriteAbortedException
extends ObjectStreamException {
    private static final long serialVersionUID = -3326426625597282442L;
    public Exception detail;

    public WriteAbortedException(String string, Exception exception) {
        super(string);
        this.detail = exception;
        this.initCause(exception);
    }

    public String getMessage() {
        String string = super.getMessage();
        if (this.detail != null) {
            string = String.valueOf(string) + "; " + this.detail.toString();
        }
        return string;
    }

    public Throwable getCause() {
        return this.detail;
    }
}

