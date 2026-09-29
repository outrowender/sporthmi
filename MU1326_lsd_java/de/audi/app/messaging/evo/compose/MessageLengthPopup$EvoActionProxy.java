/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.evo.compose.MessageLengthPopup;
import de.audi.app.messaging.evo.compose.MessageLengthPopup$1;
import de.audi.app.messaging.evo.guide.DefaultEvoActionProxy;

final class MessageLengthPopup$EvoActionProxy
extends DefaultEvoActionProxy
implements IActionProxySubscriber {
    private final /* synthetic */ MessageLengthPopup this$0;

    private MessageLengthPopup$EvoActionProxy(MessageLengthPopup messageLengthPopup) {
        this.this$0 = messageLengthPopup;
    }

    @Override
    public void editViewTransition(int n, int n2) {
        MessageLengthPopup.access$600(this.this$0).log(-2137614336, "[MessageLengthPopup#editViewTransition]");
        MessageLengthPopup.access$700(this.this$0, n2 == 0, n);
    }

    /* synthetic */ MessageLengthPopup$EvoActionProxy(MessageLengthPopup messageLengthPopup, MessageLengthPopup$1 messageLengthPopup$1) {
        this(messageLengthPopup);
    }
}

