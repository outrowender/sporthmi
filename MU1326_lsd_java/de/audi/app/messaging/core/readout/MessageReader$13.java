/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessageReader;

class MessageReader$13
implements Runnable {
    private final /* synthetic */ MessageReader this$0;

    MessageReader$13(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    @Override
    public void run() {
        MessageReader.access$3500(this.this$0).log(1078071040, "[MessageReader#speakingAborted]");
        boolean bl = true;
        if (MessageReader.access$3300(this.this$0) != null) {
            bl = false;
            if (MessageReader.access$2300(this.this$0) && !MessageReader.access$3600(this.this$0)) {
                MessageReader.access$3300(this.this$0).stopSession();
            }
            if (MessageReader.access$3600(this.this$0)) {
                MessageReader.access$2800(this.this$0, false);
                this.this$0.start();
            }
        }
        if (bl) {
            MessageReader.access$3400(this.this$0, "[MessageReader#speakingAborted]");
        }
    }
}

