/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.ConnectivityDiag
 */
package de.audi.app.data.core;

import de.audi.app.connectivity.core.AbstractApplication;
import de.audi.app.connectivity.core.IConnectivity;
import de.audi.app.data.core.DataConfigurationDSIListener;
import de.audi.app.data.core.DataConnectionDSIListener;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.esim.EsimHandler;
import de.audi.app.data.core.online.AbstractSimStateListener;
import de.audi.app.data.core.online.SimStateListener;
import de.audi.atip.base.IFrameworkAccess;
import de.mib.swdiagnosis.connectivity.ConnectivityDiag;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public abstract class AbstractDataApplication
extends AbstractApplication
implements IDataApplication {
    private final DataConfigurationDSIListener dataConfigurationDsiListener;
    private final DataConnectionDSIListener dataConnectionDsiListener;
    private final IConnectivity connectivity;
    private final AbstractSimStateListener simStateListener;
    protected final EsimHandler eSimHandler;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConfigurationListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConnectionListener;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConnection;

    public AbstractDataApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IConnectivity iConnectivity) {
        super(iFrameworkAccess, bundleContext, "App.Data.Main", "App.Data.Commands", "AppData");
        this.log.log(10000000, "AbstractDataApplication#AbstractDataApplication(): DataApplication created.");
        this.dataConfigurationDsiListener = new DataConfigurationDSIListener(this.commandListManager, this.log);
        this.dataConnectionDsiListener = new DataConnectionDSIListener(this.commandListManager, this.log);
        this.connectivity = iConnectivity;
        this.simStateListener = new SimStateListener(this);
        this.addComponent(this.simStateListener);
        if (iFrameworkAccess.getSysConst(4219) == 1) {
            this.eSimHandler = new EsimHandler(this, this.simStateListener);
            this.addComponent(this.eSimHandler);
        } else {
            this.eSimHandler = null;
        }
    }

    protected void registerDSIListener() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$networking$DSIDataConfigurationListener == null ? (class$org$dsi$ifc$networking$DSIDataConfigurationListener = AbstractDataApplication.class$("org.dsi.ifc.networking.DSIDataConfigurationListener")) : class$org$dsi$ifc$networking$DSIDataConfigurationListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.getBundleContext().registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractDataApplication.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.dataConfigurationDsiListener, (Dictionary)hashtable);
        hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$networking$DSIDataConnectionListener == null ? (class$org$dsi$ifc$networking$DSIDataConnectionListener = AbstractDataApplication.class$("org.dsi.ifc.networking.DSIDataConnectionListener")) : class$org$dsi$ifc$networking$DSIDataConnectionListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.getBundleContext().registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractDataApplication.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.dataConnectionDsiListener, (Dictionary)hashtable);
    }

    protected void startDSI() {
        this.framework.startDSIService((class$org$dsi$ifc$networking$DSIDataConfiguration == null ? (class$org$dsi$ifc$networking$DSIDataConfiguration = AbstractDataApplication.class$("org.dsi.ifc.networking.DSIDataConfiguration")) : class$org$dsi$ifc$networking$DSIDataConfiguration).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$networking$DSIDataConnection == null ? (class$org$dsi$ifc$networking$DSIDataConnection = AbstractDataApplication.class$("org.dsi.ifc.networking.DSIDataConnection")) : class$org$dsi$ifc$networking$DSIDataConnection).getName(), 0);
    }

    public IConnectivity getConnectivity() {
        return this.connectivity;
    }

    public ConnectivityDiag getDiag() {
        return this.connectivity.getDiagnosis();
    }

    public AbstractSimStateListener getSimStateListener() {
        return this.simStateListener;
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

