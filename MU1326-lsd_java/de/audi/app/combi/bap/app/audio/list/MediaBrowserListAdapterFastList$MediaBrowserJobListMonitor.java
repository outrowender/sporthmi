/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.fw.arrays.AbstractArrayJobListMonitor;
import de.audi.app.bap.fw.arrays.ArrayJobList;
import de.audi.app.combi.bap.app.audio.list.MediaBrowserListAdapterFastList;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;

class MediaBrowserListAdapterFastList$MediaBrowserJobListMonitor
extends AbstractArrayJobListMonitor {
    private final /* synthetic */ MediaBrowserListAdapterFastList this$0;

    public MediaBrowserListAdapterFastList$MediaBrowserJobListMonitor(MediaBrowserListAdapterFastList mediaBrowserListAdapterFastList, LogChannel logChannel) {
        this.this$0 = mediaBrowserListAdapterFastList;
        super(logChannel);
    }

    @Override
    public void epilogue(CommandList commandList) {
        if (commandList instanceof ArrayJobList) {
            MediaBrowserListAdapterFastList.access$000(this.this$0).responseMediaBrowserJobs(255, 10);
        }
        super.epilogue(commandList);
    }

    @Override
    public void notifyJobFinished(int n) {
        MediaBrowserListAdapterFastList.access$000(this.this$0).responseMediaBrowserJobs(n, 0);
    }

    @Override
    public void notifyJobCancelled(int n) {
        MediaBrowserListAdapterFastList.access$000(this.this$0).responseMediaBrowserJobs(n, 2);
    }
}

