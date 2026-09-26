/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.ListModelGUI;

public interface FolderListModelGUI
extends ListModelGUI {
    public static final int COLUMN_ROW_ID;
    public static final int COLUMN_ENSEMBLE_STATE;
    public static final int FOLDER_NONE;
    public static final int FOLDER_OPEN;
    public static final int FOLDER_CLOSED;

    default public int getIndexForRowID(int n) {
    }

    default public int getRowIDForIndex(int n) {
    }

    default public int itemSelected(int n, int n2, int n3, int n4) {
    }

    default public void getSelected(int[] nArray) {
    }
}

