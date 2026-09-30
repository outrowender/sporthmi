/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class TelDefaultDSIResponseListener
implements ITelDSIResponseListener {
    public void responseAbortNetworkRegistration(int n, int n2) {
    }

    public void responseAbortNetworkSearch(int n, int n2) {
    }

    public void responseAcceptCall(int n, int n2) {
    }

    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n, int n2) {
    }

    public void responseCallWaiting(int n, int n2, int n3, int n4) {
    }

    public void responseChangeSIMCode(int n, int n2, int n3) {
    }

    public void responseCLIR(int n, int n2, int n3, int n4) {
    }

    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
    }

    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct, int n2) {
    }

    public void responseHangupCall(int n, int n2) {
    }

    public void responseSIMPINRequired(int n, int n2) {
    }

    public void responseJoinCalls(int n, int n2) {
    }

    public void responseNetworkRegistration(int n, int n2) {
    }

    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n, int n2) {
    }

    public void responseUnlockOtherSIM(int n, int n2) {
    }

    public void responseUnlockSIM(int n, int n2, LockStateStruct lockStateStruct) {
    }

    public void responseRestoreFactorySettings(int n, int n2) {
    }

    public void responseSetHandsFreeMode(int n, int n2) {
    }

    public void responseSetAutomaticPinEntryActive(int n, int n2) {
    }

    public void responseSetAutomaticRedialActive(int n, int n2) {
    }

    public void responseSplitCall(int n, int n2) {
    }

    public void responseSwapCalls(int n, int n2) {
    }

    public void responseTelPower(int n, int n2) {
    }

    public void responseSetCDMAThreeWayCallingSetting(int n, int n2) {
    }

    public void responseSetAutomaticEmergencyCallActive(int n, int n2) {
    }

    public void responseSetMailboxContent(int n, int n2) {
    }

    public void responseSetPrivacyMode(int n, int n2) {
    }

    public void responseSetMICMuteState(int n, int n2) {
    }

    public void responseSetOptimizationMode(int n, int n2, int n3) {
    }

    public void responseSetNADMode(int n, int n2, int n3) {
    }

    public void responseSetPhoneRingtone(int n, int n2) {
    }

    public void responseSetESIMActive(int n, int n2) {
    }

    public void responseSendDTMF(int n, int n2) {
    }

    public void responseServiceCodeAbort(int n, int n2) {
    }

    public void responseSetPhoneReminderSetting(int n, int n2) {
    }

    public void responseChangeTopology(int n, int n2) {
    }

    public void responseSetSIMAliases(int n, int n2) {
    }

    public void responseCheckSIMPINCode(int n, int n2) {
    }

    public void responseRemoveOtherSIM(int n, int n2) {
    }
}

