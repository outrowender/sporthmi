/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sds.SDSController;
import java.util.HashMap;

class SDSController$5
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pTrackNumber;
    private final /* synthetic */ SDSController this$0;

    SDSController$5(SDSController sDSController, String string, int n) {
        this.this$0 = sDSController;
        this.val$pTrackNumber = n;
        super(string);
    }

    @Override
    public void run() {
        SDSController.access$900(this.this$0).sds().log(1078071040, "[%1.setTrackNumber] trackNr='%2'.", (Object)"SDSController", (long)this.val$pTrackNumber);
        if (!SDSController.access$1000(this.this$0)) {
            SDSController.access$1100(this.this$0, 2);
            return;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("TRACK_NUMBER", new Integer(this.val$pTrackNumber));
        Integer n = (Integer)this.this$0.getTerminal().getSDSDispatcher().notifyCommand(20002, this.this$0.getTerminal().getTerminalID(), hashMap);
        if (n == null) {
            SDSController.access$1100(this.this$0, 6);
            return;
        }
        switch (n) {
            case 11001: {
                SDSController.access$1100(this.this$0, 0);
                break;
            }
            default: {
                SDSController.access$1100(this.this$0, 3);
            }
        }
    }
}

