/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.concurrent;

public class ExecutionException
extends Exception {
    private static final long serialVersionUID;

    protected ExecutionException() {
    }

    protected ExecutionException(String string) {
        super(string);
    }

    public ExecutionException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public ExecutionException(Throwable throwable) {
        this(throwable == null ? null : throwable.toString(), throwable);
    }
}

