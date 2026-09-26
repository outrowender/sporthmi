/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.IReadable;
import de.audi.app.messaging.core.readout.MessageReader;

class MessageReader$3
implements Runnable {
    private final /* synthetic */ MessageReader this$0;

    MessageReader$3(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    @Override
    public void run() {
        MessageReader.access$900(this.this$0).log(-2137614336, "[MessageReader#toggle] A message is currently being read out: %1", MessageReader.access$800(this.this$0));
        if (!MessageReader.access$800(this.this$0)) {
            IReadable iReadable = MessageReader.access$1000(this.this$0).getReadable();
            if (iReadable == null) {
                throw new IllegalStateException("Could not obtain a readable job.");
            }
            MessageReader.access$1100(this.this$0, iReadable);
        } else {
            MessageReader.access$1200(this.this$0);
        }
    }
}

