/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.app;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.exlap.ExlapException;
import de.audi.tghu.exlap.ExlapUtil;
import de.audi.tghu.exlap.app.ExlapExlapServiceImpl;
import de.audi.tghu.exlap.app.ExlapHandler;
import de.audi.tghu.exlap.app.ExlapHandlerImpl;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.exlap.DSIExlap;
import org.dsi.ifc.has.DSIHAS;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ExlapActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    protected LogChannel log;
    private ServiceRegistration serviceRegistrationHas;
    private ServiceRegistration serviceRegistrationExlap;
    private ServiceTracker tracker;
    private DSIHAS dsiHas;
    private DSIExlap dsiExlap;
    private ExlapHandler exlapHandler;
    private boolean exlapStarted = false;
    static /* synthetic */ Class class$org$dsi$ifc$has$DSIHAS;
    static /* synthetic */ Class class$org$dsi$ifc$exlap$DSIExlap;
    static /* synthetic */ Class class$org$dsi$ifc$has$DSIHASListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$exlap$DSIExlapListener;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.log = this.framework.getLogChannel("App.Exlap.Main");
        this.log.log(1078071040, "ExlapActivator#start(): bundleContext: %1", (Object)bundleContext);
        this.exlapHandler = new ExlapHandlerImpl(bundleContext, this.framework);
        this.initTracker();
        this.registerHasListener(this.exlapHandler);
        this.registerExlapListener(this.exlapHandler);
        boolean bl = this.framework.startDSIService((class$org$dsi$ifc$has$DSIHAS == null ? (class$org$dsi$ifc$has$DSIHAS = ExlapActivator.class$("org.dsi.ifc.has.DSIHAS")) : class$org$dsi$ifc$has$DSIHAS).getName(), 0);
        if (!bl) {
            this.deinit();
            throw new ExlapException("needed DSIHAS service not available.");
        }
        boolean bl2 = this.framework.startDSIService((class$org$dsi$ifc$exlap$DSIExlap == null ? (class$org$dsi$ifc$exlap$DSIExlap = ExlapActivator.class$("org.dsi.ifc.exlap.DSIExlap")) : class$org$dsi$ifc$exlap$DSIExlap).getName(), 0);
        if (!bl2) {
            this.deinit();
            throw new ExlapException("needed DSIExlap service not available.");
        }
        int n = ExlapUtil.readExlapStatus(this.framework);
        this.exlapHandler.setExlapStatus(ExlapUtil.convertExlapStatus(n));
    }

    private synchronized void deinit() {
        if (this.log != null) {
            this.log.log(1078071040, "[ExlapActivator.deinit()] stopping ExlapActivator");
            this.log = null;
        }
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
        if (this.serviceRegistrationExlap != null) {
            this.serviceRegistrationExlap.unregister();
            this.serviceRegistrationExlap = null;
        }
        if (this.serviceRegistrationHas != null) {
            this.serviceRegistrationHas.unregister();
            this.serviceRegistrationHas = null;
        }
        if (this.dsiHas != null) {
            this.dsiHas = null;
        }
        if (this.dsiExlap != null) {
            this.dsiExlap = null;
        }
        if (this.exlapHandler != null) {
            this.exlapHandler.deinit();
            this.exlapHandler = null;
        }
        this.exlapStarted = false;
    }

    private void registerHasListener(ExlapHandler exlapHandler) {
        Hashtable hashtable = new Hashtable();
        ((Dictionary)hashtable).put("DEVICE_INSTANCE", new Integer(0));
        ((Dictionary)hashtable).put("DEVICE_NAME", (class$org$dsi$ifc$has$DSIHASListener == null ? (class$org$dsi$ifc$has$DSIHASListener = ExlapActivator.class$("org.dsi.ifc.has.DSIHASListener")) : class$org$dsi$ifc$has$DSIHASListener).getName());
        this.serviceRegistrationHas = this.bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = ExlapActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)exlapHandler, (Dictionary)hashtable);
        this.log.log(1078071040, "ExlapActivator#registerHasListener(): HAS Listener registered");
    }

    private void registerExlapListener(ExlapHandler exlapHandler) {
        Hashtable hashtable = new Hashtable();
        ((Dictionary)hashtable).put("DEVICE_INSTANCE", new Integer(0));
        ((Dictionary)hashtable).put("DEVICE_NAME", (class$org$dsi$ifc$exlap$DSIExlapListener == null ? (class$org$dsi$ifc$exlap$DSIExlapListener = ExlapActivator.class$("org.dsi.ifc.exlap.DSIExlapListener")) : class$org$dsi$ifc$exlap$DSIExlapListener).getName());
        this.serviceRegistrationExlap = this.bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = ExlapActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)exlapHandler, (Dictionary)hashtable);
        this.log.log(1078071040, "ExlapActivator#registerExlapListener(): Exlap Listener registered");
    }

    private void initTracker() {
        String[] stringArray = new String[]{(class$org$dsi$ifc$has$DSIHAS == null ? (class$org$dsi$ifc$has$DSIHAS = ExlapActivator.class$("org.dsi.ifc.has.DSIHAS")) : class$org$dsi$ifc$has$DSIHAS).getName(), (class$org$dsi$ifc$exlap$DSIExlap == null ? (class$org$dsi$ifc$exlap$DSIExlap = ExlapActivator.class$("org.dsi.ifc.exlap.DSIExlap")) : class$org$dsi$ifc$exlap$DSIExlap).getName()};
        this.tracker = new ServiceTracker(this.bundleContext, stringArray, (ServiceTrackerCustomizer)this);
        this.tracker.open();
        this.log.log(1078071040, "ExlapActivator#initTracker(): Exlap tracker opened");
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.deinit();
        super.stop(bundleContext);
    }

    public synchronized void checkServices() {
        if (!this.exlapStarted && this.dsiExlap != null && this.dsiHas != null) {
            ExlapExlapServiceImpl exlapExlapServiceImpl = new ExlapExlapServiceImpl();
            this.exlapHandler.init(this.dsiHas, this.dsiExlap, exlapExlapServiceImpl);
            this.exlapStarted = true;
            this.log.log(1078071040, "ExlapActivator#checkServices(): ExlapHandler initialized");
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof DSIExlap) {
            this.log.log(1078071040, "ExlapActivator#addingService(): Exlap service received");
            this.dsiExlap = (DSIExlap)object;
            this.checkServices();
            return this.dsiExlap;
        }
        if (object instanceof DSIHAS) {
            this.log.log(1078071040, "ExlapActivator#addingService(): HAS service received");
            this.dsiHas = (DSIHAS)object;
            this.checkServices();
            return this.dsiHas;
        }
        this.bundleContext.ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object == this.dsiExlap) {
            this.dsiExlap = null;
        } else if (object == this.dsiHas) {
            this.dsiHas = null;
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

