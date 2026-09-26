/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.startup.StartupManager;
import de.audi.tghu.fwhmi.evo.FwHMIActivator;
import org.osgi.framework.BundleContext;

public class InitHMIActivator
extends AbstractActivator {
    private void initPerformanceLogging() {
        if (!this.framework.isPBuild()) {
            if (this.framework.getStorageMgr().getInt(262, 101, 0) > 0) {
                System.setProperty("showScreenInfo", "true");
            }
            if (this.framework.getStorageMgr().getInt(262, 102, 0) > 0) {
                System.setProperty("showEventQueueStatistic", "true");
            }
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.initPerformanceLogging();
        FwHMIActivator fwHMIActivator = new FwHMIActivator();
        fwHMIActivator.start(bundleContext);
        ((StartupManager)this.getFramework().getStartupMgr()).initHMIService(fwHMIActivator.getService());
        this.getFramework().getStartupMgr().initHMI();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.getFramework().getLogChannel("Fw.Startup").log(10000, "InitHMI service can't be stopped!");
        super.stop(bundleContext);
    }
}

