/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.eni;

import de.audi.atip.interapp.bap.eni.data.MobileKeyCount;
import de.audi.atip.interapp.bap.remoteservices.data.MobileKeySetup;

public interface ENIMobileKeyStatusDisplayListener {
    public void onMobDevKeySetup(MobileKeySetup var1);

    public void onFleetModeAvailability(boolean var1);

    public void onMobileDeviceKeyCount(MobileKeyCount var1);
}

