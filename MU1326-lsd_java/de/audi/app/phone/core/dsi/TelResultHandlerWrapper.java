/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIResponseErrorHandler;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$1;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$10;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$11;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$12;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$13;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$14;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$15;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$16;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$17;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$18;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$19;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$2;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$20;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$21;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$22;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$23;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$24;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$25;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$26;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$27;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$28;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$29;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$3;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$30;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$31;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$32;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$33;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$34;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$35;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$36;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$37;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$38;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$39;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$4;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$5;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$6;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$7;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$8;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper$9;
import de.audi.app.phone.core.event.TelEventQueue;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class TelResultHandlerWrapper
implements ITelDSIResponseListener {
    private final ITelDSIResponseErrorHandler errorHandler;
    private final boolean useDefaultErrorHandling;
    private final ITelDSIResponseListener listener;
    private final ITelDSIResponseListener[] globalResponseListeners;
    private final TelEventQueue telEventQueue;

    public TelResultHandlerWrapper(TelEventQueue telEventQueue, ITelDSIResponseErrorHandler iTelDSIResponseErrorHandler, ITelDSIResponseListener iTelDSIResponseListener, boolean bl, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.telEventQueue = telEventQueue;
        this.errorHandler = iTelDSIResponseErrorHandler;
        this.listener = iTelDSIResponseListener == null ? new TelDefaultDSIResponseListener() : iTelDSIResponseListener;
        this.useDefaultErrorHandling = bl;
        this.globalResponseListeners = iTelDSIResponseListenerArray == null ? new ITelDSIResponseListener[]{} : iTelDSIResponseListenerArray;
    }

    private void checkSendErrorResultToHandler(int n, int n2) {
        if (n != 0 && this.useDefaultErrorHandling && this.errorHandler != null) {
            this.errorHandler.handleResult(n, n2);
        }
    }

    @Override
    public void responseAbortNetworkRegistration(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$1(this, 2000, n, n2));
    }

    @Override
    public void responseAbortNetworkSearch(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$2(this, 2001, n, n2));
    }

    @Override
    public void responseAcceptCall(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$3(this, 2002, n, n2));
    }

    @Override
    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$4(this, 2003, n, n2, cFResponseDataArray));
    }

    @Override
    public void responseCallWaiting(int n, int n2, int n3, int n4) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$5(this, 2004, n3, n4, n, n2));
    }

    @Override
    public void responseChangeSIMCode(int n, int n2, int n3) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$6(this, 2005, n2, n3, n));
    }

    @Override
    public void responseCLIR(int n, int n2, int n3, int n4) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$7(this, 2006, n3, n4, n, n2));
    }

    @Override
    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$8(this, 2007, n2, n, n3, suppServiceResponseStruct));
    }

    @Override
    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$9(this, 2034, n, n2, suppServiceResponseStruct));
    }

    @Override
    public void responseHangupCall(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$10(this, 2010, n, n2));
    }

    @Override
    public void responseJoinCalls(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$11(this, 2011, n, n2));
    }

    @Override
    public void responseNetworkRegistration(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$12(this, 2012, n, n2));
    }

    @Override
    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$13(this, 2013, n, n2, networkProviderArray));
    }

    @Override
    public void responseRestoreFactorySettings(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$14(this, 2016, n, n2));
    }

    @Override
    public void responseSendDTMF(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$15(this, 2008, n, n2));
    }

    @Override
    public void responseServiceCodeAbort(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$16(this, 2020, n, n2));
    }

    @Override
    public void responseSetAutomaticEmergencyCallActive(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$17(this, 2025, n, n2));
    }

    @Override
    public void responseSetAutomaticPinEntryActive(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$18(this, 2018, n, n2));
    }

    @Override
    public void responseSetAutomaticRedialActive(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$19(this, 2019, n, n2));
    }

    @Override
    public void responseSetCDMAThreeWayCallingSetting(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$20(this, 2024, n, n2));
    }

    @Override
    public void responseSetESIMActive(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$21(this, 2041, n, n2));
    }

    @Override
    public void responseSetHandsFreeMode(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$22(this, 2017, n, n2));
    }

    @Override
    public void responseSetMailboxContent(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$23(this, 2026, n, n2));
    }

    @Override
    public void responseSetMICMuteState(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$24(this, 2028, n, n2));
    }

    @Override
    public void responseSetNADMode(int n, int n2, int n3) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$25(this, 2030, n2, n3, n));
    }

    @Override
    public void responseSetOptimizationMode(int n, int n2, int n3) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$26(this, 2029, n2, n3, n));
    }

    @Override
    public void responseSetPhoneReminderSetting(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$27(this, 2036, n, n2));
    }

    @Override
    public void responseSetPhoneRingtone(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$28(this, 2038, n, n2));
    }

    @Override
    public void responseSetPrivacyMode(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$29(this, 2027, n, n2));
    }

    @Override
    public void responseSIMPINRequired(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$30(this, 2009, n, n2));
    }

    @Override
    public void responseSplitCall(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$31(this, 2021, n, n2));
    }

    @Override
    public void responseSwapCalls(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$32(this, 2022, n, n2));
    }

    @Override
    public void responseTelPower(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$33(this, 2023, n, n2));
    }

    @Override
    public void responseUnlockOtherSIM(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$34(this, 2031, n, n2));
    }

    @Override
    public void responseUnlockSIM(int n, int n2, LockStateStruct lockStateStruct) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$35(this, 2014, n, n2, lockStateStruct));
    }

    @Override
    public void responseChangeTopology(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$36(this, 2000, n, n2));
    }

    @Override
    public void responseSetSIMAliases(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$37(this, 2032, n, n2));
    }

    @Override
    public void responseCheckSIMPINCode(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$38(this, 2015, n, n2));
    }

    @Override
    public void responseRemoveOtherSIM(int n, int n2) {
        this.telEventQueue.enqueue(new TelResultHandlerWrapper$39(this, 2033, n, n2));
    }

    static /* synthetic */ void access$000(TelResultHandlerWrapper telResultHandlerWrapper, int n, int n2) {
        telResultHandlerWrapper.checkSendErrorResultToHandler(n, n2);
    }

    static /* synthetic */ ITelDSIResponseListener access$100(TelResultHandlerWrapper telResultHandlerWrapper) {
        return telResultHandlerWrapper.listener;
    }

    static /* synthetic */ ITelDSIResponseListener[] access$200(TelResultHandlerWrapper telResultHandlerWrapper) {
        return telResultHandlerWrapper.globalResponseListeners;
    }
}

