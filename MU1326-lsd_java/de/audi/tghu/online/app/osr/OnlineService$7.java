/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.online.app.osr.OnlineService;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.OSRCommandList;
import de.audi.tghu.online.app.osr.command.OSRGetOnlineApplicationCommand;
import de.audi.tghu.online.app.osr.command.OSRWaitCommand;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRServiceState;

class OnlineService$7
extends AbstractOSRCommand {
    private final /* synthetic */ OnlineService this$0;

    OnlineService$7(OnlineService onlineService, String string) {
        this.this$0 = onlineService;
        super(string);
    }

    @Override
    public void execute() {
        OSRLicense[] oSRLicenseArray = OnlineService.access$200(this.this$0).getLicenseList();
        if (oSRLicenseArray == null || oSRLicenseArray.length == 0) {
            OnlineService.access$100(this.this$0).log(-2137614336, "[OnlineService#getLicenseInformation] no license found for application:%1 - trigger core service to retrieve new service list", (Object)OnlineService.access$000(this.this$0));
            OSRCommandList oSRCommandList = OnlineService.access$300(this.this$0).createCommandList();
            oSRCommandList.add(new OSRWaitCommand(0));
            oSRCommandList.add(new OSRGetOnlineApplicationCommand(OnlineService.access$000(this.this$0)));
            this.getCommandList().commandFinishedWithPostSequence(oSRCommandList);
        } else {
            OnlineService.access$100(this.this$0).log(-2137614336, "[OnlineService#getLicenseInformation] %2 license(s) found for application:%1", (Object)OnlineService.access$000(this.this$0), (long)oSRLicenseArray.length);
            this.getCommandList().commandFinished();
        }
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

