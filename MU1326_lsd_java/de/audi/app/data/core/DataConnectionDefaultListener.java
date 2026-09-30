/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.ApplicationErrorStruct;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;
import org.dsi.ifc.networking.DSIDataConnectionListener;
import org.dsi.ifc.networking.DataConnectionStateStruct;

class DataConnectionDefaultListener
implements DSIDataConnectionListener {
    private final LogChannel log;

    DataConnectionDefaultListener(LogChannel logChannel) {
        this.log = logChannel;
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "DataConnectionDefaultListener#asyncException(): error code: %2, error msg: %1, request type: %3 ", (Object)string, (long)n, (long)n2);
    }

    public void forceDisconnectResponse(int n) {
        this.log.log(100000, "DataConnectionDefaultListener#forceDisconnectResponse(): Expected to be handled by a Command!");
    }

    public void updateStateDataConnection(DataConnectionStateStruct dataConnectionStateStruct, int n) {
        this.log.log(100000, "DataConnectionDefaultListener#updateStateDataConnection(): unexpected call (no notification)");
    }

    public void updateConnectionStateInformation(ConnectionStateInformationStruct connectionStateInformationStruct, int n) {
        this.log.log(100000, "DataConnectionDefaultListener#updateConnectionStateInformation(): unexpected call (no notification)");
    }

    public void updateRoamingState(int n, int n2) {
        this.log.log(100000, "DataConnectionDefaultListener#updateRoamingState(): unexpected call (no notification)");
    }

    public void updateErrorState(ApplicationErrorStruct applicationErrorStruct, int n) {
        this.log.log(100000, "DataConnectionDefaultListener#updateErrorState(): unexpected call (no notification)");
    }
}

