/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceListener;
import java.util.Iterator;

class FingerTraceController$1
implements FingerTraceListener {
    private final /* synthetic */ FingerTraceController this$0;

    FingerTraceController$1(FingerTraceController fingerTraceController) {
        this.this$0 = fingerTraceController;
    }

    @Override
    public void onVisibilityChange() {
        Iterator iterator = FingerTraceController.access$000(this.this$0).iterator();
        while (iterator.hasNext()) {
            ((FingerTraceListener)iterator.next()).onVisibilityChange();
        }
    }

    @Override
    public void onFingerTraceHide() {
        Iterator iterator = FingerTraceController.access$000(this.this$0).iterator();
        while (iterator.hasNext()) {
            ((FingerTraceListener)iterator.next()).onFingerTraceHide();
        }
    }
}

