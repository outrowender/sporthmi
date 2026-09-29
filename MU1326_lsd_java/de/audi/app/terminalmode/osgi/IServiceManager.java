/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.osgi;

import de.audi.app.terminalmode.osgi.IServiceTracker;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public interface IServiceManager {
    public static final Hashtable EMPTY_PARAMETERS = new Hashtable(0);

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

    default public BundleContext getBundleContext() {
    }
}

