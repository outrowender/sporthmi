/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.Preconditions
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.INavigationStateListener;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.NaviAppHandler$1;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NaviServiceListener$Stub;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class NaviAppHandler
extends NaviServiceListener$Stub
implements ITerminalModeComponent {
    private static final String LOGCLASS;
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
        this.context = (IContext)Preconditions.checkNotNull((Object)iContext);
        this.logger = (LogChannel)Preconditions.checkNotNull((Object)iContext.getLogger().main());
    }

    @Override
    public void init() {
        this.logger.log(14808325, "[%1.init]", (Object)"NaviAppHandler");
        this.serviceTracker = this.context.getServiceManager().createServiceTracker(class$de$audi$atip$interapp$NaviService == null ? (class$de$audi$atip$interapp$NaviService = NaviAppHandler.class$("de.audi.atip.interapp.NaviService")) : class$de$audi$atip$interapp$NaviService, new NaviAppHandler$1(this));
        this.serviceTracker.open();
        this.serviceRegistration = this.context.getServiceManager().registerService(class$de$audi$atip$interapp$NaviServiceListener == null ? (class$de$audi$atip$interapp$NaviServiceListener = NaviAppHandler.class$("de.audi.atip.interapp.NaviServiceListener")) : class$de$audi$atip$interapp$NaviServiceListener, this, new Hashtable(0));
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"NaviAppHandler");
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

    @Override
    public void updateRgActive(boolean bl) {
        this.logger.log(1078071040, "[%1.updateRgActive] %2", (Object)"NaviAppHandler", (Object)String.valueOf(bl));
        this.routeGuidanceRunning = bl;
        this.notifyStateChange();
    }

    @Override
    public void responseStopRouteGuidance(byte by) {
        this.logger.log(1078071040, "[%1.responseStopRouteGuidance]", (Object)"NaviAppHandler");
        if (0 == by) {
            this.routeGuidanceRunning = false;
            this.notifyStateChange();
        }
    }

    @Override
    public void responseStartRouteGuidance(byte by) {
        this.logger.log(1078071040, "[%1.responseStartRouteGuidance]", (Object)"NaviAppHandler");
        if (0 == by) {
            this.routeGuidanceRunning = true;
            this.notifyStateChange();
        }
    }

    public void stopRouteGuidance() {
        this.logger.log(1078071040, "[%1.stopRouteGuidance]", (Object)"NaviAppHandler");
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

    static /* synthetic */ NaviService access$002(NaviAppHandler naviAppHandler, NaviService naviService) {
        naviAppHandler.naviService = naviService;
        return naviAppHandler.naviService;
    }

    static /* synthetic */ IContext access$100(NaviAppHandler naviAppHandler) {
        return naviAppHandler.context;
    }

    static /* synthetic */ LogChannel access$200(NaviAppHandler naviAppHandler) {
        return naviAppHandler.logger;
    }

    static /* synthetic */ boolean access$302(NaviAppHandler naviAppHandler, boolean bl) {
        naviAppHandler.routeGuidanceRunning = bl;
        return naviAppHandler.routeGuidanceRunning;
    }

    static /* synthetic */ NaviService access$000(NaviAppHandler naviAppHandler) {
        return naviAppHandler.naviService;
    }
}

