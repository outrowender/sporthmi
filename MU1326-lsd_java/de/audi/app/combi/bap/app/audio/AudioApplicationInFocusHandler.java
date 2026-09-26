/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.combi.bap.app.audio.IAudioApplicationInFocusObserver;
import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.log.LogChannel;
import java.util.LinkedList;
import java.util.List;

public class AudioApplicationInFocusHandler
implements IAudioFocusClient {
    private volatile int audioApplicationInFocus = -2;
    private final List observers = new LinkedList();
    private final LogChannel logChannel;

    public AudioApplicationInFocusHandler(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public void setActiveAudioApplication(int n) {
        this.audioApplicationInFocus = n;
        this.notifyObservers();
    }

    public int getAudioApplicationInFocus() {
        return this.audioApplicationInFocus;
    }

    protected String getAudioApplicationInFocusName() {
        return AudioApplicationInFocusHandler.getAudioApplicationName(this.audioApplicationInFocus);
    }

    public static String getAudioApplicationName(int n) {
        switch (n) {
            case 0: {
                return "Tuner";
            }
            case 1: {
                return "Media";
            }
            case 2: {
                return "TV";
            }
            case 3: {
                return "TerminalMode";
            }
            case -2: {
                return "[Not set]";
            }
        }
        return "[Unknown]";
    }

    public boolean isTunerInFocus() {
        return this.audioApplicationInFocus == 0;
    }

    public boolean isMediaInFocus() {
        return this.audioApplicationInFocus == 1;
    }

    public boolean isTVInFocus() {
        return this.audioApplicationInFocus == 2;
    }

    public boolean isTerminalModeInFocus() {
        return this.audioApplicationInFocus == 3;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void notifyObservers() {
        LinkedList linkedList;
        Object object = this.observers;
        synchronized (object) {
            linkedList = (LinkedList)((LinkedList)this.observers).clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            IAudioApplicationInFocusObserver iAudioApplicationInFocusObserver = (IAudioApplicationInFocusObserver)object.next();
            iAudioApplicationInFocusObserver.notifyAudioApplicationInFocusChanged(this.audioApplicationInFocus);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addObserver(IAudioApplicationInFocusObserver iAudioApplicationInFocusObserver) {
        List list = this.observers;
        synchronized (list) {
            this.observers.add(iAudioApplicationInFocusObserver);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeObserver(IAudioApplicationInFocusObserver iAudioApplicationInFocusObserver) {
        List list = this.observers;
        synchronized (list) {
            this.observers.remove(iAudioApplicationInFocusObserver);
        }
    }

    @Override
    public void updateAudioFocus(int n, int n2) {
        if (n == 0) {
            int n3;
            if (n2 == 2) {
                this.logChannel.log(1078071040, "[AudioApplicationInFocusHandler#updateAudioFocus] MEDIA has audio focus now");
                n3 = 1;
            } else if (n2 == 1) {
                this.logChannel.log(1078071040, "[AudioApplicationInFocusHandler#updateAudioFocus] TUNER has audio focus now");
                n3 = 0;
            } else if (n2 == 38) {
                this.logChannel.log(1078071040, "[AudioApplicationInFocusHandler#updateAudioFocus] TV has audio focus now");
                n3 = 2;
            } else if (n2 == 48) {
                this.logChannel.log(1078071040, "[AudioApplicationInFocusHandler#updateAudioFocus] TerminalMode has audio focus now");
                n3 = 3;
            } else {
                this.logChannel.log(1078071040, "[AudioApplicationInFocusHandler#updateAudioFocus] UNKNOWN audio focus set: %1", (long)n2);
                n3 = -1;
            }
            if (this.audioApplicationInFocus != n3) {
                this.audioApplicationInFocus = n3;
                this.notifyObservers();
            }
        }
    }
}

