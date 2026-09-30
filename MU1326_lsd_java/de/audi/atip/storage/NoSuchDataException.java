/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.storage;

public abstract class NoSuchDataException
extends RuntimeException {
    private static final long serialVersionUID = -1777840130593173511L;
    private int namespace;
    private long key;

    protected NoSuchDataException(int n, long l, String string) {
        super(string);
        this.namespace = n;
        this.key = l;
    }

    public int getNamespace() {
        return this.namespace;
    }

    public long getKey() {
        return this.key;
    }

    public String toString() {
        return "Namespace=" + this.getNamespace() + " Key=" + this.getKey() + " Cause: " + this.getMessage();
    }
}

