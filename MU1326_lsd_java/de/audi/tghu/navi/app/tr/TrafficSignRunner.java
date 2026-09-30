/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.tr;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.tr.TrafficSignQueue;
import de.audi.tghu.navi.app.tr.TrafficUtil;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;

public class TrafficSignRunner
implements Runnable,
RenderingInfoProvider.TrafficSignCallback {
    private final IconHandler iconHandler;
    private LogChannel logChannel;
    private TrafficSignQueue queue;
    private volatile boolean active = true;
    private ChoiceModelApp trafficSignChoice;
    private ChoiceModelApp warningSignAsiaChoice;
    private int requestedSignID;
    private int requestedVariant;
    private boolean resultReceived;
    private RenderingInfo renderingInfoResult;
    private ResourceLocatorModelApp trafficSignResourceLocator;
    private ResourceLocatorModelApp warningSignAsiaResourceLocator;

    public TrafficSignRunner(LogChannel logChannel, IconHandler iconHandler, TrafficSignQueue trafficSignQueue, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ResourceLocatorModelApp resourceLocatorModelApp, ResourceLocatorModelApp resourceLocatorModelApp2) {
        this.logChannel = logChannel;
        this.iconHandler = iconHandler;
        this.queue = trafficSignQueue;
        this.trafficSignChoice = choiceModelApp;
        this.warningSignAsiaChoice = choiceModelApp2;
        this.trafficSignResourceLocator = resourceLocatorModelApp;
        this.warningSignAsiaResourceLocator = resourceLocatorModelApp2;
        this.showSign(-1, choiceModelApp, resourceLocatorModelApp);
        this.showSign(-1, choiceModelApp2, resourceLocatorModelApp2);
    }

    public void run() {
        Thread.currentThread().setName(Thread.currentThread().getName() + "Nav TrafficSign Worker");
        while (this.active) {
            TrafficSignInformation trafficSignInformation = this.queue.waitForNextTrafficSign();
            if (!this.active) {
                this.logChannel.log(10000000, "TrafficSignRunner#run() - stop requested");
                continue;
            }
            this.logChannel.log(10000000, "TrafficSignRunner#run() - processing traffic sign: %1", (Object)trafficSignInformation);
            this.resolveCurrentSign(trafficSignInformation, false, this.trafficSignChoice, this.trafficSignResourceLocator);
            if (!Util.isHURegionAsia()) continue;
            this.resolveCurrentSign(trafficSignInformation, true, this.warningSignAsiaChoice, this.warningSignAsiaResourceLocator);
        }
        this.logChannel.log(10000000, "TrafficSignRunner#run() - end thread");
    }

    private void resolveCurrentSign(TrafficSignInformation trafficSignInformation, boolean bl, ChoiceModelApp choiceModelApp, ResourceLocatorModelApp resourceLocatorModelApp) {
        if (trafficSignInformation == null) {
            this.showSign(-1, choiceModelApp, resourceLocatorModelApp);
        } else {
            int n;
            int n2 = trafficSignInformation.getHighestPrioritySign();
            int n3 = bl ? TrafficUtil.getSignID(trafficSignInformation, n2, 2) : TrafficUtil.getSignID(trafficSignInformation, n2, 0);
            int n4 = this.resolveSignID(n3, n = trafficSignInformation.getVariant());
            if (n4 != -1) {
                this.showSign(n4, choiceModelApp, resourceLocatorModelApp);
            } else {
                int n5 = trafficSignInformation.getSecondHighestPrioritySign();
                n3 = bl ? TrafficUtil.getSignID(trafficSignInformation, n5, 2) : TrafficUtil.getSignID(trafficSignInformation, n5, 0);
                n4 = this.resolveSignID(n3, n);
                if (n4 != -1) {
                    this.showSign(n4, choiceModelApp, resourceLocatorModelApp);
                } else {
                    int n6 = TrafficUtil.getThirdPrioritySign(n2, n5, trafficSignInformation);
                    n3 = bl ? TrafficUtil.getSignID(trafficSignInformation, n6, 2) : TrafficUtil.getSignID(trafficSignInformation, n6, 0);
                    n4 = this.resolveSignID(n3, n);
                    this.showSign(n4, choiceModelApp, resourceLocatorModelApp);
                }
            }
        }
    }

    void stop() {
        this.logChannel.log(10000000, "TrafficSignRunner#stop()");
        this.active = false;
        this.queue.postTrafficSign(new TrafficSignInformation());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int resolveSignID(int n, int n2) {
        if (n == 0) {
            return -1;
        }
        TrafficSignRunner trafficSignRunner = this;
        synchronized (trafficSignRunner) {
            this.resultReceived = false;
            this.requestedSignID = n;
            this.requestedVariant = n2;
            this.iconHandler.resolveTrafficSign(this.requestedSignID, this.requestedVariant, this);
            while (!this.resultReceived) {
                try {
                    this.wait();
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
            }
            int n3 = this.renderingInfoResult == null || !this.renderingInfoResult.isValid() ? -1 : this.renderingInfoResult.getResourceId();
            return n3;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void renderingInfoReceived(int n, int n2, RenderingInfo renderingInfo) {
        TrafficSignRunner trafficSignRunner = this;
        synchronized (trafficSignRunner) {
            if (this.requestedSignID == n) {
                if (this.requestedVariant == n2) {
                    this.renderingInfoResult = renderingInfo;
                    this.resultReceived = true;
                    this.notifyAll();
                } else {
                    this.logChannel.log(100000, "TrafficSignRunner#renderingInfoReceived() - variant ( %1 - %2 )", (long)this.requestedVariant, (long)n2);
                }
            } else {
                this.logChannel.log(100000, "TrafficSignRunner#renderingInfoReceived() - signID ( %1 - %2 )", (long)this.requestedSignID, (long)n);
            }
        }
    }

    private void showSign(int n, ChoiceModelApp choiceModelApp, ResourceLocatorModelApp resourceLocatorModelApp) {
        int n2;
        this.logChannel.log(1000000, "TrafficSignRunner#showSign() - resourceID: %3, model: %1, resModel: %2", (Object)choiceModelApp, (Object)resourceLocatorModelApp, (long)n);
        int n3 = n2 = n == -1 ? 0 : 1;
        if (choiceModelApp != null) {
            choiceModelApp.setValue(n);
            Util.setModelStatus(choiceModelApp, n2);
        } else {
            this.logChannel.log(10000000, "TrafficSignRunner#showSign() - traffic sign model is null!");
        }
        if (resourceLocatorModelApp != null) {
            resourceLocatorModelApp.setResourceLocator(new HMIResourceLocator(n));
            Util.setModelStatus(resourceLocatorModelApp, n2);
        } else {
            this.logChannel.log(10000000, "TrafficSignRunner#showSign() - trafficSignResourceLocator is null!");
        }
    }
}

