/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.ResourceRequest;

public final class CarplayUtils {
    private static final int MAX_BITMASK_VALUE;
    private static final int[] STARTSERVICE_LM_SCREEN_RVC;
    private static final int[] STARTSERVICE_LM_SCREEN_PHONE;
    private static final int[] STARTSERVICE_LM_SCREEN_NORMAL;
    private static final int[] STARTSERVICE_LM_SCREEN_SPEECH;
    private static final int[][] startservice_lastmode_screenTransferConstraints;
    private static final int[] STARTSERVICE_LM_AUDIO_PHONE;
    private static final int[] STARTSERVICE_LM_AUDIO_NORMAL;
    private static final int[] STARTSERVICE_LM_AUDIO_SPEECH;
    private static final int[][] startservice_lastmode_audioTransferConstraints;
    private static final int[] SCREEN_RVC;
    private static final int[] SCREEN_PHONE;
    private static final int[] SCREEN_NORMAL;
    private static final int[] SCREEN_SPEECH;
    private static final int[][] screenTransferConstraints;
    private static final int[] AUDIO_NORMAL;
    private static final int[] AUDIO_PHONE;
    private static final int[] AUDIO_SPEECH;
    private static final int[][] audioTransferConstraints;

    private CarplayUtils() {
    }

    public static int getDsiTransferType(int n, boolean bl, boolean bl2) {
        if (n > 31) {
            return 0;
        }
        if (bl2) {
            if (bl) {
                return startservice_lastmode_screenTransferConstraints[n][0];
            }
            return startservice_lastmode_audioTransferConstraints[n][0];
        }
        if (bl) {
            return screenTransferConstraints[n][0];
        }
        return audioTransferConstraints[n][0];
    }

    public static int getDsiTransferPriority(int n, boolean bl, boolean bl2) {
        if (n > 31) {
            return 0;
        }
        if (bl2) {
            if (bl) {
                return startservice_lastmode_screenTransferConstraints[n][1];
            }
            return startservice_lastmode_audioTransferConstraints[n][1];
        }
        if (bl) {
            return screenTransferConstraints[n][1];
        }
        return audioTransferConstraints[n][1];
    }

    public static int getInvertTransferType(int n) {
        switch (n) {
            case 1: {
                return 2;
            }
            case 3: {
                return 4;
            }
        }
        return n;
    }

    public static int getDsiTakeConstraint(int n, boolean bl, boolean bl2) {
        if (n > 31) {
            return 0;
        }
        if (bl2) {
            if (bl) {
                return startservice_lastmode_screenTransferConstraints[n][2];
            }
            return startservice_lastmode_audioTransferConstraints[n][2];
        }
        if (bl) {
            return screenTransferConstraints[n][2];
        }
        return audioTransferConstraints[n][2];
    }

    public static int getDsiBorrowConstraint(int n, boolean bl, boolean bl2) {
        if (n > 31) {
            return 0;
        }
        if (bl2) {
            if (bl) {
                return startservice_lastmode_screenTransferConstraints[n][3];
            }
            return startservice_lastmode_audioTransferConstraints[n][3];
        }
        if (bl) {
            return screenTransferConstraints[n][3];
        }
        return audioTransferConstraints[n][3];
    }

    public static int getDsiUnborrowConstraint(int n, boolean bl, boolean bl2) {
        if (n > 31) {
            return 0;
        }
        if (bl2) {
            if (bl) {
                return startservice_lastmode_screenTransferConstraints[n][4];
            }
            return startservice_lastmode_audioTransferConstraints[n][4];
        }
        if (bl) {
            return screenTransferConstraints[n][4];
        }
        return audioTransferConstraints[n][4];
    }

    public static String logTransferType(int n) {
        switch (n) {
            case 2: {
                return "UNTAKE";
            }
            case 1: {
                return "TAKE";
            }
            case 4: {
                return "UNBORROW";
            }
            case 3: {
                return "BORROW";
            }
        }
        return "UNKNOWN";
    }

    public static String logResourceSharingPolicy(int n) {
        switch (n) {
            case 1: {
                return "ALWAYS";
            }
            case 3: {
                return "NEVER";
            }
            case 2: {
                return "USER_INITIALED";
            }
        }
        return "UNKNOWN";
    }

    static String logModeRequest(ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray) {
        int n;
        Buffer buffer = new Buffer(500);
        for (n = 0; n < resourceRequestArray.length; ++n) {
            buffer.append(resourceRequestArray[n].toString());
        }
        for (n = 0; n < appStateRequestArray.length; ++n) {
            buffer.append(appStateRequestArray[n].toString());
        }
        return buffer.toString();
    }

    static {
        STARTSERVICE_LM_SCREEN_RVC = new int[]{3, 1, 0, 0, 3};
        STARTSERVICE_LM_SCREEN_PHONE = new int[]{3, 1, 0, 0, 3};
        STARTSERVICE_LM_SCREEN_NORMAL = new int[]{1, 2, 1, 1, 0};
        STARTSERVICE_LM_SCREEN_SPEECH = new int[]{3, 1, 0, 0, 1};
        startservice_lastmode_screenTransferConstraints = new int[][]{STARTSERVICE_LM_SCREEN_NORMAL, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_PHONE, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_NORMAL, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_PHONE, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_NORMAL, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_PHONE, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_NORMAL, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_PHONE, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_SPEECH, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_PHONE, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_SPEECH, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_PHONE, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_SPEECH, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_PHONE, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_SPEECH, STARTSERVICE_LM_SCREEN_RVC, STARTSERVICE_LM_SCREEN_PHONE, STARTSERVICE_LM_SCREEN_RVC};
        STARTSERVICE_LM_AUDIO_PHONE = new int[]{3, 1, 0, 0, 3};
        STARTSERVICE_LM_AUDIO_NORMAL = new int[]{1, 2, 1, 1, 0};
        STARTSERVICE_LM_AUDIO_SPEECH = new int[]{3, 1, 0, 0, 2};
        startservice_lastmode_audioTransferConstraints = new int[][]{STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_PHONE, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_PHONE, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_PHONE, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_PHONE, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_SPEECH, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_PHONE, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_SPEECH, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_PHONE, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_SPEECH, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_PHONE, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_SPEECH, STARTSERVICE_LM_AUDIO_NORMAL, STARTSERVICE_LM_AUDIO_PHONE, STARTSERVICE_LM_AUDIO_NORMAL};
        SCREEN_RVC = new int[]{3, 1, 0, 0, 3};
        SCREEN_PHONE = new int[]{3, 1, 0, 0, 3};
        SCREEN_NORMAL = new int[]{1, 1, 2, 1, 0};
        SCREEN_SPEECH = new int[]{3, 1, 0, 0, 2};
        screenTransferConstraints = new int[][]{SCREEN_NORMAL, SCREEN_RVC, SCREEN_PHONE, SCREEN_RVC, SCREEN_NORMAL, SCREEN_RVC, SCREEN_PHONE, SCREEN_RVC, SCREEN_NORMAL, SCREEN_RVC, SCREEN_PHONE, SCREEN_RVC, SCREEN_NORMAL, SCREEN_RVC, SCREEN_PHONE, SCREEN_RVC, SCREEN_SPEECH, SCREEN_RVC, SCREEN_PHONE, SCREEN_RVC, SCREEN_SPEECH, SCREEN_RVC, SCREEN_PHONE, SCREEN_RVC, SCREEN_SPEECH, SCREEN_RVC, SCREEN_PHONE, SCREEN_RVC, SCREEN_SPEECH, SCREEN_RVC, SCREEN_PHONE, SCREEN_RVC};
        AUDIO_NORMAL = new int[]{1, 1, 2, 1, 0};
        AUDIO_PHONE = new int[]{3, 1, 0, 0, 3};
        AUDIO_SPEECH = new int[]{3, 1, 0, 0, 2};
        audioTransferConstraints = new int[][]{AUDIO_NORMAL, AUDIO_NORMAL, AUDIO_PHONE, AUDIO_NORMAL, AUDIO_NORMAL, AUDIO_NORMAL, AUDIO_PHONE, AUDIO_NORMAL, AUDIO_NORMAL, AUDIO_NORMAL, AUDIO_PHONE, AUDIO_NORMAL, AUDIO_NORMAL, AUDIO_NORMAL, AUDIO_PHONE, AUDIO_NORMAL, AUDIO_SPEECH, AUDIO_NORMAL, AUDIO_PHONE, AUDIO_NORMAL, AUDIO_SPEECH, AUDIO_NORMAL, AUDIO_PHONE, AUDIO_NORMAL, AUDIO_SPEECH, AUDIO_NORMAL, AUDIO_PHONE, AUDIO_NORMAL, AUDIO_SPEECH, AUDIO_NORMAL, AUDIO_PHONE, AUDIO_NORMAL};
    }
}

