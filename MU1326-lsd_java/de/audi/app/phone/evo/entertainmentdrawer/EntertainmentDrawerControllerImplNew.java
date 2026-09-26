/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.model.TelModelGroup;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.evo.entertainmentdrawer.EntertainmentDrawerControllerImplNew$1;
import de.audi.app.phone.evo.entertainmentdrawer.IEntertainmentDrawerControllerNew;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$SourceAudioState;
import de.audi.atip.interapp.phone.IEcallState;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;
import java.util.Map;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class EntertainmentDrawerControllerImplNew
extends AbstractPhoneComponent
implements IEntertainmentDrawerControllerNew,
IActionProxyListener,
ServiceTrackerCustomizer {
    private final int DRW_OPENED;
    private final int DRW_CLOSED;
    private final int DRW_UNKNOWN;
    private final PhoneServiceProvider audioDrawerContextListenerProvider;
    private final boolean isStandardSystem;
    private volatile boolean telAppEntered;
    private volatile boolean callAcceptedFromCluster;
    private volatile boolean callAcceptedFromMU;
    private volatile boolean callAcceptedFromMUStdSystemOngoing;
    private volatile boolean disconnectedCallWhenOtherCallActivityAvailable;
    private volatile boolean acceptOnNCLDOngoing;
    private volatile boolean dialingNumberJumpToPhoneWillOccur;
    private volatile int drawerState = 1;
    private volatile int currentPhoneAudioDrawerContext = 0;
    private volatile int drawerStateAtDisconnectingCall = -2;
    private volatile int drawerStateAtIncomingCall = -2;
    private volatile ModelGroup[] mg;
    private volatile IGlobalTelephoneStateStruct stateStruct;
    private volatile PhoneServiceTracker audioDrawerServiceTracker;
    private volatile AudioDrawerContext audioDrawerContextService;
    private Map disconnectingList = new HashMap();
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext;

    public EntertainmentDrawerControllerImplNew(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.EntertainmentDrawer");
        this.DRW_OPENED = 0;
        this.DRW_CLOSED = 1;
        this.DRW_UNKNOWN = -2;
        this.audioDrawerContextListenerProvider = new PhoneServiceProvider((class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener = EntertainmentDrawerControllerImplNew.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContextListener")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener).getName(), new EntertainmentDrawerControllerImplNew$1(this), null, iTelApplication.getBundleContext(), this.log);
        this.isStandardSystem = this.getApplication().getFrameworkAccess().getSysConst(523) == 0;
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(8, this);
        this.getApplication().getGlobalTelephoneStateManager().registerListenerForSpecificAttributeUpdate(0xC000400, (IGlobalTelephoneStateListener)this);
        this.audioDrawerContextListenerProvider.startService();
        this.audioDrawerServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext = EntertainmentDrawerControllerImplNew.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContext")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.audioDrawerServiceTracker.openTracker();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(8, this);
        this.getApplication().getGlobalTelephoneStateManager().removeListenerForSpecificAttributeUpdate(0xC000400, (IGlobalTelephoneStateListener)this);
        this.audioDrawerContextListenerProvider.stopService();
        if (this.audioDrawerServiceTracker != null) {
            this.audioDrawerServiceTracker.closeTracker();
            this.audioDrawerServiceTracker = null;
        }
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 0xC000400 && iGlobalTelephoneStateStruct != null) {
            boolean bl;
            IEcallState iEcallState = iGlobalTelephoneStateStruct.getConnectedGatewayState();
            if (iEcallState.isLowPrioritySOSEmergencyCallType() && iEcallState.getCall().getState() != 0) {
                this.log.log(1078071040, "[EntertainmentDrawerControllerImplNew#updateGlobalTelephoneStateProperty] set AudioDrawerContext#SOURCE_PHONE_STATE_ACTIVE_CALL because of low priority SOS call");
                this.changeEntDrawerContext(AudioDrawerContext.SOURCE_PHONE_STATE_ACTIVE_CALL, 2);
                return;
            }
            if (!iEcallState.isCustomerCallAllowed()) {
                this.audioDrawerContextService.setContext(AudioDrawerContext.SOURCE_PHONE, AudioDrawerContext.SOURCE_PHONE_STATE_IDLE);
                this.currentPhoneAudioDrawerContext = 0;
            }
            if (!(bl = iEcallState.isServiceActive()) && this.hasIncomingCall(iGlobalTelephoneStateStruct)) {
                this.showEntertainmentDrawer();
            } else if (bl && iEcallState.getServiceKind() == 1) {
                this.closeEntertainmentDrawer();
            }
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object instanceof AudioDrawerContext) {
            this.audioDrawerContextService = (AudioDrawerContext)object;
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof AudioDrawerContext) {
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.audioDrawerContextService = null;
        }
    }

    @Override
    public void showEntertainmentDrawer() {
        this.log.log(-2137614336, "[EntertainmentDrawerControllerImplNew#showEntertainmentDrawer] try to show ED");
        if (this.getDrawerState() != 0) {
            this.log.log(-2137614336, "[EntertainmentDrawerControllerImplNew#showEntertainmentDrawer] ED will be showed");
            this.getApplication().getFrameworkAccess().getHmiServiceApp().showPopup(-527236096);
        }
    }

    @Override
    public void closeEntertainmentDrawer() {
        this.log.log(-2137614336, "[EntertainmentDrawerControllerImplNew#closeEntertainmentDrawer] will try to remove ED");
        if (this.getDrawerState() == 0) {
            this.log.log(-2137614336, "[EntertainmentDrawerControllerImplNew#closeEntertainmentDrawer] removing ED");
            this.getApplication().getFrameworkAccess().getHmiServiceApp().removePopup(-527236096);
        }
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 7) {
            this.telAppEntered = true;
        } else if (n == 8) {
            this.telAppEntered = false;
        } else {
            this.log.log(-1601830656, "[EntertainmentDrawerControllerImplNew#actionProxyCallPerformed] unhandled methodID=%1", (long)n);
        }
    }

    @Override
    public void onIncomingCallMute() {
        this.log.log(-2137614336, "EntertainmentDrawerControllerImplNew#onIncomingCallMute(): called");
        if (this.hasJoystik() || !this.isInTelefoneContext()) {
            this.closeEntertainmentDrawer();
        }
    }

    @Override
    public void onTelAppEntered(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (this.hasIncomingCall(iGlobalTelephoneStateStruct) && !this.callAcceptedFromMUStdSystemOngoing) {
            this.log.log(1078071040, "[EntertainmentDrawerControllerImplNew#actionProxyCallPerformed] TEL_APP_ENTERED --> showing ED for incoming call");
            this.log.log(-2137614336, "[EntertainmentDrawerControllerImplNew#showEntertainmentDrawer] ED will be showed");
            this.getApplication().getFrameworkAccess().getHmiServiceApp().showPopup(-527236096);
        }
        this.callAcceptedFromMUStdSystemOngoing = false;
    }

    @Override
    public void onTelAppLeft(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        boolean bl = this.hasActiveCall(iGlobalTelephoneStateStruct);
        this.log.log(1078071040, "EntertainmentDrawerControllerImplNew#onTelAppLeft(): hasActiveCall: %1", bl);
        if (bl) {
            this.closeEntertainmentDrawer();
        }
    }

    @Override
    public void callAcceptedOnCluster() {
        this.log.log(-2137614336, "EntertainmentDrawerControllerImplNew#callAcceptedOnCluster()");
        this.setCallAcceptedFromCluster(true);
        this.closeEntertainmentDrawer();
    }

    @Override
    public void callAcceptedOnMU() {
        this.log.log(-2137614336, "EntertainmentDrawerControllerImplNew#callAcceptedOnMU()");
        this.setCallAcceptedFromMU(true);
        if (this.isStandardSystem) {
            this.acceptIncomingCallOnStdSystemOnMU();
        } else {
            this.acceptIncomingCallOnHighSystemMU();
        }
    }

    @Override
    public void acceptOnNCLDOngoing(boolean bl) {
        this.acceptOnNCLDOngoing = bl;
    }

    @Override
    public void computeNewDrawerState(ModelGroup[] modelGroupArray, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        int n = this.computeNewDrawerState(iGlobalTelephoneStateStruct);
        if (this.mg != null) {
            if (!((TelModelGroup)modelGroupArray[0]).isGroupFlushed()) {
                this.flushIncomingCallModels();
            }
            if (!((TelModelGroup)modelGroupArray[1]).isGroupFlushed()) {
                this.flushActiveCallModels();
            }
        }
        this.mg = modelGroupArray;
        this.stateStruct = iGlobalTelephoneStateStruct;
        this.log.log(1078071040, "EntertainmentDrawerControllerImplNew#computeNewDrawerState() newDrawerState=%1", (Object)EntertainmentDrawerControllerImplNew.getDrawerStateName(n));
        switch (n) {
            case 0: {
                this.flushModelGroupAndChangeAudioContext();
                this.showEntertainmentDrawer();
                break;
            }
            case 1: {
                this.closeEntertainmentDrawer();
                break;
            }
            case 2: {
                this.flushModelGroupAndChangeAudioContext();
                break;
            }
            default: {
                this.log.log(-1601830656, "EntertainmentDrawerControllerImplNew#computeNewDrawerState(): invalid drawer state %1", (long)n);
                this.flushModelGroupAndChangeAudioContext();
            }
        }
    }

    @Override
    public void deactivateTerminalModeDrawer() {
        this.log.log(1078071040, "EntertainmentDrawerControllerImplNew#deactivateTerminalModeDrawer(): deactivating of TM audio drawer");
        if (this.audioDrawerContextService != null) {
            this.audioDrawerContextService.setContext(AudioDrawerContext.SOURCE_TERMINAL_MODE_PHONE, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
        } else {
            this.log.log(-1601830656, "EntertainmentDrawerControllerImplNew#deactivateTerminalModeDrawer(): audioDrawerContextService is NULL");
        }
    }

    @Override
    public void dialingNumberJumpToPhoneWillOccur() {
        this.dialingNumberJumpToPhoneWillOccur = true;
    }

    @Override
    public void resetdialingNumberJumpToPhoneFlag() {
        this.dialingNumberJumpToPhoneWillOccur = false;
    }

    private static String getDrawerStateName(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "OPEN";
                break;
            }
            case 1: {
                string = "CLOSE";
                break;
            }
            case 2: {
                string = "NO CHANGE";
                break;
            }
            default: {
                string = "UNKNOWN";
            }
        }
        return string;
    }

    protected synchronized void flushModelGroupAndChangeAudioContext() {
        this.log.log(1078071040, "EntertainmentDrawerControllerImplNew#flushModelGroup()");
        this.updateAudioDrawerContext();
    }

    private void updateAudioDrawerContext() {
        if (this.stateStruct != null && this.audioDrawerContextService != null) {
            CallStateStruct callStateStruct;
            CallStateStruct callStateStruct2 = callStateStruct = this.stateStruct.getCallLeadingDevice() != null ? this.stateStruct.getCallLeadingDevice().getCallState() : null;
            if (this.stateStruct.getConnectedGatewayState().isCustomerCallNotAllowed() && this.stateStruct.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType() && this.stateStruct.getConnectedGatewayState().getCall().getState() != 0) {
                this.log.log(1078071040, "[EntertainmentDrawerControllerImplNew#updateAudioDrawerContext] active SOS call");
                this.changeEntDrawerContext(AudioDrawerContext.SOURCE_PHONE_STATE_ACTIVE_CALL, 2);
                this.flushActiveCallModels();
                this.flushIncomingCallModels();
            } else if (this.hasIncomingCall(this.stateStruct)) {
                if (this.currentPhoneAudioDrawerContext != 1) {
                    this.log.log(1078071040, "[EntertainmentDrawerControllerImplNew#updateAudioDrawerContext] AudioDrawerContext#SOURCE_PHONE_STATE_INCOMING_CALL");
                    this.flushIncomingCallModels();
                    this.changeEntDrawerContext(AudioDrawerContext.SOURCE_PHONE_STATE_INCOMING_CALL, 1);
                    this.flushActiveCallModels();
                } else {
                    this.log.log(1078071040, "[EntertainmentDrawerControllerImplNew#updateAudioDrawerContext] context is already AudioDrawerContext#SOURCE_PHONE_STATE_INCOMING_CALL");
                    this.flushIncomingCallModels();
                    this.flushActiveCallModels();
                }
            } else if (callStateStruct != null && !callStateStruct.isIdle() && this.stateStruct.getConnectedGatewayState().isCustomerCallAllowed()) {
                if (this.currentPhoneAudioDrawerContext != 2) {
                    this.flushActiveCallModels();
                    try {
                        Thread.sleep(0);
                    }
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    this.log.log(1078071040, "[EntertainmentDrawerControllerImplNew#updateAudioDrawerContext] AudioDrawerContext#SOURCE_PHONE_STATE_ACTIVE_CALL");
                    this.changeEntDrawerContext(AudioDrawerContext.SOURCE_PHONE_STATE_ACTIVE_CALL, 2);
                } else {
                    this.log.log(1078071040, "[EntertainmentDrawerControllerImplNew#updateAudioDrawerContext] context is already AudioDrawerContext#SOURCE_PHONE_STATE_ACTIVE_CALL");
                    this.flushActiveCallModels();
                    this.flushIncomingCallModels();
                }
            } else {
                if (callStateStruct != null && callStateStruct.isIdle() && this.currentPhoneAudioDrawerContext != 0) {
                    this.log.log(1078071040, "[EntertainmentDrawerControllerImplNew#updateAudioDrawerContext] AudioDrawerContext#SOURCE_PHONE_STATE_IDLE");
                    this.changeEntDrawerContext(AudioDrawerContext.SOURCE_PHONE_STATE_IDLE, 0);
                } else {
                    this.log.log(1078071040, "[EntertainmentDrawerControllerImplNew#updateAudioDrawerContext] context is already AudioDrawerContext#SOURCE_PHONE_STATE_IDLE");
                }
                this.flushActiveCallModels();
                this.flushIncomingCallModels();
            }
        } else {
            this.flushIncomingCallModels();
            this.flushActiveCallModels();
        }
    }

    private int computeNewDrawerState(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        CallStateStruct callStateStruct;
        int n = 2;
        this.log.log(1078071040, "EntertainmentDrawerControllerImplNew#computeNewDrawerState()");
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(-1601830656, "EntertainmentDrawerControllerImplNew#computeNewDrawerState(): stateStruct is NULL");
            return 2;
        }
        CallStateStruct callStateStruct2 = iGlobalTelephoneStateStruct.getCallLeadingDevice() != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice().getCallState() : null;
        CallStateStruct callStateStruct3 = callStateStruct = iGlobalTelephoneStateStruct.getNonCallLeadingDevice() != null ? iGlobalTelephoneStateStruct.getNonCallLeadingDevice().getCallState() : null;
        if (callStateStruct2 == null) {
            this.log.log(-1601830656, "EntertainmentDrawerControllerImplNew#computeNewDrawerState(): callLeadingCallState is NULL");
            return 2;
        }
        if (this.hasIncomingCall(iGlobalTelephoneStateStruct) && !callStateStruct2.isHasDisconnectingCall() && !this.isAcceptDuringActiveCallOrConferenceOngoing(callStateStruct2) && !this.acceptOnNCLDOngoing) {
            this.drawerStateAtIncomingCall = this.getDrawerState();
            return this.computeNewDrawerState(0);
        }
        if (this.acceptOnNCLDOngoing) {
            return this.computeNewDrawerState(2);
        }
        n = this.computeNewDrawerStateReturnValue(callStateStruct2, callStateStruct);
        return n;
    }

    private int computeNewDrawerStateReturnValue(CallStateStruct callStateStruct, CallStateStruct callStateStruct2) {
        int n = 2;
        if ((EntertainmentDrawerControllerImplNew.isCallAccepted(callStateStruct) || EntertainmentDrawerControllerImplNew.isCallAccepted(callStateStruct2)) && !callStateStruct.isHasDisconnectingCall()) {
            n = this.onAcceptIncomingCall();
        }
        if (callStateStruct.isHasDisconnectingCall()) {
            if (this.isDrawerStateToBeRecovered(callStateStruct) && this.disconnectingCallIsUnknown(callStateStruct, this.stateStruct.getCallLeadingDevice())) {
                this.setDrawerStateToBeRecovered(this.getDrawerState());
            }
            n = this.computeNewDrawerState(1);
        } else if (callStateStruct2 != null && callStateStruct2.isHasDisconnectingCall()) {
            if (this.isDrawerStateToBeRecovered(callStateStruct)) {
                this.setDrawerStateToBeRecovered(this.drawerStateAtIncomingCall);
            }
            n = this.computeNewDrawerState(1);
        } else if (callStateStruct.isHasOutgoingCall()) {
            AbstractPhoneCall abstractPhoneCall = callStateStruct.getOutgoingCall();
            n = this.onOutgoingCall(abstractPhoneCall.getTelCallType());
        } else if (callStateStruct.isHasActiveCall() || callStateStruct.isHasOnHoldCall()) {
            this.dialingNumberJumpToPhoneWillOccur = false;
            if (this.isDrawerStateRecoveryNeeded(callStateStruct)) {
                n = this.recoverDrawerState();
                this.disconnectingList.clear();
            }
        } else if (callStateStruct != null && callStateStruct.isIdle() && callStateStruct2 != null && callStateStruct2.isIdle()) {
            this.resetAllInternalFlags();
        }
        return n;
    }

    private boolean isDrawerStateToBeRecovered(CallStateStruct callStateStruct) {
        return (callStateStruct.isHasOnHoldCall() || callStateStruct.isHasActiveCall()) && !this.isInTelefoneContext();
    }

    private void resetAllInternalFlags() {
        this.dialingNumberJumpToPhoneWillOccur = false;
        this.callAcceptedFromCluster = false;
        this.callAcceptedFromMU = false;
        this.callAcceptedFromMUStdSystemOngoing = false;
        this.disconnectedCallWhenOtherCallActivityAvailable = false;
        this.acceptOnNCLDOngoing = false;
        this.drawerState = 1;
        this.disconnectingList.clear();
    }

    private void changeEntDrawerContext(AudioDrawerContext$SourceAudioState audioDrawerContext$SourceAudioState, int n) {
        this.audioDrawerContextService.setContext(AudioDrawerContext.SOURCE_PHONE, audioDrawerContext$SourceAudioState);
        this.currentPhoneAudioDrawerContext = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void flushIncomingCallModels() {
        if (this.mg != null) {
            ModelGroup[] modelGroupArray = this.mg;
            synchronized (this.mg) {
                this.mg[0].flush();
                this.mg[0].removeAll();
                // ** MonitorExit[var1_1] (shouldn't be in output)
            }
        } else {
            this.log.log(-1601830656, "EntertainmentDrawerControllerImplNew#flushIncomingCallModels(): modelGroup is NULL");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void flushActiveCallModels() {
        if (this.mg != null) {
            ModelGroup[] modelGroupArray = this.mg;
            synchronized (this.mg) {
                this.mg[1].flush();
                this.mg[1].removeAll();
                // ** MonitorExit[var1_1] (shouldn't be in output)
            }
        } else {
            this.log.log(-1601830656, "EntertainmentDrawerControllerImplNew#flushActiveCallModels(): modelGroup is NULL");
        }
    }

    private boolean disconnectingCallIsUnknown(CallStateStruct callStateStruct, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        boolean bl;
        Short s = new Short(callStateStruct.getDisconnectingCall().getTelCallID());
        Integer n = new Integer(this.stateStruct.getCallLeadingDevice().getDeviceRole());
        if (!this.disconnectingList.containsKey(s)) {
            this.disconnectingList.put(s, n);
            bl = true;
        } else {
            bl = ((Integer)this.disconnectingList.get(s)).intValue() != iTelDSIMobileEquipmentDeviceState.getDeviceRole();
        }
        return bl;
    }

    private boolean isAcceptDuringActiveCallOrConferenceOngoing(CallStateStruct callStateStruct) {
        return callStateStruct.getPreviousMPCallState() == 26 && callStateStruct.getMpCallState() == 18 || callStateStruct.getPreviousMPCallState() == 16 && callStateStruct.getMpCallState() == 17;
    }

    private void setDrawerStateToBeRecovered(int n) {
        this.drawerStateAtDisconnectingCall = n;
        this.disconnectedCallWhenOtherCallActivityAvailable = true;
    }

    private boolean isDrawerStateRecoveryNeeded(CallStateStruct callStateStruct) {
        return this.disconnectedCallWhenOtherCallActivityAvailable && !callStateStruct.isHasDisconnectingCall() && !this.isInTelefoneContext();
    }

    private int recoverDrawerState() {
        this.log.log(1078071040, "EntertainmentDrawerControllerImplNew#recoverDrawerState(): drawerStateAtDisconnectingCall=%1, drawerStateAtIncomingCall=%2", (long)this.drawerStateAtDisconnectingCall, (long)this.drawerStateAtIncomingCall);
        int n = this.computeNewDrawerStateAtDisconnectingCall();
        this.drawerStateAtDisconnectingCall = -2;
        this.drawerStateAtIncomingCall = -2;
        this.disconnectedCallWhenOtherCallActivityAvailable = false;
        return n;
    }

    private int computeNewDrawerStateAtDisconnectingCall() {
        if (this.drawerStateAtDisconnectingCall == 0) {
            return this.computeNewDrawerState(0);
        }
        if (this.drawerStateAtDisconnectingCall == -2) {
            return this.computeNewDrawerState(2);
        }
        return this.computeNewDrawerState(1);
    }

    protected int onOutgoingCall(int n) {
        boolean bl = n == 0 || n == 6 || n == 4 || n == 3 || n == 5 || n == 8 || n == 9;
        this.log.log(-2137614336, "EntertainmentDrawerControllerImplNew#onOutgoingCall(): callType=%1", (long)n);
        if (bl) {
            if (!(this.hasJoystik() || this.isInTelefoneContext() || this.dialingNumberJumpToPhoneWillOccur)) {
                return this.computeNewDrawerState(0);
            }
        } else {
            this.log.log(1078071040, "[EntertainmentDrawerControllerImplNew#onOutgoingCall] not showing ED for callType %1", (long)n);
        }
        return this.computeNewDrawerState(2);
    }

    protected int onAcceptIncomingCall() {
        this.log.log(-2137614336, "EntertainmentDrawerControllerImplNew#onAcceptIncomingCall(): called");
        if (!this.isInTelefoneContext() && this.hasJoystik() && this.isCallAcceptedFromCluster()) {
            this.log.log(-2137614336, "EntertainmentDrawerControllerImplNew#onAcceptIncomingCall(): call was accepted by Cluster.");
            this.setCallAcceptedFromCluster(false);
            return this.computeNewDrawerState(1);
        }
        if (!this.isInTelefoneContext() && this.hasJoystik() && this.isCallAcceptedFromMU()) {
            this.log.log(-2137614336, "EntertainmentDrawerControllerImplNew#onAcceptIncomingCall(): call was accepted by Main Unit.");
            this.setCallAcceptedFromMU(false);
            this.showEntertainmentDrawer();
            return this.computeNewDrawerState(0);
        }
        return this.acceptIncomingCallOnHighSystem();
    }

    private int computeNewDrawerState(int n) {
        switch (n) {
            case 1: {
                return this.getDrawerState() == 1 ? 2 : 1;
            }
            case 0: {
                return this.getDrawerState() == 0 ? 2 : 0;
            }
        }
        return 2;
    }

    private void acceptIncomingCallOnStdSystemOnMU() {
        if (!this.isInTelefoneContext() && !this.hasJoystik()) {
            this.log.log(-2137614336, "EntertainmentDrawerControllerImplNew#acceptIncomingCallOnStdSystem(): change to phone");
            this.callAcceptedFromMUStdSystemOngoing = true;
            this.closeEntertainmentDrawer();
            PhoneUtils.triggerJumpToPhone(this.getApplication().getFrameworkAccess().getHmiServiceApp());
        } else {
            this.acceptIncomingCallOnHighSystemMU();
        }
    }

    private void acceptIncomingCallOnHighSystemMU() {
        if (this.isInTelefoneContext()) {
            this.closeEntertainmentDrawer();
        } else {
            this.showEntertainmentDrawer();
        }
    }

    private int acceptIncomingCallOnHighSystem() {
        if (this.isInTelefoneContext() || this.hasJoystik()) {
            return this.computeNewDrawerState(1);
        }
        return this.computeNewDrawerState(0);
    }

    private boolean hasIncomingCall(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null) {
            AbstractPhoneCall abstractPhoneCall = iGlobalTelephoneStateStruct.getCallLeadingDevice() != null && iGlobalTelephoneStateStruct.getCallLeadingDevice().getCallState() != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice().getCallState().getIncomingCall() : null;
            AbstractPhoneCall abstractPhoneCall2 = iGlobalTelephoneStateStruct.getNonCallLeadingDevice() != null && iGlobalTelephoneStateStruct.getNonCallLeadingDevice().getCallState() != null ? iGlobalTelephoneStateStruct.getNonCallLeadingDevice().getCallState().getIncomingCall() : null;
            return abstractPhoneCall != null || abstractPhoneCall2 != null;
        }
        return false;
    }

    private boolean hasActiveCall(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallState() != null && iGlobalTelephoneStateStruct.getCallState().isHasActiveCall();
    }

    private static boolean isCallAccepted(CallStateStruct callStateStruct) {
        return callStateStruct != null && callStateStruct.getTransition() == 2;
    }

    boolean isInTelefoneContext() {
        return this.telAppEntered;
    }

    boolean hasJoystik() {
        return this.getApplication().getFrameworkAccess().getHMIService().getHMITerminal(0).getKbdService().isPanelWithJoystick();
    }

    int getDrawerState() {
        return this.drawerState;
    }

    void setDrawerState(int n) {
        this.drawerState = n;
    }

    boolean isCallAcceptedFromCluster() {
        return this.callAcceptedFromCluster;
    }

    void setCallAcceptedFromCluster(boolean bl) {
        this.callAcceptedFromCluster = bl;
    }

    boolean isCallAcceptedFromMU() {
        return this.callAcceptedFromMU;
    }

    void setCallAcceptedFromMU(boolean bl) {
        this.callAcceptedFromMU = bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(EntertainmentDrawerControllerImplNew entertainmentDrawerControllerImplNew) {
        return entertainmentDrawerControllerImplNew.log;
    }

    static /* synthetic */ int access$100(EntertainmentDrawerControllerImplNew entertainmentDrawerControllerImplNew) {
        return entertainmentDrawerControllerImplNew.currentPhoneAudioDrawerContext;
    }

    static /* synthetic */ void access$200(EntertainmentDrawerControllerImplNew entertainmentDrawerControllerImplNew) {
        entertainmentDrawerControllerImplNew.flushIncomingCallModels();
    }

    static /* synthetic */ LogChannel access$300(EntertainmentDrawerControllerImplNew entertainmentDrawerControllerImplNew) {
        return entertainmentDrawerControllerImplNew.log;
    }

    static /* synthetic */ LogChannel access$400(EntertainmentDrawerControllerImplNew entertainmentDrawerControllerImplNew) {
        return entertainmentDrawerControllerImplNew.log;
    }
}

