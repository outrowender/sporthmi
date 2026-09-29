/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipementResponseListener;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class TelDefaultDSIMobileEquipmentListener
implements ITelDSIMobileEquipementResponseListener {
    @Override
    public void responseAbortNetworkRegistration(int n) {
    }

    @Override
    public void responseAbortNetworkSearch(int n) {
    }

    @Override
    public void responseAcceptCall(int n) {
    }

    @Override
    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
    }

    @Override
    public void responseCallWaiting(int n, int n2) {
    }

    @Override
    public void responseChangeSIMCode(int n, int n2) {
    }

    @Override
    public void responseCLIR(int n, int n2, int n3) {
    }

    @Override
    public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    @Override
    public void responseHangupCall(int n) {
    }

    @Override
    public void responseJoinCalls(int n) {
    }

    @Override
    public void responseNetworkRegistration(int n) {
    }

    @Override
    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
    }

    @Override
    public void responseSendDTMF(int n) {
    }

    @Override
    public void responseServiceCodeAbort(int n) {
    }

    @Override
    public void responseSetAutomaticEmergencyCallActive(int n) {
    }

    @Override
    public void responseSetAutomaticPinEntryActive(int n) {
    }

    @Override
    public void responseSetAutomaticRedialActive(int n) {
    }

    @Override
    public void responseSetCDMAThreeWayCallingSetting(int n) {
    }

    @Override
    public void responseSetESIMActive(int n) {
    }

    @Override
    public void responseSetHandsFreeMode(int n) {
    }

    @Override
    public void responseSetMailboxContent(int n) {
    }

    @Override
    public void responseSetMICMuteState(int n) {
    }

    @Override
    public void responseSetNADMode(int n, int n2) {
    }

    @Override
    public void responseSetOptimizationMode(int n, int n2) {
    }

    @Override
    public void responseSetPhoneReminderSetting(int n) {
    }

    @Override
    public void responseSetPhoneRingtone(int n) {
    }

    @Override
    public void responseSetPrivacyMode(int n) {
    }

    @Override
    public void responseSIMPINRequired(int n) {
    }

    @Override
    public void responseSplitCall(int n) {
    }

    @Override
    public void responseSwapCalls(int n) {
    }

    @Override
    public void responseTelPower(int n) {
    }

    @Override
    public void responseUnlockOtherSIM(int n) {
    }

    @Override
    public void responseUnlockSIM(int n) {
    }

    @Override
    public void responseChangeTopology(int n) {
    }

    @Override
    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
    }

    @Override
    public void updateLockState(LockStateStruct lockStateStruct, int n) {
    }

    @Override
    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }
}

