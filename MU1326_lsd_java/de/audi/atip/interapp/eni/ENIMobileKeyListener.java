/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.eni;

import de.audi.atip.interapp.bap.eni.data.MobileKeyCount;
import de.audi.atip.interapp.bap.remoteservices.data.VTANData;

public interface ENIMobileKeyListener {
    public void onMobileDeviceKeyCount(MobileKeyCount var1);

    public void onVTANAuthDataFinished(boolean var1, String var2);

    public void onRemoteProcessGetVtan(int var1, int var2);

    public void onRemoteProcessFinished(boolean var1);

    public void onVtanDataEncrypted(String var1);

    public void onVTANDecryptionFinished(boolean var1, VTANData var2);
}

