/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.dsi.audio;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSISound;
import org.dsi.ifc.audio.DSISound;

public abstract class DSISoundExt {
    protected final LogChannel lc;
    protected DSISound dsi;

    public DSISoundExt(LogChannel logChannel) {
        this.lc = logChannel;
        this.dsi = new NullDSISound(logChannel, 10000000);
    }

    public void register(DSISound dSISound) {
        this.lc.log(10000000, "[DSISoundExt.register] %1", (Object)dSISound);
        this.dsi = dSISound;
    }

    public abstract void setMicGainLevel(int var1);
}

