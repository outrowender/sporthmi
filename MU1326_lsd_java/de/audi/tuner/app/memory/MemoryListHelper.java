/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.memory;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import java.util.ArrayList;

public class MemoryListHelper {
    public static final int RS_DEFAULT = 0;
    static final int RS_PAG_EMPTY = 1;
    public static final int RS_PAG_LOGO = 2;
    public static final int RS_PAG_BEST_FM = 3;
    public static final int RS_PAG_NON_RDS = 4;
    public static final int RS_PAG_BEST_FM_TWO_COLS = 5;
    public static final int RS_EVO_NAR = 1;
    public static final int RS_TWO_COLS_WITH_UNIT = 4;
    public static final int RS_TWO_COLS_WITH_UNIT_ARABIC = 9;
    public static final int RS_ONE_COL_WITH_UNIT_NO_NAME = 5;
    public static final int RS_EVO_NAR_AMFM = 6;
    public static final int RS_SHOW_STORE = 7;
    public static final int RS_SDARS_GREY = 8;
    public static final int RS_PGEN2_NAME = 0;
    public static final int RS_PGEN2_FREQ = 1;
    public static final int RS_PGEN2_LOGO = 2;
    private final BaseListModelApp model;

    public MemoryListHelper(BaseListModelApp baseListModelApp, LogChannel logChannel, int n) {
        this.model = baseListModelApp;
    }

    final AbstractMemoryRow getRow(int n) {
        AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)this.model.getRow(n);
        if (abstractMemoryRow == null) {
            throw new IllegalStateException("No row for index " + n + " found!");
        }
        return abstractMemoryRow;
    }

    public final AbstractMemoryRow[] getRows() {
        AbstractMemoryRow[] abstractMemoryRowArray = new AbstractMemoryRow[this.getLength()];
        for (int i2 = 0; i2 < abstractMemoryRowArray.length; ++i2) {
            abstractMemoryRowArray[i2] = this.getRow(i2);
        }
        return abstractMemoryRowArray;
    }

    public final AbstractMemoryRow[] getRows(int n) {
        AbstractMemoryRow[] abstractMemoryRowArray = this.getRows();
        ArrayList arrayList = new ArrayList(abstractMemoryRowArray.length);
        for (int i2 = 0; i2 < abstractMemoryRowArray.length; ++i2) {
            if (abstractMemoryRowArray[i2].getBand() != n) continue;
            arrayList.add(abstractMemoryRowArray[i2]);
        }
        Object[] objectArray = new AbstractMemoryRow[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    public final int getLength() {
        return this.model.getLength();
    }

    public static int getRS(int n) {
        if (Utilities.isNARBuild() && !Utilities.isPGen1OrBentley()) {
            if (n == 7) {
                return 1;
            }
            return 6;
        }
        if (Utilities.isPiIgnore()) {
            return 4;
        }
        return 0;
    }
}

