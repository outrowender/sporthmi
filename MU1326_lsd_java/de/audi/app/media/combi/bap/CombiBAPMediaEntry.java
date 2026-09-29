/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.esolutions.fw.util.commons.Buffer;

public class CombiBAPMediaEntry {
    final long entryID;
    final int entryContentType;
    final int entryFlags;
    final MediaListEntry entry;

    public CombiBAPMediaEntry(long l, int n, int n2, MediaListEntry mediaListEntry) {
        this.entryID = l;
        this.entryContentType = n;
        this.entryFlags = n2;
        this.entry = mediaListEntry;
    }

    public long getEntryID() {
        return this.entryID;
    }

    public int getEntryContentType() {
        return this.entryContentType;
    }

    public int getEntryFlags() {
        return this.entryFlags;
    }

    public MediaListEntry getEntry() {
        return this.entry;
    }

    public String getFilename() {
        return this.entry != null ? this.entry.getFilename().getOriginalString() : "";
    }

    public boolean isProtected() {
        return (this.entryFlags & 2) == 2;
    }

    public boolean isCorrupt() {
        return (this.entryFlags & 4) == 4;
    }

    public boolean isDeadLink() {
        return (this.entryFlags & 8) == 8;
    }

    public boolean isSelected() {
        return (this.entryFlags & 0x20) == 32;
    }

    public boolean isPartlySelected() {
        return (this.entryFlags & 0x40) == 64;
    }

    public boolean isImportRunning() {
        return (this.entryFlags & 0x80) == 128;
    }

    public boolean isImportPending() {
        return (this.entryFlags & 0x100) == 256;
    }

    public boolean isNoPlaybackDuringImport() {
        return (this.entryFlags & 0x200) == 512;
    }

    public boolean isImported() {
        return (this.entryFlags & 0x400) == 1024;
    }

    public boolean isPartiallyImported() {
        return (this.entryFlags & 0x800) == 2048;
    }

    public boolean equals(Object object) {
        try {
            CombiBAPMediaEntry combiBAPMediaEntry = (CombiBAPMediaEntry)object;
            return combiBAPMediaEntry.getEntryID() == this.entryID && combiBAPMediaEntry.getEntryContentType() == this.entryContentType;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public int hashCode() {
        return (int)this.entryID + this.entryContentType * 10000;
    }

    public String toString() {
        Buffer buffer = new Buffer(50);
        buffer.append("[CombiMediaEntry: '");
        buffer.append(this.entryID);
        buffer.append("','");
        buffer.append(this.entryContentType);
        buffer.append("','");
        buffer.append(this.entryFlags);
        buffer.append("','");
        buffer.append(this.getFilename());
        buffer.append("']");
        return buffer.toString();
    }
}

