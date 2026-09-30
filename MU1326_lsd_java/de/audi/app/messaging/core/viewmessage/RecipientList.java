/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.recipients.RecipientListRow;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import org.dsi.ifc.messaging.MatchedAddress;

public final class RecipientList
extends AbstractMessagingComponent {
    private static volatile long nextRowId = 0L;
    private final BaseListModelApp listModel;

    public RecipientList(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.listModel = this.framework.getHmiServiceApp().getBaseListModel(2200264);
    }

    public void clear() {
        this.log.log(10000000, "[RecipientList#clear]");
        this.listModel.removeAll();
    }

    public int getLength() {
        return this.listModel.getLength();
    }

    public void addRecipient(MatchedAddress matchedAddress, int n) {
        this.log.log(10000000, "[RecipientList#addRecipientTo] recipient = %1, recipientType = %2", (Object)matchedAddress, (long)n);
        RecipientListRow recipientListRow = new RecipientListRow(matchedAddress, n, nextRowId++);
        this.listModel.append(recipientListRow);
    }

    public void addRecipients(MatchedAddress[] matchedAddressArray, int n) {
        this.log.log(10000000, "[RecipientList#addRecipients] recipients.length = %1, recipientType = %2", (long)matchedAddressArray.length, (long)n);
        for (int i2 = 0; i2 < matchedAddressArray.length; ++i2) {
            this.addRecipient(matchedAddressArray[i2], n);
        }
    }
}

