/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.osgi;

import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.osgi.ServiceTrackerImpl;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ServiceManagerImpl
implements IServiceManager {
    private static final String LOGCLASS = "ServiceManagerImpl";
    private final BundleContext osgiBundleContext;
    private final IFrameworkAccess framework;
    private final LogChannel logger;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    public ServiceManagerImpl(BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        if (bundleContext == null || iFrameworkAccess == null) {
            throw new IllegalArgumentException();
        }
        this.logger = iFrameworkAccess.getLogChannel("App.Media.OSGI");
        this.osgiBundleContext = bundleContext;
        this.framework = iFrameworkAccess;
    }

    public IServiceTracker createServiceTracker(Class clazz, ServiceTrackerCustomizer serviceTrackerCustomizer) {
        if (clazz == null || serviceTrackerCustomizer == null) {
            throw new IllegalArgumentException();
        }
        return new ServiceTrackerImpl(this.osgiBundleContext, clazz, serviceTrackerCustomizer);
    }

    public ServiceReference[] getServiceReferences(Class clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException();
        }
        try {
            return this.osgiBundleContext.getServiceReferences(clazz.getName(), null);
        }
        catch (Exception exception) {
            this.logger.log(100000, "[%1.getServiceReferences] %2.", (Object)LOGCLASS, (Throwable)exception);
            return new ServiceReference[0];
        }
    }

    public final ServiceRegistration registerService(Class clazz, Object object, Dictionary dictionary) {
        if (clazz == null || object == null || dictionary == null) {
            throw new IllegalArgumentException();
        }
        this.logger.log(10000000, "[%1.registerService] '%2'.", (Object)LOGCLASS, (Object)ServiceManagerImpl.getClassnameWithoutPackage(clazz.getName()));
        return this.osgiBundleContext.registerService(clazz.getName(), object, dictionary);
    }

    public void unregisterService(ServiceRegistration serviceRegistration) {
        try {
            serviceRegistration.unregister();
        }
        catch (NullPointerException nullPointerException) {
            throw new IllegalArgumentException();
        }
    }

    public final ServiceRegistration registerDSIListener(int n, String string, DSIListener dSIListener) {
        this.logger.log(1000000, "[%1.registerDSIListener] [%2,%3]", (Object)LOGCLASS, (Object)ServiceManagerImpl.getClassnameWithoutPackage(string), (long)n);
        if (string == null || dSIListener == null) {
            throw new IllegalArgumentException();
        }
        Hashtable hashtable = new Hashtable(2);
        ((Dictionary)hashtable).put("DEVICE_NAME", string);
        ((Dictionary)hashtable).put("DEVICE_INSTANCE", new Integer(n));
        return this.registerService(class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = ServiceManagerImpl.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener, dSIListener, hashtable);
    }

    public Object getService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            throw new IllegalArgumentException();
        }
        return this.osgiBundleContext.getService(serviceReference);
    }

    public void releaseService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            throw new IllegalArgumentException();
        }
        this.osgiBundleContext.ungetService(serviceReference);
    }

    public boolean startDSIService(String string, int n) {
        this.logger.log(1000000, "[%1.startDSIService] [%2,%3]", (Object)LOGCLASS, (Object)ServiceManagerImpl.getClassnameWithoutPackage(string), (long)n);
        return this.framework.startDSIService(string, n);
    }

    public void stopDSIService(String string, int n) {
        this.logger.log(1000000, "[%1.stopDSIService] [%2,%3]", (Object)LOGCLASS, (Object)ServiceManagerImpl.getClassnameWithoutPackage(string), (long)n);
        this.framework.stopDSIService(string, n);
    }

    private static String getClassnameWithoutPackage(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return string.substring(string.lastIndexOf(46) + 1);
    }

    public IFrameworkAccess getFrameworkAccess() {
        return this.framework;
    }

    public BundleContext getBundleContext() {
        return this.osgiBundleContext;
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

