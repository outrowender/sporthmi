/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.app.navi.evo.poi.online.OnlineSearchForm;
import de.audi.atip.phone.ITelServiceListener;

class OnlineSearchForm$1
implements ITelServiceListener {
    private final /* synthetic */ OnlineSearchForm this$0;

    OnlineSearchForm$1(OnlineSearchForm onlineSearchForm) {
        this.this$0 = onlineSearchForm;
    }

    @Override
    public void dialNumberResponse(int n) {
        OnlineSearchForm.access$000(this.this$0).log(-2137614336, "OnlineSearchForm#dialNumberResponse( %1 ): %2", (Object)Integer.toString(n), (Object)(n == 0 ? "OK" : "Error"));
    }
}

