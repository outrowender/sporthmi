/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.parser;

import org.apache.xerces.xni.XNIException;

public class XMLConfigurationException
extends XNIException {
    static final long serialVersionUID;
    public static final short NOT_RECOGNIZED;
    public static final short NOT_SUPPORTED;
    protected short fType;
    protected String fIdentifier;

    public XMLConfigurationException(short s, String string) {
        super(string);
        this.fType = s;
        this.fIdentifier = string;
    }

    public XMLConfigurationException(short s, String string, String string2) {
        super(string2);
        this.fType = s;
        this.fIdentifier = string;
    }

    public short getType() {
        return this.fType;
    }

    public String getIdentifier() {
        return this.fIdentifier;
    }
}

