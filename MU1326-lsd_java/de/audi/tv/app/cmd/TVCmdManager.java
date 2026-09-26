/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cmd;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tv.app.cmd.ITVCmdManager;
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

public class TVCmdManager
implements ITVCmdManager {
    private final CommandListManager manager;
    private final LogChannel log;
    private final Object mutex = new Object();
    private volatile boolean isDeinitCalled = false;

    public TVCmdManager(LogChannel logChannel, IFrameworkAccess iFrameworkAccess) {
        this.log = logChannel;
        this.manager = new CommandListManager("TV", iFrameworkAccess, logChannel, null, null);
        this.manager.start();
    }

    @Override
    public CommandListManager getCommandListManager() {
        return this.manager;
    }

    @Override
    public TVCommandList createCmdList(int n) {
        return new TVCommandList(this, n);
    }

    public void deinit() {
        this.isDeinitCalled = true;
        this.manager.destroy();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void enqueue(CommandList commandList) {
        if (commandList.size() == 0) {
            this.log.log(-1601830656, "[TVCmdManager.enqueue] Empty CL %1", (Object)commandList);
            return;
        }
        if (this.isDeinitCalled) {
            this.log.log(1078071040, "[TVCmdManager.enqueue] CL %1 not enqueued due to ongoing deinit.", (Object)commandList);
            return;
        }
        this.debug2(commandList);
        Object object = this.mutex;
        synchronized (object) {
            this.manager.execute(commandList);
        }
    }

    private void debug2(CommandList commandList) {
        if (this.log.isDebug2()) {
            Object[] objectArray = commandList.getCommands().toArray();
            this.log.log(14808325, "[TVCmdManager.enqueue] type:%1 #%2", commandList.get("CL_TYPE"), (long)objectArray.length);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                this.log.log(14808325, "[TVCmdManager.enqueue] [%2] %1", objectArray[i2], (long)i2);
            }
        }
    }

    @Override
    public AddFavoriteCmd createAddFavoriteCmd(IServiceListsResource iServiceListsResource, StationMapper stationMapper) {
        return new AddFavoriteCmd(this.log, iServiceListsResource, stationMapper);
    }

    @Override
    public SetFavoritesCmd createSetFavoritesCmd(IServiceListsResource iServiceListsResource, StationMapper stationMapper) {
        return new SetFavoritesCmd(this.log, iServiceListsResource, stationMapper);
    }

    @Override
    public RemoveFavoriteCmd createRemoveFavoriteCmd(IServiceListsResource iServiceListsResource, StationMapper stationMapper) {
        return new RemoveFavoriteCmd(this.log, iServiceListsResource, stationMapper);
    }

    @Override
    public ClearFavoritesCmd createClearFavoritesCmd(IServiceListsResource iServiceListsResource, StationMapper stationMapper) {
        return new ClearFavoritesCmd(this.log, iServiceListsResource, stationMapper);
    }

    @Override
    public UpdateStationListCmd createUpdateStationListCmd(IServiceListsResource iServiceListsResource, StationMapper stationMapper) {
        return new UpdateStationListCmd(this.log, iServiceListsResource, stationMapper);
    }

    @Override
    public LoadFavoritesCmd createLoadFavoritesCmd(IServiceListsResource iServiceListsResource) {
        return new LoadFavoritesCmd(this.log, iServiceListsResource);
    }

    @Override
    public UpdateSelectedStationCmd createUpdateSelectedStationCmd(IServiceListsResource iServiceListsResource, boolean bl) {
        return new UpdateSelectedStationCmd(this.log, iServiceListsResource, bl);
    }

    @Override
    public UpdateLogosCmd createUpdateLogosCmd(IServiceListsResource iServiceListsResource, LogoInfo[] logoInfoArray) {
        return new UpdateLogosCmd(this.log, iServiceListsResource, logoInfoArray);
    }
}

