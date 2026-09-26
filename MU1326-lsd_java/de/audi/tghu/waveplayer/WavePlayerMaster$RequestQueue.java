/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.waveplayer;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.WavePlayerMaster$Request;
import java.util.ArrayList;
import java.util.List;

class WavePlayerMaster$RequestQueue {
    LogChannel lc;
    private final List list = new ArrayList(10);

    public WavePlayerMaster$RequestQueue(LogChannel logChannel) {
        this.lc = logChannel;
    }

    void add(WavePlayerMaster$Request wavePlayerMaster$Request) {
        this.lc.log(-2137614336, "WavePlayerMaster.RequestQueue.add(%1) called", (Object)wavePlayerMaster$Request);
        this.list.add(wavePlayerMaster$Request);
    }

    WavePlayerMaster$Request get() {
        this.lc.log(-2137614336, "WavePlayerMaster.RequestQueue.get() called");
        if (!this.list.isEmpty()) {
            WavePlayerMaster$Request wavePlayerMaster$Request = (WavePlayerMaster$Request)this.list.get(0);
            this.lc.log(-2137614336, "WavePlayerMaster.RequestQueue.get() request.id: %1", (long)wavePlayerMaster$Request.id);
            return wavePlayerMaster$Request;
        }
        return null;
    }

    WavePlayerMaster$Request remove() {
        this.lc.log(-2137614336, "WavePlayerMaster.RequestQueue.remove() called");
        if (!this.list.isEmpty()) {
            return (WavePlayerMaster$Request)this.list.remove(0);
        }
        return null;
    }

    void clear() {
        this.lc.log(-2137614336, "WavePlayerMaster.RequestQueue.clear() called");
        this.list.clear();
    }
}

