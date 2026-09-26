/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.sds;

import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechTTSListener$1;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechTTSListener$2;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechTTSListener$3;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechTTSListener$4;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechTTSListener$ISpeechCallbackListener;
import de.audi.tghu.tts.TTSStringUtil;

public class HMISpeechTTSListener
extends AbstractRemoteHMIComponent
implements TTSListener {
    private TTSSessionBasedService ttsService = null;
    private String lastTtsString = null;
    private boolean sessionRunning = false;
    private HMISpeechTTSListener$ISpeechCallbackListener listener;

    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        this.logChannel = Online.getInstance().getLogChannelRemoteHMISpeech();
        remoteHMIService.addCommandHandler(802, new HMISpeechTTSListener$1(this, "trigger-tts-start"));
        remoteHMIService.addCommandHandler(801, new HMISpeechTTSListener$2(this, "trigger-tts-stop"));
        remoteHMIService.addCommandHandler(803, new HMISpeechTTSListener$3(this, "trigger-tts-pause"));
        remoteHMIService.addCommandHandler(804, new HMISpeechTTSListener$4(this, "trigger-tts-resume"));
    }

    public void setHmiCallbackListener(HMISpeechTTSListener$ISpeechCallbackListener iSpeechCallbackListener) {
        this.listener = iSpeechCallbackListener;
    }

    public void setTTSService(TTSSessionBasedService tTSSessionBasedService) {
        this.ttsService = tTSSessionBasedService;
    }

    public void startTts(String string, boolean bl, boolean bl2) {
        this.logChannel.log(1078071040, "HMISpeechTTSListener#startTtS string.length %1 stop:%2", (Object)(string != null ? new Integer(string.length()) : new Integer(0)), (Object)Boolean.toString(bl));
        if (this.getFrameworkAccess().isSimulator()) {
            System.err.println(new StringBuffer().append("HMISpeechTTSListener#startTtS: ").append(string).toString());
        }
        if (this.ttsService == null) {
            this.logChannel.log(10000, "HMISpeechTTSListener#startTts: TTS service is null!");
            return;
        }
        if (!bl2 && this.lastTtsString != null && string != null && string.equals(this.lastTtsString) && !bl) {
            this.logChannel.log(-2137614336, "HMISpeechTTSListener#startTts: not resetting, because strings are equal and not reinit");
            return;
        }
        if (bl) {
            this.logChannel.log(1078071040, "HMISpeechTTSListener#startTts: abort speaking");
            this.abort();
            this.lastTtsString = null;
        } else if (string != null && string.length() > 0) {
            String string2 = this.prepareString(string);
            this.logChannel.log(1078071040, "HMISpeechTTSListener#startTts: starting phrase \"%1\"", (Object)string2);
            this.lastTtsString = string2;
            if (this.sessionRunning) {
                this.logChannel.log(1078071040, "HMISpeechTTSListener#startTts: session running, starting phrase \"%1\"", (Object)string2);
                this.ttsService.abortSpeaking();
                this.ttsService.speak(string2);
            } else {
                this.logChannel.log(1078071040, "HMISpeechTTSListener#startTts: session closed, starting phrase \"%1\"", (Object)string2);
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
        string2 = TTSStringUtil.escapeXml(string2);
        return string2;
    }

    public void pause() {
        if (this.ttsService != null) {
            this.ttsService.pause();
        }
    }

    public void resume() {
        if (this.ttsService != null) {
            this.ttsService.resume();
        }
    }

    public void abort() {
        if (this.ttsService != null) {
            this.logChannel.log(1078071040, "HMISpeechTTSListener#abort: aborting TTS");
            try {
                this.ttsService.stopSession();
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "HMISpeechTTSListener#abort: error during abort %1", (Throwable)exception);
            }
        }
    }

    @Override
    public void sessionStarted() {
        this.logChannel.log(1078071040, "HMISpeechTTSListener#sessionStarted");
        this.sessionRunning = true;
        this.ttsService.speak(this.lastTtsString);
        this.informListenerSessionStarted();
    }

    @Override
    public void sessionStopped() {
        this.logChannel.log(1078071040, "HMISpeechTTSListener#sessionStopped");
        this.sessionRunning = false;
        this.informListenerSessionStopped();
    }

    @Override
    public void speakingFinished() {
        this.logChannel.log(1078071040, "HMISpeechTTSListener#speakingFinished");
        this.lastTtsString = null;
        this.ttsService.stopSession();
        this.informListenerSessionFinished();
        RemoteHMIAction remoteHMIAction = this.getAction(910);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    @Override
    public void speakingAborted() {
        this.logChannel.log(1078071040, "HMISpeechTTSListener#speakingAborted");
        this.informListenerSessionStopped();
        RemoteHMIAction remoteHMIAction = this.getAction(911);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    @Override
    public void sessionPaused() {
        this.logChannel.log(1078071040, "HMISpeechTTSListener#sessionPaused");
        this.ttsService.abortSpeaking();
        this.informListenerSessionStopped();
    }

    @Override
    public void sessionResumed() {
        this.logChannel.log(1078071040, "HMISpeechTTSListener#sessionResumed");
        if (this.lastTtsString != null && this.ttsService != null) {
            this.logChannel.log(1078071040, "HMISpeechTTSListener#resumeSpeakingPossible re-starting phrase \"%1\"", (Object)this.lastTtsString);
            this.ttsService.speak(this.lastTtsString);
        }
    }

    @Override
    public void speakingFailed() {
        this.logChannel.log(1078071040, "HMISpeechTTSListener#speakingFailed");
        this.lastTtsString = null;
        this.abort();
    }

    private void informListenerSessionStarted() {
        if (this.listener != null) {
            this.listener.started();
        }
    }

    private void informListenerSessionFinished() {
        if (this.listener != null) {
            this.listener.finished();
        }
    }

    private void informListenerSessionStopped() {
        if (this.listener != null) {
            this.listener.stopped();
        }
    }

    @Override
    public void speakingPaused() {
    }

    @Override
    public void audioAvailable(boolean bl) {
        this.logChannel.log(1078071040, "HMISpeechTTSListener#audioAvailable %1", bl);
    }

    @Override
    public void speakingStarted() {
        this.logChannel.log(1078071040, "HMISpeechTTSListener#speakingStarted");
    }

    protected RemoteHMIAction getAction(int n) {
        return this.remoteHmiService.getAction(n);
    }

    @Override
    public void onExit() {
        this.abort();
    }
}

