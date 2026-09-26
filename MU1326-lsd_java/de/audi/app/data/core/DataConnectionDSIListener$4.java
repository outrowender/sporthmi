/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.data.core.DataConnectionDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.ApplicationErrorStruct;
import org.dsi.ifc.networking.DSIDataConnectionListener;

class DataConnectionDSIListener$4
extends CommandResponse {
    private final /* synthetic */ ApplicationErrorStruct val$errorState;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ DataConnectionDSIListener this$0;

    DataConnectionDSIListener$4(DataConnectionDSIListener dataConnectionDSIListener, ApplicationErrorStruct applicationErrorStruct, int n) {
        this.this$0 = dataConnectionDSIListener;
        this.val$errorState = applicationErrorStruct;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDataConnectionListener)dSIListener).updateErrorState(this.val$errorState, this.val$validFlag);
    }
}

