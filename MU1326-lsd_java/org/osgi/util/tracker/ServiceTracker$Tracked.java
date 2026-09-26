/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.util.tracker;

import de.dreisoft.lsd.BundleInfo;
import de.dreisoft.lsd.ServiceInfo;
import de.dreisoft.lsd.ServiceObserver;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTracker$LSDFramework;

class ServiceTracker$Tracked
implements ServiceObserver {
    private static final long serialVersionUID;
    private final Hashtable services = new Hashtable();
    private Vector adding = new Vector(10, 10);
    private boolean closed = false;
    private int trackingCount = 0;
    private final /* synthetic */ ServiceTracker this$0;

    protected ServiceTracker$Tracked(ServiceTracker serviceTracker) {
        this.this$0 = serviceTracker;
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

    @Override
    public String[] getObservedClasses() {
        return ServiceTracker.access$100(this.this$0);
    }

    @Override
    public boolean addingService(ServiceInfo serviceInfo) {
        if (this.closed) {
            return false;
        }
        if (ServiceTracker.access$200(this.this$0) != null && !ServiceTracker.access$200(this.this$0).match(serviceInfo)) {
            return false;
        }
        try {
            return this.track(serviceInfo);
        }
        catch (Exception exception) {
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("exception adding service to ServiceTrackerCustomizer of bundle ");
            stringBuffer.append(" '").append(((BundleInfo)this.this$0.context).getBundleName()).append("' ");
            ServiceTracker$LSDFramework.getLogService().log(serviceInfo, 1, stringBuffer.toString(), exception);
            return false;
        }
    }

    @Override
    public void removedService(ServiceInfo serviceInfo) {
        if (ServiceTracker.access$200(this.this$0) != null && !ServiceTracker.access$200(this.this$0).match(serviceInfo)) {
            return;
        }
        try {
            this.untrack(serviceInfo);
        }
        catch (Exception exception) {
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("exception removing service from ServiceTrackerCustomizer of bundle ");
            stringBuffer.append(" '").append(((BundleInfo)this.this$0.context).getBundleName()).append("' ");
            ServiceTracker$LSDFramework.getLogService().log(serviceInfo, 1, stringBuffer.toString(), exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean track(ServiceReference serviceReference) {
        Object object = this.get(serviceReference);
        if (object != null) {
            ServiceTracker.access$300(this.this$0).setTrackedService(serviceReference, Thread.currentThread().getName());
            ServiceTracker.access$400().setAlarm(0, "call of modifiedService timed out", ServiceTracker.access$300(this.this$0));
            ServiceTracker.access$500(this.this$0).modifiedService(serviceReference, object);
            ServiceTracker.access$400().cancelAlarm();
            return true;
        }
        ServiceTracker$Tracked serviceTracker$Tracked = this;
        synchronized (serviceTracker$Tracked) {
            if (this.adding.indexOf(serviceReference, 0) != -1) {
                return false;
            }
            this.adding.addElement(serviceReference);
        }
        boolean bl = false;
        boolean bl2 = true;
        try {
            ServiceTracker.access$300(this.this$0).setTrackedService(serviceReference, Thread.currentThread().getName());
            ServiceTracker.access$400().setAlarm(0, "call of addingService timed out", ServiceTracker.access$300(this.this$0));
            object = ServiceTracker.access$500(this.this$0).addingService(serviceReference);
            ServiceTracker.access$400().cancelAlarm();
        }
        finally {
            ServiceTracker$Tracked serviceTracker$Tracked2 = this;
            synchronized (serviceTracker$Tracked2) {
                if (this.adding.removeElement(serviceReference)) {
                    if (object != null) {
                        this.put(serviceReference, object);
                        ++this.trackingCount;
                        super.notifyAll();
                    } else {
                        bl2 = false;
                    }
                } else {
                    bl = true;
                }
            }
        }
        if (bl) {
            ServiceTracker.access$300(this.this$0).setTrackedService(serviceReference, Thread.currentThread().getName());
            ServiceTracker.access$400().setAlarm(0, "call of removedService timed out", ServiceTracker.access$300(this.this$0));
            ServiceTracker.access$500(this.this$0).removedService(serviceReference, object);
            ServiceTracker.access$400().cancelAlarm();
        }
        return bl2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void untrack(ServiceReference serviceReference) {
        Object object;
        ServiceTracker$Tracked serviceTracker$Tracked = this;
        synchronized (serviceTracker$Tracked) {
            if (this.adding.removeElement(serviceReference)) {
                return;
            }
            object = this.services.remove(serviceReference);
            if (object == null) {
                return;
            }
            ++this.trackingCount;
        }
        ServiceTracker.access$300(this.this$0).setTrackedService(serviceReference, Thread.currentThread().getName());
        ServiceTracker.access$400().setAlarm(0, "call of removedService timed out", ServiceTracker.access$300(this.this$0));
        ServiceTracker.access$500(this.this$0).removedService(serviceReference, object);
        ServiceTracker.access$400().cancelAlarm();
    }

    public String toString() {
        return this.this$0.toString();
    }
}

