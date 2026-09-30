/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.ann.AnnouncementHandler;

public final class TunerConfiguration {
    public static final int FM_STATION_LIST_SIZE = 200;
    public static final int UNI_STATION_LIST_SIZE = 200;
    private static final int TIME_RADIO_TEXT_TIMER_DAB = 30000;
    public static final long TIME_AF_DISPLAY_FREEZE = 30000L;
    public static final int MAX_RECENTS = 30;
    public static final int HISTORY_ADD_TIMEOUT = 10000;
    private static boolean dABDoubleTuner = Utilities.isHigh();
    private static boolean aMDoubleTuner = Utilities.isHigh() || Utilities.isNARBuild();
    public static final int TAGGING_LIST_SIZE = 50;

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
}

