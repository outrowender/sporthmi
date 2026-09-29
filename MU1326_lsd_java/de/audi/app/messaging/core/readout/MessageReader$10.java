/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessageReader;

class MessageReader$10
implements Runnable {
    private final /* synthetic */ MessageReader this$0;

    MessageReader$10(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    @Override
    public void run() {
        if (!MessageReader.access$2300(this.this$0)) {
            MessageReader.access$2400(this.this$0).log(1078071040, "[MessageReader#sessionPaused] Session has been started in paused state. Waiting for session to be resumed.");
            MessageReader.access$2502(this.this$0, true);
            this.this$0.setSessionState(1);
        } else {
            MessageReader.access$2600(this.this$0).log(1078071040, "[MessageReader#sessionPaused]");
        }
    }
}

