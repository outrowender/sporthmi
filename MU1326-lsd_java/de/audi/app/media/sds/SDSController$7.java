/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sds.SDSController;
import java.util.HashMap;

class SDSController$7
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$type;
    private final /* synthetic */ SDSController this$0;

    SDSController$7(SDSController sDSController, String string, int n) {
        this.this$0 = sDSController;
        this.val$type = n;
        super(string);
    }

    @Override
    public void run() {
        SDSController.access$1500(this.this$0).sds().log(1078071040, "[%1.startBrowsing] type='%2'.", (Object)"SDSController", (long)this.val$type);
        if (!SDSController.access$1000(this.this$0)) {
            SDSController.access$1600(this.this$0, 2);
            return;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(new String("BROWSE_TYPE"), new Integer(this.val$type));
        Integer n = (Integer)this.this$0.getTerminal().getSDSDispatcher().notifyCommand(20003, this.this$0.getTerminal().getTerminalID(), hashMap);
        if (n == null) {
            SDSController.access$1600(this.this$0, 1);
            return;
        }
        switch (n) {
            case 11004: {
                SDSController.access$1600(this.this$0, 1);
                break;
            }
            case 11001: {
                SDSController.access$1600(this.this$0, 0);
                break;
            }
            default: {
                SDSController.access$1600(this.this$0, 1);
            }
        }
    }
}

