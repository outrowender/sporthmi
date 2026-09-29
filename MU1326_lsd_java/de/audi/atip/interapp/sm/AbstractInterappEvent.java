/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.sm;

import de.audi.atip.interapp.sm.IInterappEvent;

public abstract class AbstractInterappEvent
implements IInterappEvent {
    private int id;
    private int data;

    public AbstractInterappEvent(int n, int n2) {
        this.id = n;
        this.data = n2;
    }

    @Override
    public int getData() {
        return this.data;
    }

    @Override
    public int getId() {
        return this.id;
    }
}

