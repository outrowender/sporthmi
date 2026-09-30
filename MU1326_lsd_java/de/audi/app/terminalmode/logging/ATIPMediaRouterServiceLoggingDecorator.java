/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.logging.Arrays2;
import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.interapp.audio.ATIPMediaRouterService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.media.DSIMediaRouter;

public class ATIPMediaRouterServiceLoggingDecorator
implements ATIPMediaRouterService {
    private ATIPMediaRouterService wrappee;
    private final LogChannel lc;
    private final int level;

    public ATIPMediaRouterServiceLoggingDecorator(ATIPMediaRouterService aTIPMediaRouterService, LogChannel logChannel, int n) {
        this.wrappee = aTIPMediaRouterService;
        this.lc = logChannel;
        this.level = n;
    }

    public void setAudioRoutes(ATIPAudioRoute[] aTIPAudioRouteArray) {
        this.lc.log(this.level, "-> [ATIPMediaRouterService.setAudioRoutes] %1", (Object)Arrays2.toString(aTIPAudioRouteArray));
        this.wrappee.setAudioRoutes(aTIPAudioRouteArray);
    }

    public void setDSIMediaRouter(DSIMediaRouter dSIMediaRouter) {
        this.lc.log(this.level, "-> [ATIPMediaRouterService.setDSIMediaRouter] %1", (Object)dSIMediaRouter);
        this.wrappee.setDSIMediaRouter(dSIMediaRouter);
    }
}

