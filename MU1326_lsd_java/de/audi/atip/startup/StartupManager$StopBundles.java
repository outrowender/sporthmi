/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.StartupManager;
import de.audi.atip.startup.StartupManager$BundlesJob;
import de.audi.atip.startup.StartupManager$StopBundle;
import org.osgi.framework.Bundle;

class StartupManager$StopBundles
extends StartupManager$BundlesJob {
    private final /* synthetic */ StartupManager this$0;

    StartupManager$StopBundles(StartupManager startupManager, Bundle[] bundleArray) {
        this.this$0 = startupManager;
        super(startupManager, "StopBundles: ", bundleArray.length);
        for (int i2 = 0; i2 < bundleArray.length; ++i2) {
            this.jobs[i2] = new StartupManager$StopBundle(startupManager, bundleArray[i2]);
        }
    }
}

