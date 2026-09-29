/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$IUserHintPartialPopupListener;

final class TouchControllerListenerFactory$UserHintPartialPopupListenerImpl
implements TouchControllerListenerFactory$IUserHintPartialPopupListener {
    private static boolean hintIsShown = false;
    private TouchController touchController = null;

    private TouchControllerListenerFactory$UserHintPartialPopupListenerImpl(TouchController touchController) {
        this.touchController = touchController;
    }

    @Override
    public void partialPopupVisible(int n, int n2) {
        TouchControllerListenerFactory$UserHintPartialPopupListenerImpl.setHintIsShown(true);
        this.touchController.updateMenuCursorVisibility();
        this.touchController.stopCursorBlinkAnimation();
    }

    @Override
    public void partialPopupHidden(int n, int n2) {
        TouchControllerListenerFactory$UserHintPartialPopupListenerImpl.setHintIsShown(false);
        this.touchController.updateMenuCursorVisibility();
        this.touchController.startCursorBlinkAnimation();
    }

    @Override
    public int[] getPPIDsForCallbacks() {
        return new int[]{96, 97};
    }

    private static void setHintIsShown(boolean bl) {
        hintIsShown = bl;
    }

    @Override
    public boolean isUserHintShown() {
        return hintIsShown;
    }

    @Override
    public void partialPopupRemoved(int n, int n2) {
    }

    @Override
    public void partialPopupListenerRegistered(int n, int n2, boolean bl) {
    }

    @Override
    public void informAboutPPCoordinates(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    static /* synthetic */ boolean access$000() {
        return hintIsShown;
    }

    /* synthetic */ TouchControllerListenerFactory$UserHintPartialPopupListenerImpl(TouchController touchController, TouchControllerListenerFactory$1 touchControllerListenerFactory$1) {
        this(touchController);
    }
}

