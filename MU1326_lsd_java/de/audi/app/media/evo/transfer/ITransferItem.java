/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.source.ISourceSlot;

public interface ITransferItem {
    public static final int INVALID;

    default public boolean isFolder() {
    }

    default public long getEntryId() {
    }

    default public int getContentType() {
    }

    default public boolean isContentTypeCDDA() {
    }

    default public MediaListEntry[] getTransferFolder() {
    }

    default public boolean isPhysicalFolder() {
    }

    default public boolean isDeletionSource() {
    }

    default public boolean isDynamicTransferFolder() {
    }

    default public ISourceSlot getTransferSourceSlot() {
    }
}

