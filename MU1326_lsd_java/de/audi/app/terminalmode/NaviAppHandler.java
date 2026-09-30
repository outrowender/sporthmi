/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.INavigationStateListener;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;
import java.util.Hashtable;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class NaviAppHandler
extends NaviServiceListener.Stub
implements ITerminalModeComponent {
    private static final String LOGCLASS = "NaviAppHandler";
    private volatile NaviService naviService;
    private volatile IServiceTracker serviceTracker;
    private volatile ServiceRegistration serviceRegistration;
    private volatile INavigationStateListener navigationStateListener;
    private volatile boolean routeGuidanceRunning = false;
    private final IContext context;
    private final LogChannel logger;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviService;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviServiceListener;

    public NaviAppHandler(IContext iContext) {
        this.context = Preconditions.checkNotNull(iContext);
        this.logger = Preconditions.checkNotNull(iContext.getLogger().main());
    }

    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        this.serviceTracker = this.context.getServiceManager().createServiceTracker(class$de$audi$atip$interapp$NaviService == null ? (class$de$audi$atip$interapp$NaviService = NaviAppHandler.class$("de.audi.atip.interapp.NaviService")) : class$de$audi$atip$interapp$NaviService, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                NaviAppHandler.this.naviService = null;
                NaviAppHandler.this.context.getServiceManager().releaseService(serviceReference);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                Object object = NaviAppHandler.this.context.getServiceManager().getService(serviceReference);
                if (!(object instanceof NaviService)) {
                    NaviAppHandler.this.logger.log(1000000, "[%1.addingService] unwanted service", (Object)NaviAppHandler.LOGCLASS);
                    NaviAppHandler.this.context.getServiceManager().releaseService(serviceReference);
                    return object;
                }
                NaviAppHandler.this.naviService = (NaviService)object;
                NaviAppHandler.this.routeGuidanceRunning = NaviAppHandler.this.naviService.getRgActiveStatus();
                return NaviAppHandler.this.naviService;
            }
        });
        this.serviceTracker.open();
        this.serviceRegistration = this.context.getServiceManager().registerService(class$de$audi$atip$interapp$NaviServiceListener == null ? (class$de$audi$atip$interapp$NaviServiceListener = NaviAppHandler.class$("de.audi.atip.interapp.NaviServiceListener")) : class$de$audi$atip$interapp$NaviServiceListener, this, new Hashtable(0));
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.serviceTracker.close();
        if (null != this.serviceRegistration) {
            this.context.getServiceManager().unregisterService(this.serviceRegistration);
        }
    }

    public void setNavigationStateListener(INavigationStateListener iNavigationStateListener) {
        this.navigationStateListener = iNavigationStateListener;
        this.notifyStateChange();
    }

    private void notifyStateChange() {
        if (null != this.navigationStateListener) {
            this.navigationStateListener.stateChanged(this.routeGuidanceRunning);
        }
    }

    public void updateRgActive(boolean bl) {
        this.logger.log(1000000, "[%1.updateRgActive] %2", (Object)LOGCLASS, (Object)String.valueOf(bl));
        this.routeGuidanceRunning = bl;
        this.notifyStateChange();
    }

    public void responseStopRouteGuidance(byte by) {
        this.logger.log(1000000, "[%1.responseStopRouteGuidance]", (Object)LOGCLASS);
        if (0 == by) {
            this.routeGuidanceRunning = false;
            this.notifyStateChange();
        }
    }

    public void responseStartRouteGuidance(byte by) {
        this.logger.log(1000000, "[%1.responseStartRouteGuidance]", (Object)LOGCLASS);
        if (0 == by) {
            this.routeGuidanceRunning = true;
            this.notifyStateChange();
        }
    }

    public void stopRouteGuidance() {
        this.logger.log(1000000, "[%1.stopRouteGuidance]", (Object)LOGCLASS);
        if (null != this.naviService) {
            this.naviService.stopRouteGuidance();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

