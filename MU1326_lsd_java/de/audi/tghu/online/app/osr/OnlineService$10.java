/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.online.app.osr.OnlineService;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationHelper;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.OSRCommandList;
import de.audi.tghu.online.app.osr.command.OSRGetOnlineApplicationCommand;
import org.dsi.ifc.online.OSRServiceState;

class OnlineService$10
extends AbstractOSRCommand {
    private final /* synthetic */ OnlineService this$0;

    OnlineService$10(OnlineService onlineService, String string) {
        this.this$0 = onlineService;
        super(string);
    }

    @Override
    public void execute() {
        OnlineService.access$100(this.this$0).log(-2137614336, "[OnlineService#getReminderStatus] application:%1 check if info was retrieved before", (Object)OnlineService.access$000(this.this$0));
        if (!OnlineServiceRegistrationHelper.isKeyAvailable("ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_STATE", OnlineService.access$200(this.this$0))) {
            OnlineService.access$100(this.this$0).log(-2137614336, "[OnlineService#getReminderStatus] Key ONLINE_TRAFFIC_LICENCE_EXPIRES_REMINDER_STATE is not available, trigger getOnlineApplication(%1)", (Object)OnlineService.access$000(this.this$0));
            OSRCommandList oSRCommandList = OnlineService.access$300(this.this$0).createCommandList();
            oSRCommandList.add(new OSRGetOnlineApplicationCommand(OnlineService.access$000(this.this$0)));
            this.getCommandList().commandFinishedWithPostSequence(oSRCommandList);
        } else {
            this.getCommandList().commandFinished();
        }
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

