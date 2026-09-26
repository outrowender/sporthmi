/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.waveplayer;

public final class WavePlayerUtil {
    public static String getAudioStateLabel(int n) {
        switch (n) {
            case 0: {
                return "ACTIVE";
            }
            case 1: {
                return "IDLE";
            }
        }
        return "UNKNOWN";
    }

    public static String getAudioModeLabel(int n) {
        switch (n) {
            case 2: {
                return "ABORT";
            }
            case 5: {
                return "ABORTED";
            }
            case 6: {
                return "ERROR_BUSY";
            }
            case 9: {
                return "ERROR_INTERNAL";
            }
            case 7: {
                return "ERROR_NOT_POSSIBLE";
            }
            case 8: {
                return "ERROR_REGISTRATION_MISSING";
            }
            case 1: {
                return "REPEAT";
            }
            case 0: {
                return "START";
            }
            case 3: {
                return "STARTED";
            }
            case 4: {
                return "STOPPED";
            }
        }
        return "UNKNOWN";
    }

    public static String getResultLabel(int n) {
        switch (n) {
            case 0: {
                return "SUCCESS";
            }
            case 1: {
                return "INVALID_TONE_ID";
            }
        }
        return "UNKNOWN";
    }

    private WavePlayerUtil() {
        throw new IllegalAccessError("This class contains only static helper methods!");
    }
}

