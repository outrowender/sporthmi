/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cmd;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tv.app.cmd.TVCommandList;
import de.audi.tv.app.cmd.lists.AddFavoriteCmd;
import de.audi.tv.app.cmd.lists.ClearFavoritesCmd;
import de.audi.tv.app.cmd.lists.LoadFavoritesCmd;
import de.audi.tv.app.cmd.lists.RemoveFavoriteCmd;
import de.audi.tv.app.cmd.lists.SetFavoritesCmd;
import de.audi.tv.app.cmd.lists.UpdateLogosCmd;
import de.audi.tv.app.cmd.lists.UpdateSelectedStationCmd;
import de.audi.tv.app.cmd.lists.UpdateStationListCmd;
import de.audi.tv.app.lists.IServiceListsResource;
import de.audi.tv.app.lists.StationMapper;
import org.dsi.ifc.tvtuner.LogoInfo;

public interface ITVCmdManager {
    public static final String KEY_TYPE;
    public static final int CL_TYPE_STATIONS;
    public static final int CL_TYPE_AUDIO;
    public static final int CL_TYPE_DSI;

    default public TVCommandList createCmdList(int n) {
    }

    default public CommandListManager getCommandListManager() {
    }

    default public void enqueue(CommandList commandList) {
    }

    default public AddFavoriteCmd createAddFavoriteCmd(IServiceListsResource iServiceListsResource, StationMapper stationMapper) {
    }

    default public SetFavoritesCmd createSetFavoritesCmd(IServiceListsResource iServiceListsResource, StationMapper stationMapper) {
    }

    default public RemoveFavoriteCmd createRemoveFavoriteCmd(IServiceListsResource iServiceListsResource, StationMapper stationMapper) {
    }

    default public ClearFavoritesCmd createClearFavoritesCmd(IServiceListsResource iServiceListsResource, StationMapper stationMapper) {
    }

    default public UpdateStationListCmd createUpdateStationListCmd(IServiceListsResource iServiceListsResource, StationMapper stationMapper) {
    }

    default public LoadFavoritesCmd createLoadFavoritesCmd(IServiceListsResource iServiceListsResource) {
    }

    default public UpdateSelectedStationCmd createUpdateSelectedStationCmd(IServiceListsResource iServiceListsResource, boolean bl) {
    }

    default public UpdateLogosCmd createUpdateLogosCmd(IServiceListsResource iServiceListsResource, LogoInfo[] logoInfoArray) {
    }
}

