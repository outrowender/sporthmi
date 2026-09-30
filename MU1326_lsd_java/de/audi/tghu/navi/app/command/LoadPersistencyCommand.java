/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.IPersistenceHandler;
import de.audi.tghu.navi.app.NavigationStartup;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.RGSetRouteOptionsCommand;

public class LoadPersistencyCommand
extends NavCommand {
    public void execute() {
        this.logger.log(10000000, "LoadPersistencyCommand#execute()");
        NavigationStartup navigationStartup = this.navigation.getNavigationStartup();
        CommandList commandList = null;
        this.logger.log(10000000, "LoadPersistencyCommand#execute() - persistencyLoaded: %1", navigationStartup.isPersistencyLoaded());
        if (!navigationStartup.isPersistencyLoaded()) {
            ((IPersistenceHandler)((Object)this.navigation.getRouteManager())).loadPersistence();
            this.navigation.getSpeechManager().loadState();
            this.navigation.getGeneralSetupListener().loadState();
            this.navigation.getClusterService().getClusterInputListener().loadState();
            this.navigation.getOnlineSearchController().loadState();
            this.navigation.getTrafficMiniMap().loadState();
            int n = this.navigation.getSpeechManager().getGuidanceMode();
            commandList = this.navigation.getCommandListFactory().createCommandList();
            commandList.add(this.navigation.getSpeechManager().buildGuidanceModeCommandList(n));
            commandList.add(new RGSetRouteOptionsCommand(this.navigation.getRouteCriteriaManager().getRouteCriteria().getRouteOptions(true)[0]));
            navigationStartup.setPersistencyLoaded(true);
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

