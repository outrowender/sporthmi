/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.online.app.osr.OnlineService;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.OSRServiceState;

class OnlineService$12
extends AbstractOSRCommand {
    private final /* synthetic */ OnlineService this$0;

    OnlineService$12(OnlineService onlineService, String string) {
        this.this$0 = onlineService;
        super(string);
    }

    @Override
    public void execute() {
        OnlineService.access$100(this.this$0).log(-1601830656, "[OnlineService#getOnlineApplicationPreCheck] error occured for application:%1", (Object)OnlineService.access$000(this.this$0));
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

