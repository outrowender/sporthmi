/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.evo;

import de.audi.app.connectivity.IEvoConnectivity;
import de.audi.app.data.core.AbstractDataApplication;
import de.audi.app.data.core.connection.AbstractConnectionState;
import de.audi.app.data.core.counter.AbstractDataCounter;
import de.audi.app.data.core.interapp.BapDataPacketCountProvider;
import de.audi.app.data.core.interapp.OnlineConnectionStateProvider;
import de.audi.app.data.core.interapp.OnlineConnectivityStateProvider;
import de.audi.app.data.core.online.BaseDataRequestHandler;
import de.audi.app.data.core.online.BaseOnlineComponent;
import de.audi.app.data.core.online.IOnline;
import de.audi.app.data.core.profile.AbstractDataProfile;
import de.audi.app.data.core.profile.IDataProfile;
import de.audi.app.data.core.reset.ResetDataSettings;
import de.audi.app.data.core.setup.IDataSetup;
import de.audi.app.data.evo.DataProfile;
import de.audi.app.data.evo.online.ErrorHandler;
import de.audi.app.data.evo.setup.DataSetup;
import de.audi.atip.base.IFrameworkAccess;
import org.osgi.framework.BundleContext;

public class DataApplication
extends AbstractDataApplication {
    private final IEvoConnectivity connectivity;
    private final AbstractDataProfile profile;
    private final DataSetup setup;
    private final BaseOnlineComponent online;
    private final ErrorHandler errorHandler;

    public DataApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IEvoConnectivity iEvoConnectivity) {
        super(iFrameworkAccess, bundleContext, iEvoConnectivity);
        this.connectivity = iEvoConnectivity;
        this.profile = new DataProfile(this);
        this.addComponent(this.profile);
        this.setup = new DataSetup(this);
        this.addComponent(this.setup);
        this.errorHandler = new ErrorHandler(this);
        this.addComponent(this.errorHandler);
        this.online = new BaseOnlineComponent(this, this.errorHandler);
        this.addComponent(this.online);
        this.addComponent(new BaseDataRequestHandler(this, this.online));
        this.addComponent(new AbstractDataCounter(this));
        this.addComponent(new ResetDataSettings(this));
        this.addComponent(new AbstractConnectionState(this));
        this.addComponent(new OnlineConnectionStateProvider(this));
        this.addComponent(new BapDataPacketCountProvider(this));
        this.addComponent(new OnlineConnectivityStateProvider(this));
    }

    @Override
    public IDataProfile getDataProfile() {
        return this.profile;
    }

    @Override
    public IDataSetup getDataSetup() {
        return this.setup;
    }

    @Override
    public IOnline getOnline() {
        return this.online;
    }

    public IEvoConnectivity getEvoConnectivity() {
        return this.connectivity;
    }
}

