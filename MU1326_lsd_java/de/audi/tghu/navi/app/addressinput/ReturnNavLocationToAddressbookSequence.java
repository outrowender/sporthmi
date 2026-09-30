/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.atip.interapp.NaviADBService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class ReturnNavLocationToAddressbookSequence {
    private final ICommandListFactory commandListFactory;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public ReturnNavLocationToAddressbookSequence(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    public void startWithLiCurrentLd() {
        this.startWithLocation(null);
    }

    public void startWithLocation(NavLocation navLocation) {
        this.getStartCommandListWithLocation(navLocation).execute(this.CLASS_NAME + "#startWithLocation");
    }

    public CommandList getStartCommandListWithLiCurrentLd() {
        return this.getStartCommandListWithLocation(null);
    }

    public CommandList getStartCommandListWithLocation(final NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(this.CLASS_NAME + "#serializeLocation"){

            public void execute() {
                if (navLocation == null) {
                    this.logger.log(10000000, "%1 - using liCurrentLd", (Object)this.CLASS_NAME);
                    this.getCommandList().commandFinishedWithPostCommand(new LocationToStreamCommand(this.dsiResponseContainer.getLiCurrentLD()));
                } else {
                    this.logger.log(10000000, "%1 - using given location(%2)", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
                    this.getCommandList().commandFinishedWithPostCommand(new LocationToStreamCommand(navLocation));
                }
            }
        });
        commandList.add(new NavCommand(this.CLASS_NAME + "#saveNavLocationOnEntry"){

            public void execute() {
                byte[] byArray = (byte[])this.getCommandList().get("LOCATION_STREAM");
                NaviADBService.LocationInputHandler locationInputHandler = this.navigation.getAdbInterAppService().getCurrentLocationInputHandler();
                if (locationInputHandler != null) {
                    locationInputHandler.updateLocation(byArray);
                    this.navigation.getAdbInterAppService().removeHandler();
                    this.env.getLogChannel().log(10000000, "NavLocation was commited via interAppService, locationToStream = %2", (Object)byArray);
                    this.getCommandList().commandFinished();
                } else {
                    this.env.getLogChannel().log(10000, "%1#start() - LocationInputhandler is null", (Object)this.CLASS_NAME);
                    this.getCommandList().commandAborted("No LocationInputhandler available");
                }
            }
        });
        return commandList;
    }
}

