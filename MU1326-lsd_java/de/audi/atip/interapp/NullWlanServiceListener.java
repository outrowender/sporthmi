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

    @Override
    public void updateWlanState(boolean bl) {
        this.lc.log(1078071040, "NullWlanServiceListener#updateWlanState(): enabled=%1", bl);
    }

    @Override
    public void updateNumberOfClients(int n) {
        this.lc.log(1078071040, "NullWlanServiceListener#updateNumberOfClients(): numberOfClients=%1", (long)n);
    }
}

