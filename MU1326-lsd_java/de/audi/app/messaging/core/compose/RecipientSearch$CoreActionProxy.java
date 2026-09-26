/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.RecipientSearch;
import de.audi.app.messaging.core.compose.RecipientSearch$1;
import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.search.MessagingSearch;
import java.util.Map;

final class RecipientSearch$CoreActionProxy
extends DefaultCoreActionProxy
implements IActionProxySubscriber {
    private final /* synthetic */ RecipientSearch this$0;

    private RecipientSearch$CoreActionProxy(RecipientSearch recipientSearch) {
        this.this$0 = recipientSearch;
    }

    @Override
    public void searchableViewTransition(int n, int n2, int n3) {
        RecipientSearch.access$200(this.this$0).log(-2137614336, "[RecipientSearch#searchableViewTransition]");
        if (n3 == 0 && n2 == 1) {
            Map map = RecipientSearch.access$300(this.this$0).getAccountManager().isEmailMode() ? RecipientSearch.access$400() : RecipientSearch.access$500();
            ((MessagingSearch)RecipientSearch.access$600(this.this$0)).switchConfiguration(this.this$0, map);
        }
    }

    /* synthetic */ RecipientSearch$CoreActionProxy(RecipientSearch recipientSearch, RecipientSearch$1 recipientSearch$1) {
        this(recipientSearch);
    }
}

