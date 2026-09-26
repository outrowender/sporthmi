/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.ComponentState;
import de.audi.atip.startup.StartupManager;
import de.audi.atip.startup.StartupManager$BundlesJob;
import de.audi.atip.startup.StartupManager$StartBundle;
import org.osgi.framework.Bundle;

class StartupManager$StartBundles
extends StartupManager$BundlesJob {
    private final ComponentState componentState;
    private final /* synthetic */ StartupManager this$0;

    StartupManager$StartBundles(StartupManager startupManager, Bundle[] bundleArray, ComponentState componentState) {
        this.this$0 = startupManager;
        super(startupManager, "StartBundles: ", bundleArray.length);
        for (int i2 = 0; i2 < bundleArray.length; ++i2) {
            this.jobs[i2] = new StartupManager$StartBundle(startupManager, bundleArray[i2], componentState);
        }
        this.componentState = componentState;
    }

    @Override
    public void run() {
        if (this.componentState != null) {
            if (this.componentState.isDomainFailed()) {
                StartupManager.access$300(this.this$0).log(1078071040, "%1 Do not start due to domain error!", (Object)this);
                return;
            }
            if (this.componentState.isWaitingForDomainStart()) {
                StartupManager.access$300(this.this$0).log(1078071040, "%1 Do not start, startDomain call is still pending!", (Object)this);
                return;
            }
        }
        super.run();
    }
}

