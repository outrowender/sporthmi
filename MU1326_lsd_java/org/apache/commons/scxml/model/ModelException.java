/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

public class ModelException
extends Exception {
    private static final long serialVersionUID = 1L;

    public ModelException() {
    }

    public ModelException(String string) {
        super(string);
    }

    public ModelException(Throwable throwable) {
        super(throwable);
    }

    public ModelException(String string, Throwable throwable) {
        super(string, throwable);
    }
}

