/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.MediaSourceSlot;

public interface ISourceResolver {
    default public MediaSourceSlot getSourceSlot(long l, long l2) {
    }

    default public MediaSourceSlot getSourceSlot(long l, String string) {
    }
}

