/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.osgi;

import de.audi.atip.base.IFrameworkAccess;
import org.osgi.framework.BundleContext;

public final class BundleEnvironment {
    private final BundleContext bundleContext;
    private final IFrameworkAccess frameworkAccess;

    public BundleEnvironment(BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        this.frameworkAccess = iFrameworkAccess;
        this.bundleContext = bundleContext;
    }

    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    public IFrameworkAccess getFramework() {
        return this.frameworkAccess;
    }
}

