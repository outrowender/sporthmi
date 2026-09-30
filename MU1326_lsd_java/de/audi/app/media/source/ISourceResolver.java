/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.MediaSourceSlot;

public interface ISourceResolver {
    public MediaSourceSlot getSourceSlot(long var1, long var3);

    public MediaSourceSlot getSourceSlot(long var1, String var3);
}

