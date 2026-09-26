/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.RecipientList;

class DiagDsiMessaging$7
implements Runnable {
    private final /* synthetic */ int val$requestId;
    private final /* synthetic */ int val$type;
    private final /* synthetic */ RecipientList val$recipients;
    private final /* synthetic */ String val$subject;
    private final /* synthetic */ String val$message;
    private final /* synthetic */ AttachmentInformation[] val$attachments;
    private final /* synthetic */ int val$messagingAccountID;
    private final /* synthetic */ DiagDsiMessaging this$0;

    DiagDsiMessaging$7(DiagDsiMessaging diagDsiMessaging, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        this.this$0 = diagDsiMessaging;
        this.val$requestId = n;
        this.val$type = n2;
        this.val$recipients = recipientList;
        this.val$subject = string;
        this.val$message = string2;
        this.val$attachments = attachmentInformationArray;
        this.val$messagingAccountID = n3;
    }

    @Override
    public void run() {
        DiagDsiMessaging.access$000(this.this$0).indicateSendMessage(new int[]{0}, this.val$requestId, this.val$type, this.val$recipients, this.val$subject, this.val$message, this.val$attachments, this.val$messagingAccountID);
    }
}

