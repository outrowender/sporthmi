/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.extracteditems;

import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.extracteditems.ExtractedMailAddressList;
import de.audi.app.messaging.core.extracteditems.ExtractedMailAddressList$1;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;

class ExtractedMailAddressList$MyBaseListModelListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ ExtractedMailAddressList this$0;

    private ExtractedMailAddressList$MyBaseListModelListener(ExtractedMailAddressList extractedMailAddressList) {
        this.this$0 = extractedMailAddressList;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        ExtractedMailAddressList.access$100(this.this$0).log(1078071040, "[ExtractedMailAddressList#itemSelected] row = %1", (Object)evoListRow);
        boolean bl = Accounts.supportsSend(ExtractedMailAddressList.access$200(this.this$0).getAccountManager().getSelectedAccount());
        if (bl) {
            ExtractedMailAddressList.access$300(this.this$0, evoListRow);
            ExtractedMailAddressList.access$400(this.this$0).getHmiServiceApp().getModelApp(n).fireEvent(n4);
        } else {
            ExtractedMailAddressList.access$500(this.this$0).log(1078071040, "[ExtractedMailAddressList#itemSelected] Current account does not support sending messages.");
        }
    }

    /* synthetic */ ExtractedMailAddressList$MyBaseListModelListener(ExtractedMailAddressList extractedMailAddressList, ExtractedMailAddressList$1 extractedMailAddressList$1) {
        this(extractedMailAddressList);
    }
}

