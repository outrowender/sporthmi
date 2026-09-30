/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts;

import de.audi.atip.interapp.tts.TTSSingleSpeakService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.AbstractSpeaker;
import de.audi.tghu.tts.DSITTSCaller;
import de.audi.tghu.tts.TTSSingleSpeakerDefaultListener;

public class SingleSpeaker
extends AbstractSpeaker
implements TTSSingleSpeakService {
    private TTSSingleSpeakerDefaultListener defaultListener;

    public SingleSpeaker(LogChannel logChannel, DSITTSCaller dSITTSCaller, int n, short s) {
        super(logChannel, dSITTSCaller, n, s);
        this.logCh.log(10000000, "[SingleSpeaker#ctor] Called.");
        this.sessionPauseHandling = 1;
        this.defaultListener = new TTSSingleSpeakerDefaultListener(logChannel, this);
        this.setTTSListener(this.defaultListener);
    }

    public void speakImpl(String string) {
        this.logCh.log(10000000, "[SingleSpeaker#speak] Called, text: %1", (Object)string);
        this.defaultListener.setBufferedText(string);
        this.ttsService.singleSpeak(string);
    }
}

