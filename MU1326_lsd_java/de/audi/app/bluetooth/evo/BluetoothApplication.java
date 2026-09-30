/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.IDiagComponent
 */
package de.audi.app.bluetooth.evo;

import de.audi.app.bluetooth.core.AbstractBluetoothApplication;
import de.audi.app.bluetooth.core.a2dp.AbstractAudio;
import de.audi.app.bluetooth.core.a2dp.IAudio;
import de.audi.app.bluetooth.core.accessibility.BluetoothNameHandler;
import de.audi.app.bluetooth.core.accessibility.IAccessibility;
import de.audi.app.bluetooth.core.accessibility.ISupportedBtProfiles;
import de.audi.app.bluetooth.core.accessibility.ProfileSupport;
import de.audi.app.bluetooth.core.connectivity.BaseBondingState;
import de.audi.app.bluetooth.core.connectivity.IBondingState;
import de.audi.app.bluetooth.core.connectivity.connect.BaseSapUpgradeHandler;
import de.audi.app.bluetooth.core.connectivity.connect.IConnection;
import de.audi.app.bluetooth.core.connectivity.reconnect.BasePrioReconnect;
import de.audi.app.bluetooth.core.connectivity.reconnect.IPrioReconnect;
import de.audi.app.bluetooth.core.connectivity.reconnect.IReconnect;
import de.audi.app.bluetooth.core.connectivity.search.IInquiry;
import de.audi.app.bluetooth.core.connectivity.trusted.DeviceProfileList;
import de.audi.app.bluetooth.core.connectivity.trusted.IDeviceProfileList;
import de.audi.app.bluetooth.core.connectivity.trusted.ITrustedDeviceList;
import de.audi.app.bluetooth.core.interapp.BapBluetoothStateProvider;
import de.audi.app.bluetooth.core.online.IConnectAppSetup;
import de.audi.app.bluetooth.core.reset.ResetBluetoothSettings;
import de.audi.app.bluetooth.core.security.ISecurity;
import de.audi.app.bluetooth.core.statusbar.BaseStatusBar;
import de.audi.app.bluetooth.evo.BluetoothApplicationDiag;
import de.audi.app.bluetooth.evo.IEvoBluetoothApplication;
import de.audi.app.bluetooth.evo.accessibility.Accessibility;
import de.audi.app.bluetooth.evo.connectivity.connect.BluetoothConnection;
import de.audi.app.bluetooth.evo.connectivity.reconnect.ReconnectInfo;
import de.audi.app.bluetooth.evo.connectivity.search.IEvoInquiry;
import de.audi.app.bluetooth.evo.connectivity.search.Inquiry;
import de.audi.app.bluetooth.evo.connectivity.trusted.IEvoTrustedDeviceList;
import de.audi.app.bluetooth.evo.connectivity.trusted.TrustedDeviceList;
import de.audi.app.bluetooth.evo.online.AudiConnectSetup;
import de.audi.app.bluetooth.evo.security.Security;
import de.audi.app.connectivity.IEvoConnectivity;
import de.audi.atip.base.IFrameworkAccess;
import de.mib.swdiagnosis.connectivity.IDiagComponent;
import org.osgi.framework.BundleContext;

public class BluetoothApplication
extends AbstractBluetoothApplication
implements IEvoBluetoothApplication {
    private final IEvoConnectivity connectivity;
    private final Accessibility accessibility;
    private final AbstractAudio audio;
    private final BaseBondingState bondingState;
    private final BluetoothConnection connection;
    private final BaseSapUpgradeHandler sapUpgrade;
    private final Inquiry inquiry;
    private final TrustedDeviceList trustedDevices;
    private final DeviceProfileList deviceProfileList;
    private final Security security;
    private final ReconnectInfo reconnect;
    private final BasePrioReconnect prioReconnect;
    private final ProfileSupport supportedBTProfiles;
    private AudiConnectSetup audiConnectSetup;

    public BluetoothApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IEvoConnectivity iEvoConnectivity) {
        super(iFrameworkAccess, bundleContext, iEvoConnectivity);
        this.connectivity = iEvoConnectivity;
        this.audio = new AbstractAudio(this);
        this.addComponent(this.audio);
        this.accessibility = new Accessibility(this);
        this.addComponent(this.accessibility);
        this.addComponent(new BluetoothNameHandler(this));
        this.bondingState = new BaseBondingState(this);
        this.addComponent(this.bondingState);
        this.supportedBTProfiles = new ProfileSupport(this);
        this.addComponent(this.supportedBTProfiles);
        this.connection = new BluetoothConnection(this);
        this.addComponent(this.connection);
        this.sapUpgrade = new BaseSapUpgradeHandler(this);
        this.addComponent(this.sapUpgrade);
        this.inquiry = new Inquiry(this);
        this.addComponent(this.inquiry);
        this.security = new Security(this);
        this.addComponent(this.security);
        this.trustedDevices = new TrustedDeviceList(this);
        this.addComponent(this.trustedDevices);
        this.deviceProfileList = new DeviceProfileList(this);
        this.addComponent(this.deviceProfileList);
        this.addComponent(new ResetBluetoothSettings(this));
        this.reconnect = new ReconnectInfo(this);
        this.addComponent(this.reconnect);
        this.prioReconnect = new BasePrioReconnect(this);
        this.addComponent(this.prioReconnect);
        this.addComponent(new BaseStatusBar(this));
        if (iFrameworkAccess.getSysConst(492) == 1) {
            this.audiConnectSetup = new AudiConnectSetup(this);
            this.addComponent(this.audiConnectSetup);
        }
        this.addComponent(new BapBluetoothStateProvider(this));
        this.getDiag().addDiagnosisComponent((IDiagComponent)new BluetoothApplicationDiag(this));
    }

    public IAccessibility getAccessibility() {
        return this.accessibility;
    }

    public IAudio getAudio() {
        return this.audio;
    }

    public IBondingState getBondingState() {
        return this.bondingState;
    }

    public IConnection getConnection() {
        return this.connection;
    }

    public BaseSapUpgradeHandler getSapUpgrade() {
        return this.sapUpgrade;
    }

    public IDeviceProfileList getDeviceProfileList() {
        return this.deviceProfileList;
    }

    public IInquiry getInquiry() {
        return this.getEvoInquiry();
    }

    public IReconnect getReconnect() {
        return this.reconnect;
    }

    public IPrioReconnect getPrioReconnect() {
        return this.prioReconnect;
    }

    public ISecurity getSecurity() {
        return this.security;
    }

    public ISupportedBtProfiles getSupportedBtProfiles() {
        return this.supportedBTProfiles;
    }

    public ITrustedDeviceList getTrustedDeviceList() {
        return this.trustedDevices;
    }

    public IEvoConnectivity getConnectivity() {
        return this.connectivity;
    }

    public IConnectAppSetup getAudiConnectSetup() {
        return this.audiConnectSetup;
    }

    public IEvoInquiry getEvoInquiry() {
        return this.inquiry;
    }

    public IEvoTrustedDeviceList getEvoTrustedDeviceList() {
        return this.trustedDevices;
    }
}

