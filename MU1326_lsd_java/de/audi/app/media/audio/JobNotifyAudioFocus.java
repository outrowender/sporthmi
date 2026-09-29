/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.IAudioStateListener;
import de.audi.app.media.logger.IMediaLogger;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.List;

public class JobNotifyAudioFocus
implements Runnable {
    private static final String LOGCLASS;
    private final List listeners;
    private final IMediaLogger logger;
    private final boolean hasAudioFocus;

    public JobNotifyAudioFocus(IMediaLogger iMediaLogger, List list, boolean bl) {
        this.logger = iMediaLogger;
        this.listeners = list;
        this.hasAudioFocus = bl;
    }

    @Override
    public void run() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IAudioStateListener)iterator.next()).audioFocusChanged(this.hasAudioFocus);
            }
            catch (Exception exception) {
                this.logger.audio().log(10000, "[%1.run]", (Object)"JobNotifyAudioFocus", (Throwable)exception);
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("AudioManager.audioFocusChanged('").append(this.hasAudioFocus).append("')");
        return buffer.toString();
    }
}

