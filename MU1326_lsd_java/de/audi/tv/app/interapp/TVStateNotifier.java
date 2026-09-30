/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;

public class TVStateNotifier
extends TVEventDefaultListener {
    private final TVEnv env;
    private boolean hasMuAudioFocus = false;
    private boolean hasSdisAudioFocus = false;
    private boolean highTemperatureShutdownHappened = false;

    public TVStateNotifier(TVEnv tVEnv) {
        this.env = tVEnv;
    }

    public void onTunerAvailable() {
        this.env.getChoiceModel(547).setValue(1);
        this.env.getChoiceModel(4117).setValue(1);
    }

    public void onTunerUnavailable() {
        this.env.getChoiceModel(4117).setValue(0);
        this.env.getChoiceModel(2600184).setValue(0);
    }

    public void onHighTemperatureShutdown() {
        this.highTemperatureShutdownHappened = true;
        this.env.getChoiceModel(4117).setValue(0);
    }

    public void onEsmLeft() {
        if (this.highTemperatureShutdownHappened) {
            this.highTemperatureShutdownHappened = false;
            this.env.getChoiceModel(4117).setValue(1);
        }
        this.env.getChoiceModel(2600184).setValue(1);
    }

    public void onEsmEntered() {
        this.env.getChoiceModel(2600184).setValue(0);
    }

    public void onAppActivated(int n) {
        if (n == 1) {
            this.onSdisLostTvAudioFocus();
        }
    }

    public void onMuGotTvAudioFocus() {
        this.hasMuAudioFocus = true;
        this.updateTvAvActivityStatus();
    }

    public void onMuLostTvAudioFocus() {
        this.hasMuAudioFocus = false;
        this.updateTvAvActivityStatus();
    }

    public void onSdisGotTvAudioFocus() {
        this.hasSdisAudioFocus = true;
        this.updateTvAvActivityStatus();
    }

    public void onSdisLostTvAudioFocus() {
        this.hasSdisAudioFocus = false;
        this.updateTvAvActivityStatus();
    }

    private void updateTvAvActivityStatus() {
        this.env.getChoiceModel(2600183).setValue(this.hasMuAudioFocus || this.hasSdisAudioFocus ? 1 : 0);
    }
}

