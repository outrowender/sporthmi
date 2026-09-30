/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.base.FwServices;
import de.audi.mib.jdsi.DSIActivator;
import org.osgi.framework.BundleContext;

public final class DomainActivator
extends AbstractFrameworkActivator {
    private static final String DSI_STARTUP_CLASS = (class$org$dsi$ifc$startup$DSIStartup == null ? (class$org$dsi$ifc$startup$DSIStartup = DomainActivator.class$("org.dsi.ifc.startup.DSIStartup")) : class$org$dsi$ifc$startup$DSIStartup).getName();
    private static final int INSTANCE_ID_MU = 0;
    private static final int INSTANCE_ID_RSU = 1;
    private final FwServices fwServices;
    private DSIActivator dsiActivator = null;
    private DSIActivator dsiMUActivator = null;
    static /* synthetic */ Class class$org$dsi$ifc$startup$DSIStartup;
    static /* synthetic */ Class class$org$dsi$ifc$startup$DSIStartupListener;

    public DomainActivator(FwServices fwServices) {
        super("DomainHandler");
        this.fwServices = fwServices;
    }

    protected void startInternal(BundleContext bundleContext) {
        this.fwServices.createDomainHandler();
        this.dsiActivator = new DSIActivator(this.getFramework(), DSI_STARTUP_CLASS, (class$org$dsi$ifc$startup$DSIStartupListener == null ? (class$org$dsi$ifc$startup$DSIStartupListener = DomainActivator.class$("org.dsi.ifc.startup.DSIStartupListener")) : class$org$dsi$ifc$startup$DSIStartupListener).getName(), new Integer(0), this.fwServices.getDomainHandler(), this.fwServices.getDomainHandler());
        this.dsiActivator.start(bundleContext);
    }

    public void initRSE() {
        this.fwServices.createDomainHandlerMU();
        this.dsiMUActivator = new DSIActivator(this.getFramework(), DSI_STARTUP_CLASS, (class$org$dsi$ifc$startup$DSIStartupListener == null ? (class$org$dsi$ifc$startup$DSIStartupListener = DomainActivator.class$("org.dsi.ifc.startup.DSIStartupListener")) : class$org$dsi$ifc$startup$DSIStartupListener).getName(), new Integer(1), this.fwServices.getDomainHandlerMU(), this.fwServices.getDomainHandlerMU());
        this.dsiMUActivator.start(this.getBundleContext());
    }

    public void stop(BundleContext bundleContext) {
        if (this.dsiActivator != null) {
            this.dsiActivator.stop(bundleContext);
            this.dsiActivator = null;
        }
        if (this.dsiMUActivator != null) {
            this.dsiMUActivator.stop(bundleContext);
            this.dsiMUActivator = null;
        }
        super.stop(bundleContext);
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

