/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.data.core.DataConnectionDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIDataConnectionListener;

class DataConnectionDSIListener$5
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ DataConnectionDSIListener this$0;

    DataConnectionDSIListener$5(DataConnectionDSIListener dataConnectionDSIListener, int n) {
        this.this$0 = dataConnectionDSIListener;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDataConnectionListener)dSIListener).forceDisconnectResponse(this.val$result);
    }
}

