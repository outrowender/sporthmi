/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.WlanServiceListener;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullWlanServiceListener
extends NullService
implements WlanServiceListener {
    public NullWlanServiceListener(LogChannel logChannel) {
        super(logChannel, "WlanServiceListener");
    }

    public void updateWlanState(boolean bl) {
        this.lc.log(1000000, "NullWlanServiceListener#updateWlanState(): enabled=%1", bl);
    }

    public void updateNumberOfClients(int n) {
        this.lc.log(1000000, "NullWlanServiceListener#updateNumberOfClients(): numberOfClients=%1", (long)n);
    }
}

