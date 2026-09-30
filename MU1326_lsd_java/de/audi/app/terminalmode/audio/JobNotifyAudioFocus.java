/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.IAudioStateListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.esolutions.fw.util.commons.Buffer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class JobNotifyAudioFocus
implements Runnable {
    private static final String LOGCLASS = "JobNotifyAudioFocus";
    private final GList<IAudioStateListener> listeners;
    private final LogChannel logger;
    private final boolean hasAudioFocus;

    public JobNotifyAudioFocus(LogChannel logChannel, GList<IAudioStateListener> gList, boolean bl) {
        this.logger = logChannel;
        this.listeners = gList;
        this.hasAudioFocus = bl;
    }

    @Override
    public void run() {
        GIterator<IAudioStateListener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            try {
                gIterator.next().audioFocusChanged(this.hasAudioFocus);
            }
            catch (Exception exception) {
                this.logger.log(10000, "[%1.run]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("AudioManager.audioFocusChanged('").append(this.hasAudioFocus).append("')");
        return buffer.toString();
    }
}

