/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tv.app.EWS;

class EWS$EWSAreaRow
extends EvoListRow {
    private static final int MAX_COLS;
    private static final int COL_ID;
    private static final int COL_STRING_ID;
    private static final int COL_CURSOR_FIX;
    private final /* synthetic */ EWS this$0;

    EWS$EWSAreaRow(EWS eWS, int n, String string) {
        this.this$0 = eWS;
        super(n, 3);
        this.setInteger(0, n);
        this.setText(1, string);
        this.setInteger(2, 0);
    }

    private EWS$EWSAreaRow(EWS eWS, EWS$EWSAreaRow eWS$EWSAreaRow) {
        this.this$0 = eWS;
        super(eWS$EWSAreaRow);
    }

    @Override
    public EvoListRow copy() {
        return new EWS$EWSAreaRow(this.this$0, this);
    }
}

