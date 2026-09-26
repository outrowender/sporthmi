/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.storage;

public abstract class NoSuchDataException
extends RuntimeException {
    private static final long serialVersionUID;
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

    @Override
    public String toString() {
        return new StringBuffer().append("Namespace=").append(this.getNamespace()).append(" Key=").append(this.getKey()).append(" Cause: ").append(this.getMessage()).toString();
    }
}

