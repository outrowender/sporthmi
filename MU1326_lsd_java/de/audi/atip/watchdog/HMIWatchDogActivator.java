/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.watchdog;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.watchdog.HMIWatchDog;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.system.DSIHMIWatchDog;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
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
        this.tracker = new ServiceTracker(this.bundleContext, DSI_WATCHDOG_CLASS, new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                try {
                    String string = (String)serviceReference.getProperty("DEVICE_NAME");
                    Object object = serviceReference.getProperty("DEVICE_INSTANCE");
                    int n = 0;
                    if (object instanceof Integer) {
                        n = (Integer)object;
                    }
                    HMIWatchDogActivator.this.log.log(10000000, "HMIWatchDogActivator.addingService( %1, %2 )", (Object)string, (long)n);
                    Object object2 = HMIWatchDogActivator.this.bundleContext.getService(serviceReference);
                    if (DSI_WATCHDOG_CLASS.equals(string) && n == 0) {
                        HMIWatchDogActivator.this.log.log(1000000, "DSIHMIWatchDog is available!", (Object)string, (long)n);
                        HMIWatchDogActivator.this.instance.setDSI((DSIHMIWatchDog)object2);
                    }
                    return object2;
                }
                catch (Exception exception) {
                    HMIWatchDogActivator.this.log.log(100000, "DomainActivator.addingService failed", (Throwable)exception);
                    return null;
                }
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                HMIWatchDogActivator.this.log.log(10000000, "HMIWatchDogActivator.removedService( %1 )", (Object)serviceReference);
                HMIWatchDogActivator.this.bundleContext.ungetService(serviceReference);
                HMIWatchDogActivator.this.instance.setDSI(null);
            }
        });
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
}

