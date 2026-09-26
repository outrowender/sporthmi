/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractDynamicSidebar;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ListScrollingController;

class AbstractDynamicSidebar$1
extends ListScrollingController {
    private final /* synthetic */ AbstractDynamicSidebar this$0;

    AbstractDynamicSidebar$1(AbstractDynamicSidebar abstractDynamicSidebar, int n, int n2, int n3, int n4) {
        this.this$0 = abstractDynamicSidebar;
        super(n, n2, n3, n4);
    }

    @Override
    void positionElements(float f2) {
        if (!this.this$0.activeIndices.isEmpty()) {
            this.this$0.updateCursorPosition(f2);
            float f3 = this.this$0.calculateProgress(f2);
            int n = this.this$0.calculateHeightDifference(this.pDestLineCount);
            this.this$0.updateCursorHeight(this.this$0.cursorHeightAtAnimationStart + Math.round(f3 * (float)n));
        }
    }

    @Override
    public void scrollingStopped() {
    }
}

