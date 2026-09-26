/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.dsi;

import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.interapp.audio.ATIPMediaRouterServiceListener;
import de.audi.atip.interapp.def.ATIPAudioRouteImpl;
import de.audi.audio.AudioEnv;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.media.AudioRoute;
import org.dsi.ifc.media.DSIMediaRouterListener;

public class DSIMediaRouterListenerImpl
implements DSIMediaRouterListener {
    private final List listeners;
    private final Object listMutex;
    private final AudioEnv env;

    public DSIMediaRouterListenerImpl(AudioEnv audioEnv) {
        this.env = audioEnv;
        this.listeners = new ArrayList();
        this.listMutex = new Object();
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void responseConfiguration(int n, int n2) {
    }

    @Override
    public void responseClientStatus(int n, int n2) {
    }

    @Override
    public void updateStreamingStatus(int n, int n2, int n3) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateActiveAudioRoutes(AudioRoute[] audioRouteArray, int n) {
        this.env.lcDSI.log(1078071040, "[DSIMediaRouterListenerImpl.updateActiveAudioRoutes] validFlag: %1", (long)n);
        if (n == 1) {
            Object object;
            ATIPAudioRoute[] aTIPAudioRouteArray = new ATIPAudioRoute[audioRouteArray.length];
            for (int i2 = 0; i2 < aTIPAudioRouteArray.length; ++i2) {
                object = audioRouteArray[i2];
                if (object == null) {
                    object = new AudioRoute();
                }
                aTIPAudioRouteArray[i2] = new ATIPAudioRouteImpl(((AudioRoute)object).getRoutingInput(), ((AudioRoute)object).getRoutingOutput(), ((AudioRoute)object).getRouteStatus());
            }
            Object object2 = this.listMutex;
            synchronized (object2) {
                object = this.listeners.iterator();
                while (object.hasNext()) {
                    ((ATIPMediaRouterServiceListener)object.next()).updateActiveAudioRoutes(aTIPAudioRouteArray);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addATIPMediaRouterServiceListener(ATIPMediaRouterServiceListener aTIPMediaRouterServiceListener) {
        Object object = this.listMutex;
        synchronized (object) {
            this.listeners.add(aTIPMediaRouterServiceListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeATIPMediaRouterServiceListener(ATIPMediaRouterServiceListener aTIPMediaRouterServiceListener) {
        Object object = this.listMutex;
        synchronized (object) {
            this.listeners.remove(aTIPMediaRouterServiceListener);
        }
    }
}

