/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.services;

import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.interapp.audio.ATIPMediaRouterService;
import de.audi.atip.interapp.def.ATIPAudioRouteImpl;
import de.audi.audio.AudioEnv;
import de.audi.audio.services.NullDSIMediaRouter;
import org.dsi.ifc.media.AudioRoute;
import org.dsi.ifc.media.DSIMediaRouter;

public class ATIPMediaRouterServiceImpl
implements ATIPMediaRouterService {
    private DSIMediaRouter dsiMediaRouter;
    private final AudioEnv env;

    public ATIPMediaRouterServiceImpl(AudioEnv audioEnv) {
        this.env = audioEnv;
        this.dsiMediaRouter = new NullDSIMediaRouter(audioEnv.lcDSI);
    }

    public void setAudioRoutes(ATIPAudioRoute[] aTIPAudioRouteArray) {
        AudioRoute[] audioRouteArray = new AudioRoute[aTIPAudioRouteArray.length];
        for (int i2 = 0; i2 < audioRouteArray.length; ++i2) {
            ATIPAudioRoute aTIPAudioRoute = aTIPAudioRouteArray[i2];
            if (aTIPAudioRoute == null) {
                aTIPAudioRoute = new ATIPAudioRouteImpl();
            }
            int n = aTIPAudioRoute.getRoutingInput();
            int n2 = aTIPAudioRoute.getRoutingOutput();
            int n3 = aTIPAudioRoute.getRouteStatus();
            audioRouteArray[i2] = new AudioRoute(n, n2, n3);
            this.env.lcMain.log(10000000, "[ATIPMediaRouterServiceImpl.setAudioRoutes] input %1 output: %2, status: %3", (long)n, (long)n2, (long)n3);
        }
        this.dsiMediaRouter.setAudioRoutes(audioRouteArray);
    }

    public void setDSIMediaRouter(DSIMediaRouter dSIMediaRouter) {
        if (dSIMediaRouter instanceof DSIMediaRouter) {
            this.env.lcMain.log(10000000, "[ATIPMediaRouterServiceImpl.setService] DSIMediaRouter registered");
            this.dsiMediaRouter = dSIMediaRouter;
        }
    }
}

