/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessageReader;

class MessageReader$14
implements Runnable {
    private final /* synthetic */ MessageReader this$0;

    MessageReader$14(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    @Override
    public void run() {
        MessageReader.access$3700(this.this$0).log(1078071040, "[MessageReader#sessionResumed]");
        this.this$0.setSessionState(2);
        if (MessageReader.access$2500(this.this$0)) {
            MessageReader.access$3800(this.this$0).log(1078071040, "[MessageReader#sessionResumed] Session started in paused state has been resumed. Requesting readout to commence.");
            MessageReader.access$2502(this.this$0, false);
            MessageReader.access$2200(this.this$0);
        }
    }
}

