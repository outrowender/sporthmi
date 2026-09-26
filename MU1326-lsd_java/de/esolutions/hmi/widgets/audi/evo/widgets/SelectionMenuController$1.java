/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionMenuController;

class SelectionMenuController$1
implements AnimationListener {
    private final /* synthetic */ SelectionMenuController this$0;

    SelectionMenuController$1(SelectionMenuController selectionMenuController) {
        this.this$0 = selectionMenuController;
    }

    @Override
    public void animate(int n, float f2, int n2) {
        float f3 = SelectionMenuController.access$700(this.this$0).getProgress();
        this.this$0.subViewportPosition.setProgress(f3);
        this.this$0.assignSubSlots();
        this.this$0.updateSubScrollbar();
        this.this$0.setCompositesDirty(true);
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
        this.this$0.subViewportPosition.setProgress(1.0f);
        this.this$0.assignSubSlots();
        this.this$0.updateSubScrollbar();
        this.this$0.setCompositesDirty(true);
    }
}

