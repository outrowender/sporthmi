/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.interapp.audio.ATIPMediaRouterService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.media.DSIMediaRouter;

public class NullMediaRouterService
implements ATIPMediaRouterService {
    private static final String LOGCLASS;
    private final LogChannel logger;

    public NullMediaRouterService(LogChannel logChannel) {
        this.logger = logChannel;
    }

    @Override
    public void setAudioRoutes(ATIPAudioRoute[] aTIPAudioRouteArray) {
        this.logger.log(1078071040, "[%1.setAudioRoutes]", (Object)"NullMediaRouterService");
    }

    @Override
    public void setDSIMediaRouter(DSIMediaRouter dSIMediaRouter) {
        this.logger.log(1078071040, "[%1.setDSIMediaRouter]", (Object)"NullMediaRouterService");
    }
}

