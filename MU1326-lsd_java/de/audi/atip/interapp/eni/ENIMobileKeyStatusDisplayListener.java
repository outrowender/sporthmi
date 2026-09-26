/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.eni;

import de.audi.atip.interapp.bap.eni.data.MobileKeyCount;
import de.audi.atip.interapp.bap.remoteservices.data.MobileKeySetup;

public interface ENIMobileKeyStatusDisplayListener {
    default public void onMobDevKeySetup(MobileKeySetup mobileKeySetup) {
    }

    default public void onFleetModeAvailability(boolean bl) {
    }

    default public void onMobileDeviceKeyCount(MobileKeyCount mobileKeyCount) {
    }
}

