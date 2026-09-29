/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.callstacks.TelCallStacksUtils;
import de.audi.app.phone.core.dsi.AbstractDSIMobileEquipementListener;
import de.audi.app.phone.core.dsi.TelActivationStateStruct;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$1;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$10;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$11;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$12;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$13;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$14;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$15;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$16;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$17;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$18;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$19;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$2;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$20;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$21;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$22;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$23;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$24;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$25;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$26;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$27;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$28;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$29;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$3;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$30;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$31;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$32;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$33;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$34;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$35;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$36;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$37;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$4;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$5;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$6;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$7;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$8;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener$9;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.esolutions.fw.util.commons.Buffer;
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

    @Override
    public CommandList getActiveCommandList() {
        return this.commandListManager.getActiveCommandList();
    }

    @Override
    public String getHandlerName() {
        return "TelDSIMobileEquipmentListener";
    }

    @Override
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
        this.log.log(-1601830656, "[TelDSIMobilEquipmentListener(%2)#asyncException] %1", (Object)buffer, (Object)this.getInstanceAndRoleString());
    }

    @Override
    public void responseAbortNetworkRegistration(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseAbortNetworkRegistration] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$1(this, n));
    }

    @Override
    public void responseAbortNetworkSearch(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseAbortNetworkSearch] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$2(this, n));
    }

    @Override
    public void responseAcceptCall(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseAcceptCall] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$3(this, n));
    }

    @Override
    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseCallForward] telCFResponseData=%1, result=%2", (Object)TelLoggingUtils.objectArray2StringNewLines(cFResponseDataArray), (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$4(this, cFResponseDataArray, n));
    }

    @Override
    public void responseCallWaiting(int n, int n2) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseCallWaiting] telCWStatus=%1, result=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$5(this, n, n2));
    }

    @Override
    public void responseChangeSIMCode(int n, int n2) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseChangeSIMCode] telLockCode=%1, result=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$6(this, n, n2));
    }

    @Override
    public void responseCheckSIMPINCode(int n) {
        this.log.log(-1601830656, "[TelDSIMobileEquipmentListener#responseCheckSIMPINCode] not supported --> NOP!");
    }

    @Override
    public void responseCLIR(int n, int n2, int n3) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseCLIR] telCLIRState=%1, telCLIRNWState=%2, result=%3", (long)n, (long)n2, (long)n3);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$7(this, n, n2, n3));
    }

    @Override
    public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseDialNumber] result=%2, telSuppServResult=%1", (Object)suppServiceResponseStruct, (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$8(this, n, suppServiceResponseStruct));
    }

    @Override
    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseDialOperator] result=%2, telSuppServResult=%1", (Object)suppServiceResponseStruct, (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$9(this, n, suppServiceResponseStruct));
    }

    @Override
    public void responseHangupCall(int n) {
        CommandResponse.execute(new TelDSIMobileEquipmentListener$10(this), new TelDSIMobileEquipmentListener$11(this, n));
    }

    @Override
    public void responseJoinCalls(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseJoinCalls] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$12(this, n));
    }

    @Override
    public void responseNetworkRegistration(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseNetworkRegistration] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$13(this, n));
    }

    @Override
    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseNetworkSearch] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$14(this, networkProviderArray, n));
    }

    @Override
    public void responseRemoveOtherSIM(int n) {
        this.log.log(-1601830656, "[TelDSIMobileEquipmentListener#responseRemoveOtherSIM] not supported --> NOP!");
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseRestoreFactorySettings] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$15(this, n));
    }

    @Override
    public void responseSendDTMF(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSendDTMF] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$16(this, n));
    }

    @Override
    public void responseServiceCodeAbort(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseServiceCodeAbort] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$17(this, n));
    }

    @Override
    public void responseSetAutomaticEmergencyCallActive(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSetAutomaticEmergencyCallActive] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$18(this, n));
    }

    @Override
    public void responseSetAutomaticPinEntryActive(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSetAutomaticPinEntryActive] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$19(this, n));
    }

    @Override
    public void responseSetAutomaticRedialActive(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSetAutomaticRedialActive] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$20(this, n));
    }

    @Override
    public void responseSetCDMAThreeWayCallingSetting(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSetCDMAThreeWayCallingSetting] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$21(this, n));
    }

    @Override
    public void responseSetESIMActive(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSetESIMActive] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$22(this, n));
    }

    @Override
    public void responseSetFavorites(int n) {
        this.log.log(-1601830656, "[TelDSIMobileEquipmentListener#responseSetFavorites] not supported --> NOP!");
    }

    @Override
    public void responseSetHandsFreeMode(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSetHandsFreeMode] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$23(this, n));
    }

    @Override
    public void responseSetMailboxContent(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSetMailboxContent] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$24(this, n));
    }

    @Override
    public void responseSetMICMuteState(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSetMICMuteState] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$25(this, n));
    }

    @Override
    public void responseSetNADMode(int n, int n2) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSetNADMode] result=%1", (long)n2);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$26(this, n, n2));
    }

    @Override
    public void responseSetOptimizationMode(int n, int n2) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSetOptimizationMode] result=%1", (long)n2);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$27(this, n, n2));
    }

    @Override
    public void responseSetPhoneReminderSetting(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSetPhoneReminderSetting] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$28(this, n));
    }

    @Override
    public void responseSetPhoneRingtone(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSetPhoneRingtone] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$29(this, n));
    }

    @Override
    public void responseSetPrefixActivated(int n) {
        this.log.log(-1601830656, "[TelDSIMobileEquipmentListener#responseSetPrefixActivated] not supported --> NOP!");
    }

    @Override
    public void responseSetPrefixContent(int n) {
        this.log.log(-1601830656, "[TelDSIMobileEquipmentListener#responseSetPrefixContent] not supported --> NOP!");
    }

    @Override
    public void responseSetPrivacyMode(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSetPrivacyMode] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$30(this, n));
    }

    @Override
    public void responseSetSIMAliases(int n) {
        this.log.log(-1601830656, "[TelDSIMobileEquipmentListener#responseSetSIMAliases] not supported --> NOP!");
    }

    @Override
    public void responseSetSIMName(int n) {
        this.log.log(-1601830656, "[TelDSIMobileEquipmentListener#responseSetSIMName] not supported --> NOP!");
    }

    @Override
    public void responseSIMPINRequired(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSIMPINRequired] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$31(this, n));
    }

    @Override
    public void responseSplitCall(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSplitCall] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$32(this, n));
    }

    @Override
    public void responseSwapCalls(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseSwapCalls] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$33(this, n));
    }

    @Override
    public void responseTelPower(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseTelPower] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$34(this, n));
    }

    @Override
    public void responseUnlockOtherSIM(int n) {
        this.log.log(-1601830656, "[TelDSIMobileEquipmentListener#responseUnlockOtherSIM] not supported --> NOP!");
    }

    @Override
    public void responseUnlockSIM(int n) {
        this.log.log(-2137614336, "[TelDSIMobileEquipmentListener#responseUnlockSIM] result=%1", (long)n);
        CommandResponse.execute(this, new TelDSIMobileEquipmentListener$35(this, n));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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

    @Override
    public void updateFavorites(Favorite[] favoriteArray, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateFavorites] favorites=%1 --> NOP!", (Object)TelLoggingUtils.objectArray2StringNewLines(favoriteArray), (Object)this.getInstanceAndRoleString());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
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
    @Override
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
    @Override
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
    @Override
    public void updateLockState(LockStateStruct lockStateStruct, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateLockState] lockState=%1", (Object)lockStateStruct, (Object)this.getInstanceAndRoleString());
            CommandResponse.execute(this, new TelDSIMobileEquipmentListener$36(this, lockStateStruct, n));
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
        if (n == 1) {
            this.log.log(this.getLogLevelFromRole(), "[TelDSIMobileEquipmentListener(%2)#updateServiceCodeType] serviceCodeType=%1", (Object)serviceCodeTypeStruct, (Object)this.getInstanceAndRoleString());
            CommandResponse.execute(this, new TelDSIMobileEquipmentListener$37(this, serviceCodeTypeStruct, n));
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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

    @Override
    public void updateSpeechRecognitionAvailable(int n, int n2) {
    }

    @Override
    public void updateSpeechRecognitionActive(int n, int n2) {
    }

    @Override
    public void updateSpeechRecognitionType(int n, int n2) {
    }

    @Override
    public void responseStartSpeechRecognition(int n) {
    }

    @Override
    public void responseStopSpeechRecognition(int n) {
    }

    static /* synthetic */ CommandListManager access$000(TelDSIMobileEquipmentListener telDSIMobileEquipmentListener) {
        return telDSIMobileEquipmentListener.hangupCmdListManager;
    }
}

