/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IMMICombiScreen;
import de.audi.atip.mmicombi.IMMICombiViewSizeSync;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.SystemProperties;
import de.esolutions.hmi.widgets.audi.base.animation.AnimationController;
import de.esolutions.hmi.widgets.audi.evo.DrawerAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.ViewSizeHistoryManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.ViewSizeAnimationManager;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ViewSizeManager
implements IViewSizeManager,
IWidgetLogChannel,
ISDSServiceStatusListener {
    private static final int DELAY_FOR_MFW = 1500;
    private static final int MIN_DELAY_FOR_MFW = 1000;
    private static final int TIME_FOR_FAST_MFW_KEY_TOOGLE = 1000;
    private static final int MAX_LOCKING_TIME = 3000;
    private int[] viewSizeRequests = new int[17];
    private boolean requestsInvalidated = false;
    private IMMICombiViewSizeSync mmiCombiViewSizeSync;
    private SDSService sdsService;
    private Screen currentScreen;
    private boolean viewSizeInitialized;
    private int currentViewSize = 2;
    private static final int STAGE_COUNT = 2;
    private IDrawerFocusManagerEvo drawerFocusManager;
    private List viewSizeListeners = new ArrayList(5);
    private final ViewSizeHistoryManager historyManager = new ViewSizeHistoryManager(this.currentViewSize);
    private ViewSizeAnimationManager viewSizeAnimationManager;
    private boolean drawerAnimationManagerInitialized;
    private Job historyViewSizeJob;
    private int numLocks = 0;
    private long lockingTime;
    private long timeStampMFW1;
    private long timeStampMFW2;
    private boolean isMFWDelayActive = true;
    private boolean isStageKeepingOnHMIPopupActive = SystemProperties.getBoolean("EnableStageKeepingOnHMIPopup", false);
    private boolean isStageKeepingOnCombiPopupActive = SystemProperties.getBoolean("EnableStageKeepingOnCombiPopup", true);
    private HMITerminalEvo terminal = null;
    private boolean sportskinSmallStage;
    private boolean selectionDrawerOpened;
    private int hideSmallStageIconNextScreenID = -1;
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IMMICombiViewSizeSync;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IViewSizeManager;

    public ViewSizeManager(HMITerminalEvo hMITerminalEvo) {
        this.terminal = hMITerminalEvo;
        AnimationController animationController = (AnimationController)hMITerminalEvo.getIAnimationController();
        if (animationController == null) {
            throw new IllegalStateException("AnimationController is not initialized yet");
        }
        this.drawerFocusManager = hMITerminalEvo.getDrawerFocusManager();
        DrawerAnimationManager drawerAnimationManager = this.drawerFocusManager instanceof DrawerFocusManager ? ((DrawerFocusManager)this.drawerFocusManager).getDrawerAnimationManager() : null;
        this.viewSizeAnimationManager = new ViewSizeAnimationManager(animationController, drawerAnimationManager, 2);
    }

    public void startTrackingServices(BundleContext bundleContext, HMITerminal hMITerminal) {
        this.initializeMMICombiViewSizeSyncTracker(bundleContext);
    }

    public void optionMenuChange(int n) {
    }

    public void touchpadViewSizeChangeRequest() {
    }

    public void setScreen(Screen screen) {
        if (screen == null) {
            if (this.currentScreen != null) {
                logViewSize.log(10000, "new screen is null, old screen: %1", (long)this.currentScreen.getID());
            } else {
                logViewSize.log(10000, "new screen is null and old screen is null");
            }
        } else {
            logViewSize.log(10000000, "ViewSizeManager#setScreen with ID = %1", (long)screen.getID());
            this.currentScreen = screen;
            if (this.hideSmallStageIconNextScreenID == this.currentScreen.getID()) {
                this.hideSmallStageIcon();
            }
            this.hideSmallStageIconNextScreenID = -1;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setViewSize(int n, boolean bl) {
        if (n != 2 && n != 1) {
            logViewSize.log(10000000, "ViewSizeManager#setViewSize invalid view size: %1", (long)n);
            return;
        }
        if (!this.viewSizeInitialized) {
            this.terminal.initializeViewSize(n);
        }
        logViewSize.log(1000000, "ViewSizeManager#setViewSize changing view size: %1->%2", (long)this.currentViewSize, (long)n);
        if (n == this.currentViewSize) {
            logViewSize.log(1000000, "ViewSizeManager#setViewSize not changing view size because it stayed the same");
            this.viewSizeInitialized = true;
            return;
        }
        if (this.currentScreen == null) {
            logViewSize.log(1000000, "ViewSizeManager#setViewSize no screen available therefore don't animate view size change");
            bl = false;
        }
        if (!bl) {
            this.terminal.initializeViewSize(n);
        }
        this.currentViewSize = n;
        this.historyManager.setCurrentViewSize(n);
        if (this.drawerFocusManager != null) {
            if (!this.drawerAnimationManagerInitialized) {
                logViewSize.log(1000000, "ViewSizeManager#setViewSize Initialize drawer with current view size.", (long)n);
                this.drawerFocusManager.setViewSize(n, false);
                this.drawerAnimationManagerInitialized = true;
            } else {
                this.drawerFocusManager.setViewSize(n, bl && this.viewSizeInitialized);
            }
        }
        float[] fArray = n == 1 ? ScreenWidgetEVO.SMALL_STAGE : ScreenWidgetEVO.BIG_STAGE;
        this.viewSizeAnimationManager.setTargetWeights(fArray, bl && this.viewSizeInitialized, n);
        this.viewSizeInitialized = true;
        Object[] objectArray = null;
        List list = this.viewSizeListeners;
        synchronized (list) {
            if (!this.viewSizeListeners.isEmpty()) {
                objectArray = this.viewSizeListeners.toArray();
            }
        }
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                IViewSizeListener iViewSizeListener = (IViewSizeListener)objectArray[i2];
                try {
                    iViewSizeListener.viewSizeChanged(n);
                    continue;
                }
                catch (Exception exception) {
                    logViewSize.log(10000, "ViewSizeManager#setViewSize Exception caught calling viewSizeChanged on listener %1", (Object)iViewSizeListener, (Throwable)exception);
                }
            }
        }
    }

    public int getCurrentViewSize() {
        return this.currentViewSize;
    }

    public int getViewSize(Screen screen) {
        return this.currentViewSize;
    }

    public void unrequestLargeViewSize(int n) {
        this.unrequestLargeViewSize(n, 0);
    }

    public void unrequestLargeViewSize(int n, int n2) {
        if (n == 1) {
            this.setSelectionDrawerOpened(false);
        }
        if (this.isRequestActive(n)) {
            if (this.requestsInvalidated && ViewSizeManager.isScreenBasedReason(n)) {
                logViewSize.log(10000000, "ViewSizeManager#unrequestLargeViewSize Try to unrequest for reason %1, but requests have already been invalidated. %2 requests are still active.", (long)n, (long)this.viewSizeRequests[n]);
                return;
            }
            this.releaseViewSizeRequest(n, true, n2);
        } else {
            logViewSize.log(100000, "ViewSizeManager#unrequestLargeViewSize Try to unrequest for reason %1, but no view size request active.", (long)n);
        }
    }

    public void unrequestLargeViewSize(int n, boolean bl) {
        if (bl) {
            this.unrequestLargeViewSize(n);
        } else {
            this.releaseViewSizeRequest(n, false, 0);
        }
    }

    public void requestEarlyViewSizeChange(int n, int n2) {
        logViewSize.log(10000000, "ViewSizeManager#requestEarlyViewSizeChange viewSize = %1, screenID = %2", (long)n, (long)n2);
        if (this.isStageKeepingOnCombiPopupActive && this.isRequestActive(13)) {
            logViewSize.log(10000000, "ViewSizeManager#requestEarlyViewSizeChange Do not request early viewSize = %1 because combi fullscreen popop is active.", (long)n);
            return;
        }
        if (this.isStageKeepingOnHMIPopupActive && this.isRequestActive(12)) {
            logViewSize.log(10000000, "ViewSizeManager#requestEarlyViewSizeChange Do not request early viewSize = %1 because hmi fullscreen popop is active.", (long)n);
            return;
        }
        this.requestViewSizeChangeWithDelay(n, 0, -1);
        if (this.currentScreen instanceof AbstractScreenWidget && ((AbstractScreenWidget)this.currentScreen).getSmallStageType() != 8) {
            if (this.currentScreen.getID() == n2) {
                this.hideSmallStageIcon();
            } else {
                this.hideSmallStageIconNextScreenID = n2;
            }
        }
    }

    private void hideSmallStageIcon() {
        logViewSize.log(10000000, "ViewSizeManager#hideSmallStageIcon screenID = %1", (long)this.currentScreen.getID());
        ((AbstractScreenWidget)this.currentScreen).setSmallStageIconOnScreen(false);
    }

    public void requestLargeViewSizeViaBitfield(long l) {
        if (logViewSize.isDebug()) {
            logViewSize.log(10000000, "ViewSizeManager#requestLargeViewSizeViaBitfield reasons = %1", (Object)Long.toBinaryString(l));
        }
        int n = 0;
        while (l > 0L) {
            long l2 = l & 1L;
            if (l2 > 0L) {
                this.requestLargeViewSize(n);
            }
            ++n;
            l >>= 1;
        }
    }

    public void requestLargeViewSize(int n) {
        this.requestLargeViewSize(n, 0);
    }

    public void requestLargeViewSize(int n, int n2) {
        if (n == 1 && !this.isSelectionDrawerOpened()) {
            logViewSize.log(1000000, "ViewSizeManager#requestLargeViewSize Drop request for reason %1. Selection drawer is not opened.", (long)n);
            return;
        }
        this.addViewSizeRequest(n);
        if (n == 12 || n == 13 || n == 14 || n == 15) {
            logViewSize.log(1000000, "ViewSizeManager#requestLargeViewSize Reason does not change the view's size.");
            return;
        }
        if (this.isRequestValid(n)) {
            if (this.currentScreen != null && this.currentScreen instanceof IMMICombiScreen && !((IMMICombiScreen)((Object)this.currentScreen)).isHMIScreen() && n == 16) {
                logViewSize.log(1000000, "ViewSizeManager#requestLargeViewSize kombi internal reason for large view size active, but hmi is not rendering current screen, not requesting large view size.");
            } else {
                this.requestViewSizeChangeWithDelay(2, n2, n);
            }
        }
    }

    public void requestViewSizeChange(int n) {
        if (this.mmiCombiViewSizeSync == null) {
            return;
        }
        int n2 = this.historyManager.getRequestedViewSize();
        if (this.getCurrentViewSize() != n || n2 != -1) {
            if (n2 != -1) {
                logViewSize.log(1000000, "ViewSizeManager#requestViewSizeChange A view size change seems to be active.");
                if (n2 == n) {
                    logViewSize.log(1000000, "ViewSizeManager#requestViewSizeChange don't request view size: %1 again", (long)n2);
                    return;
                }
            }
            if (this.isLocked()) {
                logViewSize.log(1000000, "ViewSizeManager#requestViewSizeChange Could not request the view size change %1->%2 because the view size manager is locked.", (long)this.currentViewSize, (long)n);
                return;
            }
            if (this.mmiCombiViewSizeSync.requestViewSize(n)) {
                logViewSize.log(1000000, "ViewSizeManager#requestViewSizeChange %1->%2", (long)this.currentViewSize, (long)n);
                this.setRequestedViewSize(n);
            } else {
                logViewSize.log(1000000, "ViewSizeManager#requestViewSizeChange request could not be send to kombi");
            }
        }
    }

    private void requestViewSizeChangeWithDelay(int n, int n2, int n3) {
        if (this.isMFWDelayEnabled() && (ViewSizeManager.isScreenBasedReason(n3) || n3 == -1)) {
            n2 = this.calculateDelay(n2);
        }
        if (n2 > 0) {
            this.restartHistoryViewSizeJob(n, n2);
        } else {
            this.cancelDelayedViewSizeJob();
            this.requestViewSizeChange(n);
        }
    }

    private void initializeMMICombiViewSizeSyncTracker(final BundleContext bundleContext) {
        final ViewSizeManager viewSizeManager = this;
        String[] stringArray = new String[]{(class$de$audi$atip$mmicombi$IMMICombiViewSizeSync == null ? (class$de$audi$atip$mmicombi$IMMICombiViewSizeSync = ViewSizeManager.class$("de.audi.atip.mmicombi.IMMICombiViewSizeSync")) : class$de$audi$atip$mmicombi$IMMICombiViewSizeSync).getName(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = ViewSizeManager.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName()};
        ServiceTracker serviceTracker = new ServiceTracker(bundleContext, stringArray, new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                Object object = bundleContext.getService(serviceReference);
                if (object instanceof IMMICombiViewSizeSync) {
                    ViewSizeManager.this.mmiCombiViewSizeSync = (IMMICombiViewSizeSync)object;
                } else if (object instanceof SDSService) {
                    ViewSizeManager.this.sdsService = (SDSService)object;
                    ViewSizeManager.this.sdsService.registerStatusListener(viewSizeManager);
                }
                return ViewSizeManager.this.mmiCombiViewSizeSync;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                if (object instanceof IMMICombiViewSizeSync) {
                    ViewSizeManager.this.mmiCombiViewSizeSync = null;
                } else if (object instanceof SDSService) {
                    ViewSizeManager.this.sdsService.unregisterStatusListener(viewSizeManager);
                    ViewSizeManager.this.sdsService = null;
                }
            }
        });
        serviceTracker.open();
    }

    public void registerViewSizeManagerService(IFrameworkAccess iFrameworkAccess) {
        Hashtable hashtable = new Hashtable();
        iFrameworkAccess.getBundleCxt().registerService(new String[]{(class$de$audi$atip$mmicombi$IViewSizeManager == null ? (class$de$audi$atip$mmicombi$IViewSizeManager = ViewSizeManager.class$("de.audi.atip.mmicombi.IViewSizeManager")) : class$de$audi$atip$mmicombi$IViewSizeManager).getName()}, (Object)this, (Dictionary)hashtable);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addViewSizeListener(IViewSizeListener iViewSizeListener) {
        List list = this.viewSizeListeners;
        synchronized (list) {
            this.viewSizeListeners.add(iViewSizeListener);
        }
    }

    public void viewSizeKeyPressed() {
        long l;
        logViewSize.log(1000000, "ViewSizeManager#viewSizeKeyPressed currentViewSize=%1", (long)this.getCurrentViewSize());
        this.releaseRequestsOnViewSizeKeyPressed();
        if (this.isLocked() && (l = AbstractWidget.framework.getMonotonicTime() - this.lockingTime) > 3000L) {
            this.numLocks = 0;
        }
        this.cancelDelayedViewSizeJob();
        if (this.currentScreen instanceof AbstractScreenWidget) {
            ((AbstractScreenWidget)this.currentScreen).setSmallStageIconOnScreen(true);
        }
    }

    public int getPreferredViewSize() {
        return this.historyManager.getPreferredViewSize();
    }

    public void setPreferredViewSize(int n) {
        this.historyManager.setPreferredViewSize(n);
        this.checkForHistoryStateChange();
    }

    public ViewSizeAnimationManager getViewSizeAnimationManager() {
        return this.viewSizeAnimationManager;
    }

    public void addViewSizeRequest(int n) {
        if (this.isRequestValid(n)) {
            logViewSize.log(10000000, "ViewSizeManager#addViewSizeRequest for reason = %1", (long)n);
            int n2 = n;
            this.viewSizeRequests[n2] = this.viewSizeRequests[n2] + 1;
        } else {
            logViewSize.log(10000, "ViewSizeManager#addViewSizeRequest Reason %1 is not valid.", (long)n);
        }
    }

    public void releaseInvalidation() {
        if (this.requestsInvalidated) {
            this.requestsInvalidated = false;
            logViewSize.log(10000000, "ViewSizeManager#releaseInvalidation");
        }
    }

    private void releaseRequestsOnViewSizeKeyPressed() {
        logViewSize.log(10000000, "ViewSizeManager#releaseRequestsOnViewSizeKeyPressed");
        this.viewSizeRequests[10] = 0;
        this.viewSizeRequests[11] = 0;
        this.viewSizeRequests[8] = 0;
        this.viewSizeRequests[7] = 0;
        this.viewSizeRequests[2] = 0;
        this.viewSizeRequests[3] = 0;
        this.viewSizeRequests[4] = 0;
        this.viewSizeRequests[5] = 0;
        this.viewSizeRequests[6] = 0;
        this.viewSizeRequests[9] = 0;
        this.viewSizeRequests[12] = 0;
        this.viewSizeRequests[13] = 0;
        this.viewSizeRequests[14] = 0;
        this.viewSizeRequests[0] = 0;
        this.viewSizeRequests[1] = 0;
        this.requestsInvalidated = true;
    }

    private void releaseViewSizeRequest(int n, boolean bl, int n2) {
        this.releaseViewSizeRequest(n, 1, bl, n2);
    }

    private void releaseViewSizeRequest(int n, int n2, boolean bl, int n3) {
        if (this.isRequestValid(n)) {
            logViewSize.log(10000000, "ViewSizeManager#releaseViewSizeRequest for reason = %1", (long)n);
            this.viewSizeRequests[n] = Math.max(0, this.viewSizeRequests[n] - n2);
            int n4 = this.getNumberOfViewSizeRequests();
            if (n4 == 0) {
                if (this.historyManager.isHistoryStateChangeRequired()) {
                    if (bl) {
                        if (this.currentScreen != null && ((IMMICombiScreen)((Object)this.currentScreen)).isHMIScreen()) {
                            logViewSize.log(10000000, "ViewSizeManager#releaseViewSizeRequest Restore desired stage from history state.");
                            this.requestViewSizeChangeWithDelay(this.historyManager.getPreferredViewSize(), n3, n);
                        } else {
                            logViewSize.log(10000000, "ViewSizeManager#releaseViewSizeRequest do not restored desired stage from history because combi screen is active");
                        }
                    } else {
                        logViewSize.log(10000000, "ViewSizeManager#releaseViewSizeRequest Do not restore the preferred view size.");
                    }
                } else {
                    this.cancelDelayedViewSizeJob();
                    logViewSize.log(10000000, "ViewSizeManager#releaseViewSizeRequest No history state change required.");
                }
            } else {
                logViewSize.log(10000000, "ViewSizeManager#releaseViewSizeRequest There are %1 requests for the current view size.", (long)n4);
                this.dumpAllActiveViewSizeRequests();
            }
        } else {
            logViewSize.log(10000, "ViewSizeManager#releaseViewSizeRequest Reason %1 is not valid.", (long)n);
        }
    }

    private int calculateDelay(int n) {
        long l = AbstractWidget.framework.getMonotonicTime();
        long l2 = l - this.timeStampMFW1;
        long l3 = l - this.timeStampMFW2;
        if (l2 + (long)n < 1000L) {
            n = (int)((long)n + (1500L - (l2 + (long)n)));
            logViewSize.log(10000000, "ViewSizeManager#calculateDelay Job is delayed for %1 ms by MFW arrows.", (long)n);
        } else if (l3 + (long)n < 1000L) {
            n = (int)((long)n + (1000L - (l3 + (long)n)));
            logViewSize.log(10000000, "ViewSizeManager#calculateDelay Job is delayed for %1 ms by MFW arrows.", (long)n);
        }
        return n;
    }

    private void cancelDelayedViewSizeJob() {
        if (this.historyViewSizeJob != null) {
            this.historyViewSizeJob.cancel();
            this.historyViewSizeJob = null;
        }
    }

    public void checkForHistoryStateChange() {
        if (this.getNumberOfViewSizeRequests() == 0) {
            if (this.historyManager.isHistoryStateChangeRequired()) {
                logViewSize.log(10000000, "ViewSizeManager#checkForHistoryStateChange Restore desired stage from history state.");
                this.requestViewSizeChangeWithDelay(this.historyManager.getPreferredViewSize(), 0, -1);
            } else {
                this.cancelDelayedViewSizeJob();
                logViewSize.log(10000000, "ViewSizeManager#checkForHistoryStateChange No history state change required.");
            }
        }
    }

    private void checkForStateChange() {
        if (this.getNumberOfViewSizeRequests() == 0) {
            this.checkForHistoryStateChange();
        } else if ((this.historyManager.getCurrentViewSize() == 1 || this.historyManager.getRequestedViewSize() == 1) && this.isActiveLargeViewSizeRequestActive()) {
            this.requestViewSizeChangeWithDelay(2, 0, -1);
        }
    }

    private int getNumberOfViewSizeRequests() {
        int n = 0;
        for (int i2 = 0; i2 < 17; ++i2) {
            n += this.viewSizeRequests[i2];
        }
        return n;
    }

    public void dumpAllActiveViewSizeRequests() {
        for (int i2 = 0; i2 < 17; ++i2) {
            int n = this.viewSizeRequests[i2];
            if (n <= 0) continue;
            logViewSize.log(10000000, "ViewSizeManager#dumpAllActiveViewSizeRequests %2 requests for reason %1", (long)i2, (long)n);
        }
    }

    public void dumpAllViewSizeRequests() {
        for (int i2 = 0; i2 < 17; ++i2) {
            logViewSize.log(10000000, "ViewSizeManager#dumpAllViewSizeRequests %2 requests for reason %1", (long)i2, (long)this.viewSizeRequests[i2]);
        }
    }

    public void restartHistoryViewSizeJob(int n, int n2) {
        this.cancelDelayedViewSizeJob();
        logViewSize.log(10000000, "ViewSizeManager#restartHistoryViewSizeJob creating new job");
        this.historyViewSizeJob = AbstractWidget.hmiService.getEventDispatcher().postEvent(new RunnableEvent(false, new DelayedViewSizeChange(n)), n2);
    }

    private boolean isRequestValid(int n) {
        return 0 <= n && n <= 17;
    }

    private boolean isSelectionDrawerOpened() {
        return this.selectionDrawerOpened;
    }

    public boolean isActiveLargeViewSizeRequestActive() {
        long l = 0L;
        for (int i2 = 0; i2 < 17; ++i2) {
            l |= (long)((this.viewSizeRequests[i2] > 0 ? 1 : 0) << i2);
        }
        long l2 = 61440L;
        long l3 = l2 ^ 0xFFFFFFFFFFFFFFFFL;
        if (logViewSize.isDebug()) {
            logViewSize.log(10000000, "ViewSizeManager#isActiveLargeViewSizeRequestActive activeRequests = %1, activeRequestMask = %2", (Object)Long.toBinaryString(l), (Object)Long.toBinaryString(l3));
        }
        return (l & l3) > 0L;
    }

    public boolean isLargeViewSizeRequestActive() {
        return this.getNumberOfViewSizeRequests() > 0;
    }

    public boolean isRequestActive(int n) {
        if (this.isRequestValid(n)) {
            return this.viewSizeRequests[n] > 0;
        }
        return false;
    }

    private static boolean isScreenBasedReason(int n) {
        boolean bl;
        switch (n) {
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 9: 
            case 12: 
            case 13: 
            case 14: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    public int getRequestedViewSize() {
        int n = this.historyManager.getRequestedViewSize();
        logViewSize.log(10000000, "ViewSizeManager#getRequestedViewSize requestedViewSize = %1", (long)n);
        return n;
    }

    public void resetRequestedViewSize() {
        this.historyManager.setRequestedViewSize(-1);
    }

    public void setRequestedViewSize(int n) {
        this.historyManager.setRequestedViewSize(n);
    }

    public void setSelectionDrawerOpened(boolean bl) {
        this.selectionDrawerOpened = bl;
    }

    public boolean isViewSizeInitialized() {
        return this.viewSizeInitialized;
    }

    public boolean isNonScreenBasedRequestActive() {
        boolean bl = false;
        bl |= this.isRequestActive(15);
        bl |= this.isRequestActive(10);
        bl |= this.isRequestActive(11);
        bl |= this.isRequestActive(16);
        return bl |= this.isRequestActive(1) && this.isSelectionDrawerOpened();
    }

    public boolean isLocked() {
        return this.numLocks > 0;
    }

    public boolean setLocked(boolean bl, boolean bl2) {
        if (bl) {
            this.lockingTime = AbstractWidget.framework.getMonotonicTime();
        }
        int n = this.numLocks;
        if (logViewSize.isDebug()) {
            logViewSize.log(10000000, "ViewSizeManager#setLocked locksBefore = %1, lock = %2, restoreViewSize = %3", (Object)String.valueOf(n), (Object)String.valueOf(bl), (Object)String.valueOf(bl2));
        }
        this.numLocks += bl ? 1 : -1;
        if (this.numLocks < 0) {
            logViewSize.log(10000, "ViewSizeManager#setLocked Number of locks is below 0 (%1).", (long)this.numLocks);
            this.numLocks = 0;
        }
        logViewSize.log(10000000, "ViewSizeManager#setLocked numLocks = %1", (long)this.numLocks);
        if (n > 0 && this.numLocks == 0) {
            if (bl2) {
                this.checkForStateChange();
            }
            return true;
        }
        return n == 0 && this.numLocks > 0;
    }

    public void setSportskinSmallStage(boolean bl) {
        this.sportskinSmallStage = bl;
    }

    public boolean isSportskinSmallStage() {
        if (this.terminal.getSkin() != 1) {
            return false;
        }
        return this.sportskinSmallStage;
    }

    public void mfwArrowKeyPressed(int n, long l) {
        if (this.isMFWDelayEnabled()) {
            logViewSize.log(10000000, "ViewSizeManager#mfwArrowKeyPressed keyState = %1, timeStamp = %2", (long)n, l);
            if (n != 0) {
                long l2 = l;
                this.timeStampMFW1 = this.timeStampMFW2;
                this.timeStampMFW2 = l2;
                if (this.historyViewSizeJob != null) {
                    RunnableEvent runnableEvent = (RunnableEvent)this.historyViewSizeJob.getPayload();
                    DelayedViewSizeChange delayedViewSizeChange = (DelayedViewSizeChange)runnableEvent.getRunnable();
                    this.restartHistoryViewSizeJob(delayedViewSizeChange.desiredViewSize, this.calculateDelay(0));
                }
            }
        } else {
            logViewSize.log(1000000, "ViewSizeManager#mfwArrowKeyPressed MFW delay for automatic view size change is disabled.");
        }
    }

    public void notifySDSDialogStarted() {
        this.requestLargeViewSize(15);
    }

    public void notifySDSDialogAborting() {
    }

    public void notifySDSDialogEnded() {
        this.unrequestLargeViewSize(15, 500);
    }

    public LogChannel getLogChannel() {
        return logViewSize;
    }

    public void setEnableMFWDealyForAutomaticViewSizeChange(boolean bl) {
        this.isMFWDelayActive = bl;
    }

    public boolean isMFWDelayEnabled() {
        return this.isMFWDelayActive;
    }

    public void setEnableStageKeepingForPopup(boolean bl, boolean bl2) {
        this.isStageKeepingOnHMIPopupActive = bl;
        this.isStageKeepingOnCombiPopupActive = bl2;
    }

    public boolean isKombiPopupHandlingActive() {
        return this.isStageKeepingOnCombiPopupActive;
    }

    public boolean isHMIPopupHandlingActive() {
        return this.isStageKeepingOnHMIPopupActive;
    }

    public void screenChangeStateFinished(int n) {
        if (this.isMFWDelayActive && this.historyViewSizeJob != null && this.executeDelayedJobAfterScreenChange(n)) {
            this.historyViewSizeJob.cancel();
            RunnableEvent runnableEvent = (RunnableEvent)this.historyViewSizeJob.getPayload();
            runnableEvent.dispatch();
        }
    }

    private boolean executeDelayedJobAfterScreenChange(int n) {
        if (n == 2) {
            return AbstractWidget.framework.getMonotonicTime() - this.timeStampMFW2 > 300L || this.timeStampMFW2 - this.timeStampMFW1 > 1000L;
        }
        if (n == 1) {
            return AbstractWidget.framework.getMonotonicTime() - this.timeStampMFW2 > 200L || this.timeStampMFW2 - this.timeStampMFW1 > 1000L;
        }
        return false;
    }

    public boolean isAnimationRunning() {
        return this.viewSizeAnimationManager.isAnimationRunning();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class DelayedViewSizeChange
    implements Runnable {
        private int desiredViewSize;

        public DelayedViewSizeChange(int n) {
            this.desiredViewSize = n;
        }

        public void run() {
            IWidgetLogChannel.logViewSize.log(10000000, "DelayedViewSizeChange#run Requesting stage %1", (long)this.desiredViewSize);
            if (this.desiredViewSize == 2) {
                ViewSizeManager.this.requestViewSizeChange(this.desiredViewSize);
            } else if (this.desiredViewSize == 1 && ViewSizeManager.this.getNumberOfViewSizeRequests() == 0) {
                ViewSizeManager.this.requestViewSizeChange(this.desiredViewSize);
            } else {
                IWidgetLogChannel.logViewSize.log(10000000, "DelayedViewSizeChange#run Requesting stage %1, but new reasons appeared in the meantime.", (long)this.desiredViewSize);
            }
            ViewSizeManager.this.historyViewSizeJob = null;
        }
    }
}

