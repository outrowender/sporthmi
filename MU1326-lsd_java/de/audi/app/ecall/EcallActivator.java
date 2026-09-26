/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall;

import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.evo.EcallApplicationEvo;
import de.audi.atip.activator.AbstractActivator;
import org.osgi.framework.BundleContext;

public class EcallActivator
extends AbstractActivator {
    private IEcallApplication eCallApplication;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.eCallApplication = new EcallApplicationEvo(this.framework, bundleContext);
        this.eCallApplication.init();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.eCallApplication.deinit();
        this.eCallApplication = null;
        super.stop(bundleContext);
    }
}

