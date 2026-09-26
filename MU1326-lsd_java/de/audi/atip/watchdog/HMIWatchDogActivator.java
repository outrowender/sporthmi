/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.watchdog;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.watchdog.HMIWatchDog;
import de.audi.atip.watchdog.HMIWatchDogActivator$1;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class HMIWatchDogActivator
extends AbstractFrameworkActivator {
    private static final String DSI_WATCHDOG_CLASS = (class$org$dsi$ifc$system$DSIHMIWatchDog == null ? (class$org$dsi$ifc$system$DSIHMIWatchDog = HMIWatchDogActivator.class$("org.dsi.ifc.system.DSIHMIWatchDog")) : class$org$dsi$ifc$system$DSIHMIWatchDog).getName();
    private LogChannel log;
    private HMIWatchDog instance;
    private ServiceRegistration sRegDSIWatchDog;
    private ServiceTracker tracker;
    static /* synthetic */ Class class$org$dsi$ifc$system$DSIHMIWatchDog;
    static /* synthetic */ Class class$org$dsi$ifc$system$DSIHMIWatchDogListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    public HMIWatchDogActivator() {
        super("HMIWatchDog");
    }

    public HMIWatchDog getService() {
        return this.instance;
    }

    @Override
    protected void startInternal(BundleContext bundleContext) {
        this.log = this.framework.getLogChannel("Fw.WatchDog");
        this.instance = new HMIWatchDog(this.framework);
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$system$DSIHMIWatchDogListener == null ? (class$org$dsi$ifc$system$DSIHMIWatchDogListener = HMIWatchDogActivator.class$("org.dsi.ifc.system.DSIHMIWatchDogListener")) : class$org$dsi$ifc$system$DSIHMIWatchDogListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.sRegDSIWatchDog = bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = HMIWatchDogActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.instance, (Dictionary)hashtable);
        this.initTracker();
        this.framework.startDSIService((class$org$dsi$ifc$system$DSIHMIWatchDog == null ? (class$org$dsi$ifc$system$DSIHMIWatchDog = HMIWatchDogActivator.class$("org.dsi.ifc.system.DSIHMIWatchDog")) : class$org$dsi$ifc$system$DSIHMIWatchDog).getName(), 0);
        this.instance.setReady();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.sRegDSIWatchDog != null) {
            this.sRegDSIWatchDog.unregister();
            this.sRegDSIWatchDog = null;
        }
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
        super.stop(bundleContext);
    }

    private void initTracker() {
        this.tracker = new ServiceTracker(this.bundleContext, DSI_WATCHDOG_CLASS, (ServiceTrackerCustomizer)new HMIWatchDogActivator$1(this));
        this.tracker.open();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(HMIWatchDogActivator hMIWatchDogActivator) {
        return hMIWatchDogActivator.log;
    }

    static /* synthetic */ BundleContext access$100(HMIWatchDogActivator hMIWatchDogActivator) {
        return hMIWatchDogActivator.bundleContext;
    }

    static /* synthetic */ String access$200() {
        return DSI_WATCHDOG_CLASS;
    }

    static /* synthetic */ HMIWatchDog access$300(HMIWatchDogActivator hMIWatchDogActivator) {
        return hMIWatchDogActivator.instance;
    }

    static /* synthetic */ BundleContext access$400(HMIWatchDogActivator hMIWatchDogActivator) {
        return hMIWatchDogActivator.bundleContext;
    }
}

