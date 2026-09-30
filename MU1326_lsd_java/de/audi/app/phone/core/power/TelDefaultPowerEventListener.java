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

    public void init() {
        super.init();
        this.getApplication().getPowerEventDispatcher().addPowerEventListener(this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getPowerEventDispatcher().removePowerEventListener(this);
    }

    public void notifyPowerListenerOnEnterState(int n) {
    }

    public void notifyPowerListenerOnExitState(int n) {
    }

    public void notifyPowerTriggerAction(int n) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }
}

