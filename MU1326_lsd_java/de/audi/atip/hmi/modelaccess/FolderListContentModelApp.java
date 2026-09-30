/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.ListModelApp;

public interface FolderListContentModelApp
extends ListModelApp {
    public static final int INDEX_ROW_ID = 0;
    public static final int INDEX_IS_FOLDER = 2;
    public static final int INDEX_FOLDER_ID = 1;

    public int getFolderIndex(int var1);
}

