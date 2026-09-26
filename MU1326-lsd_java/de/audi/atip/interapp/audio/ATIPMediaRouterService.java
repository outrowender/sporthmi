/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio;

import de.audi.atip.interapp.audio.ATIPAudioRoute;
import org.dsi.ifc.media.DSIMediaRouter;

public interface ATIPMediaRouterService {
    default public void setAudioRoutes(ATIPAudioRoute[] aTIPAudioRouteArray) {
    }

    default public void setDSIMediaRouter(DSIMediaRouter dSIMediaRouter) {
    }
}

