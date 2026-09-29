/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.dsi.media.MediaListEntry;
import org.dsi.ifc.global.CharacterInfo;

public interface IBrowseListListener {
    default public void browseModeChanged(boolean bl, int n) {
    }

    default public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    default public void listUpdated(int n) {
    }

    default public int getClientId() {
    }

    default public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    default public void responsePickList(boolean bl, MediaListEntry[] mediaListEntryArray) {
    }

    default public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4, long l5) {
    }

    default public void resetSelectionResult(boolean bl, int n) {
    }

    default public void notifyMetadataEntryAvailable(boolean bl) {
    }

    default public void notifyFilesystemEntryAvailable(boolean bl) {
    }

    default public void notifyCoverartsAvailable(boolean bl) {
    }

    default public void notifyUpdateAlphabeticalIndex(CharacterInfo[] characterInfoArray) {
    }
}

