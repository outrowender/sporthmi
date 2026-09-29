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

    @Override
    public void init() {
        super.init();
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(-953743104, this);
    }

    @Override
    public void deinit() {
        this.getApplication().getScreenStateDispatcher().removeScreenStateListener(-953743104, this);
        super.deinit();
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(270, (short)10);
        this.speedWarningManualEntry = this.getApplication().getMenuEntryRegistry().registerMenuEntry(606603520, (short)10);
        this.getApplication().getMenuEntryRegistry().updateSlotBinding(56, 55);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(606603520);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(270);
    }

    @Override
    protected void updateMenuEntryVisibility(BCViewOptions bCViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(606603520, this.getMenuEntryVisibilityState(bCViewOptions.getSpeedWarning()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(270, this.getMenuEntryVisibilityState(bCViewOptions.getLifeTipsDisplay()));
    }

    @Override
    public int getID() {
        return 23;
    }

    @Override
    public void notifyScreenVisible(int n) {
    }

    @Override
    public void notifyScreenHidden(int n) {
    }

    @Override
    public void notifyScreenConnected(int n) {
        this.getLogChannel().log(1078071040, "[SpeedWarningManualComponentEvo#notifyScreenConnected] screen='%1'", (long)n);
        if (n == -953743104) {
            this.resetSpeedSetting();
        }
    }

    @Override
    public void notifyScreenFadedOut(int n) {
        this.getLogChannel().log(1078071040, "[SpeedWarningManualComponentEvo#notifiyScreenFadedOut] screen='%1'", (long)n);
        if (n == -953743104) {
            if (this.speedWarningManualEntry.getState() == 0) {
                this.saveCurrentSpeedSetting();
            } else {
                this.getLogChannel().log(-2137614336, "[SpeedWarningManualComponentEvo#notifyScreenFadedOut] menu entry not functional");
                this.resetSpeedSetting();
            }
        }
    }

    @Override
    public void updateBCTotalDistance(CarBCDistance carBCDistance, int n) {
    }

    @Override
    public void updateBCTankLevel1(BCTankLevel bCTankLevel, int n) {
    }

    @Override
    public void updateBCTankLevel2(BCTankLevel bCTankLevel, int n) {
    }
}

