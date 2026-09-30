/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio;

import de.audi.atip.interapp.audio.ATIPAudioRoute;
import org.dsi.ifc.media.DSIMediaRouter;

public interface ATIPMediaRouterService {
    public void setAudioRoutes(ATIPAudioRoute[] var1);

    public void setDSIMediaRouter(DSIMediaRouter var1);
}

