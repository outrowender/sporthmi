/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.remoteservices;

import de.audi.atip.interapp.bap.BAPServiceListener;
import de.audi.atip.interapp.bap.remoteservices.data.MobileKeySetup;
import de.audi.atip.interapp.bap.remoteservices.data.VTANData;

public interface BAPServiceRemoteServicesListener
extends BAPServiceListener {
    public void onCommunicationUp();

    public void onMobDevKeySetup(MobileKeySetup var1);

    public void onVTANAuthDataFinished(boolean var1, String var2);

    public void onVTANDecryptionFinished(boolean var1, VTANData var2);
}

