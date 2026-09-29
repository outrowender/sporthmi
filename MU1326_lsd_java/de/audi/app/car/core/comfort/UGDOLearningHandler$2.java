/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.core.comfort.UGDOLearningHandler;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;

class UGDOLearningHandler$2
extends DefaultChoiceListener {
    private final /* synthetic */ UGDOLearningHandler this$0;

    UGDOLearningHandler$2(UGDOLearningHandler uGDOLearningHandler) {
        this.this$0 = uGDOLearningHandler;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        UGDOLearningHandler.access$000(this.this$0).log(1078071040, "[UGDOLearningHandler#itemSelected] modelID='%1' itemID='%2'", (long)n, (long)n2);
        if (n == 1546651904) {
            switch (n2) {
                case 0: {
                    UGDOLearningHandler.access$000(this.this$0).log(1078071040, "[UGDOLearningHandler#itemSelected] Fixkit selected.");
                    UGDOLearningHandler.access$102(this.this$0, false);
                    UGDOLearningHandler.access$1000(this.this$0, UGDOLearningHandler.access$900(this.this$0), 5);
                    break;
                }
                case 1: {
                    UGDOLearningHandler.access$000(this.this$0).log(1078071040, "[UGDOLearningHandler#itemSelected] DefaultMode selected.");
                    UGDOLearningHandler.access$102(this.this$0, false);
                    UGDOLearningHandler.access$1000(this.this$0, UGDOLearningHandler.access$900(this.this$0), 6);
                    break;
                }
                default: {
                    UGDOLearningHandler.access$000(this.this$0).log(-1601830656, "[UGDOLearningHandler#itemSelected] modelID='%1' not supported.", (long)n);
                }
            }
        }
    }
}

