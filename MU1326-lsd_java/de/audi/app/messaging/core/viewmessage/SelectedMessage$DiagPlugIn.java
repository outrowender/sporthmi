/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.util.Strings;
import de.audi.app.messaging.core.viewmessage.SelectedMessage;
import org.dsi.ifc.messaging.MessageDetails;

final class SelectedMessage$DiagPlugIn
implements IDiagPlugIn {
    private final /* synthetic */ SelectedMessage this$0;

    SelectedMessage$DiagPlugIn(SelectedMessage selectedMessage) {
        this.this$0 = selectedMessage;
    }

    public void cmdSetReplyTo(String string) {
        MessageDetails messageDetails = this.this$0.getMessageDetails();
        if (messageDetails != null) {
            messageDetails.replyTo = Strings.removeNonNumericChars(string);
        }
    }
}

