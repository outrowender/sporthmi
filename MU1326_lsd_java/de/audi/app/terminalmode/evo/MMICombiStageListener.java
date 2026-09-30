/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.evo;

import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.actionproxy.IActionProxyDispatcher;
import de.audi.app.terminalmode.actionproxy.IActionProxyListener;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.mmicombi.IViewSizeManager;
import java.util.Map;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class MMICombiStageListener
extends DefaultEventListener
implements ITerminalModeComponent,
IViewSizeListener,
IActionProxyListener {
    private static final String LOGCLASS = "MMICombiStageListener";
    private final LogChannel logger;
    private final IServiceManager serviceManager;
    private final IActionProxyDispatcher actionProxyDispatcher;
    private final IFrameworkAccess framework;
    private final IEventBus eventBus;
    private final IServiceTracker viewSizeMgrTracker;
    private volatile IViewSizeManager viewSizeManager;
    private volatile int currentView;
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IViewSizeManager;

    public MMICombiStageListener(ITerminalLogger iTerminalLogger, IServiceManager iServiceManager, IActionProxyDispatcher iActionProxyDispatcher, IFrameworkAccess iFrameworkAccess, IEventBus iEventBus) {
        this.logger = iTerminalLogger.hmi();
        this.serviceManager = iServiceManager;
        this.actionProxyDispatcher = iActionProxyDispatcher;
        this.framework = iFrameworkAccess;
        this.eventBus = iEventBus;
        this.viewSizeMgrTracker = this.serviceManager.createServiceTracker(class$de$audi$atip$mmicombi$IViewSizeManager == null ? (class$de$audi$atip$mmicombi$IViewSizeManager = MMICombiStageListener.class$("de.audi.atip.mmicombi.IViewSizeManager")) : class$de$audi$atip$mmicombi$IViewSizeManager, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                MMICombiStageListener.this.serviceManager.releaseService(serviceReference);
                MMICombiStageListener.this.viewSizeManager = null;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                Object object = MMICombiStageListener.this.serviceManager.getService(serviceReference);
                if (object instanceof IViewSizeManager && object != null) {
                    MMICombiStageListener.this.viewSizeManager = (IViewSizeManager)object;
                    MMICombiStageListener.this.viewSizeManager.addViewSizeListener(MMICombiStageListener.this);
                    MMICombiStageListener.this.viewSizeChanged(MMICombiStageListener.this.viewSizeManager.getCurrentViewSize());
                }
                return object;
            }
        });
    }

    public void init() {
        this.logger.log(10000000, "[%1.init]", (Object)LOGCLASS);
        this.viewSizeMgrTracker.open();
        this.eventBus.registerListener(this);
    }

    public void deinit() {
        this.logger.log(10000000, "[%1.deinit]", (Object)LOGCLASS);
        this.viewSizeMgrTracker.close();
        this.eventBus.unregisterListener(this);
    }

    public void viewSizeChanged(int n) {
        if (1 == n) {
            this.logger.log(1000000, "[%1.viewSizeChanged] SMALL_STAGE", (Object)LOGCLASS);
            this.eventBus.updateKombiStage(false);
        } else if (2 == n) {
            this.logger.log(1000000, "[%1.viewSizeChanged] BIG_STAGE", (Object)LOGCLASS);
            this.eventBus.updateKombiStage(true);
        } else {
            this.logger.log(1000000, "[%1.viewSizeChanged] Unknown view size = %2", (Object)LOGCLASS, (long)n);
        }
        this.currentView = n;
    }

    public void triggerBigStage() {
        if (2 != this.currentView && null != this.viewSizeManager) {
            this.logger.log(10000000, "[%1.triggerBigStage]", (Object)LOGCLASS);
            this.actionProxyDispatcher.addActionProxyListener(1002, -1, this);
            this.viewSizeManager.requestLargeViewSize(9);
        }
    }

    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 1002) {
            this.logger.log(10000000, "[%1.actionProxyCallPerformed]", (Object)LOGCLASS);
            this.actionProxyDispatcher.removeActionProxyListener(-1, this);
            if (null != this.viewSizeManager) {
                this.viewSizeManager.unrequestLargeViewSize(9);
            }
        }
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

