/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.util.tracker;

import de.dreisoft.lsd.BundleInfo;
import de.dreisoft.lsd.LSDWatchdog;
import de.dreisoft.lsd.ServiceFilter;
import de.dreisoft.lsd.ServiceInfo;
import de.dreisoft.lsd.ServiceObserver;
import de.dreisoft.lsd.ServiceRegistry;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ServiceTracker
implements ServiceTrackerCustomizer {
    private static final boolean DEBUG = false;
    private static final LSDWatchdog WATCHDOG = new LSDWatchdog("Tracker");
    private AlarmHandler alarmHandler = new AlarmHandler();
    protected final BundleContext context;
    private Tracked tracked;
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
            Tracked tracked = this.tracked = new Tracked();
            synchronized (tracked) {
                LSDFramework.getServiceRegistry().addObserver(this.tracked);
            }
        }
    }

    public synchronized void close() {
        if (this.tracked != null) {
            this.tracked.close();
            Tracked tracked = this.tracked;
            this.tracked = null;
            LSDFramework.getServiceRegistry().removeObserver(tracked);
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        return this.context.getService(serviceReference);
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        this.context.ungetService(serviceReference);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object waitForService(long l) throws InterruptedException {
        if (l < 0L) {
            throw new IllegalArgumentException("timeout value is negative");
        }
        Object object = this.getService();
        while (object == null) {
            Tracked tracked = this.tracked;
            if (tracked == null) {
                return null;
            }
            Tracked tracked2 = tracked;
            synchronized (tracked2) {
                if (tracked.size() == 0) {
                    tracked.wait(l);
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
        Tracked tracked = this.tracked;
        if (tracked == null) {
            return null;
        }
        Tracked tracked2 = tracked;
        synchronized (tracked2) {
            int n = tracked.size();
            if (n == 0) {
                return null;
            }
            ServiceReference[] serviceReferenceArray = new ServiceReference[n];
            Enumeration enumeration = tracked.keys();
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
        Tracked tracked = this.tracked;
        if (tracked == null) {
            return null;
        }
        Tracked tracked2 = tracked;
        synchronized (tracked2) {
            int n = tracked.size();
            if (n == 0) {
                return null;
            }
            Object[] objectArray = new Object[n];
            Enumeration enumeration = tracked.elements();
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
                int n6 = Integer.MIN_VALUE;
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
        Tracked tracked = this.tracked;
        if (tracked == null) {
            return null;
        }
        return tracked.get(serviceReference);
    }

    public Object getService() {
        ServiceReference serviceReference = this.getServiceReference();
        if (serviceReference != null) {
            return this.getService(serviceReference);
        }
        return null;
    }

    public void remove(ServiceReference serviceReference) {
        Tracked tracked = this.tracked;
        if (tracked == null) {
            return;
        }
        try {
            tracked.untrack(serviceReference);
        }
        catch (Exception exception) {
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("exception removing service from ServiceTrackerCustomizer of bundle ");
            stringBuffer.append(" '").append(((BundleInfo)this.context).getBundleName()).append("' ");
            LSDFramework.getLogService().log(serviceReference, 1, stringBuffer.toString(), exception);
        }
    }

    public int size() {
        Tracked tracked = this.tracked;
        if (tracked == null) {
            return 0;
        }
        return tracked.size();
    }

    public int getTrackingCount() {
        Tracked tracked = this.tracked;
        if (tracked == null) {
            return -1;
        }
        return tracked.getTrackingCount();
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

    static {
        LSDWatchdog.startWatchdog(WATCHDOG);
    }

    private class Tracked
    implements ServiceObserver {
        private static final long serialVersionUID = -5234368493803321949L;
        private final Hashtable services = new Hashtable();
        private Vector adding = new Vector(10, 10);
        private boolean closed = false;
        private int trackingCount = 0;

        protected Tracked() {
        }

        protected void close() {
            this.closed = true;
        }

        protected int getTrackingCount() {
            return this.trackingCount;
        }

        protected int size() {
            return this.services.size();
        }

        protected Enumeration keys() {
            return this.services.keys();
        }

        protected Enumeration elements() {
            return this.services.elements();
        }

        protected Object get(ServiceReference serviceReference) {
            return this.services.get(serviceReference);
        }

        protected void put(ServiceReference serviceReference, Object object) {
            this.services.put(serviceReference, object);
        }

        public String[] getObservedClasses() {
            return ServiceTracker.this.svcInterfaces;
        }

        public boolean addingService(ServiceInfo serviceInfo) {
            if (this.closed) {
                return false;
            }
            if (ServiceTracker.this.svcFilter != null && !ServiceTracker.this.svcFilter.match(serviceInfo)) {
                return false;
            }
            try {
                return this.track(serviceInfo);
            }
            catch (Exception exception) {
                StringBuffer stringBuffer = new StringBuffer(256);
                stringBuffer.append("exception adding service to ServiceTrackerCustomizer of bundle ");
                stringBuffer.append(" '").append(((BundleInfo)ServiceTracker.this.context).getBundleName()).append("' ");
                LSDFramework.getLogService().log(serviceInfo, 1, stringBuffer.toString(), exception);
                return false;
            }
        }

        public void removedService(ServiceInfo serviceInfo) {
            if (ServiceTracker.this.svcFilter != null && !ServiceTracker.this.svcFilter.match(serviceInfo)) {
                return;
            }
            try {
                this.untrack(serviceInfo);
            }
            catch (Exception exception) {
                StringBuffer stringBuffer = new StringBuffer(256);
                stringBuffer.append("exception removing service from ServiceTrackerCustomizer of bundle ");
                stringBuffer.append(" '").append(((BundleInfo)ServiceTracker.this.context).getBundleName()).append("' ");
                LSDFramework.getLogService().log(serviceInfo, 1, stringBuffer.toString(), exception);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected boolean track(ServiceReference serviceReference) {
            Object object = this.get(serviceReference);
            if (object != null) {
                ServiceTracker.this.alarmHandler.setTrackedService(serviceReference, Thread.currentThread().getName());
                WATCHDOG.setAlarm(2000L, "call of modifiedService timed out", ServiceTracker.this.alarmHandler);
                ServiceTracker.this.customizer.modifiedService(serviceReference, object);
                WATCHDOG.cancelAlarm();
                return true;
            }
            Tracked tracked = this;
            synchronized (tracked) {
                if (this.adding.indexOf(serviceReference, 0) != -1) {
                    return false;
                }
                this.adding.addElement(serviceReference);
            }
            boolean bl = false;
            boolean bl2 = true;
            try {
                ServiceTracker.this.alarmHandler.setTrackedService(serviceReference, Thread.currentThread().getName());
                WATCHDOG.setAlarm(2000L, "call of addingService timed out", ServiceTracker.this.alarmHandler);
                object = ServiceTracker.this.customizer.addingService(serviceReference);
                WATCHDOG.cancelAlarm();
            }
            finally {
                Tracked tracked2 = this;
                synchronized (tracked2) {
                    if (this.adding.removeElement(serviceReference)) {
                        if (object != null) {
                            this.put(serviceReference, object);
                            ++this.trackingCount;
                            this.notifyAll();
                        } else {
                            bl2 = false;
                        }
                    } else {
                        bl = true;
                    }
                }
            }
            if (bl) {
                ServiceTracker.this.alarmHandler.setTrackedService(serviceReference, Thread.currentThread().getName());
                WATCHDOG.setAlarm(2000L, "call of removedService timed out", ServiceTracker.this.alarmHandler);
                ServiceTracker.this.customizer.removedService(serviceReference, object);
                WATCHDOG.cancelAlarm();
            }
            return bl2;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void untrack(ServiceReference serviceReference) {
            Object object;
            Tracked tracked = this;
            synchronized (tracked) {
                if (this.adding.removeElement(serviceReference)) {
                    return;
                }
                object = this.services.remove(serviceReference);
                if (object == null) {
                    return;
                }
                ++this.trackingCount;
            }
            ServiceTracker.this.alarmHandler.setTrackedService(serviceReference, Thread.currentThread().getName());
            WATCHDOG.setAlarm(2000L, "call of removedService timed out", ServiceTracker.this.alarmHandler);
            ServiceTracker.this.customizer.removedService(serviceReference, object);
            WATCHDOG.cancelAlarm();
        }

        public String toString() {
            return ServiceTracker.this.toString();
        }
    }

    private class AlarmHandler
    implements Runnable {
        String thread = null;
        ServiceInfo svcInfo = null;

        private AlarmHandler() {
        }

        public void setTrackedService(ServiceReference serviceReference, String string) {
            this.svcInfo = (ServiceInfo)serviceReference;
            this.thread = string;
        }

        public void run() {
            long l = this.svcInfo.getServiceID();
            String[] stringArray = this.svcInfo.getServiceInterfaces();
            BundleInfo bundleInfo = (BundleInfo)this.svcInfo.getBundle();
            String string = bundleInfo.getBundleName();
            String string2 = ((BundleInfo)ServiceTracker.this.context).getBundleName();
            System.err.println(new StringBuffer().append("[").append(this.thread).append("] bundle ").append(string2).append(" tracked service (").append(l).append(") of bundle ").append(string).toString());
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                System.err.print("  ");
                System.err.print(stringArray[i2]);
            }
        }
    }

    private static class LSDFramework
    extends de.dreisoft.lsd.LSDFramework {
        private LSDFramework() {
        }

        public static ServiceRegistry getServiceRegistry() {
            return serviceRegistry;
        }

        public static LogService getLogService() {
            return logService;
        }
    }
}

