/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.exchange;

public class KeyNotFoundException
extends Exception {
    private static final long serialVersionUID;
    private final int key;

    public KeyNotFoundException(int n) {
        super(new StringBuffer().append("Key ").append(n).append(" not found!").toString());
        this.key = n;
    }

    public int getKey() {
        return this.key;
    }
}

