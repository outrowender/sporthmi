/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessageReader;

class MessageReader$8
implements Runnable {
    private final /* synthetic */ boolean val$flag;
    private final /* synthetic */ MessageReader this$0;

    MessageReader$8(MessageReader messageReader, boolean bl) {
        this.this$0 = messageReader;
        this.val$flag = bl;
    }

    @Override
    public void run() {
        MessageReader.access$1900(this.this$0).log(1078071040, "[MessageReader#audioAvailable] flag = %1", this.val$flag);
        MessageReader.access$2002(this.this$0, this.val$flag);
        MessageReader.access$700(this.this$0);
    }
}

