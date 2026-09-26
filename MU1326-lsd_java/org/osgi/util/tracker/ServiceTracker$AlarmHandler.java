/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.util.tracker;

import de.dreisoft.lsd.BundleInfo;
import de.dreisoft.lsd.ServiceInfo;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTracker$1;

class ServiceTracker$AlarmHandler
implements Runnable {
    String thread = null;
    ServiceInfo svcInfo = null;
    private final /* synthetic */ ServiceTracker this$0;

    private ServiceTracker$AlarmHandler(ServiceTracker serviceTracker) {
        this.this$0 = serviceTracker;
    }

    public void setTrackedService(ServiceReference serviceReference, String string) {
        this.svcInfo = (ServiceInfo)serviceReference;
        this.thread = string;
    }

    @Override
    public void run() {
        long l = this.svcInfo.getServiceID();
        String[] stringArray = this.svcInfo.getServiceInterfaces();
        BundleInfo bundleInfo = (BundleInfo)this.svcInfo.getBundle();
        String string = bundleInfo.getBundleName();
        String string2 = ((BundleInfo)this.this$0.context).getBundleName();
        System.err.println(new StringBuffer().append("[").append(this.thread).append("] bundle ").append(string2).append(" tracked service (").append(l).append(") of bundle ").append(string).toString());
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            System.err.print("  ");
            System.err.print(stringArray[i2]);
        }
    }

    /* synthetic */ ServiceTracker$AlarmHandler(ServiceTracker serviceTracker, ServiceTracker$1 serviceTracker$1) {
        this(serviceTracker);
    }
}

