/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.UpdatingIconComponent;

class UpdatingIconComponent$1
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ UpdatingIconComponent this$0;

    UpdatingIconComponent$1(UpdatingIconComponent updatingIconComponent, String string, LogChannel logChannel) {
        this.this$0 = updatingIconComponent;
        this.val$logChannel = logChannel;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        if (!(object instanceof HMIProperties)) {
            this.val$logChannel.log(10000, new StringBuffer().append("UpdatingIconComponent#indicateCommand() invalid payload: ").append(object).toString());
            return;
        }
        boolean bl = ((HMIProperties)object).getBoolean("updating");
        String string = ((HMIProperties)object).getString("appContextName");
        String string2 = ((HMIProperties)object).getString("actionData");
        this.val$logChannel.log(1078071040, "UpdatingIconComponent#indicateCommand(): setting updating-icon %1 for context %2 and source %3", (Object)(bl ? "visible" : "hidden"), (Object)string, (Object)string2);
        UpdatingIconComponent.access$100(this.this$0, UpdatingIconComponent.access$000(this.this$0, bl, string, string2));
    }
}

