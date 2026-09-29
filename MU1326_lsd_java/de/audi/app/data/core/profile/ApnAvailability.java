/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.profile;

import org.dsi.ifc.networking.CDataProfile;

final class ApnAvailability {
    static final ApnAvailability NONE = new ApnAvailability(0);
    static final ApnAvailability ONLY_APN = new ApnAvailability(1);
    static final ApnAvailability ONLY_APN2 = new ApnAvailability(2);
    static final ApnAvailability APN_AND_APN2 = new ApnAvailability(3);
    final int value;

    ApnAvailability(int n) {
        this.value = n;
    }

    public static ApnAvailability valueOf(CDataProfile cDataProfile) {
        if (cDataProfile == null) {
            return NONE;
        }
        if (cDataProfile.isAPNvisible && cDataProfile.isAPN2visible) {
            return APN_AND_APN2;
        }
        if (cDataProfile.isAPNvisible && !cDataProfile.isAPN2visible) {
            return ONLY_APN;
        }
        if (!cDataProfile.isAPNvisible && cDataProfile.isAPN2visible) {
            return ONLY_APN2;
        }
        return NONE;
    }
}

