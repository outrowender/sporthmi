/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.source.MediaSourceSlot;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.ListEntry;

public interface IMediaRecorderListener {
    public void sourceSlotActivated(MediaSourceSlot var1);

    public void responseSetSelection(int var1, boolean var2);

    public void updateDatabaseSpace(DatabaseSpace var1);

    public void updateDeletionProgress(long var1);

    public void updateDeletionStatus(int var1);

    public void updateImportProgress(long var1, ListEntry var3);

    public void updateImportStatus(int var1);

    public void updateImportSummary(long var1, long var3, long var5, long var7, long var9, long var11);

    public void responseSetEncodingQuality(int var1);

    public void asyncException(int var1, String var2, int var3);

    public void dsiServiceRemoved();
}

