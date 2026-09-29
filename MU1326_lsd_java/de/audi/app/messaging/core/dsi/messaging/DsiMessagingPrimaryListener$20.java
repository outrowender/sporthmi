/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.DSIMessagingListener;
import org.dsi.ifc.messaging.RecipientList;

class DsiMessagingPrimaryListener$20
extends CommandResponse {
    private final /* synthetic */ int[] val$result;
    private final /* synthetic */ int val$requestId;
    private final /* synthetic */ int val$type;
    private final /* synthetic */ RecipientList val$recipients;
    private final /* synthetic */ String val$subject;
    private final /* synthetic */ String val$message;
    private final /* synthetic */ AttachmentInformation[] val$attachments;
    private final /* synthetic */ int val$messagingAccountID;
    private final /* synthetic */ DsiMessagingPrimaryListener this$0;

    DsiMessagingPrimaryListener$20(DsiMessagingPrimaryListener dsiMessagingPrimaryListener, int[] nArray, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        this.this$0 = dsiMessagingPrimaryListener;
        this.val$result = nArray;
        this.val$requestId = n;
        this.val$type = n2;
        this.val$recipients = recipientList;
        this.val$subject = string;
        this.val$message = string2;
        this.val$attachments = attachmentInformationArray;
        this.val$messagingAccountID = n3;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.access$100(this.this$0);
        try {
            dSIMessagingListener = (DSIMessagingListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            Logs.logException(DsiMessagingPrimaryListener.access$2000(this.this$0), classCastException, "[DsiMessagingPrimaryListener#indicateSendMessage]");
        }
        dSIMessagingListener.indicateSendMessage(this.val$result, this.val$requestId, this.val$type, this.val$recipients, this.val$subject, this.val$message, this.val$attachments, this.val$messagingAccountID);
    }
}

