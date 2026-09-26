/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone;

import de.audi.atip.interapp.combi.bap.CombiBAPService;

public interface CombiBAPServiceMessaging
extends CombiBAPService {
    public static final int MOBILE_SERVICE_SUPPORT_EMAIL_STATE;

    default public void updateMobileServiceSupport(boolean bl, boolean bl2) {
    }

    default public void updateSMSState(boolean bl, int n, int n2) {
    }

    default public void updateEmailState(int n, int n2) {
    }
}

