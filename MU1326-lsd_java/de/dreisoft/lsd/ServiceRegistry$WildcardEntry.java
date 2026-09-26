/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.ServiceInfo;
import de.dreisoft.lsd.ServiceObserver;
import de.dreisoft.lsd.ServiceRegistry;
import de.dreisoft.lsd.ServiceRegistry$Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ServiceRegistry$WildcardEntry
extends ServiceRegistry$Entry {
    private final /* synthetic */ ServiceRegistry this$0;

    public ServiceRegistry$WildcardEntry(ServiceRegistry serviceRegistry) {
        this.this$0 = serviceRegistry;
        super("*");
    }

    @Override
    public void addService(ServiceInfo serviceInfo) {
        Iterator iterator = this.observerList.iterator();
        while (iterator.hasNext()) {
            ServiceObserver serviceObserver = (ServiceObserver)iterator.next();
            serviceObserver.addingService(serviceInfo);
        }
    }

    @Override
    public void removeService(ServiceInfo serviceInfo) {
        Iterator iterator = this.observerList.iterator();
        while (iterator.hasNext()) {
            ServiceObserver serviceObserver = (ServiceObserver)iterator.next();
            serviceObserver.removedService(serviceInfo);
        }
    }

    @Override
    public synchronized List getServices() {
        ArrayList arrayList = new ArrayList(10);
        Iterator iterator = ServiceRegistry.access$100(this.this$0).values().iterator();
        while (iterator.hasNext()) {
            ServiceRegistry$Entry serviceRegistry$Entry = (ServiceRegistry$Entry)iterator.next();
            arrayList.addAll(serviceRegistry$Entry.svcList);
        }
        return arrayList;
    }

    @Override
    public synchronized void addObserver(ServiceObserver serviceObserver) {
        this.observerList.add(serviceObserver);
        Iterator iterator = ServiceRegistry.access$100(this.this$0).values().iterator();
        while (iterator.hasNext()) {
            ServiceRegistry$Entry serviceRegistry$Entry = (ServiceRegistry$Entry)iterator.next();
            Iterator iterator2 = serviceRegistry$Entry.svcList.iterator();
            while (iterator2.hasNext()) {
                ServiceInfo serviceInfo = (ServiceInfo)iterator2.next();
                serviceObserver.addingService(serviceInfo);
            }
        }
    }

    @Override
    public void removeObserver(ServiceObserver serviceObserver) {
        this.observerList.remove(serviceObserver);
        Iterator iterator = ServiceRegistry.access$100(this.this$0).values().iterator();
        while (iterator.hasNext()) {
            ServiceRegistry$Entry serviceRegistry$Entry = (ServiceRegistry$Entry)iterator.next();
            Iterator iterator2 = serviceRegistry$Entry.svcList.iterator();
            while (iterator2.hasNext()) {
                ServiceInfo serviceInfo = (ServiceInfo)iterator2.next();
                serviceObserver.removedService(serviceInfo);
            }
        }
    }
}

