/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.IAudioStateListener;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.List;

public class JobNotifyRearSeatAudioFocus
implements Runnable {
    private static final String LOGCLASS = "JobNotifyRearSeatAudioFocus";
    private final IMediaLogger logger;
    private final boolean hasAudioFocus;
    private final ChoiceModelApp rearSeatChoiceModel;
    private final List focusListeners;

    public JobNotifyRearSeatAudioFocus(IMediaLogger iMediaLogger, ChoiceModelApp choiceModelApp, boolean bl, List list) {
        this.logger = iMediaLogger;
        this.rearSeatChoiceModel = choiceModelApp;
        this.hasAudioFocus = bl;
        this.focusListeners = list;
    }

    public void run() {
        try {
            this.rearSeatChoiceModel.setValue(this.hasAudioFocus ? 1 : 0);
        }
        catch (Exception exception) {
            this.logger.audio().log(10000, "[%1.run]", (Object)LOGCLASS, (Throwable)exception);
        }
        Iterator iterator = this.focusListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IAudioStateListener)iterator.next()).rearSeatAudioFocusChanged(this.hasAudioFocus);
            }
            catch (Exception exception) {
                this.logger.audio().log(10000, "[%1.run]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("AudioManager.rearSeatAudioFocusChanged('").append(this.hasAudioFocus).append("')");
        return buffer.toString();
    }
}

