/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.poi.online.OnlineSearchController;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class ReturnNavLocationToPOIOnlineSearchSequence {
    private final ICommandListFactory commandListFactory;

    public ReturnNavLocationToPOIOnlineSearchSequence(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    public void start() {
        CommandList commandList = this.getStartCommandList();
        commandList.execute("ReturnNavLocationToNaviOnlineSequence#start");
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                this.logger.log(10000000, "%1 - liCurrentLd=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
                OnlineSearchController onlineSearchController = this.navigation.getOnlineSearchController();
                if (onlineSearchController == null) {
                    this.env.getLogChannel().log(10000, "ReturnNavLocationToNaviOnlineSequence#start() - no OnlineSearchController");
                    return;
                }
                onlineSearchController.getOnlineSearchSequence().setSearchArea(3, navLocation);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }
}

