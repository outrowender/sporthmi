/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.ExlapService;
import de.audi.tghu.exlap.ExlapStatusHandler;
import de.audi.tghu.exlap.ExlapUtil;
import de.audi.tghu.exlap.ResultReceiver;
import de.audi.tghu.exlap.app.ActionRequest;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.app.ExlapExlapServiceImpl;
import de.audi.tghu.exlap.app.ExlapHandler;
import de.audi.tghu.exlap.ifc.enumeration.ContextStateEnumeration;
import de.audi.tghu.exlap.impl.worker.HasHelper;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.dsi.ifc.exlap.DSIExlap;
import org.dsi.ifc.exlap.Service;
import org.dsi.ifc.has.DSIHAS;
import org.dsi.ifc.has.HASDataContainer;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class ExlapHandlerImpl
implements ExlapHandler,
ServiceTrackerCustomizer,
ResultReceiver,
TimerListener,
ExlapStatusHandler {
    private DSIHAS dsiHas;
    private DSIExlap dsiExlap;
    private ServiceTracker tracker;
    private final Map availableServices = new HashMap();
    private final HasHelper hasHelper;
    private final IFrameworkAccess framework;
    private final BundleContext context;
    private final LogChannel log;
    private final ExlapDispatcher dispatcher;
    private final Set actionRequests = new HashSet();
    private Timer actionRequestTimer;
    private ExlapExlapServiceImpl exlapServiceImpl;
    private final long ACTION_REQUEST_TIMEOUT;
    private volatile boolean serverStarted = false;
    private volatile boolean exlapEnabled = false;
    private volatile boolean servicesAvailable = false;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ExlapStatusHandler;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ifc$service$ExlapExlapService;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ifc$service$ExlapMediaService;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ifc$service$ExlapNavigationService;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ifc$service$ExlapRadioService;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ifc$service$ExlapSoundService;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ifc$service$ExlapSystemService;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ifc$service$ExlapSettingsService;
    static /* synthetic */ Class class$de$audi$tghu$exlap$ExlapService;

    public ExlapHandlerImpl(BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        this.ACTION_REQUEST_TIMEOUT = 16000L;
        this.context = bundleContext;
        this.framework = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("App.Exlap.Handler");
        this.dispatcher = new ExlapDispatcher(iFrameworkAccess);
        this.hasHelper = new HasHelper(iFrameworkAccess);
        bundleContext.registerService((class$de$audi$tghu$exlap$ExlapStatusHandler == null ? (class$de$audi$tghu$exlap$ExlapStatusHandler = ExlapHandlerImpl.class$("de.audi.tghu.exlap.ExlapStatusHandler")) : class$de$audi$tghu$exlap$ExlapStatusHandler).getName(), (Object)this, (Dictionary)new Hashtable());
    }

    public void init(DSIHAS dSIHAS, DSIExlap dSIExlap, ExlapExlapServiceImpl exlapExlapServiceImpl) {
        this.dsiHas = dSIHAS;
        this.dsiExlap = dSIExlap;
        this.exlapServiceImpl = exlapExlapServiceImpl;
        exlapExlapServiceImpl.setContextState((class$de$audi$tghu$exlap$ifc$service$ExlapExlapService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapExlapService = ExlapHandlerImpl.class$("de.audi.tghu.exlap.ifc.service.ExlapExlapService")) : class$de$audi$tghu$exlap$ifc$service$ExlapExlapService).getName(), ContextStateEnumeration.UNAVAILABLE);
        exlapExlapServiceImpl.setContextState((class$de$audi$tghu$exlap$ifc$service$ExlapMediaService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapMediaService = ExlapHandlerImpl.class$("de.audi.tghu.exlap.ifc.service.ExlapMediaService")) : class$de$audi$tghu$exlap$ifc$service$ExlapMediaService).getName(), ContextStateEnumeration.UNAVAILABLE);
        exlapExlapServiceImpl.setContextState((class$de$audi$tghu$exlap$ifc$service$ExlapNavigationService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapNavigationService = ExlapHandlerImpl.class$("de.audi.tghu.exlap.ifc.service.ExlapNavigationService")) : class$de$audi$tghu$exlap$ifc$service$ExlapNavigationService).getName(), ContextStateEnumeration.UNAVAILABLE);
        exlapExlapServiceImpl.setContextState((class$de$audi$tghu$exlap$ifc$service$ExlapRadioService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapRadioService = ExlapHandlerImpl.class$("de.audi.tghu.exlap.ifc.service.ExlapRadioService")) : class$de$audi$tghu$exlap$ifc$service$ExlapRadioService).getName(), ContextStateEnumeration.UNAVAILABLE);
        exlapExlapServiceImpl.setContextState((class$de$audi$tghu$exlap$ifc$service$ExlapSoundService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapSoundService = ExlapHandlerImpl.class$("de.audi.tghu.exlap.ifc.service.ExlapSoundService")) : class$de$audi$tghu$exlap$ifc$service$ExlapSoundService).getName(), ContextStateEnumeration.UNAVAILABLE);
        exlapExlapServiceImpl.setContextState((class$de$audi$tghu$exlap$ifc$service$ExlapSystemService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapSystemService = ExlapHandlerImpl.class$("de.audi.tghu.exlap.ifc.service.ExlapSystemService")) : class$de$audi$tghu$exlap$ifc$service$ExlapSystemService).getName(), ContextStateEnumeration.UNAVAILABLE);
        exlapExlapServiceImpl.setContextState((class$de$audi$tghu$exlap$ifc$service$ExlapSettingsService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapSettingsService = ExlapHandlerImpl.class$("de.audi.tghu.exlap.ifc.service.ExlapSettingsService")) : class$de$audi$tghu$exlap$ifc$service$ExlapSettingsService).getName(), ContextStateEnumeration.UNAVAILABLE);
        this.addService((class$de$audi$tghu$exlap$ifc$service$ExlapExlapService == null ? (class$de$audi$tghu$exlap$ifc$service$ExlapExlapService = ExlapHandlerImpl.class$("de.audi.tghu.exlap.ifc.service.ExlapExlapService")) : class$de$audi$tghu$exlap$ifc$service$ExlapExlapService).getName(), exlapExlapServiceImpl);
        Thread thread = new Thread(this.dispatcher);
        thread.setName("ExlapDispatcher");
        thread.start();
        this.initTracker();
        dSIHAS.setNotification(this);
        dSIExlap.setNotification(this);
        dSIHAS.hmiReady();
    }

    public void deinit() {
        if (this.log != null) {
            this.log.log(1000000, "[ExlapHandlerImpl.deinit()] stopping ExlapHandlerImpl");
        }
        if (this.dsiHas != null) {
            this.dsiHas.clearNotification(this);
            this.dsiHas = null;
        }
        if (this.dsiExlap != null) {
            this.dsiExlap.stop();
            this.dsiExlap.clearNotification(this);
            this.dsiExlap = null;
        }
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
        if (this.dispatcher != null) {
            this.dispatcher.stop();
        }
    }

    private void initTracker() {
        String[] stringArray = new String[]{(class$de$audi$tghu$exlap$ExlapService == null ? (class$de$audi$tghu$exlap$ExlapService = ExlapHandlerImpl.class$("de.audi.tghu.exlap.ExlapService")) : class$de$audi$tghu$exlap$ExlapService).getName()};
        this.tracker = new ServiceTracker(this.context, stringArray, (ServiceTrackerCustomizer)this);
        this.tracker.open();
        this.log.log(1000000, "[ExlapHandlerImpl#initTracker()] Exlap tracker opened");
    }

    public synchronized void actionRequest(int n, int n2, HASDataContainer[] hASDataContainerArray) {
        this.log.log(1000000, "[ExlapHandlerImpl#actionRequest()] calling actionId: %1: ", (long)n2);
        String string = this.hasHelper.getClassForActionId(n2);
        ExlapService exlapService = (ExlapService)this.availableServices.get(string);
        if (exlapService == null) {
            this.log.log(100000, "[ExlapHandlerImpl#actionRequest()] actionRequest failed, service not available: %1", (Object)string);
            this.dsiHas.actionResult(n, n2, null, 16);
            return;
        }
        try {
            boolean bl;
            Container container = null;
            if (hASDataContainerArray != null) {
                container = this.hasHelper.createContainer(hASDataContainerArray);
            }
            if (!(bl = this.hasHelper.isImmediateResult(n2))) {
                this.pushActionRequest(n, n2);
            }
            this.hasHelper.callAction(n, n2, container, exlapService);
            if (bl) {
                this.dsiHas.actionResult(n, n2, null, 0);
            }
            this.log.log(10000000, "[ExlapHandlerImpl#actionRequest()] actionRequest success", (Object)string);
        }
        catch (Exception exception) {
            this.log.log(10000, "[ExlapHandlerImpl#actionRequest()] actionRequest failed for reason: %1", (Throwable)exception);
            this.actionResult(n, n2, null, 16);
        }
    }

    public void actionResult(int n, int n2, Container container) {
        this.actionResult(n, n2, container, 0);
    }

    public void actionResult(int n, int n2, Container container, int n3) {
        ActionRequest actionRequest = this.popActionRequest(n, n2);
        if (actionRequest == null) {
            this.log.log(100000, "[ExlapHandlerImpl#actionResult()] invalid action request, ignoring. requestId=%1 actionId=%2", (long)n, (long)n2);
            return;
        }
        HASDataContainer[] hASDataContainerArray = null;
        if (container != null) {
            hASDataContainerArray = container.createContainer();
        }
        this.dsiHas.actionResult(n, n2, hASDataContainerArray, n3);
        this.log.log(10000000, "[ExlapHandlerImpl#actionResult()] actionResult sent: %1", (Object)hASDataContainerArray);
        this.exlapServiceImpl.setContextState(this.hasHelper.getClassForActionId(actionRequest.getActionId()), ContextStateEnumeration.READY);
    }

    private synchronized void pushActionRequest(int n, int n2) {
        ActionRequest actionRequest = new ActionRequest(this.framework.getMonotonicTime(), n, n2);
        this.actionRequests.add(actionRequest);
        if (this.actionRequestTimer == null || !this.actionRequestTimer.isRunning()) {
            this.actionRequestTimer = new Timer("actionRequestTimer", 16000L, true, this);
            this.actionRequestTimer.start();
        }
    }

    private synchronized ActionRequest popActionRequest(int n, int n2) {
        Iterator iterator = this.actionRequests.iterator();
        while (iterator.hasNext()) {
            ActionRequest actionRequest = (ActionRequest)iterator.next();
            if (actionRequest.getRequestId() != n || actionRequest.getActionId() != n2) continue;
            iterator.remove();
            return actionRequest;
        }
        return null;
    }

    public synchronized void subscribeRequest(int n, int n2) {
        this.log.log(1000000, "[ExlapHandlerImpl#subscribeRequest()] subscribeRequest id: %1, interval: %2", (long)n, (long)n2);
        boolean bl = this.hasHelper.subscribe(n, n2);
        if (bl) {
            this.dsiHas.subscribeResult(n, 0);
            this.log.log(10000000, "[ExlapHandlerImpl#subscribeRequest()] subscribeResult: success");
        } else {
            this.dsiHas.subscribeResult(n, 1);
            this.log.log(10000000, "[ExlapHandlerImpl#subscribeRequest()] subscribeResult: error");
        }
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(1000000, "[ExlapHandlerImpl#asyncException()] asynchronous exception for %1: [%2] %3", (Object)new Integer(n2), (Object)new Integer(n), (Object)string);
    }

    public void unsubscribeRequest(int n) {
        this.log.log(1000000, "[ExlapHandlerImpl#unsubscribeRequest()] unsubscribeRequest id: %1", (long)n);
        this.hasHelper.unsubscribe(n);
    }

    public void unsubscribeAllRequest() {
        this.log.log(1000000, "[ExlapHandlerImpl#unsubscribeAllRequest()] unsubscribeAllRequest");
        this.hasHelper.unsubscribeAll();
    }

    public void getPropertyRequest(int n) {
    }

    public synchronized Object addingService(ServiceReference serviceReference) {
        String string = (String)serviceReference.getProperty("service_name");
        Object object = this.context.getService(serviceReference);
        if (object == null) {
            this.context.ungetService(serviceReference);
            return null;
        }
        if (!(object instanceof ExlapService)) {
            this.context.ungetService(serviceReference);
            return null;
        }
        if (string == null) {
            this.log.log(10000, "[ExlapHandlerImpl#addingService()] valid service received but property ExlapService.SERVICE_NAME is null: %1", (Object)object.getClass().getName());
            this.context.ungetService(serviceReference);
            return null;
        }
        ExlapService exlapService = (ExlapService)object;
        try {
            this.addService(string, exlapService);
        }
        catch (RuntimeException runtimeException) {
            this.log.log(10000, "[ExlapHandlerImpl#addingService()] unknown error while adding service: %1", (Throwable)runtimeException);
            this.exlapServiceImpl.setContextState(string, ContextStateEnumeration.ERROR);
            this.context.ungetService(serviceReference);
            return null;
        }
        return object;
    }

    private void addService(String string, ExlapService exlapService) {
        this.exlapServiceImpl.setContextState(string, ContextStateEnumeration.INITIALIZING);
        this.log.log(1000000, "[ExlapHandlerImpl#addingService()] new service installed: %1", (Object)string);
        exlapService.setResultReceiver(this);
        this.availableServices.put(string, exlapService);
        this.hasHelper.createWorkers(string, exlapService, this.dispatcher, this.dsiHas);
        exlapService.init();
        this.triggerSubscribeRequests();
        this.exlapServiceImpl.setContextState(string, ContextStateEnumeration.READY);
    }

    public synchronized void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public synchronized void removedService(ServiceReference serviceReference, Object object) {
        if (object == null) {
            return;
        }
        ExlapService exlapService = (ExlapService)object;
        String string = (String)serviceReference.getProperty("service_name");
        exlapService.setResultReceiver(new ResultReceiver(){

            public void actionResult(int n, int n2, Container container) {
            }
        });
        this.exlapServiceImpl.setContextState(string, ContextStateEnumeration.UNAVAILABLE);
        this.hasHelper.stopWorkers(string);
        this.availableServices.remove(string);
        this.context.ungetService(serviceReference);
        this.triggerSubscribeRequests();
    }

    private void triggerSubscribeRequests() {
        if (this.serverStarted) {
            this.log.log(1000000, "[ExlapHandlerImpl#triggerSubscribeRequests()] triggering new subscribe requests through calling start()");
            this.dsiExlap.start();
        }
    }

    public void startResult(int n) {
        if (n == 0) {
            this.serverStarted = true;
        } else {
            this.log.log(10000, "[ExlapHandlerImpl#startResult()] Exlap server start failed for unknown reason");
        }
    }

    public void stopResult(int n) {
        if (n == 0) {
            this.serverStarted = false;
        } else {
            this.log.log(10000, "[ExlapHandlerImpl#stopResult()] Exlap server stop failed for unknown reason");
        }
    }

    public void updateAvailableServices(Service[] serviceArray, int n) {
        if (n == 1) {
            if (this.atLeastOneAvailable(serviceArray)) {
                this.log.log(1000000, "[ExlapHandlerImpl#updateAvailableServices()] at least one service was available. Starting server. Services = %1", (Object)serviceArray);
                this.servicesAvailable = true;
                this.start();
            } else {
                this.log.log(10000, "[ExlapHandlerImpl#updateAvailableServices()] no valid services found. not starting.");
            }
        }
    }

    private boolean atLeastOneAvailable(Service[] serviceArray) {
        if (serviceArray == null) {
            this.log.log(10000, "[ExlapHandlerImpl#atLeastOneAvailable()] serviceAvailability is null");
            return false;
        }
        for (int i2 = 0; i2 < serviceArray.length; ++i2) {
            if (serviceArray[i2].status != 0) continue;
            return true;
        }
        return false;
    }

    public synchronized void fireTimer(Timer timer) {
        ActionRequest actionRequest = null;
        long l = this.framework.getMonotonicTime();
        Iterator iterator = this.actionRequests.iterator();
        while (iterator.hasNext()) {
            ActionRequest actionRequest2 = (ActionRequest)iterator.next();
            if (l >= actionRequest2.getTime() + 16000L) {
                iterator.remove();
                this.log.log(10000, "[ExlapHandlerImpl#fireTimer()] action request failed, HMI did not answer, sending fail. requestId=%1 actionId=%2", (long)actionRequest2.getRequestId(), (long)actionRequest2.getActionId());
                this.dsiHas.actionResult(actionRequest2.getRequestId(), actionRequest2.getActionId(), null, 16);
                this.exlapServiceImpl.setContextState(this.hasHelper.getClassForActionId(actionRequest2.getActionId()), ContextStateEnumeration.TEMPORARILY_UNAVAILABLE);
                continue;
            }
            if (actionRequest != null && actionRequest2.getTime() >= actionRequest.getTime()) continue;
            actionRequest = actionRequest2;
        }
        if (actionRequest != null) {
            this.log.log(10000000, "[ExlapHandlerImpl#fireTimer()] restarting action request timer. requestId=%1 actionId=%2", (long)actionRequest.getRequestId(), (long)actionRequest.getActionId());
            this.actionRequestTimer = new Timer("actionRequestTimer", actionRequest.getTime() + 16000L - l, true, this);
            this.actionRequestTimer.start();
        }
    }

    public void cancelTimer(Timer timer) {
    }

    public void setExlapStatus(boolean bl) {
        ExlapUtil.persistExlapStatus(this.framework, ExlapUtil.convertExlapStatus(bl));
        this.exlapEnabled = bl;
        if (this.exlapEnabled) {
            this.start();
        } else {
            this.stop();
        }
    }

    public boolean getExlapStatus() {
        return this.exlapEnabled;
    }

    private void start() {
        if (this.serverStarted) {
            this.log.log(1000000, "[ExlapHandlerImpl#start()] Exlap start requested but exlap is already started!");
            return;
        }
        if (!this.exlapEnabled) {
            this.log.log(1000000, "[ExlapHandlerImpl#start()] Exlap start requested but exlap is not enabled!");
            return;
        }
        if (!this.servicesAvailable) {
            this.log.log(1000000, "[ExlapHandlerImpl#start()] Exlap start requested but services are not available!");
            return;
        }
        this.log.log(10000000, "[ExlapHandlerImpl#start()] requesting exlap server start!");
        this.dsiExlap.start();
    }

    private void stop() {
        if (!this.serverStarted) {
            this.log.log(1000000, "[ExlapHandlerImpl#stop()] Exlap stop requested but exlap is already stopped!");
            return;
        }
        this.log.log(10000000, "[ExlapHandlerImpl#stop()] requesting exlap server stop!");
        this.dsiExlap.stop();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

