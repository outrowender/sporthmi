/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.SDSListEntry;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;

public class IMediaSDSService$MediaSDSListEntry
extends SDSListEntry {
    private final int sourceID;
    private final int slot;
    private final ResourceLocator cover;
    private final String nameSecondRow;

    public IMediaSDSService$MediaSDSListEntry(String string, long l, int n) {
        this(string, l, n, null);
    }

    public IMediaSDSService$MediaSDSListEntry(String string, long l, int n, int n2, int n3) {
        this(string, null, l, n, n2, n3, null);
    }

    public IMediaSDSService$MediaSDSListEntry(String string, String string2, long l, int n, ResourceLocator resourceLocator) {
        this(string, string2, l, n, -1, -1, resourceLocator);
    }

    public IMediaSDSService$MediaSDSListEntry(String string, long l, int n, ResourceLocator resourceLocator) {
        this(string, null, l, n, -1, -1, resourceLocator);
    }

    public IMediaSDSService$MediaSDSListEntry(String string, String string2, long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
        super(string, l, n);
        this.nameSecondRow = string2;
        this.sourceID = n2;
        this.slot = n3;
        this.cover = resourceLocator;
    }

    public int getSourceID() {
        return this.sourceID;
    }

    public int getSlot() {
        return this.slot;
    }

    public ResourceLocator getCover() {
        return this.cover;
    }

    public String getNameSecondRow() {
        return this.nameSecondRow;
    }

    @Override
    public String toString() {
        return new Buffer().append(super.toString()).append("{").append(this.nameSecondRow == null ? "null" : this.nameSecondRow).append('}').toString();
    }
}

