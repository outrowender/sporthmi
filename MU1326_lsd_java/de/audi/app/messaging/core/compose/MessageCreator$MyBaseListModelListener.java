/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.addressbook.AddressSelectionListRow;
import de.audi.app.messaging.core.compose.MessageCreator;
import de.audi.app.messaging.core.compose.MessageCreator$1;
import de.audi.app.messaging.core.compose.NewMessage;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.MatchedAddress;

class MessageCreator$MyBaseListModelListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ MessageCreator this$0;

    private MessageCreator$MyBaseListModelListener(MessageCreator messageCreator) {
        this.this$0 = messageCreator;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        MessageCreator.access$1200(this.this$0).log(1078071040, "[MessageCreator#itemSelected] row = %1", (Object)evoListRow);
        MatchedAddress matchedAddress = ((AddressSelectionListRow)evoListRow).getMatchedAddress();
        NewMessage newMessage = MessageCreator.access$1300(this.this$0).getNewMessage();
        newMessage.clear();
        newMessage.getSelectedRecipientList().addRecipientsTo(new MatchedAddress[]{matchedAddress});
        MessageCreator.access$1400(this.this$0).getHmiServiceApp().getModelApp(n).fireEvent(n4);
    }

    /* synthetic */ MessageCreator$MyBaseListModelListener(MessageCreator messageCreator, MessageCreator$1 messageCreator$1) {
        this(messageCreator);
    }
}

