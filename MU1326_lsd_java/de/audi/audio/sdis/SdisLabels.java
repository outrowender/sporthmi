/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;

public final class SdisLabels {
    private SdisLabels() {
    }

    public static String getContext(int n) {
        switch (n) {
            case 2: {
                return "AUDIOCONTEXT_RADIO";
            }
            case 3: {
                return "AUDIOCONTEXT_MEDIA";
            }
            case 4: {
                return "AUDIOCONTEXT_TV";
            }
            case 1: {
                return "AUDIOCONTEXT_A2LS";
            }
            case 0: {
                return "AUDIOCONTEXT_NONE";
            }
        }
        return "AUDIOCONTEXT_UNKNOW(" + n + ")";
    }

    public static String getAudioState(int n) {
        switch (n) {
            case 0: {
                return "AUDIOSTATE_IN_CHANGE";
            }
            case 1: {
                return "AUDIOSTATE_READY";
            }
            case 2: {
                return "AUDIOSTATE_A2LS_PENDING";
            }
        }
        return "AUDIOSTATE_UNKNOW(" + n + ")";
    }

    public static String getAudioState(AudioState audioState) {
        if (audioState == null) {
            return "NULL";
        }
        return SdisLabels.getContext(audioState.audioContext) + ": " + SdisLabels.getAudioState(audioState.audioState);
    }

    public static String getAudibleState(int n) {
        switch (n) {
            case 0: {
                return "AUDIBLESTATE_AUDIBLE";
            }
            case 1: {
                return "AUDIBLESTATE_NAV_ANNOUNCEMENT";
            }
            case 2: {
                return "AUDIBLESTATE_CALL";
            }
            case 4: {
                return "AUDIBLESTATE_SDS";
            }
            case 8: {
                return "AUDIBLESTATE_TA";
            }
            case 16: {
                return "AUDIBLESTATE_APS";
            }
            case 0x100000: {
                return "AUDIBLESTATE_OTHER";
            }
        }
        return "AUDIOSTATE_UNKNOW";
    }
}

