/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.source.ISourceSlot;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DataSelectionContainer
implements IDataSelectionContext {
    private final int browseMode;
    private final MediaListEntry[] folder;
    public static final DataSelectionContainer INVALID_CONTAINER = new DataSelectionContainer(null, -1, null, null, null);
    private final MediaListEntry folderToSelect;
    private final MediaListEntry entryToPlay;
    protected final Map metadata = new HashMap(6);
    private final int browserCategory;
    private final MediaDetailInfo detailInfo;
    private final ISourceSlot sourceSlot;

    public DataSelectionContainer(ISourceSlot iSourceSlot, int n, MediaListEntry[] mediaListEntryArray, MediaListEntry mediaListEntry, MediaListEntry mediaListEntry2) {
        this.browseMode = n;
        this.folder = mediaListEntryArray;
        this.folderToSelect = mediaListEntry;
        this.entryToPlay = mediaListEntry2;
        this.detailInfo = null;
        this.browserCategory = 0;
        this.sourceSlot = iSourceSlot;
    }

    public DataSelectionContainer(ISourceSlot iSourceSlot, MediaListEntry mediaListEntry, int n, MediaDetailInfo mediaDetailInfo) {
        this.browseMode = 1;
        this.folder = null;
        this.folderToSelect = null;
        this.entryToPlay = mediaListEntry;
        this.browserCategory = n;
        this.detailInfo = mediaDetailInfo;
        this.sourceSlot = iSourceSlot;
    }

    public DataSelectionContainer(ISourceSlot iSourceSlot, MediaListEntry mediaListEntry, int n, MediaListEntry[] mediaListEntryArray) {
        this.browseMode = 1;
        this.folder = mediaListEntryArray;
        this.folderToSelect = null;
        this.entryToPlay = mediaListEntry;
        this.browserCategory = n;
        this.detailInfo = null;
        this.sourceSlot = iSourceSlot;
    }

    public int getBrowseMode() {
        return this.browseMode;
    }

    public MediaListEntry[] getFolder() {
        return this.folder;
    }

    public MediaListEntry getFolderToSelect() {
        return this.folderToSelect;
    }

    public MediaListEntry getEntryToPlay() {
        return this.entryToPlay;
    }

    public void addParameter(String string, Object object) {
        this.metadata.put(string, object);
    }

    public Object getParameter(String string, Object object) {
        return this.metadata.containsKey(string) ? this.metadata.get(string) : object;
    }

    public MediaDetailInfo getDetailInfo() {
        return this.detailInfo;
    }

    public String toString() {
        Buffer buffer = new Buffer(200);
        buffer.append("[browseMode=").append(this.browseMode);
        buffer.append(", folder=").append(this.folder != null ? Arrays.asList(this.folder) : null);
        buffer.append(", folderToSelect=").append(this.folderToSelect);
        buffer.append(", entryToPlay=").append(this.entryToPlay);
        buffer.append(", browserCategory=").append(this.browserCategory);
        buffer.append(", metadata=").append(this.metadata);
        buffer.append("]");
        return buffer.toString();
    }

    public int getBrowserCategory() {
        return this.browserCategory;
    }

    public ISourceSlot getSourceSlot() {
        return this.sourceSlot;
    }
}

