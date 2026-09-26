/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.data.core.DataConfigurationDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.DSIDataConfigurationListener;

class DataConfigurationDSIListener$1
extends CommandResponse {
    private final /* synthetic */ CDataProfile[] val$availableProfiles;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ DataConfigurationDSIListener this$0;

    DataConfigurationDSIListener$1(DataConfigurationDSIListener dataConfigurationDSIListener, CDataProfile[] cDataProfileArray, int n) {
        this.this$0 = dataConfigurationDSIListener;
        this.val$availableProfiles = cDataProfileArray;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDataConfigurationListener)dSIListener).updateAvailableProfiles(this.val$availableProfiles, this.val$validFlag);
    }
}

