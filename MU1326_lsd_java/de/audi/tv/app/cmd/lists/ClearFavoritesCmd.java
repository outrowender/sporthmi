/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cmd.lists;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.cmd.AbstractTVCommand;
import de.audi.tv.app.lists.IServiceListsResource;
import de.audi.tv.app.lists.StationMapper;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class ClearFavoritesCmd
extends AbstractTVCommand {
    private final IServiceListsResource serviceListsResource;
    private final StationMapper mapper;

    public ClearFavoritesCmd(LogChannel logChannel, IServiceListsResource iServiceListsResource, StationMapper stationMapper) {
        super(logChannel, 1);
        this.setName("ClearFavoritesCmd");
        this.serviceListsResource = iServiceListsResource;
        this.mapper = stationMapper;
    }

    public void execute() {
        this.logger.log(100000000, "[ClearFavoritesCmd.execute] command started");
        ServiceInfo[] serviceInfoArray = this.serviceListsResource.getOldFavorites();
        long[] lArray = this.mapper.getServicesIDs(serviceInfoArray);
        this.serviceListsResource.clearFavorites();
        this.serviceListsResource.unmarkFavorites(lArray);
        this.logger.log(100000000, "[ClearFavoritesCmd.execute] command finished");
        this.commandFinished();
    }
}

