/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.activator.AbstractActivator;
import org.osgi.framework.BundleContext;

public class ShowFirstScreenActivator
extends AbstractActivator {
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.framework.getStartupMgr().showFirstScreen();
    }

    public void stop(BundleContext bundleContext) {
        this.getFramework().getLogChannel("Fw.Startup").log(10000, "ShowFirstScreen service can't be stopped!");
        super.stop(bundleContext);
    }
}

