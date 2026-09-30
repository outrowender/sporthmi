/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelCallListUpdater;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelCombinedNumbers;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelDisconnectReason;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelFSGOperationState;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelFSGSetup;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelLockState;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelMicroMuteOnOff;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelMissedCallIndication;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelMobileBatteryLevel;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelMobileServiceSupport;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelNetworkProvider;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelRegisterState;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelRingtoneMute;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelSignalQuality;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelSupportedServiceNumbers;
import de.audi.app.phone.core.bap.telephone.TelBAPCallArrayAccess;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodAcceptCallHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodCallHoldHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodCallResumeHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodConfirmEmergencyCallHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodDialNumberFromAdbEntryHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodDialNumberHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodDialServiceHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodHangupCallHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodHoldActiveCallAcceptWaitingCallHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodJoinCallsHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodMicMuteHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodReleaseAllCallsAcceptWaitingCall;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodResetMissedCallsIndicator;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodRingtoneMuteHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodSetAutomaticRedialActive;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodSetWaitingCallonHoldHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodSplitCallHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodSwapCallsHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhoneListener;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallStackEntry;
import de.audi.atip.job.JobLogger;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class TelBAPManagerTel1
extends AbstractPhoneComponent
implements CombiBAPServicePhoneListener {
    private volatile PhoneServiceProvider combiBapServicePhoneListenerService;
    private final DispatcherBase bapCombiDispatcher;
    private final TelBAPCallArrayAccess callArrayAccess;
    private final TelBAPMethodDialNumberHandler dialNumberHandler;
    private final TelBAPMethodDialNumberFromAdbEntryHandler dialNumberFromAdbEntryHandler;
    private final TelBAPMethodDialServiceHandler dialServiceHandler;
    private final TelBAPMethodConfirmEmergencyCallHandler confirmEmergencyCallHandler;
    private final TelBAPMethodHangupCallHandler hangupCallHandler;
    private final TelBAPMethodAcceptCallHandler acceptCallHandler;
    private final TelBAPMethodCallHoldHandler callHoldHandler;
    private final TelBAPMethodCallResumeHandler callResumeHandler;
    private final TelBAPMethodMicMuteHandler micMuteHandler;
    private final TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler releaseActiveCallAcceptWaitingCallHandler;
    private final TelBAPMethodSwapCallsHandler swapCallsHandler;
    private final TelBAPMethodHoldActiveCallAcceptWaitingCallHandler holdActiveCallAcceptWaitingCallHandler;
    private final TelBAPMethodSetWaitingCallonHoldHandler setWaitingCallOnHoldHandler;
    private final TelBAPMethodJoinCallsHandler joinCallsHandler;
    private final TelBAPMethodSplitCallHandler splitCallsHandler;
    private final TelBAPMethodRingtoneMuteHandler ringtoneMuteHandler;
    private final TelBAPMethodReleaseAllCallsAcceptWaitingCall releaseAllCallsAcceptWaitingCallHandler;
    private final TelBAPMethodSetAutomaticRedialActive setAutomaticRedialActiveHandler;
    private final TelBAPMethodResetMissedCallsIndicator resetMissedCallsIndicatorHandler;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhoneListener;

    public TelBAPManagerTel1(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
        this.callArrayAccess = new TelBAPCallArrayAccess(this.log);
        JobLogger jobLogger = new JobLogger(iTelApplication.getFrameworkAccess().getLogChannel("App.Phone.BAP.CL"));
        this.bapCombiDispatcher = iTelApplication.getFrameworkAccess().getDispatcherManager().createDispatcher("TEL_1_BAP_COMBI_DISPATCHER", jobLogger);
        this.dialNumberHandler = new TelBAPMethodDialNumberHandler(iTelApplication, this.bapCombiDispatcher);
        this.dialNumberFromAdbEntryHandler = new TelBAPMethodDialNumberFromAdbEntryHandler(iTelApplication, this.bapCombiDispatcher);
        this.dialServiceHandler = new TelBAPMethodDialServiceHandler(iTelApplication, this.bapCombiDispatcher);
        this.confirmEmergencyCallHandler = new TelBAPMethodConfirmEmergencyCallHandler(iTelApplication, this.bapCombiDispatcher);
        this.hangupCallHandler = new TelBAPMethodHangupCallHandler(iTelApplication, this.bapCombiDispatcher, this.callArrayAccess);
        this.acceptCallHandler = new TelBAPMethodAcceptCallHandler(iTelApplication, this.bapCombiDispatcher);
        this.callHoldHandler = new TelBAPMethodCallHoldHandler(iTelApplication, this.bapCombiDispatcher);
        this.callResumeHandler = new TelBAPMethodCallResumeHandler(iTelApplication, this.bapCombiDispatcher);
        this.micMuteHandler = new TelBAPMethodMicMuteHandler(iTelApplication, this.bapCombiDispatcher);
        this.releaseActiveCallAcceptWaitingCallHandler = new TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler(iTelApplication, this.bapCombiDispatcher);
        this.swapCallsHandler = new TelBAPMethodSwapCallsHandler(iTelApplication, this.bapCombiDispatcher);
        this.holdActiveCallAcceptWaitingCallHandler = new TelBAPMethodHoldActiveCallAcceptWaitingCallHandler(iTelApplication, this.bapCombiDispatcher);
        this.setWaitingCallOnHoldHandler = new TelBAPMethodSetWaitingCallonHoldHandler(iTelApplication, this.bapCombiDispatcher);
        this.joinCallsHandler = new TelBAPMethodJoinCallsHandler(iTelApplication, this.bapCombiDispatcher);
        this.splitCallsHandler = new TelBAPMethodSplitCallHandler(iTelApplication, this.bapCombiDispatcher, this.callArrayAccess);
        this.ringtoneMuteHandler = new TelBAPMethodRingtoneMuteHandler(iTelApplication, this.bapCombiDispatcher);
        this.releaseAllCallsAcceptWaitingCallHandler = new TelBAPMethodReleaseAllCallsAcceptWaitingCall(iTelApplication, this.bapCombiDispatcher);
        this.setAutomaticRedialActiveHandler = new TelBAPMethodSetAutomaticRedialActive(iTelApplication, this.bapCombiDispatcher);
        this.resetMissedCallsIndicatorHandler = new TelBAPMethodResetMissedCallsIndicator(iTelApplication, this.bapCombiDispatcher);
        this.addSubPhoneComponent(new BAPPropertyTelMobileServiceSupport(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTelFSGSetup(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTelFSGOperationState(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTelRegisterState(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTelMobileBatteryLevel(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTelMicroMuteOnOff(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTelMissedCallIndication(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTelSignalQuality(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTelNetworkProvider(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTelSupportedServiceNumbers(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTelDisconnectReason(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTelCallListUpdater(iTelApplication, this.bapCombiDispatcher, this.callArrayAccess));
        this.addSubPhoneComponent(new BAPPropertyTelLockState(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTelCombinedNumbers(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(new BAPPropertyTelRingtoneMute(iTelApplication, this.bapCombiDispatcher));
        this.addSubPhoneComponent(this.dialNumberHandler);
        this.addSubPhoneComponent(this.dialNumberFromAdbEntryHandler);
        this.addSubPhoneComponent(this.dialServiceHandler);
        this.addSubPhoneComponent(this.confirmEmergencyCallHandler);
        this.addSubPhoneComponent(this.hangupCallHandler);
        this.addSubPhoneComponent(this.acceptCallHandler);
        this.addSubPhoneComponent(this.callHoldHandler);
        this.addSubPhoneComponent(this.callResumeHandler);
        this.addSubPhoneComponent(this.micMuteHandler);
        this.addSubPhoneComponent(this.releaseActiveCallAcceptWaitingCallHandler);
        this.addSubPhoneComponent(this.swapCallsHandler);
        this.addSubPhoneComponent(this.holdActiveCallAcceptWaitingCallHandler);
        this.addSubPhoneComponent(this.setWaitingCallOnHoldHandler);
        this.addSubPhoneComponent(this.joinCallsHandler);
        this.addSubPhoneComponent(this.splitCallsHandler);
        this.addSubPhoneComponent(this.ringtoneMuteHandler);
        this.addSubPhoneComponent(this.releaseAllCallsAcceptWaitingCallHandler);
        this.addSubPhoneComponent(this.setAutomaticRedialActiveHandler);
    }

    public void init() {
        super.init();
        this.bapCombiDispatcher.start();
        this.combiBapServicePhoneListenerService = new PhoneServiceProvider((class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhoneListener == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhoneListener = TelBAPManagerTel1.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhoneListener")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhoneListener).getName(), this, null, this.getApplication().getBundleContext(), this.log);
        this.combiBapServicePhoneListenerService.startService();
    }

    public void deinit() {
        super.deinit();
        this.bapCombiDispatcher.stop();
        if (this.combiBapServicePhoneListenerService != null) {
            this.combiBapServicePhoneListenerService.stopService();
        }
    }

    public void dialNumber(String string, String string2) {
        this.log.log(1000000, "[TelBAPManagerTel1#dialNumber] telNumber=%1, name=%2", (Object)string, (Object)string2);
        this.dialNumberHandler.dialNumber(string, string2);
    }

    public void dialNumberFromAdbEntry(String string, String string2, CombiBAPCallStackEntry combiBAPCallStackEntry) {
        if (combiBAPCallStackEntry == null) {
            this.log.log(10000, "TelBAPManagerTel1#dialNumberFromAdbEntry adbEntry is null");
            return;
        }
        this.log.log(1000000, new StringBuffer().append("[TelBAPManagerTel1#dialNumberFromAdbEntry] telNumber=%1, name=%2, entryID=").append(combiBAPCallStackEntry.getCallStackEntry().getAdbEntryID()).toString(), (Object)combiBAPCallStackEntry.getCallStackEntry().getClNumber(), (Object)combiBAPCallStackEntry.getCallStackEntry().getClName());
        this.dialNumberFromAdbEntryHandler.dialNumberFromAdbEntry(string, string2, combiBAPCallStackEntry.getCallStackEntry());
    }

    public void dialService(int n) {
        this.log.log(1000000, "[TelBAPManagerTel1#dialService] serviceType=%1", (long)n);
        this.dialServiceHandler.dialService(n);
    }

    public void confirmEmergencyCall(boolean bl) {
        this.log.log(1000000, "[TelBAPManagerTel1#confirmEmergencyCall] confirmed", bl);
        this.confirmEmergencyCallHandler.confirmEmergencyCall(bl);
    }

    public void hangupCall(int n) {
        this.log.log(1000000, "[TelBAPManagerTel1#hangupCall] index=%1", (long)n);
        this.hangupCallHandler.hangupCall(n);
    }

    public void acceptCall() {
        this.log.log(1000000, "[TelBAPManagerTel1#acceptCall]");
        this.acceptCallHandler.acceptCall();
    }

    public void callHold() {
        this.log.log(1000000, "[TelBAPManagerTel1#callHold]");
        this.callHoldHandler.callHold();
    }

    public void resumeCall() {
        this.log.log(1000000, "[TelBAPManagerTel1#resumeCall]");
        this.callResumeHandler.resumeCall();
    }

    public void setMicMuteState(boolean bl) {
        this.log.log(1000000, "[TelBAPManagerTel1#setMicMuteState] micMuteState=%1", bl);
        this.micMuteHandler.setMicMuteState(bl);
    }

    public void releaseActiveCallAcceptWaitingCall() {
        this.log.log(1000000, "[TelBAPManagerTel1#releaseActiveCallAcceptWaitingCall]");
        this.releaseActiveCallAcceptWaitingCallHandler.releaseActiveCallAcceptWaitingCall();
    }

    public void swapCalls() {
        this.log.log(1000000, "[TelBAPManagerTel1#swapCalls]");
        this.swapCallsHandler.swapCalls();
    }

    public void callHoldAcceptWaitingCall() {
        this.log.log(1000000, "[TelBAPManagerTel1#callHoldAcceptWaitingCall]");
        this.holdActiveCallAcceptWaitingCallHandler.callHoldActiveAcceptWaitingCall();
    }

    public void releaseAllCallsAcceptWaitingCall() {
        this.log.log(100000, "[TelBAPManagerTel1#releaseAllCallsAcceptWaitingCall] not implemented!");
        this.releaseAllCallsAcceptWaitingCallHandler.releaseAllCallsAcceptWaitingCall();
    }

    public void setWaitingCallOnHold() {
        this.log.log(1000000, "[TelBAPManagerTel1#setWaitingCallOnHold]");
        this.setWaitingCallOnHoldHandler.setWaitingCallOnHold();
    }

    public void joinCalls() {
        this.log.log(1000000, "[TelBAPManagerTel1#joinCalls]");
        this.joinCallsHandler.joinCalls();
    }

    public void splitCall(int n) {
        this.log.log(1000000, "[TelBAPManagerTel1#splitCall] callId", (long)n);
        this.splitCallsHandler.splitCall(n);
    }

    public void setRingToneMuteState(boolean bl) {
        this.log.log(1000000, "[TelBAPManagerTel1#setRingToneMuteState] ringToneMuted=%1", bl);
        this.ringtoneMuteHandler.setRingToneMuteState(bl);
    }

    public void setAutomaticRedialActive(boolean bl) {
        this.log.log(100000, "[TelBAPManagerTel1#setAutomaticRedialActive] automaticRedialActive=%1 - not supported", bl);
        this.setAutomaticRedialActiveHandler.setAutomaticRedialActive(bl);
    }

    public void resetMissedCallsIndicator() {
        this.log.log(1000000, "[TelBAPManagerTel1#resetMissedCallsIndicator] ");
        this.resetMissedCallsIndicatorHandler.resetMissedCallsIndicator();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

