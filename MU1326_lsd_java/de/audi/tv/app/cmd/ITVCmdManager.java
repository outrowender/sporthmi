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
    public static final String KEY_TYPE = "CL_TYPE";
    public static final int CL_TYPE_STATIONS = 0;
    public static final int CL_TYPE_AUDIO = 1;
    public static final int CL_TYPE_DSI = 2;

    public TVCommandList createCmdList(int var1);

    public CommandListManager getCommandListManager();

    public void enqueue(CommandList var1);

    public AddFavoriteCmd createAddFavoriteCmd(IServiceListsResource var1, StationMapper var2);

    public SetFavoritesCmd createSetFavoritesCmd(IServiceListsResource var1, StationMapper var2);

    public RemoveFavoriteCmd createRemoveFavoriteCmd(IServiceListsResource var1, StationMapper var2);

    public ClearFavoritesCmd createClearFavoritesCmd(IServiceListsResource var1, StationMapper var2);

    public UpdateStationListCmd createUpdateStationListCmd(IServiceListsResource var1, StationMapper var2);

    public LoadFavoritesCmd createLoadFavoritesCmd(IServiceListsResource var1);

    public UpdateSelectedStationCmd createUpdateSelectedStationCmd(IServiceListsResource var1, boolean var2);

    public UpdateLogosCmd createUpdateLogosCmd(IServiceListsResource var1, LogoInfo[] var2);
}

