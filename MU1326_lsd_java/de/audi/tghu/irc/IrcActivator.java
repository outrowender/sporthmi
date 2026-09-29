/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.irc;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.tghu.irc.InfotainmentrecorderImpl;
import org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class IrcActivator
extends AbstractFrameworkActivator
implements ServiceTrackerCustomizer {
    private static BundleContext bundleContext;
    private ServiceTracker dsiTracker;
    private InfotainmentrecorderImpl irc;
    static /* synthetic */ Class class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder;

    public IrcActivator() {
        super("IrcActivator");
    }

    public InfotainmentrecorderImpl getService() {
        return this.irc;
    }

    @Override
    protected void startInternal(BundleContext bundleContext) {
        IrcActivator.bundleContext = bundleContext;
        this.irc = new InfotainmentrecorderImpl(this.framework);
        this.dsiTracker = new ServiceTracker(IrcActivator.bundleContext, (class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder == null ? (class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder = IrcActivator.class$("org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder")) : class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder).getName(), (ServiceTrackerCustomizer)this);
        this.dsiTracker.open();
        this.framework.startDSIService((class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder == null ? (class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder = IrcActivator.class$("org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder")) : class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder).getName(), 0);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.dsiTracker != null) {
            this.dsiTracker.close();
            this.dsiTracker = null;
        }
        super.stop(bundleContext);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = bundleContext.getService(serviceReference);
        if (!(object instanceof DSIInfotainmentRecorder)) {
            return null;
        }
        this.irc.setDsi((DSIInfotainmentRecorder)object);
        return serviceReference;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.irc.setDsi(null);
        bundleContext.ungetService(serviceReference);
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

