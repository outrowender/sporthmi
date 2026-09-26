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
    default public void responseAbortNetworkRegistration(int n) {
    }

    default public void responseAbortNetworkSearch(int n) {
    }

    default public void responseAcceptCall(int n) {
    }

    default public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
    }

    default public void responseCallWaiting(int n, int n2) {
    }

    default public void responseChangeSIMCode(int n, int n2) {
    }

    default public void responseCLIR(int n, int n2, int n3) {
    }

    default public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    default public void responseHangupCall(int n) {
    }

    default public void responseJoinCalls(int n) {
    }

    default public void responseNetworkRegistration(int n) {
    }

    default public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
    }

    default public void responseRestoreFactorySettings(int n) {
    }

    default public void responseSendDTMF(int n) {
    }

    default public void responseServiceCodeAbort(int n) {
    }

    default public void responseSetAutomaticEmergencyCallActive(int n) {
    }

    default public void responseSetAutomaticPinEntryActive(int n) {
    }

    default public void responseSetAutomaticRedialActive(int n) {
    }

    default public void responseSetCDMAThreeWayCallingSetting(int n) {
    }

    default public void responseSetESIMActive(int n) {
    }

    default public void responseSetHandsFreeMode(int n) {
    }

    default public void responseSetMailboxContent(int n) {
    }

    default public void responseSetMICMuteState(int n) {
    }

    default public void responseSetNADMode(int n, int n2) {
    }

    default public void responseSetOptimizationMode(int n, int n2) {
    }

    default public void responseSetPhoneReminderSetting(int n) {
    }

    default public void responseSetPhoneRingtone(int n) {
    }

    default public void responseSetPrivacyMode(int n) {
    }

    default public void responseSIMPINRequired(int n) {
    }

    default public void responseSplitCall(int n) {
    }

    default public void responseSwapCalls(int n) {
    }

    default public void responseTelPower(int n) {
    }

    default public void responseUnlockOtherSIM(int n) {
    }

    default public void responseUnlockSIM(int n) {
    }

    default public void responseChangeTopology(int n) {
    }

    default public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
    }

    default public void updateLockState(LockStateStruct lockStateStruct, int n) {
    }

    default public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }
}

