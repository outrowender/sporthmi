/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.tone.app.ToneAppEvo;
import de.audi.tone.app.VariantProviderEvo;
import de.audi.tone.app.init.AbstractToneActivator;
import de.audi.tone.app.init.ToneAppCommon;
import org.osgi.framework.BundleContext;

public class ToneActivator
extends AbstractToneActivator {
    private ToneAppEvo app;

    protected void init() {
        VariantProviderEvo variantProviderEvo = new VariantProviderEvo();
        this.app = new ToneAppEvo(this.framework, variantProviderEvo);
        this.app.init();
    }

    protected ToneAppCommon getApp() {
        return this.app;
    }

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.registerActionProxy(19, this.app.actionProxy);
    }
}

