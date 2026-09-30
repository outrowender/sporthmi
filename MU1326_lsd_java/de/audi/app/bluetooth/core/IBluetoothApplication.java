/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.a2dp.IAudio;
import de.audi.app.bluetooth.core.accessibility.IAccessibility;
import de.audi.app.bluetooth.core.accessibility.ISupportedBtProfiles;
import de.audi.app.bluetooth.core.connectivity.IBondingState;
import de.audi.app.bluetooth.core.connectivity.connect.BaseSapUpgradeHandler;
import de.audi.app.bluetooth.core.connectivity.connect.IConnection;
import de.audi.app.bluetooth.core.connectivity.reconnect.IReconnect;
import de.audi.app.bluetooth.core.connectivity.search.IInquiry;
import de.audi.app.bluetooth.core.connectivity.trusted.IDeviceProfileList;
import de.audi.app.bluetooth.core.connectivity.trusted.ITrustedDeviceList;
import de.audi.app.bluetooth.core.interapp.IMediaBluetoothStateProvider;
import de.audi.app.bluetooth.core.security.ISecurity;
import de.audi.app.connectivity.core.IApplication;
import de.audi.app.connectivity.core.common.IClampStateProvider;
import de.audi.app.connectivity.core.common.PhoneProxy;

public interface IBluetoothApplication
extends IApplication {
    public static final String MODULE_NAME = "AppBluetooth";
    public static final String LOGCHANNEL = "App.Bluetooth.Main";
    public static final String LOGCHANNEL_CMD = "App.Bluetooth.Commands";

    public IAccessibility getAccessibility();

    public IAudio getAudio();

    public IBondingState getBondingState();

    public IConnection getConnection();

    public BaseSapUpgradeHandler getSapUpgrade();

    public IDeviceProfileList getDeviceProfileList();

    public IInquiry getInquiry();

    public IMediaBluetoothStateProvider getMediaBluetoothStateProvider();

    public PhoneProxy getPhone();

    public IClampStateProvider getClampStateProvider();

    public IReconnect getReconnect();

    public ISecurity getSecurity();

    public ISupportedBtProfiles getSupportedBtProfiles();

    public ITrustedDeviceList getTrustedDeviceList();
}

