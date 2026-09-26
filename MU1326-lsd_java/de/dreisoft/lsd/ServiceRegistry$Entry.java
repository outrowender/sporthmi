/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.AuditTrail;
import de.dreisoft.lsd.ServiceInfo;
import de.dreisoft.lsd.ServiceObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class ServiceRegistry$Entry {
    protected List svcList = new LinkedList();
    protected List observerList = new LinkedList();

    public ServiceRegistry$Entry(String string) {
    }

    public synchronized void addService(ServiceInfo serviceInfo) {
        this.svcList.add(serviceInfo);
        Iterator iterator = this.observerList.iterator();
        while (iterator.hasNext()) {
            ServiceObserver serviceObserver = (ServiceObserver)iterator.next();
            AuditTrail.getInstance().addEntry("tracker_addToObserver", serviceObserver);
            serviceObserver.addingService(serviceInfo);
        }
    }

    public synchronized void removeService(ServiceInfo serviceInfo) {
        this.svcList.remove(serviceInfo);
        Iterator iterator = this.observerList.iterator();
        while (iterator.hasNext()) {
            ServiceObserver serviceObserver = (ServiceObserver)iterator.next();
            AuditTrail.getInstance().addEntry("tracker_removedFromObserver", serviceObserver);
            serviceObserver.removedService(serviceInfo);
        }
    }

    public synchronized List getServices() {
        return new ArrayList(this.svcList);
    }

    public synchronized ServiceInfo getRandomService() {
        if (this.svcList.isEmpty()) {
            return null;
        }
        return (ServiceInfo)((LinkedList)this.svcList).getFirst();
    }

    public synchronized void addObserver(ServiceObserver serviceObserver) {
        this.observerList.add(serviceObserver);
        Iterator iterator = this.svcList.iterator();
        while (iterator.hasNext()) {
            ServiceInfo serviceInfo = (ServiceInfo)iterator.next();
            AuditTrail.getInstance().addEntry("tracker_addService", serviceInfo);
            serviceObserver.addingService(serviceInfo);
        }
    }

    public synchronized void removeObserver(ServiceObserver serviceObserver) {
        this.observerList.remove(serviceObserver);
        Iterator iterator = this.svcList.iterator();
        while (iterator.hasNext()) {
            ServiceInfo serviceInfo = (ServiceInfo)iterator.next();
            AuditTrail.getInstance().addEntry("tracker_removedService", serviceInfo);
            serviceObserver.removedService(serviceInfo);
        }
    }

    public synchronized List getObservers() {
        return new ArrayList(this.observerList);
    }
}

