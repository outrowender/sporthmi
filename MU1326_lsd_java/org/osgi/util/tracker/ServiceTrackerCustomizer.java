/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.util.tracker;

import org.osgi.framework.ServiceReference;

public interface ServiceTrackerCustomizer {
    public Object addingService(ServiceReference var1);

    public void modifiedService(ServiceReference var1, Object var2);

    public void removedService(ServiceReference var1, Object var2);
}

