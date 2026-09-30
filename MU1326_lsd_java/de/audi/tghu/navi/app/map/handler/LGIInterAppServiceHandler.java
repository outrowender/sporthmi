/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.interapp.navcar.ILGIServiceListener;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.tmc.LocalHazardInformation;

public class LGIInterAppServiceHandler
implements ILGIServiceListener {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final List listeners;
    private final DispatcherBase dispatcher;
    private static final String LGI_NAV_DISPATCHER = "LGINavDispatcher";
    private LocalHazardInformation[] lastReceivedLGIEvents;

    public LGIInterAppServiceHandler(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.listeners = new ArrayList();
        this.dispatcher = navigationEnv.getFramework().getDispatcherManager().createDispatcher(LGI_NAV_DISPATCHER, new JobLogger(this.logChannel));
        this.dispatcher.start();
        this.lastReceivedLGIEvents = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addListener(ILGIServiceListener iLGIServiceListener) {
        if (iLGIServiceListener == null) {
            return;
        }
        List list = this.listeners;
        synchronized (list) {
            if (!this.listeners.contains(iLGIServiceListener)) {
                this.logChannel.log(1000000, "LGIInterAppServiceHandler#addListener() - Register listener");
                this.listeners.add(iLGIServiceListener);
            }
        }
        this.provideLastReceivedUpdate(iLGIServiceListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListener(ILGIServiceListener iLGIServiceListener) {
        if (iLGIServiceListener == null) {
            return;
        }
        List list = this.listeners;
        synchronized (list) {
            if (this.listeners.contains(iLGIServiceListener)) {
                this.logChannel.log(1000000, "LGIInterAppServiceHandler#removeListener() - Unregister listener");
                this.listeners.remove(iLGIServiceListener);
            }
        }
    }

    public void cleanUp() {
        this.logChannel.log(1000000, "LGIInterAppServiceHandler#cleanUp()");
        this.listeners.clear();
        this.dispatcher.stop();
        this.env.getFramework().getDispatcherManager().destroyDispatcher(LGI_NAV_DISPATCHER);
        this.lastReceivedLGIEvents = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateLocalHazardInformation(final LocalHazardInformation[] localHazardInformationArray) {
        ILGIServiceListener[] iLGIServiceListenerArray;
        this.lastReceivedLGIEvents = localHazardInformationArray;
        if (localHazardInformationArray == null) {
            this.logChannel.log(10000, "LGIInterAppServiceHandler#updateLocalHazardInformation() - Invalid parameter set!");
            return;
        }
        List list = this.listeners;
        synchronized (list) {
            iLGIServiceListenerArray = (ILGIServiceListener[])this.listeners.toArray(new ILGIServiceListener[this.listeners.size()]);
        }
        this.logChannel.log(1000000, "LGIInterAppServiceHandler#updateLocalHazardInformation() - events: %1, listeners: %2", (long)localHazardInformationArray.length, (long)iLGIServiceListenerArray.length);
        for (int i2 = 0; i2 < iLGIServiceListenerArray.length; ++i2) {
            try {
                final ILGIServiceListener iLGIServiceListener = iLGIServiceListenerArray[i2];
                this.dispatcher.execute(new Runnable(){

                    public void run() {
                        iLGIServiceListener.updateLocalHazardInformation(localHazardInformationArray);
                    }
                });
                continue;
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "LGIInterAppServiceHandler#updateLocalHazardInformation() - %1", (Throwable)exception);
            }
        }
    }

    private void provideLastReceivedUpdate(final ILGIServiceListener iLGIServiceListener) {
        if (iLGIServiceListener == null) {
            return;
        }
        if (this.lastReceivedLGIEvents == null) {
            this.logChannel.log(1000000, "LGIInterAppServiceHandler#provideLastReceivedUpdate() - Did not receive any update yet");
            return;
        }
        Buffer buffer = new Buffer("LocalHazardInformation");
        Util.appendObjectArray(buffer, this.lastReceivedLGIEvents);
        this.logChannel.log(1000000, "LGIInterAppServiceHandler#provideLastReceivedUpdate() - %1", (Object)buffer);
        try {
            this.dispatcher.execute(new Runnable(){

                public void run() {
                    iLGIServiceListener.updateLocalHazardInformation(LGIInterAppServiceHandler.this.lastReceivedLGIEvents);
                }
            });
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "LGIInterAppServiceHandler#provideLastReceivedUpdate() - %1", (Throwable)exception);
        }
    }
}

