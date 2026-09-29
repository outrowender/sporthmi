/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessageReader;

class MessageReader$11
implements Runnable {
    private final /* synthetic */ MessageReader this$0;

    MessageReader$11(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    @Override
    public void run() {
        MessageReader.access$2700(this.this$0).log(1078071040, "[MessageReader#sessionStopped]");
        this.this$0.setSessionState(0);
        MessageReader.access$2502(this.this$0, false);
        MessageReader.access$2800(this.this$0, false);
        MessageReader.access$2900(this.this$0, false);
    }
}

