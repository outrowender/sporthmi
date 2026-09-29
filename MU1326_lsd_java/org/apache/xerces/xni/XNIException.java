/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni;

public class XNIException
extends RuntimeException {
    static final long serialVersionUID;
    private Exception fException;

    public XNIException(String string) {
        super(string);
    }

    public XNIException(Exception exception) {
        super(exception.getMessage());
        this.fException = exception;
    }

    public XNIException(String string, Exception exception) {
        super(string);
        this.fException = exception;
    }

    public Exception getException() {
        return this.fException;
    }
}

