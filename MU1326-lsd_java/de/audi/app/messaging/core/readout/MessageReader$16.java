/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessageReader;

class MessageReader$16
implements Runnable {
    private final /* synthetic */ MessageReader this$0;

    MessageReader$16(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    @Override
    public void run() {
        MessageReader.access$4000(this.this$0).log(1078071040, "[MessageReader#speakingStarted]");
        MessageReader.access$2800(this.this$0, true);
        MessageReader.access$2900(this.this$0, false);
    }
}

