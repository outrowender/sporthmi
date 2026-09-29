/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class ADBInterAppService$1
extends NavCommand {
    private final /* synthetic */ String val$generalDescription;
    private final /* synthetic */ ADBInterAppService this$0;

    ADBInterAppService$1(ADBInterAppService aDBInterAppService, String string, String string2) {
        this.this$0 = aDBInterAppService;
        this.val$generalDescription = string2;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = (NavLocation)this.getCommandList().get("STREAMED_LOCATION");
        ADBInterAppService.access$000(this.this$0, navLocation, this.val$generalDescription);
        ADBInterAppService.access$100(this.this$0).start(navLocation);
        this.getCommandList().commandFinished();
    }
}

