/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.data.core.DataConnectionDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIDataConnectionListener;

class DataConnectionDSIListener$3
extends CommandResponse {
    private final /* synthetic */ int val$state;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ DataConnectionDSIListener this$0;

    DataConnectionDSIListener$3(DataConnectionDSIListener dataConnectionDSIListener, int n, int n2) {
        this.this$0 = dataConnectionDSIListener;
        this.val$state = n;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDataConnectionListener)dSIListener).updateRoamingState(this.val$state, this.val$validFlag);
    }
}

