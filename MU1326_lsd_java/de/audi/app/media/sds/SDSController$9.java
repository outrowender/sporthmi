/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sds.SDSController;
import java.util.HashMap;

class SDSController$9
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$pOn;
    private final /* synthetic */ SDSController this$0;

    SDSController$9(SDSController sDSController, String string, boolean bl) {
        this.this$0 = sDSController;
        this.val$pOn = bl;
        super(string);
    }

    @Override
    public void run() {
        SDSController.access$2400(this.this$0).sds().log(1078071040, "[%1.mix] '%2'", (Object)"SDSController", (Object)(this.val$pOn ? "ON" : "OFF"));
        HashMap hashMap = new HashMap(1);
        hashMap.put("MIX", this.val$pOn);
        Integer n = (Integer)this.this$0.getTerminal().getSDSDispatcher().notifyCommand(20008, this.this$0.getTerminal().getTerminalID(), hashMap);
        if (n == null) {
            SDSController.access$2500(this.this$0).sds().log(1078071040, "[%1.mix] NOT SUPPORTED", (Object)"SDSController");
            SDSController.access$2600(this.this$0, 1);
            return;
        }
        switch (n) {
            case 11002: {
                SDSController.access$2700(this.this$0).sds().log(1078071040, "[%1.mix] RET_ALREADY_SET", (Object)"SDSController");
                SDSController.access$2600(this.this$0, 2);
                break;
            }
            case 11001: {
                SDSController.access$2800(this.this$0).sds().log(1078071040, "[%1.mix] SUCCESSFUL", (Object)"SDSController");
                SDSController.access$2600(this.this$0, 0);
                break;
            }
            default: {
                SDSController.access$2900(this.this$0).sds().log(1078071040, "[%1.mix] NOT SUPPORTED", (Object)"SDSController");
                SDSController.access$2600(this.this$0, 1);
            }
        }
    }
}

