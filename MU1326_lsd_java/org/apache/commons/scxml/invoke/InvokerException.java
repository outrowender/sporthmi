/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.invoke;

public class InvokerException
extends Exception {
    private static final long serialVersionUID = 1L;

    public InvokerException() {
    }

    public InvokerException(String string) {
        super(string);
    }

    public InvokerException(Throwable throwable) {
        super(throwable);
    }

    public InvokerException(String string, Throwable throwable) {
        super(string, throwable);
    }
}

