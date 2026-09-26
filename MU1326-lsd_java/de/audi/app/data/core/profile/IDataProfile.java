/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.profile;

import org.dsi.ifc.networking.CDataProfile;

public interface IDataProfile {
    default public void discardProfileEdits() {
    }

    default public void automaticProfileResponse(CDataProfile cDataProfile) {
    }

    default public void updateSimState(boolean bl, boolean bl2, boolean bl3) {
    }

    default public void esimActiveCheckIfisProfileStateAvailable(boolean bl) {
    }
}

