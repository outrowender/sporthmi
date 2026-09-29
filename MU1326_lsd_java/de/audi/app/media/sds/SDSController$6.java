/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sds.SDSController;
import java.util.HashMap;

class SDSController$6
extends AbstractDispatcherRunnable {
    private final /* synthetic */ SDSController this$0;

    SDSController$6(SDSController sDSController, String string) {
        this.this$0 = sDSController;
        super(string);
    }

    @Override
    public void run() {
        SDSController.access$1200(this.this$0).sds().log(1078071040, "[%1.folderUp]", (Object)"SDSController");
        if (!SDSController.access$1000(this.this$0)) {
            SDSController.access$1300(this.this$0, 2);
            return;
        }
        Integer n = (Integer)this.this$0.getTerminal().getSDSDispatcher().notifyCommand(20001, this.this$0.getTerminal().getTerminalID(), new HashMap(0));
        if (n == null) {
            SDSController.access$1300(this.this$0, 4);
            return;
        }
        switch (n) {
            case 21002: {
                SDSController.access$1300(this.this$0, 4);
                break;
            }
            case 21001: {
                SDSController.access$1300(this.this$0, 3);
                break;
            }
            case 11001: {
                SDSController.access$1400(this.this$0);
                SDSController.access$1300(this.this$0, 0);
                break;
            }
            default: {
                SDSController.access$1300(this.this$0, 3);
            }
        }
    }
}

