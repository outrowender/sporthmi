/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.power;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.power.IPowerEventListener;

public class EcallPowerHandler
extends AbstractEcallComponent
implements IPowerEventListener {
    protected volatile int currentHMIPowerState;
    private final int ACTIVATE_ACTION;
    private final int INACTIVATE_ACTION;

    public EcallPowerHandler(IEcallApplication iEcallApplication, int n, int n2) {
        super(iEcallApplication, "App.Ecall.Main");
        this.ACTIVATE_ACTION = n;
        this.INACTIVATE_ACTION = n2;
    }

    public void init() {
        this.getApplication().getPowerEventDispatcher().addPowerEventListener(this);
    }

    public void deinit() {
        this.getApplication().getPowerEventDispatcher().removePowerEventListener(this);
    }

    public void notifyPowerListenerOnEnterState(int n) {
        this.currentHMIPowerState = n;
    }

    public void notifyPowerListenerOnExitState(int n) {
    }

    public void notifyPowerTriggerAction(int n) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    public void activatePowerState() {
        this.log.log(1000000, "EcallPowerHandler#activatePowerState(): activate action: %1, currentHMIPowerState %2", (long)this.ACTIVATE_ACTION, (long)this.currentHMIPowerState);
        this.getFrameworkAccess().getPowerMgr().setExtendedPowerState(this.ACTIVATE_ACTION, 0);
    }

    public void disactivatePowerState() {
        this.log.log(1000000, "EcallPowerHandler#disactivatePowerState(): inactivate action %1", (long)this.INACTIVATE_ACTION);
        this.getFrameworkAccess().getPowerMgr().setExtendedPowerState(this.INACTIVATE_ACTION, 0);
    }
}

