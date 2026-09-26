/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl.dv;

public class DatatypeException
extends Exception {
    static final long serialVersionUID;
    protected String key;
    protected Object[] args;

    public DatatypeException(String string, Object[] objectArray) {
        super(string);
        this.key = string;
        this.args = objectArray;
    }

    public String getKey() {
        return this.key;
    }

    public Object[] getArgs() {
        return this.args;
    }

    @Override
    public String getMessage() {
        String string = new StringBuffer().append("Data type exception: key is ").append(this.key).append(".").toString();
        return string;
    }
}

