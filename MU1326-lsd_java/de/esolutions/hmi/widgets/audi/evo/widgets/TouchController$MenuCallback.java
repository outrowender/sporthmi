/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuCallbackAdapter;

final class TouchController$MenuCallback
extends MenuCallbackAdapter {
    private final /* synthetic */ TouchController this$0;

    private TouchController$MenuCallback(TouchController touchController) {
        this.this$0 = touchController;
    }

    @Override
    public void menuLayouted() {
        if (this.shouldExecuteInitialJump5()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchController.MenuCallback#menuLayouted initially focus first menu item because of jump-5 rule");
            this.this$0.focusFirstMenuLineAfterTouchfield(true);
        }
        TouchController.access$002(this.this$0, -1);
    }

    private boolean shouldExecuteInitialJump5() {
        return TouchController.access$000(this.this$0) > 0 && TouchController.access$000(this.this$0) <= 5 && this.this$0.isVisibleInHierarchy() && this.this$0.isFocused() && !this.this$0.userHintPartialPopupListener.isUserHintShown();
    }

    /* synthetic */ TouchController$MenuCallback(TouchController touchController, TouchController$1 touchController$1) {
        this(touchController);
    }
}

