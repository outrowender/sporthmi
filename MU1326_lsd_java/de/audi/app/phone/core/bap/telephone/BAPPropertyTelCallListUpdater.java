/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.addressbook.core.combi.bap.CombiADBUtils;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelCallListUpdater$1;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelCallListUpdater$ITelEMPTerminalModeUpdateListener;
import de.audi.app.phone.core.bap.telephone.TelBAPCall;
import de.audi.app.phone.core.bap.telephone.TelBAPCallArrayAccess;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.combi.bap.phone.data.CallStartTime;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallInfo;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallState;
import de.audi.atip.interapp.phone.IEcallState;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Converter;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.telephoneng.CallInformation;

public class BAPPropertyTelCallListUpdater
extends AbstractTel1EnqueuedBAPPropertyHandler {
    public static final int MAX_NR_CALLS;
    public static final int CALL_ID_CONFERENCE_DUMMY;
    private final TelBAPCallArrayAccess callArrayAccess;
    private final DefaultTerminalModeUpdateListener tmUpdateListener;
    private final PhoneServiceProvider terminalModeUpdateListnerService;
    private volatile boolean pActiveDeviceAndroidAuto;
    private volatile boolean isTMVideoFocus = false;
    private final boolean isG24;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener;

    public BAPPropertyTelCallListUpdater(ITelApplication iTelApplication, DispatcherBase dispatcherBase, TelBAPCallArrayAccess telBAPCallArrayAccess) {
        super(iTelApplication, dispatcherBase);
        this.callArrayAccess = telBAPCallArrayAccess;
        this.tmUpdateListener = new BAPPropertyTelCallListUpdater$ITelEMPTerminalModeUpdateListener(this, null);
        this.terminalModeUpdateListnerService = new PhoneServiceProvider((class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = BAPPropertyTelCallListUpdater.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener).getName(), this.tmUpdateListener, null, iTelApplication.getBundleContext(), this.log);
        this.isG24 = this.getApplication().getFrameworkAccess().getSysConst(522) == 4;
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(new BAPPropertyTelCallListUpdater$1(this));
    }

    @Override
    public void deinit() {
        this.terminalModeUpdateListnerService.stopService();
        super.deinit();
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && (n == 0x8000100 || n == 0x8000200 || n == 0x8000300 || n == 0xC000400);
    }

    @Override
    protected void updateAsync() {
        IEcallState iEcallState;
        this.setCombiCallArray(this.getTelephoneState());
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        IEcallState iEcallState2 = iEcallState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getConnectedGatewayState() : null;
        if (combiBAPServicePhone != null) {
            PhoneCall phoneCall;
            boolean bl = false;
            PhoneCall phoneCall2 = phoneCall = iEcallState != null ? iEcallState.getCall() : null;
            if (phoneCall != null && phoneCall.isServiceCall()) {
                CombiBAPCallState[] combiBAPCallStateArray = new CombiBAPCallState[7];
                combiBAPCallStateArray[0] = new CombiBAPCallState(phoneCall.getState(), 7, 0);
                this.log.log(1078071040, "[BAPPropertyTelCallListUpdater#updateAsync] serviceCall callStates=%1, eCallConfirmationPending=%2", (Object)Converter.array2String(combiBAPCallStateArray), (Object)String.valueOf(bl));
                combiBAPServicePhone.updateCallStates(combiBAPCallStateArray, bl);
            } else if (phoneCall != null && phoneCall.isLowPrioritySOSCall()) {
                CombiBAPCallState[] combiBAPCallStateArray = new CombiBAPCallState[7];
                combiBAPCallStateArray[0] = new CombiBAPCallState(phoneCall.getState(), 1, 0);
                this.log.log(1078071040, "[BAPPropertyTelCallListUpdater#updateAsync] emergencyCall callStates=%1, eCallConfirmationPending=%2", (Object)Converter.array2String(combiBAPCallStateArray), (Object)String.valueOf(bl));
                combiBAPServicePhone.updateCallStates(combiBAPCallStateArray, bl);
                CombiBAPCallInfo[] combiBAPCallInfoArray = new CombiBAPCallInfo[7];
                String string = iEcallState.getEmergencyNumberToBeDialed();
                String string2 = PhoneUtils.getSOSCallTextConstant(this.getApplication().geEmergencyTextFactory(), string);
                combiBAPCallInfoArray[0] = new CombiBAPCallInfo(string2, string, 1, CombiADBUtils.getCombiPhoneType(8));
                combiBAPServicePhone.updateCallInfo(combiBAPCallInfoArray);
            } else if (iGlobalTelephoneStateStruct != null) {
                Object[] objectArray = this.callArrayAccess.getCallStateArray();
                Object[] objectArray2 = this.callArrayAccess.getCallInfoArray();
                Object[] objectArray3 = this.callArrayAccess.getCallStartingTimesArray();
                this.log.log(1078071040, "[BAPPropertyTelCallListUpdater#updateAsync] callStates=%1, eCallConfirmationPending=%2", (Object)TelLoggingUtils.objectArray2StringNewLines(objectArray), (Object)String.valueOf(bl));
                combiBAPServicePhone.updateCallStates((CombiBAPCallState[])objectArray, bl);
                this.log.log(1078071040, "[BAPPropertyTelCallListUpdater#updateAsync] callInfos=%1", (Object)TelLoggingUtils.objectArray2StringNewLines(objectArray2));
                combiBAPServicePhone.updateCallInfo((CombiBAPCallInfo[])objectArray2);
                this.log.log(1078071040, "[BAPPropertyTelCallListUpdater#updateAsync] startTimes=%1", (Object)TelLoggingUtils.objectArray2StringNewLines(objectArray3));
                combiBAPServicePhone.updateCallDurations((CallStartTime[])objectArray3);
            } else {
                this.log.log(-1601830656, "[BAPPropertyTelCallState#update] state is null --> NOP!");
            }
        } else {
            this.log.log(-1601830656, "[BAPPropertyTelCallState#update] CombiBAPServicePhone is null --> NOP!");
        }
    }

    public void updateEcallState(boolean bl) {
        this.log.log(-2137614336, "BAPPropertyTelCallListUpdater#updateEcallState(): is ecall active: %1", bl);
    }

    private void setCombiCallArray(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        AbstractPhoneCall abstractPhoneCall;
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-2137614336, "[BAPPropertyTelCallListUpdater#setCombiCallArray] telState is null --> NOP!");
            return;
        }
        Object[] objectArray = new TelBAPCall[7];
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iGlobalTelephoneStateStruct.getNonCallLeadingDevice();
        CallStateStruct callStateStruct = this.getDeviceCallStateStruct(iGlobalTelephoneStateStruct, iTelDSIMobileEquipmentDeviceState);
        CallStateStruct callStateStruct2 = this.getDeviceCallStateStruct(iGlobalTelephoneStateStruct, iTelDSIMobileEquipmentDeviceState2);
        CallInformation[] callInformationArray = callStateStruct != null ? callStateStruct.getDsiCallList() : null;
        boolean bl = callStateStruct != null && callStateStruct.isHasIncomingCall();
        boolean bl2 = callStateStruct2 != null && callStateStruct2.isHasIncomingCall();
        int n = 0;
        if (callInformationArray != null && callInformationArray != null) {
            for (int i2 = 0; i2 < callInformationArray.length; ++i2) {
                CallInformation callInformation = callInformationArray[i2];
                if (!this.isCallValid(n, callInformation)) continue;
                if (this.isG24 && this.pActiveDeviceAndroidAuto && this.isTMVideoFocus && callInformation.getTelCallState() == 3) {
                    this.log.log(1078071040, "[BAPPropertyTelCallListUpdater#updateAsync] G24, AA active, currentVideoFocus is AA => do not add the incoming call into the call list");
                    continue;
                }
                objectArray[n++] = new TelBAPCall(callInformation, iTelDSIMobileEquipmentDeviceState, true, this.getApplication().getTextFactory());
            }
        }
        if (bl2 && !bl && this.isCallValid(n, abstractPhoneCall = callStateStruct2.getIncomingCall())) {
            objectArray[n] = new TelBAPCall(abstractPhoneCall, iTelDSIMobileEquipmentDeviceState2, false, this.getApplication().getTextFactory());
        }
        this.log.log(-2137614336, "[BAPPropertyTelCallListUpdater#setCombiCallArray] bapPhoneCallArray=%1", (Object)TelLoggingUtils.objectArray2StringNewLines(objectArray));
        this.callArrayAccess.setArray((TelBAPCall[])objectArray);
    }

    private boolean isCallValid(int n, CallInformation callInformation) {
        return callInformation != null && callInformation.getTelCallID() != 254 && n >= 0 && n < 7;
    }

    private CallStateStruct getDeviceCallStateStruct(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iGlobalTelephoneStateStruct != null && iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() : null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ITelApplication access$100(BAPPropertyTelCallListUpdater bAPPropertyTelCallListUpdater) {
        return bAPPropertyTelCallListUpdater.getApplication();
    }

    static /* synthetic */ PhoneServiceProvider access$200(BAPPropertyTelCallListUpdater bAPPropertyTelCallListUpdater) {
        return bAPPropertyTelCallListUpdater.terminalModeUpdateListnerService;
    }

    static /* synthetic */ LogChannel access$300(BAPPropertyTelCallListUpdater bAPPropertyTelCallListUpdater) {
        return bAPPropertyTelCallListUpdater.log;
    }

    static /* synthetic */ boolean access$402(BAPPropertyTelCallListUpdater bAPPropertyTelCallListUpdater, boolean bl) {
        bAPPropertyTelCallListUpdater.pActiveDeviceAndroidAuto = bl;
        return bAPPropertyTelCallListUpdater.pActiveDeviceAndroidAuto;
    }

    static /* synthetic */ boolean access$400(BAPPropertyTelCallListUpdater bAPPropertyTelCallListUpdater) {
        return bAPPropertyTelCallListUpdater.pActiveDeviceAndroidAuto;
    }

    static /* synthetic */ LogChannel access$500(BAPPropertyTelCallListUpdater bAPPropertyTelCallListUpdater) {
        return bAPPropertyTelCallListUpdater.log;
    }

    static /* synthetic */ LogChannel access$600(BAPPropertyTelCallListUpdater bAPPropertyTelCallListUpdater) {
        return bAPPropertyTelCallListUpdater.log;
    }

    static /* synthetic */ boolean access$702(BAPPropertyTelCallListUpdater bAPPropertyTelCallListUpdater, boolean bl) {
        bAPPropertyTelCallListUpdater.isTMVideoFocus = bl;
        return bAPPropertyTelCallListUpdater.isTMVideoFocus;
    }

    static /* synthetic */ boolean access$800(BAPPropertyTelCallListUpdater bAPPropertyTelCallListUpdater) {
        return bAPPropertyTelCallListUpdater.isG24;
    }

    static /* synthetic */ boolean access$700(BAPPropertyTelCallListUpdater bAPPropertyTelCallListUpdater) {
        return bAPPropertyTelCallListUpdater.isTMVideoFocus;
    }

    static /* synthetic */ void access$900(BAPPropertyTelCallListUpdater bAPPropertyTelCallListUpdater) {
        bAPPropertyTelCallListUpdater.enqueueUpdate();
    }
}

