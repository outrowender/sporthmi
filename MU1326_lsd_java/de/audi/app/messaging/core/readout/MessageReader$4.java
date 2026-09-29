/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.IReadable;
import de.audi.app.messaging.core.readout.MessageReader;

class MessageReader$4
implements Runnable {
    private final /* synthetic */ MessageReader this$0;

    MessageReader$4(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    @Override
    public void run() {
        MessageReader.access$1300(this.this$0).log(-2137614336, "[MessageReader#start]");
        if (MessageReader.access$1400(this.this$0) != 1) {
            throw new IllegalStateException("A message is already being read.");
        }
        IReadable iReadable = MessageReader.access$1000(this.this$0).getReadable();
        if (iReadable == null) {
            throw new IllegalStateException("Could not obtain a readable job.");
        }
        MessageReader.access$1100(this.this$0, iReadable);
    }
}

