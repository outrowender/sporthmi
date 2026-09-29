/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.osgi;

import de.audi.app.messaging.core.osgi.DsiDescriptor;
import java.util.Dictionary;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

public interface IServiceRegistry {
    default public ServiceRegistration registerService(String string, Object object, Dictionary dictionary) {
    }

    default public ServiceRegistration registerService(String[] stringArray, Object object, Dictionary dictionary) {
    }

    default public void addTracker(ServiceTracker serviceTracker) {
    }

    default public void startDsiService(DsiDescriptor dsiDescriptor) {
    }
}

