/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.callcontrol;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.callcontrol.ITelCallControl;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.interapp.phone.ITelEcallService;
import de.audi.atip.interapp.phone.NullTelEcallService;
import de.esolutions.fw.util.commons.Buffer;

public class TelCallControlBase
extends AbstractPhoneComponent
implements ITelCallControl,
ButtonListener {
    private volatile IGlobalTelephoneStateStruct state;
    private volatile ITelEcallService telEcallService;
    private final TelEcallServiceTracker telEcallServiceTracker;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelEcallService;

    public TelCallControlBase(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.telEcallServiceTracker = new TelEcallServiceTracker(iTelApplication);
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getAcceptButton().setButtonListener(this);
        this.getRejectButton().setButtonListener(this);
        this.getSwapButton().setButtonListener(this);
        this.getJoinToConferenceButton().setButtonListener(this);
        this.getHangupButton().setButtonListener(this);
        this.getReplaceButton().setButtonListener(this);
        this.getResponseAndHoldButton().setButtonListener(this);
        this.telEcallServiceTracker.init();
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getAcceptButton().resetListener();
        this.getRejectButton().resetListener();
        this.getSwapButton().resetListener();
        this.getJoinToConferenceButton().resetListener();
        this.getHangupButton().resetListener();
        this.getReplaceButton().resetListener();
        this.getResponseAndHoldButton().resetListener();
        this.telEcallServiceTracker.deinit();
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.state = iGlobalTelephoneStateStruct;
    }

    protected ButtonModelApp getAcceptButton() {
        return this.getButtonModel(301151);
    }

    protected ButtonModelApp getRejectButton() {
        return this.getButtonModel(301154);
    }

    protected ButtonModelApp getSwapButton() {
        return this.getButtonModel(300302);
    }

    protected ButtonModelApp getJoinToConferenceButton() {
        return this.getButtonModel(300660);
    }

    protected ButtonModelApp getHangupButton() {
        return this.getButtonModel(300645);
    }

    protected ButtonModelApp getReplaceButton() {
        return this.getButtonModel(300232);
    }

    protected ButtonModelApp getResponseAndHoldButton() {
        return this.getButtonModel(301157);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("modelID=");
            buffer.append(n);
            buffer.append(", ");
            buffer.append("keyID=");
            buffer.append(n2);
            buffer.append(", ");
            buffer.append("terminalID=");
            buffer.append(n3);
            this.log.log(1000000, "[TelCallControlBase#keyTyped] %1", (Object)buffer);
        }
        if (n == this.getAcceptButton().getID()) {
            this.acceptIncomingCall(n3);
        } else if (n == this.getRejectButton().getID()) {
            this.rejectIncomingCall(n3);
        } else if (n == this.getSwapButton().getID()) {
            this.swapCalls(n3);
        } else if (n == this.getJoinToConferenceButton().getID()) {
            this.joinCallsToConference(n3);
        } else if (n == this.getHangupButton().getID()) {
            this.hangupCall(n3);
        } else if (n == this.getReplaceButton().getID()) {
            this.replaceActiveCallWithIncomingCall(n3);
        } else if (n == this.getResponseAndHoldButton().getID()) {
            this.placeIncomingCallOnHold(n3);
        } else {
            this.log.log(10000000, "[TelCallControlBase#keyTyped] unhandled modelID %1", (long)n);
        }
    }

    private void placeIncomingCallOnHold(int n) {
        this.getApplication().getTelephoneDSIAccess().placeIncomingCallOnHold(n);
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void replaceActiveCallWithIncomingCall(int n) {
        this.getApplication().getTelephoneDSIAccess().acceptCall(n);
    }

    public void hangupCall(int n) {
        CallStateStruct callStateStruct;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.state;
        boolean bl = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getConnectedGatewayState() != null && iGlobalTelephoneStateStruct.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType();
        CallStateStruct callStateStruct2 = callStateStruct = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice().getCallState() : null;
        if (bl) {
            this.telEcallService.hangupLowPrioritySOSCall();
        } else if (callStateStruct != null) {
            AbstractPhoneCall abstractPhoneCall;
            AbstractPhoneCall abstractPhoneCall2 = callStateStruct.getActiveCall();
            AbstractPhoneCall abstractPhoneCall3 = callStateStruct.getOutgoingCall();
            AbstractPhoneCall abstractPhoneCall4 = callStateStruct.getHeldCall();
            AbstractPhoneCall abstractPhoneCall5 = abstractPhoneCall3 != null ? abstractPhoneCall3 : (abstractPhoneCall2 != null ? abstractPhoneCall2 : (abstractPhoneCall = abstractPhoneCall4 != null ? abstractPhoneCall4 : null));
            if (abstractPhoneCall != null) {
                this.getApplication().getTelephoneDSIAccess().hangupCall(abstractPhoneCall.getTelCallID(), n);
            } else {
                this.log.log(10000, "TelCallControlBase#hangupCall callToHangup is null");
            }
        } else {
            this.log.log(10000, "TelCallControlBase#hangupCall callLeadingCallState is null");
        }
    }

    public void hangupCall(int n, int n2) {
        CallStateStruct callStateStruct;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.state;
        boolean bl = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getConnectedGatewayState() != null && iGlobalTelephoneStateStruct.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType();
        CallStateStruct callStateStruct2 = callStateStruct = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice().getCallState() : null;
        if (bl) {
            this.telEcallService.hangupLowPrioritySOSCall();
        } else if (callStateStruct != null) {
            this.getApplication().getTelephoneDSIAccess().hangupCall(n, n2);
        }
    }

    public void joinCallsToConference(int n) {
        this.getApplication().getTelephoneDSIAccess().joinCallsToConference(n);
    }

    public void swapCalls(int n) {
        CallStateStruct callStateStruct;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.state;
        CallStateStruct callStateStruct2 = callStateStruct = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice().getCallState() : null;
        if (callStateStruct != null && callStateStruct.getHeldCall() != null && callStateStruct.getHeldCall().getTelCallState() == 8) {
            this.getApplication().getTelephoneDSIAccess().acceptCall(n);
        } else {
            this.getApplication().getTelephoneDSIAccess().swapCalls(n, true, this.getSwapCallsResponseListener());
        }
    }

    protected ITelDSIResponseListener getSwapCallsResponseListener() {
        return null;
    }

    public void rejectIncomingCall(int n) {
        AbstractPhoneCall abstractPhoneCall;
        CallStateStruct callStateStruct;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.state;
        CallStateStruct callStateStruct2 = callStateStruct = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice().getCallState() : null;
        if (callStateStruct != null && (abstractPhoneCall = callStateStruct.getIncomingCall()) != null) {
            this.getApplication().getTelephoneDSIAccess().hangupCall(abstractPhoneCall.getTelCallID(), n);
        }
    }

    public void acceptIncomingCall(int n) {
        this.getApplication().getTelephoneDSIAccess().acceptCall(n);
    }

    public void acceptOnNCLDOngoing(boolean bl) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class TelEcallServiceTracker
    extends AbstractTelServiceTracker {
        public TelEcallServiceTracker(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", class$de$audi$atip$interapp$phone$ITelEcallService == null ? (class$de$audi$atip$interapp$phone$ITelEcallService = TelCallControlBase.class$("de.audi.atip.interapp.phone.ITelEcallService")) : class$de$audi$atip$interapp$phone$ITelEcallService);
        }

        protected void serviceAvailable(Object object) {
            this.log.log(1000000, "TelCallControlBase.TelServiceListenerTracker#serviceAvailable(): %1", object);
            TelCallControlBase.this.telEcallService = (ITelEcallService)object;
        }

        protected void serviceRemoved(Object object) {
            this.log.log(1000000, "TelCallControlBase.TelServiceListenerTracker#serviceRemoved(): %1", object);
            TelCallControlBase.this.telEcallService = new NullTelEcallService(this.log);
        }
    }
}

