/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.source.ISourceSlot;

public interface ITransferItem {
    public static final int INVALID = -1;

    public boolean isFolder();

    public long getEntryId();

    public int getContentType();

    public boolean isContentTypeCDDA();

    public MediaListEntry[] getTransferFolder();

    public boolean isPhysicalFolder();

    public boolean isDeletionSource();

    public boolean isDynamicTransferFolder();

    public ISourceSlot getTransferSourceSlot();
}

