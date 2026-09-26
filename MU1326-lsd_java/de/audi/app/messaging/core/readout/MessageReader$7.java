/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessageReader;

class MessageReader$7
implements Runnable {
    private final /* synthetic */ MessageReader this$0;

    MessageReader$7(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    @Override
    public void run() {
        MessageReader.access$1800(this.this$0).log(-2137614336, "[MessageReader#resume]");
        this.this$0.requestResume();
    }
}

