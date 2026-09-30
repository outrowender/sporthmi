/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.osgi;

import de.audi.app.terminalmode.osgi.IServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ServiceTrackerImpl
implements IServiceTracker {
    private final ServiceTracker osgiServiceTracker;

    public ServiceTrackerImpl(BundleContext bundleContext, Class clazz, ServiceTrackerCustomizer serviceTrackerCustomizer) {
        this.osgiServiceTracker = new ServiceTracker(bundleContext, clazz.getName(), serviceTrackerCustomizer);
    }

    public void open() {
        this.osgiServiceTracker.open();
    }

    public void close() {
        this.osgiServiceTracker.close();
    }
}

