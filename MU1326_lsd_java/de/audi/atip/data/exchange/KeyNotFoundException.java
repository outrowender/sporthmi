/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.exchange;

public class KeyNotFoundException
extends Exception {
    private static final long serialVersionUID = -5155657051720597688L;
    private final int key;

    public KeyNotFoundException(int n) {
        super("Key " + n + " not found!");
        this.key = n;
    }

    public int getKey() {
        return this.key;
    }
}

