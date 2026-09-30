/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.bcme;

import de.audi.app.car.common.adapter.AbstractDSICarDrivingCharacteristicsAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.atip.hmi.model.ChoiceListener;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlOperationMessages;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;

public abstract class AbstractAirSuspensionIndicatorComponent
extends AbstractDSICarDrivingCharacteristicsAdapter
implements ChoiceListener {
    public static final short CODING_ID = 21;
    private static final String LOGCHANNEL_NAME = "App.Car.Charisma";
    private static final int AIRSUSPENSION_CAR_JACK_MODE_ACTIVE = 1;
    private static final int AIRSUSPENSION_CAR_JACK_MODE_INACTIVE = 0;
    private static final int AIRSUSPENSION_TRAILER_MODE_ACTIVE = 1;
    private static final int AIRSUSPENSION_TRAILER_MODE_INACTIVE = 0;
    private static final int AIRSUSPENSION_LVL_CONTROL_ACTIVE = 1;
    private static final int AIRSUSPENSION_LVL_CONTROL_INACTIVE = 0;
    private static final int OPERATION_MESSAGE_UNLOCKED = 7;
    private static final int OPERATION_MESSAGE_LOCKED = 6;
    private static final int LIFT_NORMAL = 0;
    private static final int LIFT_RAISED = 1;
    protected SuspensionControlViewOptions currViewOptions;
    private int airSuspensionCurrentLevel = 0;
    private int airSuspensionTargetLevel = 0;
    private int airSuspensionVehicleState = 0;

    public AbstractAirSuspensionIndicatorComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getChoiceModel(600755).setChoiceListener(this);
        this.getChoiceModel(600758).setChoiceListener(this);
        this.getChoiceModel(600861).setChoiceListener(this);
    }

    protected void deinitModels() {
        this.getChoiceModel(600755).resetListener();
        this.getChoiceModel(600758).resetListener();
        this.getChoiceModel(600861).resetListener();
    }

    public String getName() {
        return "Air Suspension";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{29, 30, 3, 4, 2})};
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
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
        this.getLogChannel().log(1000000, "[AbstractAirSuspensionIndicatorComponent#itemSelected] modelID='%1', itemID='%2'", (long)n, (long)n2);
        switch (n) {
            case 600755: {
                boolean bl = n2 == 1;
                this.getLogChannel().log(1000000, "[AbstractAirSuspensionIndicatorComponent#itemSelected] dsi.setSuspensionControlCarJackMode(%1)", bl);
                this.getDSI().setSuspensionControlCarJackMode(bl);
                break;
            }
            case 600758: {
                boolean bl = n2 == 1;
                this.getLogChannel().log(1000000, "[AbstractAirSuspensionIndicatorComponent#itemSelected] dsi.setSuspensionControlTrailerMode(%1)", bl);
                this.getDSI().setSuspensionControlTrailerMode(bl);
                break;
            }
            case 600861: {
                int n5 = this.getChoiceModel(600861).getValue();
                boolean bl = n5 == 0;
                this.getLogChannel().log(1000000, "[AbstractAirSuspensionIndicatorComponent#itemSelected] dsi.setSuspensionControlLiftMode(%1)", bl);
                this.getDSI().setSuspensionControlLiftMode(bl);
                break;
            }
            default: {
                this.getLogChannel().log(100000, "[AbstractAirSuspensionIndicatorComponent#itemSelected] invalid modelID: '%1'", (long)n);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void setSuspensionCurrentLevelDisplay() {
        this.getLogChannel().log(1000000, "[AbstractAirSuspensionIndicatorComponent#setSuspensionCurrentLevelDisplay] CurrentLevel = %1, TargetLevel = %2, modelID = %3", (long)this.airSuspensionCurrentLevel, (long)this.airSuspensionTargetLevel, 600756L);
        this.getChoiceModel(600756).setValue(this.airSuspensionCurrentLevel);
    }

    protected void setSuspensionTargetLevelDisplay() {
        this.getLogChannel().log(1000000, "[AbstractAirSuspensionIndicatorComponent#setSuspensionTargetLevelDisplay] CurrentLevel = %1, TargetLevel = %2, modelID = %3", (long)this.airSuspensionCurrentLevel, (long)this.airSuspensionTargetLevel, 601191L);
        this.getChoiceModel(601191).setValue(this.airSuspensionTargetLevel);
    }

    private void updateAirSuspensionActivityState() {
        int n = this.getSuspensionControlActivityState();
        this.getLogChannel().log(1000000, "[AbstractAirSuspensionIndicatorComponent#updateAirSuspensionActivityState] modelID='%1', state='%2'", 601192L, (long)n);
        this.getChoiceModel(601192).setValue(n);
    }

    private int getSuspensionControlActivityState() {
        if (this.airSuspensionTargetLevel != this.airSuspensionCurrentLevel && this.airSuspensionTargetLevel != 0 && this.isAirSuspensionActiveByVehicleState(this.airSuspensionVehicleState)) {
            return 1;
        }
        return 0;
    }

    protected abstract boolean isAirSuspensionActiveByVehicleState(int var1);

    public void updateSuspensionControlViewOptions(SuspensionControlViewOptions suspensionControlViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateSuspensionControlViewOptions: '%1', valid='%2'", (Object)suspensionControlViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = suspensionControlViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
            this.updateAirSuspensionActivityState();
        }
    }

    public void updateSuspensionControlCurrentLevel(int n, int n2) {
        this.getLogChannel().log(1000000, "[AbstractAirSuspensionIndicatorComponent#updateSuspensionControlCurrentLevel] '%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.airSuspensionCurrentLevel = n;
            this.setSuspensionCurrentLevelDisplay();
            this.updateAirSuspensionActivityState();
        }
    }

    public void updateSuspensionControlTargetLevel(int n, int n2) {
        this.getLogChannel().log(1000000, "[AbstractAirSuspensionIndicatorComponent#updateSuspensionControlTargetLevel] '%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.airSuspensionTargetLevel = n;
            this.setSuspensionTargetLevelDisplay();
            this.updateAirSuspensionActivityState();
        }
    }

    public void updateSuspensionControlVehicleStatus(int n, int n2) {
        this.getLogChannel().log(1000000, "[AbstractAirSuspensionIndicatorComponent#updateSuspensionControlVehicleStatus]: status='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.airSuspensionVehicleState = n;
            this.updateAirSuspensionActivityState();
        }
    }

    public void updateSuspensionControlCarJackMode(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateSuspensionControlCarJackMode: active='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600755).setValue(bl ? 1 : 0);
        }
    }

    public void updateSuspensionControlTrailerMode(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateSuspensionControlTrailerMode: active='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600758).setValue(bl ? 1 : 0);
        }
    }

    public void updateSuspensionControlOperationMessages(SuspensionControlOperationMessages suspensionControlOperationMessages, int n) {
        this.getLogChannel().log(1000000, "updateSuspensionControlOperationMessages messages='%1', valid='%2'", (Object)suspensionControlOperationMessages, (long)n);
        if (n == 1) {
            if (suspensionControlOperationMessages.getProcessFinished() == 6) {
                this.getLogChannel().log(1000000, "[AbstractAirSuspensionIndicatorComponent#updateSuspensionControlOperationMessages] lock airsuspension: processFinished='%1'", (long)suspensionControlOperationMessages.getProcessFinished());
                this.getChoiceModel(601482).setValue(1);
            } else if (suspensionControlOperationMessages.getProcessFinished() == 7) {
                this.getLogChannel().log(1000000, "[AbstractAirSuspensionIndicatorComponent#updateSuspensionControlOperationMessages] unlock airsuspension: processFinished='%1'", (long)suspensionControlOperationMessages.getProcessFinished());
                this.getChoiceModel(601482).setValue(0);
            }
        }
    }

    public void updateSuspensionControlLiftMode(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateSuspensionControlLiftMode active='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600861).setValue(bl ? 1 : 0);
        }
    }

    protected abstract void updateMenuEntryVisibility(SuspensionControlViewOptions var1);
}

