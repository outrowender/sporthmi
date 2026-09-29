/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap;

public class Enum {
    private final int ordinal;
    private final String name;

    protected Enum(String string, int n) {
        this.name = string;
        this.ordinal = n;
    }

    public String name() {
        return this.name;
    }

    public int ordinal() {
        return this.ordinal;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean equals(Object object) {
        return this == object;
    }

    public String toString() {
        return this.name;
    }
}

