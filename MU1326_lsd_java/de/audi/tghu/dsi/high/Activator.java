/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.dsi.high;

import de.audi.tghu.dsi.IFacadeFactory;
import de.audi.tghu.dsi.high.HighFacadeFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator
implements BundleActivator {
    private ServiceRegistration sregFactory = null;
    private IFacadeFactory factory = null;
    static /* synthetic */ Class class$de$audi$tghu$dsi$IFacadeFactory;

    @Override
    public void start(BundleContext bundleContext) {
        this.factory = new HighFacadeFactory();
        this.sregFactory = bundleContext.registerService((class$de$audi$tghu$dsi$IFacadeFactory == null ? (class$de$audi$tghu$dsi$IFacadeFactory = Activator.class$("de.audi.tghu.dsi.IFacadeFactory")) : class$de$audi$tghu$dsi$IFacadeFactory).getName(), (Object)this.factory, null);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.sregFactory != null) {
            this.sregFactory.unregister();
        }
        this.sregFactory = null;
        this.factory = null;
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

