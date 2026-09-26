/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.AbstractWidgetFinderDiag;

class AbstractWidgetFinderDiag$1
implements Runnable {
    private final /* synthetic */ int val$width;
    private final /* synthetic */ int val$height;
    private final /* synthetic */ int val$x;
    private final /* synthetic */ int val$y;
    private final /* synthetic */ AbstractWidgetFinderDiag this$0;

    AbstractWidgetFinderDiag$1(AbstractWidgetFinderDiag abstractWidgetFinderDiag, int n, int n2, int n3, int n4) {
        this.this$0 = abstractWidgetFinderDiag;
        this.val$width = n;
        this.val$height = n2;
        this.val$x = n3;
        this.val$y = n4;
    }

    @Override
    public void run() {
        int n = Math.max(this.val$width, 1);
        int n2 = Math.max(this.val$height, 1);
        this.this$0.markSynced(this.val$x, this.val$y, n, n2);
    }
}

