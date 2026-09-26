/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.sdis;

import de.audi.app.navi.sdis.NaviASIProvider;
import de.audi.app.navi.sdis.NaviSDISActivator$MyServiceTracker;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import org.osgi.framework.BundleContext;
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

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.log = this.getFramework().getLogChannel("App.Navi.SDIS");
        this.naviAsiProvider = new NaviASIProvider(this.log);
        this.tracker = new ServiceTracker(bundleContext, (class$de$audi$tghu$navi$app$sdis$INaviTabletService == null ? (class$de$audi$tghu$navi$app$sdis$INaviTabletService = NaviSDISActivator.class$("de.audi.tghu.navi.app.sdis.INaviTabletService")) : class$de$audi$tghu$navi$app$sdis$INaviTabletService).getName(), (ServiceTrackerCustomizer)new NaviSDISActivator$MyServiceTracker(this, null));
        this.tracker.open();
        this.registerService((class$de$audi$tghu$navi$app$sdis$INaviTabletServiceListener == null ? (class$de$audi$tghu$navi$app$sdis$INaviTabletServiceListener = NaviSDISActivator.class$("de.audi.tghu.navi.app.sdis.INaviTabletServiceListener")) : class$de$audi$tghu$navi$app$sdis$INaviTabletServiceListener).getName(), (Object)this.naviAsiProvider.naviTabletServiceListener, null);
        this.registerService((class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = NaviSDISActivator.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName(), (Object)this.naviAsiProvider, null);
    }

    @Override
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

    static /* synthetic */ LogChannel access$100(NaviSDISActivator naviSDISActivator) {
        return naviSDISActivator.log;
    }

    static /* synthetic */ BundleContext access$200(NaviSDISActivator naviSDISActivator) {
        return naviSDISActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$300(NaviSDISActivator naviSDISActivator) {
        return naviSDISActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$400(NaviSDISActivator naviSDISActivator) {
        return naviSDISActivator.bundleContext;
    }
}

