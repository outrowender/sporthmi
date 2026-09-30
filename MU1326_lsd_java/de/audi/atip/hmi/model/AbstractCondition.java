/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

public abstract class AbstractCondition {
    private int id;
    private String name;

    public AbstractCondition(int n, String string) {
        this.id = n;
        this.name = string;
    }

    public AbstractCondition() {
    }

    public abstract int[] getModelIds();

    public abstract boolean evaluate(int var1);
}

