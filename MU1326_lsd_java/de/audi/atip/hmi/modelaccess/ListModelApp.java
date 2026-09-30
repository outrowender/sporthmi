/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface ListModelApp
extends HMIModelApp {
    public static final int NO_SELECTION = -1;

    public void setCell(int var1, int var2, ListCell var3);

    public ListCell getCell(int var1, int var2);

    public Class getColumnType(int var1);

    public int getLength();

    public int getLengthOnTransaction();

    public void setListListener(ListListener var1);

    public void setMaxColumns(int var1);

    public int getMaxColumns();

    public void setMaxRows(int var1);

    public int getMaxRows();

    public void setRow(int var1, BaseListRow var2);

    public void setRow(int var1, ListCell var2);

    public void setRow(int var1, ListCell[] var2);

    public boolean getRow(int var1, ListCell[] var2);

    public BaseListRow getRow(int var1);

    public BaseListRow getRowOnTransaction(int var1);

    public void setSelected(int var1);

    public int getSelected();

    public void addRow(BaseListRow var1);

    public void addRow(ListCell var1);

    public void addRow(ListCell[] var1);

    public void clear();

    public void insertRow(int var1, BaseListRow var2);

    public void insertRow(int var1, ListCell var2);

    public void insertRow(int var1, ListCell[] var2);

    public void removeRow(int var1);
}

