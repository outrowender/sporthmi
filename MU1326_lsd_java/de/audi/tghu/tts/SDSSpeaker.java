/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts;

import de.audi.atip.interapp.tts.TTSSDSService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.AbstractSpeaker;
import de.audi.tghu.tts.DSITTSCaller;

public class SDSSpeaker
extends AbstractSpeaker
implements TTSSDSService {
    public SDSSpeaker(LogChannel logChannel, DSITTSCaller dSITTSCaller, short s) {
        super(logChannel, dSITTSCaller, -1, s);
        this.sessionPauseHandling = 0;
        this.logCh.log(-2137614336, "[SDSSpeaker#ctor] Called.");
    }

    @Override
    public void speakImpl(String string) {
        this.logCh.log(-2137614336, "[SDSSpeaker#speakImpl] Called, text: %1", (Object)string);
        this.ttsService.speak(string);
    }

    @Override
    public void playTone(int n) {
        this.logCh.log(-2137614336, "[SDSSpeaker#playTone] Called, toneValue=%1", (long)n);
        this.ttsService.playTone(n);
    }

    @Override
    public synchronized void speakRemoteHMI(String string) {
        this.logCh.log(1078071040, "[AbstractSpeaker#speakRemoteHMI] Called, text: %1", (Object)string);
        this.ttsService.speak(string, 3);
    }
}

