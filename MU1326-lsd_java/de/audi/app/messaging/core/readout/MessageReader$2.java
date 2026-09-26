/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessageReader;

class MessageReader$2
implements Runnable {
    private final /* synthetic */ boolean val$isReadoutPermitted;
    private final /* synthetic */ MessageReader this$0;

    MessageReader$2(MessageReader messageReader, boolean bl) {
        this.this$0 = messageReader;
        this.val$isReadoutPermitted = bl;
    }

    @Override
    public void run() {
        MessageReader.access$500(this.this$0).log(-2137614336, "[MessageReader#setReadoutPermitted] isReadoutPermitted = %1", this.val$isReadoutPermitted);
        MessageReader.access$602(this.this$0, this.val$isReadoutPermitted);
        MessageReader.access$700(this.this$0);
    }
}

