/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.AudioState;
import de.audi.app.media.audio.IAudioStateListener;
import de.audi.app.media.logger.IMediaLogger;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.List;

public class JobNotifyAudioState
implements Runnable {
    private static final String LOGCLASS = "JobNotifyAudioState";
    private final List listeners;
    private final IMediaLogger logger;
    private final AudioState state;

    public JobNotifyAudioState(IMediaLogger iMediaLogger, List list, AudioState audioState) {
        this.logger = iMediaLogger;
        this.listeners = list;
        this.state = audioState;
    }

    public void run() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IAudioStateListener)iterator.next()).audioStateChanged(this.state);
            }
            catch (Exception exception) {
                this.logger.audio().log(10000, "[%1.run]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("AudioManager.audioStateChanged('").append(this.state).append("')");
        return buffer.toString();
    }
}

