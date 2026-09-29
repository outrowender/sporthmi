/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.seat;

import de.audi.app.car.common.ap.IActionProxyListener;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.screenstate.IScreenStateListener;
import de.audi.app.car.core.seat.AbstractSeatComponent;
import java.util.Map;
import org.dsi.ifc.carseat.SeatmemoryConfig;
import org.dsi.ifc.global.CarViewOption;

public class SeatComponentEvo
extends AbstractSeatComponent
implements IActionProxyListener,
IScreenStateListener {
    private final boolean isRgsAvailable;
    private final boolean isPneumatic = this.isComponentAvailable(CODING_ID[1]);
    private volatile boolean coDriverSettingByDriverEntered;

    public SeatComponentEvo(ICarApplication iCarApplication, boolean bl) {
        super(iCarApplication);
        this.isRgsAvailable = bl;
    }

    @Override
    protected void initVisibility() {
        if (this.isSeatConfigurationCoded()) {
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(2049444096, CODING_ID[0]);
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(2066221312, CODING_ID[0]);
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(86509824, CODING_ID[0]);
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(2015889664, CODING_ID[0]);
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(36178176, CODING_ID[0]);
        }
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(19400960, this.getCodingID());
        if (this.isRgsAvailable) {
            this.getApplication().getMenuEntryRegistry().updateSlotBinding(422906880, -1615984128);
        } else {
            this.getApplication().getMenuEntryRegistry().updateSlotBinding(422906880, -1481766400);
        }
    }

    private short getCodingID() {
        return this.isPneumatic ? CODING_ID[1] : CODING_ID[0];
    }

    private boolean isComponentAvailable(short s) {
        return this.getApplication().getCarMenuCoding().isMenuDisplayActivated(s);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(2015889664);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(2049444096);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(2066221312);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(86509824);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(19400960);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(36178176);
    }

    @Override
    protected void updateMenuEntryVisibility() {
        this.selectVariant();
        this.updateCoDriverFromDriverSettingsVisibility();
        if (this.currentViewOptions != null) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2049444096, this.getMenuEntryVisibilityState(new CarViewOption[]{this.currentViewOptions.seatEasyEntryRearLeft, this.currentViewOptions.seatEasyEntryRearRight}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2015889664, this.getMenuEntryVisibilityState(this.currentViewOptions.getSeatRadioKeyAutomatic()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2066221312, this.getMenuEntryVisibilityState(this.currentViewOptions.getSeatCoDriverSettingsFromRear()));
            int n = 1;
            int n2 = 1;
            SeatmemoryConfig seatmemoryConfig = this.currentViewOptions.getSeatmemoryConfig();
            if (seatmemoryConfig != null) {
                int n3 = this.getMenuEntryVisibilityState(this.currentViewOptions.getSeatSpecialPosition());
                if (seatmemoryConfig.normalPosition) {
                    n = n3;
                }
                if (seatmemoryConfig.seatsymmetry) {
                    n2 = n3;
                }
            }
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(86509824, n);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(36178176, n2);
        }
    }

    private void updateCoDriverFromDriverSettingsVisibility() {
        int n = 1;
        int n2 = 1;
        if (this.currentViewOptions != null) {
            n = this.getMenuEntryVisibilityState(this.currentViewOptions.getSeatCoDriverSettingsFromDriver());
        }
        if (this.currentPneumaticViewOptions != null) {
            n2 = this.getMenuEntryVisibilityState(this.currentPneumaticViewOptions.getSeatPneumaticCoDriverSettingsFromDriver());
        }
        if (n == 1 || n2 == 0 || n > 1 && n2 > 1 && n2 < n) {
            this.getLogChannel().log(1078071040, "[SeatComponentEvo#updateCoDriverFromDriverSettingsVisibility] SEAT_CO_DRV_POS according to pneumaticCoDriverFromDriverSettingsVisibility'");
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(19400960, n2);
        } else {
            this.getLogChannel().log(1078071040, "[SeatComponentEvo#updateCoDriverFromDriverSettingsVisibility] SEAT_CO_DRV_POS according to seatCoDriverFromDriverSettingsVisibility'");
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(19400960, n);
        }
    }

    private void selectVariant() {
        String string;
        int n;
        if (this.isVariantHigh()) {
            n = -1615984128;
            string = "HIGH_VARIANT";
        } else {
            n = -1481766400;
            string = "LOW_VARIANT";
        }
        boolean bl = this.getApplication().getMenuEntryRegistry().updateSlotBinding(422906880, n);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[SeatComponentEvo#selectVariant] variant='%1', menu entries of seat driver have been moved = '%2'", (Object)string, (Object)bl);
        }
    }

    private boolean isVariantHigh() {
        boolean bl = this.pneumaticVOsSupportHighVariant();
        boolean bl2 = this.seatVOsSupportHighVariant();
        if (bl || this.isRgsAvailable) {
            return true;
        }
        return bl2;
    }

    private boolean seatVOsSupportHighVariant() {
        if (this.currentViewOptions != null) {
            this.seatCoDriverFromDriver = this.getMenuEntryVisibilityState(this.currentViewOptions.seatCoDriverSettingsFromDriver) == 0;
            return this.currentViewOptions.seatmemoryConfig != null && (this.currentViewOptions.seatmemoryConfig.normalPosition || this.currentViewOptions.seatmemoryConfig.seatsymmetry) && this.getMenuEntryVisibilityState(this.currentViewOptions.getSeatSpecialPosition()) != 1 || this.getMenuEntryVisibilityState(new CarViewOption[]{this.currentViewOptions.seatEasyEntryRearLeft, this.currentViewOptions.seatEasyEntryRearRight}) != 1 || this.getMenuEntryVisibilityState(this.currentViewOptions.getSeatCoDriverSettingsFromRear()) != 1 || this.getMenuEntryVisibilityState(this.currentViewOptions.getSeatCoDriverSettingsFromDriver()) != 1;
        }
        this.seatCoDriverFromDriver = false;
        return false;
    }

    private boolean pneumaticVOsSupportHighVariant() {
        if (this.currentPneumaticViewOptions != null) {
            int n = this.getMenuEntryVisibilityState(this.currentPneumaticViewOptions.getSeatPneumaticCoDriverSettingsFromDriver());
            this.seatPneumaticCoDriverFromDriver = n == 0;
            return n != 1;
        }
        this.seatPneumaticCoDriverFromDriver = false;
        return false;
    }

    @Override
    public int getID() {
        return 32;
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(62, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(63, this);
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(-668530432, this);
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(-400094976, this);
    }

    @Override
    public void deinit() {
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(62, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(63, this);
        this.getApplication().getScreenStateDispatcher().removeScreenStateListener(-668530432, this);
        this.getApplication().getScreenStateDispatcher().removeScreenStateListener(-400094976, this);
        super.deinit();
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[SeatComponentEvo#actionProxyCallPerformed] methodID='%1'", (long)n);
        }
        this.coDriverSettingByDriverEntered = n == 63;
        this.updateMappingSettingsFromDriverToCodriver(this.coDriverSettingByDriverEntered);
    }

    @Override
    public void notifyScreenVisible(int n) {
    }

    @Override
    public void notifyScreenHidden(int n) {
    }

    @Override
    public void notifyScreenConnected(int n) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyScreenFadedOut(int n) {
        Object object = mutex;
        synchronized (object) {
            if (n == -668530432 || n == -400094976) {
                this.stopSeatMovement("notifyScreenFadedOut");
            }
        }
    }

    private boolean isSeatConfigurationCoded() {
        return this.isComponentAvailable(CODING_ID[0]);
    }

    @Override
    protected void initModels() {
        super.initModels();
        this.getButtonModel(-1274273792).setButtonListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getButtonModel(-1274273792).resetListener();
        super.deinitModels();
    }

    @Override
    public void updateSeatCodriverSettingsFromDriver(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "[SeatComponentEvo#updateSeatCodriverSettingsFromDriver] seatCodriverSettingsFromRear='%1', valid='%2'", bl, (long)n);
        if (n == 1 && !bl && this.coDriverSettingByDriverEntered) {
            this.getButtonModel(-1274273792).fireEvent(0);
        }
    }

    @Override
    public void updateSeatPneumaticCodriverSettingsFromDriver(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "[SeatComponentEvo#updateSeatPneumaticCodriverSettingsFromDriver] seatCodriverSettingsFromRear='%1', valid='%2'", bl, (long)n);
        if (n == 1 && !bl && this.coDriverSettingByDriverEntered) {
            this.getButtonModel(-1274273792).fireEvent(0);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        if (n == -1274273792) {
            this.logModelData("[SeatComponentEvo#keyPressed] jump back to CoDriver Menu Screen: ", n, n2, true);
            this.getButtonModel(-1274273792).fireEvent(n3);
        } else {
            super.keyPressed(n, n2, n3);
        }
    }
}

