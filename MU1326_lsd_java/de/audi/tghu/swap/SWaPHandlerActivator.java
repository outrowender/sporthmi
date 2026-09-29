/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swap;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.base.FwServices;
import de.audi.atip.log.LogChannel;
import de.audi.atip.swap.SWaPEventListener;
import de.audi.atip.swap.SWaPHandler;
import de.audi.tghu.swap.SWaPHandlerImpl;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.swap.DSISWaP;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SWaPHandlerActivator
extends AbstractFrameworkActivator
implements ServiceTrackerCustomizer {
    private ServiceTracker tracker;
    private FwServices fwService;
    private SWaPHandlerImpl swapHandler;
    private ServiceRegistration sRegSWaP;
    private LogChannel log;
    static /* synthetic */ Class class$org$dsi$ifc$swap$DSISWaPListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$swap$DSISWaP;
    static /* synthetic */ Class class$de$audi$atip$swap$SWaPEventListener;

    public SWaPHandlerActivator(FwServices fwServices) {
        super("FwSWaPDSI");
        this.fwService = fwServices;
    }

    public SWaPHandler getService() {
        return this.swapHandler;
    }

    @Override
    protected void startInternal(BundleContext bundleContext) {
        this.log = this.framework.getLogChannel("Fw.SWaP.Activator");
        this.swapHandler = new SWaPHandlerImpl(this.framework);
        Hashtable hashtable = new Hashtable();
        ((Dictionary)hashtable).put("DEVICE_NAME", (class$org$dsi$ifc$swap$DSISWaPListener == null ? (class$org$dsi$ifc$swap$DSISWaPListener = SWaPHandlerActivator.class$("org.dsi.ifc.swap.DSISWaPListener")) : class$org$dsi$ifc$swap$DSISWaPListener).getName());
        ((Dictionary)hashtable).put("DEVICE_INSTANCE", new Integer(0));
        this.sRegSWaP = bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = SWaPHandlerActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.swapHandler, (Dictionary)hashtable);
        String[] stringArray = new String[]{(class$org$dsi$ifc$swap$DSISWaP == null ? (class$org$dsi$ifc$swap$DSISWaP = SWaPHandlerActivator.class$("org.dsi.ifc.swap.DSISWaP")) : class$org$dsi$ifc$swap$DSISWaP).getName(), (class$de$audi$atip$swap$SWaPEventListener == null ? (class$de$audi$atip$swap$SWaPEventListener = SWaPHandlerActivator.class$("de.audi.atip.swap.SWaPEventListener")) : class$de$audi$atip$swap$SWaPEventListener).getName()};
        this.tracker = new ServiceTracker(this.bundleContext, stringArray, (ServiceTrackerCustomizer)this);
        this.tracker.open();
        this.framework.startDSIService((class$org$dsi$ifc$swap$DSISWaP == null ? (class$org$dsi$ifc$swap$DSISWaP = SWaPHandlerActivator.class$("org.dsi.ifc.swap.DSISWaP")) : class$org$dsi$ifc$swap$DSISWaP).getName(), 0);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.sRegSWaP != null) {
            this.sRegSWaP.unregister();
            this.sRegSWaP = null;
        }
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
        this.log = null;
        super.stop(bundleContext);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof DSISWaP) {
            this.log.log(1078071040, "Setting DSI Service=%1", object);
            this.swapHandler.setDSI((DSISWaP)object);
        } else if (object instanceof SWaPEventListener) {
            this.log.log(1078071040, "Adding Service=%1", object);
            this.swapHandler.addListener((SWaPEventListener)object);
        } else {
            this.log.log(10000, "track unwanted service=%1", object);
            this.getBundleContext().ungetService(serviceReference);
            return null;
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof SWaPEventListener) {
            this.log.log(1078071040, "Removing Service=%1", object);
            this.swapHandler.removeListener((SWaPEventListener)object);
        }
        this.bundleContext.ungetService(serviceReference);
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

