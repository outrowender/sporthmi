/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.keys;

import de.audi.tuner.app.AudioFocusClient;
import de.audi.tuner.app.BandListHandler;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.keys.BandSelectKeyHandler;
import de.audi.tuner.keys.DefaultButtonHandler;
import de.audi.tuner.keys.DefaultKeyHandler;
import de.audi.tuner.keys.JokerKeyHandler;
import de.audi.tuner.keys.KeyHandlerBasics;

public class KeyHandlerManager {
    private final DefaultButtonHandler defaultButtonHandler;
    private final BandSelectKeyHandler bandSelectKeyHandler;

    public KeyHandlerManager(TunerBasics tunerBasics, BandListHandler bandListHandler, TunerAudioMgmt tunerAudioMgmt, AnnouncementHandler announcementHandler, MemoryListHandler memoryListHandler, AudioFocusClient audioFocusClient, IScanHandler iScanHandler) {
        KeyHandlerBasics keyHandlerBasics = new KeyHandlerBasics(tunerBasics, bandListHandler, tunerAudioMgmt, announcementHandler, memoryListHandler, audioFocusClient);
        this.defaultButtonHandler = new DefaultButtonHandler(keyHandlerBasics);
        new DefaultKeyHandler(keyHandlerBasics);
        this.bandSelectKeyHandler = new BandSelectKeyHandler(keyHandlerBasics, iScanHandler);
        new JokerKeyHandler(keyHandlerBasics, this.defaultButtonHandler);
    }

    public DefaultButtonHandler getDefaultButtonHandler() {
        return this.defaultButtonHandler;
    }

    public BandSelectKeyHandler getBandSelectKeyHandler() {
        return this.bandSelectKeyHandler;
    }
}

