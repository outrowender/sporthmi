/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.core.comfort.UGDOLearningHandler;
import de.audi.atip.hmi.model.menu.MenuModelListener;

class UGDOLearningHandler$3
implements MenuModelListener {
    private final /* synthetic */ UGDOLearningHandler this$0;

    UGDOLearningHandler$3(UGDOLearningHandler uGDOLearningHandler) {
        this.this$0 = uGDOLearningHandler;
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        UGDOLearningHandler.access$000(this.this$0).log(1078071040, "[UGDOLearningHandler#itemFocused] modelID='%1' menuItemId: '%2'", (long)n2, (long)n);
        switch (n2) {
            case 602217: {
                UGDOLearningHandler.access$1100(this.this$0, n);
                break;
            }
            default: {
                UGDOLearningHandler.access$000(this.this$0).log(-1601830656, "[UGDOLearningHandler#itemFocused] modelID='%1' not supported (menuItemId: '%2')", (long)n2, (long)n);
            }
        }
    }
}

