/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util.change;

public class ChangeEvent {
    private final Object source;

    public ChangeEvent(Object object) {
        this.source = object;
    }

    public Object getSource() {
        return this.source;
    }
}

