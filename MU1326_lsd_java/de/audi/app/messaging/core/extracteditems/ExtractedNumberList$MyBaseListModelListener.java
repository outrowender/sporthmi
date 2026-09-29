/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.extracteditems;

import de.audi.app.messaging.core.extracteditems.ExtractedItemListRow;
import de.audi.app.messaging.core.extracteditems.ExtractedNumberList;
import de.audi.app.messaging.core.extracteditems.ExtractedNumberList$1;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;

class ExtractedNumberList$MyBaseListModelListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ ExtractedNumberList this$0;

    private ExtractedNumberList$MyBaseListModelListener(ExtractedNumberList extractedNumberList) {
        this.this$0 = extractedNumberList;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        ExtractedNumberList.access$200(this.this$0).log(1078071040, "[ExtractedNumberList#itemSelected] row = %1, col = %2", (Object)evoListRow, (long)n3);
        if (ExtractedNumberList.access$300(this.this$0).getSysConst(4168) == 7 || ExtractedNumberList.access$400(this.this$0).getSysConst(4168) == 5) {
            this.proceedActionForPorsche(evoListRow, n3);
        } else {
            this.proceedActionForAudi(evoListRow, n3);
        }
    }

    private void proceedActionForPorsche(EvoListRow evoListRow, int n) {
        if (n == 1) {
            ExtractedNumberList.access$500(this.this$0, (ExtractedItemListRow)evoListRow);
        } else if (n == 0) {
            ExtractedNumberList.access$600(this.this$0, (ExtractedItemListRow)evoListRow);
        }
    }

    private void proceedActionForAudi(EvoListRow evoListRow, int n) {
        if (n == 0) {
            ExtractedNumberList.access$500(this.this$0, (ExtractedItemListRow)evoListRow);
        } else if (n == 1) {
            ExtractedNumberList.access$600(this.this$0, (ExtractedItemListRow)evoListRow);
        }
    }

    /* synthetic */ ExtractedNumberList$MyBaseListModelListener(ExtractedNumberList extractedNumberList, ExtractedNumberList$1 extractedNumberList$1) {
        this(extractedNumberList);
    }
}

