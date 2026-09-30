/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.esolutions.fw.util.commons.Buffer;

public class PlayTime {
    public static final int INVALID = -1;
    private static final int MAX_TIME_VALUE_SECONDS = 59999;
    private final int restrictedTotalTime;
    private final String restrictedTotalTimeStr;
    private final int totalTimeOfTrack;
    private final String totalTimeStr;
    private final int remainTime;
    private final String remainTimeStr;
    private final int currentTime;
    private final String currentTimeStr;
    private final int currentRestrictedTime;
    private final String currentRestrictedTimeStr;
    private final int progress;
    public static final String EMPTY_PLAYTIME = "-:-";
    public static final int EMPTY_PROGRESS = 0;
    public static final int INVALID_PLAYTIME = 0;

    public PlayTime(int n, int n2) {
        if (n2 > 0) {
            this.totalTimeOfTrack = n2;
            this.totalTimeStr = PlayTime.toTimeString(n2, false);
            this.remainTime = PlayTime.restrictTimeToMaximumValue(n2 - n);
            this.remainTimeStr = PlayTime.toTimeString(this.remainTime, true);
            this.restrictedTotalTime = PlayTime.restrictTimeToMaximumValue(n2);
            this.restrictedTotalTimeStr = PlayTime.toTimeString(this.restrictedTotalTime, false);
        } else {
            this.totalTimeOfTrack = 0;
            this.totalTimeStr = EMPTY_PLAYTIME;
            this.remainTime = 0;
            this.remainTimeStr = EMPTY_PLAYTIME;
            this.restrictedTotalTime = 0;
            this.restrictedTotalTimeStr = EMPTY_PLAYTIME;
        }
        this.currentTime = n;
        this.currentTimeStr = PlayTime.toTimeString(n, false);
        this.currentRestrictedTime = PlayTime.restrictTimeToMaximumValue(n);
        this.currentRestrictedTimeStr = PlayTime.toTimeString(this.currentRestrictedTime, false);
        this.progress = n2 > 0 ? (this.restrictedTotalTime != 0 ? this.currentRestrictedTime * 100 / this.restrictedTotalTime : 0) : 0;
    }

    private static int restrictTimeToMaximumValue(int n) {
        if (n > 59999) {
            return 59999;
        }
        return n;
    }

    public int getRestrictedTotalTime() {
        return this.restrictedTotalTime;
    }

    public String getTotalTimeStr() {
        return this.totalTimeStr;
    }

    public int getTotalTimeOfTrack() {
        return this.totalTimeOfTrack;
    }

    public String getRestrictedTotalTimeStr() {
        return this.restrictedTotalTimeStr;
    }

    public int getPlayTime() {
        return this.currentTime;
    }

    public String getPlayTimeStr() {
        return this.currentTimeStr;
    }

    public int getRestrictedPlayTime() {
        return this.currentRestrictedTime;
    }

    public String getRestrictedPlayTimeStr() {
        return this.currentRestrictedTimeStr;
    }

    public int getRemainTime() {
        return this.remainTime;
    }

    public String getRemainTimeStr() {
        return this.remainTimeStr;
    }

    public int getProgress() {
        return this.progress;
    }

    public static String toTimeString(long l, boolean bl) {
        long l2 = l / 60L;
        long l3 = l % 60L;
        Buffer buffer = new Buffer(7);
        if (bl) {
            buffer.append("-");
        }
        buffer.append(l2);
        buffer.append(":");
        if (l3 < 10L) {
            buffer.append("0");
        }
        buffer.append(l3);
        return buffer.toString();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(this.currentTimeStr).append(":").append(this.remainTimeStr);
        return buffer.toString();
    }
}

