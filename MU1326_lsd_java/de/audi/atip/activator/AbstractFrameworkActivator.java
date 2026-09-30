/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.activator;

import de.audi.atip.activator.FrameworkException;
import de.audi.atip.base.IFrameworkAccess;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public abstract class AbstractFrameworkActivator
implements BundleActivator {
    protected BundleContext bundleContext;
    private final String bundleName;
    private boolean isStarted;
    protected IFrameworkAccess framework;
    static /* synthetic */ Class class$de$audi$atip$base$IFrameworkAccess;

    public AbstractFrameworkActivator(String string) {
        this.bundleName = string;
    }

    protected boolean isStarted() {
        return this.isStarted;
    }

    protected IFrameworkAccess getFramework() {
        return this.framework;
    }

    protected abstract void startInternal(BundleContext var1);

    public final void start(BundleContext bundleContext) {
        if (!this.isStarted) {
            this.bundleContext = bundleContext;
            ServiceReference serviceReference = bundleContext.getServiceReference((class$de$audi$atip$base$IFrameworkAccess == null ? (class$de$audi$atip$base$IFrameworkAccess = AbstractFrameworkActivator.class$("de.audi.atip.base.IFrameworkAccess")) : class$de$audi$atip$base$IFrameworkAccess).getName());
            if (serviceReference != null) {
                this.framework = (IFrameworkAccess)bundleContext.getService(serviceReference);
            }
            if (this.framework == null) {
                throw new FrameworkException(new StringBuffer().append("Framework service not available, starting of ").append(this.bundleName).append(" aborted").toString());
            }
            this.startInternal(bundleContext);
            this.isStarted = true;
        }
    }

    public void stop(BundleContext bundleContext) {
        this.isStarted = false;
    }

    protected BundleContext getBundleContext() {
        return this.bundleContext;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

