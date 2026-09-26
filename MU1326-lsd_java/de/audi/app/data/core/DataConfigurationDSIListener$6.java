/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.data.core.DataConfigurationDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIDataConfigurationListener;

class DataConfigurationDSIListener$6
extends CommandResponse {
    private final /* synthetic */ int val$dataRequest;
    private final /* synthetic */ int val$statusRequest;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ DataConfigurationDSIListener this$0;

    DataConfigurationDSIListener$6(DataConfigurationDSIListener dataConfigurationDSIListener, int n, int n2, int n3) {
        this.this$0 = dataConfigurationDSIListener;
        this.val$dataRequest = n;
        this.val$statusRequest = n2;
        this.val$validFlag = n3;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDataConfigurationListener)dSIListener).updateRequestSetting(this.val$dataRequest, this.val$statusRequest, this.val$validFlag);
    }
}

