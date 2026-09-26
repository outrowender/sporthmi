/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.ComponentState;
import de.audi.atip.startup.StartupManager;
import de.audi.atip.startup.StartupManager$BundleJob;
import de.audi.atip.timer.WatchDog;
import de.esolutions.fw.util.commons.Buffer;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

class StartupManager$StartBundle
implements StartupManager$BundleJob {
    private final Bundle bundle;
    private final String bundleName;
    private final ComponentState componentState;
    private final /* synthetic */ StartupManager this$0;

    StartupManager$StartBundle(StartupManager startupManager, Bundle bundle, ComponentState componentState) {
        this.this$0 = startupManager;
        this.bundle = bundle;
        this.bundleName = StartupManager.access$200(startupManager, bundle);
        this.componentState = componentState;
    }

    public String toString() {
        return new Buffer().append("StartBundle: ").append(this.bundleName).toString();
    }

    @Override
    public String getBundleName() {
        return this.bundleName;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        WatchDog watchDog = null;
        if (this.componentState != null) {
            if (this.componentState.isDomainFailed()) {
                StartupManager.access$300(this.this$0).log(1078071040, "Bundle: %1 Do not start due to domain error!", (Object)this.bundleName);
                return;
            }
            if (this.componentState.isWaitingForDomainStart()) {
                StartupManager.access$300(this.this$0).log(1078071040, "Bundle: %1 Do not start, startDomain call is still pending!", (Object)this.bundleName);
                return;
            }
        }
        try {
            watchDog = StartupManager.access$400(this.this$0, new StringBuffer().append("Start of bundle timed out: ").append(this.bundleName).toString());
            this.this$0.getBundleHandler().startBundle(this.bundle);
            StartupManager.access$500(this.this$0, this.bundleName);
        }
        catch (BundleException bundleException) {
            StartupManager.access$300(this.this$0).log(10000, "Start of Bundle %1 failed!", (Object)this.bundleName, (Throwable)bundleException);
            StartupManager.access$500(this.this$0, this.bundleName);
            this.this$0.getFramework().getErrorMgr().handleError(bundleException, new StringBuffer().append("Error starting bundle (").append(this.bundleName).append(")").toString(), 0, 0, 0);
        }
        catch (RuntimeException runtimeException) {
            StartupManager.access$500(this.this$0, this.bundleName);
            this.this$0.logStartupEvent(StartupManager.access$300(this.this$0), 10000, new StringBuffer().append("StartBundle#run() - Start of Bundle ").append(this.bundleName).append(" failed!").toString(), runtimeException);
        }
        finally {
            if (watchDog != null) {
                watchDog.cancel();
            }
        }
    }
}

