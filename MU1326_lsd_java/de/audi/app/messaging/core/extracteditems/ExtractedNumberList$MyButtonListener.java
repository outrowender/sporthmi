/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.extracteditems;

import de.audi.app.messaging.core.extracteditems.ExtractedNumberList;
import de.audi.app.messaging.core.extracteditems.ExtractedNumberList$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class ExtractedNumberList$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ ExtractedNumberList this$0;

    private ExtractedNumberList$MyButtonListener(ExtractedNumberList extractedNumberList) {
        this.this$0 = extractedNumberList;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == 1922179328) {
            ExtractedNumberList.access$700(this.this$0, n, n3);
        } else {
            ExtractedNumberList.access$800(this.this$0).log(10000, "[ExtractedNumberList#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ ExtractedNumberList$MyButtonListener(ExtractedNumberList extractedNumberList, ExtractedNumberList$1 extractedNumberList$1) {
        this(extractedNumberList);
    }
}

