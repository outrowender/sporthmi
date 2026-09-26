/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.calllist;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.evo.calllist.TelConferenceMemberListHandler;
import de.audi.atip.hmi.model.ModelGroup;

class TelConferenceMemberListHandler$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ ModelGroup val$modelGroup;
    private final /* synthetic */ TelConferenceMemberListHandler this$0;

    TelConferenceMemberListHandler$1(TelConferenceMemberListHandler telConferenceMemberListHandler, ModelGroup modelGroup) {
        this.this$0 = telConferenceMemberListHandler;
        this.val$modelGroup = modelGroup;
    }

    @Override
    public void responseHangupCall(int n, int n2) {
        TelConferenceMemberListHandler.access$000(this.this$0).log(1078071040, "[TelConferenceMemberListHandler.itemSelected(...).new TelDefaultDSIResponseListener() {...}#responseHangupCall] result=%1", (long)n);
        TelConferenceMemberListHandler.access$100(this.this$0, -577305600).setStatus(1);
        this.val$modelGroup.flush();
        this.val$modelGroup.removeAll();
    }
}

