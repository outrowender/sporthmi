/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class DefaultServiceTrackerCustomizer
implements ServiceTrackerCustomizer {
    @Override
    public Object addingService(ServiceReference serviceReference) {
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

