/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.drafts;

import de.audi.app.messaging.core.drafts.SaveDraftController;
import de.audi.app.messaging.core.drafts.SaveDraftController$1;
import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;

final class SaveDraftController$CoreActionProxy
extends DefaultCoreActionProxy
implements IActionProxySubscriber {
    private final /* synthetic */ SaveDraftController this$0;

    private SaveDraftController$CoreActionProxy(SaveDraftController saveDraftController) {
        this.this$0 = saveDraftController;
    }

    @Override
    public void messageCompositionTransition(int n, int n2) {
        SaveDraftController.access$800(this.this$0).log(-2137614336, "[SaveDraftController#messageCompositionTransition]");
        if (SaveDraftController.access$900(this.this$0) && n2 == 1) {
            this.this$0.saveDraftIfJustified(true);
        }
    }

    /* synthetic */ SaveDraftController$CoreActionProxy(SaveDraftController saveDraftController, SaveDraftController$1 saveDraftController$1) {
        this(saveDraftController);
    }
}

