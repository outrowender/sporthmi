/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.ServiceInfo;

public interface ServiceObserver {
    public String[] getObservedClasses();

    public boolean addingService(ServiceInfo var1);

    public void removedService(ServiceInfo var1);
}

