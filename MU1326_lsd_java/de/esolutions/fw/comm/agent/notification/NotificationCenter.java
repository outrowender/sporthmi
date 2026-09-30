/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.notification;

import de.esolutions.fw.comm.agent.config.CommConfig;
import de.esolutions.fw.comm.agent.notification.INotification;
import de.esolutions.fw.comm.agent.notification.INotificationCallback;
import de.esolutions.fw.comm.agent.notification.ProxyListenerNotification;
import de.esolutions.fw.comm.agent.notification.ServiceInstanceListenerNotification;
import de.esolutions.fw.comm.agent.notification.ServiceListenerNotification;
import de.esolutions.fw.comm.agent.notification.ServiceListenerStubNotification;
import de.esolutions.fw.comm.agent.service.ServiceIKChecker;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.IProxyListener;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IServiceInstanceListener;
import de.esolutions.fw.comm.core.IServiceListener;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.MapList;
import de.esolutions.fw.util.commons.queue.QueueShutdownException;
import de.esolutions.fw.util.commons.queue.QueueWorker;
import de.esolutions.fw.util.commons.timeout.ITimeOutHandler;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeOutTimer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotificationCenter
extends QueueWorker {
    protected MapList serviceInstanceListeners;
    protected MapList proxyListeners;
    protected MapList serviceListeners;
    protected TimeOutTimer timer;
    protected int notifyTimeout;
    private final ITimeSource monoTime;

    public NotificationCenter(CommConfig commConfig, ITimeSource iTimeSource) {
        super("commNotify", commConfig.getNotifyQueueSize());
        this.monoTime = iTimeSource;
        this.serviceInstanceListeners = new MapList();
        this.proxyListeners = new MapList();
        this.serviceListeners = new MapList();
        this.notifyTimeout = commConfig.getNotifyTimeout();
        if (this.notifyTimeout > 0) {
            this.timer = new TimeOutTimer();
        }
        int n = commConfig.getPriorities().getNotifierThreadPrio();
        this.start(n);
        CommAgentTracing.NOTIFICATION.log((short)0, "notification center started (prio=%1)", new Integer(n));
    }

    public void shutdown() {
        this.stop();
        if (this.timer != null) {
            this.timer.cancel();
            this.timer = null;
        }
        CommAgentTracing.NOTIFICATION.log((short)0, "notification center shutdown");
    }

    private String getServiceInstanceTag(ServiceInstanceID serviceInstanceID) {
        Buffer buffer = new Buffer();
        buffer.append(serviceInstanceID.getServiceUUID());
        buffer.append(":");
        buffer.append(serviceInstanceID.getHandle());
        return buffer.toString();
    }

    public synchronized void registerServiceInstanceListener(ServiceInstanceID serviceInstanceID, IServiceInstanceListener iServiceInstanceListener) {
        String string = this.getServiceInstanceTag(serviceInstanceID);
        CommAgentTracing.NOTIFICATION.log((short)1, "registerServiceInstanceListener: id=%1 tag=%2 listener=%3", serviceInstanceID, (Object)string, (Object)iServiceInstanceListener);
        ServiceInstanceListenerEntry serviceInstanceListenerEntry = new ServiceInstanceListenerEntry(iServiceInstanceListener, serviceInstanceID);
        if (!this.serviceInstanceListeners.contains(string, serviceInstanceListenerEntry)) {
            this.serviceInstanceListeners.add(string, serviceInstanceListenerEntry);
        }
    }

    public synchronized void unregisterServiceInstanceListener(ServiceInstanceID serviceInstanceID, IServiceInstanceListener iServiceInstanceListener) {
        String string = this.getServiceInstanceTag(serviceInstanceID);
        CommAgentTracing.NOTIFICATION.log((short)1, "unregisterServiceInstanceListener: id=%1 tag=%2 listener=%3", serviceInstanceID, (Object)string, (Object)iServiceInstanceListener);
        ServiceInstanceListenerEntry serviceInstanceListenerEntry = new ServiceInstanceListenerEntry(iServiceInstanceListener, serviceInstanceID);
        this.serviceInstanceListeners.remove(string, serviceInstanceListenerEntry);
    }

    public synchronized void unregisterAllServiceInstanceListeners(ServiceInstanceID serviceInstanceID) {
        String string = this.getServiceInstanceTag(serviceInstanceID);
        CommAgentTracing.NOTIFICATION.log((short)1, "unregisterServiceInstanceListener: id=%1 tag=%2 remove all", serviceInstanceID, (Object)string);
        this.serviceInstanceListeners.removeAll(string);
    }

    public synchronized void registerProxyListener(Proxy proxy, IProxyListener iProxyListener) {
        CommAgentTracing.NOTIFICATION.log((short)1, "registerProxyListener: proxy=#%1:%2 listener=%3", new Integer(proxy.getProxyID()), (Object)proxy.getInstanceID(), (Object)iProxyListener);
        if (!this.proxyListeners.contains(proxy, iProxyListener)) {
            this.proxyListeners.add(proxy, iProxyListener);
        }
    }

    public synchronized void unregisterProxyListener(Proxy proxy, IProxyListener iProxyListener) {
        CommAgentTracing.NOTIFICATION.log((short)1, "unregisterProxyListener: proxy=#%1:%2 listener=%3", new Integer(proxy.getProxyID()), (Object)proxy.getInstanceID(), (Object)iProxyListener);
        this.proxyListeners.remove(proxy, iProxyListener);
    }

    public synchronized void unregisterAllProxyListeners(Proxy proxy) {
        CommAgentTracing.NOTIFICATION.log((short)1, "unregisterProxyListener: proxy=#%1:%2 remove all", new Integer(proxy.getProxyID()), (Object)proxy.getInstanceID());
        this.proxyListeners.removeAll(proxy);
    }

    public synchronized void registerServiceListener(IService iService, IServiceListener iServiceListener) {
        CommAgentTracing.NOTIFICATION.log((short)1, "registerServiceListener: service=%1 listener=%2", iService.getInstanceID(), (Object)iServiceListener);
        if (!this.serviceListeners.contains(iService, iServiceListener)) {
            this.serviceListeners.add(iService, iServiceListener);
        }
    }

    public synchronized void unregisterServiceListener(IService iService, IServiceListener iServiceListener) {
        CommAgentTracing.NOTIFICATION.log((short)1, "unregisterServiceListener: service=%1 listener=%2", iService.getInstanceID(), (Object)iServiceListener);
        this.serviceListeners.remove(iService, iServiceListener);
    }

    public synchronized void unregisterAllServiceListeners(IService iService) {
        CommAgentTracing.NOTIFICATION.log((short)1, "unregisterServiceListener: service=%1 remove all", iService.getInstanceID());
        this.serviceListeners.removeAll(iService);
    }

    protected void addNotification(INotification iNotification) {
        try {
            CommAgentTracing.NOTIFICATION.log((short)1, "adding notification: %1", iNotification);
            if (this.addToQueue(iNotification)) {
                CommAgentTracing.NOTIFICATION.log((short)3, "added notification in high water range. queue size=%1", new Integer(this.queueSize()));
            }
        }
        catch (QueueShutdownException queueShutdownException) {
            CommAgentTracing.NOTIFICATION.log((short)4, "addNotification failed: %1", queueShutdownException);
        }
    }

    public synchronized void reportRegisterServiceInstance(ServiceIKChecker serviceIKChecker, ServiceInstanceID serviceInstanceID, boolean bl, short s) {
        String string = this.getServiceInstanceTag(serviceInstanceID);
        List list = this.serviceInstanceListeners.get(string);
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ServiceInstanceListenerEntry serviceInstanceListenerEntry = (ServiceInstanceListenerEntry)iterator.next();
            if (!serviceIKChecker.isCompatible("Report", serviceInstanceListenerEntry.instanceID, serviceInstanceID)) continue;
            arrayList.add(serviceInstanceListenerEntry.listener);
        }
        this.addNotification(new ServiceInstanceListenerNotification(serviceInstanceID, arrayList, bl, s));
    }

    public synchronized void reportRegisterServiceInstance(IServiceInstanceListener iServiceInstanceListener, ServiceInstanceID serviceInstanceID, short s) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(iServiceInstanceListener);
        this.addNotification(new ServiceInstanceListenerNotification(serviceInstanceID, arrayList, true, s));
    }

    public synchronized boolean reportProxyStateChanged(Proxy proxy, int n, INotificationCallback iNotificationCallback) {
        List list = this.proxyListeners.get(proxy);
        if (list == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(list);
        ProxyListenerNotification proxyListenerNotification = new ProxyListenerNotification(proxy, arrayList, n);
        proxyListenerNotification.setCallback(iNotificationCallback);
        this.addNotification(proxyListenerNotification);
        return true;
    }

    public synchronized boolean reportProxyStateChanged(Proxy proxy, int n, INotificationCallback iNotificationCallback, IProxyListener iProxyListener) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(iProxyListener);
        ProxyListenerNotification proxyListenerNotification = new ProxyListenerNotification(proxy, arrayList, n);
        proxyListenerNotification.setCallback(iNotificationCallback);
        this.addNotification(proxyListenerNotification);
        return true;
    }

    public synchronized void reportProxyLifecycleChanged(IProxyListener iProxyListener, Proxy proxy, int n) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(iProxyListener);
        this.addNotification(new ProxyListenerNotification(proxy, arrayList, n));
    }

    public synchronized void reportServiceStubCountChanged(IService iService, int n) {
        List list = this.serviceListeners.get(iService);
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        this.addNotification(new ServiceListenerNotification(iService, arrayList, n));
    }

    public synchronized boolean reportServiceStubAttached(IStub iStub, INotificationCallback iNotificationCallback) {
        List list = this.serviceListeners.get(iStub.getService());
        if (list == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(list);
        ServiceListenerStubNotification serviceListenerStubNotification = new ServiceListenerStubNotification(iStub, arrayList, true);
        serviceListenerStubNotification.setCallback(iNotificationCallback);
        this.addNotification(serviceListenerStubNotification);
        return true;
    }

    public synchronized boolean reportServiceStubDetached(IStub iStub, INotificationCallback iNotificationCallback) {
        List list = this.serviceListeners.get(iStub.getService());
        if (list == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(list);
        ServiceListenerStubNotification serviceListenerStubNotification = new ServiceListenerStubNotification(iStub, arrayList, false);
        serviceListenerStubNotification.setCallback(iNotificationCallback);
        this.addNotification(serviceListenerStubNotification);
        return true;
    }

    public synchronized void reportServiceStubCountChanged(IServiceListener iServiceListener, IService iService, int n) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(iServiceListener);
        this.addNotification(new ServiceListenerNotification(iService, arrayList, n));
    }

    protected void handleQueuedObject(Object object) {
        INotification iNotification = (INotification)object;
        long l = this.monoTime.getCurrentTime();
        TimeOutTimer.TimeOutTask timeOutTask = null;
        if (this.timer != null) {
            timeOutTask = this.timer.schedule(new NotifyTimeOutHandler(iNotification), this.notifyTimeout);
        }
        try {
            iNotification.performNotification();
            iNotification.triggerCallback();
        }
        catch (Throwable throwable) {
            CommAgentTracing.NOTIFICATION.log((short)4, "COMM notification callee failed: %1", throwable);
        }
        if (timeOutTask != null) {
            timeOutTask.disarm();
        }
        long l2 = this.monoTime.getCurrentTime();
        CommAgentTracing.NOTIFICATION.log((short)0, "  notification duration %1 ms", new Long(l2 - l));
    }

    protected class NotifyTimeOutHandler
    implements ITimeOutHandler {
        private INotification notification;

        public NotifyTimeOutHandler(INotification iNotification) {
            this.notification = iNotification;
        }

        public void timeoutOccurred(Thread thread) {
            CommAgentTracing.NOTIFICATION.log((short)4, "notification timeout detected:\n  notification=%1\n  thread=%2 timeout=%3 ms", this.notification, (Object)thread, (Object)new Integer(NotificationCenter.this.notifyTimeout));
        }
    }

    private class ServiceInstanceListenerEntry {
        public final IServiceInstanceListener listener;
        public final ServiceInstanceID instanceID;

        public ServiceInstanceListenerEntry(IServiceInstanceListener iServiceInstanceListener, ServiceInstanceID serviceInstanceID) {
            this.listener = iServiceInstanceListener;
            this.instanceID = serviceInstanceID;
        }

        public boolean equals(Object object) {
            if (!(object instanceof ServiceInstanceListenerEntry)) {
                return false;
            }
            ServiceInstanceListenerEntry serviceInstanceListenerEntry = (ServiceInstanceListenerEntry)object;
            return serviceInstanceListenerEntry.listener == this.listener && serviceInstanceListenerEntry.instanceID.equals(this.instanceID);
        }

        public int hashCode() {
            int n = 1;
            n += 7 * this.listener.hashCode();
            return n += 41 * this.instanceID.hashCode();
        }
    }
}

