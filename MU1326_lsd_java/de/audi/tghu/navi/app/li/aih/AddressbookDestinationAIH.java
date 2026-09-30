/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.li.aih;

import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.aih.AddressInputHandler;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressbookDestinationAIH
extends AddressInputHandler {
    private final NaviADBService.LocationInputHandler locationInputHandler;
    private final ICommandListFactory commandListFactory;

    public AddressbookDestinationAIH(NaviADBService.LocationInputHandler locationInputHandler, ICommandListFactory iCommandListFactory) {
        this.locationInputHandler = locationInputHandler;
        this.commandListFactory = iCommandListFactory;
    }

    public CommandList handleCompleteLocation(NavLocation navLocation, LogChannel logChannel) {
        this.logRouteInformations(logChannel, "AddressbookDestinationAIH#handleCompleteLocation()", navLocation);
        if (this.locationInputHandler == null) {
            logChannel.log(100000, "AddressbookDestinationAIH#handleCompleteLocation() - no location input handler set!");
        } else {
            if (Util.getLocationAccessor(navLocation).isNavigable()) {
                CommandList commandList = this.commandListFactory.createCommandList(1);
                commandList.add(new LocationToStreamCommand(navLocation));
                commandList.add(new NavCommand("AddressbookDestinationAIH.updateLocation"){

                    public void execute() {
                        byte[] byArray = (byte[])this.getCommandList().get("LOCATION_STREAM");
                        AddressbookDestinationAIH.this.locationInputHandler.updateLocation(byArray);
                        this.getCommandList().commandFinished();
                    }
                });
                return commandList;
            }
            logChannel.log(100000, "AddressbookDestinationAIH#handleCompleteLocation() - currentLocation: %1 is not navigable!", (Object)LocationFormatter.formatLocationShort(navLocation));
        }
        return null;
    }
}

