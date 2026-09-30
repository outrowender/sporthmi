/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.seat;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.power.IPowerEventListener;
import de.audi.app.car.common.seat.AbstractDSICarSeatAdapter;
import de.audi.atip.hmi.drawerfocus.DrawerFocusUtil;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.interapp.phone.ITelState;
import de.audi.atip.interapp.phone.ITelStateListener;
import org.dsi.ifc.carseat.SeatPneumaticViewOptions;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SeatViewOptions;

public abstract class AbstractSeatComponent
extends AbstractDSICarSeatAdapter
implements ChoiceListener,
IPowerEventListener,
ITelStateListener {
    public static final short[] CODING_ID = new short[]{14, 48};
    private static final String LOGCHANNEL_NAME = "App.Car.Seat";
    protected volatile SeatViewOptions currentViewOptions;
    protected volatile SeatPneumaticViewOptions currentPneumaticViewOptions;
    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;
    private boolean easyEntryRearLeftActive;
    private boolean easyEntryRearRightActive;
    protected volatile SeatSpecialPosition currentSeatSpecialPosition = new SeatSpecialPosition();
    private boolean seatMoving;
    private boolean isDriverSideLeft;
    protected boolean seatCoDriverFromDriver;
    protected boolean seatPneumaticCoDriverFromDriver;
    public static final int DRIVER_SIDE_LEFT = 0;
    public static final int DRIVER_SIDE_RIGHT = 1;
    protected static final Object mutex = new Object();
    private volatile boolean moveToSpecialPositionBlocked = false;

    public AbstractSeatComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    public void init() {
        super.init();
        this.getApplication().getPowerEventDispatcher().addPowerEventListener(this);
    }

    public void deinit() {
        this.getApplication().getPowerEventDispatcher().removePowerEventListener(this);
        super.deinit();
    }

    protected void initModels() {
        this.getChoiceModel(600388).setChoiceListener(this);
        this.getChoiceModel(600377).setChoiceListener(this);
        this.getChoiceModel(600387).setChoiceListener(this);
        this.getChoiceModel(602108).setChoiceListener(this);
        this.getButtonModel(600372).setButtonListener(this);
        this.getButtonModel(600384).setButtonListener(this);
        this.getButtonModel(600556).setButtonListener(this);
    }

    protected void deinitModels() {
        this.getChoiceModel(600388).resetListener();
        this.getChoiceModel(600377).resetListener();
        this.getChoiceModel(600387).resetListener();
        this.getChoiceModel(602108).resetListener();
        this.getButtonModel(600372).resetListener();
        this.getButtonModel(600384).resetListener();
        this.getButtonModel(600556).resetListener();
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logModelData("[AbstractSeatComponent#keyPressed]", n, n2, true);
        switch (n) {
            case 600372: {
                this.startCoDriverSymmetryMovement();
                break;
            }
            case 600384: {
                this.startRearNormalPosMovement();
                break;
            }
            case 600556: {
                this.getButtonModel(600556).fireEvent(n3);
                break;
            }
            default: {
                this.logModelData("[AbstractSeatComponent#keyPressed]", n, n2, false);
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
        this.logModelData("[AbstractSeatComponent#keyReleased]", n, n2, true);
        switch (n) {
            case 600372: {
                this.stopCoDriverSymmetryMovement();
                break;
            }
            case 600384: {
                this.stopRearNormalPosMovement();
                break;
            }
            default: {
                this.logModelData("[AbstractSeatComponent#keyReleased]", n, n2, false);
            }
        }
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("[AbstractSeatComponent#itemSelected]", n, n2, true);
        switch (n) {
            case 600388: {
                this.itemSelectedEasyEntryRear(n2 == 1);
                break;
            }
            case 600377: {
                this.itemSelectedDriverRadioKey(n2 == 1);
                break;
            }
            case 600387: {
                this.itemSelectedRearCodriverPosition(n2 == 1);
                break;
            }
            case 602108: {
                if (this.seatMoving && DrawerFocusUtil.isFocusLost(n2)) {
                    Object object = mutex;
                    synchronized (object) {
                        this.stopSeatMovement("itemSelected::isFocusLost");
                        break;
                    }
                }
                if (!this.seatMoving || !DrawerFocusUtil.isPartialPopupShown(n2)) break;
                Object object = mutex;
                synchronized (object) {
                    this.stopSeatMovement("itemSelected::isPartialPopupShown");
                    break;
                }
            }
            default: {
                this.logModelData("[AbstractSeatComponent#itemSelected]", n, n2, false);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void itemSelectedEasyEntryRear(boolean bl) {
        this.getLogChannel().log(1000000, "[AbstractSeatComponent#itemSelectedEasyEntryRear] dsi.setSeatEasyEntryRearLeft/Right: state=%1", bl);
        this.getDSI().setSeatEasyEntryRearLeft(bl);
        this.getDSI().setSeatEasyEntryRearRight(bl);
    }

    private void itemSelectedDriverRadioKey(boolean bl) {
        this.getLogChannel().log(1000000, "[AbstractSeatComponent#itemSelectedDriverRadioKey] dsi.setSeatRadioKeyAutomatic: state=%1", bl);
        this.getDSI().setSeatRadioKeyAutomatic(bl);
    }

    private void itemSelectedRearCodriverPosition(boolean bl) {
        this.getLogChannel().log(1000000, "[AbstractSeatComponent#itemSelectedRearCodriverPosition] dsi.setSeatCodriverSettingsFromRear: state=%1", bl);
        this.getDSI().setSeatCodriverSettingsFromRear(bl);
    }

    private void applyActivityStateToModel(int n, boolean bl) {
        this.getChoiceModel(n).setValue(bl ? 1 : 0);
    }

    private void updateEasyEntryRear() {
        this.applyActivityStateToModel(600388, this.easyEntryRearRightActive && this.easyEntryRearLeftActive);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void startCoDriverSymmetryMovement() {
        Object object = mutex;
        synchronized (object) {
            if (!this.seatMoving || this.currentSeatSpecialPosition.position == 0) {
                this.currentSeatSpecialPosition.position = 2;
                this.currentSeatSpecialPosition.seat1RL = !this.isDriverSideLeft;
                this.currentSeatSpecialPosition.seat1RR = this.isDriverSideLeft;
            }
            this.startSeatMovement("startCoDriverSymmetryMovement");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void startRearNormalPosMovement() {
        Object object = mutex;
        synchronized (object) {
            if (!this.seatMoving || this.currentSeatSpecialPosition.position == 0) {
                this.currentSeatSpecialPosition.position = 3;
                this.currentSeatSpecialPosition.seat1RL = !this.isDriverSideLeft;
                this.currentSeatSpecialPosition.seat1RR = this.isDriverSideLeft;
                this.currentSeatSpecialPosition.seat2RR = true;
                this.currentSeatSpecialPosition.seat2RL = true;
            }
            this.startSeatMovement("startRearNormalPosMovement");
        }
    }

    private void startSeatMovement(String string) {
        if (this.moveToSpecialPositionBlocked) {
            this.getLogChannel().log(1000000, "[AbstractSeatComponent#startSeatMovement] (called by %1) dsi.setSeatSpecialPosition call is blocked because clamp15 is OFF", (Object)string);
            return;
        }
        if (this.getLogChannel().isInfo() || !this.seatMoving) {
            this.getLogChannel().log(1000000, "[AbstractSeatComponent#startSeatMovement] (called by %1) dsi.setSeatSpecialPosition : seatSpecialPosition=%2", (Object)string, (Object)this.currentSeatSpecialPosition);
        }
        this.getDSI().setSeatSpecialPosition(this.currentSeatSpecialPosition);
        this.seatMoving = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void stopCoDriverSymmetryMovement() {
        Object object = mutex;
        synchronized (object) {
            this.stopSeatMovement("stopCoDriverSymmetryMovement");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void stopRearNormalPosMovement() {
        Object object = mutex;
        synchronized (object) {
            this.stopSeatMovement("stopRearNormalPosMovement");
        }
    }

    protected void stopSeatMovement(String string) {
        if (this.seatMoving) {
            SeatSpecialPosition seatSpecialPosition = new SeatSpecialPosition();
            this.getLogChannel().log(1000000, "[AbstractSeatComponent#stopSeatMovement] (called by '%1') dsi.setSeatSpecialPosition:  seatSpecialPosition=%2", (Object)string, (Object)seatSpecialPosition);
            this.getDSI().setSeatSpecialPosition(seatSpecialPosition);
            this.seatMoving = false;
        } else {
            this.getLogChannel().log(10000000, "[AbstractSeatComponent#stopSeatMovement] (called by '%1') seat already stopped", (Object)string);
        }
    }

    protected void updateMappingSettingsFromDriverToCodriver(boolean bl) {
        if (this.seatCoDriverFromDriver) {
            this.getDSI().setSeatCodriverSettingsFromDriver(bl);
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[AbstractSeatComponent#startMappingSettingsFromDriverToCodriver] dsi.setSeatCodriverSettingsFromDriver:  state='%1'", (Object)bl);
            }
        }
        if (this.seatPneumaticCoDriverFromDriver) {
            this.getDSI().setSeatPneumaticCodriverSettingsFromDriver(bl);
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[AbstractSeatComponent#startMappingSettingsFromDriverToCodriver] dsi.setSeatPneumaticCodriverSettingsFromDriver:  state='%1'", (Object)bl);
            }
        }
    }

    private void setDriverSide() {
        this.getChoiceModel(600381).setValue(this.isDriverSideLeft ? 0 : 1);
    }

    public void updateSeatViewOptions(SeatViewOptions seatViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractSeatComponent#updateSeatViewOptions] viewOptions='%1', valid='%2'", (Object)(seatViewOptions != null ? this.formatViewOptionsLog(seatViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && seatViewOptions != null) {
            this.currentViewOptions = seatViewOptions;
            this.updateMenuEntryVisibility();
            this.isDriverSideLeft = this.currentViewOptions.seatmemoryConfig.driversideLeft;
            this.setDriverSide();
            this.primaryAttributeReceived(0, 1);
            this.primaryAttributeReceived(0, 23);
        }
    }

    public void updateSeatPneumaticViewOptions(SeatPneumaticViewOptions seatPneumaticViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractSeatComponent#updateSeatPneumaticViewOptions] viewOptions='%1', valid='%2'", (Object)(seatPneumaticViewOptions != null ? this.formatViewOptionsLog(seatPneumaticViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && seatPneumaticViewOptions != null) {
            this.currentPneumaticViewOptions = seatPneumaticViewOptions;
            this.updateMenuEntryVisibility();
            this.isDriverSideLeft = this.currentPneumaticViewOptions.seatPneumaticConfig.driversideLeft;
            this.setDriverSide();
            this.primaryAttributeReceived(0, 23);
            this.primaryAttributeReceived(0, 1);
        }
    }

    public void updateSeatRadioKeyAutomatic(boolean bl, int n) {
        this.getLogChannel().log(1000000, "[AbstractSeatComponent#updateSeatRadioKeyAutomatic] seatRadioKeyAutomatic='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.applyActivityStateToModel(600377, bl);
        }
    }

    public void updateSeatEasyEntryRearLeft(boolean bl, int n) {
        this.getLogChannel().log(1000000, "[AbstractSeatComponent#updateSeatEasyEntryRearLeft] seatEasyEntryRearLeft='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.easyEntryRearLeftActive = bl;
            this.updateEasyEntryRear();
        }
    }

    public void updateSeatEasyEntryRearRight(boolean bl, int n) {
        this.getLogChannel().log(1000000, "[AbstractSeatComponent#updateSeatEasyEntryRearRight] seatEasyEntryRearRight='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.easyEntryRearRightActive = bl;
            this.updateEasyEntryRear();
        }
    }

    public void updateSeatCodriverSettingsFromRear(boolean bl, int n) {
        this.getLogChannel().log(1000000, "[AbstractSeatComponent#updateSeatCodriverSettingsFromRear] seatCodriverSettingsFromRear='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.applyActivityStateToModel(600387, bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateSeatSpecialPosition(SeatSpecialPosition seatSpecialPosition, int n) {
        this.getLogChannel().log(1000000, "[AbstractSeatComponent#updateSeatSpecialPosition] seatSpecialPosition='%1', valid='%2'", (Object)seatSpecialPosition, (long)n);
        if (n == 1) {
            Object object = mutex;
            synchronized (object) {
                this.currentSeatSpecialPosition = seatSpecialPosition;
            }
        }
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1, 23}, new int[]{2, 21, 22, 3, 7, 6, 24})};
    }

    protected abstract void updateMenuEntryVisibility();

    public String getCurrentViewOptions() {
        if (this.seatPneumaticCoDriverFromDriver) {
            return this.getCurrentSeatPneumaticViewOptions();
        }
        return this.getCurrentSeatViewOptions();
    }

    private String getCurrentSeatPneumaticViewOptions() {
        if (this.currentPneumaticViewOptions == null) {
            return "no pneumatic view options received yet";
        }
        return this.currentPneumaticViewOptions.toString();
    }

    private String getCurrentSeatViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    public String getName() {
        return "Car Seat Settings";
    }

    public void notifyPowerListenerOnEnterState(int n) {
    }

    public void notifyPowerListenerOnExitState(int n) {
    }

    public void notifyPowerTriggerAction(int n) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Object object = mutex;
        synchronized (object) {
            this.getLogChannel().log(1000000, "[AbstractSeatComponent#updateClampState] clamp15='%1' , seatMoving='%2'", bl2, this.seatMoving);
            boolean bl5 = this.moveToSpecialPositionBlocked = !bl2;
            if (this.moveToSpecialPositionBlocked) {
                this.stopSeatMovement("updateClampState");
            }
        }
    }

    public void updateTelState(int n, ITelState iTelState) {
        if (iTelState.isIncomingCallPresent()) {
            this.stopCoDriverSymmetryMovement();
        }
    }
}

