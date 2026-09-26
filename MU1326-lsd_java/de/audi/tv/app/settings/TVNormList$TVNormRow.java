/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tv.app.settings.TVNormList;

class TVNormList$TVNormRow
extends EvoListRow {
    private static final int COL_COUNT;
    private static final int COL_NORM_ID;
    private static final int COL_NORM_SELECTED;
    private static final int COL_NORM_CLOSE_OPTION;
    static final int NORM_NOT_SELECTED;
    static final int NORM_IS_SELECTED;
    final int id;
    private final /* synthetic */ TVNormList this$0;

    private TVNormList$TVNormRow(TVNormList tVNormList, TVNormList$TVNormRow tVNormList$TVNormRow) {
        this.this$0 = tVNormList;
        super(tVNormList$TVNormRow);
        this.id = tVNormList$TVNormRow.id;
    }

    protected TVNormList$TVNormRow(TVNormList tVNormList, int n, int n2) {
        this.this$0 = tVNormList;
        super(n, 3);
        this.id = n;
        this.setInteger(0, n);
        this.setInteger(1, n2);
        this.setInteger(2, 1);
    }

    public void setSelected(int n) {
        this.setInteger(1, n);
    }

    @Override
    public EvoListRow copy() {
        return new TVNormList$TVNormRow(this.this$0, this);
    }
}

