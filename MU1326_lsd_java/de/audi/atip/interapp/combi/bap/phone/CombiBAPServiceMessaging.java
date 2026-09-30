/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone;

import de.audi.atip.interapp.combi.bap.CombiBAPService;

public interface CombiBAPServiceMessaging
extends CombiBAPService {
    public static final int MOBILE_SERVICE_SUPPORT_EMAIL_STATE = 5;

    public void updateMobileServiceSupport(boolean var1, boolean var2);

    public void updateSMSState(boolean var1, int var2, int var3);

    public void updateEmailState(int var1, int var2);
}

