/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.dsi.media.MediaListEntry;

public interface IEvoTransferController {
    public static final MediaListEntry[] NO_TRANSFER_FOLDER = null;
    public static final long NO_ENTRY_ID = -1L;
    public static final int NO_CONTENT_TYPE = -1;
    public static final boolean CDDAContent = true;
    public static final boolean DATAContent = false;
    public static final int FOLDER = 0;
    public static final int FILE = 1;
    public static final int PHYSICAL_FOLDER = 2;
    public static final int FILE_IN_PHYSICAL_FOLDER = 3;

    public void startTransfer(boolean var1, int var2, MediaListEntry[] var3, long var4, int var6);
}

