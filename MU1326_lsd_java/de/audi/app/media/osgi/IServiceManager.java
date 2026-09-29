/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.osgi;

import de.audi.app.media.osgi.IServiceTracker;
import java.util.Dictionary;
import org.dsi.ifc.base.DSIListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public interface IServiceManager {
    default public IServiceTracker createServiceTracker(Class clazz, ServiceTrackerCustomizer serviceTrackerCustomizer) {
    }

    default public ServiceReference[] getServiceReferences(Class clazz) {
    }

    default public ServiceRegistration registerService(Class clazz, Object object, Dictionary dictionary) {
    }

    default public void unregisterService(ServiceRegistration serviceRegistration) {
    }

    default public ServiceRegistration registerDSIListener(int n, String string, DSIListener dSIListener) {
    }

    default public Object getService(ServiceReference serviceReference) {
    }

    default public void releaseService(ServiceReference serviceReference) {
    }

    default public boolean startDSIService(String string, int n) {
    }

    default public void stopDSIService(String string, int n) {
    }

    default public BundleContext getBundleContext() {
    }
}

