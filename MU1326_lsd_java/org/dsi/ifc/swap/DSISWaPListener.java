/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swap;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.swap.ConfigInfo;
import org.dsi.ifc.swap.SFscDetails;
import org.dsi.ifc.swap.SFscHistory;
import org.dsi.ifc.swap.SFscImportStatus;
import org.dsi.ifc.swap.SFscStatus;

public interface DSISWaPListener
extends DSIListener {
    public void updateSoftwareEnabling(int[] var1, int var2);

    public void updateIllegalFSCs(int[] var1, int var2);

    public void updateAreFSCsSigned(boolean var1, int var2);

    public void updateLimitedLifetime(boolean var1, int var2);

    public void updateConfigCheck(ConfigInfo var1, int var2);

    public void updateConfigPrepare(String var1, int var2);

    public void updateConfigFinalize(ConfigInfo var1, int var2);

    public void updateFscList(SFscStatus[] var1, int var2);

    public void encryptFile(String var1, int var2);

    public void checkSignature(boolean var1, String var2);

    public void getPublicKey(short[] var1, boolean var2);

    public void checkSingleFsc(int var1, int var2);

    public void decryptFile(String var1, int var2);

    public void getFscDetail(SFscDetails var1);

    public void importFSCs(int var1, SFscImportStatus var2);

    public void importFSCsList(int var1, SFscImportStatus[] var2);

    public void exportCCD(int var1);

    public void getHistory(SFscHistory var1);

    public void getHistoryList(SFscHistory[] var1);
}

