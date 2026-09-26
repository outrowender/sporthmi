/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.AbstractWidgetFinderDiag;

class AbstractWidgetFinderDiag$2
implements Runnable {
    private final /* synthetic */ String val$value;
    private final /* synthetic */ AbstractWidgetFinderDiag this$0;

    AbstractWidgetFinderDiag$2(AbstractWidgetFinderDiag abstractWidgetFinderDiag, String string) {
        this.this$0 = abstractWidgetFinderDiag;
        this.val$value = string;
    }

    @Override
    public void run() {
        this.this$0.callbackSelectedSynced(this.val$value);
    }
}

