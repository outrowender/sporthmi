/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.ApplicationErrorStruct;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;
import org.dsi.ifc.networking.DataConnectionStateStruct;

public interface DSIDataConnectionListener
extends DSIListener {
    public void updateStateDataConnection(DataConnectionStateStruct var1, int var2);

    public void updateConnectionStateInformation(ConnectionStateInformationStruct var1, int var2);

    public void updateRoamingState(int var1, int var2);

    public void updateErrorState(ApplicationErrorStruct var1, int var2);

    public void forceDisconnectResponse(int var1);
}

