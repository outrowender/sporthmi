/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.NewMessage;
import de.audi.app.messaging.core.compose.NewMessage$1;
import de.audi.atip.hmi.model.menu.MenuModelListener;

class NewMessage$MyMenuModelListener
implements MenuModelListener {
    private final /* synthetic */ NewMessage this$0;

    private NewMessage$MyMenuModelListener(NewMessage newMessage) {
        this.this$0 = newMessage;
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        NewMessage.access$400(this.this$0).log(1078071040, "[NewMessage#itemFocused] menuItemID = %1", (long)n);
        NewMessage.access$500(this.this$0).getHmiServiceApp().getChoiceModel(1351819520).setValue(n);
    }

    /* synthetic */ NewMessage$MyMenuModelListener(NewMessage newMessage, NewMessage$1 newMessage$1) {
        this(newMessage);
    }
}

