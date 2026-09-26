/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.ServiceInfo;

public interface ServiceObserver {
    default public String[] getObservedClasses() {
    }

    default public boolean addingService(ServiceInfo serviceInfo) {
    }

    default public void removedService(ServiceInfo serviceInfo) {
    }
}

