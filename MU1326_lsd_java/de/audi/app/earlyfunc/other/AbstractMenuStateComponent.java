/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.other;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.power.IPowerEventListener;
import de.audi.app.car.common.service.AbstractDSICarVehicleStatesAdapter;

public abstract class AbstractMenuStateComponent
extends AbstractDSICarVehicleStatesAdapter
implements IPowerEventListener {
    private static final String LOGCHANNEL_NAME;
    private volatile boolean menusVisible;
    private volatile boolean clamp15on;
    private volatile boolean dsiAvailable;
    private volatile boolean goodbyeVisible;
    private final Object mutex = new Object();

    public AbstractMenuStateComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.EarlyFunc.MenuState");
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
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    protected void initVisibility() {
    }

    @Override
    protected void deinitVisibility() {
    }

    @Override
    public String getName() {
        return "MenuState";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[0];
    }

    @Override
    public String getCurrentViewOptions() {
        return "component does not use view options";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setCarMenusVisible(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            this.menusVisible = bl;
            this.checkState();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setPHEVGoodbyeVisible(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            this.goodbyeVisible = bl;
            this.checkState();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void dsiAvailable(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            this.dsiAvailable = true;
            this.checkState();
        }
    }

    private void checkState() {
        if (this.dsiAvailable) {
            this.getLogChannel().log(-2137614336, "[AbstractMenuStateComponent#checkState] carMenusVisible='%1', clamp15='%2', phevGoodbyeVisible='%3'", this.menusVisible, this.clamp15on, this.goodbyeVisible);
            if (this.menusVisible && this.clamp15on || this.goodbyeVisible) {
                this.getLogChannel().log(1078071040, "dsi.setCarMenuState(true)");
                this.getDSI().setCarMenuState(true);
            } else {
                this.getLogChannel().log(1078071040, "dsi.setCarMenuState(false)");
                this.getDSI().setCarMenuState(false);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Object object = this.mutex;
        synchronized (object) {
            this.clamp15on = bl2;
            this.checkState();
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
}

