/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.ListRowComparator;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface AbstractListModelApp
extends HMIModelApp {
    public void setRowsPerScreen(int var1);

    public void jumpToStartOfListSupported(boolean var1);

    public void jumpToEndOfListSupported(boolean var1);

    public void clear();

    public boolean setFocusedCursorPosition(ListRow var1, int var2);

    public void setMaxColumns(int var1);

    public ListRow getRow(ListRowComparator var1);

    public ListRow[] getRows(ListRowComparator var1);

    public ListRow getFirstRow();

    public ListRow getLastRow();

    public ListRow getPreviousRow(ListRow var1);

    public ListRow getNextRow(ListRow var1);

    public ListRow getVisibleRow(int var1);

    public boolean contains(ListRow var1);

    public void enableFastScrolling(boolean var1);

    public void setListLength(int var1);

    public int getListLength();

    public int getVisibleRowsCount();
}

