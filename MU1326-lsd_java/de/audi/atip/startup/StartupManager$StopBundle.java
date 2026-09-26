/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.StartupManager;
import de.audi.atip.startup.StartupManager$BundleJob;
import de.audi.atip.timer.WatchDog;
import de.esolutions.fw.util.commons.Buffer;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

class StartupManager$StopBundle
implements StartupManager$BundleJob {
    private final Bundle bundle;
    private final String bundleName;
    private final /* synthetic */ StartupManager this$0;

    StartupManager$StopBundle(StartupManager startupManager, Bundle bundle) {
        this.this$0 = startupManager;
        this.bundle = bundle;
        this.bundleName = StartupManager.access$200(startupManager, bundle);
    }

    public final String toString() {
        return new Buffer().append("StopBundle: ").append(this.bundleName).toString();
    }

    @Override
    public String getBundleName() {
        return this.bundleName;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void run() {
        WatchDog watchDog = null;
        try {
            watchDog = StartupManager.access$400(this.this$0, new StringBuffer().append("StopBundle#run() - Stop of bundle timed out: ").append(this.bundleName).toString());
            this.this$0.getBundleHandler().stopBundle(this.bundle);
        }
        catch (BundleException bundleException) {
            StartupManager.access$300(this.this$0).log(10000, "Stop of Bundle %1 failed!", (Object)this.bundleName, (Throwable)bundleException);
        }
        catch (RuntimeException runtimeException) {
            StartupManager.access$300(this.this$0).log(10000, "Stop of Bundle %1 failed!", (Object)this.bundleName, (Throwable)runtimeException);
        }
        finally {
            if (watchDog != null) {
                watchDog.cancel();
            }
            this.this$0.getAppStateManager().updateComponentState(this.bundleName);
        }
    }
}

