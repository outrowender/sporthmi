/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.display;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.display.AbstractDisplayHandler;
import de.audi.app.settings.display.KombiBrightnessHandler;

public final class DisplayHandlerEvo
extends AbstractDisplayHandler {
    public DisplayHandlerEvo(SettingsEnv settingsEnv, KombiBrightnessHandler kombiBrightnessHandler) {
        super(settingsEnv, kombiBrightnessHandler);
    }

    @Override
    protected int modelValueToBrightnessValue(int n) {
        return n;
    }

    @Override
    protected int brightnessValueToModelValue(int n) {
        return n;
    }

    @Override
    protected void initBrightnessConstants() {
        this.rangeBrightnessMin = 0;
        this.rangeBrightnessMax = 100;
        this.rangeBrightnessMedial = 50;
        this.rangeBrightnessStep = 10;
    }
}

