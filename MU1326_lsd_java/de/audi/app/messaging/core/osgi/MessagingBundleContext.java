/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.osgi;

import de.audi.atip.base.IFrameworkAccess;
import org.osgi.framework.BundleContext;

public final class MessagingBundleContext {
    private final IFrameworkAccess frameworkAccess;
    private final BundleContext bundleContext;
    private final Object messagingHmiLock = new Object();

    public MessagingBundleContext(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext) {
        this.frameworkAccess = iFrameworkAccess;
        this.bundleContext = bundleContext;
    }

    public IFrameworkAccess getFramework() {
        return this.frameworkAccess;
    }

    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    public Object getMessagingHmiLock() {
        return this.messagingHmiLock;
    }
}

