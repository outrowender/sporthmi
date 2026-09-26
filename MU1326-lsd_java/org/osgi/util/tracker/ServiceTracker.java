/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.util.tracker;

import de.dreisoft.lsd.BundleInfo;
import de.dreisoft.lsd.LSDWatchdog;
import de.dreisoft.lsd.ServiceFilter;
import java.util.Enumeration;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker$AlarmHandler;
import org.osgi.util.tracker.ServiceTracker$LSDFramework;
import org.osgi.util.tracker.ServiceTracker$Tracked;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ServiceTracker
implements ServiceTrackerCustomizer {
    private static final boolean DEBUG;
    private static final LSDWatchdog WATCHDOG;
    private ServiceTracker$AlarmHandler alarmHandler = new ServiceTracker$AlarmHandler(this, null);
    protected final BundleContext context;
    private ServiceTracker$Tracked tracked;
    private ServiceTrackerCustomizer customizer;
    private String[] svcInterfaces;
    private ServiceFilter svcFilter;

    public ServiceTracker(BundleContext bundleContext, ServiceReference serviceReference, ServiceTrackerCustomizer serviceTrackerCustomizer) {
        throw new UnsupportedOperationException("ServiceTracker constructor with service reference not supported");
    }

    public ServiceTracker(BundleContext bundleContext, String string, ServiceTrackerCustomizer serviceTrackerCustomizer) {
        if (string == null) {
            throw new IllegalArgumentException("no class specified");
        }
        this.context = bundleContext;
        this.customizer = serviceTrackerCustomizer == null ? this : serviceTrackerCustomizer;
        this.svcInterfaces = new String[]{string};
    }

    public ServiceTracker(BundleContext bundleContext, String[] stringArray, ServiceTrackerCustomizer serviceTrackerCustomizer) {
        if (stringArray == null) {
            throw new IllegalArgumentException("no class specified");
        }
        this.context = bundleContext;
        this.customizer = serviceTrackerCustomizer == null ? this : serviceTrackerCustomizer;
        this.svcInterfaces = stringArray;
    }

    public ServiceTracker(BundleContext bundleContext, Filter filter, ServiceTrackerCustomizer serviceTrackerCustomizer) {
        if (filter == null) {
            throw new IllegalArgumentException("no filter specified");
        }
        this.context = bundleContext;
        ServiceTrackerCustomizer serviceTrackerCustomizer2 = this.customizer = serviceTrackerCustomizer == null ? this : serviceTrackerCustomizer;
        if (!(filter instanceof ServiceFilter)) {
            throw new IllegalArgumentException("Filter must be created by BundleContext.createFilter(String)");
        }
        this.svcFilter = (ServiceFilter)filter;
        this.svcInterfaces = this.svcFilter.getServiceInterfaces();
        if (this.svcFilter.isServiceInterfaceList()) {
            this.svcFilter = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void open() {
        if (this.tracked == null) {
            ServiceTracker$Tracked serviceTracker$Tracked = this.tracked = new ServiceTracker$Tracked(this);
            synchronized (serviceTracker$Tracked) {
                ServiceTracker$LSDFramework.getServiceRegistry().addObserver(this.tracked);
            }
        }
    }

    public synchronized void close() {
        if (this.tracked != null) {
            this.tracked.close();
            ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
            this.tracked = null;
            ServiceTracker$LSDFramework.getServiceRegistry().removeObserver(serviceTracker$Tracked);
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        return this.context.getService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.context.ungetService(serviceReference);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object waitForService(long l) {
        if (l < 0L) {
            throw new IllegalArgumentException("timeout value is negative");
        }
        Object object = this.getService();
        while (object == null) {
            ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
            if (serviceTracker$Tracked == null) {
                return null;
            }
            ServiceTracker$Tracked serviceTracker$Tracked2 = serviceTracker$Tracked;
            synchronized (serviceTracker$Tracked2) {
                if (serviceTracker$Tracked.size() == 0) {
                    super.wait(l);
                }
            }
            object = this.getService();
            if (l <= 0L) continue;
            return object;
        }
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ServiceReference[] getServiceReferences() {
        ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
        if (serviceTracker$Tracked == null) {
            return null;
        }
        ServiceTracker$Tracked serviceTracker$Tracked2 = serviceTracker$Tracked;
        synchronized (serviceTracker$Tracked2) {
            int n = serviceTracker$Tracked.size();
            if (n == 0) {
                return null;
            }
            ServiceReference[] serviceReferenceArray = new ServiceReference[n];
            Enumeration enumeration = serviceTracker$Tracked.keys();
            for (int i2 = 0; i2 < n; ++i2) {
                serviceReferenceArray[i2] = (ServiceReference)enumeration.nextElement();
            }
            return serviceReferenceArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object[] getServices() {
        ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
        if (serviceTracker$Tracked == null) {
            return null;
        }
        ServiceTracker$Tracked serviceTracker$Tracked2 = serviceTracker$Tracked;
        synchronized (serviceTracker$Tracked2) {
            int n = serviceTracker$Tracked.size();
            if (n == 0) {
                return null;
            }
            Object[] objectArray = new Object[n];
            Enumeration enumeration = serviceTracker$Tracked.elements();
            for (int i2 = 0; i2 < n; ++i2) {
                objectArray[i2] = enumeration.nextElement();
            }
            return objectArray;
        }
    }

    public ServiceReference getServiceReference() {
        int n;
        ServiceReference[] serviceReferenceArray = this.getServiceReferences();
        int n2 = n = serviceReferenceArray == null ? 0 : serviceReferenceArray.length;
        if (n > 0) {
            int n3 = 0;
            if (n > 1) {
                int n4;
                int[] nArray = new int[n];
                int n5 = 0;
                int n6 = 128;
                for (int i2 = 0; i2 < n; ++i2) {
                    Object object = serviceReferenceArray[i2].getProperty("service.ranking");
                    nArray[i2] = n4 = object instanceof Integer ? (Integer)object : 0;
                    if (n4 > n6) {
                        n3 = i2;
                        n6 = n4;
                        n5 = 1;
                        continue;
                    }
                    if (n4 != n6) continue;
                    ++n5;
                }
                if (n5 > 1) {
                    long l = Long.MAX_VALUE;
                    for (n4 = 0; n4 < n; ++n4) {
                        long l2;
                        if (nArray[n4] != n6 || (l2 = ((Long)serviceReferenceArray[n4].getProperty("service.id")).longValue()) >= l) continue;
                        n3 = n4;
                        l = l2;
                    }
                }
            }
            return serviceReferenceArray[n3];
        }
        return null;
    }

    public Object getService(ServiceReference serviceReference) {
        ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
        if (serviceTracker$Tracked == null) {
            return null;
        }
        return serviceTracker$Tracked.get(serviceReference);
    }

    public Object getService() {
        ServiceReference serviceReference = this.getServiceReference();
        if (serviceReference != null) {
            return this.getService(serviceReference);
        }
        return null;
    }

    public void remove(ServiceReference serviceReference) {
        ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
        if (serviceTracker$Tracked == null) {
            return;
        }
        try {
            serviceTracker$Tracked.untrack(serviceReference);
        }
        catch (Exception exception) {
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("exception removing service from ServiceTrackerCustomizer of bundle ");
            stringBuffer.append(" '").append(((BundleInfo)this.context).getBundleName()).append("' ");
            ServiceTracker$LSDFramework.getLogService().log(serviceReference, 1, stringBuffer.toString(), exception);
        }
    }

    public int size() {
        ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
        if (serviceTracker$Tracked == null) {
            return 0;
        }
        return serviceTracker$Tracked.size();
    }

    public int getTrackingCount() {
        ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
        if (serviceTracker$Tracked == null) {
            return -1;
        }
        return serviceTracker$Tracked.getTrackingCount();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append('[').append(((BundleInfo)this.context.getBundle()).getBundleName()).append("] Tracker( ");
        for (int i2 = 0; i2 < this.svcInterfaces.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append("Interface=");
            stringBuffer.append(this.svcInterfaces[i2]);
        }
        if (this.svcInterfaces.length > 0) {
            stringBuffer.append(", ");
        }
        if (this.svcFilter != null) {
            stringBuffer.append("Filter=");
            stringBuffer.append(this.svcFilter);
        }
        stringBuffer.append(" )");
        return stringBuffer.toString();
    }

    static /* synthetic */ String[] access$100(ServiceTracker serviceTracker) {
        return serviceTracker.svcInterfaces;
    }

    static /* synthetic */ ServiceFilter access$200(ServiceTracker serviceTracker) {
        return serviceTracker.svcFilter;
    }

    static /* synthetic */ ServiceTracker$AlarmHandler access$300(ServiceTracker serviceTracker) {
        return serviceTracker.alarmHandler;
    }

    static /* synthetic */ LSDWatchdog access$400() {
        return WATCHDOG;
    }

    static /* synthetic */ ServiceTrackerCustomizer access$500(ServiceTracker serviceTracker) {
        return serviceTracker.customizer;
    }

    static {
        WATCHDOG = new LSDWatchdog("Tracker");
        LSDWatchdog.startWatchdog(WATCHDOG);
    }
}

