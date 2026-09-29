/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$1;

final class TouchControllerListenerFactory$FingerTraceListenerImpl
implements FingerTraceListener {
    private TouchController touchController = null;

    private TouchControllerListenerFactory$FingerTraceListenerImpl(TouchController touchController) {
        this.touchController = touchController;
    }

    @Override
    public void onVisibilityChange() {
        this.touchController.calculateCursorPosition();
    }

    @Override
    public void onFingerTraceHide() {
        this.touchController.setCompositeDirty(1);
    }

    /* synthetic */ TouchControllerListenerFactory$FingerTraceListenerImpl(TouchController touchController, TouchControllerListenerFactory$1 touchControllerListenerFactory$1) {
        this(touchController);
    }
}

