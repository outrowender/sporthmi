/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sds.SDSController;
import java.util.HashMap;

class SDSController$10
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$pActive;
    private final /* synthetic */ SDSController this$0;

    SDSController$10(SDSController sDSController, String string, boolean bl) {
        this.this$0 = sDSController;
        this.val$pActive = bl;
        super(string);
    }

    @Override
    public void run() {
        SDSController.access$3000(this.this$0).sds().log(1078071040, "[%1.repeatTrack] '%2'", (Object)"SDSController", (Object)(this.val$pActive ? "ON" : "OFF"));
        HashMap hashMap = new HashMap(1);
        hashMap.put("REPEAT_TRACK", this.val$pActive);
        Integer n = (Integer)this.this$0.getTerminal().getSDSDispatcher().notifyCommand(20006, this.this$0.getTerminal().getTerminalID(), hashMap);
        if (null == n) {
            SDSController.access$3100(this.this$0).sds().log(1078071040, "[%1.repeatTrack] NOT SUPPORTED", (Object)"SDSController");
            SDSController.access$3200(this.this$0, 1);
            return;
        }
        switch (n) {
            case 11002: {
                SDSController.access$3300(this.this$0).sds().log(1078071040, "[%1.repeatTrack] RET_ALREADY_SET", (Object)"SDSController");
                SDSController.access$3200(this.this$0, 4);
                break;
            }
            case 11001: {
                SDSController.access$3400(this.this$0).sds().log(1078071040, "[%1.repeatTrack] SUCCESSFUL", (Object)"SDSController");
                SDSController.access$3200(this.this$0, 0);
                break;
            }
            default: {
                SDSController.access$3500(this.this$0).sds().log(1078071040, "[%1.repeatTrack] default: NOT SUPPORTED", (Object)"SDSController");
                SDSController.access$3200(this.this$0, 1);
            }
        }
    }
}

