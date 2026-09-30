/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIResponseErrorHandler;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.event.AbstractTelDSIResponseEvent;
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

    public void responseAbortNetworkRegistration(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2000){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseAbortNetworkRegistration(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseAbortNetworkRegistration(n, n2);
                }
            }
        });
    }

    public void responseAbortNetworkSearch(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2001){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseAbortNetworkSearch(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseAbortNetworkSearch(n, n2);
                }
            }
        });
    }

    public void responseAcceptCall(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2002){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseAcceptCall(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseAcceptCall(n, n2);
                }
            }
        });
    }

    public void responseCallForward(final CFResponseData[] cFResponseDataArray, final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2003){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseCallForward(cFResponseDataArray, n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseCallForward(cFResponseDataArray, n, n2);
                }
            }
        });
    }

    public void responseCallWaiting(final int n, final int n2, final int n3, final int n4) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2004){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n3, n4);
                TelResultHandlerWrapper.this.listener.responseCallWaiting(n, n2, n3, n4);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseCallWaiting(n, n2, n3, n4);
                }
            }
        });
    }

    public void responseChangeSIMCode(final int n, final int n2, final int n3) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2005){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n2, n3);
                TelResultHandlerWrapper.this.listener.responseChangeSIMCode(n, n2, n3);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseChangeSIMCode(n, n2, n3);
                }
            }
        });
    }

    public void responseCLIR(final int n, final int n2, final int n3, final int n4) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2006){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n3, n4);
                TelResultHandlerWrapper.this.listener.responseCLIR(n, n2, n3, n4);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseCLIR(n, n2, n3, n4);
                }
            }
        });
    }

    public void responseDialNumber(final int n, final int n2, final SuppServiceResponseStruct suppServiceResponseStruct, final int n3) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2007){

            public void run() {
                if (n2 == 0) {
                    TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n3);
                }
                TelResultHandlerWrapper.this.listener.responseDialNumber(n, n2, suppServiceResponseStruct, n3);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseDialNumber(n, n2, suppServiceResponseStruct, n3);
                }
            }
        });
    }

    public void responseDialOperator(final int n, final SuppServiceResponseStruct suppServiceResponseStruct, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2034){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseDialOperator(n, suppServiceResponseStruct, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseDialOperator(n, suppServiceResponseStruct, n2);
                }
            }
        });
    }

    public void responseHangupCall(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2010){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseHangupCall(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseHangupCall(n, n2);
                }
            }
        });
    }

    public void responseJoinCalls(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2011){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseJoinCalls(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseJoinCalls(n, n2);
                }
            }
        });
    }

    public void responseNetworkRegistration(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2012){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseNetworkRegistration(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseNetworkRegistration(n, n2);
                }
            }
        });
    }

    public void responseNetworkSearch(final NetworkProvider[] networkProviderArray, final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2013){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseNetworkSearch(networkProviderArray, n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseNetworkSearch(networkProviderArray, n, n2);
                }
            }
        });
    }

    public void responseRestoreFactorySettings(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2016){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseRestoreFactorySettings(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseRestoreFactorySettings(n, n2);
                }
            }
        });
    }

    public void responseSendDTMF(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2008){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSendDTMF(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSendDTMF(n, n2);
                }
            }
        });
    }

    public void responseServiceCodeAbort(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2020){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseServiceCodeAbort(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseServiceCodeAbort(n, n2);
                }
            }
        });
    }

    public void responseSetAutomaticEmergencyCallActive(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2025){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSetAutomaticEmergencyCallActive(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSetAutomaticEmergencyCallActive(n, n2);
                }
            }
        });
    }

    public void responseSetAutomaticPinEntryActive(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2018){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSetAutomaticPinEntryActive(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSetAutomaticPinEntryActive(n, n2);
                }
            }
        });
    }

    public void responseSetAutomaticRedialActive(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2019){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSetAutomaticRedialActive(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSetAutomaticRedialActive(n, n2);
                }
            }
        });
    }

    public void responseSetCDMAThreeWayCallingSetting(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2024){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSetCDMAThreeWayCallingSetting(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSetCDMAThreeWayCallingSetting(n, n2);
                }
            }
        });
    }

    public void responseSetESIMActive(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2041){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSetESIMActive(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSetESIMActive(n, n2);
                }
            }
        });
    }

    public void responseSetHandsFreeMode(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2017){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSetHandsFreeMode(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSetHandsFreeMode(n, n2);
                }
            }
        });
    }

    public void responseSetMailboxContent(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2026){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSetMailboxContent(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSetMailboxContent(n, n2);
                }
            }
        });
    }

    public void responseSetMICMuteState(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2028){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSetMICMuteState(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSetMICMuteState(n, n2);
                }
            }
        });
    }

    public void responseSetNADMode(final int n, final int n2, final int n3) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2030){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n2, n3);
                TelResultHandlerWrapper.this.listener.responseSetNADMode(n, n2, n3);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSetNADMode(n, n2, n3);
                }
            }
        });
    }

    public void responseSetOptimizationMode(final int n, final int n2, final int n3) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2029){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n2, n3);
                TelResultHandlerWrapper.this.listener.responseSetOptimizationMode(n, n2, n3);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSetOptimizationMode(n, n2, n3);
                }
            }
        });
    }

    public void responseSetPhoneReminderSetting(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2036){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSetPhoneReminderSetting(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSetPhoneReminderSetting(n, n2);
                }
            }
        });
    }

    public void responseSetPhoneRingtone(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2038){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSetPhoneRingtone(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSetPhoneRingtone(n, n2);
                }
            }
        });
    }

    public void responseSetPrivacyMode(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2027){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSetPrivacyMode(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSetPrivacyMode(n, n2);
                }
            }
        });
    }

    public void responseSIMPINRequired(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2009){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSIMPINRequired(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSIMPINRequired(n, n2);
                }
            }
        });
    }

    public void responseSplitCall(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2021){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSplitCall(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSplitCall(n, n2);
                }
            }
        });
    }

    public void responseSwapCalls(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2022){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSwapCalls(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSwapCalls(n, n2);
                }
            }
        });
    }

    public void responseTelPower(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2023){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseTelPower(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseTelPower(n, n2);
                }
            }
        });
    }

    public void responseUnlockOtherSIM(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2031){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseUnlockOtherSIM(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseUnlockOtherSIM(n, n2);
                }
            }
        });
    }

    public void responseUnlockSIM(final int n, final int n2, final LockStateStruct lockStateStruct) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2014){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseUnlockSIM(n, n2, lockStateStruct);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseUnlockSIM(n, n2, lockStateStruct);
                }
            }
        });
    }

    public void responseChangeTopology(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2000){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseChangeTopology(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseChangeTopology(n, n2);
                }
            }
        });
    }

    public void responseSetSIMAliases(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2032){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseSetSIMAliases(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseSetSIMAliases(n, n2);
                }
            }
        });
    }

    public void responseCheckSIMPINCode(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2015){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseCheckSIMPINCode(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseCheckSIMPINCode(n, n2);
                }
            }
        });
    }

    public void responseRemoveOtherSIM(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelDSIResponseEvent(2033){

            public void run() {
                TelResultHandlerWrapper.this.checkSendErrorResultToHandler(n, n2);
                TelResultHandlerWrapper.this.listener.responseRemoveOtherSIM(n, n2);
                for (int i2 = 0; i2 < TelResultHandlerWrapper.this.globalResponseListeners.length; ++i2) {
                    TelResultHandlerWrapper.this.globalResponseListeners[i2].responseRemoveOtherSIM(n, n2);
                }
            }
        });
    }
}

