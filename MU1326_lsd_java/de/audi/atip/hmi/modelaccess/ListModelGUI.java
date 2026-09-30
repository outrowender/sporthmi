/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface ListModelGUI
extends HMIModelGUI {
    public static final int NO_SELECTION = -1;
    public static final int FLAG_DATA_CHANGED = 1;
    public static final int FLAG_SELECTION_CHANGED = 2;
    public static final int FLAG_MAX_ROWS_CHANGED = 4;
    public static final int FLAG_MAX_COLS_CHANGED = 8;

    public ListCell getCell(int var1, int var2);

    public Class getColumnType(int var1);

    public int getLength();

    public int getMaxColumns();

    public int getMaxRows();

    public boolean getRow(int var1, ListCell[] var2);

    public int getSelected();

    public void itemFocused(int var1, int var2, int var3);

    public void itemSelected(int var1, int var2, int var3);

    public void itemReleased(int var1, int var2, int var3);
}

