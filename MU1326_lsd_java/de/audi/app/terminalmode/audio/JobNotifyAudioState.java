/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.IAudioStateListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.esolutions.fw.util.commons.Buffer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class JobNotifyAudioState
implements Runnable {
    private static final String LOGCLASS = "JobNotifyAudioState";
    private final GList<IAudioStateListener> listeners;
    private final LogChannel logger;
    private final AudioConnectionState state;

    public JobNotifyAudioState(LogChannel logChannel, GList<IAudioStateListener> gList, AudioConnectionState audioConnectionState) {
        this.logger = logChannel;
        this.listeners = gList;
        this.state = audioConnectionState;
    }

    @Override
    public void run() {
        this.logger.log(10000000, "<*> [%1.run] IAudioStateListener.audioStateChanged '%2'", (Object)LOGCLASS, (Object)this.state);
        GIterator<IAudioStateListener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            try {
                gIterator.next().audioStateChanged(this.state);
            }
            catch (Exception exception) {
                this.logger.log(10000, "[%1.run]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("AudioManager.audioStateChanged('").append(this.state).append("')");
        return buffer.toString();
    }
}

