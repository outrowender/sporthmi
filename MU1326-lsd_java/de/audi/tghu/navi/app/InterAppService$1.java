/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;

class InterAppService$1
extends NavCommand {
    private final /* synthetic */ OperatorCallResult val$operatorCallResult;
    private final /* synthetic */ InterAppService this$0;

    InterAppService$1(InterAppService interAppService, String string, OperatorCallResult operatorCallResult) {
        this.this$0 = interAppService;
        this.val$operatorCallResult = operatorCallResult;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = Util.wgs84ToNavLocation(this.val$operatorCallResult.getLocation());
        this.getCommandList().commandFinishedWithPostCommand(new LIGetLocationDescriptionTransformCommand(navLocation));
    }
}

