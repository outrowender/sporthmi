/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.li.aih;

import de.audi.atip.interapp.NaviADBService$LocationInputHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.li.aih.AddressInputHandler;
import de.audi.tghu.navi.app.li.aih.AddressbookDestinationAIH$1;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressbookDestinationAIH
extends AddressInputHandler {
    private final NaviADBService$LocationInputHandler locationInputHandler;
    private final ICommandListFactory commandListFactory;

    public AddressbookDestinationAIH(NaviADBService$LocationInputHandler naviADBService$LocationInputHandler, ICommandListFactory iCommandListFactory) {
        this.locationInputHandler = naviADBService$LocationInputHandler;
        this.commandListFactory = iCommandListFactory;
    }

    @Override
    public CommandList handleCompleteLocation(NavLocation navLocation, LogChannel logChannel) {
        this.logRouteInformations(logChannel, "AddressbookDestinationAIH#handleCompleteLocation()", navLocation);
        if (this.locationInputHandler == null) {
            logChannel.log(-1601830656, "AddressbookDestinationAIH#handleCompleteLocation() - no location input handler set!");
        } else {
            if (Util.getLocationAccessor(navLocation).isNavigable()) {
                CommandList commandList = this.commandListFactory.createCommandList(1);
                commandList.add(new LocationToStreamCommand(navLocation));
                commandList.add(new AddressbookDestinationAIH$1(this, "AddressbookDestinationAIH.updateLocation"));
                return commandList;
            }
            logChannel.log(-1601830656, "AddressbookDestinationAIH#handleCompleteLocation() - currentLocation: %1 is not navigable!", (Object)LocationFormatter.formatLocationShort(navLocation));
        }
        return null;
    }

    static /* synthetic */ NaviADBService$LocationInputHandler access$000(AddressbookDestinationAIH addressbookDestinationAIH) {
        return addressbookDestinationAIH.locationInputHandler;
    }
}

