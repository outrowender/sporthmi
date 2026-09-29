/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sds.SDSController;
import java.util.HashMap;

class SDSController$8
extends AbstractDispatcherRunnable {
    private final /* synthetic */ SDSController this$0;

    SDSController$8(SDSController sDSController, String string) {
        this.this$0 = sDSController;
        super(string);
    }

    @Override
    public void run() {
        SDSController.access$1700(this.this$0).sds().log(1078071040, "[%1.playMoreLikeThis]", (Object)"SDSController");
        Integer n = (Integer)this.this$0.getTerminal().getSDSDispatcher().notifyCommand(20005, this.this$0.getTerminal().getTerminalID(), new HashMap(0));
        if (n == null) {
            SDSController.access$1800(this.this$0).sds().log(1078071040, "[%1.playMoreLikeThis] NOT SUPPORTED", (Object)"SDSController");
            SDSController.access$1900(this.this$0, 1);
            return;
        }
        switch (n) {
            case 11003: {
                SDSController.access$2000(this.this$0).sds().log(1078071040, "[%1.playMoreLikeThis] FAILED", (Object)"SDSController");
                SDSController.access$1900(this.this$0, 3);
                break;
            }
            case 11005: {
                SDSController.access$2100(this.this$0).sds().log(1078071040, "[%1.playMoreLikeThis] NOT READY", (Object)"SDSController");
                SDSController.access$1900(this.this$0, 2);
                break;
            }
            case 11001: {
                SDSController.access$2200(this.this$0).sds().log(1078071040, "[%1.playMoreLikeThis] READY", (Object)"SDSController");
                SDSController.access$1900(this.this$0, 0);
                break;
            }
            default: {
                SDSController.access$2300(this.this$0).sds().log(1078071040, "[%1.playMoreLikeThis] NOT SUPPORTED", (Object)"SDSController");
                SDSController.access$1900(this.this$0, 1);
            }
        }
    }
}

