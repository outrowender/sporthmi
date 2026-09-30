/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.DetailsDestionationHandler;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;

public class DetailsDestinationHandlerAsia
extends DetailsDestionationHandler {
    private final ICommandListFactory commandListFactory;

    public DetailsDestinationHandlerAsia(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    public void setOperatorCallResult(final OperatorCallResult operatorCallResult) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetLocationDescriptionTransformCommand(operatorCallResult.getLocation()));
        commandList.add(new NavCommand("Set result as location and change mapping of the URL from OperatorCall to NavLocation"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getTransformedLocation();
                if (operatorCallResult.getAddress() != null && !Util.isEmpty(operatorCallResult.getAddress().getUrl())) {
                    Util.setURLOnLocation(navLocation, operatorCallResult.getAddress().getUrl());
                }
                DetailsDestinationHandlerAsia.this.setLocation(navLocation);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("DetailsDestionationHandler#setOperatorCallResult");
    }
}

