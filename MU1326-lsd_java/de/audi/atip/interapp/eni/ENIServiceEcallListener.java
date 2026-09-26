/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.eni;

import de.audi.atip.interapp.bap.eni.data.Destination;

public interface ENIServiceEcallListener {
    default public void onError() {
    }

    default public void onExpirationWarning(boolean bl, int n, boolean bl2) {
    }

    default public void onLicenceExpired() {
    }

    default public void onDestination(Destination destination) {
    }

    default public void setEcallPrivacyDisclaimerTextVisible(boolean bl) {
    }
}

