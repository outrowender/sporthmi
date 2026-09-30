/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.evo.MediaEVOHMIApplicationImpl;
import de.audi.atip.activator.AbstractActivator;
import org.osgi.framework.BundleContext;

public class MediaActivator
extends AbstractActivator {
    private MediaEVOHMIApplicationImpl mediaEVOApp;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.mediaEVOApp = new MediaEVOHMIApplicationImpl(this.getFramework(), bundleContext);
        this.mediaEVOApp.init();
    }

    public void stop(BundleContext bundleContext) {
        this.mediaEVOApp.deinit();
        super.stop(bundleContext);
    }
}

