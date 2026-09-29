/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.readout.MessageReader;
import de.audi.app.messaging.core.readout.MessageReader$1;

final class MessageReader$CoreActionProxy
extends DefaultCoreActionProxy
implements IActionProxySubscriber {
    private final /* synthetic */ MessageReader this$0;

    private MessageReader$CoreActionProxy(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    @Override
    public void readoutScreensExited(int n) {
        MessageReader.access$4800(this.this$0).log(-2137614336, "[MessageReader#readoutScreensExited]");
        this.this$0.stop();
    }

    /* synthetic */ MessageReader$CoreActionProxy(MessageReader messageReader, MessageReader$1 messageReader$1) {
        this(messageReader);
    }
}

