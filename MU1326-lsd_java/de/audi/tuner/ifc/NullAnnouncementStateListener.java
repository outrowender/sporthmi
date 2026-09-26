/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.atip.interapp.audio.IAnnouncementStateListener;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullAnnouncementStateListener
extends NullService
implements IAnnouncementStateListener {
    public NullAnnouncementStateListener(LogChannel logChannel) {
        super(logChannel, "IAnnouncementStateListener");
    }

    @Override
    public void updateAnnouncementState(int n, int n2) {
        this.log();
    }
}

