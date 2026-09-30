/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.internal;

import org.dsi.ifc.internal.AdapterManager;
import org.dsi.ifc.internal.NavigationFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class AdapterPlugin
implements BundleActivator {
    private ServiceRegistration fAdapterManagerReg;
    static /* synthetic */ Class class$org$dsi$ifc$base$IAdapterManager;

    public void start(BundleContext bundleContext) throws Exception {
        AdapterManager adapterManager = AdapterManager.getDefault();
        adapterManager.registerFactories(new NavigationFactory());
        this.fAdapterManagerReg = bundleContext.registerService((class$org$dsi$ifc$base$IAdapterManager == null ? (class$org$dsi$ifc$base$IAdapterManager = AdapterPlugin.class$("org.dsi.ifc.base.IAdapterManager")) : class$org$dsi$ifc$base$IAdapterManager).getName(), (Object)adapterManager, null);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        AdapterManager adapterManager;
        if (this.fAdapterManagerReg != null) {
            this.fAdapterManagerReg.unregister();
            this.fAdapterManagerReg = null;
        }
        if ((adapterManager = AdapterManager.getDefault()) != null) {
            adapterManager.unregisterAllFactories();
        }
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

