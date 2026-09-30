/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.IDeviceListListener;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceID;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;

public interface IDeviceManager {
    public void addDeviceListListener(IDeviceListListener var1);

    public void removeDeviceListListener(IDeviceListListener var1);

    public void addActiveDeviceListener(IActiveDeviceStateListener var1);

    public void removeActiveDeviceListener(IActiveDeviceStateListener var1);

    public TMDeviceControl control(TMDeviceID var1);

    public TMDeviceControl control(TMDevice var1);

    public TMDevice getActiveDevice();

    public IDeviceManagerProperties getProperties();

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface IDeviceManagerProperties {
        public ReadOnlyProperty<TMDevice> activeDevice();
    }
}

