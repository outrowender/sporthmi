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
import de.audi.app.terminalmode.evo.MMICombiStageListener$1;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.mmicombi.IViewSizeManager;
import java.util.Map;

public class MMICombiStageListener
extends DefaultEventListener
implements ITerminalModeComponent,
IViewSizeListener,
IActionProxyListener {
    private static final String LOGCLASS;
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
        this.viewSizeMgrTracker = this.serviceManager.createServiceTracker(class$de$audi$atip$mmicombi$IViewSizeManager == null ? (class$de$audi$atip$mmicombi$IViewSizeManager = MMICombiStageListener.class$("de.audi.atip.mmicombi.IViewSizeManager")) : class$de$audi$atip$mmicombi$IViewSizeManager, new MMICombiStageListener$1(this));
    }

    @Override
    public void init() {
        this.logger.log(-2137614336, "[%1.init]", (Object)"MMICombiStageListener");
        this.viewSizeMgrTracker.open();
        this.eventBus.registerListener(this);
    }

    @Override
    public void deinit() {
        this.logger.log(-2137614336, "[%1.deinit]", (Object)"MMICombiStageListener");
        this.viewSizeMgrTracker.close();
        this.eventBus.unregisterListener(this);
    }

    @Override
    public void viewSizeChanged(int n) {
        if (1 == n) {
            this.logger.log(1078071040, "[%1.viewSizeChanged] SMALL_STAGE", (Object)"MMICombiStageListener");
            this.eventBus.updateKombiStage(false);
        } else if (2 == n) {
            this.logger.log(1078071040, "[%1.viewSizeChanged] BIG_STAGE", (Object)"MMICombiStageListener");
            this.eventBus.updateKombiStage(true);
        } else {
            this.logger.log(1078071040, "[%1.viewSizeChanged] Unknown view size = %2", (Object)"MMICombiStageListener", (long)n);
        }
        this.currentView = n;
    }

    @Override
    public void triggerBigStage() {
        if (2 != this.currentView && null != this.viewSizeManager) {
            this.logger.log(-2137614336, "[%1.triggerBigStage]", (Object)"MMICombiStageListener");
            this.actionProxyDispatcher.addActionProxyListener(1002, -1, this);
            this.viewSizeManager.requestLargeViewSize(9);
        }
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 1002) {
            this.logger.log(-2137614336, "[%1.actionProxyCallPerformed]", (Object)"MMICombiStageListener");
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

    static /* synthetic */ IServiceManager access$000(MMICombiStageListener mMICombiStageListener) {
        return mMICombiStageListener.serviceManager;
    }

    static /* synthetic */ IViewSizeManager access$102(MMICombiStageListener mMICombiStageListener, IViewSizeManager iViewSizeManager) {
        mMICombiStageListener.viewSizeManager = iViewSizeManager;
        return mMICombiStageListener.viewSizeManager;
    }

    static /* synthetic */ IViewSizeManager access$100(MMICombiStageListener mMICombiStageListener) {
        return mMICombiStageListener.viewSizeManager;
    }
}

