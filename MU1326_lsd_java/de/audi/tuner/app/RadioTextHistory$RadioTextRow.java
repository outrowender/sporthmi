/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.RadioTextHistory;
import de.audi.tuner.app.rthyperlinking.IPendingHyperlinkAction;

class RadioTextHistory$RadioTextRow
extends EvoListRow {
    private static final int SELECTABLE_NO;
    private static final int SELECTABLE_YES;
    private static final int INDEX_TXT;
    private static final int INDEX_SELECTABLE;
    private static final int INDEX_LINE;
    private static final int NUM_COLS;
    private IPendingHyperlinkAction pendingHyperlinkAction;
    private final /* synthetic */ RadioTextHistory this$0;

    public RadioTextHistory$RadioTextRow(RadioTextHistory radioTextHistory, long l, String string) {
        this.this$0 = radioTextHistory;
        super(l, 3);
        this.setText(0, string);
        this.setInteger(1, 0);
        this.setInteger(2, 0);
    }

    private RadioTextHistory$RadioTextRow(RadioTextHistory radioTextHistory, RadioTextHistory$RadioTextRow radioTextHistory$RadioTextRow) {
        this.this$0 = radioTextHistory;
        super(radioTextHistory$RadioTextRow);
        this.pendingHyperlinkAction = radioTextHistory$RadioTextRow.pendingHyperlinkAction;
    }

    @Override
    public EvoListRow copy() {
        return new RadioTextHistory$RadioTextRow(this.this$0, this);
    }

    public void addSeparator(int n) {
        int n2 = this.getInteger(2);
        if (n == 1 && n2 == 2 || n == 2 && n2 == 1) {
            this.setInteger(2, 3);
        } else {
            this.setInteger(2, n);
        }
    }

    public void removeSeparator(int n) {
        int n2 = this.getInteger(2);
        if (n2 == 3) {
            if (n == 2) {
                this.setInteger(2, 1);
            } else {
                this.setInteger(2, 2);
            }
        }
    }

    public String getRadiotext() {
        return this.getText(0);
    }

    public IPendingHyperlinkAction getPendingHyperlinkAction() {
        return this.pendingHyperlinkAction;
    }

    public void setPendingHyperlinkAction(IPendingHyperlinkAction iPendingHyperlinkAction) {
        this.pendingHyperlinkAction = iPendingHyperlinkAction;
        boolean bl = iPendingHyperlinkAction.isExecutable(RadioTextHistory.access$300(this.this$0));
        int n = bl ? 1 : 0;
        this.setInteger(1, n);
    }
}

