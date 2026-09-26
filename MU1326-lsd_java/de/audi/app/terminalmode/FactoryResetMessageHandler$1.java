/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.FactoryResetMessageHandler;
import de.audi.atip.msg.MsgListener;

class FactoryResetMessageHandler$1
implements MsgListener {
    private final /* synthetic */ FactoryResetMessageHandler this$0;

    FactoryResetMessageHandler$1(FactoryResetMessageHandler factoryResetMessageHandler) {
        this.this$0 = factoryResetMessageHandler;
    }

    @Override
    public void processMsg(int n) {
        if (n == 94) {
            FactoryResetMessageHandler.access$000(this.this$0);
        }
    }
}

