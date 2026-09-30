/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

public class EALException
extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EALException() {
    }

    public EALException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public EALException(String string) {
        super(string);
    }

    public EALException(Throwable throwable) {
        super(throwable);
    }
}

