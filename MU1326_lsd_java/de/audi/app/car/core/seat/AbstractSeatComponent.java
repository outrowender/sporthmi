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
    private static final String LOGCHANNEL_NAME;
    protected volatile SeatViewOptions currentViewOptions;
    protected volatile SeatPneumaticViewOptions currentPneumaticViewOptions;
    public static final int ACTIVE;
    public static final int INACTIVE;
    private boolean easyEntryRearLeftActive;
    private boolean easyEntryRearRightActive;
    protected volatile SeatSpecialPosition currentSeatSpecialPosition = new SeatSpecialPosition();
    private boolean seatMoving;
    private boolean isDriverSideLeft;
    protected boolean seatCoDriverFromDriver;
    protected boolean seatPneumaticCoDriverFromDriver;
    public static final int DRIVER_SIDE_LEFT;
    public static final int DRIVER_SIDE_RIGHT;
    protected static final Object mutex;
    private volatile boolean moveToSpecialPositionBlocked = false;

    public AbstractSeatComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Seat");
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getPowerEventDispatcher().addPowerEventListener(this);
    }

    @Override
    public void deinit() {
        this.getApplication().getPowerEventDispatcher().removePowerEventListener(this);
        super.deinit();
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(1143539968).setChoiceListener(this);
        this.getChoiceModel(958990592).setChoiceListener(this);
        this.getChoiceModel(1126762752).setChoiceListener(this);
        this.getChoiceModel(-64026368).setChoiceListener(this);
        this.getButtonModel(875104512).setButtonListener(this);
        this.getButtonModel(1076431104).setButtonListener(this);
        this.getButtonModel(-332855040).setButtonListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(1143539968).resetListener();
        this.getChoiceModel(958990592).resetListener();
        this.getChoiceModel(1126762752).resetListener();
        this.getChoiceModel(-64026368).resetListener();
        this.getButtonModel(875104512).resetListener();
        this.getButtonModel(1076431104).resetListener();
        this.getButtonModel(-332855040).resetListener();
    }

    @Override
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
                this.getButtonModel(-332855040).fireEvent(n3);
                break;
            }
            default: {
                this.logModelData("[AbstractSeatComponent#keyPressed]", n, n2, false);
            }
        }
    }

    @Override
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

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
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

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void itemSelectedEasyEntryRear(boolean bl) {
        this.getLogChannel().log(1078071040, "[AbstractSeatComponent#itemSelectedEasyEntryRear] dsi.setSeatEasyEntryRearLeft/Right: state=%1", bl);
        this.getDSI().setSeatEasyEntryRearLeft(bl);
        this.getDSI().setSeatEasyEntryRearRight(bl);
    }

    private void itemSelectedDriverRadioKey(boolean bl) {
        this.getLogChannel().log(1078071040, "[AbstractSeatComponent#itemSelectedDriverRadioKey] dsi.setSeatRadioKeyAutomatic: state=%1", bl);
        this.getDSI().setSeatRadioKeyAutomatic(bl);
    }

    private void itemSelectedRearCodriverPosition(boolean bl) {
        this.getLogChannel().log(1078071040, "[AbstractSeatComponent#itemSelectedRearCodriverPosition] dsi.setSeatCodriverSettingsFromRear: state=%1", bl);
        this.getDSI().setSeatCodriverSettingsFromRear(bl);
    }

    private void applyActivityStateToModel(int n, boolean bl) {
        this.getChoiceModel(n).setValue(bl ? 1 : 0);
    }

    private void updateEasyEntryRear() {
        this.applyActivityStateToModel(1143539968, this.easyEntryRearRightActive && this.easyEntryRearLeftActive);
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
            this.getLogChannel().log(1078071040, "[AbstractSeatComponent#startSeatMovement] (called by %1) dsi.setSeatSpecialPosition call is blocked because clamp15 is OFF", (Object)string);
            return;
        }
        if (this.getLogChannel().isInfo() || !this.seatMoving) {
            this.getLogChannel().log(1078071040, "[AbstractSeatComponent#startSeatMovement] (called by %1) dsi.setSeatSpecialPosition : seatSpecialPosition=%2", (Object)string, (Object)this.currentSeatSpecialPosition);
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
            this.getLogChannel().log(1078071040, "[AbstractSeatComponent#stopSeatMovement] (called by '%1') dsi.setSeatSpecialPosition:  seatSpecialPosition=%2", (Object)string, (Object)seatSpecialPosition);
            this.getDSI().setSeatSpecialPosition(seatSpecialPosition);
            this.seatMoving = false;
        } else {
            this.getLogChannel().log(-2137614336, "[AbstractSeatComponent#stopSeatMovement] (called by '%1') seat already stopped", (Object)string);
        }
    }

    protected void updateMappingSettingsFromDriverToCodriver(boolean bl) {
        if (this.seatCoDriverFromDriver) {
            this.getDSI().setSeatCodriverSettingsFromDriver(bl);
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[AbstractSeatComponent#startMappingSettingsFromDriverToCodriver] dsi.setSeatCodriverSettingsFromDriver:  state='%1'", (Object)bl);
            }
        }
        if (this.seatPneumaticCoDriverFromDriver) {
            this.getDSI().setSeatPneumaticCodriverSettingsFromDriver(bl);
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[AbstractSeatComponent#startMappingSettingsFromDriverToCodriver] dsi.setSeatPneumaticCodriverSettingsFromDriver:  state='%1'", (Object)bl);
            }
        }
    }

    private void setDriverSide() {
        this.getChoiceModel(1026099456).setValue(this.isDriverSideLeft ? 0 : 1);
    }

    @Override
    public void updateSeatViewOptions(SeatViewOptions seatViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatComponent#updateSeatViewOptions] viewOptions='%1', valid='%2'", (Object)(seatViewOptions != null ? this.formatViewOptionsLog(seatViewOptions.toString()) : "null"), (long)n);
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

    @Override
    public void updateSeatPneumaticViewOptions(SeatPneumaticViewOptions seatPneumaticViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSeatComponent#updateSeatPneumaticViewOptions] viewOptions='%1', valid='%2'", (Object)(seatPneumaticViewOptions != null ? this.formatViewOptionsLog(seatPneumaticViewOptions.toString()) : "null"), (long)n);
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

    @Override
    public void updateSeatRadioKeyAutomatic(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "[AbstractSeatComponent#updateSeatRadioKeyAutomatic] seatRadioKeyAutomatic='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.applyActivityStateToModel(958990592, bl);
        }
    }

    @Override
    public void updateSeatEasyEntryRearLeft(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "[AbstractSeatComponent#updateSeatEasyEntryRearLeft] seatEasyEntryRearLeft='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.easyEntryRearLeftActive = bl;
            this.updateEasyEntryRear();
        }
    }

    @Override
    public void updateSeatEasyEntryRearRight(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "[AbstractSeatComponent#updateSeatEasyEntryRearRight] seatEasyEntryRearRight='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.easyEntryRearRightActive = bl;
            this.updateEasyEntryRear();
        }
    }

    @Override
    public void updateSeatCodriverSettingsFromRear(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "[AbstractSeatComponent#updateSeatCodriverSettingsFromRear] seatCodriverSettingsFromRear='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.applyActivityStateToModel(1126762752, bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateSeatSpecialPosition(SeatSpecialPosition seatSpecialPosition, int n) {
        this.getLogChannel().log(1078071040, "[AbstractSeatComponent#updateSeatSpecialPosition] seatSpecialPosition='%1', valid='%2'", (Object)seatSpecialPosition, (long)n);
        if (n == 1) {
            Object object = mutex;
            synchronized (object) {
                this.currentSeatSpecialPosition = seatSpecialPosition;
            }
        }
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1, 23}, new int[]{2, 21, 22, 3, 7, 6, 24})};
    }

    protected abstract void updateMenuEntryVisibility() {
    }

    @Override
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

    @Override
    public String getName() {
        return "Car Seat Settings";
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Object object = mutex;
        synchronized (object) {
            this.getLogChannel().log(1078071040, "[AbstractSeatComponent#updateClampState] clamp15='%1' , seatMoving='%2'", bl2, this.seatMoving);
            boolean bl5 = this.moveToSpecialPositionBlocked = !bl2;
            if (this.moveToSpecialPositionBlocked) {
                this.stopSeatMovement("updateClampState");
            }
        }
    }

    @Override
    public void updateTelState(int n, ITelState iTelState) {
        if (iTelState.isIncomingCallPresent()) {
            this.stopCoDriverSymmetryMovement();
        }
    }

    static {
        mutex = new Object();
    }
}

