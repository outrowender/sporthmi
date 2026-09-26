/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.device.TMDevice;

public final class NewDeviceHMIHandler$DisclaimerDeviceTypeChoice {
    public static final int CARPLAY;
    public static final int ANDROID;
    public static final int CARLIFE;

    public static int getModelValueFor(TMDevice tMDevice) {
        SmartphoneManager$SmartphoneType smartphoneManager$SmartphoneType = tMDevice.smartphoneType();
        return smartphoneManager$SmartphoneType.is(SmartphoneManager$SmartphoneType.ANDROIDAUTO2) ? 2 : (smartphoneManager$SmartphoneType.is(SmartphoneManager$SmartphoneType.CARPLAY) ? 1 : 3);
    }
}

