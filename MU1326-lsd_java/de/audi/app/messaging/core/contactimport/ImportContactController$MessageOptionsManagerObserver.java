/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.contactimport;

import de.audi.app.messaging.core.contactimport.ImportContactController;
import de.audi.app.messaging.core.contactimport.ImportContactController$1;
import de.audi.app.messaging.core.viewmessage.IMessageOptionsManagerObserver$EmptyImplementation;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.MessageDetails;

final class ImportContactController$MessageOptionsManagerObserver
extends IMessageOptionsManagerObserver$EmptyImplementation {
    private final /* synthetic */ ImportContactController this$0;

    private ImportContactController$MessageOptionsManagerObserver(ImportContactController importContactController) {
        this.this$0 = importContactController;
    }

    @Override
    public void messageDetailsChanged() {
        ImportContactController.access$500(this.this$0).log(-2137614336, "[ImportContactController#messageDetailsChanged]");
        MessageDetails messageDetails = ImportContactController.access$600(this.this$0).getSelectedMessage().getMessageDetails();
        AttachmentInformation attachmentInformation = null;
        int n = 4;
        if (messageDetails != null) {
            AttachmentInformation[] attachmentInformationArray = messageDetails.getAttachments();
            attachmentInformation = ImportContactController.access$700(this.this$0, attachmentInformationArray);
            n = messageDetails.getType();
        }
        ImportContactController.access$800(this.this$0, attachmentInformation, n);
    }

    /* synthetic */ ImportContactController$MessageOptionsManagerObserver(ImportContactController importContactController, ImportContactController$1 importContactController$1) {
        this(importContactController);
    }
}

