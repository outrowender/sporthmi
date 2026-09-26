/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.activator.AbstractActivator;
import org.osgi.framework.BundleContext;

public class InitDSIActivator
extends AbstractActivator {
    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.getFramework().getStartupMgr().initDSI();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.getFramework().getLogChannel("Fw.Startup").log(10000, "InitDSI service can't be stopped!");
        super.stop(bundleContext);
    }
}

