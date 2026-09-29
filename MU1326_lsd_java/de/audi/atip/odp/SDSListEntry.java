/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

public class SDSListEntry {
    private String name;
    private long id;

    public SDSListEntry(String string, long l) {
        this.name = string;
        this.id = l;
    }

    public String getName() {
        return this.name;
    }

    public long getId() {
        return this.id;
    }
}

