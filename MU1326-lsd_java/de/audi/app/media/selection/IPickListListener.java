/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.dsi.media.MediaListEntry;

public interface IPickListListener {
    default public void responsePicklist(MediaListEntry[] mediaListEntryArray, boolean bl) {
    }
}

