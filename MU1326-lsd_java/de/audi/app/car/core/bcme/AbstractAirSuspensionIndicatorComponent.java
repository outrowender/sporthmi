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
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private static final int AIRSUSPENSION_CAR_JACK_MODE_ACTIVE;
    private static final int AIRSUSPENSION_CAR_JACK_MODE_INACTIVE;
    private static final int AIRSUSPENSION_TRAILER_MODE_ACTIVE;
    private static final int AIRSUSPENSION_TRAILER_MODE_INACTIVE;
    private static final int AIRSUSPENSION_LVL_CONTROL_ACTIVE;
    private static final int AIRSUSPENSION_LVL_CONTROL_INACTIVE;
    private static final int OPERATION_MESSAGE_UNLOCKED;
    private static final int OPERATION_MESSAGE_LOCKED;
    private static final int LIFT_NORMAL;
    private static final int LIFT_RAISED;
    protected SuspensionControlViewOptions currViewOptions;
    private int airSuspensionCurrentLevel = 0;
    private int airSuspensionTargetLevel = 0;
    private int airSuspensionVehicleState = 0;

    public AbstractAirSuspensionIndicatorComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Charisma");
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(-1289090816).setChoiceListener(this);
        this.getChoiceModel(-1238759168).setChoiceListener(this);
        this.getChoiceModel(489359616).setChoiceListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(-1289090816).resetListener();
        this.getChoiceModel(-1238759168).resetListener();
        this.getChoiceModel(489359616).resetListener();
    }

    @Override
    public String getName() {
        return "Air Suspension";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{29, 30, 3, 4, 2})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
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
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.getLogChannel().log(1078071040, "[AbstractAirSuspensionIndicatorComponent#itemSelected] modelID='%1', itemID='%2'", (long)n, (long)n2);
        switch (n) {
            case 600755: {
                boolean bl = n2 == 1;
                this.getLogChannel().log(1078071040, "[AbstractAirSuspensionIndicatorComponent#itemSelected] dsi.setSuspensionControlCarJackMode(%1)", bl);
                this.getDSI().setSuspensionControlCarJackMode(bl);
                break;
            }
            case 600758: {
                boolean bl = n2 == 1;
                this.getLogChannel().log(1078071040, "[AbstractAirSuspensionIndicatorComponent#itemSelected] dsi.setSuspensionControlTrailerMode(%1)", bl);
                this.getDSI().setSuspensionControlTrailerMode(bl);
                break;
            }
            case 600861: {
                int n5 = this.getChoiceModel(489359616).getValue();
                boolean bl = n5 == 0;
                this.getLogChannel().log(1078071040, "[AbstractAirSuspensionIndicatorComponent#itemSelected] dsi.setSuspensionControlLiftMode(%1)", bl);
                this.getDSI().setSuspensionControlLiftMode(bl);
                break;
            }
            default: {
                this.getLogChannel().log(-1601830656, "[AbstractAirSuspensionIndicatorComponent#itemSelected] invalid modelID: '%1'", (long)n);
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void setSuspensionCurrentLevelDisplay() {
        this.getLogChannel().log(1078071040, "[AbstractAirSuspensionIndicatorComponent#setSuspensionCurrentLevelDisplay] CurrentLevel = %1, TargetLevel = %2, modelID = %3", (long)this.airSuspensionCurrentLevel, (long)this.airSuspensionTargetLevel, (long)0);
        this.getChoiceModel(-1272313600).setValue(this.airSuspensionCurrentLevel);
    }

    protected void setSuspensionTargetLevelDisplay() {
        this.getLogChannel().log(1078071040, "[AbstractAirSuspensionIndicatorComponent#setSuspensionTargetLevelDisplay] CurrentLevel = %1, TargetLevel = %2, modelID = %3", (long)this.airSuspensionCurrentLevel, (long)this.airSuspensionTargetLevel, (long)0);
        this.getChoiceModel(1730939136).setValue(this.airSuspensionTargetLevel);
    }

    private void updateAirSuspensionActivityState() {
        int n = this.getSuspensionControlActivityState();
        this.getLogChannel().log(1078071040, "[AbstractAirSuspensionIndicatorComponent#updateAirSuspensionActivityState] modelID='%1', state='%2'", (long)0, (long)n);
        this.getChoiceModel(1747716352).setValue(n);
    }

    private int getSuspensionControlActivityState() {
        if (this.airSuspensionTargetLevel != this.airSuspensionCurrentLevel && this.airSuspensionTargetLevel != 0 && this.isAirSuspensionActiveByVehicleState(this.airSuspensionVehicleState)) {
            return 1;
        }
        return 0;
    }

    protected abstract boolean isAirSuspensionActiveByVehicleState(int n) {
    }

    @Override
    public void updateSuspensionControlViewOptions(SuspensionControlViewOptions suspensionControlViewOptions, int n) {
        this.getLogChannel().log(1078071040, "updateSuspensionControlViewOptions: '%1', valid='%2'", (Object)suspensionControlViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = suspensionControlViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
            this.updateAirSuspensionActivityState();
        }
    }

    @Override
    public void updateSuspensionControlCurrentLevel(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractAirSuspensionIndicatorComponent#updateSuspensionControlCurrentLevel] '%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.airSuspensionCurrentLevel = n;
            this.setSuspensionCurrentLevelDisplay();
            this.updateAirSuspensionActivityState();
        }
    }

    @Override
    public void updateSuspensionControlTargetLevel(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractAirSuspensionIndicatorComponent#updateSuspensionControlTargetLevel] '%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.airSuspensionTargetLevel = n;
            this.setSuspensionTargetLevelDisplay();
            this.updateAirSuspensionActivityState();
        }
    }

    @Override
    public void updateSuspensionControlVehicleStatus(int n, int n2) {
        this.getLogChannel().log(1078071040, "[AbstractAirSuspensionIndicatorComponent#updateSuspensionControlVehicleStatus]: status='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.airSuspensionVehicleState = n;
            this.updateAirSuspensionActivityState();
        }
    }

    @Override
    public void updateSuspensionControlCarJackMode(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateSuspensionControlCarJackMode: active='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(-1289090816).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateSuspensionControlTrailerMode(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateSuspensionControlTrailerMode: active='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(-1238759168).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateSuspensionControlOperationMessages(SuspensionControlOperationMessages suspensionControlOperationMessages, int n) {
        this.getLogChannel().log(1078071040, "updateSuspensionControlOperationMessages messages='%1', valid='%2'", (Object)suspensionControlOperationMessages, (long)n);
        if (n == 1) {
            if (suspensionControlOperationMessages.getProcessFinished() == 6) {
                this.getLogChannel().log(1078071040, "[AbstractAirSuspensionIndicatorComponent#updateSuspensionControlOperationMessages] lock airsuspension: processFinished='%1'", (long)suspensionControlOperationMessages.getProcessFinished());
                this.getChoiceModel(-1976760064).setValue(1);
            } else if (suspensionControlOperationMessages.getProcessFinished() == 7) {
                this.getLogChannel().log(1078071040, "[AbstractAirSuspensionIndicatorComponent#updateSuspensionControlOperationMessages] unlock airsuspension: processFinished='%1'", (long)suspensionControlOperationMessages.getProcessFinished());
                this.getChoiceModel(-1976760064).setValue(0);
            }
        }
    }

    @Override
    public void updateSuspensionControlLiftMode(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateSuspensionControlLiftMode active='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(489359616).setValue(bl ? 1 : 0);
        }
    }

    protected abstract void updateMenuEntryVisibility(SuspensionControlViewOptions suspensionControlViewOptions) {
    }
}

