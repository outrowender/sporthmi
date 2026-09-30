/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.source.ISourceSlot;

public interface IDataSelectionContext {
    public int getBrowseMode();

    public MediaListEntry[] getFolder();

    public MediaListEntry getFolderToSelect();

    public MediaListEntry getEntryToPlay();

    public int getBrowserCategory();

    public MediaDetailInfo getDetailInfo();

    public void addParameter(String var1, Object var2);

    public Object getParameter(String var1, Object var2);

    public ISourceSlot getSourceSlot();
}

