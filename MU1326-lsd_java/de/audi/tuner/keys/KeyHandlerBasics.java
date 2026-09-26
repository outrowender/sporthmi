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

class KeyHandlerBasics {
    private final TunerBasics basics;
    private final BandListHandler bandList;
    private final TunerAudioMgmt audio;
    private final AnnouncementHandler announce;
    private final MemoryListHandler memory;
    private final AudioFocusClient audioFocusClient;

    KeyHandlerBasics(TunerBasics tunerBasics, BandListHandler bandListHandler, TunerAudioMgmt tunerAudioMgmt, AnnouncementHandler announcementHandler, MemoryListHandler memoryListHandler, AudioFocusClient audioFocusClient) {
        this.basics = tunerBasics;
        this.bandList = bandListHandler;
        this.audio = tunerAudioMgmt;
        this.announce = announcementHandler;
        this.memory = memoryListHandler;
        this.audioFocusClient = audioFocusClient;
    }

    public TunerBasics getBasics() {
        return this.basics;
    }

    public BandListHandler getBandList() {
        return this.bandList;
    }

    public TunerAudioMgmt getAudio() {
        return this.audio;
    }

    public MemoryListHandler getMemory() {
        return this.memory;
    }

    public AnnouncementHandler getAnnouncementHandler() {
        return this.announce;
    }

    public AudioFocusClient getAudioFocusClient() {
        return this.audioFocusClient;
    }
}

