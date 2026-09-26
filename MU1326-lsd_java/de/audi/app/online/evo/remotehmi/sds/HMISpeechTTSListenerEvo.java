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

    @Override
    public void setTTSService(TTSSessionBasedService tTSSessionBasedService) {
        this.ttsService = tTSSessionBasedService;
    }

    @Override
    public void startTts(String string, boolean bl, boolean bl2) {
        if (this.getFrameworkAccess().isSimulator()) {
            System.err.println(new StringBuffer().append("TTS: ").append(string).toString());
        }
        if (this.ttsService == null) {
            this.logChannel.log(10000, "HMISpeechTTSListenerEvo#startTts: TTS service is null!");
            return;
        }
        if (!bl2 && this.lastTtsString != null && string != null && string.equals(this.lastTtsString) && !bl) {
            this.logChannel.log(-2137614336, "HMISpeechTTSListenerEvo#startTts: not resetting, because strings are equal and not reinit");
            return;
        }
        if (bl) {
            this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#startTts: abort speaking");
            this.abort();
            this.lastTtsString = null;
        } else if (string != null && string.length() > 0) {
            String string2 = this.prepareString(string);
            this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#startTts: starting phrase \"%1\"", (Object)string2);
            this.lastTtsString = string2;
            if (this.sessionRunning) {
                this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#startTts: session running, starting phrase \"%1\"", (Object)string2);
                this.ttsService.abortSpeaking();
                this.ttsService.speak(string2);
            } else {
                this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#startTts: session closed, starting phrase \"%1\"", (Object)string2);
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

    @Override
    public void pause() {
        System.out.println("TTS PAUSE");
        if (this.ttsService != null) {
            this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#pause: pausing TTS");
            this.ttsService.pause();
        }
    }

    @Override
    public void resume() {
        System.out.println("TTS RESUME");
        if (this.ttsService != null) {
            this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#resume: resuming TTS");
            this.ttsService.resume();
        }
    }

    @Override
    public void abort() {
        if (this.ttsService != null) {
            this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#abort: aborting TTS");
            try {
                this.ttsService.stopSession();
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "HMISpeechTTSListenerEvo#abort: error during abort %1", (Throwable)exception);
            }
        }
    }

    @Override
    public void sessionStarted() {
        this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#sessionStarted");
        this.sessionRunning = true;
        this.ttsService.speak(this.lastTtsString);
    }

    @Override
    public void sessionStopped() {
        this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#sessionStopped");
        this.sessionRunning = false;
    }

    @Override
    public void speakingFinished() {
        this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#speakingFinished");
        this.lastTtsString = null;
        this.ttsService.stopSession();
        RemoteHMIAction remoteHMIAction = this.getAction(910);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    @Override
    public void speakingAborted() {
        this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#speakingAborted");
        RemoteHMIAction remoteHMIAction = this.getAction(911);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    @Override
    public void sessionPaused() {
        this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#sessionPaused");
    }

    @Override
    public void sessionResumed() {
        this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#sessionResumed");
        if (this.lastTtsString != null && this.ttsService != null) {
            this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#sessionResumed re-starting phrase \"%1\"", (Object)this.lastTtsString);
            this.ttsService.speak(this.lastTtsString);
        }
    }

    @Override
    public void speakingFailed() {
        this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#speakingFailed");
        this.lastTtsString = null;
        this.abort();
    }

    @Override
    public void speakingPaused() {
        this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#speakingPaused");
        RemoteHMIAction remoteHMIAction = this.getAction(912);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    @Override
    public void audioAvailable(boolean bl) {
        this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#audioAvailable %1", bl);
    }

    @Override
    public void speakingStarted() {
        this.logChannel.log(1078071040, "HMISpeechTTSListenerEvo#speakingStarted");
    }

    @Override
    protected RemoteHMIAction getAction(int n) {
        return this.remoteHmiService.getAction(n);
    }

    @Override
    public void onExit() {
        this.abort();
    }
}

