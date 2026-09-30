/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.eni;

import de.audi.atip.interapp.bap.eni.data.Destination;

public interface ENIServiceEcallListener {
    public void onError();

    public void onExpirationWarning(boolean var1, int var2, boolean var3);

    public void onLicenceExpired();

    public void onDestination(Destination var1);

    public void setEcallPrivacyDisclaimerTextVisible(boolean var1);
}

