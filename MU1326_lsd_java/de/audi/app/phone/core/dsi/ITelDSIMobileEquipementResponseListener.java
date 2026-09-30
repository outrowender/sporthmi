/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public interface ITelDSIMobileEquipementResponseListener
extends DSIListener {
    public void responseAbortNetworkRegistration(int var1);

    public void responseAbortNetworkSearch(int var1);

    public void responseAcceptCall(int var1);

    public void responseCallForward(CFResponseData[] var1, int var2);

    public void responseCallWaiting(int var1, int var2);

    public void responseChangeSIMCode(int var1, int var2);

    public void responseCLIR(int var1, int var2, int var3);

    public void responseDialNumber(int var1, SuppServiceResponseStruct var2);

    public void responseHangupCall(int var1);

    public void responseJoinCalls(int var1);

    public void responseNetworkRegistration(int var1);

    public void responseNetworkSearch(NetworkProvider[] var1, int var2);

    public void responseRestoreFactorySettings(int var1);

    public void responseSendDTMF(int var1);

    public void responseServiceCodeAbort(int var1);

    public void responseSetAutomaticEmergencyCallActive(int var1);

    public void responseSetAutomaticPinEntryActive(int var1);

    public void responseSetAutomaticRedialActive(int var1);

    public void responseSetCDMAThreeWayCallingSetting(int var1);

    public void responseSetESIMActive(int var1);

    public void responseSetHandsFreeMode(int var1);

    public void responseSetMailboxContent(int var1);

    public void responseSetMICMuteState(int var1);

    public void responseSetNADMode(int var1, int var2);

    public void responseSetOptimizationMode(int var1, int var2);

    public void responseSetPhoneReminderSetting(int var1);

    public void responseSetPhoneRingtone(int var1);

    public void responseSetPrivacyMode(int var1);

    public void responseSIMPINRequired(int var1);

    public void responseSplitCall(int var1);

    public void responseSwapCalls(int var1);

    public void responseTelPower(int var1);

    public void responseUnlockOtherSIM(int var1);

    public void responseUnlockSIM(int var1);

    public void responseChangeTopology(int var1);

    public void updateServiceCodeType(ServiceCodeTypeStruct var1, int var2);

    public void updateLockState(LockStateStruct var1, int var2);

    public void responseDialOperator(int var1, SuppServiceResponseStruct var2);
}

