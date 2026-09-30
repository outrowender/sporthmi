/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdlselection;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.swdlselection.LameClient;

public interface DSISwdlSelectionListener
extends DSIListener {
    public void updateLameClients(LameClient[] var1, int var2);

    public void updateEngineering(boolean var1, int var2);

    public void updateUserSwdl(boolean var1, int var2);

    public void updateRingNotOK(boolean var1, int var2);

    public void updateEndDownload(boolean var1, int var2);

    public void updateAvailableMedia(byte var1, int var2);

    public void updateUnitType(int var1, int var2);

    public void getMedia(int[] var1);

    public void storeNfsIpAddress(String var1);

    public void storeNfsPath(String var1);

    public void storeFsPath(String var1);

    public void setMedium(int var1, String var2, String[] var3);

    public void setRelease(int var1, String var2);

    public void getUserDefinedAllowed(boolean var1);

    public void setTargetLanguage(short var1);

    public void getIncompatibleDevices(String[] var1, String[] var2);

    public void startVersionUpload(boolean var1);

    public void checkConsistency(int var1, boolean var2, String var3, int var4);

    public void abortSetMedium();

    public void abortSetRelease();

    public void getFinalizeTargets(int[] var1);

    public void setFinalizeTarget(int var1, long var2, long var4, long var6);

    public void enterComponentUpdateConfirmation();
}

