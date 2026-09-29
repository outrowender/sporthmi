/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeChangeAnimationStatus;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.cluster.ViewSizeManagerCluster$1;
import de.audi.tghu.navi.app.cluster.ViewSizeManagerCluster$2;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.List;
import org.osgi.framework.BundleContext;

public class ViewSizeManagerCluster
implements IViewSizeManager {
    private final LogChannel logChannel;
    private final List viewSizeListeners;
    private final DispatcherBase dispatcher;
    private int currentViewSize;

    public ViewSizeManagerCluster(NavigationEnv navigationEnv, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.viewSizeListeners = new ArrayList(5);
        this.dispatcher = navigationEnv.getFramework().getDispatcherManager().createDispatcher("ViewSizeNotificationDispatcher", new JobLogger(logChannel));
        this.dispatcher.start();
        this.currentViewSize = 2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addViewSizeListener(IViewSizeListener iViewSizeListener) {
        if (iViewSizeListener == null) {
            return;
        }
        List list = this.viewSizeListeners;
        synchronized (list) {
            if (!this.viewSizeListeners.contains(iViewSizeListener)) {
                this.logChannel.log(1078071040, "ViewSizeManagerCluster#addViewSizeListener() - Register listener");
                this.viewSizeListeners.add(iViewSizeListener);
            }
        }
        this.provideLastReceivedUpdate(iViewSizeListener);
    }

    @Override
    public int getCurrentViewSize() {
        return this.currentViewSize;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setViewSize(int n, boolean bl) {
        IViewSizeListener[] iViewSizeListenerArray;
        this.currentViewSize = n;
        List list = this.viewSizeListeners;
        synchronized (list) {
            iViewSizeListenerArray = (IViewSizeListener[])this.viewSizeListeners.toArray(new IViewSizeListener[this.viewSizeListeners.size()]);
        }
        this.logChannel.log(1078071040, "ViewSizeManagerCluster#setViewSize( %1 ) - currentListeners: %2", (long)n, (long)iViewSizeListenerArray.length);
        for (int i2 = 0; i2 < iViewSizeListenerArray.length; ++i2) {
            try {
                IViewSizeListener iViewSizeListener = iViewSizeListenerArray[i2];
                this.dispatcher.execute(new ViewSizeManagerCluster$1(this, iViewSizeListener, n));
                continue;
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "ViewSizeManagerCluster#setViewSize() - %1", (Throwable)exception);
            }
        }
    }

    private void provideLastReceivedUpdate(IViewSizeListener iViewSizeListener) {
        this.logChannel.log(1078071040, "ViewSizeManagerCluster#provideLastReceivedUpdate() - %1", (long)this.currentViewSize);
        try {
            this.dispatcher.execute(new ViewSizeManagerCluster$2(this, iViewSizeListener));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "ViewSizeManagerCluster#provideLastReceivedUpdate() - %1", (Throwable)exception);
        }
    }

    @Override
    public void optionMenuChange(int n) {
        this.logChannel.log(10000, "ViewSizeManagerCluster#optionMenuChange() - NOT IN USE!");
    }

    @Override
    public void touchpadViewSizeChangeRequest() {
        this.logChannel.log(10000, "ViewSizeManagerCluster#touchpadViewSizeChangeRequest() - NOT IN USE!");
    }

    @Override
    public int getViewSize(Screen screen) {
        this.logChannel.log(10000, "ViewSizeManagerCluster#getViewSize() - NOT IN USE!");
        return 0;
    }

    public IViewSizeChangeAnimationStatus getAnimationStatus() {
        this.logChannel.log(10000, "ViewSizeManagerCluster#getAnimationStatus() - NOT IN USE!");
        return null;
    }

    @Override
    public void setScreen(Screen screen) {
        this.logChannel.log(10000, "ViewSizeManagerCluster#setScreen() - NOT IN USE!");
    }

    @Override
    public void startTrackingServices(BundleContext bundleContext, HMITerminal hMITerminal) {
        this.logChannel.log(10000, "ViewSizeManagerCluster#startTrackingServices() - NOT IN USE!");
    }

    @Override
    public void registerViewSizeManagerService(IFrameworkAccess iFrameworkAccess) {
        this.logChannel.log(10000, "ViewSizeManagerCluster#registerViewSizeManagerService() - NOT IN USE!");
    }

    @Override
    public void requestViewSizeChange(int n) {
        this.logChannel.log(10000, "ViewSizeManagerCluster#requestViewSizeChange() - NOT IN USE!");
    }

    @Override
    public void viewSizeKeyPressed() {
        this.logChannel.log(10000, "ViewSizeManagerCluster#viewSizeKeyPressed() - NOT IN USE!");
    }

    @Override
    public int getPreferredViewSize() {
        this.logChannel.log(10000, "ViewSizeManagerCluster#getPreferredViewSize() - NOT IN USE!");
        return this.currentViewSize;
    }

    @Override
    public void setPreferredViewSize(int n) {
        this.logChannel.log(10000, "ViewSizeManagerCluster#setPreferredViewSize() - NOT IN USE!");
    }

    @Override
    public void requestLargeViewSize(int n) {
    }

    @Override
    public void requestLargeViewSize(int n, int n2) {
    }

    @Override
    public void unrequestLargeViewSize(int n) {
    }

    @Override
    public void unrequestLargeViewSize(int n, int n2) {
    }

    @Override
    public void unrequestLargeViewSize(int n, boolean bl) {
    }

    @Override
    public void addViewSizeRequest(int n) {
    }

    @Override
    public boolean isRequestActive(int n) {
        return false;
    }

    @Override
    public void dumpAllViewSizeRequests() {
    }

    @Override
    public int getRequestedViewSize() {
        return 0;
    }

    @Override
    public void resetRequestedViewSize() {
    }

    @Override
    public boolean isViewSizeInitialized() {
        return false;
    }

    @Override
    public void releaseInvalidation() {
    }

    @Override
    public boolean isNonScreenBasedRequestActive() {
        return false;
    }

    @Override
    public boolean setLocked(boolean bl, boolean bl2) {
        return false;
    }

    @Override
    public boolean isLocked() {
        return false;
    }

    @Override
    public void setSportskinSmallStage(boolean bl) {
    }

    @Override
    public boolean isSportskinSmallStage() {
        return false;
    }

    @Override
    public void setRequestedViewSize(int n) {
    }

    @Override
    public boolean isLargeViewSizeRequestActive() {
        return false;
    }

    @Override
    public void setSelectionDrawerOpened(boolean bl) {
    }

    @Override
    public void mfwArrowKeyPressed(int n, long l) {
    }

    @Override
    public void requestEarlyViewSizeChange(int n, int n2) {
    }

    @Override
    public LogChannel getLogChannel() {
        return null;
    }

    @Override
    public void screenChangeStateFinished(int n) {
    }

    @Override
    public void requestLargeViewSizeViaBitfield(long l) {
    }

    @Override
    public boolean isKombiPopupHandlingActive() {
        return false;
    }

    @Override
    public boolean isHMIPopupHandlingActive() {
        return false;
    }

    @Override
    public boolean isAnimationRunning() {
        return false;
    }

    static /* synthetic */ int access$000(ViewSizeManagerCluster viewSizeManagerCluster) {
        return viewSizeManagerCluster.currentViewSize;
    }
}

