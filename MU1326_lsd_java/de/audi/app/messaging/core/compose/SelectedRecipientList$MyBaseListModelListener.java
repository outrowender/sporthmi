/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.SelectedRecipientList;
import de.audi.app.messaging.core.compose.SelectedRecipientList$1;
import de.audi.app.messaging.core.recipients.RecipientListRow;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;

class SelectedRecipientList$MyBaseListModelListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ SelectedRecipientList this$0;

    private SelectedRecipientList$MyBaseListModelListener(SelectedRecipientList selectedRecipientList) {
        this.this$0 = selectedRecipientList;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        SelectedRecipientList.access$100(this.this$0).log(1078071040, "[SelectedRecipientList#itemSelected] row = %1, index = %2", (Object)evoListRow, (long)n2);
        this.this$0.removeRecipient((RecipientListRow)evoListRow);
    }

    /* synthetic */ SelectedRecipientList$MyBaseListModelListener(SelectedRecipientList selectedRecipientList, SelectedRecipientList$1 selectedRecipientList$1) {
        this(selectedRecipientList);
    }
}

