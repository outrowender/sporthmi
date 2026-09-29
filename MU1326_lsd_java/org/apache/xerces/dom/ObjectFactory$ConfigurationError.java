/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

final class ObjectFactory$ConfigurationError
extends Error {
    static final long serialVersionUID;
    private Exception exception;

    ObjectFactory$ConfigurationError(String string, Exception exception) {
        super(string);
        this.exception = exception;
    }

    Exception getException() {
        return this.exception;
    }
}

