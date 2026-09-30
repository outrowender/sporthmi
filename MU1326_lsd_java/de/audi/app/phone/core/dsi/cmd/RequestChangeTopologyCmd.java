/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractDSIMobileEquipmentTolologyCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology;

public class RequestChangeTopologyCmd
extends AbstractDSIMobileEquipmentTolologyCmd {
    private final int[] updatedTopology;

    public RequestChangeTopologyCmd(LogChannel logChannel, int n, DSIMobileEquipmentTopology dSIMobileEquipmentTopology, int[] nArray, ITelDSIResponseListener iTelDSIResponseListener) {
        super(logChannel, "RequestChangeTopologyCmd", n, dSIMobileEquipmentTopology, iTelDSIResponseListener);
        this.updatedTopology = nArray;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        RequestChangeTopologyCmd.schedule(commandListManager, this, "RequestChangeTopologyCmd", new Command(this.logger, "RequestChangeTopologyCmdError"){

            public void execute() {
                this.logger.log(100000, "[RequestChangeTopologyCmd.schedule().new Command() {...}#execute] Error.");
                if (RequestChangeTopologyCmd.this.listener != null) {
                    RequestChangeTopologyCmd.this.listener.responseChangeTopology(65537, RequestChangeTopologyCmd.this.getTerminalID());
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        if (this.dsi != null) {
            this.logger.log(1000000, "[RequestChangeTopologyCmd#execute] updatedTopology=%1", (Object)Converter.intArrayToString(this.updatedTopology));
            this.dsi.requestChangeTopology(this.updatedTopology);
        } else {
            this.logger.log(100000, "[RequestChangeTopologyCmd#execute] dsi is null --> NOP!");
        }
    }

    public void responseChangeTopology(int n) {
        this.logger.log(1000000, "[RequestChangeTopologyCmd#responseChangeTopology] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseChangeTopology(n, this.getTerminalID());
        }
        this.getCommandList().commandFinished();
    }
}

