/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.connectedradio;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.connectedradio.RadioStation;

public interface DSIOnlineRadioListener
extends DSIListener {
    public void getRadioStationLogoResult(int var1, int var2, RadioStation var3, int var4);

    public void getStreamUrlResult(int var1, int var2, RadioStation var3);

    public void getMetaInformationResult(int var1, int var2, RadioStation var3);

    public void downloadDatabaseResult(int var1, int var2);

    public void cancelDownloadDatabaseResult(int var1, int var2);

    public void updateProfileState(int var1, int var2, int var3);

    public void profileChanged(int var1, int var2);

    public void profileCopied(int var1, int var2, int var3);

    public void profileReset(int var1, int var2);

    public void profileResetAll(int var1);
}

