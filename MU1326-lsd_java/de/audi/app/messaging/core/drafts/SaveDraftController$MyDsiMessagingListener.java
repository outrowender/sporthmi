/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.drafts;

import de.audi.app.messaging.core.compose.Message;
import de.audi.app.messaging.core.drafts.SaveDraftController;
import de.audi.app.messaging.core.drafts.SaveDraftController$1;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import org.dsi.ifc.messaging.StatusInformation;

final class SaveDraftController$MyDsiMessagingListener
extends DsiMessagingEmptyListener {
    private final /* synthetic */ SaveDraftController this$0;

    private SaveDraftController$MyDsiMessagingListener(SaveDraftController saveDraftController) {
        this.this$0 = saveDraftController;
    }

    @Override
    public void indicateMessageStatus(StatusInformation statusInformation) {
        String string;
        String string2;
        Message message;
        SaveDraftController.access$1000(this.this$0).log(-2137614336, "[SaveDraftController#indicateMessageStatus]");
        if (statusInformation.getStatus() == 1 && (message = SaveDraftController.access$000(this.this$0)) != null && (string2 = statusInformation.getMessageId()).equals(string = message.getMessageDetails().getMessageID())) {
            SaveDraftController.access$1100(this.this$0).log(1078071040, "[SaveDraftController#indicateMessageStatus] Most recently saved draft has been deleted, clearing cached information on that draft.");
            SaveDraftController.access$002(this.this$0, null);
        }
    }

    /* synthetic */ SaveDraftController$MyDsiMessagingListener(SaveDraftController saveDraftController, SaveDraftController$1 saveDraftController$1) {
        this(saveDraftController);
    }
}

