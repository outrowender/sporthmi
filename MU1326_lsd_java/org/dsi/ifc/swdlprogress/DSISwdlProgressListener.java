/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdlprogress;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public interface DSISwdlProgressListener
extends DSIListener {
    public void updateGeneralProgress(GeneralProgress var1, int var2);

    public void updateDevicesOverviewProgress(DeviceOverviewProgress[] var1, int var2);

    public void updateTriggerPanel(int var1, int var2);

    public void updateLostDevices(String[] var1, int var2);

    public void updateOverviewStatus(int var1, int var2);

    public void updateActiveDevices(String[] var1, int var2);

    public void getStaticProgressDetails(int var1, int var2, short var3, String var4);

    public void getDynamicProgressDetails(int var1, byte var2, String var3);

    public void indicatePopUp(int var1, String var2, byte var3, int var4, int var5, String var6);

    public void indicateDismissPopUp(int var1, String var2);
}

