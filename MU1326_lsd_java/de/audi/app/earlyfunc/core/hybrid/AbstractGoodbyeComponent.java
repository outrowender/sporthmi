/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.handler.DefaultMenuModelHandler;
import de.audi.app.car.common.power.IPowerEventListener;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.earlyfunc.core.hybrid.CarNetworkPlatformInfo;
import de.audi.app.earlyfunc.core.hybrid.ChargePopupHandler;
import de.audi.app.earlyfunc.core.hybrid.GoodbyeMenuEventBusiness;
import de.audi.app.earlyfunc.core.hybrid.GoodbyePopupHKTimerController;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.interapp.IBattCtrlCommunicationService;
import de.audi.atip.interapp.IBatteryControlListHandlingCallback;
import de.audi.atip.interapp.IBatteryControlListHandlingConstants;
import de.audi.atip.interapp.IBatteryControlListHandlingService;
import de.audi.atip.metrics.DateMetric;
import java.util.Date;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlConfiguration;
import org.dsi.ifc.carhybrid.BatteryControlExpiredTimer;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;

public abstract class AbstractGoodbyeComponent
extends AbstractDSICarHybridAdapter
implements IPowerEventListener,
ChoiceListener,
IBatteryControlListHandlingCallback,
IBatteryControlListHandlingConstants,
IBattCtrlCommunicationService {
    public static final short CODING_ID1 = 41;
    public static final short CODING_ID2 = 46;
    protected static final String LOGCHANNEL_NAME = "App.EarlyFunc.Goodbye";
    public static final int CHARGE_POPUP_ID_INVALID = -1;
    private BatteryControlViewOptions currBConViewOptions;
    private BatteryControlConfiguration bcConfig = null;
    private static final int IMMEDIATE_CONTROL_STOP = 0;
    private static final int IMMEDIATE_CONTROL_START = 1;
    private static final int PROFILE_ID_TIMER1 = 3;
    private static final int PROFILE_ID_TIMER2 = 4;
    private static final int PROFILE_ID_IMMEDIATE = 6;
    private static final int CLIMATE_STATE_ARROW_GRAPHIC_INVISIBLE = 0;
    private static final int CLIMATE_STATE_ARROW_GRAPHIC_RED_BLUE = 3;
    private GoodbyePopupHKTimerController popupHKTimer = null;
    private CarServiceProvider serviceProvider;
    private CarNetworkPlatformInfo networkPlatformInfo;
    private ChargePopupHandler popupHandler;
    private volatile BatteryControlClimateState currClimateState;
    private final int INITIAL_CLAMP_STATE;
    private final int CLAMP_STATE_ON;
    private final int CLAMP_STATE_OFF;
    private int currentState = 0;
    private Object mutex = new Object();
    private CarServiceTracker goodbyeTracker;
    private DefaultMenuModelHandler goodbyeMenuHandler;
    private IBatteryControlListHandlingService bcListHandlingService;
    private BatteryControlTimerState currentTimerState;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBattCtrlCommunicationService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBatteryControlListHandlingService;

    public AbstractGoodbyeComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.INITIAL_CLAMP_STATE = 0;
        this.CLAMP_STATE_ON = 1;
        this.CLAMP_STATE_OFF = 2;
        this.popupHandler = new ChargePopupHandler(iCarApplication, this, this.getLogChannel());
        this.currentTimerState = new BatteryControlTimerState(new BatteryControlProgrammedTimer(), new BatteryControlExpiredTimer());
        this.networkPlatformInfo = new CarNetworkPlatformInfo(this.getApplication().getFrameworkAccess());
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{6}, new int[]{11, 12, 13, 14, 10, 24, 18, 15, 17, 9, 8})};
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected:", n, n2, true);
        switch (n) {
            case 2100361: {
                if (this.bcListHandlingService.getProfileListLength() > 1) {
                    if (!this.bcListHandlingService.isProfileXOperationCharge(1)) {
                        this.bcListHandlingService.setProfileXOperationCharge(1, true);
                    }
                    if (this.bcListHandlingService.getProfileXProviderDataId(1) != this.bcListHandlingService.getProfile1Pos()) {
                        this.bcListHandlingService.setProfile1ProviderDataId(this.bcListHandlingService.getProfile1Pos());
                    }
                }
                this.switchChargeTimerActivation(n2 == 1);
                break;
            }
            case 2100368: {
                if (this.bcListHandlingService.getProfileListLength() > 1) {
                    if (!this.bcListHandlingService.isProfileXOperationCharge(2)) {
                        this.bcListHandlingService.setProfileXOperationCharge(2, true);
                    }
                    if (this.bcListHandlingService.getProfileXProviderDataId(2) != this.bcListHandlingService.getProfile2Pos()) {
                        this.bcListHandlingService.setProfile2ProviderDataId(this.bcListHandlingService.getProfile2Pos());
                    }
                }
                this.switchChargeTimerActivation(n2 == 1);
                break;
            }
            case 2100369: {
                this.switchClimateTimerActivation(n2 == 1);
                break;
            }
            case 2100362: {
                this.switchClimateTimerActivation(n2 == 1);
                break;
            }
            case 2100505: {
                this.submitAllowParkHeaterChoice(n2, 1);
                break;
            }
            case 2100506: {
                this.submitAllowParkHeaterChoice(n2, 2);
                break;
            }
        }
    }

    private void switchChargeTimerActivation(boolean bl) {
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        boolean bl5 = true;
        if (this.getNextChargeTimerId() == 1) {
            bl2 = bl;
            bl3 = this.currentTimerState.programmedTimer.timer2;
            bl4 = this.currentTimerState.programmedTimer.timer3;
            bl5 = this.currentTimerState.programmedTimer.timer4;
        } else if (this.getNextChargeTimerId() == 2) {
            bl2 = this.currentTimerState.programmedTimer.timer1;
            bl3 = bl;
            bl4 = this.currentTimerState.programmedTimer.timer3;
            bl5 = this.currentTimerState.programmedTimer.timer4;
        }
        BatteryControlProgrammedTimer batteryControlProgrammedTimer = new BatteryControlProgrammedTimer(bl2, bl3, bl4, bl5);
        this.getLogChannel().log(1000000, "switchTimerActivation: dsi.setBatteryControlTimerState(timer=%1)", (Object)batteryControlProgrammedTimer);
        this.getDSI().setBatteryControlTimerState(batteryControlProgrammedTimer);
    }

    private void switchClimateTimerActivation(boolean bl) {
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        boolean bl5 = true;
        if (this.getNextClimateTimerId() == 3) {
            bl2 = this.currentTimerState.programmedTimer.timer1;
            bl3 = this.currentTimerState.programmedTimer.timer2;
            bl4 = bl;
            bl5 = this.currentTimerState.programmedTimer.timer4;
        } else if (this.getNextClimateTimerId() == 4) {
            bl2 = this.currentTimerState.programmedTimer.timer1;
            bl3 = this.currentTimerState.programmedTimer.timer2;
            bl4 = this.currentTimerState.programmedTimer.timer3;
            bl5 = bl;
        }
        BatteryControlProgrammedTimer batteryControlProgrammedTimer = new BatteryControlProgrammedTimer(bl2, bl3, bl4, bl5);
        this.getLogChannel().log(1000000, "switchTimerActivation: dsi.setBatteryControlTimerState(timer=%1)", (Object)batteryControlProgrammedTimer);
        this.getDSI().setBatteryControlTimerState(batteryControlProgrammedTimer);
    }

    private void submitAllowParkHeaterChoice(int n, int n2) {
        if (n2 >= 1 && n2 <= 2) {
            this.bcListHandlingService.setAuxAcClimateSystem(n2, n == 1 ? 0 : 1);
        }
    }

    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBatteryControlViewOptions(%1), valid=%2", (Object)(batteryControlViewOptions != null ? this.formatViewOptionsLog(batteryControlViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && batteryControlViewOptions != null) {
            this.currBConViewOptions = batteryControlViewOptions;
            this.updateMenuEntryVisibility(this.currBConViewOptions);
            if (batteryControlViewOptions.getConfiguration() != null) {
                this.bcConfig = batteryControlViewOptions.getConfiguration();
            }
            this.primaryAttributeFirstSetReceived();
        }
    }

    protected abstract void updateAllowParkHeaterMEVisibility(BatteryControlViewOptions var1);

    public void updateBatteryControlClimateState(BatteryControlClimateState batteryControlClimateState, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlClimateState: climateState=%1, validFlag=%2", (Object)batteryControlClimateState, (long)n);
        if (n == 1) {
            this.currClimateState = batteryControlClimateState;
            this.updateAllowParkHeaterMEVisibility(this.currBConViewOptions);
            if (this.currClimateState.climateMode != null) {
                boolean bl = this.currClimateState.climateMode.isClimating();
                this.getChoiceModel(2100401).setValue(bl ? 1 : 0);
                this.updateAuxACImmediateOn(bl);
            }
            if (this.currClimateState.climateState == 12) {
                this.getChoiceModel(2100489).setValue(3);
            } else {
                this.getChoiceModel(2100489).setValue(0);
            }
        }
    }

    public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlChargeState: chargeState=%1, validFlag=%2", (Object)batteryControlChargeState, (long)n);
        if (n == 1 && batteryControlChargeState.remainingChargeTime != 65535 && batteryControlChargeState.chargeState == 2) {
            DateMetric dateMetric = new DateMetric(new Date(batteryControlChargeState.remainingChargeTime * 60000), 5);
            dateMetric.setUseInstanceUnit(true);
            this.getMetricsModel(2100378).setMetric(dateMetric);
            this.getMetricsModel(2100378).formatChanged();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Object object = this.mutex;
        synchronized (object) {
            this.getLogChannel().log(1000000, "updateClampState: clampS=%1, clamp15=%2", bl, bl2);
            if (!bl2) {
                if (this.currentState == 1) {
                    if (this.currBConViewOptions != null && this.currBConViewOptions.getConfiguration() != null) {
                        this.updateMenuEntryVisibility(this.currBConViewOptions);
                        this.requestChargePopup(-1);
                    } else {
                        this.getLogChannel().log(100000, "AbstractGoodbyeComponent::updateAllowParkHeaterMEVisibility Trying to show popup but have VOs=%1", (Object)(this.currBConViewOptions != null ? this.currBConViewOptions.toString() : "null"));
                    }
                    this.currentState = 2;
                }
            } else {
                this.removePopup();
                this.currentState = 1;
            }
            if (!bl) {
                this.removePopup();
            }
        }
    }

    public void notifyPowerListenerOnEnterState(int n) {
    }

    public void notifyPowerListenerOnExitState(int n) {
    }

    public void notifyPowerTriggerAction(int n) {
    }

    public void requestChargePopup(int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "requestChargePopup(%1)", (long)n);
        }
        if (this.getPopUpID() != -1) {
            this.popupHandler.requestChargePopup(n, true);
            this.popupHKTimer.resetActivated();
        }
    }

    public void removePopup() {
        this.popupHandler.removePopup();
        this.popupHKTimer.deactivate();
    }

    protected abstract void updateMenuEntryVisibility(BatteryControlViewOptions var1);

    public abstract int getPopUpID();

    protected abstract void updateAuxACImmediateOn(boolean var1);

    public void init() {
        super.init();
        this.getApplication().getPowerEventDispatcher().addPowerEventListener(this);
        this.goodbyeTracker = new CarServiceTracker(new BCListHandlingTrackerListener(this), this.getApplication().getBundleContext(), this.getApplication().getFrameworkAccess().getLogChannel(LOGCHANNEL_NAME));
        this.goodbyeTracker.startTracking();
        this.serviceProvider = new CarServiceProvider((class$de$audi$atip$interapp$IBattCtrlCommunicationService == null ? (class$de$audi$atip$interapp$IBattCtrlCommunicationService = AbstractGoodbyeComponent.class$("de.audi.atip.interapp.IBattCtrlCommunicationService")) : class$de$audi$atip$interapp$IBattCtrlCommunicationService).getName(), this, null, this.getApplication().getBundleContext(), this.getApplication().getFrameworkAccess().getLogChannel(LOGCHANNEL_NAME));
        this.serviceProvider.startService();
    }

    public void deinit() {
        this.serviceProvider.stopService();
    }

    protected void initModels() {
        this.popupHKTimer = new GoodbyePopupHKTimerController(this.popupHandler, this.getApplication().getFrameworkAccess(), this.getLogChannel());
        this.getChoiceModel(2100361).setChoiceListener(this);
        this.getChoiceModel(2100368).setChoiceListener(this);
        this.getChoiceModel(2100369).setChoiceListener(this);
        this.getChoiceModel(2100362).setChoiceListener(this);
        this.getChoiceModel(2100505).setChoiceListener(this);
        this.getChoiceModel(2100506).setChoiceListener(this);
        this.popupHandler.init();
        this.goodbyeMenuHandler = new DefaultMenuModelHandler(this.getMenuModel(2100398), this.getLogChannel());
        this.getButtonModel(2100394).setButtonListener(this);
        this.getButtonModel(2100395).setButtonListener(this);
    }

    protected void initBusiness() {
        if (this.networkPlatformInfo.isMLBEvo()) {
            this.goodbyeMenuHandler.setBusiness(new GoodbyeMenuEventBusiness(this.getDSI(), this.getChoiceModel(2100399), this.popupHKTimer, this.getLogChannel()));
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logModelData("keyPressed", n, n2, true);
        switch (n) {
            case 2100394: {
                this.switchImmediate(1);
                break;
            }
            case 2100395: {
                this.switchImmediate(0);
                break;
            }
        }
    }

    private void switchImmediate(int n) {
        this.checkProfileSettings(6);
        this.getLogChannel().log(1000000, "dsi.setBatteryControlImmediately(6,%1)", (long)n);
        this.getDSI().setBatteryControlImmediately(6, n);
    }

    private void checkProfileSettings(int n) {
        if (!this.bcListHandlingService.isProfileXOperationClimate(n)) {
            this.bcListHandlingService.setProfileXOperationClimate(n, true);
        }
        if (this.bcListHandlingService.isProfileXOperationCharge(n)) {
            this.bcListHandlingService.setProfileXOperationCharge(n, false);
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public int getNextChargeTimerId() {
        boolean bl = false;
        boolean bl2 = false;
        Date date = new Date();
        Date date2 = new Date();
        if (this.getChoiceModel(2100361) != null && this.getDateMetric(2100371) != null) {
            bl = this.getChoiceModel(2100361).getValue() == 1;
            date = this.getDateMetric(2100371).getDate();
        }
        if (this.getChoiceModel(2100368) != null && this.getDateMetric(2100370) != null) {
            bl2 = this.getChoiceModel(2100368).getValue() == 1;
            date2 = this.getDateMetric(2100370).getDate();
        }
        int n = date.before(date2) ? (bl ? 1 : (bl2 ? 2 : 0)) : (bl2 ? 2 : (bl ? 1 : 0));
        return n;
    }

    public synchronized BatteryControlClimateState getCurrClimateState() {
        return this.currClimateState;
    }

    public int getNextClimateTimerId() {
        boolean bl = false;
        boolean bl2 = false;
        Date date = new Date();
        Date date2 = new Date();
        if (this.getChoiceModel(2100369) != null && this.getDateMetric(2100363) != null) {
            bl = this.getChoiceModel(2100369).getValue() == 1;
            date = this.getDateMetric(2100363).getDate();
        }
        if (this.getChoiceModel(2100362) != null && this.getDateMetric(2100364) != null) {
            bl2 = this.getChoiceModel(2100362).getValue() == 1;
            date2 = this.getDateMetric(2100364).getDate();
        }
        int n = date.before(date2) ? (bl ? 3 : (bl2 ? 4 : 0)) : (bl2 ? 4 : (bl ? 3 : 0));
        return n;
    }

    public void updateChargeTimerClimateChoice(int n, int n2) {
        switch (n) {
            case 1: {
                this.getChoiceModel(2100505).setValue(n2);
                break;
            }
            case 2: {
                this.getChoiceModel(2100506).setValue(n2);
                break;
            }
        }
    }

    public void updateClimateSystemType(int n, int n2) {
        switch (n) {
            case 1: {
                this.getChoiceModel(2100505).setValue(n2 == 0 ? 1 : (n2 == 1 ? 0 : 2));
                break;
            }
            case 2: {
                this.getChoiceModel(2100506).setValue(n2 == 0 ? 1 : (n2 == 1 ? 0 : 2));
                break;
            }
        }
    }

    public void updateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlTimerState: timer=%1, validflag=%2", (Object)batteryControlTimerState, (long)n);
        if (n == 1) {
            this.currentTimerState = batteryControlTimerState;
            this.getChoiceModel(2100361).setValue(batteryControlTimerState.getProgrammedTimer().isTimer1() ? 1 : 0);
            this.getChoiceModel(2100368).setValue(batteryControlTimerState.getProgrammedTimer().isTimer2() ? 1 : 0);
            this.getChoiceModel(2100369).setValue(batteryControlTimerState.getProgrammedTimer().isTimer3() ? 1 : 0);
            this.getChoiceModel(2100362).setValue(batteryControlTimerState.getProgrammedTimer().isTimer4() ? 1 : 0);
        }
        this.popupHKTimer.resetActivated();
        this.updateMenuEntryVisibility(this.currBConViewOptions);
    }

    public void onBatteryControlProfileOperationChanged(int n, BatteryControlProfileOperation batteryControlProfileOperation) {
    }

    public void chargeTimerMetricsUpdated(int n) {
        this.updateMenuEntryVisibility(this.currBConViewOptions);
    }

    public void climateTimerMetricsUpdated(int n) {
        this.updateMenuEntryVisibility(this.currBConViewOptions);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class BCListHandlingTrackerListener
    implements CarServiceTrackerListener {
        private AbstractGoodbyeComponent component;

        public BCListHandlingTrackerListener(AbstractGoodbyeComponent abstractGoodbyeComponent2) {
            this.component = abstractGoodbyeComponent2;
        }

        public void serviceAvailable(Object object) {
            AbstractGoodbyeComponent.this.bcListHandlingService = (IBatteryControlListHandlingService)object;
            AbstractGoodbyeComponent.this.bcListHandlingService.registerCalledBackComponent(this.component);
        }

        public void serviceRemoved() {
            AbstractGoodbyeComponent.this.bcListHandlingService = null;
        }

        public String[] getTrackedServiceClazzName() {
            return new String[]{(class$de$audi$atip$interapp$IBatteryControlListHandlingService == null ? (class$de$audi$atip$interapp$IBatteryControlListHandlingService = AbstractGoodbyeComponent.class$("de.audi.atip.interapp.IBatteryControlListHandlingService")) : class$de$audi$atip$interapp$IBatteryControlListHandlingService).getName()};
        }

        public IBatteryControlListHandlingService getGoodbyeService() {
            return AbstractGoodbyeComponent.this.bcListHandlingService;
        }
    }
}

