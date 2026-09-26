/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio.data;

import de.audi.atip.interapp.bap.data.TimeStamp;
import de.audi.atip.interapp.combi.bap.audio.data.PlayPosition;

public final class PlayPosition$Builder {
    private TimeStamp timePosition;
    private TimeStamp totalPlayTime;
    private boolean isVariableBitRate;

    public PlayPosition$Builder setTimePosition(TimeStamp timeStamp) {
        this.timePosition = timeStamp;
        return this;
    }

    public PlayPosition$Builder setTotalPlayTime(TimeStamp timeStamp) {
        this.totalPlayTime = timeStamp;
        return this;
    }

    public PlayPosition$Builder setVariableBitRate(boolean bl) {
        this.isVariableBitRate = bl;
        return this;
    }

    public PlayPosition build() {
        return new PlayPosition(this.timePosition, this.totalPlayTime, this.isVariableBitRate);
    }
}

