/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdlprogress;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public interface DSISwdlProgressReply {
    public static final String IPL_COMM_UUID = "3503d547-697f-53c6-9dc6-9aa9d8c5e20a";
    public static final String IPL_COMM_INTERFACE_KEY = "672abe51-3beb-5644-9610-3ea590ee4d91";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.6";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.6";

    public void updateGeneralProgress(GeneralProgress var1, int var2) throws MethodException;

    public void updateDevicesOverviewProgress(DeviceOverviewProgress[] var1, int var2) throws MethodException;

    public void updateTriggerPanel(int var1, int var2) throws MethodException;

    public void updateLostDevices(String[] var1, int var2) throws MethodException;

    public void updateOverviewStatus(int var1, int var2) throws MethodException;

    public void updateActiveDevices(String[] var1, int var2) throws MethodException;

    public void getStaticProgressDetails(int var1, int var2, short var3, String var4) throws MethodException;

    public void getDynamicProgressDetails(int var1, byte var2, String var3) throws MethodException;

    public void indicatePopUp(int var1, String var2, byte var3, int var4, int var5, String var6) throws MethodException;

    public void indicateDismissPopUp(int var1, String var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

