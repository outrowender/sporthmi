/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cmd.lists;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.cmd.AbstractTVCommand;
import de.audi.tv.app.lists.IServiceListsResource;
import de.audi.tv.app.lists.StationMapper;
import java.util.List;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class UpdateStationListCmd
extends AbstractTVCommand {
    private final IServiceListsResource serviceListsResource;
    private final StationMapper mapper;

    public UpdateStationListCmd(LogChannel logChannel, IServiceListsResource iServiceListsResource, StationMapper stationMapper) {
        super(logChannel, 3);
        this.setName("UpdateStationListCmd");
        this.serviceListsResource = iServiceListsResource;
        this.mapper = stationMapper;
    }

    @Override
    public void execute() {
        this.logger.log(14808325, "[UpdateStationListCmd.execute] command started");
        ServiceInfo[] serviceInfoArray = this.serviceListsResource.getNewServiceList();
        long[] lArray = this.mapper.getServicesIDs(serviceInfoArray);
        long[] lArray2 = this.serviceListsResource.getFavoritesIDs();
        List list = this.serviceListsResource.createNewStationList(serviceInfoArray, lArray, lArray2);
        this.serviceListsResource.setStationList(list);
        this.logger.log(14808325, "[UpdateStationListCmd.execute] command finished");
        this.commandFinished();
    }
}

