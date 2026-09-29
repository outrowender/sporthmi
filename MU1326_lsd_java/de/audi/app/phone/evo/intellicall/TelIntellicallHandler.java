/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ITelTextFactory;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.core.state.CallState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.evo.AbstractEvoPhoneComponent;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.intellicall.ITelIntellicallHandler;
import de.audi.app.phone.evo.intellicall.IntellicallCombinedCallStackHandler;
import de.audi.app.phone.evo.intellicall.IntellicallFullCallListHandler;
import de.audi.app.phone.evo.intellicall.IntellicallFullMenuFocusHandler;
import de.audi.app.phone.evo.intellicall.IntellicallReducedCallListHandler;
import de.audi.app.phone.evo.intellicall.IntellicallReducedMenuFocusHandler;
import de.audi.app.phone.evo.intellicall.PhoneIntellicallSearchHandler;
import de.audi.app.phone.evo.intellicall.TelEvoADBMatchSpellerHandler;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$1;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$2;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$3;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$4;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$5;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$IntelliCallTerminalModeUpdateListener;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$IntellicallFullScreenListener;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$IntellicallMainLanguageUpdateListener;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$TelFurtherCallOptionButtonListener;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$TogglePhonesOptionHandler;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;
import de.audi.atip.log.LogChannel;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class TelIntellicallHandler
extends AbstractEvoPhoneComponent
implements IActionProxyListener,
ITelIntellicallHandler {
    public static final int INTELLICALL_MENU_WIDGET_ID;
    private static final boolean USE_DEFAULT_ERROR_HANDLING;
    private static final int DOWN_TRANSITION;
    private static final int UP_TRANSITION;
    private static final int SHOW_CALL_STACKS;
    private static final int INTELLICALL_VIEW_MODE_FULL;
    private static final int INTELLICALL_VIEW_MODE_REDUCED;
    private PhoneIntellicallSearchHandler searchHandler;
    private TelEvoADBMatchSpellerHandler telStdIntellicallSearchModelHandler;
    private final PhoneServiceProvider terminalModeUpdateListnerService;
    private final DefaultTerminalModeUpdateListener tmUpdateListener;
    private volatile IGlobalTelephoneStateStruct telephoneState;
    private volatile TerminalModeDevice pActiveDevice;
    private volatile boolean telAppEntered;
    private volatile boolean intellicallFullModeEntered;
    private volatile boolean intellicallReducedModeEntered;
    private volatile int intellicallViewMode = 0;
    private final IntellicallFullMenuFocusHandler fullViewFocusManager;
    private final IntellicallReducedMenuFocusHandler reducedFocusManager;
    private final ITelDSISearchAccess dsiSearchManager;
    private final int ROLE_CHANGE_POPUP;
    private volatile boolean isTMVideoFocus = false;
    private final ModelGroup modelGroup = new ModelGroup();
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener;

    public TelIntellicallHandler(ITelEvoApplication iTelEvoApplication, ITelDSISearchAccess iTelDSISearchAccess) {
        super(iTelEvoApplication, "App.Phone.Main");
        this.ROLE_CHANGE_POPUP = 815072256;
        this.fullViewFocusManager = new IntellicallFullMenuFocusHandler(iTelEvoApplication);
        this.reducedFocusManager = new IntellicallReducedMenuFocusHandler(iTelEvoApplication);
        this.dsiSearchManager = iTelDSISearchAccess;
        this.tmUpdateListener = new TelIntellicallHandler$IntelliCallTerminalModeUpdateListener(this, null);
        this.terminalModeUpdateListnerService = new PhoneServiceProvider((class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = TelIntellicallHandler.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener).getName(), this.tmUpdateListener, null, iTelEvoApplication.getBundleContext(), this.log);
        this.addSubPhoneComponent(new IntellicallFullCallListHandler(iTelEvoApplication));
        this.addSubPhoneComponent(new IntellicallReducedCallListHandler(iTelEvoApplication));
        this.addSubPhoneComponent(this.fullViewFocusManager);
        this.addSubPhoneComponent(this.reducedFocusManager);
        this.addSubPhoneComponent(new TelIntellicallHandler$TelFurtherCallOptionButtonListener(this, iTelEvoApplication, null));
        this.addSubPhoneComponent(new IntellicallCombinedCallStackHandler(iTelEvoApplication));
        this.addSubPhoneComponent(new TelIntellicallHandler$IntellicallFullScreenListener(this, iTelEvoApplication, null));
        this.addSubPhoneComponent(new TelIntellicallHandler$TogglePhonesOptionHandler(this, iTelEvoApplication, null));
        this.addSubPhoneComponent(new TelIntellicallHandler$IntellicallMainLanguageUpdateListener(this, iTelEvoApplication));
    }

    @Override
    public void init() {
        super.init();
        if (this.getApplication().getFrameworkAccess().getSysConst(523) == 1) {
            this.searchHandler = new PhoneIntellicallSearchHandler(this.getEvoApplication(), this.dsiSearchManager, this.fullViewFocusManager);
            this.searchHandler.init();
        } else if (this.getApplication().getFrameworkAccess().getSysConst(523) == 0) {
            this.telStdIntellicallSearchModelHandler = new TelEvoADBMatchSpellerHandler(this.getApplication().getADBHandler().getAdbApplication(), this.getApplication(), this.log);
            this.telStdIntellicallSearchModelHandler.initHandler();
        }
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().getGlobalTelephoneStateManager().registerListener(new TelIntellicallHandler$1(this));
        this.getChoiceModel(-1902771200).setValue(1);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(8, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(5, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(4, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(6, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(15, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(27, this);
        this.getResourceLocatorModel(-107609088).setStatus(0);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        if (this.searchHandler != null) {
            this.searchHandler.deinit();
        } else if (this.telStdIntellicallSearchModelHandler != null) {
            this.telStdIntellicallSearchModelHandler.deinitHandler();
        }
        this.terminalModeUpdateListnerService.stopService();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(8, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(5, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(4, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(6, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(15, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(27, this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        CallStateStruct callStateStruct;
        this.telephoneState = iGlobalTelephoneStateStruct;
        if (n == 0xC000400 && iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType()) {
            this.setFurtherCallOptionPossibility(false);
            this.getBaseListModel(-778697728).trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
            this.checkIntellicallViewMode(iGlobalTelephoneStateStruct.getConnectedGatewayState().getCall().getState());
            return;
        }
        if (n == 0x12000100) {
            this.updatePrimaryDeviceName();
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() : null;
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getNonCallLeadingDevice() : null;
        CallStateStruct callStateStruct2 = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() : null;
        CallStateStruct callStateStruct3 = callStateStruct = iTelDSIMobileEquipmentDeviceState2 != null ? iTelDSIMobileEquipmentDeviceState2.getCallState() : null;
        if ((n == 0x8000100 || n == 0x8000200 || n == 0x8000300) && iTelDSIMobileEquipmentDeviceState != null && callStateStruct2 != null) {
            this.resolveFurtherCallPossibility(iTelDSIMobileEquipmentDeviceState);
            this.checkIfClosingOfLeftDrawerIsNeeded(callStateStruct2);
            this.checkIntellicallViewMode(callStateStruct2, callStateStruct);
            this.jumpToPhoneApplicationIfNeeded(callStateStruct2);
        } else if (n == 0x4000400) {
            this.getChoiceModel(110560256).setValue(iGlobalTelephoneStateStruct.isNewSMSAvailable() ? 1 : 0);
        } else if (n == 0x3000100 || n == 0xF000100 || n == 0x3000200 || n == 0xF000200 || n == 0x3000300 || n == 0xF000300) {
            this.resolveFurtherCallPossibility(iTelDSIMobileEquipmentDeviceState);
        }
    }

    private void checkIfClosingOfLeftDrawerIsNeeded(CallStateStruct callStateStruct) {
        if (this.isG24() && callStateStruct != null && callStateStruct.isHasIncomingCall()) {
            this.getBaseListModel(-778697728).trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
        }
    }

    private void updatePrimaryDeviceName() {
        String string = TelIntellicallHandler.getTelephoneNameLabelValue(this.telephoneState != null ? this.telephoneState.getPrimaryDeviceState() : null, this.getApplication().getTextFactory());
        LabelModelApp labelModelApp = this.getApplication().getFrameworkAccess().getHMIService().getLabelModel(328729600);
        labelModelApp.setText(string);
    }

    private void checkIntellicallViewMode(int n) {
        switch (n) {
            case 3: {
                this.eCallDialed();
                break;
            }
            case 0: {
                this.setIntellicallFullViewMode();
                break;
            }
        }
    }

    private void checkIntellicallViewMode(CallStateStruct callStateStruct, CallStateStruct callStateStruct2) {
        if (this.telephoneState != null && this.telephoneState.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType()) {
            return;
        }
        if (callStateStruct != null) {
            if (callStateStruct.isIdle() && (callStateStruct2 == null || callStateStruct2.isIdle())) {
                this.log.log(1078071040, "[TelIntellicallHandler#checkIntellicallViewMode] no calls present - setting view mode to INTELLICALL_MAIN");
                this.setIntellicallFullViewMode();
            } else if (callStateStruct.getMpCallState() == 15 && this.intellicallReducedModeEntered) {
                this.log.log(1078071040, "[TelIntellicallHandler#checkIntellicallViewMode] MPCALLSTATE_RINGING --> setting view mode and switching to INTELLICALL_MAIN");
                this.transitionToFullView();
            }
            int n = callStateStruct.getTransition();
            switch (n) {
                case 2: {
                    this.callAccepted();
                    break;
                }
                case 1: {
                    this.callDialed();
                    break;
                }
                case 3: {
                    this.conferenceEstablished();
                    break;
                }
                case 5: {
                    this.directTransitionToActiveDetected();
                    break;
                }
                default: {
                    this.log.log(-2137614336, "[TelIntellicallHandler#updateGlobalTelephoneStateProperty] no handling for transition %1", (Object)CallState.getTransitionString(n));
                }
            }
        }
    }

    private void jumpToPhoneApplicationIfNeeded(CallStateStruct callStateStruct) {
        if (callStateStruct == null) {
            this.log.log(10000, "[TelIntellicallHandler#jumpToPhoneApplicationIfNeeded] callLeadingDeviceCallState is null.");
            return;
        }
        boolean bl = false;
        this.log.log(1078071040, new StringBuffer().append("[TelIntellicallHandler#jumpToPhoneApplicationIfNeeded] telAppEntered=%1, callTransition=%2, hasIncomingCall=").append(callStateStruct.isHasIncomingCall()).append("isTerminalModeActive=").append(this.isTerminalModeActive()).toString(), this.telAppEntered, (long)callStateStruct.getTransition());
        bl = this.isTerminalModeActive() ? this.isJumpWhenTerminalModeActiveAllowed(callStateStruct) : this.isJumpOnNormalTelephoneInstance(callStateStruct);
        if (!this.telAppEntered && bl) {
            if (this.isTerminalModeActive()) {
                ((ITelEvoApplication)this.getApplication()).getNewEntertainmentDrawerController().deactivateTerminalModeDrawer();
            }
            PhoneUtils.triggerJumpToPhone(this.getApplication().getFrameworkAccess().getHmiServiceApp());
        }
    }

    private boolean isJumpOnNormalTelephoneInstance(CallStateStruct callStateStruct) {
        return this.isG24() && callStateStruct != null && callStateStruct.getTransition() == 1 && !this.isSomeSpecificCallAvailable(callStateStruct);
    }

    private boolean isJumpWhenTerminalModeActiveAllowed(CallStateStruct callStateStruct) {
        boolean bl = false;
        if (callStateStruct != null && callStateStruct.getTransition() == 1) {
            if (this.isG24() && !this.isTMVideoFocus && (this.isActiveDeviceAndroidAuto() || this.isActiveDeviceCarLife())) {
                bl = true;
            } else if (this.isActiveDeviceCarLife() && this.isTMVideoFocus) {
                bl = true;
            }
        } else if (callStateStruct != null && callStateStruct.isHasIncomingCall() && !this.isG24() && this.isActiveDeviceCarLife() && this.isTMVideoFocus) {
            bl = true;
        }
        return bl;
    }

    private void resolveFurtherCallPossibility(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null) {
            boolean bl = iTelDSIMobileEquipmentDeviceState.getCallState().isIdle();
            if (bl) {
                this.setFurtherCallOptionPossibility(false);
            } else {
                this.setFurtherCallOptionPossibility(!iTelDSIMobileEquipmentDeviceState.isRoleAssociated() && iTelDSIMobileEquipmentDeviceState.isDialingPossible() && !iTelDSIMobileEquipmentDeviceState.getCallState().isHasDisconnectingCall());
            }
        }
    }

    private void setFurtherCallOptionPossibility(boolean bl) {
        this.getChoiceModel(-1684601856).setValue(bl ? 1 : 0);
    }

    private void directTransitionToActiveDetected() {
        this.log.log(-2137614336, "[TelIntellicallHandler#directTransitionToActiveDetected]");
        this.transitionToReducedViewFocusActiveOrDialingCall();
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 7: {
                this.telAppEntered = true;
                break;
            }
            case 8: {
                this.telAppEntered = false;
                break;
            }
            case 5: {
                this.intellicallReducedModeEntered = false;
                this.intellicallFullModeEntered = false;
                this.getChoiceModel(764871680).setValue(0);
                break;
            }
            case 6: {
                this.intellicallReducedModeEntered = false;
                this.intellicallFullModeEntered = false;
                break;
            }
            case 4: {
                this.intellicallFullViewEntered();
                break;
            }
            case 15: {
                this.intellicallReducedModeEntered();
                break;
            }
            case 27: {
                this.getChoiceModel(764871680).setValue(1);
                break;
            }
            default: {
                this.log.log(-1601830656, "[TelIntellicallHandler#actionProxyCallPerformed] unhandled methodID=%1", (long)n);
            }
        }
    }

    protected void intellicallReducedModeEntered() {
        this.log.log(1078071040, "[TelIntellicallHandler#intellicallReducedModeEntered]");
        this.intellicallReducedModeEntered = true;
        this.intellicallFullModeEntered = false;
        this.setIntellicallReducedViewMode();
    }

    protected void intellicallFullViewEntered() {
        this.log.log(1078071040, "[TelIntellicallHandler#intellicallFullViewEntered]");
        this.intellicallFullModeEntered = true;
        this.intellicallReducedModeEntered = false;
        this.setIntellicallFullViewMode();
    }

    @Override
    public void callAccepted() {
        this.log.log(1078071040, "[TelIntellicallHandler#callAccepted] call accepted, transitioning to reduced view.");
        this.transitionToReducedViewFocusActiveOrDialingCall();
    }

    @Override
    public void eCallDialed() {
        this.log.log(1078071040, "[TelIntellicallHandler#eCallDialed] eCall dialed, transitioning to reduced view.");
        this.transitionToReducedViewFocusDialingECall();
    }

    @Override
    public void callDialed() {
        this.log.log(1078071040, "[TelIntellicallHandler#callDialed] call dialed, transitioning to reduced view.");
        this.transitionToReducedViewFocusActiveOrDialingCall();
    }

    @Override
    public void conferenceEstablished() {
        this.log.log(1078071040, "[TelIntellicallHandler#conferenceEstablished] conference established, transitioning to reduced view.");
        this.transitionToReducedViewFocusActiveOrDialingCall();
    }

    @Override
    public void dtmfEntrySelected() {
        this.log.log(1078071040, "[TelIntellicallHandler#dtmfEntrySelected] transitioning to reduced view.");
        this.transitionToReducedViewFocusDTMF();
    }

    @Override
    public void dialNumber(String string, int n) {
        this.dialNumber(string, n, this.getApplication().getDefaultListener());
    }

    @Override
    public void dialNumber(String string, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        if (this.intellicallFullModeEntered) {
            this.groupModels();
        }
        this.getApplication().getTelephoneDSIAccess().dialNumber(string, n, true, new TelIntellicallHandler$2(this, iTelDSIResponseListener));
    }

    private void processDialNumberResponse(ITelDSIResponseListener iTelDSIResponseListener, int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        if (n2 != 0) {
            this.clearTrueffelSearch();
            this.flushAndRemoveModels();
        }
        if (iTelDSIResponseListener != null) {
            iTelDSIResponseListener.responseDialNumber(n, n2, suppServiceResponseStruct, n3);
        }
    }

    @Override
    public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, int n3) {
        this.dialNumberFromDBEntry(string, l, string2, s, s2, resourceLocator, n, n2, n3, this.getApplication().getDefaultListener());
    }

    @Override
    public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, int n3, ITelDSIResponseListener iTelDSIResponseListener) {
        if (this.intellicallFullModeEntered) {
            this.groupModels();
        }
        this.getApplication().getTelephoneDSIAccess().dialNumberFromDBEntry(string, l, string2, s, s2, resourceLocator, n, n2, n3, true, new TelIntellicallHandler$3(this, iTelDSIResponseListener));
    }

    @Override
    public void dialNumberFromCallStackEntry(CallStackEntry callStackEntry, int n) {
        this.dialNumberFromCallStackEntry(callStackEntry, n, this.getApplication().getDefaultListener());
    }

    @Override
    public void dialNumberFromCallStackEntry(CallStackEntry callStackEntry, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        if (this.intellicallFullModeEntered) {
            this.groupModels();
        }
        this.getApplication().getTelephoneDSIAccess().dialNumberFromCallStackEntry(callStackEntry, n, true, new TelIntellicallHandler$4(this, iTelDSIResponseListener));
    }

    @Override
    public void dialNumberFromADBEntry(AdbEntry adbEntry, int n, int n2) {
        this.dialNumberFromADBEntry(adbEntry, n, n2, this.getApplication().getDefaultListener());
    }

    @Override
    public void dialNumberFromADBEntry(AdbEntry adbEntry, int n, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        if (this.intellicallFullModeEntered) {
            this.groupModels();
        }
        this.getApplication().getTelephoneDSIAccess().dialNumberFromADBEntry(adbEntry, n, n2, true, new TelIntellicallHandler$5(this, iTelDSIResponseListener));
    }

    private synchronized void groupModels() {
        this.log.log(1078071040, "[TelIntellicallHandler#groupModels]");
        this.modelGroup.add(this.getListModel(-1718287360));
        this.modelGroup.add(this.getBaseListModel(462881792));
        this.modelGroup.add(this.getChoiceModel(-1701444608));
        this.modelGroup.add(this.getSpellerModel(1737819136));
        this.modelGroup.add(this.getBaseListModel(-1365900288));
        this.modelGroup.add(this.getChoiceModel(-1885993984));
        this.modelGroup.add(this.getChoiceModel(1855259648));
        this.modelGroup.add(this.getChoiceModel(-1902771200));
        this.modelGroup.add(this.getLabelModel(-1282079744));
    }

    private synchronized void flushAndRemoveModels() {
        this.log.log(1078071040, "[TelIntellicallHandler#flushAndRemoveModels]");
        this.modelGroup.flush();
        this.modelGroup.removeAll();
    }

    private void transitionToFullView() {
        this.log.log(-2137614336, "[TelIntellicallHandler#transitionToFullView]");
        this.setIntellicallFullViewMode();
        this.switchToIntellicall();
    }

    private boolean isTerminalModeActive() {
        return this.pActiveDevice != null && this.pActiveDevice.isActive();
    }

    private boolean isActiveDeviceAndroidAuto() {
        return this.isTerminalModeActive() && this.pActiveDevice.getConnectionMethod() == 2;
    }

    private boolean isActiveDeviceCarLife() {
        return this.isTerminalModeActive() && this.pActiveDevice.getConnectionMethod() == 3;
    }

    private boolean isSomeSpecificCallAvailable(CallStateStruct callStateStruct) {
        return callStateStruct != null ? callStateStruct.isHasOperatorCall() || callStateStruct.isHasBreakdownCall() || callStateStruct.isHasInfoCall() || callStateStruct.isHasEmergencyCall() : false;
    }

    private boolean isG24() {
        return this.getApplication().getFrameworkAccess().getSysConst(522) == 4;
    }

    protected void transitionToReducedViewFocusDialingECall() {
        this.log.log(-2137614336, "[TelIntellicallHandler#transitionToReducedViewFocusDialingECall]");
        this.reducedFocusManager.focusDialingECall();
        this.setIntellicallReducedViewMode();
        this.switchToIntellicall();
    }

    protected void transitionToReducedViewFocusActiveOrDialingCall() {
        this.log.log(-2137614336, "[TelIntellicallHandler#transitionToReducedViewFocusActiveOrDialingCall]");
        this.reducedFocusManager.focusActiveOrDialingCall();
        this.setIntellicallReducedViewMode();
        this.switchToIntellicall();
    }

    protected void transitionToReducedViewFocusDTMF() {
        this.log.log(-2137614336, "[TelIntellicallHandler#transitionToReducedViewFocusDTMF]");
        this.reducedFocusManager.focusDtmf();
        this.setIntellicallReducedViewMode();
        this.switchToIntellicall();
    }

    private void setIntellicallFullViewMode() {
        this.log.log(-2137614336, "[TelIntellicallHandler#setIntellicallFullViewMode] - setting to INTELLICALL_MAIN");
        this.intellicallViewMode = 0;
        this.getChoiceModel(-1869216768).setValue(0);
    }

    private void setIntellicallReducedViewMode() {
        this.log.log(-2137614336, "[TelIntellicallHandler#setIntellicallReducedViewMode] - setting to INTELLICALL_REDUCED.");
        this.intellicallViewMode = 1;
        this.getChoiceModel(-1869216768).setValue(1);
    }

    private void switchToIntellicall() {
        int n = this.getChoiceModel(-1869216768).getValue();
        this.log.log(-2137614336, "[TelIntellicallHandler#switchToIntellicall] switching to %1", (Object)(n == 0 ? "INTELLICALL_MAIN" : "INTELLICALL_REDUCED"));
        ChoiceModelApp choiceModelApp = this.getChoiceModel(-879361024);
        int n2 = choiceModelApp.getValue();
        int n3 = n2 == 0 ? 1 : 0;
        this.getChoiceModel(-879361024).setValue(n3);
    }

    void clearTrueffelSearch() {
        if (this.searchHandler != null) {
            this.searchHandler.clearSearch();
        }
    }

    private static String getBluetoothFriendlyName(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getPhoneInformation() != null) {
            return iTelDSIMobileEquipmentDeviceState.getPhoneInformation().getMeFriendlyName();
        }
        return "";
    }

    private static String getTelephoneNameLabelValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, ITelTextFactory iTelTextFactory) {
        if (iTelDSIMobileEquipmentDeviceState != null) {
            int n = iTelDSIMobileEquipmentDeviceState.getTelMode();
            if (n == 0) {
                return iTelTextFactory != null ? iTelTextFactory.getText(13) : "";
            }
            if (n == 2 || n == 3) {
                return TelIntellicallHandler.getBluetoothFriendlyName(iTelDSIMobileEquipmentDeviceState);
            }
        }
        return "";
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ITelApplication access$400(TelIntellicallHandler telIntellicallHandler) {
        return telIntellicallHandler.getApplication();
    }

    static /* synthetic */ PhoneServiceProvider access$500(TelIntellicallHandler telIntellicallHandler) {
        return telIntellicallHandler.terminalModeUpdateListnerService;
    }

    static /* synthetic */ void access$600(TelIntellicallHandler telIntellicallHandler, ITelDSIResponseListener iTelDSIResponseListener, int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        telIntellicallHandler.processDialNumberResponse(iTelDSIResponseListener, n, n2, suppServiceResponseStruct, n3);
    }

    static /* synthetic */ void access$700(TelIntellicallHandler telIntellicallHandler) {
        telIntellicallHandler.flushAndRemoveModels();
    }

    static /* synthetic */ IGlobalTelephoneStateStruct access$800(TelIntellicallHandler telIntellicallHandler) {
        return telIntellicallHandler.telephoneState;
    }

    static /* synthetic */ String access$900(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, ITelTextFactory iTelTextFactory) {
        return TelIntellicallHandler.getTelephoneNameLabelValue(iTelDSIMobileEquipmentDeviceState, iTelTextFactory);
    }

    static /* synthetic */ void access$1400(TelIntellicallHandler telIntellicallHandler) {
        telIntellicallHandler.updatePrimaryDeviceName();
    }

    static /* synthetic */ LogChannel access$1500(TelIntellicallHandler telIntellicallHandler) {
        return telIntellicallHandler.log;
    }

    static /* synthetic */ TerminalModeDevice access$1602(TelIntellicallHandler telIntellicallHandler, TerminalModeDevice terminalModeDevice) {
        telIntellicallHandler.pActiveDevice = terminalModeDevice;
        return telIntellicallHandler.pActiveDevice;
    }

    static /* synthetic */ LogChannel access$1700(TelIntellicallHandler telIntellicallHandler) {
        return telIntellicallHandler.log;
    }

    static /* synthetic */ boolean access$1802(TelIntellicallHandler telIntellicallHandler, boolean bl) {
        telIntellicallHandler.isTMVideoFocus = bl;
        return telIntellicallHandler.isTMVideoFocus;
    }
}

