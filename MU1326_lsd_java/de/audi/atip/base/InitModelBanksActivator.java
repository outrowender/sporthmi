/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.activator.AbstractActivator;
import org.osgi.framework.BundleContext;

public class InitModelBanksActivator
extends AbstractActivator {
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.getFramework().getStartupMgr().initModelBanks();
    }

    public void stop(BundleContext bundleContext) {
        this.getFramework().getLogChannel("Fw.Startup").log(10000, "InitModelBanks service can't be stopped!");
        super.stop(bundleContext);
    }
}

