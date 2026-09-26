/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.data.core.DataConnectionDSIListener$1;
import de.audi.app.data.core.DataConnectionDSIListener$2;
import de.audi.app.data.core.DataConnectionDSIListener$3;
import de.audi.app.data.core.DataConnectionDSIListener$4;
import de.audi.app.data.core.DataConnectionDSIListener$5;
import de.audi.app.data.core.DataConnectionDefaultListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.ApplicationErrorStruct;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;
import org.dsi.ifc.networking.DSIDataConnectionListener;
import org.dsi.ifc.networking.DataConnectionStateStruct;

class DataConnectionDSIListener
implements DSIDataConnectionListener,
ICommandResponseSupplier {
    private final CommandListManager cmdListManager;
    private final DataConnectionDefaultListener dataConnectionDefaultListener;
    private final LogChannel log;

    DataConnectionDSIListener(CommandListManager commandListManager, LogChannel logChannel) {
        this.cmdListManager = commandListManager;
        this.dataConnectionDefaultListener = new DataConnectionDefaultListener(logChannel);
        this.log = logChannel;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "DataConnectionDSIListener#asyncException(): called, error code: %2, error msg: %1, request type: %3 ", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void updateStateDataConnection(DataConnectionStateStruct dataConnectionStateStruct, int n) {
        CommandResponse.execute(this, new DataConnectionDSIListener$1(this, dataConnectionStateStruct, n));
    }

    @Override
    public void updateConnectionStateInformation(ConnectionStateInformationStruct connectionStateInformationStruct, int n) {
        CommandResponse.execute(this, new DataConnectionDSIListener$2(this, connectionStateInformationStruct, n));
    }

    @Override
    public void updateRoamingState(int n, int n2) {
        CommandResponse.execute(this, new DataConnectionDSIListener$3(this, n, n2));
    }

    @Override
    public void updateErrorState(ApplicationErrorStruct applicationErrorStruct, int n) {
        CommandResponse.execute(this, new DataConnectionDSIListener$4(this, applicationErrorStruct, n));
    }

    @Override
    public void forceDisconnectResponse(int n) {
        CommandResponse.execute(this, new DataConnectionDSIListener$5(this, n));
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.dataConnectionDefaultListener;
    }

    @Override
    public String getHandlerName() {
        return super.getClass().getName();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.log;
    }
}

