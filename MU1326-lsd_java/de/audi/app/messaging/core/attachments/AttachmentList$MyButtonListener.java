/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.attachments;

import de.audi.app.messaging.core.attachments.AttachmentList;
import de.audi.app.messaging.core.attachments.AttachmentList$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class AttachmentList$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AttachmentList this$0;

    private AttachmentList$MyButtonListener(AttachmentList attachmentList) {
        this.this$0 = attachmentList;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == -1064165120) {
            AttachmentList.access$200(this.this$0, n, n3);
        } else {
            AttachmentList.access$300(this.this$0).log(10000, "[AttachmentList#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ AttachmentList$MyButtonListener(AttachmentList attachmentList, AttachmentList$1 attachmentList$1) {
        this(attachmentList);
    }
}

