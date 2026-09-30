/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exboxm;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.exboxm.AudioRequest;
import org.dsi.ifc.exboxm.ConnectionControl;
import org.dsi.ifc.exboxm.ExBoxState;
import org.dsi.ifc.exboxm.MobileDeviceLinkStatus;
import org.dsi.ifc.exboxm.PublicDeviceAddress;

public interface DSIExBoxMListener
extends DSIListener {
    public void responseDisplayControl(int var1, int var2);

    public void updateAudioRequest(AudioRequest var1, int var2);

    public void updateDisplayRequest(int var1, int var2);

    public void updateOperationState(int var1, int var2);

    public void responseVolumeRange(int var1);

    public void responseResetToFactory(int var1);

    public void responseConnectionControl(ConnectionControl var1);

    public void updateActiveSourceType(int var1, int var2);

    public void updateCurrentStationInfo(String var1, int var2, String var3, int var4, int var5, String var6, int var7, String var8, int var9, int var10);

    public void updateMobileDeviceLinkStatus(MobileDeviceLinkStatus var1, ExBoxState var2, int var3);

    public void updatePublicDeviceAddress(PublicDeviceAddress var1, int var2);
}

