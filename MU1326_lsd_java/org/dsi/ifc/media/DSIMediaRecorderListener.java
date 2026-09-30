/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.ListEntry;

public interface DSIMediaRecorderListener
extends DSIListener {
    public void updateActiveMedia(long var1, long var3, int var5);

    public void responseSetSelection(int var1, boolean var2);

    public void updateImportSummary(long var1, long var3, long var5, long var7, long var9, long var11, int var13);

    public void updateImportProgress(long var1, ListEntry var3, int var4);

    public void updateImportStatus(int var1, int var2);

    public void updateDeletionProgress(long var1, int var3);

    public void updateDeletionStatus(int var1, int var2);

    public void updateDatabaseSpace(DatabaseSpace var1, int var2);

    public void updateTargetMedia(long var1, long var3, int var5);

    public void responseSetEncodingQuality(int var1);
}

