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
        this.log.log(-2137614336, "AddressBookTTSHandler#setTTSService(): got TTSService: %1", (Object)tTSSingleSpeakService);
        this.ttsService = tTSSingleSpeakService;
    }

    public synchronized void speak(String string) {
        if (this.ttsService == null) {
            this.log.log(10000, "AddressBookTTSHandler#speak(): ttsService not available!");
            return;
        }
        if (this.isAlreadySpeaking) {
            this.log.log(-2137614336, "AddressBookTTSHandler#speak(): read out already in progress, ignoring speak request.");
            return;
        }
        this.ttsService.speak(string);
    }

    @Override
    public void sessionStarted() {
        this.log.log(-2137614336, "AddressBookTTSHandler#sessionStarted()");
        this.isAlreadySpeaking = true;
    }

    @Override
    public void sessionStopped() {
        this.log.log(-2137614336, "AddressBookTTSHandler#sessionStopped()");
        this.isAlreadySpeaking = false;
    }

    @Override
    public synchronized void sessionPaused() {
        this.log.log(-2137614336, "AddressBookTTSHandler#sessionPaused()");
        if (this.ttsService != null) {
            this.ttsService.abortSpeaking();
        }
    }

    @Override
    public void speakingFinished() {
        this.log.log(-2137614336, "AddressBookTTSHandler#sessionFinished()");
    }

    @Override
    public void speakingAborted() {
        this.log.log(-2137614336, "AddressBookTTSHandler#sessionAborted()");
    }

    @Override
    public void sessionResumed() {
        this.log.log(-2137614336, "AddressBookTTSHandler#sessionResumed()");
    }

    @Override
    public void speakingFailed() {
        this.log.log(-2137614336, "AddressBookTTSHandler#sessionFailed()");
    }

    @Override
    public void audioAvailable(boolean bl) {
        this.log.log(-2137614336, "AddressBookTTSHandler#audioAvailable()");
    }

    @Override
    public void speakingStarted() {
        this.log.log(-2137614336, "AddressBookTTSHandler#speakingStarted()");
    }

    @Override
    public void speakingPaused() {
        this.log.log(-2137614336, "AddressBookTTSHandler#speakingPaused()");
    }
}

