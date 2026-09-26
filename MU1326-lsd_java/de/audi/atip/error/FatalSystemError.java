/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

public class FatalSystemError
extends Error {
    private static final long serialVersionUID;
    private Throwable cause;

    public FatalSystemError() {
    }

    public FatalSystemError(String string, Throwable throwable) {
        super(string);
        this.cause = throwable;
    }

    @Override
    public Throwable getCause() {
        return this.cause;
    }
}

