/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.evo.PhoneApplicationEvo;
import de.audi.atip.activator.AbstractActivator;
import org.osgi.framework.BundleContext;

public class PhoneActivator
extends AbstractActivator {
    private ITelApplication phoneApplicationEvo;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.phoneApplicationEvo = new PhoneApplicationEvo(this.framework, bundleContext);
        this.phoneApplicationEvo.init();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.phoneApplicationEvo.deinit();
        this.phoneApplicationEvo = null;
        super.stop(bundleContext);
    }
}

