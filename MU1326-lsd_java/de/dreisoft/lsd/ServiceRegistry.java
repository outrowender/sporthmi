/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.AuditTrail;
import de.dreisoft.lsd.AuditTrail$Entry;
import de.dreisoft.lsd.LSDFramework;
import de.dreisoft.lsd.LSDWatchdog;
import de.dreisoft.lsd.ServiceInfo;
import de.dreisoft.lsd.ServiceObserver;
import de.dreisoft.lsd.ServiceRegistry$Entry;
import de.dreisoft.lsd.ServiceRegistry$ServiceListenerAlarmHandler;
import de.dreisoft.lsd.ServiceRegistry$SingletonHolder;
import de.dreisoft.lsd.ServiceRegistry$WildcardEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

public final class ServiceRegistry {
    static final String GENERAL_SERVICE;
    private final LSDWatchdog watchdog = new LSDWatchdog("Service Registry");
    private final ServiceRegistry$ServiceListenerAlarmHandler svcListenerAlarmHandler = new ServiceRegistry$ServiceListenerAlarmHandler(this, null);
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
        return ServiceRegistry$SingletonHolder.instance;
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
            this.registerServiceInternal(serviceInfo, (AuditTrail$Entry)object);
        }
        finally {
            ((AuditTrail$Entry)object).setStartProcessingQueued();
            this.releaseChangeLock();
            ((AuditTrail$Entry)object).setFinished();
        }
    }

    private void registerServiceInternal(ServiceInfo serviceInfo, AuditTrail$Entry auditTrail$Entry) {
        Object object;
        AuditTrail$Entry auditTrail$Entry2 = auditTrail$Entry != null ? auditTrail$Entry : AuditTrail.getInstance().addEntry("registerServiceInternal", serviceInfo);
        String[] stringArray = serviceInfo.getServiceInterfaces();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            object = this.getEntry(stringArray[i2]);
            ((ServiceRegistry$Entry)object).addService(serviceInfo);
        }
        ServiceRegistry$Entry serviceRegistry$Entry = this.getEntry("*");
        serviceRegistry$Entry.addService(serviceInfo);
        object = new ServiceEvent(1, serviceInfo);
        Iterator iterator = this.serviceListeners.iterator();
        while (iterator.hasNext()) {
            ServiceListener serviceListener = (ServiceListener)iterator.next();
            this.notifySvcListener(serviceListener, (ServiceEvent)object);
        }
        auditTrail$Entry2.setFinished();
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
            this.unregisterServiceInternal(serviceInfo, (AuditTrail$Entry)object);
        }
        finally {
            ((AuditTrail$Entry)object).setStartProcessingQueued();
            this.releaseChangeLock();
            ((AuditTrail$Entry)object).setFinished();
        }
    }

    private void unregisterServiceInternal(ServiceInfo serviceInfo, AuditTrail$Entry auditTrail$Entry) {
        Object object;
        AuditTrail$Entry auditTrail$Entry2 = auditTrail$Entry != null ? auditTrail$Entry : AuditTrail.getInstance().addEntry("unregisterServiceInternal", serviceInfo);
        String[] stringArray = serviceInfo.getServiceInterfaces();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            object = this.getEntry(stringArray[i2]);
            ((ServiceRegistry$Entry)object).removeService(serviceInfo);
        }
        ServiceRegistry$Entry serviceRegistry$Entry = this.getEntry("*");
        serviceRegistry$Entry.removeService(serviceInfo);
        object = new ServiceEvent(4, serviceInfo);
        Iterator iterator = this.serviceListeners.iterator();
        while (iterator.hasNext()) {
            ServiceListener serviceListener = (ServiceListener)iterator.next();
            this.notifySvcListener(serviceListener, (ServiceEvent)object);
        }
        auditTrail$Entry2.setFinished();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ServiceRegistry$Entry getExistingEntry(String string) {
        Map map = this.svcMap;
        synchronized (map) {
            return (ServiceRegistry$Entry)this.svcMap.get(string);
        }
    }

    public ServiceInfo getServiceInfo(String string) {
        ServiceRegistry$Entry serviceRegistry$Entry = this.getExistingEntry(string);
        return serviceRegistry$Entry != null ? serviceRegistry$Entry.getRandomService() : null;
    }

    public List getServiceInfos(String string) {
        ServiceRegistry$Entry serviceRegistry$Entry = this.getExistingEntry(string);
        return serviceRegistry$Entry != null ? serviceRegistry$Entry.getServices() : new ArrayList(0);
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
        hashSet.remove("*");
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
            this.addObserverInternal(serviceObserver, (AuditTrail$Entry)object);
        }
        finally {
            ((AuditTrail$Entry)object).setStartProcessingQueued();
            this.releaseChangeLock();
            ((AuditTrail$Entry)object).setFinished();
        }
    }

    private void addObserverInternal(ServiceObserver serviceObserver, AuditTrail$Entry auditTrail$Entry) {
        AuditTrail$Entry auditTrail$Entry2 = auditTrail$Entry != null ? auditTrail$Entry : AuditTrail.getInstance().addEntry("addObserverInternal", serviceObserver);
        String[] stringArray = serviceObserver.getObservedClasses();
        if (stringArray.length == 0) {
            ServiceRegistry$Entry serviceRegistry$Entry = this.getEntry("*");
            serviceRegistry$Entry.addObserver(serviceObserver);
        } else {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                ServiceRegistry$Entry serviceRegistry$Entry = this.getEntry(stringArray[i2]);
                serviceRegistry$Entry.addObserver(serviceObserver);
            }
        }
        auditTrail$Entry2.setFinished();
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
            this.removeObserverInternal(serviceObserver, (AuditTrail$Entry)object);
        }
        finally {
            ((AuditTrail$Entry)object).setStartProcessingQueued();
            this.releaseChangeLock();
            ((AuditTrail$Entry)object).setFinished();
        }
    }

    private void removeObserverInternal(ServiceObserver serviceObserver, AuditTrail$Entry auditTrail$Entry) {
        AuditTrail$Entry auditTrail$Entry2 = auditTrail$Entry != null ? auditTrail$Entry : AuditTrail.getInstance().addEntry("removeObserverInternal", serviceObserver);
        String[] stringArray = serviceObserver.getObservedClasses();
        if (stringArray.length == 0) {
            ServiceRegistry$Entry serviceRegistry$Entry = this.getEntry("*");
            serviceRegistry$Entry.removeObserver(serviceObserver);
        } else {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                ServiceRegistry$Entry serviceRegistry$Entry = this.getEntry(stringArray[i2]);
                serviceRegistry$Entry.removeObserver(serviceObserver);
            }
        }
        auditTrail$Entry2.setFinished();
    }

    public List getObservers(String string) {
        ServiceRegistry$Entry serviceRegistry$Entry = this.getExistingEntry(string);
        return serviceRegistry$Entry != null ? serviceRegistry$Entry.getObservers() : new ArrayList(0);
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
            this.watchdog.setAlarm(0, "call of ServiceListener.serviceChanged timed out", this.svcListenerAlarmHandler);
            serviceListener.serviceChanged(serviceEvent);
            this.watchdog.cancelAlarm();
        }
        catch (Exception exception) {
            StringBuffer stringBuffer = new StringBuffer(64);
            stringBuffer.append("exception sending service event (t");
            stringBuffer.append(serviceEvent.getType());
            stringBuffer.append(") to service listener ");
            stringBuffer.append(super.getClass());
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
                    super.wait(0);
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
        super.notifyAll();
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
    private ServiceRegistry$Entry getEntry(String string) {
        Map map = this.svcMap;
        synchronized (map) {
            ServiceRegistry$Entry serviceRegistry$Entry = (ServiceRegistry$Entry)this.svcMap.get(string);
            if (serviceRegistry$Entry == null) {
                serviceRegistry$Entry = string.equals("*") ? new ServiceRegistry$WildcardEntry(this) : new ServiceRegistry$Entry(string);
                this.svcMap.put(string, serviceRegistry$Entry);
            }
            return serviceRegistry$Entry;
        }
    }

    static /* synthetic */ Map access$100(ServiceRegistry serviceRegistry) {
        return serviceRegistry.svcMap;
    }
}

