/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.MediaListEntry;
import org.dsi.ifc.global.CharacterInfo;

public interface IMediaBrowserStateListener {
    default public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray) {
    }

    default public void updateBrowseMode(int n) {
    }

    default public void updateContentFilter(int n) {
    }

    default public void updateListSize(int n, int n2) {
    }

    default public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
    }

    default public void errorFolderChange() {
    }

    default public void errorSelection() {
    }

    default public void errorBrowseMode() {
    }

    default public void updateAlphabeticalIndex(CharacterInfo[] characterInfoArray) {
    }
}

