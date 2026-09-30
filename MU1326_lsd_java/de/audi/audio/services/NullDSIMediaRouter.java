/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.services;

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

    public void registerClient(int n, String string, String string2) {
        this.log("registerClient");
    }

    public void unregisterClient(int n) {
        this.log("unregisterClient");
    }

    public void startStreaming(int n) {
        this.log("startStreaming");
    }

    public void stopStreaming(int n) {
        this.log("stopStreaming");
    }

    public void requestConfiguration(int n, int n2, int n3, int n4) {
        this.log("requestConfiguration");
    }

    public void setAudioRoutes(AudioRoute[] audioRouteArray) {
        this.log("setAudioRoutes");
    }
}

