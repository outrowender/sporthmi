/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.details.DetailsDestinationHandlerAsia$1;
import de.audi.tghu.navi.app.details.DetailsDestionationHandler;
import org.dsi.ifc.online.OperatorCallResult;

public class DetailsDestinationHandlerAsia
extends DetailsDestionationHandler {
    private final ICommandListFactory commandListFactory;

    public DetailsDestinationHandlerAsia(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    @Override
    public void setOperatorCallResult(OperatorCallResult operatorCallResult) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetLocationDescriptionTransformCommand(operatorCallResult.getLocation()));
        commandList.add(new DetailsDestinationHandlerAsia$1(this, "Set result as location and change mapping of the URL from OperatorCall to NavLocation", operatorCallResult));
        commandList.execute("DetailsDestionationHandler#setOperatorCallResult");
    }
}

