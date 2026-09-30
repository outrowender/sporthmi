/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.driveassist.AbstractDSICarDriverAssistanceAdapter;
import de.audi.app.car.core.driveassist.SpeedWarningCameraHandler;
import de.audi.atip.hmi.model.ChoiceListener;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;
import org.dsi.ifc.global.CarBCSpeed;

public abstract class AbstractSpeedWarningCameraComponent
extends AbstractDSICarDriverAssistanceAdapter
implements ChoiceListener {
    public static final short CODING_ID = 30;
    private static final String LOGCHANNEL_NAME = "App.Car.SpeedWarning.Camera";
    volatile TSDViewOptions currentViewOptions;
    private final SpeedWarningCameraHandler speedWarningHandler = new SpeedWarningCameraHandler();

    public AbstractSpeedWarningCameraComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getChoiceModel(600750).setChoiceListener(this);
    }

    protected void deinitModels() {
        this.getChoiceModel(600750).resetListener();
    }

    private void setTSDSpeedWarningThreshold(int n) {
        this.getLogChannel().log(1000000, "setTSDSpeedWarningThreshold: combobox-step='%1'", (long)n);
        CarBCSpeed carBCSpeed = new CarBCSpeed();
        carBCSpeed.speedUnit = this.speedWarningHandler.getUnit();
        carBCSpeed.speedValue = this.speedWarningHandler.getValueForStep(n);
        carBCSpeed.speedValueState = this.speedWarningHandler.getValueStateForStep(n);
        boolean bl = this.speedWarningHandler.getStateForStep(n);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "setTSDSpeedWarningThreshold: state='%1', BCSpeed='%2'", bl, (Object)carBCSpeed);
        }
        this.getDSI().setTSDSpeedWarningThreshold(bl, carBCSpeed);
    }

    public void updateTSDViewOptions(TSDViewOptions tSDViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateTSDViewOptions: '%1', valid='%2'", (Object)(tSDViewOptions != null ? this.formatViewOptionsLog(tSDViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && tSDViewOptions != null) {
            this.currentViewOptions = tSDViewOptions;
            this.updateMenuEntryVisibility(tSDViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateTSDSpeedWarningThreshold(boolean bl, CarBCSpeed carBCSpeed, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateTSDSpeedWarningThreshold: state='%1', speed='%2', valid='%3'", (Object)Boolean.toString(bl), (Object)carBCSpeed, (long)n);
        }
        if (n == 1) {
            this.speedWarningHandler.setCurrentValues(bl, carBCSpeed.getSpeedValueState(), carBCSpeed.getSpeedValue(), carBCSpeed.getSpeedUnit());
            this.updateSpeedWarningUnit(carBCSpeed.getSpeedUnit() == 0);
            this.getChoiceModel(600749).setValue(this.speedWarningHandler.unitIsMPH() ? 1 : 0);
            this.getChoiceModel(600750).setValue(this.speedWarningHandler.getStep());
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.getLogChannel().log(1000000, "[AbstractSpeedWarningComponen#itemSelected] model='%1', itemID='%2'", (long)n, (long)n2);
        switch (n) {
            case 600750: {
                this.setTSDSpeedWarningThreshold(n2);
                break;
            }
            default: {
                this.getLogChannel().log(100000, "[AbstractSpeedWarningComponen#itemSelected] unsupported model '%1'", (long)n);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{35}, new int[]{52})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    protected abstract void updateMenuEntryVisibility(TSDViewOptions var1);

    protected abstract void updateSpeedWarningUnit(boolean var1);

    public String getName() {
        return "SpeedWarningCamera";
    }
}

