/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.powermanagement;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.powermanagement.ClampSignal;

public interface DSIPowerManagementReply {
    public static final String IPL_COMM_UUID = "6f03b6fa-61a3-550e-b68d-542d13666d43";
    public static final String IPL_COMM_INTERFACE_KEY = "8fff252e-ea27-52bc-8f1f-2bc868ac2c70";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.13";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.13";

    public void updatePowerManagementState(int var1, int var2, int var3) throws MethodException;

    public void updatePowerManagementStateRight(int var1, int var2, int var3) throws MethodException;

    public void updateBEMState(int var1, int var2) throws MethodException;

    public void updateTelMaxPopup(boolean var1, int var2) throws MethodException;

    public void updateTStandbyPopup(boolean var1, int var2) throws MethodException;

    public void updateClampSignal(ClampSignal var1, int var2) throws MethodException;

    public void updateRVCActive(boolean var1, int var2) throws MethodException;

    public void updateChildLockState(int var1, int var2) throws MethodException;

    public void updateLastOn(int var1, int var2) throws MethodException;

    public void updateSplashScreenAnimation(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

