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
    public static final String MODULE_NAME;
    public static final String LOGCHANNEL;
    public static final String LOGCHANNEL_CMD;

    default public IAccessibility getAccessibility() {
    }

    default public IAudio getAudio() {
    }

    default public IBondingState getBondingState() {
    }

    default public IConnection getConnection() {
    }

    default public BaseSapUpgradeHandler getSapUpgrade() {
    }

    default public IDeviceProfileList getDeviceProfileList() {
    }

    default public IInquiry getInquiry() {
    }

    default public IMediaBluetoothStateProvider getMediaBluetoothStateProvider() {
    }

    default public PhoneProxy getPhone() {
    }

    default public IClampStateProvider getClampStateProvider() {
    }

    default public IReconnect getReconnect() {
    }

    default public ISecurity getSecurity() {
    }

    default public ISupportedBtProfiles getSupportedBtProfiles() {
    }

    default public ITrustedDeviceList getTrustedDeviceList() {
    }
}

