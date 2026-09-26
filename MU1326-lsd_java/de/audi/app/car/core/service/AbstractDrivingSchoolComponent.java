/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.service;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.AbstractDSICarVehicleStatesAdapter;
import de.audi.app.car.core.service.AbstractDrivingSchoolComponent$DrvSchoolEventObserverNullFilter;
import de.audi.app.car.core.service.IDrivingSchoolDisplay;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.metrics.Speed;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarBCSpeed;
import org.dsi.ifc.global.CarViewOption;

public abstract class AbstractDrivingSchoolComponent
extends AbstractDSICarVehicleStatesAdapter
implements ChoiceListener,
IDrivingSchoolDisplay,
TimerListener {
    private static final String LOGCHANNEL_NAME;
    private static final String[] BLINKING_STATE_LOG;
    protected volatile CarViewOption currViewOptionSystem;
    protected volatile CarViewOption currViewOptionBlinker;
    protected volatile CarViewOption currViewOptionSpeed;
    protected volatile Timer timer = new Timer("DrvSchoolTimer", 5, this.getLogChannel(), this, 0, true);
    private static final int TIMER_DELAY;
    protected volatile boolean drvSchoolMode;

    public AbstractDrivingSchoolComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.DrvSchool");
    }

    @Override
    public void init() {
        super.init();
        this.handleDriveSchoolMode(this.getApplication().getFrameworkAccess().getStorageMgr().getBoolean(1006, 40, false) ? 1 : 0);
        AbstractDrivingSchoolComponent$DrvSchoolEventObserverNullFilter abstractDrivingSchoolComponent$DrvSchoolEventObserverNullFilter = new AbstractDrivingSchoolComponent$DrvSchoolEventObserverNullFilter(this);
        this.getApplication().getFrameworkAccess().getHMIService().getEventDispatcherAdmin().addEventFilter(abstractDrivingSchoolComponent$DrvSchoolEventObserverNullFilter);
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{11}, new int[0]), new CarDSIAttributesSet(1, new int[]{12}, new int[]{14}), new CarDSIAttributesSet(2, new int[]{13}, new int[]{15})};
    }

    @Override
    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append("DrvSchoolSystem: ").append(this.currViewOptionSystem).append('\n');
        buffer.append("Blinker: ").append(this.currViewOptionBlinker).append('\n');
        buffer.append("Speed: ").append(this.currViewOptionSpeed).append('\n');
        return buffer.toString();
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(942344448).setChoiceListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(942344448).resetListener();
    }

    @Override
    public void updateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
        if (n == 1) {
            this.getLogChannel().log(1078071040, "updateVehicleInfoViewOptions(%1)", (Object)vehicleInfoViewOptions);
            this.currViewOptionSystem = vehicleInfoViewOptions.getDrvSchoolSystem();
            this.updateMenuEntryVisibilitySystem(this.currViewOptionSystem);
            this.primaryAttributeReceived(0, 11);
        }
    }

    @Override
    public void updateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions, int n) {
        if (n == 1) {
            this.currViewOptionBlinker = dynamicVehicleInfoMidFrequentViewOptions.getBlinkingState();
            this.getLogChannel().log(1078071040, "updateDynamicVehicleInfoMidFrequentViewOptions( blinkingState: %1) ", (Object)dynamicVehicleInfoMidFrequentViewOptions.getBlinkingState());
            this.updateMenuEntryVisibilityBlinker(this.currViewOptionBlinker);
            this.primaryAttributeReceived(2, 13);
        }
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
        if (n == 1) {
            this.currViewOptionSpeed = dynamicVehicleInfoHighFrequentViewOptions.getVehicleSpeed();
            this.getLogChannel().log(1078071040, "updateDynamicVehicleInfoHighFrequentViewOptions(vehicleSpeed: %1)", (Object)this.currViewOptionSpeed);
            this.updateMenuEntryVisibilitySpeed(this.currViewOptionSpeed);
            this.primaryAttributeReceived(1, 12);
        }
    }

    @Override
    public void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
        if (n == 1) {
            int n2 = dynamicVehicleInfoMidFrequent.getBlinkingState();
            this.getLogChannel().log(1078071040, "updateDynamicVehicleInfoMidFrequent(%2) state: %1", (Object)BLINKING_STATE_LOG[n2], (long)n2);
            this.getChoiceModel(908790016).setValue(n2);
        }
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        if (n == 1) {
            int n2 = dynamicVehicleInfoHighFrequent.getEngineSpeed();
            this.getLogChannel().log(1078071040, "updateDynamicVehicleInfoHighFrequent(%1)", (long)n2);
            CarBCSpeed carBCSpeed = dynamicVehicleInfoHighFrequent.getVehicleSpeed();
            int n3 = carBCSpeed.getSpeedUnit() == 0 ? 1 : 2;
            Speed speed = new Speed(carBCSpeed.getSpeedValue(), n3);
            speed.setUseInstanceUnit(true);
            this.getMetricsModel(975898880).setMetric(speed);
        }
    }

    protected abstract void updateMenuEntryVisibilitySystem(CarViewOption carViewOption) {
    }

    protected abstract void updateMenuEntryVisibilityBlinker(CarViewOption carViewOption) {
    }

    protected abstract void updateMenuEntryVisibilitySpeed(CarViewOption carViewOption) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected:", n, n2, true);
        switch (n) {
            case 600888: {
                this.handleDriveSchoolMode(n2);
                break;
            }
            default: {
                this.logModelData("itemSelected:", n, n2, false);
            }
        }
    }

    public synchronized void handleDriveSchoolMode(int n) {
        this.drvSchoolMode = n == 1;
        this.getApplication().getFrameworkAccess().getStorageMgr().setBoolean(1006, 40, this.drvSchoolMode);
        this.getLogChannel().log(-2137614336, "handleDriveSchoolMode itemID %2 --> %1", this.drvSchoolMode, (long)n);
        this.getChoiceModel(942344448).setValue(n);
        if (this.drvSchoolMode) {
            this.timer.restart();
        } else {
            this.timer.cancel();
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
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

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public String getName() {
        return "Driving School Mode";
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void fireTimer(Timer timer) {
        this.activateDisplay();
    }

    static /* synthetic */ ICarApplication access$000(AbstractDrivingSchoolComponent abstractDrivingSchoolComponent) {
        return abstractDrivingSchoolComponent.getApplication();
    }

    static {
        BLINKING_STATE_LOG = new String[]{"BLINKINGSTATE_NOBLINKING", "BLINKINGSTATE_LEFTBLINKING", "BLINKINGSTATE_RIGHTBLINKING", "BLINKINGSTATE_LEFTRIGHTBLINKING"};
    }
}

