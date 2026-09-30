/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.sds;

import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechTTSListener;

public class HMISpeechTTSListenerEvo
extends HMISpeechTTSListener
implements TTSListener {
    private TTSSessionBasedService ttsService = null;
    private String lastTtsString = null;
    private boolean sessionRunning = false;

    public void setTTSService(TTSSessionBasedService tTSSessionBasedService) {
        this.ttsService = tTSSessionBasedService;
    }

    public void startTts(String string, boolean bl, boolean bl2) {
        if (this.getFrameworkAccess().isSimulator()) {
            System.err.println("TTS: " + string);
        }
        if (this.ttsService == null) {
            this.logChannel.log(10000, "HMISpeechTTSListenerEvo#startTts: TTS service is null!");
            return;
        }
        if (!bl2 && this.lastTtsString != null && string != null && string.equals(this.lastTtsString) && !bl) {
            this.logChannel.log(10000000, "HMISpeechTTSListenerEvo#startTts: not resetting, because strings are equal and not reinit");
            return;
        }
        if (bl) {
            this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#startTts: abort speaking");
            this.abort();
            this.lastTtsString = null;
        } else if (string != null && string.length() > 0) {
            String string2 = this.prepareString(string);
            this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#startTts: starting phrase \"%1\"", (Object)string2);
            this.lastTtsString = string2;
            if (this.sessionRunning) {
                this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#startTts: session running, starting phrase \"%1\"", (Object)string2);
                this.ttsService.abortSpeaking();
                this.ttsService.speak(string2);
            } else {
                this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#startTts: session closed, starting phrase \"%1\"", (Object)string2);
                this.ttsService.startSession();
            }
        }
    }

    private String replaceAll(String string, String string2, String string3) {
        int n = string.lastIndexOf(string2);
        if (n != -1) {
            StringBuffer stringBuffer = new StringBuffer(string);
            stringBuffer.replace(n, n + string2.length(), string3);
            while ((n = string.lastIndexOf(string2, n - 1)) != -1) {
                stringBuffer.replace(n, n + string2.length(), string3);
            }
            string = stringBuffer.toString();
        }
        return string;
    }

    private String prepareString(String string) {
        String string2 = this.replaceAll(string, "&nbsp;", " ");
        string2 = this.replaceAll(string, "&", "&amp;");
        return string2;
    }

    public void pause() {
        System.out.println("TTS PAUSE");
        if (this.ttsService != null) {
            this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#pause: pausing TTS");
            this.ttsService.pause();
        }
    }

    public void resume() {
        System.out.println("TTS RESUME");
        if (this.ttsService != null) {
            this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#resume: resuming TTS");
            this.ttsService.resume();
        }
    }

    public void abort() {
        if (this.ttsService != null) {
            this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#abort: aborting TTS");
            try {
                this.ttsService.stopSession();
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "HMISpeechTTSListenerEvo#abort: error during abort %1", (Throwable)exception);
            }
        }
    }

    public void sessionStarted() {
        this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#sessionStarted");
        this.sessionRunning = true;
        this.ttsService.speak(this.lastTtsString);
    }

    public void sessionStopped() {
        this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#sessionStopped");
        this.sessionRunning = false;
    }

    public void speakingFinished() {
        this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#speakingFinished");
        this.lastTtsString = null;
        this.ttsService.stopSession();
        RemoteHMIAction remoteHMIAction = this.getAction(910);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public void speakingAborted() {
        this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#speakingAborted");
        RemoteHMIAction remoteHMIAction = this.getAction(911);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public void sessionPaused() {
        this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#sessionPaused");
    }

    public void sessionResumed() {
        this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#sessionResumed");
        if (this.lastTtsString != null && this.ttsService != null) {
            this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#sessionResumed re-starting phrase \"%1\"", (Object)this.lastTtsString);
            this.ttsService.speak(this.lastTtsString);
        }
    }

    public void speakingFailed() {
        this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#speakingFailed");
        this.lastTtsString = null;
        this.abort();
    }

    public void speakingPaused() {
        this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#speakingPaused");
        RemoteHMIAction remoteHMIAction = this.getAction(912);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public void audioAvailable(boolean bl) {
        this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#audioAvailable %1", bl);
    }

    public void speakingStarted() {
        this.logChannel.log(1000000, "HMISpeechTTSListenerEvo#speakingStarted");
    }

    protected RemoteHMIAction getAction(int n) {
        return this.remoteHmiService.getAction(n);
    }

    public void onExit() {
        this.abort();
    }
}

