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
    private static final int CLAMP_OFF;
    private static final int CLAMP_ON;
    private final LogChannel log;
    private final ChoiceModelApp model;
    private volatile boolean isClampS_On;

    public ClampStateHandler(LogChannel logChannel, ChoiceModelApp choiceModelApp) {
        this.log = logChannel;
        this.model = choiceModelApp;
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.log.log(-2137614336, "ClampStateHandler#updateClampState(): Clamp S: %1", bl);
        this.isClampS_On = bl;
        this.model.setValue(bl ? 1 : 0);
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
    }

    @Override
    public boolean isClampSOn() {
        return this.isClampS_On;
    }
}

