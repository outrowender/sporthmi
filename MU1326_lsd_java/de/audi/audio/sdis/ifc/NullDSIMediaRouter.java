/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.ifc;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIBase;
import org.dsi.ifc.media.AudioRoute;
import org.dsi.ifc.media.DSIMediaRouter;

public class NullDSIMediaRouter
extends NullDSIBase
implements DSIMediaRouter {
    public NullDSIMediaRouter(LogChannel logChannel) {
        super(logChannel, "DSIMediaRouter");
    }

    @Override
    public void registerClient(int n, String string, String string2) {
        this.log("registerClient");
    }

    @Override
    public void unregisterClient(int n) {
        this.log("unregisterClient");
    }

    @Override
    public void startStreaming(int n) {
        this.log("startStreaming");
    }

    @Override
    public void stopStreaming(int n) {
        this.log("stopStreaming");
    }

    @Override
    public void requestConfiguration(int n, int n2, int n3, int n4) {
        this.log("requestConfiguration");
    }

    @Override
    public void setAudioRoutes(AudioRoute[] audioRouteArray) {
        this.log("setAudioRoutes");
    }
}

