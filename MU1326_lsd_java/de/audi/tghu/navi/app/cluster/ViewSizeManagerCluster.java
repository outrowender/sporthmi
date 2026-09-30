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
    public void addViewSizeListener(IViewSizeListener iViewSizeListener) {
        if (iViewSizeListener == null) {
            return;
        }
        List list = this.viewSizeListeners;
        synchronized (list) {
            if (!this.viewSizeListeners.contains(iViewSizeListener)) {
                this.logChannel.log(1000000, "ViewSizeManagerCluster#addViewSizeListener() - Register listener");
                this.viewSizeListeners.add(iViewSizeListener);
            }
        }
        this.provideLastReceivedUpdate(iViewSizeListener);
    }

    public int getCurrentViewSize() {
        return this.currentViewSize;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setViewSize(final int n, boolean bl) {
        IViewSizeListener[] iViewSizeListenerArray;
        this.currentViewSize = n;
        List list = this.viewSizeListeners;
        synchronized (list) {
            iViewSizeListenerArray = (IViewSizeListener[])this.viewSizeListeners.toArray(new IViewSizeListener[this.viewSizeListeners.size()]);
        }
        this.logChannel.log(1000000, "ViewSizeManagerCluster#setViewSize( %1 ) - currentListeners: %2", (long)n, (long)iViewSizeListenerArray.length);
        for (int i2 = 0; i2 < iViewSizeListenerArray.length; ++i2) {
            try {
                final IViewSizeListener iViewSizeListener = iViewSizeListenerArray[i2];
                this.dispatcher.execute(new Runnable(){

                    public void run() {
                        iViewSizeListener.viewSizeChanged(n);
                    }
                });
                continue;
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "ViewSizeManagerCluster#setViewSize() - %1", (Throwable)exception);
            }
        }
    }

    private void provideLastReceivedUpdate(final IViewSizeListener iViewSizeListener) {
        this.logChannel.log(1000000, "ViewSizeManagerCluster#provideLastReceivedUpdate() - %1", (long)this.currentViewSize);
        try {
            this.dispatcher.execute(new Runnable(){

                public void run() {
                    iViewSizeListener.viewSizeChanged(ViewSizeManagerCluster.this.currentViewSize);
                }
            });
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "ViewSizeManagerCluster#provideLastReceivedUpdate() - %1", (Throwable)exception);
        }
    }

    public void optionMenuChange(int n) {
        this.logChannel.log(10000, "ViewSizeManagerCluster#optionMenuChange() - NOT IN USE!");
    }

    public void touchpadViewSizeChangeRequest() {
        this.logChannel.log(10000, "ViewSizeManagerCluster#touchpadViewSizeChangeRequest() - NOT IN USE!");
    }

    public int getViewSize(Screen screen) {
        this.logChannel.log(10000, "ViewSizeManagerCluster#getViewSize() - NOT IN USE!");
        return 0;
    }

    public IViewSizeChangeAnimationStatus getAnimationStatus() {
        this.logChannel.log(10000, "ViewSizeManagerCluster#getAnimationStatus() - NOT IN USE!");
        return null;
    }

    public void setScreen(Screen screen) {
        this.logChannel.log(10000, "ViewSizeManagerCluster#setScreen() - NOT IN USE!");
    }

    public void startTrackingServices(BundleContext bundleContext, HMITerminal hMITerminal) {
        this.logChannel.log(10000, "ViewSizeManagerCluster#startTrackingServices() - NOT IN USE!");
    }

    public void registerViewSizeManagerService(IFrameworkAccess iFrameworkAccess) {
        this.logChannel.log(10000, "ViewSizeManagerCluster#registerViewSizeManagerService() - NOT IN USE!");
    }

    public void requestViewSizeChange(int n) {
        this.logChannel.log(10000, "ViewSizeManagerCluster#requestViewSizeChange() - NOT IN USE!");
    }

    public void viewSizeKeyPressed() {
        this.logChannel.log(10000, "ViewSizeManagerCluster#viewSizeKeyPressed() - NOT IN USE!");
    }

    public int getPreferredViewSize() {
        this.logChannel.log(10000, "ViewSizeManagerCluster#getPreferredViewSize() - NOT IN USE!");
        return this.currentViewSize;
    }

    public void setPreferredViewSize(int n) {
        this.logChannel.log(10000, "ViewSizeManagerCluster#setPreferredViewSize() - NOT IN USE!");
    }

    public void requestLargeViewSize(int n) {
    }

    public void requestLargeViewSize(int n, int n2) {
    }

    public void unrequestLargeViewSize(int n) {
    }

    public void unrequestLargeViewSize(int n, int n2) {
    }

    public void unrequestLargeViewSize(int n, boolean bl) {
    }

    public void addViewSizeRequest(int n) {
    }

    public boolean isRequestActive(int n) {
        return false;
    }

    public void dumpAllViewSizeRequests() {
    }

    public int getRequestedViewSize() {
        return 0;
    }

    public void resetRequestedViewSize() {
    }

    public boolean isViewSizeInitialized() {
        return false;
    }

    public void releaseInvalidation() {
    }

    public boolean isNonScreenBasedRequestActive() {
        return false;
    }

    public boolean setLocked(boolean bl, boolean bl2) {
        return false;
    }

    public boolean isLocked() {
        return false;
    }

    public void setSportskinSmallStage(boolean bl) {
    }

    public boolean isSportskinSmallStage() {
        return false;
    }

    public void setRequestedViewSize(int n) {
    }

    public boolean isLargeViewSizeRequestActive() {
        return false;
    }

    public void setSelectionDrawerOpened(boolean bl) {
    }

    public void mfwArrowKeyPressed(int n, long l) {
    }

    public void requestEarlyViewSizeChange(int n, int n2) {
    }

    public LogChannel getLogChannel() {
        return null;
    }

    public void screenChangeStateFinished(int n) {
    }

    public void requestLargeViewSizeViaBitfield(long l) {
    }

    public boolean isKombiPopupHandlingActive() {
        return false;
    }

    public boolean isHMIPopupHandlingActive() {
        return false;
    }

    public boolean isAnimationRunning() {
        return false;
    }
}

