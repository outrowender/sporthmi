/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.data.core.DataConfigurationDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIDataConfigurationListener;

class DataConfigurationDSIListener$4
extends CommandResponse {
    private final /* synthetic */ int val$connectionMode;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ DataConfigurationDSIListener this$0;

    DataConfigurationDSIListener$4(DataConfigurationDSIListener dataConfigurationDSIListener, int n, int n2) {
        this.this$0 = dataConfigurationDSIListener;
        this.val$connectionMode = n;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDataConfigurationListener)dSIListener).updateConnectionMode(this.val$connectionMode, this.val$validFlag);
    }
}

