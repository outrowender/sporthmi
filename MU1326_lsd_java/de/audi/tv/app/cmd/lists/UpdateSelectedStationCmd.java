/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cmd.lists;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.cmd.AbstractTVCommand;
import de.audi.tv.app.lists.IServiceListsResource;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class UpdateSelectedStationCmd
extends AbstractTVCommand {
    private final IServiceListsResource serviceListsResource;
    private final boolean isNewProgram;

    public UpdateSelectedStationCmd(LogChannel logChannel, IServiceListsResource iServiceListsResource, boolean bl) {
        super(logChannel, 2);
        this.setName("UpdateSelectedStationCmd");
        this.serviceListsResource = iServiceListsResource;
        this.isNewProgram = bl;
    }

    public void execute() {
        this.logger.log(100000000, "[UpdateSelectedStationCmd.execute] command started");
        if (this.isNewProgram) {
            ProgramInfo programInfo = this.serviceListsResource.getSelectedProgram();
            this.serviceListsResource.setSelectedProgram(programInfo);
        } else {
            ServiceInfo serviceInfo = this.serviceListsResource.getSelectedService();
            this.serviceListsResource.setSelectedService(serviceInfo);
        }
        this.logger.log(100000000, "[UpdateSelectedStationCmd.execute] command finished");
        this.commandFinished();
    }
}

