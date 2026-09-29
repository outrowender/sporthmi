/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.ann.AnnouncementHandler;

public final class TunerConfiguration {
    public static final int FM_STATION_LIST_SIZE;
    public static final int UNI_STATION_LIST_SIZE;
    private static final int TIME_RADIO_TEXT_TIMER_DAB;
    public static final long TIME_AF_DISPLAY_FREEZE;
    public static final int MAX_RECENTS;
    public static final int HISTORY_ADD_TIMEOUT;
    private static boolean dABDoubleTuner;
    private static boolean aMDoubleTuner;
    public static final int TAGGING_LIST_SIZE;

    private TunerConfiguration() {
    }

    public static boolean isDABDoubleTuner() {
        return dABDoubleTuner;
    }

    public static synchronized int getDefaultAnnouncementFilter() {
        if (Utilities.isSinglePiMode()) {
            return AnnouncementHandler.getAlarmMask();
        }
        return 0;
    }

    public static boolean isAMDoubleTuner() {
        return aMDoubleTuner;
    }

    static int getTimeIntervallRadioTextTimerDab() {
        return 30000;
    }

    static {
        dABDoubleTuner = Utilities.isHigh();
        aMDoubleTuner = Utilities.isHigh() || Utilities.isNARBuild();
    }
}

