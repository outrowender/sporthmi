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
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.lang.AbstractTelLangaugeUpdateListener;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.screen.AbstractTelDefaultScreenStateListener;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.core.state.CallState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.core.util.TelLoggingUtils;
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
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class TelIntellicallHandler
extends AbstractEvoPhoneComponent
implements IActionProxyListener,
ITelIntellicallHandler {
    public static final int INTELLICALL_MENU_WIDGET_ID = 200;
    private static final boolean USE_DEFAULT_ERROR_HANDLING = true;
    private static final int DOWN_TRANSITION = 0;
    private static final int UP_TRANSITION = 1;
    private static final int SHOW_CALL_STACKS = 1;
    private static final int INTELLICALL_VIEW_MODE_FULL = 0;
    private static final int INTELLICALL_VIEW_MODE_REDUCED = 1;
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
        this.ROLE_CHANGE_POPUP = 300336;
        this.fullViewFocusManager = new IntellicallFullMenuFocusHandler(iTelEvoApplication);
        this.reducedFocusManager = new IntellicallReducedMenuFocusHandler(iTelEvoApplication);
        this.dsiSearchManager = iTelDSISearchAccess;
        this.tmUpdateListener = new IntelliCallTerminalModeUpdateListener();
        this.terminalModeUpdateListnerService = new PhoneServiceProvider((class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = TelIntellicallHandler.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener).getName(), this.tmUpdateListener, null, iTelEvoApplication.getBundleContext(), this.log);
        this.addSubPhoneComponent(new IntellicallFullCallListHandler(iTelEvoApplication));
        this.addSubPhoneComponent(new IntellicallReducedCallListHandler(iTelEvoApplication));
        this.addSubPhoneComponent(this.fullViewFocusManager);
        this.addSubPhoneComponent(this.reducedFocusManager);
        this.addSubPhoneComponent(new TelFurtherCallOptionButtonListener(iTelEvoApplication));
        this.addSubPhoneComponent(new IntellicallCombinedCallStackHandler(iTelEvoApplication));
        this.addSubPhoneComponent(new IntellicallFullScreenListener(iTelEvoApplication));
        this.addSubPhoneComponent(new TogglePhonesOptionHandler(iTelEvoApplication));
        this.addSubPhoneComponent(new IntellicallMainLanguageUpdateListener(iTelEvoApplication));
    }

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
        this.getApplication().getGlobalTelephoneStateManager().registerListener(new IGlobalTelephoneStateListener(){

            public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
                TelIntellicallHandler.this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
                TelIntellicallHandler.this.terminalModeUpdateListnerService.startService();
            }
        });
        this.getChoiceModel(300686).setValue(1);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(8, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(5, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(4, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(6, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(15, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(27, this);
        this.getResourceLocatorModel(300793).setStatus(0);
    }

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

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        CallStateStruct callStateStruct;
        this.telephoneState = iGlobalTelephoneStateStruct;
        if (n == 262156 && iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType()) {
            this.setFurtherCallOptionPossibility(false);
            this.getBaseListModel(300753).trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
            this.checkIntellicallViewMode(iGlobalTelephoneStateStruct.getConnectedGatewayState().getCall().getState());
            return;
        }
        if (n == 65554) {
            this.updatePrimaryDeviceName();
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() : null;
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getNonCallLeadingDevice() : null;
        CallStateStruct callStateStruct2 = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() : null;
        CallStateStruct callStateStruct3 = callStateStruct = iTelDSIMobileEquipmentDeviceState2 != null ? iTelDSIMobileEquipmentDeviceState2.getCallState() : null;
        if ((n == 65544 || n == 131080 || n == 196616) && iTelDSIMobileEquipmentDeviceState != null && callStateStruct2 != null) {
            this.resolveFurtherCallPossibility(iTelDSIMobileEquipmentDeviceState);
            this.checkIfClosingOfLeftDrawerIsNeeded(callStateStruct2);
            this.checkIntellicallViewMode(callStateStruct2, callStateStruct);
            this.jumpToPhoneApplicationIfNeeded(callStateStruct2);
        } else if (n == 262148) {
            this.getChoiceModel(300806).setValue(iGlobalTelephoneStateStruct.isNewSMSAvailable() ? 1 : 0);
        } else if (n == 65539 || n == 65551 || n == 131075 || n == 131087 || n == 196611 || n == 196623) {
            this.resolveFurtherCallPossibility(iTelDSIMobileEquipmentDeviceState);
        }
    }

    private void checkIfClosingOfLeftDrawerIsNeeded(CallStateStruct callStateStruct) {
        if (this.isG24() && callStateStruct != null && callStateStruct.isHasIncomingCall()) {
            this.getBaseListModel(300753).trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
        }
    }

    private void updatePrimaryDeviceName() {
        String string = TelIntellicallHandler.getTelephoneNameLabelValue(this.telephoneState != null ? this.telephoneState.getPrimaryDeviceState() : null, this.getApplication().getTextFactory());
        LabelModelApp labelModelApp = this.getApplication().getFrameworkAccess().getHMIService().getLabelModel(301075);
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
                this.log.log(1000000, "[TelIntellicallHandler#checkIntellicallViewMode] no calls present - setting view mode to INTELLICALL_MAIN");
                this.setIntellicallFullViewMode();
            } else if (callStateStruct.getMpCallState() == 15 && this.intellicallReducedModeEntered) {
                this.log.log(1000000, "[TelIntellicallHandler#checkIntellicallViewMode] MPCALLSTATE_RINGING --> setting view mode and switching to INTELLICALL_MAIN");
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
                    this.log.log(10000000, "[TelIntellicallHandler#updateGlobalTelephoneStateProperty] no handling for transition %1", (Object)CallState.getTransitionString(n));
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
        this.log.log(1000000, new StringBuffer().append("[TelIntellicallHandler#jumpToPhoneApplicationIfNeeded] telAppEntered=%1, callTransition=%2, hasIncomingCall=").append(callStateStruct.isHasIncomingCall()).append("isTerminalModeActive=").append(this.isTerminalModeActive()).toString(), this.telAppEntered, (long)callStateStruct.getTransition());
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
        this.getChoiceModel(300955).setValue(bl ? 1 : 0);
    }

    private void directTransitionToActiveDetected() {
        this.log.log(10000000, "[TelIntellicallHandler#directTransitionToActiveDetected]");
        this.transitionToReducedViewFocusActiveOrDialingCall();
    }

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
                this.getChoiceModel(300845).setValue(0);
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
                this.getChoiceModel(300845).setValue(1);
                break;
            }
            default: {
                this.log.log(100000, "[TelIntellicallHandler#actionProxyCallPerformed] unhandled methodID=%1", (long)n);
            }
        }
    }

    protected void intellicallReducedModeEntered() {
        this.log.log(1000000, "[TelIntellicallHandler#intellicallReducedModeEntered]");
        this.intellicallReducedModeEntered = true;
        this.intellicallFullModeEntered = false;
        this.setIntellicallReducedViewMode();
    }

    protected void intellicallFullViewEntered() {
        this.log.log(1000000, "[TelIntellicallHandler#intellicallFullViewEntered]");
        this.intellicallFullModeEntered = true;
        this.intellicallReducedModeEntered = false;
        this.setIntellicallFullViewMode();
    }

    public void callAccepted() {
        this.log.log(1000000, "[TelIntellicallHandler#callAccepted] call accepted, transitioning to reduced view.");
        this.transitionToReducedViewFocusActiveOrDialingCall();
    }

    public void eCallDialed() {
        this.log.log(1000000, "[TelIntellicallHandler#eCallDialed] eCall dialed, transitioning to reduced view.");
        this.transitionToReducedViewFocusDialingECall();
    }

    public void callDialed() {
        this.log.log(1000000, "[TelIntellicallHandler#callDialed] call dialed, transitioning to reduced view.");
        this.transitionToReducedViewFocusActiveOrDialingCall();
    }

    public void conferenceEstablished() {
        this.log.log(1000000, "[TelIntellicallHandler#conferenceEstablished] conference established, transitioning to reduced view.");
        this.transitionToReducedViewFocusActiveOrDialingCall();
    }

    public void dtmfEntrySelected() {
        this.log.log(1000000, "[TelIntellicallHandler#dtmfEntrySelected] transitioning to reduced view.");
        this.transitionToReducedViewFocusDTMF();
    }

    public void dialNumber(String string, int n) {
        this.dialNumber(string, n, this.getApplication().getDefaultListener());
    }

    public void dialNumber(String string, int n, final ITelDSIResponseListener iTelDSIResponseListener) {
        if (this.intellicallFullModeEntered) {
            this.groupModels();
        }
        this.getApplication().getTelephoneDSIAccess().dialNumber(string, n, true, new TelDefaultDSIResponseListener(){

            public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
                TelIntellicallHandler.this.processDialNumberResponse(iTelDSIResponseListener, n, n2, suppServiceResponseStruct, n3);
            }
        });
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

    public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, int n3) {
        this.dialNumberFromDBEntry(string, l, string2, s, s2, resourceLocator, n, n2, n3, this.getApplication().getDefaultListener());
    }

    public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, int n3, final ITelDSIResponseListener iTelDSIResponseListener) {
        if (this.intellicallFullModeEntered) {
            this.groupModels();
        }
        this.getApplication().getTelephoneDSIAccess().dialNumberFromDBEntry(string, l, string2, s, s2, resourceLocator, n, n2, n3, true, new TelDefaultDSIResponseListener(){

            public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
                TelIntellicallHandler.this.processDialNumberResponse(iTelDSIResponseListener, n, n2, suppServiceResponseStruct, n3);
            }
        });
    }

    public void dialNumberFromCallStackEntry(CallStackEntry callStackEntry, int n) {
        this.dialNumberFromCallStackEntry(callStackEntry, n, this.getApplication().getDefaultListener());
    }

    public void dialNumberFromCallStackEntry(CallStackEntry callStackEntry, int n, final ITelDSIResponseListener iTelDSIResponseListener) {
        if (this.intellicallFullModeEntered) {
            this.groupModels();
        }
        this.getApplication().getTelephoneDSIAccess().dialNumberFromCallStackEntry(callStackEntry, n, true, new TelDefaultDSIResponseListener(){

            public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
                TelIntellicallHandler.this.processDialNumberResponse(iTelDSIResponseListener, n, n2, suppServiceResponseStruct, n3);
            }
        });
    }

    public void dialNumberFromADBEntry(AdbEntry adbEntry, int n, int n2) {
        this.dialNumberFromADBEntry(adbEntry, n, n2, this.getApplication().getDefaultListener());
    }

    public void dialNumberFromADBEntry(AdbEntry adbEntry, int n, int n2, final ITelDSIResponseListener iTelDSIResponseListener) {
        if (this.intellicallFullModeEntered) {
            this.groupModels();
        }
        this.getApplication().getTelephoneDSIAccess().dialNumberFromADBEntry(adbEntry, n, n2, true, new TelDefaultDSIResponseListener(){

            public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
                TelIntellicallHandler.this.processDialNumberResponse(iTelDSIResponseListener, n, n2, suppServiceResponseStruct, n3);
            }
        });
    }

    private synchronized void groupModels() {
        this.log.log(1000000, "[TelIntellicallHandler#groupModels]");
        this.modelGroup.add(this.getListModel(300441));
        this.modelGroup.add(this.getBaseListModel(300827));
        this.modelGroup.add(this.getChoiceModel(300698));
        this.modelGroup.add(this.getSpellerModel(300391));
        this.modelGroup.add(this.getBaseListModel(300718));
        this.modelGroup.add(this.getChoiceModel(300687));
        this.modelGroup.add(this.getChoiceModel(300398));
        this.modelGroup.add(this.getChoiceModel(300686));
        this.modelGroup.add(this.getLabelModel(300467));
    }

    private synchronized void flushAndRemoveModels() {
        this.log.log(1000000, "[TelIntellicallHandler#flushAndRemoveModels]");
        this.modelGroup.flush();
        this.modelGroup.removeAll();
    }

    private void transitionToFullView() {
        this.log.log(10000000, "[TelIntellicallHandler#transitionToFullView]");
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
        this.log.log(10000000, "[TelIntellicallHandler#transitionToReducedViewFocusDialingECall]");
        this.reducedFocusManager.focusDialingECall();
        this.setIntellicallReducedViewMode();
        this.switchToIntellicall();
    }

    protected void transitionToReducedViewFocusActiveOrDialingCall() {
        this.log.log(10000000, "[TelIntellicallHandler#transitionToReducedViewFocusActiveOrDialingCall]");
        this.reducedFocusManager.focusActiveOrDialingCall();
        this.setIntellicallReducedViewMode();
        this.switchToIntellicall();
    }

    protected void transitionToReducedViewFocusDTMF() {
        this.log.log(10000000, "[TelIntellicallHandler#transitionToReducedViewFocusDTMF]");
        this.reducedFocusManager.focusDtmf();
        this.setIntellicallReducedViewMode();
        this.switchToIntellicall();
    }

    private void setIntellicallFullViewMode() {
        this.log.log(10000000, "[TelIntellicallHandler#setIntellicallFullViewMode] - setting to INTELLICALL_MAIN");
        this.intellicallViewMode = 0;
        this.getChoiceModel(300688).setValue(0);
    }

    private void setIntellicallReducedViewMode() {
        this.log.log(10000000, "[TelIntellicallHandler#setIntellicallReducedViewMode] - setting to INTELLICALL_REDUCED.");
        this.intellicallViewMode = 1;
        this.getChoiceModel(300688).setValue(1);
    }

    private void switchToIntellicall() {
        int n = this.getChoiceModel(300688).getValue();
        this.log.log(10000000, "[TelIntellicallHandler#switchToIntellicall] switching to %1", (Object)(n == 0 ? "INTELLICALL_MAIN" : "INTELLICALL_REDUCED"));
        ChoiceModelApp choiceModelApp = this.getChoiceModel(300747);
        int n2 = choiceModelApp.getValue();
        int n3 = n2 == 0 ? 1 : 0;
        this.getChoiceModel(300747).setValue(n3);
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

    private class TogglePhonesOptionHandler
    extends TelDefaultButtonListener {
        private TogglePhonesOptionHandler(ITelApplication iTelApplication) {
            super(iTelApplication, 300997);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelIntellicallHandler.TogglePhonesOptionHandler#keyTyped] Toggle phones key typed: reset Cursor, reset Truffle Search view");
            final String string = TelIntellicallHandler.getTelephoneNameLabelValue(TelIntellicallHandler.this.telephoneState.getPrimaryDeviceState(), this.getApplication().getTextFactory());
            final String string2 = TelIntellicallHandler.getTelephoneNameLabelValue(TelIntellicallHandler.this.telephoneState.getAssociatedDeviceState(), this.getApplication().getTextFactory());
            this.getApplication().getTelephoneDSIAccess().togglePhones(n3, true, new TelDefaultDSIResponseListener(){

                public void responseChangeTopology(int n, int n2) {
                    if (n == 0) {
                        TogglePhonesOptionHandler.this.log.log(1000000, "[TelIntellicallHandler.TogglePhonesOptionHandler#responseChangeTopology] Toggle phones key typed: reset Cursor, reset Truffle Search view");
                        this.updateDeviceNames(string2, string);
                        TogglePhonesOptionHandler.this.getApplication().getFrameworkAccess().getHmiServiceApp().showPartialPopup(0, 300336);
                    }
                }

                private void updateDeviceNames(String string3, String string22) {
                    ModelGroup modelGroup = new ModelGroup();
                    LabelModelApp labelModelApp = TogglePhonesOptionHandler.this.getApplication().getFrameworkAccess().getHMIService().getLabelModel(301075);
                    LabelModelApp labelModelApp2 = TogglePhonesOptionHandler.this.getApplication().getFrameworkAccess().getHMIService().getLabelModel(301115);
                    modelGroup.add(labelModelApp);
                    modelGroup.add(labelModelApp2);
                    labelModelApp.setText(string3);
                    labelModelApp2.setText(string22);
                    modelGroup.flush();
                    modelGroup.removeAll();
                }
            });
            TelIntellicallHandler.this.clearTrueffelSearch();
            this.getMenuModel(300744).setFocusedItem(200, null, -1L);
        }
    }

    private class IntellicallFullScreenListener
    extends AbstractTelDefaultScreenStateListener {
        private IntellicallFullScreenListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 300045);
        }

        public void notifyScreenFadedOut(int n) {
            this.log.log(1000000, "[TelIntellicallHandler.IntellicallReducedScreenListener#notifyScreenFadedOut] INTELLICALL_MAIN faded out.");
            TelIntellicallHandler.this.flushAndRemoveModels();
        }
    }

    private class TelFurtherCallOptionButtonListener
    extends TelDefaultButtonListener {
        private TelFurtherCallOptionButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300864);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelIntellicallHandler.TelFurtherCallOptionButtonListener#keyTyped] %1", (Object)TelLoggingUtils.keyTyped(n, n2, n3));
            TelIntellicallHandler.this.clearTrueffelSearch();
            this.getMenuModel(300744).setFocusedItem(200, null, -1L);
            this.getButtonModel(n).fireEvent(n3);
        }
    }

    private class IntelliCallTerminalModeUpdateListener
    extends DefaultTerminalModeUpdateListener {
        private IntelliCallTerminalModeUpdateListener() {
        }

        public void updateActiveDeviceState(TerminalModeDevice terminalModeDevice) {
            TelIntellicallHandler.this.log.log(1000000, "[TelTerminalModeHandler#updateActiveDeviceState] pActiveDevice=%1", (Object)terminalModeDevice);
            TelIntellicallHandler.this.pActiveDevice = terminalModeDevice;
        }

        public void updateTMVideoFocus(boolean bl) {
            TelIntellicallHandler.this.log.log(1000000, "[TelTerminalModeHandler#updateTMVideoFocus] pVideoFocus=%1", bl);
            TelIntellicallHandler.this.isTMVideoFocus = bl;
        }
    }

    private class IntellicallMainLanguageUpdateListener
    extends AbstractTelLangaugeUpdateListener {
        public IntellicallMainLanguageUpdateListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main");
        }

        public void setLanguage(Language language) {
            this.log.log(1000000, "[TelIntellicallHandler.IntellicallMainLanguageUpdateListener#setLanguage] refreshing primary device name");
            TelIntellicallHandler.this.updatePrimaryDeviceName();
        }
    }
}

