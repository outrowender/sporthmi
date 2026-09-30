/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.kombi;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.mer.IMenuEntry;
import de.audi.app.car.common.screenstate.IScreenStateListener;
import de.audi.app.car.core.kombi.AbstractSpeedWarningManualComponent;
import org.dsi.ifc.carkombi.BCTankLevel;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.global.CarBCDistance;

public class SpeedWarningManualComponentEvo
extends AbstractSpeedWarningManualComponent
implements IScreenStateListener {
    private IMenuEntry speedWarningManualEntry;

    public SpeedWarningManualComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    public void init() {
        super.init();
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(600007, this);
    }

    public void deinit() {
        this.getApplication().getScreenStateDispatcher().removeScreenStateListener(600007, this);
        super.deinit();
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(270, (short)10);
        this.speedWarningManualEntry = this.getApplication().getMenuEntryRegistry().registerMenuEntry(600100, (short)10);
        this.getApplication().getMenuEntryRegistry().updateSlotBinding(56, 55);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600100);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(270);
    }

    protected void updateMenuEntryVisibility(BCViewOptions bCViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600100, this.getMenuEntryVisibilityState(bCViewOptions.getSpeedWarning()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(270, this.getMenuEntryVisibilityState(bCViewOptions.getLifeTipsDisplay()));
    }

    public int getID() {
        return 23;
    }

    public void notifyScreenVisible(int n) {
    }

    public void notifyScreenHidden(int n) {
    }

    public void notifyScreenConnected(int n) {
        this.getLogChannel().log(1000000, "[SpeedWarningManualComponentEvo#notifyScreenConnected] screen='%1'", (long)n);
        if (n == 600007) {
            this.resetSpeedSetting();
        }
    }

    public void notifyScreenFadedOut(int n) {
        this.getLogChannel().log(1000000, "[SpeedWarningManualComponentEvo#notifiyScreenFadedOut] screen='%1'", (long)n);
        if (n == 600007) {
            if (this.speedWarningManualEntry.getState() == 0) {
                this.saveCurrentSpeedSetting();
            } else {
                this.getLogChannel().log(10000000, "[SpeedWarningManualComponentEvo#notifyScreenFadedOut] menu entry not functional");
                this.resetSpeedSetting();
            }
        }
    }

    public void updateBCTotalDistance(CarBCDistance carBCDistance, int n) {
    }

    public void updateBCTankLevel1(BCTankLevel bCTankLevel, int n) {
    }

    public void updateBCTankLevel2(BCTankLevel bCTankLevel, int n) {
    }
}

