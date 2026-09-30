/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.ConnectivityDiag
 */
package de.audi.app.obex.core;

import de.audi.app.connectivity.core.AbstractApplication;
import de.audi.app.connectivity.core.IConnectivity;
import de.audi.app.obex.core.IObexApplication;
import de.audi.atip.base.IFrameworkAccess;
import de.mib.swdiagnosis.connectivity.ConnectivityDiag;
import org.osgi.framework.BundleContext;

public class AbstractObexApplication
extends AbstractApplication
implements IObexApplication {
    private final IConnectivity connectivity;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIObexAuthentication;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIObjectPush;

    protected AbstractObexApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IConnectivity iConnectivity) {
        super(iFrameworkAccess, bundleContext, "App.Obex.Main", "App.Obex.Commands", "AppObex");
        this.log.log(10000000, "AbstractObexApplication#AbstractObexApplication(): OBEX application created.");
        this.connectivity = iConnectivity;
    }

    protected void registerDSIListener() {
    }

    protected void startDSI() {
        this.framework.startDSIService((class$org$dsi$ifc$bluetooth$DSIObexAuthentication == null ? (class$org$dsi$ifc$bluetooth$DSIObexAuthentication = AbstractObexApplication.class$("org.dsi.ifc.bluetooth.DSIObexAuthentication")) : class$org$dsi$ifc$bluetooth$DSIObexAuthentication).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$bluetooth$DSIObjectPush == null ? (class$org$dsi$ifc$bluetooth$DSIObjectPush = AbstractObexApplication.class$("org.dsi.ifc.bluetooth.DSIObjectPush")) : class$org$dsi$ifc$bluetooth$DSIObjectPush).getName(), 0);
    }

    public ConnectivityDiag getDiag() {
        return this.connectivity.getDiagnosis();
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

