/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.drafts;

import de.audi.app.messaging.core.drafts.SaveDraftController;
import de.audi.app.messaging.core.drafts.SaveDraftController$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class SaveDraftController$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ SaveDraftController this$0;

    private SaveDraftController$MyButtonListener(SaveDraftController saveDraftController) {
        this.this$0 = saveDraftController;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == -1366089472 || n == 1100161280) {
            SaveDraftController.access$500(this.this$0, n, n3);
        } else if (n == -309190400) {
            SaveDraftController.access$600(this.this$0, n, n3);
        } else {
            SaveDraftController.access$700(this.this$0).log(10000, "[SaveDraftController#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ SaveDraftController$MyButtonListener(SaveDraftController saveDraftController, SaveDraftController$1 saveDraftController$1) {
        this(saveDraftController);
    }
}

