/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.tghu.online.app.osr.OnlineService;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRServiceState;

class OnlineService$8
extends AbstractOSRCommand {
    private final /* synthetic */ IOnlineServiceListener val$callback;
    private final /* synthetic */ OnlineService this$0;

    OnlineService$8(OnlineService onlineService, String string, IOnlineServiceListener iOnlineServiceListener) {
        this.this$0 = onlineService;
        this.val$callback = iOnlineServiceListener;
        super(string);
    }

    @Override
    public void execute() {
        OSRLicense[] oSRLicenseArray = this.this$0.getOnlineApplication().getLicenseList();
        OnlineService.access$100(this.this$0).log(-2137614336, "[OnlineService#getLicenseInformation] application:%1 delegating license list (number:%2)", (Object)OnlineService.access$000(this.this$0), (long)oSRLicenseArray.length);
        this.val$callback.getLicenseInformationResult(oSRLicenseArray);
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

