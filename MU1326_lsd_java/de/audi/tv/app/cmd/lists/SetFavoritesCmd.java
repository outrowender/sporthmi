/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cmd.lists;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.cmd.AbstractTVCommand;
import de.audi.tv.app.lists.IServiceListsResource;
import de.audi.tv.app.lists.StationMapper;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class SetFavoritesCmd
extends AbstractTVCommand {
    private final IServiceListsResource serviceListsResource;
    private final StationMapper mapper;

    public SetFavoritesCmd(LogChannel logChannel, IServiceListsResource iServiceListsResource, StationMapper stationMapper) {
        super(logChannel, 0);
        this.setName("SetFavoriteCmd");
        this.serviceListsResource = iServiceListsResource;
        this.mapper = stationMapper;
    }

    @Override
    public void execute() {
        this.logger.log(14808325, "[SetFavoritesCmd.execute] command started");
        ServiceInfo[] serviceInfoArray = this.serviceListsResource.getNewFavorites();
        long[] lArray = this.mapper.getServicesIDs(serviceInfoArray);
        this.serviceListsResource.setFavorites(serviceInfoArray, lArray);
        this.serviceListsResource.markFavorites(lArray);
        this.logger.log(14808325, "[SetFavoritesCmd.execute] command finished");
        this.commandFinished();
    }
}

