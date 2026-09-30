/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephone.ActivationStateStruct;
import org.dsi.ifc.telephone.LockStateStruct;
import org.dsi.ifc.telephone.NADTemperatureStruct;
import org.dsi.ifc.telephone.NetworkProvider;
import org.dsi.ifc.telephone.NetworkProviderName;
import org.dsi.ifc.telephone.PhoneInformation;
import org.dsi.ifc.telephone.RegisterStateStruct;
import org.dsi.ifc.telephone.ServiceProvider;

public interface DSINADListener
extends DSIListener {
    public void responseAbortNetworkRegistration(int var1);

    public void responseAbortNetworkSearch(int var1);

    public void responseChangeSIMCode(int var1, int var2);

    public void responseSIMPINRequired(int var1);

    public void updateSIMPINRequired(boolean var1, int var2);

    public void responseNetworkRegistration(int var1);

    public void responseNetworkSearch(NetworkProvider[] var1, int var2);

    public void responseUnlockSIM(int var1);

    public void responseCheckSIMPINCode(int var1);

    public void responseRestoreFactorySettings(int var1);

    public void responseTelPower(int var1);

    public void responseSetAutomaticPinEntryActive(int var1);

    public void updateActivationState(ActivationStateStruct var1, int var2);

    public void updateAutomaticPinEntryActive(boolean var1, int var2);

    public void updateLockState(LockStateStruct var1, int var2);

    public void updateNADTemperature(NADTemperatureStruct var1, int var2);

    public void updatePhoneInformation(PhoneInformation var1, int var2);

    public void updateNetworkProvider(NetworkProviderName var1, int var2);

    public void updateNetworkType(int var1, int var2);

    public void updateRegisterState(RegisterStateStruct var1, int var2);

    public void updateSignalQuality(int var1, int var2);

    public void updateServiceProvider(ServiceProvider var1, int var2);
}

