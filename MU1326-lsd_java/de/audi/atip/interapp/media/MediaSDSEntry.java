/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.esolutions.fw.util.commons.Buffer;

public class MediaSDSEntry {
    private final long entryID;
    private final String name;

    public MediaSDSEntry(long l, String string) {
        this.entryID = l;
        this.name = string;
    }

    public long getEntryID() {
        return this.entryID;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[MediaSDSEntry: entryID='").append(this.entryID).append("',name='").append(this.name).append("']");
        return buffer.toString();
    }
}

