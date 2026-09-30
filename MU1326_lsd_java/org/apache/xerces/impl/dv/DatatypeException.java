/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl.dv;

public class DatatypeException
extends Exception {
    static final long serialVersionUID = 1940805832730465578L;
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

    public String getMessage() {
        String string = "Data type exception: key is " + this.key + ".";
        return string;
    }
}

