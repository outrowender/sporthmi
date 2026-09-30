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
    public void responseAbortNetworkRegistration(int n) {
    }

    public void responseAbortNetworkSearch(int n) {
    }

    public void responseAcceptCall(int n) {
    }

    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
    }

    public void responseCallWaiting(int n, int n2) {
    }

    public void responseChangeSIMCode(int n, int n2) {
    }

    public void responseCLIR(int n, int n2, int n3) {
    }

    public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    public void responseHangupCall(int n) {
    }

    public void responseJoinCalls(int n) {
    }

    public void responseNetworkRegistration(int n) {
    }

    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
    }

    public void responseRestoreFactorySettings(int n) {
    }

    public void responseSendDTMF(int n) {
    }

    public void responseServiceCodeAbort(int n) {
    }

    public void responseSetAutomaticEmergencyCallActive(int n) {
    }

    public void responseSetAutomaticPinEntryActive(int n) {
    }

    public void responseSetAutomaticRedialActive(int n) {
    }

    public void responseSetCDMAThreeWayCallingSetting(int n) {
    }

    public void responseSetESIMActive(int n) {
    }

    public void responseSetHandsFreeMode(int n) {
    }

    public void responseSetMailboxContent(int n) {
    }

    public void responseSetMICMuteState(int n) {
    }

    public void responseSetNADMode(int n, int n2) {
    }

    public void responseSetOptimizationMode(int n, int n2) {
    }

    public void responseSetPhoneReminderSetting(int n) {
    }

    public void responseSetPhoneRingtone(int n) {
    }

    public void responseSetPrivacyMode(int n) {
    }

    public void responseSIMPINRequired(int n) {
    }

    public void responseSplitCall(int n) {
    }

    public void responseSwapCalls(int n) {
    }

    public void responseTelPower(int n) {
    }

    public void responseUnlockOtherSIM(int n) {
    }

    public void responseUnlockSIM(int n) {
    }

    public void responseChangeTopology(int n) {
    }

    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
    }

    public void updateLockState(LockStateStruct lockStateStruct, int n) {
    }

    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    public void asyncException(int n, String string, int n2) {
    }
}

