/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.dsi.audio;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.dsi.audio.DSISoundExt;

public class NullDSISoundExt
extends DSISoundExt {
    public NullDSISoundExt(LogChannel logChannel) {
        super(logChannel);
    }

    @Override
    public void setMicGainLevel(int n) {
        this.lc.log(-1601830656, "[NullDSISoundExt.setMicGainLevel]");
    }
}

