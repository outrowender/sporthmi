/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.viewmessage.SelectedMessage;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$1;

final class SelectedMessage$CoreActionProxy
extends DefaultCoreActionProxy
implements IActionProxySubscriber {
    private final /* synthetic */ SelectedMessage this$0;

    private SelectedMessage$CoreActionProxy(SelectedMessage selectedMessage) {
        this.this$0 = selectedMessage;
    }

    @Override
    public void detailViewTransition(int n, int n2) {
        SelectedMessage.access$1600(this.this$0).log(-2137614336, "[SelectedMessage#detailViewTransition]");
        SelectedMessage.access$1702(this.this$0, n2 == 0);
    }

    /* synthetic */ SelectedMessage$CoreActionProxy(SelectedMessage selectedMessage, SelectedMessage$1 selectedMessage$1) {
        this(selectedMessage);
    }
}

