/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DownloadInfo;

public interface DSIAdbVCardExchangeListener
extends DSIListener {
    public void updateExportCount(DownloadInfo var1, int var2);

    public void updateImportCount(DownloadInfo var1, int var2);

    public void importVCardResult(int var1, int var2, int var3, int var4);

    public void exportVCardResult(int var1, int var2, int var3, int var4);

    public void exportSpellerVCardResult(int var1, int var2, int var3, int var4, int var5);

    public void createVCardResult(int var1, long[] var2, int var3, String var4);

    public void parseVCardResult(int var1, AdbEntry[] var2);

    public void responseAbort(int var1);
}

