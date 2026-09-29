/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.data.core.DataConfigurationDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIDataConfigurationListener;

class DataConfigurationDSIListener$11
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ DataConfigurationDSIListener this$0;

    DataConfigurationDSIListener$11(DataConfigurationDSIListener dataConfigurationDSIListener, int n) {
        this.this$0 = dataConfigurationDSIListener;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDataConfigurationListener)dSIListener).setRequestSettingResponse(this.val$result);
    }
}

