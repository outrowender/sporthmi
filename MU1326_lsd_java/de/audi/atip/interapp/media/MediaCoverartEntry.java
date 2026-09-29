/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;

public class MediaCoverartEntry {
    private final long entryId;
    private final ResourceLocator coverart;

    public MediaCoverartEntry(long l, ResourceLocator resourceLocator) {
        this.entryId = l;
        this.coverart = resourceLocator;
    }

    public long getEntryId() {
        return this.entryId;
    }

    public ResourceLocator getCoverart() {
        return this.coverart;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[MediaCoverartEntry: entryID='").append(this.entryId).append("', coverart='").append(this.coverart).append("']");
        return buffer.toString();
    }
}

