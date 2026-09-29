/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.eni;

import de.audi.atip.interapp.bap.eni.data.MobileKeyCount;
import de.audi.atip.interapp.bap.remoteservices.data.VTANData;

public interface ENIMobileKeyListener {
    default public void onMobileDeviceKeyCount(MobileKeyCount mobileKeyCount) {
    }

    default public void onVTANAuthDataFinished(boolean bl, String string) {
    }

    default public void onRemoteProcessGetVtan(int n, int n2) {
    }

    default public void onRemoteProcessFinished(boolean bl) {
    }

    default public void onVtanDataEncrypted(String string) {
    }

    default public void onVTANDecryptionFinished(boolean bl, VTANData vTANData) {
    }
}

