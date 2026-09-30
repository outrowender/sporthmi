/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.atip.interapp.NaviOnlineService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class ReturnNavLocationToRemoteHmiFromCurrentLDSequence {
    private final ICommandListFactory commandListFactory;

    public ReturnNavLocationToRemoteHmiFromCurrentLDSequence(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    public void start() {
        CommandList commandList = this.getStartCommandList();
        commandList.execute("ReturnNavLocationToRemoteHmiFromCurrentLDSequence#start");
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                this.logger.log(10000000, "%1 - liCurrentLd=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
                NaviOnlineService.NaviOnlineSearchAreaListener naviOnlineSearchAreaListener = this.navigation.getInterAppService().getNaviOnlineService().getSearchAreaListener();
                if (naviOnlineSearchAreaListener != null) {
                    naviOnlineSearchAreaListener.updateSearchLocation(Util.getLocationAccessor(navLocation));
                    this.getCommandList().commandFinished();
                } else {
                    this.env.getLogChannel().log(10000, "ReturnNavLocationToRemoteHmiFromCurrentLDSequence#start() - NaviOnlineSearchAreaListener is null");
                    this.getCommandList().commandAborted("No NaviOnlineSearchAreaListener available");
                }
            }
        });
        return commandList;
    }
}

