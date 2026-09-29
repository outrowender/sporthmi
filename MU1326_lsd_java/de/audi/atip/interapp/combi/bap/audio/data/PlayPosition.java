/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio.data;

import de.audi.atip.interapp.bap.data.TimeStamp;
import de.audi.atip.interapp.combi.bap.audio.data.PlayPosition$Builder;

public final class PlayPosition {
    private final TimeStamp timePosition;
    private final TimeStamp totalPlayTime;
    private final boolean isVariableBitRate;

    public static PlayPosition$Builder builder() {
        return new PlayPosition$Builder();
    }

    private PlayPosition(TimeStamp timeStamp, TimeStamp timeStamp2, boolean bl) {
        this.timePosition = timeStamp;
        this.totalPlayTime = timeStamp2;
        this.isVariableBitRate = bl;
    }

    public TimeStamp getTimePosition() {
        return this.timePosition;
    }

    public TimeStamp getTotalPlayTime() {
        return this.totalPlayTime;
    }

    public boolean isVariableBitRate() {
        return this.isVariableBitRate;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        PlayPosition playPosition = (PlayPosition)object;
        if (this.isVariableBitRate != playPosition.isVariableBitRate) {
            return false;
        }
        if (this.timePosition == null ? playPosition.timePosition != null : !this.timePosition.equals(playPosition.timePosition)) {
            return false;
        }
        return !(this.totalPlayTime == null ? playPosition.totalPlayTime != null : !this.totalPlayTime.equals(playPosition.totalPlayTime));
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.isVariableBitRate ? 1231 : 1237);
        n = 31 * n + (this.timePosition == null ? 0 : this.timePosition.hashCode());
        n = 31 * n + (this.totalPlayTime == null ? 0 : this.totalPlayTime.hashCode());
        return n;
    }

    public String toString() {
        return new StringBuffer().append("PlayPosition [timePosition=").append(this.timePosition).append(", totalPlayTime=").append(this.totalPlayTime).append(", isVariableBitRate=").append(this.isVariableBitRate).append("]").toString();
    }
}

