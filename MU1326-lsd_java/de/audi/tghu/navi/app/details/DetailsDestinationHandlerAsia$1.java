/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.DetailsDestinationHandlerAsia;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;

class DetailsDestinationHandlerAsia$1
extends NavCommand {
    private final /* synthetic */ OperatorCallResult val$operatorCallResult;
    private final /* synthetic */ DetailsDestinationHandlerAsia this$0;

    DetailsDestinationHandlerAsia$1(DetailsDestinationHandlerAsia detailsDestinationHandlerAsia, String string, OperatorCallResult operatorCallResult) {
        this.this$0 = detailsDestinationHandlerAsia;
        this.val$operatorCallResult = operatorCallResult;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getTransformedLocation();
        if (this.val$operatorCallResult.getAddress() != null && !Util.isEmpty(this.val$operatorCallResult.getAddress().getUrl())) {
            Util.setURLOnLocation(navLocation, this.val$operatorCallResult.getAddress().getUrl());
        }
        this.this$0.setLocation(navLocation);
        this.getCommandList().commandFinished();
    }
}

