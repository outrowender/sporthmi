/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public interface DSIMediaBaseListener
extends DSIListener {
    public void updateParentalML(int var1, int var2);

    public void updatePreferredLanguage(String var1, int var2);

    public void updateMediaList(MediaInfo[] var1, int var2);

    public void updateDeviceList(DeviceInfo[] var1, int var2);

    public void updateCustomerUpdate(int var1, int var2);

    public void updateApplicationVersion(String var1, int var2);

    public void updateMetadataDBVersion(String var1, int var2);

    public void responseResetFactorySettings(int var1, boolean var2);

    public void launchAppResult(long var1, long var3, String var5, boolean var6);

    public void updateProfileState(int var1, int var2, int var3);

    public void profileChanged(int var1, int var2);

    public void profileCopied(int var1, int var2, int var3);

    public void profileReset(int var1, int var2);

    public void profileResetAll(int var1);
}

