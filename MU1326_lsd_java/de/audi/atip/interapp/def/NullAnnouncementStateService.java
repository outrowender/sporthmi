/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.audio.IAnnouncementStateService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullAnnouncementStateService
extends NullService
implements IAnnouncementStateService {
    public NullAnnouncementStateService(LogChannel logChannel) {
        super(logChannel, "AnnouncementStateService");
    }

    @Override
    public void setAnnouncementState(int n) {
        this.log("setAnnouncementState");
    }
}

