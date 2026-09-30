/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.core.common;

import de.audi.app.connectivity.core.common.IClampStateProvider;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;

public class ClampStateHandler
implements PowerEventListener,
IClampStateProvider {
    private static final int CLAMP_OFF = 0;
    private static final int CLAMP_ON = 1;
    private final LogChannel log;
    private final ChoiceModelApp model;
    private volatile boolean isClampS_On;

    public ClampStateHandler(LogChannel logChannel, ChoiceModelApp choiceModelApp) {
        this.log = logChannel;
        this.model = choiceModelApp;
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.log.log(10000000, "ClampStateHandler#updateClampState(): Clamp S: %1", bl);
        this.isClampS_On = bl;
        this.model.setValue(bl ? 1 : 0);
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }

    public boolean isClampSOn() {
        return this.isClampS_On;
    }
}

