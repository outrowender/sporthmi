/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.drafts;

import de.audi.app.messaging.core.compose.Message;
import de.audi.app.messaging.core.drafts.SaveAsDraftCommand$ResultHandler;
import de.audi.app.messaging.core.drafts.SaveDraftController;

class SaveDraftController$2
implements SaveAsDraftCommand$ResultHandler {
    private final /* synthetic */ SaveDraftController this$0;

    SaveDraftController$2(SaveDraftController saveDraftController) {
        this.this$0 = saveDraftController;
    }

    @Override
    public void handleResult(int n, String string, Message message) {
        SaveDraftController.access$100(this.this$0, n, string, message);
    }
}

