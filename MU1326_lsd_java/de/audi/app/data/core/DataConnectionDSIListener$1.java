/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.data.core.DataConnectionDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIDataConnectionListener;
import org.dsi.ifc.networking.DataConnectionStateStruct;

class DataConnectionDSIListener$1
extends CommandResponse {
    private final /* synthetic */ DataConnectionStateStruct val$stateDataConnection;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ DataConnectionDSIListener this$0;

    DataConnectionDSIListener$1(DataConnectionDSIListener dataConnectionDSIListener, DataConnectionStateStruct dataConnectionStateStruct, int n) {
        this.this$0 = dataConnectionDSIListener;
        this.val$stateDataConnection = dataConnectionStateStruct;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDataConnectionListener)dSIListener).updateStateDataConnection(this.val$stateDataConnection, this.val$validFlag);
    }
}

