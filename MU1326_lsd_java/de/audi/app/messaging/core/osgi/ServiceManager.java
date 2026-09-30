/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.osgi;

import de.audi.app.messaging.core.osgi.DsiDescriptor;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.atip.base.IFrameworkAccess;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

public final class ServiceManager
implements IServiceRegistry {
    private final IFrameworkAccess framework;
    private final BundleContext bundleContext;
    private final List services = new ArrayList();
    private final List trackers = new ArrayList();
    private final List dsis = new ArrayList();
    private boolean disconnected;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ServiceManager(MessagingBundleContext messagingBundleContext) {
        this.framework = messagingBundleContext.getFramework();
        this.bundleContext = messagingBundleContext.getBundleContext();
        ServiceManager serviceManager = this;
        synchronized (serviceManager) {
            this.disconnected = false;
        }
    }

    public synchronized ServiceRegistration registerService(String string, Object object, Dictionary dictionary) {
        this.assertConnected();
        ServiceRegistration serviceRegistration = this.bundleContext.registerService(string, object, dictionary);
        this.services.add(serviceRegistration);
        return serviceRegistration;
    }

    public synchronized ServiceRegistration registerService(String[] stringArray, Object object, Dictionary dictionary) {
        this.assertConnected();
        ServiceRegistration serviceRegistration = this.bundleContext.registerService(stringArray, object, dictionary);
        this.services.add(serviceRegistration);
        return serviceRegistration;
    }

    public synchronized void addTracker(ServiceTracker serviceTracker) {
        this.assertConnected();
        serviceTracker.open();
        this.trackers.add(serviceTracker);
    }

    public synchronized void startDsiService(DsiDescriptor dsiDescriptor) {
        this.assertConnected();
        this.framework.startDSIService(dsiDescriptor.getInterfaceName(), dsiDescriptor.getInstanceId());
        this.dsis.add(dsiDescriptor);
    }

    public synchronized void disconnect() {
        this.assertConnected();
        this.disconnected = true;
        Iterator iterator = this.services.iterator();
        while (iterator.hasNext()) {
            ((ServiceRegistration)iterator.next()).unregister();
        }
        iterator = this.trackers.iterator();
        while (iterator.hasNext()) {
            ((ServiceTracker)iterator.next()).close();
        }
        iterator = this.dsis.iterator();
        while (iterator.hasNext()) {
            DsiDescriptor dsiDescriptor = (DsiDescriptor)iterator.next();
            this.framework.stopDSIService(dsiDescriptor.getInterfaceName(), dsiDescriptor.getInstanceId());
        }
    }

    private synchronized void assertConnected() {
        if (this.disconnected) {
            throw new IllegalStateException("Registry has already been disconnected and is therefore no longer operational.");
        }
    }
}

