/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.profile;

import org.dsi.ifc.networking.CDataProfile;

public interface IDataProfile {
    public void discardProfileEdits();

    public void automaticProfileResponse(CDataProfile var1);

    public void updateSimState(boolean var1, boolean var2, boolean var3);

    public void esimActiveCheckIfisProfileStateAvailable(boolean var1);
}

