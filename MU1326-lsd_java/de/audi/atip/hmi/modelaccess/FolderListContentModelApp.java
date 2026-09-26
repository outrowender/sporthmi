/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.ListModelApp;

public interface FolderListContentModelApp
extends ListModelApp {
    public static final int INDEX_ROW_ID;
    public static final int INDEX_IS_FOLDER;
    public static final int INDEX_FOLDER_ID;

    default public int getFolderIndex(int n) {
    }
}

