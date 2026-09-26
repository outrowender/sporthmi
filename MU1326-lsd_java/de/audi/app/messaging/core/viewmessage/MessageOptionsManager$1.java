/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.extracteditems.ExtractInformationCommand$ResultHandler;
import de.audi.app.messaging.core.viewmessage.MessageOptionsManager;
import org.dsi.ifc.messaging.ExtractedItem;

class MessageOptionsManager$1
implements ExtractInformationCommand$ResultHandler {
    private final /* synthetic */ MessageOptionsManager this$0;

    MessageOptionsManager$1(MessageOptionsManager messageOptionsManager) {
        this.this$0 = messageOptionsManager;
    }

    @Override
    public void handleResult(int n, ExtractedItem[] extractedItemArray) {
        MessageOptionsManager.access$000(this.this$0, n, extractedItemArray);
    }
}

