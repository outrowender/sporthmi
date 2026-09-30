/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.telephone.ActivationStateStruct;
import org.dsi.ifc.telephone.LockStateStruct;
import org.dsi.ifc.telephone.NADTemperatureStruct;
import org.dsi.ifc.telephone.NetworkProvider;
import org.dsi.ifc.telephone.NetworkProviderName;
import org.dsi.ifc.telephone.PhoneInformation;
import org.dsi.ifc.telephone.RegisterStateStruct;
import org.dsi.ifc.telephone.ServiceProvider;

public interface DSINADReply {
    public static final String IPL_COMM_UUID = "744f9c7a-3f01-5ae1-a600-1f677f1c9032";
    public static final String IPL_COMM_INTERFACE_KEY = "a1072e44-3963-5f62-9f7a-427c15ebcd0f";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.27";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.27";

    public void responseAbortNetworkRegistration(int var1) throws MethodException;

    public void responseAbortNetworkSearch(int var1) throws MethodException;

    public void responseChangeSIMCode(int var1, int var2) throws MethodException;

    public void responseSIMPINRequired(int var1) throws MethodException;

    public void updateSIMPINRequired(boolean var1, int var2) throws MethodException;

    public void responseNetworkRegistration(int var1) throws MethodException;

    public void responseNetworkSearch(NetworkProvider[] var1, int var2) throws MethodException;

    public void responseUnlockSIM(int var1) throws MethodException;

    public void responseCheckSIMPINCode(int var1) throws MethodException;

    public void responseRestoreFactorySettings(int var1) throws MethodException;

    public void responseTelPower(int var1) throws MethodException;

    public void responseSetAutomaticPinEntryActive(int var1) throws MethodException;

    public void updateActivationState(ActivationStateStruct var1, int var2) throws MethodException;

    public void updateAutomaticPinEntryActive(boolean var1, int var2) throws MethodException;

    public void updateLockState(LockStateStruct var1, int var2) throws MethodException;

    public void updateNADTemperature(NADTemperatureStruct var1, int var2) throws MethodException;

    public void updatePhoneInformation(PhoneInformation var1, int var2) throws MethodException;

    public void updateNetworkProvider(NetworkProviderName var1, int var2) throws MethodException;

    public void updateNetworkType(int var1, int var2) throws MethodException;

    public void updateRegisterState(RegisterStateStruct var1, int var2) throws MethodException;

    public void updateSignalQuality(int var1, int var2) throws MethodException;

    public void updateServiceProvider(ServiceProvider var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

