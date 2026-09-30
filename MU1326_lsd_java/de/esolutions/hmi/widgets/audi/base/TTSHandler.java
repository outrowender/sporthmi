/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.ITTSHandler;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.tghu.tts.TTSStringUtil;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.StringUtility;

public class TTSHandler
implements TTSListener,
ITTSHandler {
    public static final int REQUESTOR_ID_TOUCHPAD = 0;
    public static final int REQUESTOR_ID_RADIO_POPUP = 1;
    public static final int REQUESTOR_COUNT = 2;
    public static TTSSessionBasedService ttsService = null;
    private static final long CACHE_TEXT_MAXTIME = 1000L;
    private static boolean[] requestorSessionRunning = new boolean[2];
    private boolean sessionStarted = false;
    private boolean sessionPaused = false;
    private String cachedText = null;
    private boolean speaking = false;
    private boolean stopSessionRequested = false;
    private volatile long cachedTextTime = 0L;
    private static final String SAY_AS_TP_STRING_START_TAG = "<say-as interpret-as=\"touchpad\">";
    private static final String SAY_AS_STRING_END_TAG = "</say-as> ";

    public void speak(int n, String string, String string2, String string3, boolean bl, int n2) {
        this.speak(n, string, null, string2, string3, bl, n2);
    }

    public void speak(int n, String string, String string2, String string3, String string4, boolean bl, int n2) {
        String string5 = "";
        if (IWidgetLogChannel.tpLogChannelInternal.isInfo()) {
            IWidgetLogChannel.tpLogChannelInternal.log(1000000, "TTSHandler#speak speak phonemeText before adding tags phonemeText: %1, plainText: %2 sound: %3", (Object)string, (Object)StringUtility.sanitizeCharactersForLogging(string3), (Object)string4);
            IWidgetLogChannel.tpLogChannelInternal.log(1000000, "TTSHandler#speak speak phonemeText before adding tags phonemeAlphabet: %1", (Object)string2);
        }
        if (string3 != null && string3.length() > 0) {
            switch (n2) {
                case 2: {
                    string5 = TTSStringUtil.buildPhonemeString(string, string2, string3);
                    break;
                }
                case 1: {
                    string5 = TTSHandler.buildSayAsTouchpad(string3);
                    break;
                }
                default: {
                    string5 = TTSHandler.parseText(string3);
                }
            }
        }
        IWidgetLogChannel.tpLogChannelInternal.log(1000000, "TTSHandler#speak speak textToSpeak: %1, sound: %2", (Object)string5, (Object)string4);
        this.speakHandling(n, string5, string4, bl);
    }

    private void speakHandling(int n, String string, String string2, boolean bl) {
        SDSService sDSService;
        String string3 = StringUtility.sanitizeCharactersForLogging(string);
        IWidgetLogChannel.tpLogChannelInternal.log(1000000, "TTSHandler#speak speak textToSpeak: %1, sound: %2", (Object)string3, (Object)string2);
        if (string2 != null) {
            if (string.length() > 0 && string.charAt(string.length() - 1) != ' ') {
                string = string + ' ';
            }
            string = string + string2;
        }
        if ((sDSService = AbstractWidget.sdsService) != null && sDSService.isSDSActive()) {
            IWidgetLogChannel.tpLogChannelInternal.log(1000000, "TTSHandler#speak sds is active - call playPrioPrompt sound: %1, textToSpeak: %2", (Object)string2, (Object)string3);
            this.speaking = true;
            sDSService.playPrioPrompt(string);
        } else if (this.isTTSReady()) {
            IWidgetLogChannel.tpLogChannelInternal.log(1000000, "TTSHandler#speakHandling speak text: %1, sound: %2", (Object)string3, (Object)string2);
            this.speaking = true;
            if (bl) {
                ttsService.abortSpeaking();
            }
            ttsService.speak(string);
        } else {
            this.startSession(n);
            this.setCachedText(string);
            IWidgetLogChannel.tpLogChannelInternal.log(1000000, "TTSHandler#speakHandling string: %2 cannot be spoken because TTS is not ready yet, sessionPaused: %1, ttsService: %3", this.sessionPaused, (Object)string3, (Object)ttsService);
        }
    }

    private static String buildSayAsTouchpad(String string) {
        int n = string.length();
        Buffer buffer = new Buffer(n * 50);
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append(SAY_AS_TP_STRING_START_TAG);
            buffer.append(TTSHandler.parseText(string.substring(i2, i2 + 1)));
            buffer.append(SAY_AS_STRING_END_TAG);
        }
        return buffer.toString();
    }

    private static String parseText(String string) {
        int n = string.length();
        if (n > 1) {
            Buffer buffer = new Buffer(n + 12);
            for (int i2 = 0; i2 < n; ++i2) {
                buffer.append(TTSHandler.checkAndReplaceCharacter(string.charAt(i2)));
            }
            return buffer.toString();
        }
        return TTSHandler.checkAndReplaceCharacter(string.charAt(0));
    }

    private static String checkAndReplaceCharacter(char c2) {
        switch (c2) {
            case '&': {
                return "&amp;";
            }
            case '\'': {
                return "&apos;";
            }
            case '<': {
                return "&lt;";
            }
            case '>': {
                return "&gt;";
            }
            case '\"': {
                return "&quot;";
            }
        }
        return Character.toString(c2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setCachedText(String string) {
        TTSHandler tTSHandler = this;
        synchronized (tTSHandler) {
            this.cachedText = string;
        }
        this.cachedTextTime = AbstractWidget.framework.getMonotonicTime();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String getCachedText() {
        TTSHandler tTSHandler = this;
        synchronized (tTSHandler) {
            return this.cachedText;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void clearCachedText() {
        TTSHandler tTSHandler = this;
        synchronized (tTSHandler) {
            this.cachedText = null;
        }
    }

    private boolean isTTSReady() {
        return ttsService != null && this.sessionStarted && !this.sessionPaused;
    }

    public void stopSession(int n, boolean bl) {
        IWidgetLogChannel.tpLogChannelInternal.log(1000000, "TTSHandler#stopSession sessionStarted: %1, requestorID: %2", this.sessionStarted, (long)n);
        if (bl || !this.speaking) {
            this.stopSessionAtTTSService(n);
        } else {
            this.stopSessionRequested = true;
        }
    }

    private void stopSessionAtTTSService(int n) {
        if (ttsService != null) {
            if (0 <= n && n < 2) {
                TTSHandler.requestorSessionRunning[n] = false;
                if (!TTSHandler.isAnySessionRunning()) {
                    ttsService.stopSession();
                }
            }
        } else {
            IWidgetLogChannel.tpLogChannelInternal.log(100000, "TTSHandler#stopSession cannot stop ttsSession because ttsService is null", this.sessionStarted, (long)n);
        }
    }

    private static boolean isAnySessionRunning() {
        return requestorSessionRunning[0] || requestorSessionRunning[1];
    }

    public void startSession(int n) {
        IWidgetLogChannel.tpLogChannelInternal.log(1000000, "TTSHandler#startSession sessionStarted: %1, requestorID: %2", this.sessionStarted, (long)n);
        if (ttsService != null) {
            if (0 <= n && n < 2) {
                this.stopSessionRequested = false;
                if (!this.sessionStarted) {
                    ttsService.startSession();
                }
                TTSHandler.requestorSessionRunning[n] = true;
            }
        } else {
            IWidgetLogChannel.tpLogChannelInternal.log(100000, "TTSHandler#startSession cannot start ttsSession because ttsService is null", this.sessionStarted, (long)n);
        }
    }

    public void setTTSService(TTSSessionBasedService tTSSessionBasedService) {
        ttsService = tTSSessionBasedService;
        if (tTSSessionBasedService == null) {
            this.sessionStarted = false;
            this.sessionPaused = false;
            TTSHandler.requestorSessionRunning[0] = false;
            TTSHandler.requestorSessionRunning[1] = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() {
        IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TTSHandler#reset called");
        try {
            if (ttsService != null) {
                ttsService.stopSession();
            }
        }
        catch (Exception exception) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000, "TTSHandler#reset ttsService.stopSession() call failed");
        }
        finally {
            this.sessionStarted = false;
            this.sessionPaused = false;
            TTSHandler.requestorSessionRunning[0] = false;
            TTSHandler.requestorSessionRunning[1] = false;
        }
    }

    public void audioAvailable(boolean bl) {
        IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TTSHandler#audioAvailable called");
    }

    public void sessionStarted() {
        this.sessionStarted = true;
        this.sessionPaused = false;
        IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TTSHandler#sessionStarted called");
        if (ttsService != null) {
            long l = AbstractWidget.framework.getMonotonicTime() - this.cachedTextTime;
            if (0L <= l && l < 1000L) {
                String string = this.getCachedText();
                if (string != null) {
                    IWidgetLogChannel.tpLogChannelInternal.log(1000000, "TTSHandler#sessionStarted there was a cached text: %1, but duration between caching text and session started was too long: %2 (maxTime: 3)", (Object)string, l, 1000L);
                    ttsService.speak(string);
                }
            } else if (IWidgetLogChannel.tpLogChannelInternal.isInfo()) {
                IWidgetLogChannel.tpLogChannelInternal.log(1000000, "TTSHandler#sessionStarted there was a cached text: %1, but duration between caching text and session started was too long: %2 (maxTime: 3)", (Object)this.cachedText, l, 1000L);
            }
        }
    }

    public void sessionStopped() {
        this.sessionStarted = false;
        this.clearCachedText();
        IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TTSHandler#sessionStopped called");
    }

    public void speakingAborted() {
        IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TTSHandler#speakingAborted called");
        this.speaking = false;
    }

    public void speakingFailed() {
        IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TTSHandler#speakingFailed called");
        this.speaking = false;
    }

    public void speakingPaused() {
        IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TTSHandler#speakingPaused called");
    }

    public void speakingFinished() {
        IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TTSHandler#speakingFinished called");
        this.speaking = false;
        if (this.stopSessionRequested) {
            this.stopSessionAtTTSService(0);
        }
    }

    public void sessionPaused() {
        this.sessionPaused = true;
        this.sessionStarted = true;
        IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TTSHandler#sessionPaused sessionPaused: %1 sessionStarted: %2", this.sessionPaused, this.sessionStarted);
    }

    public void sessionResumed() {
        this.sessionPaused = false;
        IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TTSHandler#sessionResumed sessionPaused: %1", this.sessionPaused);
    }

    public void speakingStarted() {
    }
}

