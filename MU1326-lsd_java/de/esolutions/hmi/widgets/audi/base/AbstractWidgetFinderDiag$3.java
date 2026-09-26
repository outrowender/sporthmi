/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.AbstractWidgetFinderDiag;

class AbstractWidgetFinderDiag$3
implements Runnable {
    private final /* synthetic */ AbstractWidgetFinderDiag this$0;

    AbstractWidgetFinderDiag$3(AbstractWidgetFinderDiag abstractWidgetFinderDiag) {
        this.this$0 = abstractWidgetFinderDiag;
    }

    @Override
    public void run() {
        this.this$0.clearMarkerSynced();
    }
}

