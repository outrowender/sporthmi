/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.MediaListEntry;
import org.dsi.ifc.global.CharacterInfo;

public interface IMediaBrowserStateListener {
    public void updateBrowseFolder(MediaListEntry[] var1);

    public void updateBrowseMode(int var1);

    public void updateContentFilter(int var1);

    public void updateListSize(int var1, int var2);

    public void selectionResult(int var1, int var2, boolean var3, long var4, long var6, long var8, long var10, long var12);

    public void errorFolderChange();

    public void errorSelection();

    public void errorBrowseMode();

    public void updateAlphabeticalIndex(CharacterInfo[] var1);
}

