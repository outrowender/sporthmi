/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.queue.IQueueJob;

public interface IDataSelectionJob
extends IQueueJob {
    default public void browserActivated() {
    }

    default public void browserDeactivated(boolean bl) {
    }

    default public void browseModeChanged(boolean bl, int n) {
    }

    default public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    default public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    default public void responsePicklist(boolean bl, MediaListEntry[] mediaListEntryArray) {
    }

    default public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4, long l5) {
    }
}

