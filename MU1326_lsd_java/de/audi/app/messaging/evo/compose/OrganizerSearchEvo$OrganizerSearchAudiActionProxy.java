/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.evo.compose.OrganizerSearchEvo;
import de.audi.app.messaging.evo.compose.OrganizerSearchEvo$1;

final class OrganizerSearchEvo$OrganizerSearchAudiActionProxy
extends DefaultCoreActionProxy
implements IActionProxySubscriber {
    private final /* synthetic */ OrganizerSearchEvo this$0;

    private OrganizerSearchEvo$OrganizerSearchAudiActionProxy(OrganizerSearchEvo organizerSearchEvo) {
        this.this$0 = organizerSearchEvo;
    }

    @Override
    public void searchableViewTransition(int n, int n2, int n3) {
        OrganizerSearchEvo.access$1400(this.this$0).log(-2137614336, "[OrganizerSearchEvo#searchableViewTransition]");
        if (n3 == 0 && n2 == 1) {
            OrganizerSearchEvo.access$1600(this.this$0).getMessagingAdbHandler().setAdbMode(OrganizerSearchEvo.access$1500(this.this$0).getAccountManager().isEmailMode() ? 2 : 0);
            this.this$0.enableFiltering(true);
            this.this$0.startSearch();
        }
    }

    /* synthetic */ OrganizerSearchEvo$OrganizerSearchAudiActionProxy(OrganizerSearchEvo organizerSearchEvo, OrganizerSearchEvo$1 organizerSearchEvo$1) {
        this(organizerSearchEvo);
    }
}

