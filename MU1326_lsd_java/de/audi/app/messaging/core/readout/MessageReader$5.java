/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessageReader;

class MessageReader$5
implements Runnable {
    private final /* synthetic */ MessageReader this$0;

    MessageReader$5(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    @Override
    public void run() {
        MessageReader.access$1500(this.this$0).log(-2137614336, "[MessageReader#stop]");
        if (MessageReader.access$1400(this.this$0) != 1) {
            MessageReader.access$1200(this.this$0);
        }
    }
}

