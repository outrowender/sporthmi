/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.log.LogChannel;

public class IAudioFocusManagerLoggingDecorator
implements IAudioFocusManager {
    private final IAudioFocusManager wrappee;
    private final LogChannel lc;
    private final int level;

    public IAudioFocusManagerLoggingDecorator(IAudioFocusManager iAudioFocusManager, LogChannel logChannel, int n) {
        this.wrappee = iAudioFocusManager;
        this.lc = logChannel;
        this.level = n;
    }

    public void setActiveAudioApp(int n, int n2) {
        this.lc.log(this.level, "-> [IAudioFocusManager.setActiveAudioApp] terminalId %2, appId %1", (Object)IAudioFocusManagerLoggingDecorator.appIdToString(n2), (long)n);
        this.wrappee.setActiveAudioApp(n, n2);
    }

    private static String appIdToString(int n) {
        switch (n) {
            case 2: {
                return "APPLICATION_ID_MEDIA";
            }
            case 1: {
                return "APPLICATION_ID_TUNER";
            }
            case 43: {
                return "APPLICATION_ID_TERMINALMODE";
            }
            case 48: {
                return "APPLICATION_ID_TERMINALMODE_AUDIO";
            }
            case 38: {
                return "APPLICATION_ID_TV";
            }
        }
        return Integer.toString(n);
    }
}

