/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.onlinelogo;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.onlinelogo.IOnlineLogoProvider;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class OnlineLogoActivator
extends AbstractFrameworkActivator
implements ServiceTrackerCustomizer {
    IOnlineLogoProvider service = null;
    private ServiceTracker tracker;
    private final BundleContext bundleContext;
    private final LogChannel log;
    static /* synthetic */ Class class$de$audi$atip$onlinelogo$IOnlineLogoProvider;

    public OnlineLogoActivator(IFrameworkAccess iFrameworkAccess) {
        super("FwLogoProvider");
        this.bundleContext = iFrameworkAccess.getBundleCxt();
        this.log = iFrameworkAccess.getLogChannel("App.Online.Main");
        this.log.log(1078071040, "OnlineLogoActivator#OnlineLogoActivator()");
    }

    public IOnlineLogoProvider getService() {
        this.log.log(1078071040, "OnlineLogoActivator#getService()");
        return this.service;
    }

    @Override
    protected void startInternal(BundleContext bundleContext) {
        this.log.log(1078071040, "OnlineLogoActivator#startInternal()");
        this.tracker = new ServiceTracker(this.bundleContext, new String[]{(class$de$audi$atip$onlinelogo$IOnlineLogoProvider == null ? (class$de$audi$atip$onlinelogo$IOnlineLogoProvider = OnlineLogoActivator.class$("de.audi.atip.onlinelogo.IOnlineLogoProvider")) : class$de$audi$atip$onlinelogo$IOnlineLogoProvider).getName()}, (ServiceTrackerCustomizer)this);
        this.tracker.open();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.log.log(1078071040, "OnlineLogoActivator#addingService()");
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IOnlineLogoProvider) {
            this.service = (IOnlineLogoProvider)object;
            return object;
        }
        return null;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.log.log(1078071040, "OnlineLogoActivator#removedService()");
        if (object instanceof IOnlineLogoProvider) {
            this.service = null;
        }
        this.bundleContext.ungetService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
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

