/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.cluster.ClusterKDKHandler;
import de.audi.tghu.navi.app.cluster.CombiBAPListener;
import de.audi.tghu.navi.app.interapp.IViewSizeChangeHandler;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public class ClusterKDKHandlerImpl
implements ClusterKDKHandler {
    private static int Q7FPK_FALLBACK_TIMEOUT = -1;
    private final NavigationEnv env;
    private LogChannel logChannel;
    private boolean komoViewEnabled = false;
    private boolean komoViewVisible = false;
    private boolean rgActive = false;
    private boolean isInStandBy = false;
    private boolean clamp15 = true;
    private volatile boolean kdkAvailable = false;
    private volatile boolean kdkVisible = false;
    private volatile boolean expectedKdkVisibilityInTheFuture = false;
    private IViewSizeChangeHandler viewSizeChangeHandler;
    private ChoiceModelApp kdkControlModel;
    private CombiBAPListener combiBapListener;
    private final Object mutex = new Object();
    private final Timer fallbackTimer;

    public ClusterKDKHandlerImpl(NavigationEnv navigationEnv, IViewSizeChangeHandler iViewSizeChangeHandler, CombiBAPListener combiBAPListener) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getClusterLogChannel();
        this.viewSizeChangeHandler = iViewSizeChangeHandler;
        this.combiBapListener = combiBAPListener;
        iViewSizeChangeHandler.addViewSizeChangedListener(this);
        this.kdkControlModel = navigationEnv.getChoiceModel(1, 168);
        this.kdkControlModel.forceUpdate(true);
        this.kdkControlModel.resetHints();
        this.kdkControlModel.publishHints();
        this.fallbackTimer = Util.isClusterMapFPK(navigationEnv.getFramework()) && Q7FPK_FALLBACK_TIMEOUT > 0 ? new Timer("ClusterKDKHandler#fallbackTimer", Q7FPK_FALLBACK_TIMEOUT, true, new DefaultTimerListener(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void fireTimer(Timer timer) {
                Object object = ClusterKDKHandlerImpl.this.mutex;
                synchronized (object) {
                    if (ClusterKDKHandlerImpl.this.expectedKdkVisibilityInTheFuture != ClusterKDKHandlerImpl.this.kdkVisible) {
                        ClusterKDKHandlerImpl.this.logChannel.log(100000, "ClusterKDKHandler - did not get request from Kombi in time... setting expected KDK visibility: %1", ClusterKDKHandlerImpl.this.expectedKdkVisibilityInTheFuture);
                        ClusterKDKHandlerImpl.this.setKDKVisibility(ClusterKDKHandlerImpl.this.expectedKdkVisibilityInTheFuture);
                    }
                }
            }
        }) : null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateKOMOViewEnabled(boolean bl) {
        this.logChannel.log(1000000, "ClusterKDKHandler#setKOMOViewEnabled( %1 )", bl);
        Object object = this.mutex;
        synchronized (object) {
            this.komoViewEnabled = bl;
            this.refreshState();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateKOMOViewVisible(boolean bl) {
        this.logChannel.log(1000000, "ClusterKDKHandler#setKOMOViewVisible( %1 )", bl);
        Object object = this.mutex;
        synchronized (object) {
            this.komoViewVisible = bl;
            this.refreshState();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateRgActive(boolean bl) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "ClusterKDKHandler#updateRgActive( %1 )", bl);
        }
        Object object = this.mutex;
        synchronized (object) {
            this.rgActive = bl;
            this.refreshState();
        }
    }

    private void refreshState() {
        this.refreshState(this.kdkVisible);
    }

    private void refreshState(boolean bl) {
        if (!Util.isClusterMMI(this.env.getFramework()) && !Util.isClusterMapFPK(this.env.getFramework())) {
            this.logChannel.log(100000000, "ClusterKDKHandler#refreshKDKVisibility() - not running on MMI-Cluster/FPK - ignore");
            return;
        }
        Buffer buffer = new Buffer(100);
        buffer.append("komoViewEnabled: ").append(this.komoViewEnabled).append(", komoViewVisible: ").append(this.komoViewVisible).append(", rgActive: ").append(this.rgActive).append(", isInStandBy: ").append(this.isInStandBy).append(", clamp15: ").append(this.clamp15);
        this.logChannel.log(1000000, "ClusterKDKHandler#refreshState() - %1", (Object)buffer);
        boolean bl2 = this.komoViewEnabled && this.komoViewVisible;
        boolean bl3 = this.expectedKdkVisibilityInTheFuture = bl2 && !this.isInStandBy && this.rgActive;
        if (Util.isClusterMapFPK(this.env.getFramework())) {
            boolean bl4 = this.expectedKdkVisibilityInTheFuture = this.expectedKdkVisibilityInTheFuture && this.clamp15;
        }
        if (Util.isClusterMMI(this.env.getFramework())) {
            bl = this.expectedKdkVisibilityInTheFuture;
        }
        buffer.clear();
        buffer.append("KDK available: ").append(this.kdkAvailable).append(" -> ").append(bl2);
        buffer.append(", KDK visible: ").append(this.kdkVisible).append(" -> ").append(bl);
        buffer.append(", expected KDK visibility: ").append(this.expectedKdkVisibilityInTheFuture);
        this.logChannel.log(1000000, "ClusterKDKHandler#refreshState() - %1", (Object)buffer);
        if (this.fallbackTimer != null) {
            if (this.expectedKdkVisibilityInTheFuture != bl) {
                this.fallbackTimer.restart();
            } else {
                this.fallbackTimer.cancel();
            }
        }
        if (bl2 != this.kdkAvailable || bl != this.kdkVisible) {
            this.kdkAvailable = bl2;
            this.kdkVisible = bl;
            this.refreshHints();
            this.notifyKombi();
        }
    }

    private void notifyKombi() {
        if (Util.isClusterMMI(this.env.getFramework())) {
            this.logChannel.log(100000000, "ClusterKDKHandler#notifyKombi() - ignoring (is cluster MMI)");
            return;
        }
        this.combiBapListener.setSupplementaryMapVisibility(this.kdkVisible, true);
        if (this.kdkAvailable) {
            this.combiBapListener.setSupplementaryMapView(1);
        } else {
            this.combiBapListener.setSupplementaryMapView(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setKDKVisibility(boolean bl) {
        if (!Util.isClusterMapFPK(this.env.getFramework())) {
            this.logChannel.log(10000000, "ClusterKDKHandler#setKDKVisibility() - not running on Q7-FPK version - ignore");
            return;
        }
        this.logChannel.log(1000000, "ClusterKDKHandler#setKDKVisibility() - visible: %1", bl);
        Object object = this.mutex;
        synchronized (object) {
            this.refreshState(bl);
        }
    }

    private void refreshHints() {
        this.setKDKVisibilityHints();
        this.setKDKPositionHints();
        this.kdkControlModel.publishHints();
    }

    private void setKDKVisibilityHints() {
        this.logChannel.log(1000000, "ClusterKDKHandler#setKDKVisibilityHints() - KDK available: %1, KDK visible: %2", this.kdkAvailable, this.kdkVisible);
        if (this.kdkVisible) {
            this.kdkControlModel.addHint(16);
        } else {
            this.kdkControlModel.removeHint(16);
        }
        if (this.kdkAvailable && Util.isClusterMapFPK(this.env.getFramework()) || this.kdkVisible) {
            this.kdkControlModel.addHint(4);
        } else {
            this.kdkControlModel.removeHint(4);
        }
    }

    private void setKDKPositionHints() {
        if (!Util.isClusterMapFPK(this.env.getFramework())) {
            this.logChannel.log(100000000, "ClusterKDKHandler#viewSizeChanged() - not running on Q7-FPK version - ignore");
            return;
        }
        if (this.viewSizeChangeHandler.isSmallStageActive()) {
            this.kdkControlModel.addHint(8);
            this.logChannel.log(1000000, "ClusterKDKHandler#setKDKPositionHints() - small stage - kdk in tube");
        } else {
            this.kdkControlModel.removeHint(8);
            this.logChannel.log(1000000, "ClusterKDKHandler#setKDKPositionHints() - big stage - kdk in flap");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void viewSizeChanged(int n) {
        this.logChannel.log(1000000, "ClusterKDKHandler#viewSizeChanged() - newViewSize: %1", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            this.refreshHints();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyPowerListenerOnEnterState(int n, int n2) {
        this.logChannel.log(1000000, "ClusterKDKHandler#notifyPowerListenerOnEnterState( %1 )", (long)n);
        if (n == 2) {
            Object object = this.mutex;
            synchronized (object) {
                if (!this.isInStandBy) {
                    this.isInStandBy = true;
                    this.refreshState();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyPowerListenerOnExitState(int n, int n2) {
        this.logChannel.log(1000000, "ClusterKDKHandler#notifyPowerListenerOnExitState( %1 )", (long)n);
        if (n == 2) {
            Object object = this.mutex;
            synchronized (object) {
                if (this.isInStandBy) {
                    this.isInStandBy = false;
                    this.refreshState();
                }
            }
        }
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.logChannel.log(1000000, "ClusterKDKHandler#updateClampState() - clamp15 = %1", bl2);
        Object object = this.mutex;
        synchronized (object) {
            this.clamp15 = bl2;
            this.refreshState();
        }
    }

    public void cleanup() {
        if (this.fallbackTimer != null) {
            this.fallbackTimer.cancel();
        }
    }
}

