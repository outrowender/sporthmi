/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sse;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIBase;
import org.dsi.ifc.sse.DSISSE;

public class NullDSISSE
extends NullDSIBase
implements DSISSE {
    public NullDSISSE(LogChannel logChannel) {
        super(logChannel, "DSISSE");
    }

    public void requestSetMode(int n) {
        this.log("requestSetMode");
    }

    public void requestStartProcessing() {
        this.log("requestStartProcessing");
    }

    public void requestSetMicGainLevel(int n) {
        this.log("requestSetMicGainLevel");
    }

    public void requestSetMicMuteState(int n) {
        this.log("requestSetMicMuteState");
    }
}

