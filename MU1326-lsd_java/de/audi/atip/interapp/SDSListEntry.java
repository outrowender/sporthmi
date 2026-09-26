/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.esolutions.fw.util.commons.Buffer;

public class SDSListEntry {
    protected String name;
    protected long id;
    protected int children;

    public SDSListEntry(String string, long l) {
        this.name = string;
        this.id = l;
        this.children = -1;
    }

    public SDSListEntry(String string, long l, int n) {
        this.name = string;
        this.id = l;
        this.children = n;
    }

    public String getName() {
        return this.name;
    }

    public long getId() {
        return this.id;
    }

    public int getChildren() {
        return this.children;
    }

    public String toString() {
        return new Buffer().append(this.id).append(" <--> \"").append(this.name).append('\"').toString();
    }
}

