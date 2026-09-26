/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.online.app.osr.OnlineService;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.OSRServiceState;

class OnlineService$2
extends AbstractOSRCommand {
    private final /* synthetic */ OnlineService this$0;

    OnlineService$2(OnlineService onlineService, String string) {
        this.this$0 = onlineService;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().put("LICENSE_RESPONSE_SENT", "true");
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

