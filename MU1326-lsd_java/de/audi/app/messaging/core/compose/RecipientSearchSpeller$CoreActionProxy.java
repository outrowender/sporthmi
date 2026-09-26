/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.RecipientSearchSpeller;
import de.audi.app.messaging.core.compose.RecipientSearchSpeller$1;
import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;

final class RecipientSearchSpeller$CoreActionProxy
extends DefaultCoreActionProxy
implements IActionProxySubscriber {
    private final /* synthetic */ RecipientSearchSpeller this$0;

    private RecipientSearchSpeller$CoreActionProxy(RecipientSearchSpeller recipientSearchSpeller) {
        this.this$0 = recipientSearchSpeller;
    }

    @Override
    public void searchableViewTransition(int n, int n2, int n3) {
        RecipientSearchSpeller.access$1400(this.this$0).log(-2137614336, "[RecipientSearchSpeller#searchableViewTransition]");
        if (n3 == 0 && n2 == 1) {
            this.this$0.isInEditorView = true;
        } else if (n3 == 1 && n2 == 1) {
            this.this$0.isInEditorView = false;
        }
    }

    /* synthetic */ RecipientSearchSpeller$CoreActionProxy(RecipientSearchSpeller recipientSearchSpeller, RecipientSearchSpeller$1 recipientSearchSpeller$1) {
        this(recipientSearchSpeller);
    }
}

