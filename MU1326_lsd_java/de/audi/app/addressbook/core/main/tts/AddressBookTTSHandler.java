/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.tts;

import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSSingleSpeakService;
import de.audi.atip.log.LogChannel;

public class AddressBookTTSHandler
implements TTSListener {
    private LogChannel log;
    private TTSSingleSpeakService ttsService;
    private volatile boolean isAlreadySpeaking = false;

    public AddressBookTTSHandler(LogChannel logChannel) {
        this.log = logChannel;
    }

    public synchronized void setTTSService(TTSSingleSpeakService tTSSingleSpeakService) {
        this.log.log(10000000, "AddressBookTTSHandler#setTTSService(): got TTSService: %1", (Object)tTSSingleSpeakService);
        this.ttsService = tTSSingleSpeakService;
    }

    public synchronized void speak(String string) {
        if (this.ttsService == null) {
            this.log.log(10000, "AddressBookTTSHandler#speak(): ttsService not available!");
            return;
        }
        if (this.isAlreadySpeaking) {
            this.log.log(10000000, "AddressBookTTSHandler#speak(): read out already in progress, ignoring speak request.");
            return;
        }
        this.ttsService.speak(string);
    }

    public void sessionStarted() {
        this.log.log(10000000, "AddressBookTTSHandler#sessionStarted()");
        this.isAlreadySpeaking = true;
    }

    public void sessionStopped() {
        this.log.log(10000000, "AddressBookTTSHandler#sessionStopped()");
        this.isAlreadySpeaking = false;
    }

    public synchronized void sessionPaused() {
        this.log.log(10000000, "AddressBookTTSHandler#sessionPaused()");
        if (this.ttsService != null) {
            this.ttsService.abortSpeaking();
        }
    }

    public void speakingFinished() {
        this.log.log(10000000, "AddressBookTTSHandler#sessionFinished()");
    }

    public void speakingAborted() {
        this.log.log(10000000, "AddressBookTTSHandler#sessionAborted()");
    }

    public void sessionResumed() {
        this.log.log(10000000, "AddressBookTTSHandler#sessionResumed()");
    }

    public void speakingFailed() {
        this.log.log(10000000, "AddressBookTTSHandler#sessionFailed()");
    }

    public void audioAvailable(boolean bl) {
        this.log.log(10000000, "AddressBookTTSHandler#audioAvailable()");
    }

    public void speakingStarted() {
        this.log.log(10000000, "AddressBookTTSHandler#speakingStarted()");
    }

    public void speakingPaused() {
        this.log.log(10000000, "AddressBookTTSHandler#speakingPaused()");
    }
}

