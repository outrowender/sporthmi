/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.source.ISourceSlot;

public interface IDataSelectionContext {
    default public int getBrowseMode() {
    }

    default public MediaListEntry[] getFolder() {
    }

    default public MediaListEntry getFolderToSelect() {
    }

    default public MediaListEntry getEntryToPlay() {
    }

    default public int getBrowserCategory() {
    }

    default public MediaDetailInfo getDetailInfo() {
    }

    default public void addParameter(String string, Object object) {
    }

    default public Object getParameter(String string, Object object) {
    }

    default public ISourceSlot getSourceSlot() {
    }
}

