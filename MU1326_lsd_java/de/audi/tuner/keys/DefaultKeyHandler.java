/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.keys;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tuner.app.AudioFocusClient;
import de.audi.tuner.app.BandListHandler;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.keys.KeyHandlerBasics;

public class DefaultKeyHandler
extends DefaultButtonListener
implements ChoiceListener,
TimerListener {
    final Logger logger;
    final TunerModels models;
    final TunerStatus status;
    final TunerAudioMgmt audio;
    final AnnouncementHandler announce;
    final BandListHandler bandListHandler;
    final MemoryListHandler memory;
    final AudioFocusClient audioFocusClient;

    DefaultKeyHandler(KeyHandlerBasics keyHandlerBasics) {
        this.logger = keyHandlerBasics.getBasics().getLogger();
        this.models = keyHandlerBasics.getBasics().getModels();
        this.status = keyHandlerBasics.getBasics().getStatus();
        this.audio = keyHandlerBasics.getAudio();
        this.announce = keyHandlerBasics.getAnnouncementHandler();
        this.bandListHandler = keyHandlerBasics.getBandList();
        this.memory = keyHandlerBasics.getMemory();
        this.audioFocusClient = keyHandlerBasics.getAudioFocusClient();
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    public void fireTimer(Timer timer) {
    }

    public void cancelTimer(Timer timer) {
    }

    public void bandSelected(int n, int n2) {
    }
}

