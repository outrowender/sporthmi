/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xs;

public class XSException
extends RuntimeException {
    static final long serialVersionUID;
    public short code;
    public static final short NOT_SUPPORTED_ERR;
    public static final short INDEX_SIZE_ERR;

    public XSException(short s, String string) {
        super(string);
        this.code = s;
    }
}

