/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.attachments;

import de.audi.app.messaging.core.attachments.AttachmentList;
import de.audi.app.messaging.core.viewmessage.GetMessageContentsCommand$ResultHandler;
import org.dsi.ifc.messaging.MessageDetails;

class AttachmentList$1
implements GetMessageContentsCommand$ResultHandler {
    private final /* synthetic */ AttachmentList this$0;

    AttachmentList$1(AttachmentList attachmentList) {
        this.this$0 = attachmentList;
    }

    @Override
    public void handleResult(boolean bl, MessageDetails messageDetails, int n) {
        AttachmentList.access$100(this.this$0, bl, messageDetails, n);
    }
}

