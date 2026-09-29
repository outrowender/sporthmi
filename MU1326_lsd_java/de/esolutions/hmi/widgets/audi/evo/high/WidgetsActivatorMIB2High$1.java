/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.msg.MsgListener;
import de.esolutions.hmi.widgets.audi.evo.high.WidgetsActivatorMIB2High;

class WidgetsActivatorMIB2High$1
implements MsgListener {
    private final /* synthetic */ WidgetsActivatorMIB2High this$0;

    WidgetsActivatorMIB2High$1(WidgetsActivatorMIB2High widgetsActivatorMIB2High) {
        this.this$0 = widgetsActivatorMIB2High;
    }

    @Override
    public void processMsg(int n) {
        switch (n) {
            case 101: {
                WidgetsActivatorMIB2High.access$000(this.this$0);
                break;
            }
        }
    }
}

