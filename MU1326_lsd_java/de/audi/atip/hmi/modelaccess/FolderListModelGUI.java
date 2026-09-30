/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.ListModelGUI;

public interface FolderListModelGUI
extends ListModelGUI {
    public static final int COLUMN_ROW_ID = 0;
    public static final int COLUMN_ENSEMBLE_STATE = 2;
    public static final int FOLDER_NONE = 0;
    public static final int FOLDER_OPEN = 1;
    public static final int FOLDER_CLOSED = 2;

    public int getIndexForRowID(int var1);

    public int getRowIDForIndex(int var1);

    public int itemSelected(int var1, int var2, int var3, int var4);

    public void getSelected(int[] var1);
}

