/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.osgi;

import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.logging.ILoggingDecoratorFactory;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.app.terminalmode.osgi.ServiceTrackerImpl;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
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
    private final ILoggingDecoratorFactory loggingDecoratorFactory;
    private final List registeredServices;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    public ServiceManagerImpl(BundleContext bundleContext, TerminalModeLoggingDecoratorFactory terminalModeLoggingDecoratorFactory, IFrameworkAccess iFrameworkAccess, ITerminalLogger iTerminalLogger) {
        this.logger = iTerminalLogger.osgi();
        this.osgiBundleContext = bundleContext;
        this.framework = iFrameworkAccess;
        this.loggingDecoratorFactory = terminalModeLoggingDecoratorFactory;
        this.registeredServices = new ArrayList();
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
            return new ServiceReference[0];
        }
    }

    public final ServiceRegistration registerService(Class clazz, Object object, Dictionary dictionary) {
        if (clazz == null || object == null || dictionary == null) {
            throw new IllegalArgumentException();
        }
        this.logger.log(10000000, "[%1.registerService] '%2'.", (Object)LOGCLASS, (Object)this.getClassnameWithoutPackage(clazz.getName()));
        final ServiceRegistration serviceRegistration = this.osgiBundleContext.registerService(clazz.getName(), object, dictionary);
        this.registeredServices.add(serviceRegistration);
        return new ServiceRegistration(){

            public void unregister() {
                ServiceManagerImpl.this.registeredServices.remove(serviceRegistration);
                serviceRegistration.unregister();
            }

            public void setProperties(Dictionary dictionary) {
                serviceRegistration.setProperties(dictionary);
            }

            public ServiceReference getReference() {
                return serviceRegistration.getReference();
            }
        };
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
        this.logger.log(100000000, "[%1.registerDSIListener] [%2,%3]", (Object)LOGCLASS, (Object)this.getClassnameWithoutPackage(string), (long)n);
        if (string == null || dSIListener == null) {
            throw new IllegalArgumentException();
        }
        Object object = this.loggingDecoratorFactory.wrap(string, (Object)dSIListener);
        Hashtable hashtable = new Hashtable(2);
        ((Dictionary)hashtable).put("DEVICE_NAME", string);
        ((Dictionary)hashtable).put("DEVICE_INSTANCE", new Integer(n));
        return this.registerService(class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = ServiceManagerImpl.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener, object, hashtable);
    }

    public Object getService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            throw new IllegalArgumentException();
        }
        String[] stringArray = (String[])serviceReference.getProperty("objectClass");
        if (stringArray.length == 1) {
            return this.loggingDecoratorFactory.wrap(stringArray[0], this.osgiBundleContext.getService(serviceReference));
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
        this.logger.log(100000000, "[%1.startDSIService] [%2,%3]", (Object)LOGCLASS, (Object)this.getClassnameWithoutPackage(string), (long)n);
        return this.framework.startDSIService(string, n);
    }

    private String getClassnameWithoutPackage(String string) {
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

    public void cleanup() {
        Iterator iterator = this.registeredServices.iterator();
        while (iterator.hasNext()) {
            ((ServiceRegistration)iterator.next()).unregister();
        }
        this.registeredServices.clear();
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

