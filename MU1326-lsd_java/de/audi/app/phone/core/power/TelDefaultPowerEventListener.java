/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.power;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.power.IPowerEventListener;

public class TelDefaultPowerEventListener
extends AbstractPhoneComponent
implements IPowerEventListener {
    public TelDefaultPowerEventListener(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public TelDefaultPowerEventListener(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getPowerEventDispatcher().addPowerEventListener(this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getPowerEventDispatcher().removePowerEventListener(this);
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

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }
}

