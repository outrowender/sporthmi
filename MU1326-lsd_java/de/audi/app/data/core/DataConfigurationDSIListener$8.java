/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.data.core.DataConfigurationDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.DSIDataConfigurationListener;

class DataConfigurationDSIListener$8
extends CommandResponse {
    private final /* synthetic */ int val$dataProfileID;
    private final /* synthetic */ CDataProfile val$dataProfile;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ DataConfigurationDSIListener this$0;

    DataConfigurationDSIListener$8(DataConfigurationDSIListener dataConfigurationDSIListener, int n, CDataProfile cDataProfile, int n2) {
        this.this$0 = dataConfigurationDSIListener;
        this.val$dataProfileID = n;
        this.val$dataProfile = cDataProfile;
        this.val$result = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDataConfigurationListener)dSIListener).automaticProfileResponse(this.val$dataProfileID, this.val$dataProfile, this.val$result);
    }
}

