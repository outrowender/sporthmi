/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging;

import de.audi.app.wirelesscharging.core.IWirelessChargingApplication;
import de.audi.app.wirelesscharging.evo.EvoWirelessChargingApplication;
import de.audi.atip.activator.AbstractActivator;
import org.osgi.framework.BundleContext;

public class WirelessChargingActivator
extends AbstractActivator {
    private IWirelessChargingApplication phoneboxApplication;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.phoneboxApplication = new EvoWirelessChargingApplication(this.framework, bundleContext);
        this.phoneboxApplication.init();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.phoneboxApplication.deinit();
        this.phoneboxApplication = null;
        super.stop(bundleContext);
    }
}

