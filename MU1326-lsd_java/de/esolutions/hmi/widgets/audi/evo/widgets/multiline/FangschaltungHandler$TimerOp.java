/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.FangschaltungHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.FangschaltungHandler$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.ITimer;

class FangschaltungHandler$TimerOp
implements ITimer {
    private final /* synthetic */ FangschaltungHandler this$0;

    private FangschaltungHandler$TimerOp(FangschaltungHandler fangschaltungHandler) {
        this.this$0 = fangschaltungHandler;
    }

    @Override
    public void onEnqueue(int n) {
        FangschaltungHandler.access$000((FangschaltungHandler)this.this$0)[n] = 1;
    }

    @Override
    public void onTimeout(int n) {
        FangschaltungHandler.access$000((FangschaltungHandler)this.this$0)[n] = 2;
    }

    @Override
    public void onCancel(int n) {
        FangschaltungHandler.access$000((FangschaltungHandler)this.this$0)[n] = 3;
    }

    /* synthetic */ FangschaltungHandler$TimerOp(FangschaltungHandler fangschaltungHandler, FangschaltungHandler$1 fangschaltungHandler$1) {
        this(fangschaltungHandler);
    }
}

