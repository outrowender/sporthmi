/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.activator;

import de.audi.atip.activator.FrameworkException;
import de.audi.atip.base.IFrameworkAccess;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractActivator
implements BundleActivator {
    private static final String MNFST_HDR_BUNDLE_NAME = "Bundle-Name";
    private static final String BUNDLE_NAME_UNKNOWN = "???";
    private static final Dictionary EMPTY_DICTIONARY = new Hashtable();
    protected BundleContext bundleContext = null;
    protected IFrameworkAccess framework = null;
    private List serviceRegistrations = new LinkedList();
    static /* synthetic */ Class class$de$audi$atip$base$IFrameworkAccess;

    public void start(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$audi$atip$base$IFrameworkAccess == null ? (class$de$audi$atip$base$IFrameworkAccess = AbstractActivator.class$("de.audi.atip.base.IFrameworkAccess")) : class$de$audi$atip$base$IFrameworkAccess).getName());
        if (serviceReference != null) {
            this.framework = (IFrameworkAccess)bundleContext.getService(serviceReference);
        }
        if (this.framework == null) {
            throw new FrameworkException(new StringBuffer().append("Framework service not available, starting of ").append(this.getName()).append(" aborted").toString());
        }
    }

    private void removeService(ServiceRegistration serviceRegistration) {
        block3: {
            if (serviceRegistration != null) {
                try {
                    serviceRegistration.unregister();
                }
                catch (Exception exception) {
                    if (this.framework == null) break block3;
                    this.framework.getLogChannel("Fw.Startup").log(10000, "unregistering Service %1 failed!", (Object)serviceRegistration, (Throwable)exception);
                }
            }
        }
    }

    public void stop(BundleContext bundleContext) {
        for (int i2 = this.serviceRegistrations.size() - 1; i2 >= 0; --i2) {
            this.removeService((ServiceRegistration)this.serviceRegistrations.get(i2));
            this.serviceRegistrations.remove(i2);
        }
        if (this.framework != null) {
            bundleContext.ungetService(bundleContext.getServiceReference((class$de$audi$atip$base$IFrameworkAccess == null ? (class$de$audi$atip$base$IFrameworkAccess = AbstractActivator.class$("de.audi.atip.base.IFrameworkAccess")) : class$de$audi$atip$base$IFrameworkAccess).getName()));
            this.framework = null;
        }
    }

    public final BundleContext getBundleContext() {
        return this.bundleContext;
    }

    public final IFrameworkAccess getFramework() {
        return this.framework;
    }

    public String getName() {
        String string;
        try {
            string = (String)this.bundleContext.getBundle().getHeaders().get(MNFST_HDR_BUNDLE_NAME);
            if (string == null) {
                string = BUNDLE_NAME_UNKNOWN;
            }
        }
        catch (Exception exception) {
            string = BUNDLE_NAME_UNKNOWN;
        }
        return string;
    }

    public void registerService(String string, Object object, Dictionary dictionary) {
        this.serviceRegistrations.add(this.bundleContext.registerService(string, object, dictionary));
    }

    protected void registerService(Class clazz, Object object) {
        this.serviceRegistrations.add(this.bundleContext.registerService(clazz.getName(), object, EMPTY_DICTIONARY));
    }

    public void registerService(String[] stringArray, Object object, Dictionary dictionary) {
        this.serviceRegistrations.add(this.bundleContext.registerService(stringArray, object, dictionary));
    }

    public void registerDSIListener(String string, Object object, String string2, int n) {
        Hashtable hashtable = new Hashtable(8);
        hashtable.put("DEVICE_NAME", string2);
        hashtable.put("DEVICE_INSTANCE", new Integer(n));
        this.serviceRegistrations.add(this.bundleContext.registerService(string, object, (Dictionary)hashtable));
    }

    protected ServiceTracker openTracker(Class clazz, ServiceTrackerCustomizer serviceTrackerCustomizer) {
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, clazz.getName(), serviceTrackerCustomizer);
        serviceTracker.open();
        return serviceTracker;
    }

    public ServiceTracker closeTracker(ServiceTracker serviceTracker) {
        if (serviceTracker != null) {
            serviceTracker.close();
        }
        return null;
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

