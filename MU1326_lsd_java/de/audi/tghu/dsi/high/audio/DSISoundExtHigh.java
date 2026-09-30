/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.dsi.high.audio;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.dsi.audio.DSISoundExt;

public class DSISoundExtHigh
extends DSISoundExt {
    public DSISoundExtHigh(LogChannel logChannel) {
        super(logChannel);
    }

    public void setMicGainLevel(int n) {
        this.lc.log(10000000, "[DSISoundExtHigh.setMicGainLevel] micGainLevel:%1", (long)n);
        this.dsi.setMicGainLevel(n);
    }
}

