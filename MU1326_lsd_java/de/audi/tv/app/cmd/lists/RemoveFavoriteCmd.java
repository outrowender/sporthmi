/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cmd.lists;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.cmd.AbstractTVCommand;
import de.audi.tv.app.lists.IServiceListsResource;
import de.audi.tv.app.lists.StationMapper;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class RemoveFavoriteCmd
extends AbstractTVCommand {
    private final IServiceListsResource serviceListsResource;
    private final StationMapper mapper;

    public RemoveFavoriteCmd(LogChannel logChannel, IServiceListsResource iServiceListsResource, StationMapper stationMapper) {
        super(logChannel, 1);
        this.setName("RemoveFavoriteCmd");
        this.serviceListsResource = iServiceListsResource;
        this.mapper = stationMapper;
    }

    public void execute() {
        this.logger.log(100000000, "[RemoveFavoriteCmd.execute] command started");
        ServiceInfo[] serviceInfoArray = this.serviceListsResource.getOldFavorites();
        long[] lArray = this.mapper.getServicesIDs(serviceInfoArray);
        for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
            if (serviceInfoArray[i2] == null) continue;
            this.serviceListsResource.removeFavorite(serviceInfoArray[i2], lArray[i2]);
        }
        this.serviceListsResource.unmarkFavorites(lArray);
        this.logger.log(100000000, "[RemoveFavoriteCmd.execute] command finished");
        this.commandFinished();
    }
}

