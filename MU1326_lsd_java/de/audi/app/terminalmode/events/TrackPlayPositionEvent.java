/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.esolutions.fw.util.commons.Buffer;

public class TrackPlayPositionEvent {
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

    public TrackPlayPositionEvent(int n, int n2) {
        if (n2 > 0) {
            this.totalTimeOfTrack = n2;
            this.totalTimeStr = TrackPlayPositionEvent.toTimeString(n2, false);
            this.remainTime = this.restrictTimeToMaximumValue(n2 - n);
            this.remainTimeStr = TrackPlayPositionEvent.toTimeString(this.remainTime, true);
            this.restrictedTotalTime = this.restrictTimeToMaximumValue(n2);
            this.restrictedTotalTimeStr = TrackPlayPositionEvent.toTimeString(this.restrictedTotalTime, false);
        } else {
            this.totalTimeOfTrack = 0;
            this.totalTimeStr = EMPTY_PLAYTIME;
            this.remainTime = 0;
            this.remainTimeStr = EMPTY_PLAYTIME;
            this.restrictedTotalTime = 0;
            this.restrictedTotalTimeStr = EMPTY_PLAYTIME;
        }
        this.currentTime = n;
        this.currentTimeStr = TrackPlayPositionEvent.toTimeString(n, false);
        this.currentRestrictedTime = this.restrictTimeToMaximumValue(n);
        this.currentRestrictedTimeStr = TrackPlayPositionEvent.toTimeString(this.currentRestrictedTime, false);
        this.progress = n2 > 0 ? (this.restrictedTotalTime != 0 ? this.currentRestrictedTime * 100 / this.restrictedTotalTime : 0) : 0;
    }

    private int restrictTimeToMaximumValue(int n) {
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
        buffer.append(this.currentTimeStr).append(" - ").append(this.remainTimeStr);
        return buffer.toString();
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.currentTime;
        n = 31 * n + this.totalTimeOfTrack;
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        TrackPlayPositionEvent trackPlayPositionEvent = (TrackPlayPositionEvent)object;
        if (this.currentTime != trackPlayPositionEvent.currentTime) {
            return false;
        }
        return this.totalTimeOfTrack == trackPlayPositionEvent.totalTimeOfTrack;
    }
}

