/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.tghu.online.app.osr.OnlineService;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.OSRServiceState;

class OnlineService$1
extends AbstractOSRCommand {
    private final /* synthetic */ IOnlineServiceListener val$callback;
    private final /* synthetic */ OnlineService this$0;

    OnlineService$1(OnlineService onlineService, String string, IOnlineServiceListener iOnlineServiceListener) {
        this.this$0 = onlineService;
        this.val$callback = iOnlineServiceListener;
        super(string);
    }

    @Override
    public void execute() {
        OnlineService.access$100(this.this$0).log(-1601830656, "[OnlineService#activateLicense] error occured for application:%1", (Object)OnlineService.access$000(this.this$0));
        String string = (String)this.getCommandList().get("LICENSE_RESPONSE_SENT");
        if (string != null && string.equals("true")) {
            OnlineService.access$100(this.this$0).log(-2137614336, "[OnlineService#activateLicense] notifying callback handler that error occured");
            this.val$callback.activateLicenseResponse(6);
        }
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

