/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.dsi.media.MediaListEntry;

public interface IEvoTransferController {
    public static final MediaListEntry[] NO_TRANSFER_FOLDER = null;
    public static final long NO_ENTRY_ID;
    public static final int NO_CONTENT_TYPE;
    public static final boolean CDDAContent;
    public static final boolean DATAContent;
    public static final int FOLDER;
    public static final int FILE;
    public static final int PHYSICAL_FOLDER;
    public static final int FILE_IN_PHYSICAL_FOLDER;

    default public void startTransfer(boolean bl, int n, MediaListEntry[] mediaListEntryArray, long l, int n2) {
    }
}

