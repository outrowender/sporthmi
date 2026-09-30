/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.callstacks.TelCallStacksUtils;
import de.audi.app.phone.core.dsi.AbstractDSIMobileEquipementListener;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipementResponseListener;
import de.audi.app.phone.core.dsi.TelActivationStateStruct;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.CallDuration;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;
import org.dsi.ifc.telephoneng.DisconnectReason;
import org.dsi.ifc.telephoneng.EmergencyCallSetting;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.dsi.ifc.telephoneng.Favorite;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.MailboxDialingNumber;
import org.dsi.ifc.telephoneng.MissedCallIndicator;
import org.dsi.ifc.telephoneng.NADTemperatureStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.NetworkProviderName;
import org.dsi.ifc.telephoneng.PhoneInformation;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.SIMAliasInformation;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.ServiceNumbers;
import org.dsi.ifc.telephoneng.ServiceProvider;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class TelDSIMobileEquipmentListener
extends AbstractDSIMobileEquipementListener
implements DSIMobileEquipmentListener {
    private final CommandListManager hangupCmdListManager;

    public TelDSIMobileEquipmentListener(ITelApplication iTelApplication, int n, CommandListManager commandListManager, CommandListManager commandListManager2, LogChannel logChannel) {
        super(iTelApplication, commandListManager, logChannel, n);
        this.hangupCmdListManager = commandListManager2;
    }

    public CommandList getActiveCommandList() {
        return this.commandListManager.getActiveCommandList();
    }

    public String getHandlerName() {
        return "TelDSIMobileEquipmentListener";
    }

    public void asyncException(int n, String string, int n2) {
        Buffer buffer = new Buffer();
        buffer.append("errorCode=");
        buffer.append(n);
        buffer.append(", ");
        buffer.append("errorMsg=");
        buffer.append(string);
        buffer.append(", ");
        buffer.append("requestType=");
        buffer.append(n2);
        this.log.log(100000, "[TelDSIMobilEquipmentListener(%2)#asyncException] %1", (Object)buffer, (Object)this.getInstanceAndRoleString());
    }

    public void responseAbortNetworkRegistration(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseAbortNetworkRegistration] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseAbortNetworkRegistration(n);
            }
        });
    }

    public void responseAbortNetworkSearch(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseAbortNetworkSearch] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseAbortNetworkSearch(n);
            }
        });
    }

    public void responseAcceptCall(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseAcceptCall] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseAcceptCall(n);
            }
        });
    }

    public void responseCallForward(final CFResponseData[] cFResponseDataArray, final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseCallForward] telCFResponseData=%1, result=%2", (Object)TelLoggingUtils.objectArray2StringNewLines(cFResponseDataArray), (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseCallForward(cFResponseDataArray, n);
            }
        });
    }

    public void responseCallWaiting(final int n, final int n2) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseCallWaiting] telCWStatus=%1, result=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseCallWaiting(n, n2);
            }
        });
    }

    public void responseChangeSIMCode(final int n, final int n2) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseChangeSIMCode] telLockCode=%1, result=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseChangeSIMCode(n, n2);
            }
        });
    }

    public void responseCheckSIMPINCode(int n) {
        this.log.log(100000, "[TelDSIMobileEquipmentListener#responseCheckSIMPINCode] not supported --> NOP!");
    }

    public void responseCLIR(final int n, final int n2, final int n3) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseCLIR] telCLIRState=%1, telCLIRNWState=%2, result=%3", (long)n, (long)n2, (long)n3);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseCLIR(n, n2, n3);
            }
        });
    }

    public void responseDialNumber(final int n, final SuppServiceResponseStruct suppServiceResponseStruct) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseDialNumber] result=%2, telSuppServResult=%1", (Object)suppServiceResponseStruct, (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseDialNumber(n, suppServiceResponseStruct);
            }
        });
    }

    public void responseDialOperator(final int n, final SuppServiceResponseStruct suppServiceResponseStruct) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseDialOperator] result=%2, telSuppServResult=%1", (Object)suppServiceResponseStruct, (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseDialOperator(n, suppServiceResponseStruct);
            }
        });
    }

    public void responseHangupCall(final int n) {
        CommandResponse.execute(new ICommandResponseSupplier(){

            public LogChannel getLogChannel() {
                return TelDSIMobileEquipmentListener.this.cmdListLogChannel;
            }

            public String getHandlerName() {
                return "TelDSIMobileEquipmentListenerHangup";
            }

            public DSIListener getDSIDefaultHandler() {
                return TelDSIMobileEquipmentListener.this.defaultListener;
            }

            public CommandList getActiveCommandList() {
                return TelDSIMobileEquipmentListener.this.hangupCmdListManager.getActiveCommandList();
            }
        }, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseHangupCall(n);
            }
        });
    }

    public void responseJoinCalls(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseJoinCalls] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseJoinCalls(n);
            }
        });
    }

    public void responseNetworkRegistration(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseNetworkRegistration] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseNetworkRegistration(n);
            }
        });
    }

    public void responseNetworkSearch(final NetworkProvider[] networkProviderArray, final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseNetworkSearch] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseNetworkSearch(networkProviderArray, n);
            }
        });
    }

    public void responseRemoveOtherSIM(int n) {
        this.log.log(100000, "[TelDSIMobileEquipmentListener#responseRemoveOtherSIM] not supported --> NOP!");
    }

    public void responseRestoreFactorySettings(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseRestoreFactorySettings] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseRestoreFactorySettings(n);
            }
        });
    }

    public void responseSendDTMF(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSendDTMF] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSendDTMF(n);
            }
        });
    }

    public void responseServiceCodeAbort(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseServiceCodeAbort] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseServiceCodeAbort(n);
            }
        });
    }

    public void responseSetAutomaticEmergencyCallActive(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSetAutomaticEmergencyCallActive] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSetAutomaticEmergencyCallActive(n);
            }
        });
    }

    public void responseSetAutomaticPinEntryActive(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSetAutomaticPinEntryActive] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSetAutomaticPinEntryActive(n);
            }
        });
    }

    public void responseSetAutomaticRedialActive(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSetAutomaticRedialActive] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSetAutomaticRedialActive(n);
            }
        });
    }

    public void responseSetCDMAThreeWayCallingSetting(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSetCDMAThreeWayCallingSetting] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSetCDMAThreeWayCallingSetting(n);
            }
        });
    }

    public void responseSetESIMActive(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSetESIMActive] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSetESIMActive(n);
            }
        });
    }

    public void responseSetFavorites(int n) {
        this.log.log(100000, "[TelDSIMobileEquipmentListener#responseSetFavorites] not supported --> NOP!");
    }

    public void responseSetHandsFreeMode(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSetHandsFreeMode] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSetHandsFreeMode(n);
            }
        });
    }

    public void responseSetMailboxContent(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSetMailboxContent] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSetMailboxContent(n);
            }
        });
    }

    public void responseSetMICMuteState(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSetMICMuteState] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSetMICMuteState(n);
            }
        });
    }

    public void responseSetNADMode(final int n, final int n2) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSetNADMode] result=%1", (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSetNADMode(n, n2);
            }
        });
    }

    public void responseSetOptimizationMode(final int n, final int n2) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSetOptimizationMode] result=%1", (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSetOptimizationMode(n, n2);
            }
        });
    }

    public void responseSetPhoneReminderSetting(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSetPhoneReminderSetting] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSetPhoneReminderSetting(n);
            }
        });
    }

    public void responseSetPhoneRingtone(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSetPhoneRingtone] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSetPhoneRingtone(n);
            }
        });
    }

    public void responseSetPrefixActivated(int n) {
        this.log.log(100000, "[TelDSIMobileEquipmentListener#responseSetPrefixActivated] not supported --> NOP!");
    }

    public void responseSetPrefixContent(int n) {
        this.log.log(100000, "[TelDSIMobileEquipmentListener#responseSetPrefixContent] not supported --> NOP!");
    }

    public void responseSetPrivacyMode(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSetPrivacyMode] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSetPrivacyMode(n);
            }
        });
    }

    public void responseSetSIMAliases(int n) {
        this.log.log(100000, "[TelDSIMobileEquipmentListener#responseSetSIMAliases] not supported --> NOP!");
    }

    public void responseSetSIMName(int n) {
        this.log.log(100000, "[TelDSIMobileEquipmentListener#responseSetSIMName] not supported --> NOP!");
    }

    public void responseSIMPINRequired(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSIMPINRequired] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSIMPINRequired(n);
            }
        });
    }

    public void responseSplitCall(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSplitCall] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSplitCall(n);
            }
        });
    }

    public void responseSwapCalls(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseSwapCalls] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseSwapCalls(n);
            }
        });
    }

    public void responseTelPower(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseTelPower] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseTelPower(n);
            }
        });
    }

    public void responseUnlockOtherSIM(int n) {
        this.log.log(100000, "[TelDSIMobileEquipmentListener#responseUnlockOtherSIM] not supported --> NOP!");
    }

    public void responseUnlockSIM(final int n) {
        this.log.log(10000000, "[TelDSIMobileEquipmentListener#responseUnlockSIM] result=%1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((ITelDSIMobileEquipementResponseListener)dSIListener).responseUnlockSIM(n);
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
        if (n == 1) {
            Object object = this.mutex;
            synchronized (object) {
                TelActivationStateStruct telActivationStateStruct = new TelActivationStateStruct(activationStateStruct);
                this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateActivationState] activationState=%1", (Object)telActivationStateStruct, (Object)this.getInstanceAndRoleString());
                this.activationState = telActivationStateStruct;
                this.updateGlobalTelephoneState(4);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateAutomaticPinEntryActive(boolean bl, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateAutomaticPinEntryActive] automaticPinEntryActive=%1", bl, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.automaticPinEntryActive = bl;
                this.updateGlobalTelephoneState(5);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateAutomaticRedialActive(boolean bl, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateAutomaticRedialActive] automaticRedialActive=%1", bl, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.automaticRedialActive = bl;
                this.updateGlobalTelephoneState(6);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateBatteryChargeLevel(int n, int n2) {
        if (n2 == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateBatteryChargeLevel] batteryChargeLevel=%1", (Object)String.valueOf(n), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.batteryChargeLevel = n;
                this.updateGlobalTelephoneState(7);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateCallDurationList(CallDuration[] callDurationArray, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateCallDurationList] callDurationList=%1", (Object)TelLoggingUtils.objectArray2StringNewLines(callDurationArray), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.callState.updateCallDurationList(callDurationArray);
                this.callDurationList = callDurationArray;
                this.updateGlobalTelephoneState(8);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateCallList(CallInformation[] callInformationArray, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateCallList] callList=%1", (Object)TelLoggingUtils.objectArray2StringNewLines(callInformationArray), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.callState.updateCallList(callInformationArray);
                this.callList = callInformationArray;
                this.updateGlobalTelephoneState(9);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateCallstacksIsReverted(boolean bl, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateCallstacksIsReverted] isReverted=%1", bl, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.isCallStacksReverted = bl;
                this.updateGlobalTelephoneState(46);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateCDMAThreeWayCallingSetting(boolean bl, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateCDMAThreeWayCallingSetting] cdmaThreeWayCallingSetting=%1", bl, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.cdmaThreeWayCallingSetting = bl;
                this.updateGlobalTelephoneState(10);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateCradlePlugInState(int n, int n2) {
        if (n2 == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateCradlePlugInState] cradlePlugInState=%1", (Object)String.valueOf(n), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.cradlePlugInState = n;
                this.updateGlobalTelephoneState(11);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateDisconnectReason(DisconnectReason disconnectReason, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateDisconnectReason] disconnectReason=%1", (Object)disconnectReason, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                DisconnectReason disconnectReason2 = null;
                if (disconnectReason != null) {
                    disconnectReason2 = new DisconnectReason(disconnectReason.disconnectReason, disconnectReason.callId);
                } else {
                    this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener#updateDisconnectReason] disconnectReason is null");
                }
                this.callState.updateDisconnectReason(disconnectReason2);
                this.disconnectReason = disconnectReason2;
                this.updateGlobalTelephoneState(12);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateDTMFTonePlaying(String string, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateDTMFTonePlaying] dtmfTone=%1", (Object)string, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.dtmfTone = string;
                this.updateGlobalTelephoneState(1);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateEmergencyCallActive(EmergencyCallSetting emergencyCallSetting, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateEmergencyCallActive] emergencyCallActive=%1", (Object)emergencyCallSetting, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                EmergencyCallSetting emergencyCallSetting2 = null;
                if (emergencyCallSetting != null) {
                    emergencyCallSetting2 = new EmergencyCallSetting(emergencyCallSetting.value, emergencyCallSetting.changeable);
                } else {
                    this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener#updateEmergencyCallActive] emergencyCallActive is null");
                }
                this.emergencyCallActive = emergencyCallSetting2;
                this.updateGlobalTelephoneState(13);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateEmergencyNumbers(EmergencyNumbers emergencyNumbers, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateEmergencyNumbers] telEmerNums=%1", (Object)emergencyNumbers, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                EmergencyNumbers emergencyNumbers2 = null;
                if (emergencyNumbers != null) {
                    emergencyNumbers2 = new EmergencyNumbers(emergencyNumbers.mainEmergencyNumber, emergencyNumbers.additionalEmergencyNumber);
                } else {
                    this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener#updateEmergencyNumbers] telEmerNums is null");
                }
                this.telEmerNums = emergencyNumbers2;
                this.updateGlobalTelephoneState(2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateEnhancedPrivacyMode(boolean bl, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateEnhancedPrivacyMode] enhancedPrivacyMode=%1", bl, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.enhancedPrivacyMode = bl;
                this.updateGlobalTelephoneState(14);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateESimActive(boolean bl, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateESimActive] active=%1", bl, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.eSIMActive = bl;
                this.updateGlobalTelephoneState(44);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateESimB2BMode(boolean bl, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateESimB2BMode] active=%1", bl, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.eSIMB2BModeActive = bl;
                this.updateGlobalTelephoneState(45);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateESIMMSISDN(String string, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateESIMMSISDN] eSIMMSISDN=%1", (Object)string, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.eSIMMSISDN = string;
                this.updateGlobalTelephoneState(43);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateEUICCID(String string, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateEUICCID] eUICCID=%1", (Object)string, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.eUICCID = string;
                this.updateGlobalTelephoneState(42);
            }
        }
    }

    public void updateFavorites(Favorite[] favoriteArray, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateFavorites] favorites=%1 --> NOP!", (Object)TelLoggingUtils.objectArray2StringNewLines(favoriteArray), (Object)this.getInstanceAndRoleString());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateHandsFreeMode(int n, int n2) {
        if (n2 == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateHandsFreeMode] handsFreeMode=%1", (Object)String.valueOf(n), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.handsFreeMode = n;
                this.updateGlobalTelephoneState(15);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateLastAnsweredNumbers(CallStackEntry[] callStackEntryArray, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateLastAnsweredNumbers] lastAnsweredNumbers=%1", (Object)TelLoggingUtils.objectArray2StringNewLines(callStackEntryArray), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.lastAnsweredNumbers = callStackEntryArray;
                this.combinedCallStackEntries = TelCallStacksUtils.createCombinedCallStack(this.lastAnsweredNumbers, this.lastDialedNumbers, this.missedNumbers);
                this.updateGlobalTelephoneState(47);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateLastDialedNumbers(CallStackEntry[] callStackEntryArray, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateLastDialedNumbers] lastDialedNumbers=%1", (Object)TelLoggingUtils.objectArray2StringNewLines(callStackEntryArray), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.lastDialedNumbers = callStackEntryArray;
                this.combinedCallStackEntries = TelCallStacksUtils.createCombinedCallStack(this.lastAnsweredNumbers, this.lastDialedNumbers, this.missedNumbers);
                this.updateGlobalTelephoneState(48);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateLockState(final LockStateStruct lockStateStruct, final int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateLockState] lockState=%1", (Object)lockStateStruct, (Object)this.getInstanceAndRoleString());
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((ITelDSIMobileEquipementResponseListener)dSIListener).updateLockState(lockStateStruct, n);
                }
            });
            Object object = this.mutex;
            synchronized (object) {
                this.lockState = lockStateStruct;
                this.updateGlobalTelephoneState(16);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateMailboxContent(MailboxDialingNumber[] mailboxDialingNumberArray, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateMailboxContent] mailboxContent=%1", (Object)TelLoggingUtils.objectArray2StringNewLines(mailboxDialingNumberArray), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.mailboxContent = mailboxDialingNumberArray;
                this.updateGlobalTelephoneState(17);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateMEDataValidity(int n, int n2) {
        if (n2 == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateMEDataValidity] mEDataValidity=%1", (Object)String.valueOf(n), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.mEDataValidity = n;
                this.updateGlobalTelephoneState(50);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateMicGainLevel(int n, int n2) {
        if (n2 == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateMicGainLevel] micGainLevel=%1", (Object)String.valueOf(n), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.micGainLevel = n;
                this.updateGlobalTelephoneState(31);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateMICMuteState(int n, int n2) {
        if (n2 == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateMICMuteState] mICMuteState=%1", (Object)String.valueOf(n), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.mICMuteState = n;
                this.updateGlobalTelephoneState(18);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateMissedCallIndicator(MissedCallIndicator missedCallIndicator, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateMissedCallIndicator] missedCallIndicator=%1", (Object)missedCallIndicator, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                MissedCallIndicator missedCallIndicator2 = null;
                if (missedCallIndicator != null) {
                    missedCallIndicator2 = new MissedCallIndicator(missedCallIndicator.missedCall, missedCallIndicator.missedCallCount);
                }
                this.missedCallIndicator = missedCallIndicator2;
                this.updateGlobalTelephoneState(51);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateMissedNumbers(CallStackEntry[] callStackEntryArray, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateMissedNumbers] missedNumbers=%1", (Object)TelLoggingUtils.objectArray2StringNewLines(callStackEntryArray), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.missedNumbers = callStackEntryArray;
                this.combinedCallStackEntries = TelCallStacksUtils.createCombinedCallStack(this.lastAnsweredNumbers, this.lastDialedNumbers, this.missedNumbers);
                this.updateGlobalTelephoneState(49);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateNADMode(int n, int n2) {
        if (n2 == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateNADMode] nadMode=%1", (Object)String.valueOf(n), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.nadMode = n;
                this.updateGlobalTelephoneState(33);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateNADTemperature(NADTemperatureStruct nADTemperatureStruct, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateNADTemperature] nADTemperature=%1", (Object)nADTemperatureStruct, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.nADTemperature = nADTemperatureStruct;
                this.updateGlobalTelephoneState(19);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateNetworkProvider(NetworkProviderName networkProviderName, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateNetworkProvider] networkProvider=%1", (Object)networkProviderName, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.networkProvider = networkProviderName;
                this.updateGlobalTelephoneState(21);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateNetworkType(int n, int n2) {
        if (n2 == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateNetworkType] networkType=%1", (Object)String.valueOf(n), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.networkType = n;
                this.updateGlobalTelephoneState(22);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateOptimizationMode(int n, int n2) {
        if (n2 == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateOptimizationMode] optimizationMode=%1", (Object)String.valueOf(n), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.optimizationMode = n;
                this.updateGlobalTelephoneState(32);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateOtherSIMAvailable(boolean bl, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateOtherSIMAvailable] otherSIMAvailable=%1", bl, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.otherSIMAvailable = bl;
                this.updateGlobalTelephoneState(34);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePhoneInformation(PhoneInformation phoneInformation, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updatePhoneInformation] phoneInformation=%1", (Object)phoneInformation, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.phoneInformation = phoneInformation;
                this.updateGlobalTelephoneState(20);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePhoneReminderSetting(boolean bl, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updatePhoneReminderSetting] phoneReminderSetting=%1", bl, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.phoneReminderSetting = bl;
                this.updateGlobalTelephoneState(36);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePhoneRingtone(int n, String string, int n2) {
        if (n2 == 1) {
            Object object;
            if (this.log.isInfo()) {
                object = new Buffer();
                ((Buffer)object).append("ringtoneIndex=");
                ((Buffer)object).append(n);
                ((Buffer)object).append(", ");
                ((Buffer)object).append("ringtonePath=");
                ((Buffer)object).append(string);
                ((Buffer)object).append(", ");
                this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updatePhoneRingtone] %1", object, (Object)this.getInstanceAndRoleString());
            }
            object = this.mutex;
            synchronized (object) {
                this.ringtoneIndex = n;
                this.ringtonePath = string;
                this.updateGlobalTelephoneState(39);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePrefixActivated(boolean bl, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updatePrefixActivated] PrefixActivated=%1", bl, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.prefixActivated = bl;
                this.updateGlobalTelephoneState(37);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePrefixContent(String string, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updatePrefixContent] prefixContent=%1", (Object)string, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.prefixContent = string;
                this.updateGlobalTelephoneState(35);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePrivacyMode(boolean bl, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updatePrivacyMode] privacyMode=%1", bl, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.privacyMode = bl;
                this.updateGlobalTelephoneState(23);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateRegisterState(RegisterStateStruct registerStateStruct, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateRegisterState] registerState=%1", (Object)registerStateStruct, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.registerState = registerStateStruct;
                this.updateGlobalTelephoneState(24);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateSAPUpgradeActive(boolean bl, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateSAPUpgradeActive] active=%1", bl, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.sapUpgradeActive = bl;
                this.updateGlobalTelephoneState(41);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateServiceCodeType(final ServiceCodeTypeStruct serviceCodeTypeStruct, final int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateServiceCodeType] serviceCodeType=%1", (Object)serviceCodeTypeStruct, (Object)this.getInstanceAndRoleString());
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((ITelDSIMobileEquipementResponseListener)dSIListener).updateServiceCodeType(serviceCodeTypeStruct, n);
                }
            });
            Object object = this.mutex;
            synchronized (object) {
                this.serviceCodeType = serviceCodeTypeStruct;
                this.updateGlobalTelephoneState(25);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateServiceNumbers(ServiceNumbers serviceNumbers, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateServiceNumbers] serviceNumbers=%1", (Object)serviceNumbers, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.serviceNumbers = serviceNumbers;
                this.updateGlobalTelephoneState(26);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateServiceProvider(ServiceProvider serviceProvider, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateServiceProvider] serviceProvider=%1", (Object)serviceProvider, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.serviceProvider = serviceProvider;
                this.updateGlobalTelephoneState(29);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateSignalQuality(int n, int n2) {
        if (n2 == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateSignalQuality] signalQuality=%1", (Object)String.valueOf(n), (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.signalQuality = n;
                this.updateGlobalTelephoneState(27);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateSIMAliasInformation(SIMAliasInformation sIMAliasInformation, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateSIMAliasInformation] simAliasInformation=%1", (Object)sIMAliasInformation, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.simAliasInformation = sIMAliasInformation;
                this.updateGlobalTelephoneState(30);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateSIMPINRequired(boolean bl, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateSIMPINRequired] simPINRequired=%1", bl, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.simPINRequired = bl;
                this.updateGlobalTelephoneState(3);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateSuppServiceResponse(SuppServiceResponseStruct suppServiceResponseStruct, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateSuppServiceResponse] suppServiceResponse=%1", (Object)suppServiceResponseStruct, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.suppServiceResponse = suppServiceResponseStruct;
                this.updateGlobalTelephoneState(28);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateWidebandSpeech(boolean bl, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateWidebandSpeech] active=%1", bl, (Object)this.getInstanceAndRoleString());
            Object object = this.mutex;
            synchronized (object) {
                this.widebandSpeechActive = bl;
                this.updateGlobalTelephoneState(38);
            }
        }
    }

    public void updateSpeechRecognitionAvailable(int n, int n2) {
    }

    public void updateSpeechRecognitionActive(int n, int n2) {
    }

    public void updateSpeechRecognitionType(int n, int n2) {
    }

    public void responseStartSpeechRecognition(int n) {
    }

    public void responseStopSpeechRecognition(int n) {
    }
}

