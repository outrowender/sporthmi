/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.tghu.navi.app.cluster.ViewSizeManagerCluster;

class ViewSizeManagerCluster$2
implements Runnable {
    private final /* synthetic */ IViewSizeListener val$listener;
    private final /* synthetic */ ViewSizeManagerCluster this$0;

    ViewSizeManagerCluster$2(ViewSizeManagerCluster viewSizeManagerCluster, IViewSizeListener iViewSizeListener) {
        this.this$0 = viewSizeManagerCluster;
        this.val$listener = iViewSizeListener;
    }

    @Override
    public void run() {
        this.val$listener.viewSizeChanged(ViewSizeManagerCluster.access$000(this.this$0));
    }
}

