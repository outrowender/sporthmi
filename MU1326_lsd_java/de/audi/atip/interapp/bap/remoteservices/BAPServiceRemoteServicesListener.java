/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.remoteservices;

import de.audi.atip.interapp.bap.BAPServiceListener;
import de.audi.atip.interapp.bap.remoteservices.data.MobileKeySetup;
import de.audi.atip.interapp.bap.remoteservices.data.VTANData;

public interface BAPServiceRemoteServicesListener
extends BAPServiceListener {
    default public void onCommunicationUp() {
    }

    default public void onMobDevKeySetup(MobileKeySetup mobileKeySetup) {
    }

    default public void onVTANAuthDataFinished(boolean bl, String string) {
    }

    default public void onVTANDecryptionFinished(boolean bl, VTANData vTANData) {
    }
}

