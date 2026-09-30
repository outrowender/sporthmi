/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.queue.IQueueJob;

public interface IDataSelectionJob
extends IQueueJob {
    public void browserActivated();

    public void browserDeactivated(boolean var1);

    public void browseModeChanged(boolean var1, int var2);

    public void browseFolderChanged(boolean var1, MediaListEntry[] var2, int var3);

    public void responseList(boolean var1, MediaListEntry[] var2, int var3);

    public void responsePicklist(boolean var1, MediaListEntry[] var2);

    public void addSelectionResult(boolean var1, int var2, int var3, boolean var4, long var5, long var7, long var9, long var11, long var13);
}

