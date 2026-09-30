/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.AuditTrail;
import de.dreisoft.lsd.BundleInfo;
import de.dreisoft.lsd.LSDFramework;
import de.dreisoft.lsd.LSDWatchdog;
import de.dreisoft.lsd.ServiceInfo;
import de.dreisoft.lsd.ServiceObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

public final class ServiceRegistry {
    static final String GENERAL_SERVICE = "*";
    private final LSDWatchdog watchdog = new LSDWatchdog("Service Registry");
    private final ServiceListenerAlarmHandler svcListenerAlarmHandler = new ServiceListenerAlarmHandler();
    private Map svcMap = new HashMap();
    private boolean changingRegistry = false;
    private List newServices = new ArrayList(10);
    private List obsoleteServices = new ArrayList(10);
    private List newObservers = new ArrayList(10);
    private List obsoleteObservers = new ArrayList(10);
    private List serviceListeners = new ArrayList(10);
    private List newServiceListeners = new ArrayList(10);
    private List obsoleteServiceListeners = new ArrayList(10);

    private ServiceRegistry() {
        ServiceInfo.setServiceRegistry(this);
        LSDWatchdog.startWatchdog(this.watchdog);
    }

    static ServiceRegistry getInstance() {
        return SingletonHolder.instance;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerService(ServiceInfo serviceInfo) {
        Object object = this;
        synchronized (object) {
            if (this.changingRegistry) {
                AuditTrail.getInstance().addEntry("queue_registerService", serviceInfo);
                this.newServices.add(serviceInfo);
                return;
            }
            this.changingRegistry = true;
        }
        object = AuditTrail.getInstance().addEntry("registerService", serviceInfo);
        try {
            this.registerServiceInternal(serviceInfo, (AuditTrail.Entry)object);
        }
        finally {
            ((AuditTrail.Entry)object).setStartProcessingQueued();
            this.releaseChangeLock();
            ((AuditTrail.Entry)object).setFinished();
        }
    }

    private void registerServiceInternal(ServiceInfo serviceInfo, AuditTrail.Entry entry) {
        Object object;
        AuditTrail.Entry entry2 = entry != null ? entry : AuditTrail.getInstance().addEntry("registerServiceInternal", serviceInfo);
        String[] stringArray = serviceInfo.getServiceInterfaces();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            object = this.getEntry(stringArray[i2]);
            ((Entry)object).addService(serviceInfo);
        }
        Entry entry3 = this.getEntry(GENERAL_SERVICE);
        entry3.addService(serviceInfo);
        object = new ServiceEvent(1, serviceInfo);
        Iterator iterator = this.serviceListeners.iterator();
        while (iterator.hasNext()) {
            ServiceListener serviceListener = (ServiceListener)iterator.next();
            this.notifySvcListener(serviceListener, (ServiceEvent)object);
        }
        entry2.setFinished();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unregisterService(ServiceInfo serviceInfo) {
        Object object = this;
        synchronized (object) {
            if (this.changingRegistry) {
                AuditTrail.getInstance().addEntry("queue_unregisterService", serviceInfo);
                this.obsoleteServices.add(serviceInfo);
                return;
            }
            this.changingRegistry = true;
        }
        object = AuditTrail.getInstance().addEntry("unregisterService", serviceInfo);
        try {
            this.unregisterServiceInternal(serviceInfo, (AuditTrail.Entry)object);
        }
        finally {
            ((AuditTrail.Entry)object).setStartProcessingQueued();
            this.releaseChangeLock();
            ((AuditTrail.Entry)object).setFinished();
        }
    }

    private void unregisterServiceInternal(ServiceInfo serviceInfo, AuditTrail.Entry entry) {
        Object object;
        AuditTrail.Entry entry2 = entry != null ? entry : AuditTrail.getInstance().addEntry("unregisterServiceInternal", serviceInfo);
        String[] stringArray = serviceInfo.getServiceInterfaces();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            object = this.getEntry(stringArray[i2]);
            ((Entry)object).removeService(serviceInfo);
        }
        Entry entry3 = this.getEntry(GENERAL_SERVICE);
        entry3.removeService(serviceInfo);
        object = new ServiceEvent(4, serviceInfo);
        Iterator iterator = this.serviceListeners.iterator();
        while (iterator.hasNext()) {
            ServiceListener serviceListener = (ServiceListener)iterator.next();
            this.notifySvcListener(serviceListener, (ServiceEvent)object);
        }
        entry2.setFinished();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Entry getExistingEntry(String string) {
        Map map = this.svcMap;
        synchronized (map) {
            return (Entry)this.svcMap.get(string);
        }
    }

    public ServiceInfo getServiceInfo(String string) {
        Entry entry = this.getExistingEntry(string);
        return entry != null ? entry.getRandomService() : null;
    }

    public List getServiceInfos(String string) {
        Entry entry = this.getExistingEntry(string);
        return entry != null ? entry.getServices() : new ArrayList(0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Set getServiceInterfaces() {
        HashSet hashSet;
        Map map = this.svcMap;
        synchronized (map) {
            hashSet = new HashSet(this.svcMap.keySet());
        }
        hashSet.remove(GENERAL_SERVICE);
        return hashSet;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addObserver(ServiceObserver serviceObserver) {
        Object object = this;
        synchronized (object) {
            if (this.changingRegistry) {
                AuditTrail.getInstance().addEntry("queue_addObserver", serviceObserver);
                this.newObservers.add(serviceObserver);
                return;
            }
            this.changingRegistry = true;
        }
        object = AuditTrail.getInstance().addEntry("addObserver", serviceObserver);
        try {
            this.addObserverInternal(serviceObserver, (AuditTrail.Entry)object);
        }
        finally {
            ((AuditTrail.Entry)object).setStartProcessingQueued();
            this.releaseChangeLock();
            ((AuditTrail.Entry)object).setFinished();
        }
    }

    private void addObserverInternal(ServiceObserver serviceObserver, AuditTrail.Entry entry) {
        AuditTrail.Entry entry2 = entry != null ? entry : AuditTrail.getInstance().addEntry("addObserverInternal", serviceObserver);
        String[] stringArray = serviceObserver.getObservedClasses();
        if (stringArray.length == 0) {
            Entry entry3 = this.getEntry(GENERAL_SERVICE);
            entry3.addObserver(serviceObserver);
        } else {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                Entry entry4 = this.getEntry(stringArray[i2]);
                entry4.addObserver(serviceObserver);
            }
        }
        entry2.setFinished();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeObserver(ServiceObserver serviceObserver) {
        Object object = this;
        synchronized (object) {
            if (this.changingRegistry) {
                AuditTrail.getInstance().addEntry("queue_removeObserver", serviceObserver);
                this.obsoleteObservers.add(serviceObserver);
                return;
            }
            this.changingRegistry = true;
        }
        object = AuditTrail.getInstance().addEntry("removeObserver", serviceObserver);
        try {
            this.removeObserverInternal(serviceObserver, (AuditTrail.Entry)object);
        }
        finally {
            ((AuditTrail.Entry)object).setStartProcessingQueued();
            this.releaseChangeLock();
            ((AuditTrail.Entry)object).setFinished();
        }
    }

    private void removeObserverInternal(ServiceObserver serviceObserver, AuditTrail.Entry entry) {
        AuditTrail.Entry entry2 = entry != null ? entry : AuditTrail.getInstance().addEntry("removeObserverInternal", serviceObserver);
        String[] stringArray = serviceObserver.getObservedClasses();
        if (stringArray.length == 0) {
            Entry entry3 = this.getEntry(GENERAL_SERVICE);
            entry3.removeObserver(serviceObserver);
        } else {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                Entry entry4 = this.getEntry(stringArray[i2]);
                entry4.removeObserver(serviceObserver);
            }
        }
        entry2.setFinished();
    }

    public List getObservers(String string) {
        Entry entry = this.getExistingEntry(string);
        return entry != null ? entry.getObservers() : new ArrayList(0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addServiceListener(ServiceListener serviceListener) {
        ServiceRegistry serviceRegistry = this;
        synchronized (serviceRegistry) {
            if (this.changingRegistry) {
                AuditTrail.getInstance().addEntry("queue_addServiceListener", serviceListener);
                this.newServiceListeners.add(serviceListener);
                return;
            }
            this.addServiceListenerInternal(serviceListener);
        }
    }

    private void addServiceListenerInternal(ServiceListener serviceListener) {
        AuditTrail.getInstance().addEntry("addServiceListener", serviceListener);
        this.serviceListeners.add(serviceListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeServiceListener(ServiceListener serviceListener) {
        ServiceRegistry serviceRegistry = this;
        synchronized (serviceRegistry) {
            if (this.changingRegistry) {
                AuditTrail.getInstance().addEntry("queue_removeServiceListener", serviceListener);
                this.obsoleteServiceListeners.add(serviceListener);
                return;
            }
            this.removeServiceListenerInernal(serviceListener);
        }
    }

    private void removeServiceListenerInernal(ServiceListener serviceListener) {
        AuditTrail.getInstance().addEntry("removeServiceListener", serviceListener);
        this.serviceListeners.remove(serviceListener);
    }

    private void notifySvcListener(ServiceListener serviceListener, ServiceEvent serviceEvent) {
        try {
            this.svcListenerAlarmHandler.setData(serviceListener, serviceEvent, Thread.currentThread().getName());
            this.watchdog.setAlarm(2000L, "call of ServiceListener.serviceChanged timed out", this.svcListenerAlarmHandler);
            serviceListener.serviceChanged(serviceEvent);
            this.watchdog.cancelAlarm();
        }
        catch (Exception exception) {
            StringBuffer stringBuffer = new StringBuffer(64);
            stringBuffer.append("exception sending service event (t");
            stringBuffer.append(serviceEvent.getType());
            stringBuffer.append(") to service listener ");
            stringBuffer.append(serviceListener.getClass());
            LSDFramework.logService.log(serviceEvent.getServiceReference(), 1, stringBuffer.toString(), exception);
        }
    }

    synchronized boolean hasDelayedChanges() {
        return !this.newServices.isEmpty() || !this.obsoleteServices.isEmpty() || !this.newObservers.isEmpty() || !this.obsoleteObservers.isEmpty() || !this.newServiceListeners.isEmpty() || !this.obsoleteServiceListeners.isEmpty();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void waitForDelayedChanges() {
        ServiceRegistry serviceRegistry = this;
        synchronized (serviceRegistry) {
            if (this.changingRegistry) {
                try {
                    this.wait(1000L);
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void processDelayedChanges() {
        Object object;
        ServiceRegistry serviceRegistry;
        AuditTrail.getInstance().lastAction = "processing new Services";
        while (!this.newServices.isEmpty()) {
            serviceRegistry = this;
            synchronized (serviceRegistry) {
                object = (ServiceInfo)this.newServices.remove(0);
            }
            this.registerServiceInternal((ServiceInfo)object, null);
        }
        AuditTrail.getInstance().lastAction = "processing obsolete Services";
        while (!this.obsoleteServices.isEmpty()) {
            serviceRegistry = this;
            synchronized (serviceRegistry) {
                object = (ServiceInfo)this.obsoleteServices.remove(0);
            }
            this.unregisterServiceInternal((ServiceInfo)object, null);
        }
        AuditTrail.getInstance().lastAction = "processing new Observers";
        while (!this.newObservers.isEmpty()) {
            serviceRegistry = this;
            synchronized (serviceRegistry) {
                object = (ServiceObserver)this.newObservers.remove(0);
            }
            this.addObserverInternal((ServiceObserver)object, null);
        }
        AuditTrail.getInstance().lastAction = "processing obsolete Observers";
        while (!this.obsoleteObservers.isEmpty()) {
            serviceRegistry = this;
            synchronized (serviceRegistry) {
                object = (ServiceObserver)this.obsoleteObservers.remove(0);
            }
            this.removeObserverInternal((ServiceObserver)object, null);
        }
        AuditTrail.getInstance().lastAction = "processing new ServiceListeners";
        while (!this.newServiceListeners.isEmpty()) {
            serviceRegistry = this;
            synchronized (serviceRegistry) {
                object = (ServiceListener)this.newServiceListeners.remove(0);
                this.addServiceListenerInternal((ServiceListener)object);
            }
        }
        AuditTrail.getInstance().lastAction = "processing obsolete ServiceListeners";
        while (!this.obsoleteServiceListeners.isEmpty()) {
            serviceRegistry = this;
            synchronized (serviceRegistry) {
                object = (ServiceListener)this.obsoleteServiceListeners.remove(0);
                this.removeServiceListenerInernal((ServiceListener)object);
            }
        }
        AuditTrail.getInstance().lastAction = "processing queue done";
    }

    private synchronized void releaseChangeFlag() {
        this.changingRegistry = false;
        this.notifyAll();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void releaseChangeLock() {
        while (true) {
            try {
                if (!this.hasDelayedChanges()) continue;
                this.processDelayedChanges();
                continue;
            }
            catch (Exception exception) {
                System.err.println("CRITICAL ERROR: LSD: processing queued registrations failed!");
                exception.printStackTrace(System.err);
                this.releaseChangeFlag();
                return;
            }
            finally {
                ServiceRegistry serviceRegistry = this;
                synchronized (serviceRegistry) {
                    if (!this.hasDelayedChanges()) {
                        this.releaseChangeFlag();
                        return;
                    }
                }
                continue;
            }
            break;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Entry getEntry(String string) {
        Map map = this.svcMap;
        synchronized (map) {
            Entry entry = (Entry)this.svcMap.get(string);
            if (entry == null) {
                entry = string.equals(GENERAL_SERVICE) ? new WildcardEntry() : new Entry(string);
                this.svcMap.put(string, entry);
            }
            return entry;
        }
    }

    private static class Entry {
        protected List svcList = new LinkedList();
        protected List observerList = new LinkedList();

        public Entry(String string) {
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

    private class WildcardEntry
    extends Entry {
        public WildcardEntry() {
            super(ServiceRegistry.GENERAL_SERVICE);
        }

        public void addService(ServiceInfo serviceInfo) {
            Iterator iterator = this.observerList.iterator();
            while (iterator.hasNext()) {
                ServiceObserver serviceObserver = (ServiceObserver)iterator.next();
                serviceObserver.addingService(serviceInfo);
            }
        }

        public void removeService(ServiceInfo serviceInfo) {
            Iterator iterator = this.observerList.iterator();
            while (iterator.hasNext()) {
                ServiceObserver serviceObserver = (ServiceObserver)iterator.next();
                serviceObserver.removedService(serviceInfo);
            }
        }

        public synchronized List getServices() {
            ArrayList arrayList = new ArrayList(10);
            Iterator iterator = ServiceRegistry.this.svcMap.values().iterator();
            while (iterator.hasNext()) {
                Entry entry = (Entry)iterator.next();
                arrayList.addAll(entry.svcList);
            }
            return arrayList;
        }

        public synchronized void addObserver(ServiceObserver serviceObserver) {
            this.observerList.add(serviceObserver);
            Iterator iterator = ServiceRegistry.this.svcMap.values().iterator();
            while (iterator.hasNext()) {
                Entry entry = (Entry)iterator.next();
                Iterator iterator2 = entry.svcList.iterator();
                while (iterator2.hasNext()) {
                    ServiceInfo serviceInfo = (ServiceInfo)iterator2.next();
                    serviceObserver.addingService(serviceInfo);
                }
            }
        }

        public void removeObserver(ServiceObserver serviceObserver) {
            this.observerList.remove(serviceObserver);
            Iterator iterator = ServiceRegistry.this.svcMap.values().iterator();
            while (iterator.hasNext()) {
                Entry entry = (Entry)iterator.next();
                Iterator iterator2 = entry.svcList.iterator();
                while (iterator2.hasNext()) {
                    ServiceInfo serviceInfo = (ServiceInfo)iterator2.next();
                    serviceObserver.removedService(serviceInfo);
                }
            }
        }
    }

    private static class SingletonHolder {
        static final ServiceRegistry instance = new ServiceRegistry();

        private SingletonHolder() {
        }
    }

    private class ServiceListenerAlarmHandler
    implements Runnable {
        ServiceEvent svcEvent = null;
        ServiceListener svcListener = null;
        String thread = null;

        private ServiceListenerAlarmHandler() {
        }

        public void setData(ServiceListener serviceListener, ServiceEvent serviceEvent, String string) {
            this.svcListener = serviceListener;
            this.svcEvent = serviceEvent;
            this.thread = string;
        }

        public void run() {
            String string;
            switch (this.svcEvent.getType()) {
                case 1: {
                    string = "registered";
                    break;
                }
                case 2: {
                    string = "modified";
                    break;
                }
                case 4: {
                    string = "unregistering";
                    break;
                }
                default: {
                    string = "undefined";
                }
            }
            ServiceInfo serviceInfo = (ServiceInfo)this.svcEvent.getServiceReference();
            long l = serviceInfo.getServiceID();
            String[] stringArray = serviceInfo.getServiceInterfaces();
            BundleInfo bundleInfo = (BundleInfo)serviceInfo.getBundle();
            String string2 = bundleInfo.getBundleName();
            System.err.println(new StringBuffer().append("[").append(this.thread).append("] sent service event '").append(string).append("' for service (").append(l).append(") of bundle ").append(string2).append(" to service listener").append(this.svcListener.getClass()).toString());
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                System.err.print("  ");
                System.err.print(stringArray[i2]);
            }
        }
    }
}

