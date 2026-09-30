/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

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

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "DataConnectionDSIListener#asyncException(): called, error code: %2, error msg: %1, request type: %3 ", (Object)string, (long)n, (long)n2);
    }

    public void updateStateDataConnection(final DataConnectionStateStruct dataConnectionStateStruct, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConnectionListener)dSIListener).updateStateDataConnection(dataConnectionStateStruct, n);
            }
        });
    }

    public void updateConnectionStateInformation(final ConnectionStateInformationStruct connectionStateInformationStruct, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConnectionListener)dSIListener).updateConnectionStateInformation(connectionStateInformationStruct, n);
            }
        });
    }

    public void updateRoamingState(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConnectionListener)dSIListener).updateRoamingState(n, n2);
            }
        });
    }

    public void updateErrorState(final ApplicationErrorStruct applicationErrorStruct, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConnectionListener)dSIListener).updateErrorState(applicationErrorStruct, n);
            }
        });
    }

    public void forceDisconnectResponse(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConnectionListener)dSIListener).forceDisconnectResponse(n);
            }
        });
    }

    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    public DSIListener getDSIDefaultHandler() {
        return this.dataConnectionDefaultListener;
    }

    public String getHandlerName() {
        return this.getClass().getName();
    }

    public LogChannel getLogChannel() {
        return this.log;
    }
}

