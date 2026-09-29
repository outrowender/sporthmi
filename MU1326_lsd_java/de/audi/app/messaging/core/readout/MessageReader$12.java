/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessageReader;

class MessageReader$12
implements Runnable {
    private final /* synthetic */ MessageReader this$0;

    MessageReader$12(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    @Override
    public void run() {
        if (MessageReader.access$3000(this.this$0) != null && MessageReader.access$3000(this.this$0).hasNextSpeakTask()) {
            MessageReader.access$3100(this.this$0).log(1078071040, "[MessageReader#speakingFinished] Proceeding with the next speak() task.");
            MessageReader.access$2200(this.this$0);
        } else {
            MessageReader.access$3200(this.this$0).log(1078071040, "[MessageReader#speakingFinished] Read message job done.");
            boolean bl = true;
            if (MessageReader.access$3300(this.this$0) != null) {
                bl = false;
                if (MessageReader.access$2300(this.this$0)) {
                    MessageReader.access$2900(this.this$0, true);
                    MessageReader.access$3300(this.this$0).stopSession();
                }
            }
            if (bl) {
                MessageReader.access$3400(this.this$0, "[MessageReader#speakingFinished]");
            }
        }
    }
}

