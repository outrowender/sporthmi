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
import de.audi.app.earlyfunc.core.hybrid.AbstractGoodbyeComponent$BCListHandlingTrackerListener;
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
    public static final short CODING_ID1;
    public static final short CODING_ID2;
    protected static final String LOGCHANNEL_NAME;
    public static final int CHARGE_POPUP_ID_INVALID;
    private BatteryControlViewOptions currBConViewOptions;
    private BatteryControlConfiguration bcConfig = null;
    private static final int IMMEDIATE_CONTROL_STOP;
    private static final int IMMEDIATE_CONTROL_START;
    private static final int PROFILE_ID_TIMER1;
    private static final int PROFILE_ID_TIMER2;
    private static final int PROFILE_ID_IMMEDIATE;
    private static final int CLIMATE_STATE_ARROW_GRAPHIC_INVISIBLE;
    private static final int CLIMATE_STATE_ARROW_GRAPHIC_RED_BLUE;
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
        super(iCarApplication, "App.EarlyFunc.Goodbye");
        this.INITIAL_CLAMP_STATE = 0;
        this.CLAMP_STATE_ON = 1;
        this.CLAMP_STATE_OFF = 2;
        this.popupHandler = new ChargePopupHandler(iCarApplication, this, this.getLogChannel());
        this.currentTimerState = new BatteryControlTimerState(new BatteryControlProgrammedTimer(), new BatteryControlExpiredTimer());
        this.networkPlatformInfo = new CarNetworkPlatformInfo(this.getApplication().getFrameworkAccess());
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{6}, new int[]{11, 12, 13, 14, 10, 24, 18, 15, 17, 9, 8})};
    }

    @Override
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
        this.getLogChannel().log(1078071040, "switchTimerActivation: dsi.setBatteryControlTimerState(timer=%1)", (Object)batteryControlProgrammedTimer);
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
        this.getLogChannel().log(1078071040, "switchTimerActivation: dsi.setBatteryControlTimerState(timer=%1)", (Object)batteryControlProgrammedTimer);
        this.getDSI().setBatteryControlTimerState(batteryControlProgrammedTimer);
    }

    private void submitAllowParkHeaterChoice(int n, int n2) {
        if (n2 >= 1 && n2 <= 2) {
            this.bcListHandlingService.setAuxAcClimateSystem(n2, n == 1 ? 0 : 1);
        }
    }

    @Override
    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateBatteryControlViewOptions(%1), valid=%2", (Object)(batteryControlViewOptions != null ? this.formatViewOptionsLog(batteryControlViewOptions.toString()) : "null"), (long)n);
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

    protected abstract void updateAllowParkHeaterMEVisibility(BatteryControlViewOptions batteryControlViewOptions) {
    }

    @Override
    public void updateBatteryControlClimateState(BatteryControlClimateState batteryControlClimateState, int n) {
        this.getLogChannel().log(1078071040, "updateBatteryControlClimateState: climateState=%1, validFlag=%2", (Object)batteryControlClimateState, (long)n);
        if (n == 1) {
            this.currClimateState = batteryControlClimateState;
            this.updateAllowParkHeaterMEVisibility(this.currBConViewOptions);
            if (this.currClimateState.climateMode != null) {
                boolean bl = this.currClimateState.climateMode.isClimating();
                this.getChoiceModel(-1324605440).setValue(bl ? 1 : 0);
                this.updateAuxACImmediateOn(bl);
            }
            if (this.currClimateState.climateState == 12) {
                this.getChoiceModel(151855104).setValue(3);
            } else {
                this.getChoiceModel(151855104).setValue(0);
            }
        }
    }

    @Override
    public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        this.getLogChannel().log(1078071040, "updateBatteryControlChargeState: chargeState=%1, validFlag=%2", (Object)batteryControlChargeState, (long)n);
        if (n == 1 && batteryControlChargeState.remainingChargeTime != -65536 && batteryControlChargeState.chargeState == 2) {
            DateMetric dateMetric = new DateMetric(new Date(batteryControlChargeState.remainingChargeTime * 1625948160), 5);
            dateMetric.setUseInstanceUnit(true);
            this.getMetricsModel(-1710481408).setMetric(dateMetric);
            this.getMetricsModel(-1710481408).formatChanged();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Object object = this.mutex;
        synchronized (object) {
            this.getLogChannel().log(1078071040, "updateClampState: clampS=%1, clamp15=%2", bl, bl2);
            if (!bl2) {
                if (this.currentState == 1) {
                    if (this.currBConViewOptions != null && this.currBConViewOptions.getConfiguration() != null) {
                        this.updateMenuEntryVisibility(this.currBConViewOptions);
                        this.requestChargePopup(-1);
                    } else {
                        this.getLogChannel().log(-1601830656, "AbstractGoodbyeComponent::updateAllowParkHeaterMEVisibility Trying to show popup but have VOs=%1", (Object)(this.currBConViewOptions != null ? this.currBConViewOptions.toString() : "null"));
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

    @Override
    public void notifyPowerListenerOnEnterState(int n) {
    }

    @Override
    public void notifyPowerListenerOnExitState(int n) {
    }

    @Override
    public void notifyPowerTriggerAction(int n) {
    }

    public void requestChargePopup(int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "requestChargePopup(%1)", (long)n);
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

    protected abstract void updateMenuEntryVisibility(BatteryControlViewOptions batteryControlViewOptions) {
    }

    public abstract int getPopUpID() {
    }

    protected abstract void updateAuxACImmediateOn(boolean bl) {
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getPowerEventDispatcher().addPowerEventListener(this);
        this.goodbyeTracker = new CarServiceTracker(new AbstractGoodbyeComponent$BCListHandlingTrackerListener(this, this), this.getApplication().getBundleContext(), this.getApplication().getFrameworkAccess().getLogChannel("App.EarlyFunc.Goodbye"));
        this.goodbyeTracker.startTracking();
        this.serviceProvider = new CarServiceProvider((class$de$audi$atip$interapp$IBattCtrlCommunicationService == null ? (class$de$audi$atip$interapp$IBattCtrlCommunicationService = AbstractGoodbyeComponent.class$("de.audi.atip.interapp.IBattCtrlCommunicationService")) : class$de$audi$atip$interapp$IBattCtrlCommunicationService).getName(), this, null, this.getApplication().getBundleContext(), this.getApplication().getFrameworkAccess().getLogChannel("App.EarlyFunc.Goodbye"));
        this.serviceProvider.startService();
    }

    @Override
    public void deinit() {
        this.serviceProvider.stopService();
    }

    @Override
    protected void initModels() {
        this.popupHKTimer = new GoodbyePopupHKTimerController(this.popupHandler, this.getApplication().getFrameworkAccess(), this.getLogChannel());
        this.getChoiceModel(-1995694080).setChoiceListener(this);
        this.getChoiceModel(-1878253568).setChoiceListener(this);
        this.getChoiceModel(-1861476352).setChoiceListener(this);
        this.getChoiceModel(-1978916864).setChoiceListener(this);
        this.getChoiceModel(420290560).setChoiceListener(this);
        this.getChoiceModel(437067776).setChoiceListener(this);
        this.popupHandler.init();
        this.goodbyeMenuHandler = new DefaultMenuModelHandler(this.getMenuModel(-1374937088), this.getLogChannel());
        this.getButtonModel(-1442045952).setButtonListener(this);
        this.getButtonModel(-1425268736).setButtonListener(this);
    }

    @Override
    protected void initBusiness() {
        if (this.networkPlatformInfo.isMLBEvo()) {
            this.goodbyeMenuHandler.setBusiness(new GoodbyeMenuEventBusiness(this.getDSI(), this.getChoiceModel(-1358159872), this.popupHKTimer, this.getLogChannel()));
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
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
        this.getLogChannel().log(1078071040, "dsi.setBatteryControlImmediately(6,%1)", (long)n);
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

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    public int getNextChargeTimerId() {
        boolean bl = false;
        boolean bl2 = false;
        Date date = new Date();
        Date date2 = new Date();
        if (this.getChoiceModel(-1995694080) != null && this.getDateMetric(-1827921920) != null) {
            bl = this.getChoiceModel(-1995694080).getValue() == 1;
            date = this.getDateMetric(-1827921920).getDate();
        }
        if (this.getChoiceModel(-1878253568) != null && this.getDateMetric(-1844699136) != null) {
            bl2 = this.getChoiceModel(-1878253568).getValue() == 1;
            date2 = this.getDateMetric(-1844699136).getDate();
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
        if (this.getChoiceModel(-1861476352) != null && this.getDateMetric(-1962139648) != null) {
            bl = this.getChoiceModel(-1861476352).getValue() == 1;
            date = this.getDateMetric(-1962139648).getDate();
        }
        if (this.getChoiceModel(-1978916864) != null && this.getDateMetric(-1945362432) != null) {
            bl2 = this.getChoiceModel(-1978916864).getValue() == 1;
            date2 = this.getDateMetric(-1945362432).getDate();
        }
        int n = date.before(date2) ? (bl ? 3 : (bl2 ? 4 : 0)) : (bl2 ? 4 : (bl ? 3 : 0));
        return n;
    }

    @Override
    public void updateChargeTimerClimateChoice(int n, int n2) {
        switch (n) {
            case 1: {
                this.getChoiceModel(420290560).setValue(n2);
                break;
            }
            case 2: {
                this.getChoiceModel(437067776).setValue(n2);
                break;
            }
        }
    }

    @Override
    public void updateClimateSystemType(int n, int n2) {
        switch (n) {
            case 1: {
                this.getChoiceModel(420290560).setValue(n2 == 0 ? 1 : (n2 == 1 ? 0 : 2));
                break;
            }
            case 2: {
                this.getChoiceModel(437067776).setValue(n2 == 0 ? 1 : (n2 == 1 ? 0 : 2));
                break;
            }
        }
    }

    @Override
    public void updateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState, int n) {
        this.getLogChannel().log(1078071040, "updateBatteryControlTimerState: timer=%1, validflag=%2", (Object)batteryControlTimerState, (long)n);
        if (n == 1) {
            this.currentTimerState = batteryControlTimerState;
            this.getChoiceModel(-1995694080).setValue(batteryControlTimerState.getProgrammedTimer().isTimer1() ? 1 : 0);
            this.getChoiceModel(-1878253568).setValue(batteryControlTimerState.getProgrammedTimer().isTimer2() ? 1 : 0);
            this.getChoiceModel(-1861476352).setValue(batteryControlTimerState.getProgrammedTimer().isTimer3() ? 1 : 0);
            this.getChoiceModel(-1978916864).setValue(batteryControlTimerState.getProgrammedTimer().isTimer4() ? 1 : 0);
        }
        this.popupHKTimer.resetActivated();
        this.updateMenuEntryVisibility(this.currBConViewOptions);
    }

    @Override
    public void onBatteryControlProfileOperationChanged(int n, BatteryControlProfileOperation batteryControlProfileOperation) {
    }

    @Override
    public void chargeTimerMetricsUpdated(int n) {
        this.updateMenuEntryVisibility(this.currBConViewOptions);
    }

    @Override
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

    static /* synthetic */ IBatteryControlListHandlingService access$002(AbstractGoodbyeComponent abstractGoodbyeComponent, IBatteryControlListHandlingService iBatteryControlListHandlingService) {
        abstractGoodbyeComponent.bcListHandlingService = iBatteryControlListHandlingService;
        return abstractGoodbyeComponent.bcListHandlingService;
    }

    static /* synthetic */ IBatteryControlListHandlingService access$000(AbstractGoodbyeComponent abstractGoodbyeComponent) {
        return abstractGoodbyeComponent.bcListHandlingService;
    }
}

