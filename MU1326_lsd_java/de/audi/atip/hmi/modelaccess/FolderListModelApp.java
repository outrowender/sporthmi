/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public interface FolderListModelApp
extends ListModelApp {
    public static final int INDEX_ROW_ID = 0;
    public static final int INDEX_FOLDER_ID = 1;
    public static final int INDEX_IS_FOLDER = 2;
    public static final int FOLDERSTATE_OPEN = 1;
    public static final int FOLDERSTATE_CLOSED = 0;
    public static final int FOLDERSTATE_UNKNOWN = -1;

    public SimpleIntIntMap getFolderStates();

    public void setFolderStates(SimpleIntIntMap var1);

    public boolean isOpen(int var1);
}

