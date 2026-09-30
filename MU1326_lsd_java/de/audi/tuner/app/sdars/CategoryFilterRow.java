/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.sdars.CategoryInfo;

public class CategoryFilterRow
extends EvoListRow {
    private static final int MAX_COLS = 3;
    public static final int INDEX_FULL_NAME = 0;
    private static final int INDEX_FILTER_CHECKED = 1;
    private static final int INDEX_FILTER_DISABLED = 2;
    private volatile boolean hasSubscribedStations;

    public CategoryFilterRow(CategoryInfo categoryInfo, int n) {
        super(categoryInfo.categoryNumber, 3);
        this.setText(0, categoryInfo.fullLabel);
        this.setInteger(2, 1);
        this.setInteger(1, n);
    }

    private CategoryFilterRow(CategoryFilterRow categoryFilterRow) {
        super(categoryFilterRow);
        this.hasSubscribedStations = categoryFilterRow.hasSubscribedStations;
    }

    public EvoListRow copy() {
        return new CategoryFilterRow(this);
    }

    public void setChecked(boolean bl) {
        this.setInteger(1, bl ? 1 : 0);
    }

    public boolean isChecked() {
        return this.getInteger(1) == 1;
    }

    public boolean containsSubscribedStations() {
        return this.hasSubscribedStations;
    }

    public void setContainsSubscribedStations(boolean bl) {
        this.hasSubscribedStations = bl;
    }

    public int getCategory() {
        return (int)this.getUniqueID();
    }
}

