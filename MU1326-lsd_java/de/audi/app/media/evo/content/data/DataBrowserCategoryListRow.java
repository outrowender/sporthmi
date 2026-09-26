/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.evo.content.data.DataBrowserListLocator;
import de.audi.atip.hmi.model.list.EvoListRow;

public class DataBrowserCategoryListRow
extends EvoListRow {
    private static final int COLUMN_SIZE;
    private static final int COL_CATEGORY_ID;
    private static final DataBrowserCategoryListRow[] catRows;

    private DataBrowserCategoryListRow(int n) {
        super(n, 1);
        this.setInteger(0, n);
    }

    public DataBrowserCategoryListRow(DataBrowserCategoryListRow dataBrowserCategoryListRow) {
        super(dataBrowserCategoryListRow);
        this.setInteger(0, dataBrowserCategoryListRow.getCategoryID());
    }

    public static DataBrowserCategoryListRow create(int n) {
        return catRows[n];
    }

    public int getCategoryID() {
        return this.getInteger(0);
    }

    @Override
    public EvoListRow copy() {
        return new DataBrowserCategoryListRow(this);
    }

    @Override
    public String toString() {
        return DataBrowserListLocator.categoryID2Str(this.getCategoryID());
    }

    static {
        catRows = new DataBrowserCategoryListRow[]{new DataBrowserCategoryListRow(0), new DataBrowserCategoryListRow(1), new DataBrowserCategoryListRow(2), new DataBrowserCategoryListRow(3), new DataBrowserCategoryListRow(4), new DataBrowserCategoryListRow(5), new DataBrowserCategoryListRow(6), new DataBrowserCategoryListRow(7), new DataBrowserCategoryListRow(8), new DataBrowserCategoryListRow(9), new DataBrowserCategoryListRow(10), new DataBrowserCategoryListRow(11), new DataBrowserCategoryListRow(12)};
    }
}

