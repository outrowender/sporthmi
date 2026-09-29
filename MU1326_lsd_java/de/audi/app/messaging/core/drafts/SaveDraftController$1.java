/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.drafts;

import de.audi.app.messaging.core.compose.Message;
import de.audi.app.messaging.core.drafts.SaveAsDraftCommand$LastSavedMessageGetter;
import de.audi.app.messaging.core.drafts.SaveDraftController;

class SaveDraftController$1
implements SaveAsDraftCommand$LastSavedMessageGetter {
    private final /* synthetic */ SaveDraftController this$0;

    SaveDraftController$1(SaveDraftController saveDraftController) {
        this.this$0 = saveDraftController;
    }

    @Override
    public Message get() {
        return SaveDraftController.access$000(this.this$0);
    }
}

