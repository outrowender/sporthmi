/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts.request;

import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSToneListener;

public class TTSResult {
    static final int TTS_RESULT_NONE = 1;
    static final int TTS_RESULT_FINISHED = 2;
    static final int TTS_RESULT_FAILED = 3;
    static final int TTS_RESULT_ABORTED = 4;
    public static final int TTS_RESULT_PROMPT_STARTED = 5;
    public static final int TTS_RESULT_TONE_STARTED = 6;
    public static final int TTS_RESULT_TONE_FINISHED = 7;
    public static final int TTS_RESULT_PROMPT_PAUSED = 8;
    private int type;
    private TTSListener listener;

    public TTSResult(TTSListener tTSListener, int n) {
        this.type = n;
        this.listener = tTSListener;
    }

    public void execute() {
        if (this.listener == null) {
            return;
        }
        switch (this.type) {
            case 3: {
                this.listener.speakingFailed();
                break;
            }
            case 2: {
                this.listener.speakingFinished();
                break;
            }
            case 4: {
                this.listener.speakingAborted();
                break;
            }
            case 5: {
                this.listener.speakingStarted();
                break;
            }
            case 8: {
                this.listener.speakingPaused();
                break;
            }
            case 6: {
                if (!(this.listener instanceof TTSToneListener)) break;
                ((TTSToneListener)this.listener).toneStarted();
                break;
            }
            case 7: {
                if (!(this.listener instanceof TTSToneListener)) break;
                ((TTSToneListener)this.listener).toneFinished();
                break;
            }
            case 1: {
                break;
            }
        }
    }

    public static String resultToString(int n) {
        switch (n) {
            case 1: {
                return "NONE";
            }
            case 2: {
                return "FINISHED";
            }
            case 3: {
                return "FAILED";
            }
            case 4: {
                return "ABORTED";
            }
            case 5: {
                return "STARTED";
            }
            case 6: {
                return "TONE_STARTED";
            }
            case 7: {
                return "TONE_FINISHED";
            }
            case 8: {
                return "PAUSED";
            }
        }
        return "UNKNOWN (" + n + ")";
    }
}

