/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.tghu.online.app.osr.OnlineService;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.OSRActivateLicenseCommand;
import org.dsi.ifc.online.OSRServiceState;

class OnlineService$3
extends AbstractOSRCommand {
    private final /* synthetic */ OSRActivateLicenseCommand val$orsActivateLicenseCommand;
    private final /* synthetic */ IOnlineServiceListener val$callback;
    private final /* synthetic */ OnlineService this$0;

    OnlineService$3(OnlineService onlineService, String string, OSRActivateLicenseCommand oSRActivateLicenseCommand, IOnlineServiceListener iOnlineServiceListener) {
        this.this$0 = onlineService;
        this.val$orsActivateLicenseCommand = oSRActivateLicenseCommand;
        this.val$callback = iOnlineServiceListener;
        super(string);
    }

    @Override
    public void execute() {
        OnlineService.access$100(this.this$0).log(1078071040, "[OnlineService#activateLicense] delegating license information (%2) for application (%1)", (Object)OnlineService.access$000(this.this$0), (long)this.val$orsActivateLicenseCommand.getLicenseStatus());
        this.val$callback.activateLicenseResponse(this.val$orsActivateLicenseCommand.getLicenseStatus());
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

