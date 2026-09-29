/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class ADBInterAppService$5
extends NavCommand {
    private final /* synthetic */ ADBInterAppService this$0;

    ADBInterAppService$5(ADBInterAppService aDBInterAppService, String string) {
        this.this$0 = aDBInterAppService;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = (NavLocation)this.getCommandList().get("STREAMED_LOCATION");
        ADBInterAppService.access$500(this.this$0, navLocation);
        if (navLocation != null) {
            ADBInterAppService.access$600(this.this$0).startWithoutStrip(navLocation);
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted("deserialized NavLocation is null!");
        }
    }
}

