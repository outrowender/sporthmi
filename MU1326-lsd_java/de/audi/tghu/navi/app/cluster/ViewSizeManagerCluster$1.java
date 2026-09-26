/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.tghu.navi.app.cluster.ViewSizeManagerCluster;

class ViewSizeManagerCluster$1
implements Runnable {
    private final /* synthetic */ IViewSizeListener val$viewSizeListener;
    private final /* synthetic */ int val$size;
    private final /* synthetic */ ViewSizeManagerCluster this$0;

    ViewSizeManagerCluster$1(ViewSizeManagerCluster viewSizeManagerCluster, IViewSizeListener iViewSizeListener, int n) {
        this.this$0 = viewSizeManagerCluster;
        this.val$viewSizeListener = iViewSizeListener;
        this.val$size = n;
    }

    @Override
    public void run() {
        this.val$viewSizeListener.viewSizeChanged(this.val$size);
    }
}

