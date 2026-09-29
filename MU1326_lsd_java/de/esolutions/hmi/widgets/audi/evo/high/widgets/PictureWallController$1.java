/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.evo.high.widgets.ListScrollingController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallController;

class PictureWallController$1
extends ListScrollingController {
    private final /* synthetic */ PictureWallController this$0;

    PictureWallController$1(PictureWallController pictureWallController, int n, int n2, int n3, int n4) {
        this.this$0 = pictureWallController;
        super(n, n2, n3, n4);
    }

    @Override
    void positionElements(float f2) {
        PictureWallController.access$000(this.this$0, f2);
    }

    @Override
    public void scrollingStopped() {
        PictureWallController.access$100(this.this$0).sortQueues();
    }
}

