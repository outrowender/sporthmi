/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.tghu.online.app.osr.OnlineService;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationHelper;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.OSRServiceState;

class OnlineService$5
extends AbstractOSRCommand {
    private final /* synthetic */ IOnlineServiceListener val$callback;
    private final /* synthetic */ OnlineService this$0;

    OnlineService$5(OnlineService onlineService, String string, IOnlineServiceListener iOnlineServiceListener) {
        this.this$0 = onlineService;
        this.val$callback = iOnlineServiceListener;
        super(string);
    }

    @Override
    public void execute() {
        OnlineService.access$100(this.this$0).log(-2137614336, "[OnlineService#setReminderState] application:%1 delegating reminder status", (Object)OnlineService.access$000(this.this$0));
        int n = OnlineServiceRegistrationHelper.getReminderStatus(OnlineService.access$200(this.this$0), OnlineService.access$100(this.this$0));
        this.val$callback.setReminderStateResponse(n);
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

