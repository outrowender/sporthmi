/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public interface FolderListModelApp
extends ListModelApp {
    public static final int INDEX_ROW_ID;
    public static final int INDEX_FOLDER_ID;
    public static final int INDEX_IS_FOLDER;
    public static final int FOLDERSTATE_OPEN;
    public static final int FOLDERSTATE_CLOSED;
    public static final int FOLDERSTATE_UNKNOWN;

    default public SimpleIntIntMap getFolderStates() {
    }

    default public void setFolderStates(SimpleIntIntMap simpleIntIntMap) {
    }

    default public boolean isOpen(int n) {
    }
}

