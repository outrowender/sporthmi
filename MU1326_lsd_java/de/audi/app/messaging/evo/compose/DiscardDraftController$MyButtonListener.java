/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.evo.compose.DiscardDraftController;
import de.audi.app.messaging.evo.compose.DiscardDraftController$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

final class DiscardDraftController$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ DiscardDraftController this$0;

    private DiscardDraftController$MyButtonListener(DiscardDraftController discardDraftController) {
        this.this$0 = discardDraftController;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == 1788027136) {
            DiscardDraftController.access$100(this.this$0, n, n3);
        } else {
            DiscardDraftController.access$200(this.this$0).log(10000, "[DiscardDraftController#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ DiscardDraftController$MyButtonListener(DiscardDraftController discardDraftController, DiscardDraftController$1 discardDraftController$1) {
        this(discardDraftController);
    }
}

