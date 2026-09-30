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
    private static final String LOGCHANNEL_NAME = "App.EarlyFunc.MenuState";
    private volatile boolean menusVisible;
    private volatile boolean clamp15on;
    private volatile boolean dsiAvailable;
    private volatile boolean goodbyeVisible;
    private final Object mutex = new Object();

    public AbstractMenuStateComponent(ICarApplication iCarApplication) {
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
    }

    protected void deinitModels() {
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }

    public String getName() {
        return "MenuState";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[0];
    }

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
    protected void dsiAvailable(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            this.dsiAvailable = true;
            this.checkState();
        }
    }

    private void checkState() {
        if (this.dsiAvailable) {
            this.getLogChannel().log(10000000, "[AbstractMenuStateComponent#checkState] carMenusVisible='%1', clamp15='%2', phevGoodbyeVisible='%3'", this.menusVisible, this.clamp15on, this.goodbyeVisible);
            if (this.menusVisible && this.clamp15on || this.goodbyeVisible) {
                this.getLogChannel().log(1000000, "dsi.setCarMenuState(true)");
                this.getDSI().setCarMenuState(true);
            } else {
                this.getLogChannel().log(1000000, "dsi.setCarMenuState(false)");
                this.getDSI().setCarMenuState(false);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Object object = this.mutex;
        synchronized (object) {
            this.clamp15on = bl2;
            this.checkState();
        }
    }

    public void notifyPowerListenerOnEnterState(int n) {
    }

    public void notifyPowerListenerOnExitState(int n) {
    }

    public void notifyPowerTriggerAction(int n) {
    }
}

