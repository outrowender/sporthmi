/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.ConnectivityDiag
 */
package de.audi.app.wlan.core;

import de.audi.app.connectivity.core.AbstractApplication;
import de.audi.app.connectivity.core.IConnectivity;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.app.wlan.core.WLANDSIListener;
import de.audi.atip.base.IFrameworkAccess;
import de.mib.swdiagnosis.connectivity.ConnectivityDiag;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public abstract class AbstractWlanApplication
extends AbstractApplication
implements IWlanApplication {
    private final WLANDSIListener wlanDsiListener;
    private IConnectivity connectivity;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIWLANListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIWLAN;

    protected AbstractWlanApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IConnectivity iConnectivity) {
        super(iFrameworkAccess, bundleContext, "App.Wlan.Main", "App.Wlan.Commands", "AppWlan");
        this.log.log(-2137614336, "AbstractWlanApplication#AbstractWlanApplication(): WlanApplication created.");
        this.wlanDsiListener = new WLANDSIListener(this.commandListManager, this.log);
        this.connectivity = iConnectivity;
    }

    @Override
    protected void registerDSIListener() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$networking$DSIWLANListener == null ? (class$org$dsi$ifc$networking$DSIWLANListener = AbstractWlanApplication.class$("org.dsi.ifc.networking.DSIWLANListener")) : class$org$dsi$ifc$networking$DSIWLANListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.getBundleContext().registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractWlanApplication.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.wlanDsiListener, (Dictionary)hashtable);
    }

    @Override
    protected void startDSI() {
        this.framework.startDSIService((class$org$dsi$ifc$networking$DSIWLAN == null ? (class$org$dsi$ifc$networking$DSIWLAN = AbstractWlanApplication.class$("org.dsi.ifc.networking.DSIWLAN")) : class$org$dsi$ifc$networking$DSIWLAN).getName(), 0);
    }

    @Override
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

