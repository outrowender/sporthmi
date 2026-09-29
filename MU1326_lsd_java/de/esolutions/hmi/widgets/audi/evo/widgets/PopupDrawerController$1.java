/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.PopupDrawerController;

class PopupDrawerController$1
implements Runnable {
    private final /* synthetic */ PopupDrawerController this$0;

    PopupDrawerController$1(PopupDrawerController popupDrawerController) {
        this.this$0 = popupDrawerController;
    }

    @Override
    public void run() {
        this.this$0.closePopupDrawer();
        this.this$0.triggerRepaint();
    }
}

