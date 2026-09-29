/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessageReader;

class MessageReader$9
implements Runnable {
    private final /* synthetic */ MessageReader this$0;

    MessageReader$9(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    @Override
    public void run() {
        MessageReader.access$2100(this.this$0).log(1078071040, "[MessageReader#sessionStarted]");
        this.this$0.setSessionState(2);
        MessageReader.access$2200(this.this$0);
    }
}

