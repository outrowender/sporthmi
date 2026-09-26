/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.data.core.DataConfigurationDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.DSIDataConfigurationListener;

class DataConfigurationDSIListener$7
extends CommandResponse {
    private final /* synthetic */ CDataProfile val$dataProfile;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ DataConfigurationDSIListener this$0;

    DataConfigurationDSIListener$7(DataConfigurationDSIListener dataConfigurationDSIListener, CDataProfile cDataProfile, int n) {
        this.this$0 = dataConfigurationDSIListener;
        this.val$dataProfile = cDataProfile;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDataConfigurationListener)dSIListener).setDataProfileResponse(this.val$dataProfile, this.val$result);
    }
}

