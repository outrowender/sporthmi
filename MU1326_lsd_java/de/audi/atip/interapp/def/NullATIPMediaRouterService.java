/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.interapp.audio.ATIPMediaRouterService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.media.DSIMediaRouter;

public class NullATIPMediaRouterService
extends NullService
implements ATIPMediaRouterService {
    public NullATIPMediaRouterService(LogChannel logChannel, String string) {
        super(logChannel, "ATIPMediaRouterService");
    }

    public void setAudioRoutes(ATIPAudioRoute[] aTIPAudioRouteArray) {
        this.log("setAudioRoutes");
    }

    public void setDSIMediaRouter(DSIMediaRouter dSIMediaRouter) {
        this.log("setService");
    }
}

