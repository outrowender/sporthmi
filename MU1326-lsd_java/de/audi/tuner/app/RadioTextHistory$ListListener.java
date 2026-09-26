/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.RadioTextHistory;
import de.audi.tuner.app.RadioTextHistory$1;
import de.audi.tuner.app.RadioTextHistory$RadioTextRow;
import de.audi.tuner.app.rthyperlinking.IPendingHyperlinkAction;

class RadioTextHistory$ListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ RadioTextHistory this$0;

    private RadioTextHistory$ListListener(RadioTextHistory radioTextHistory) {
        this.this$0 = radioTextHistory;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        IPendingHyperlinkAction iPendingHyperlinkAction = ((RadioTextHistory$RadioTextRow)evoListRow).getPendingHyperlinkAction();
        if (iPendingHyperlinkAction != null && iPendingHyperlinkAction.isExecutable(RadioTextHistory.access$300(this.this$0))) {
            iPendingHyperlinkAction.prepare();
            RadioTextHistory.access$1300(this.this$0).fireEvent(n4);
        }
    }

    /* synthetic */ RadioTextHistory$ListListener(RadioTextHistory radioTextHistory, RadioTextHistory$1 radioTextHistory$1) {
        this(radioTextHistory);
    }
}

