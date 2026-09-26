/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.interapp.audio.ATIPMediaRouterServiceListener;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullATIPMediaRouterServiceListener
extends NullService
implements ATIPMediaRouterServiceListener {
    public NullATIPMediaRouterServiceListener(LogChannel logChannel) {
        super(logChannel, "NullATIPMediaRouterServiceListener");
    }

    @Override
    public void updateActiveAudioRoutes(ATIPAudioRoute[] aTIPAudioRouteArray) {
        this.log("updateActiveAudioRoutes");
    }
}

