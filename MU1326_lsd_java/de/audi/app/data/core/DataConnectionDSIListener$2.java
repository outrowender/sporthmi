/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.data.core.DataConnectionDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;
import org.dsi.ifc.networking.DSIDataConnectionListener;

class DataConnectionDSIListener$2
extends CommandResponse {
    private final /* synthetic */ ConnectionStateInformationStruct val$connetionStateInformation;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ DataConnectionDSIListener this$0;

    DataConnectionDSIListener$2(DataConnectionDSIListener dataConnectionDSIListener, ConnectionStateInformationStruct connectionStateInformationStruct, int n) {
        this.this$0 = dataConnectionDSIListener;
        this.val$connetionStateInformation = connectionStateInformationStruct;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDataConnectionListener)dSIListener).updateConnectionStateInformation(this.val$connetionStateInformation, this.val$validFlag);
    }
}

