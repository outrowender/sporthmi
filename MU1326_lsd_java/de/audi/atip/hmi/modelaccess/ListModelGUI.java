/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface ListModelGUI
extends HMIModelGUI {
    public static final int NO_SELECTION;
    public static final int FLAG_DATA_CHANGED;
    public static final int FLAG_SELECTION_CHANGED;
    public static final int FLAG_MAX_ROWS_CHANGED;
    public static final int FLAG_MAX_COLS_CHANGED;

    default public ListCell getCell(int n, int n2) {
    }

    default public Class getColumnType(int n) {
    }

    default public int getLength() {
    }

    default public int getMaxColumns() {
    }

    default public int getMaxRows() {
    }

    default public boolean getRow(int n, ListCell[] listCellArray) {
    }

    default public int getSelected() {
    }

    default public void itemFocused(int n, int n2, int n3) {
    }

    default public void itemSelected(int n, int n2, int n3) {
    }

    default public void itemReleased(int n, int n2, int n3) {
    }
}

