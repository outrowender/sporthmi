/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.BundleInfo;
import de.dreisoft.lsd.ServiceInfo;
import de.dreisoft.lsd.ServiceRegistry;
import de.dreisoft.lsd.ServiceRegistry$1;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

class ServiceRegistry$ServiceListenerAlarmHandler
implements Runnable {
    ServiceEvent svcEvent = null;
    ServiceListener svcListener = null;
    String thread = null;
    private final /* synthetic */ ServiceRegistry this$0;

    private ServiceRegistry$ServiceListenerAlarmHandler(ServiceRegistry serviceRegistry) {
        this.this$0 = serviceRegistry;
    }

    public void setData(ServiceListener serviceListener, ServiceEvent serviceEvent, String string) {
        this.svcListener = serviceListener;
        this.svcEvent = serviceEvent;
        this.thread = string;
    }

    @Override
    public void run() {
        String string;
        switch (this.svcEvent.getType()) {
            case 1: {
                string = "registered";
                break;
            }
            case 2: {
                string = "modified";
                break;
            }
            case 4: {
                string = "unregistering";
                break;
            }
            default: {
                string = "undefined";
            }
        }
        ServiceInfo serviceInfo = (ServiceInfo)this.svcEvent.getServiceReference();
        long l = serviceInfo.getServiceID();
        String[] stringArray = serviceInfo.getServiceInterfaces();
        BundleInfo bundleInfo = (BundleInfo)serviceInfo.getBundle();
        String string2 = bundleInfo.getBundleName();
        System.err.println(new StringBuffer().append("[").append(this.thread).append("] sent service event '").append(string).append("' for service (").append(l).append(") of bundle ").append(string2).append(" to service listener").append(super.getClass()).toString());
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            System.err.print("  ");
            System.err.print(stringArray[i2]);
        }
    }

    /* synthetic */ ServiceRegistry$ServiceListenerAlarmHandler(ServiceRegistry serviceRegistry, ServiceRegistry$1 serviceRegistry$1) {
        this(serviceRegistry);
    }
}

