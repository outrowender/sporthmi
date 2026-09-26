/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

public class Predicates$Optional {
    private final Object object;

    public Predicates$Optional(Object object) {
        this.object = object;
    }

    public Object get() {
        return this.object;
    }

    public boolean exists() {
        return this.object != null;
    }
}

