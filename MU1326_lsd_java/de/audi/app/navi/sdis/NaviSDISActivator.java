/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.sdis;

import de.audi.app.navi.sdis.NaviASIProvider;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import de.audi.tghu.navi.app.sdis.INaviTabletService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class NaviSDISActivator
extends AbstractActivator {
    private ServiceTracker tracker;
    NaviASIProvider naviAsiProvider;
    private LogChannel log = NullLogChannel.getInstance();
    static /* synthetic */ Class class$de$audi$tghu$navi$app$sdis$INaviTabletService;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$sdis$INaviTabletServiceListener;
    static /* synthetic */ Class class$de$audi$atip$agent$IASIProvider;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.log = this.getFramework().getLogChannel("App.Navi.SDIS");
        this.naviAsiProvider = new NaviASIProvider(this.log);
        this.tracker = new ServiceTracker(bundleContext, (class$de$audi$tghu$navi$app$sdis$INaviTabletService == null ? (class$de$audi$tghu$navi$app$sdis$INaviTabletService = NaviSDISActivator.class$("de.audi.tghu.navi.app.sdis.INaviTabletService")) : class$de$audi$tghu$navi$app$sdis$INaviTabletService).getName(), (ServiceTrackerCustomizer)new MyServiceTracker());
        this.tracker.open();
        this.registerService((class$de$audi$tghu$navi$app$sdis$INaviTabletServiceListener == null ? (class$de$audi$tghu$navi$app$sdis$INaviTabletServiceListener = NaviSDISActivator.class$("de.audi.tghu.navi.app.sdis.INaviTabletServiceListener")) : class$de$audi$tghu$navi$app$sdis$INaviTabletServiceListener).getName(), (Object)this.naviAsiProvider.naviTabletServiceListener, null);
        this.registerService((class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = NaviSDISActivator.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName(), (Object)this.naviAsiProvider, null);
    }

    public void stop(BundleContext bundleContext) {
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
        super.stop(bundleContext);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class MyServiceTracker
    implements ServiceTrackerCustomizer {
        private MyServiceTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            NaviSDISActivator.this.log.log(1000000, "Adding service: %1", (Object)serviceReference);
            Object object = null;
            try {
                object = NaviSDISActivator.this.bundleContext.getService(serviceReference);
                if (object instanceof INaviTabletService) {
                    NaviSDISActivator.this.log.log(1000000, "Adding ASIHandler: %1", object);
                    NaviSDISActivator.this.naviAsiProvider.setTabletService((INaviTabletService)object);
                    return object;
                }
            }
            catch (Exception exception) {
                NaviSDISActivator.this.log.log(1000000, "Adding Service failed: %1", (Object)serviceReference, (Throwable)exception);
            }
            if (object != null) {
                NaviSDISActivator.this.bundleContext.ungetService(serviceReference);
            }
            return null;
        }

        public void modifiedService(ServiceReference serviceReference, Object object) {
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            NaviSDISActivator.this.log.log(1000000, "Removed service: %1 %2", (Object)serviceReference, object);
            try {
                NaviSDISActivator.this.bundleContext.ungetService(serviceReference);
                if (object instanceof INaviTabletService) {
                    NaviSDISActivator.this.log.log(1000000, "Removed ASIHandler: %1", object);
                    NaviSDISActivator.this.naviAsiProvider.setTabletService(null);
                }
            }
            catch (Exception exception) {
                NaviSDISActivator.this.log.log(1000000, "Removed Service failed: %1", (Object)serviceReference, (Throwable)exception);
            }
        }
    }
}

