/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.evo;

import de.audi.app.connectivity.IEvoConnectivity;
import de.audi.app.wlan.core.AbstractWlanApplication;
import de.audi.app.wlan.core.client.AbstractInquiry;
import de.audi.app.wlan.core.client.AbstractWlanConnection;
import de.audi.app.wlan.core.client.IConnection;
import de.audi.app.wlan.core.client.IInquiry;
import de.audi.app.wlan.core.client.ITrustedNetworkList;
import de.audi.app.wlan.core.hotspot.ConnectedClientList;
import de.audi.app.wlan.core.interapp.BapWlanStateProvider;
import de.audi.app.wlan.core.interapp.MediaWlanStateProvider;
import de.audi.app.wlan.core.mode.AbstractWlanMode;
import de.audi.app.wlan.core.reset.ResetWlanSettings;
import de.audi.app.wlan.evo.IEvoWlanApplication;
import de.audi.app.wlan.evo.client.TrustedNetworkList;
import de.audi.app.wlan.evo.client.WlanConnection;
import de.audi.app.wlan.evo.hotspot.HotSpotProfile;
import de.audi.app.wlan.evo.mode.WlanMode;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.WlanService;
import org.osgi.framework.BundleContext;

public class WlanApplication
extends AbstractWlanApplication
implements IEvoWlanApplication {
    private AbstractWlanConnection connection;
    private AbstractInquiry inquiry;
    private TrustedNetworkList networkList;
    private final IEvoConnectivity connectivity;
    private final AbstractWlanMode wlanMode;

    public WlanApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IEvoConnectivity iEvoConnectivity) {
        super(iFrameworkAccess, bundleContext, iEvoConnectivity);
        this.connectivity = iEvoConnectivity;
        this.wlanMode = new WlanMode(this);
        this.addComponent(this.wlanMode);
        this.addComponent(new HotSpotProfile(this));
        this.addComponent(new MediaWlanStateProvider(this));
        if (iFrameworkAccess.getSysConst(4442) == 1) {
            this.connection = new WlanConnection(this);
            this.addComponent(this.connection);
            this.inquiry = new AbstractInquiry(this);
            this.addComponent(this.inquiry);
            this.networkList = new TrustedNetworkList(this);
            this.addComponent(this.networkList);
        }
        this.addComponent(new ResetWlanSettings(this));
        this.addComponent(new ConnectedClientList(this));
        this.addComponent(new BapWlanStateProvider(this));
    }

    @Override
    public IConnection getConnection() {
        return this.connection;
    }

    @Override
    public IInquiry getInquiry() {
        return this.inquiry;
    }

    @Override
    public ITrustedNetworkList getTrustedNetworkList() {
        return this.networkList;
    }

    @Override
    public WlanService getMode() {
        return this.wlanMode;
    }

    @Override
    public IEvoConnectivity getConnectivity() {
        return this.connectivity;
    }
}

