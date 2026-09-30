/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.dsi.media.MediaListEntry;
import org.dsi.ifc.global.CharacterInfo;

public interface IBrowseListListener {
    public void browseModeChanged(boolean var1, int var2);

    public void browseFolderChanged(boolean var1, MediaListEntry[] var2, int var3);

    public void listUpdated(int var1);

    public int getClientId();

    public void responseList(boolean var1, MediaListEntry[] var2, int var3);

    public void responsePickList(boolean var1, MediaListEntry[] var2);

    public void addSelectionResult(boolean var1, int var2, int var3, boolean var4, long var5, long var7, long var9, long var11, long var13);

    public void resetSelectionResult(boolean var1, int var2);

    public void notifyMetadataEntryAvailable(boolean var1);

    public void notifyFilesystemEntryAvailable(boolean var1);

    public void notifyCoverartsAvailable(boolean var1);

    public void notifyUpdateAlphabeticalIndex(CharacterInfo[] var1);
}

