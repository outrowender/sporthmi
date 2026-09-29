/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.parental;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tv.app.settings.parental.ParentalLevelList;

class ParentalLevelList$ParentalLevelRow
extends EvoListRow {
    private static final int MAX_COLUMNS;
    private static final int COL_ID;
    private static final int COL_SELECTED;
    private static final int COL_CLOSE_OPTIONS;
    private static final int COL_RECORDSET;
    private static final int RECORDSET_UNRESTRICTED;
    private static final int RECORDSET_RESTRICTED;
    static final int LEVEL_SELECTED;
    static final int LEVEL_UNSELECTED;
    final int ageLevel;
    private final /* synthetic */ ParentalLevelList this$0;

    ParentalLevelList$ParentalLevelRow(ParentalLevelList parentalLevelList, int n) {
        this(parentalLevelList, n, 0);
    }

    ParentalLevelList$ParentalLevelRow(ParentalLevelList parentalLevelList, int n, int n2) {
        this.this$0 = parentalLevelList;
        super(n, 4);
        this.ageLevel = n * 2;
        this.setInteger(0, n);
        this.setInteger(1, n2);
        this.setInteger(2, 1);
        this.setInteger(3, n == 0 ? 0 : 1);
    }

    private ParentalLevelList$ParentalLevelRow(ParentalLevelList parentalLevelList, ParentalLevelList$ParentalLevelRow parentalLevelList$ParentalLevelRow) {
        this.this$0 = parentalLevelList;
        super(parentalLevelList$ParentalLevelRow);
        this.ageLevel = parentalLevelList$ParentalLevelRow.ageLevel;
    }

    void setSelected(int n) {
        this.setInteger(1, n);
    }

    @Override
    public EvoListRow copy() {
        return new ParentalLevelList$ParentalLevelRow(this.this$0, this);
    }
}

