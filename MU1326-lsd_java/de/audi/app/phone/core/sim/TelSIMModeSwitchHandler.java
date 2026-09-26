/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.sim.SimUsageUserDecision;
import de.audi.app.phone.core.sim.TelSIMModeSwitchHandler$DataOnlyButtonListener;
import de.audi.app.phone.core.sim.TelSIMModeSwitchHandler$FactoryResetHandler;
import de.audi.app.phone.core.sim.TelSIMModeSwitchHandler$SimModeSwitchStorageHandler;
import de.audi.app.phone.core.sim.TelSIMModeSwitchHandler$SimUsageHkReturnButtonListener;
import de.audi.app.phone.core.sim.TelSIMModeSwitchHandler$VoiceAndDataButtonListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import de.audi.atip.interapp.IConnectivitySimUsageListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Converter;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelSIMModeSwitchHandler
extends AbstractPhoneComponent
implements ServiceTrackerCustomizer {
    private final TelSIMModeSwitchHandler$SimModeSwitchStorageHandler storageHandler;
    private final boolean isNadModeSwitch;
    private volatile IGlobalTelephoneStateStruct telState;
    private volatile SimUsageUserDecision[] simUserDecisions;
    private volatile String simCardID = "";
    private volatile PhoneServiceTracker connectivityPhoneStateListenerTracker;
    private volatile IConnectivitySimUsageListener simUsageListener;
    private volatile boolean showingIsAllowed;
    private final int UNKNOWN;
    private final int ACTIVE;
    private final int NOT_ACTIVE;
    private int eSIMActiveState = 0;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivitySimUsageListener;

    private static boolean simCardIDAvailable(String string) {
        return string != null && !"".equals(string);
    }

    public TelSIMModeSwitchHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.UNKNOWN = 0;
        this.ACTIVE = 1;
        this.NOT_ACTIVE = 2;
        this.storageHandler = new TelSIMModeSwitchHandler$SimModeSwitchStorageHandler(this, iTelApplication.getFrameworkAccess().getStorageMgr());
        this.isNadModeSwitch = iTelApplication.getFrameworkAccess().getSysConstManager().getAdaptationANP().isSimCardModeSwitch();
        this.addSubPhoneComponent(new TelSIMModeSwitchHandler$FactoryResetHandler(this, iTelApplication));
        this.addSubPhoneComponent(new TelSIMModeSwitchHandler$VoiceAndDataButtonListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelSIMModeSwitchHandler$DataOnlyButtonListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelSIMModeSwitchHandler$SimUsageHkReturnButtonListener(this, iTelApplication));
    }

    @Override
    public void init() {
        super.init();
        this.simUserDecisions = TelSIMModeSwitchHandler$SimModeSwitchStorageHandler.access$000(this.storageHandler);
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        boolean bl = this.getApplication().getFrameworkAccess().getSysApp().getAdaptationANP().isSimCardModeSwitch();
        boolean bl2 = this.getApplication().getFrameworkAccess().getSysConst(463) == 1;
        boolean bl3 = bl2 && bl;
        this.getChoiceModel(1670775808).setValue(bl3 ? 1 : 0);
        this.connectivityPhoneStateListenerTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$IConnectivitySimUsageListener == null ? (class$de$audi$atip$interapp$IConnectivitySimUsageListener = TelSIMModeSwitchHandler.class$("de.audi.atip.interapp.IConnectivitySimUsageListener")) : class$de$audi$atip$interapp$IConnectivitySimUsageListener).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.connectivityPhoneStateListenerTracker.openTracker();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.connectivityPhoneStateListenerTracker.closeTracker();
        this.connectivityPhoneStateListenerTracker = null;
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telState = iGlobalTelephoneStateStruct;
        if (this.isNadModeSwitch) {
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getNadInstanceState();
            String string = this.getSimCardID(iTelDSIMobileEquipmentDeviceState);
            SimUsageUserDecision simUsageUserDecision = this.getSIMUsageData(string);
            this.setShowingIsAllowed(n, iGlobalTelephoneStateStruct);
            this.setShowSimModeUsageScreenChoice(string, simUsageUserDecision, iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getTelMode() : 4);
            this.checkCallViaNadActive(iTelDSIMobileEquipmentDeviceState, simUsageUserDecision);
        }
    }

    private void setShowingIsAllowed(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 0x9000400) {
            int n2 = this.eSIMActiveState = iGlobalTelephoneStateStruct.isESIMActive() ? 1 : 2;
        }
        this.showingIsAllowed = iGlobalTelephoneStateStruct.getNadInstanceState() != null && iGlobalTelephoneStateStruct.getNadInstanceState().isPhoneReady() ? this.eSIMActiveState != 0 : false;
    }

    private boolean isShowingOfSIMSwitchPopupAllowed() {
        return this.showingIsAllowed;
    }

    private void checkCallViaNadActive(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, SimUsageUserDecision simUsageUserDecision) {
        int n = this.telState.getNadMode();
        if (iTelDSIMobileEquipmentDeviceState != null && n == 1) {
            boolean bl;
            boolean bl2 = iTelDSIMobileEquipmentDeviceState.getCallState() != null ? !iTelDSIMobileEquipmentDeviceState.getCallState().isIdle() : (bl = false);
            if (bl && simUsageUserDecision == null && this.isSimModeUsageToBeShown()) {
                this.log.log(1078071040, "[TelSIMModeSwitchHandler#checkCallViaNadActive] call is active but no user decision was made. Setting user decision to voice & data");
                this.resetShowSimModeUsageChoice();
                this.addSimUsageData(1);
            }
        }
    }

    private String getSimCardID(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getPhoneInformation() != null ? iTelDSIMobileEquipmentDeviceState.getPhoneInformation().getSimId() : "";
    }

    private void setShowSimModeUsageScreenChoice(String string, SimUsageUserDecision simUsageUserDecision, int n) {
        boolean bl = n == 0;
        boolean bl2 = string != null && !string.equals(this.simCardID);
        this.simCardID = string;
        if (this.eSIMActiveState == 1) {
            this.log.log(1078071040, "[TelSIMModeSwitchHandler#setShowSimModeUsageScreenChoice] ESIM is active. No usage for ESIM");
            this.showSimModeUsageChoice(false);
            return;
        }
        if (TelSIMModeSwitchHandler.simCardIDAvailable(string)) {
            if (simUsageUserDecision == null && bl) {
                if (bl2) {
                    this.log.log(1078071040, "[TelSIMModeSwitchHandler#setShowSimModeUsageScreenChoice] no usage data found for sim with id=%1", (Object)string);
                }
                if (this.isShowingOfSIMSwitchPopupAllowed()) {
                    this.log.log(1078071040, "[TelSIMModeSwitchHandler#setShowSimModeUsageScreenChoice] show SIM Usage id=%1", (Object)string);
                    this.showSimModeUsageChoice(true);
                } else {
                    this.log.log(1078071040, "[TelSIMModeSwitchHandler#setShowSimModeUsageScreenChoice] showing SIM Usage not allowed");
                }
            } else {
                if (bl2) {
                    this.log.log(1078071040, "[TelSIMModeSwitchHandler#setShowSimModeUsageScreenChoice] usage data found for sim with id=%1: %2", (Object)string, (Object)simUsageUserDecision);
                }
                this.showSimModeUsageChoice(false);
            }
        } else {
            this.showSimModeUsageChoice(false);
        }
    }

    private boolean isSimModeUsageToBeShown() {
        return this.getChoiceModel(1972831232).getValue() == 1;
    }

    protected void showSimModeUsageChoice(boolean bl) {
        if (this.simUsageListener != null) {
            this.simUsageListener.updateSimUsageToBeShown(bl);
        }
        this.getChoiceModel(1972831232).setValue(bl ? 1 : 0);
    }

    private void resetShowSimModeUsageChoice() {
        if (this.simUsageListener != null) {
            this.simUsageListener.updateSimUsageToBeShown(false);
        }
        this.getChoiceModel(1972831232).setValue(0);
    }

    protected void addSimUsageData(int n) {
        this.addSimUsageData(this.simCardID, n);
    }

    private void addSimUsageData(String string, int n) {
        SimUsageUserDecision[] simUsageUserDecisionArray = new SimUsageUserDecision[]{new SimUsageUserDecision(string, n)};
        this.log.log(1078071040, "[TelSIMModeSwitchHandler#addSimUsageData] usageInfo=%1", (Object)Converter.array2String(simUsageUserDecisionArray));
        TelSIMModeSwitchHandler$SimModeSwitchStorageHandler.access$100(this.storageHandler, simUsageUserDecisionArray);
        this.simUserDecisions = simUsageUserDecisionArray;
    }

    private SimUsageUserDecision getSIMUsageData(String string) {
        if (TelSIMModeSwitchHandler.simCardIDAvailable(string) && this.simUserDecisions != null) {
            for (int i2 = 0; i2 < this.simUserDecisions.length; ++i2) {
                if (this.simUserDecisions[i2] == null || this.simUserDecisions[i2].getSimCardID() == null || !this.simUserDecisions[i2].getSimCardID().equals(string)) continue;
                return this.simUserDecisions[i2];
            }
        }
        return null;
    }

    private void checkSwitchToDataOnly(int n, int n2) {
        if (this.telState != null) {
            int n3 = this.telState.getNadMode();
            if (n3 == 2) {
                this.log.log(1078071040, "[TelSIMModeSwitchHandler#checkSwitchToDataOnly] NAD-Mode is already in data only--> no switch necessary.");
                this.getApplication().getFrameworkAccess().getHMIService().getModelApp(n2).fireEvent(n);
            } else {
                this.log.log(1078071040, "[TelSIMModeSwitchHandler#checkSwitchToDataOnly] current nad mode is %1. Setting NAD-Mode to data only", (long)n3);
                this.getApplication().getTelephoneDSIAccess().requestSetNadMode(2, n);
            }
        } else {
            this.log.log(-1601830656, "[TelSIMModeSwitchHandler#checkSwitchToDataOnly] telState is null --> NOP!");
        }
    }

    private void checkSwitchToVoiceAndData(int n, int n2) {
        if (this.telState != null) {
            int n3 = this.telState.getNadMode();
            if (n3 == 1) {
                this.log.log(1078071040, "[TelSIMModeSwitchHandler#checkSwitchToVoiceAndData] NAD-Mode is already in Voice & Data --> no switch necessary.");
                this.getApplication().getFrameworkAccess().getHMIService().getModelApp(n2).fireEvent(n);
            } else {
                this.log.log(1078071040, "[TelSIMModeSwitchHandler#checkSwitchToVoiceAndData] current nad mode is %1. Setting NAD-Mode to Voice & Data", (long)n3);
                this.getApplication().getTelephoneDSIAccess().requestSetNadMode(1, n);
            }
        } else {
            this.log.log(-1601830656, "[TelSIMModeSwitchHandler#checkSwitchToVoiceAndData] telState is null --> NOP!");
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object instanceof IConnectivitySimUsageListener) {
            this.simUsageListener = (IConnectivitySimUsageListener)object;
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
        if (object instanceof IConnectivityPhoneStateListener) {
            this.simUsageListener = null;
            this.getApplication().getBundleContext().ungetService(serviceReference);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$200(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.log;
    }

    static /* synthetic */ LogChannel access$300(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.log;
    }

    static /* synthetic */ LogChannel access$400(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.log;
    }

    static /* synthetic */ LogChannel access$500(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.log;
    }

    static /* synthetic */ LogChannel access$600(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.log;
    }

    static /* synthetic */ LogChannel access$700(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.log;
    }

    static /* synthetic */ LogChannel access$800(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.log;
    }

    static /* synthetic */ LogChannel access$900(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.log;
    }

    static /* synthetic */ LogChannel access$1000(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.log;
    }

    static /* synthetic */ LogChannel access$1100(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.log;
    }

    static /* synthetic */ LogChannel access$1200(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.log;
    }

    static /* synthetic */ LogChannel access$1300(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.log;
    }

    static /* synthetic */ LogChannel access$1400(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.log;
    }

    static /* synthetic */ SimUsageUserDecision[] access$1502(TelSIMModeSwitchHandler telSIMModeSwitchHandler, SimUsageUserDecision[] simUsageUserDecisionArray) {
        telSIMModeSwitchHandler.simUserDecisions = simUsageUserDecisionArray;
        return simUsageUserDecisionArray;
    }

    static /* synthetic */ SimUsageUserDecision[] access$1500(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.simUserDecisions;
    }

    static /* synthetic */ TelSIMModeSwitchHandler$SimModeSwitchStorageHandler access$1600(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.storageHandler;
    }

    static /* synthetic */ void access$1700(TelSIMModeSwitchHandler telSIMModeSwitchHandler, int n, int n2) {
        telSIMModeSwitchHandler.checkSwitchToVoiceAndData(n, n2);
    }

    static /* synthetic */ void access$1800(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        telSIMModeSwitchHandler.resetShowSimModeUsageChoice();
    }

    static /* synthetic */ void access$1900(TelSIMModeSwitchHandler telSIMModeSwitchHandler, int n, int n2) {
        telSIMModeSwitchHandler.checkSwitchToDataOnly(n, n2);
    }

    static /* synthetic */ IGlobalTelephoneStateStruct access$2000(TelSIMModeSwitchHandler telSIMModeSwitchHandler) {
        return telSIMModeSwitchHandler.telState;
    }
}

