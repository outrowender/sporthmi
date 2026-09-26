/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

import de.audi.app.connectivity.manager.contents.AbstractCoMaDevice;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;

public class CoMaDeviceSmartphone
extends AbstractCoMaDevice {
    private static final PropertyListCell APPLE = PropertyListCell.create(52880697, new int[]{-1416844851});
    private static final PropertyListCell APPLE_CONNECTED = PropertyListCell.create(52880697, new int[]{-1416844851, 474525614});
    private static final PropertyListCell GOOGLE = PropertyListCell.create(52880697, new int[]{1855448429});
    private static final PropertyListCell GOOGLE_CONNECTED = PropertyListCell.create(52880697, new int[]{1855448429, 474525614});
    private static final PropertyListCell BAIDU_CAR_LIFE = PropertyListCell.create(52880697, new int[]{-1332481947});
    private static final PropertyListCell BAIDU_CAR_LIFE_CONNECTED = PropertyListCell.create(52880697, new int[]{-1332481947, 474525614});
    private final int connectionMethod;
    private final boolean isAttached;

    public CoMaDeviceSmartphone(TerminalModeDevice terminalModeDevice, String string) {
        super(7, 64, terminalModeDevice.isActive() ? 64 : 0, terminalModeDevice.isAttached() ? 64 : 0, string, terminalModeDevice.getDeviceName(), CoMaDeviceSmartphone.getSmartphoneConnectionType(terminalModeDevice.getConnectionMethod()));
        this.connectionMethod = terminalModeDevice.getConnectionMethod();
        this.isAttached = terminalModeDevice.isAttached();
    }

    @Override
    PropertyListCell getProperties() {
        PropertyListCell propertyListCell;
        switch (this.connectionMethod) {
            case 2: {
                propertyListCell = this.isAttached ? GOOGLE_CONNECTED : GOOGLE;
                break;
            }
            case 1: {
                propertyListCell = this.isAttached ? APPLE_CONNECTED : APPLE;
                break;
            }
            case 3: {
                propertyListCell = this.isAttached ? BAIDU_CAR_LIFE_CONNECTED : BAIDU_CAR_LIFE;
                break;
            }
            default: {
                propertyListCell = this.isAttached ? BAIDU_CAR_LIFE_CONNECTED : BAIDU_CAR_LIFE;
            }
        }
        return propertyListCell;
    }

    private static int getSmartphoneConnectionType(int n) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 2;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }
}

