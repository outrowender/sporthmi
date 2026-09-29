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

    @Override
    public void onTunerAvailable() {
        this.env.getChoiceModel(547).setValue(1);
        this.env.getChoiceModel(4117).setValue(1);
    }

    @Override
    public void onTunerUnavailable() {
        this.env.getChoiceModel(4117).setValue(0);
        this.env.getChoiceModel(-122935552).setValue(0);
    }

    @Override
    public void onHighTemperatureShutdown() {
        this.highTemperatureShutdownHappened = true;
        this.env.getChoiceModel(4117).setValue(0);
    }

    @Override
    public void onEsmLeft() {
        if (this.highTemperatureShutdownHappened) {
            this.highTemperatureShutdownHappened = false;
            this.env.getChoiceModel(4117).setValue(1);
        }
        this.env.getChoiceModel(-122935552).setValue(1);
    }

    @Override
    public void onEsmEntered() {
        this.env.getChoiceModel(-122935552).setValue(0);
    }

    @Override
    public void onAppActivated(int n) {
        if (n == 1) {
            this.onSdisLostTvAudioFocus();
        }
    }

    @Override
    public void onMuGotTvAudioFocus() {
        this.hasMuAudioFocus = true;
        this.updateTvAvActivityStatus();
    }

    @Override
    public void onMuLostTvAudioFocus() {
        this.hasMuAudioFocus = false;
        this.updateTvAvActivityStatus();
    }

    @Override
    public void onSdisGotTvAudioFocus() {
        this.hasSdisAudioFocus = true;
        this.updateTvAvActivityStatus();
    }

    @Override
    public void onSdisLostTvAudioFocus() {
        this.hasSdisAudioFocus = false;
        this.updateTvAvActivityStatus();
    }

    private void updateTvAvActivityStatus() {
        this.env.getChoiceModel(-139712768).setValue(this.hasMuAudioFocus || this.hasSdisAudioFocus ? 1 : 0);
    }
}

