/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.tghu.navi.app.map.handler.CruiseModeHandler;

class CruiseModeHandler$2
implements Runnable {
    private final /* synthetic */ boolean val$active;
    private final /* synthetic */ CruiseModeHandler this$0;

    CruiseModeHandler$2(CruiseModeHandler cruiseModeHandler, boolean bl) {
        this.this$0 = cruiseModeHandler;
        this.val$active = bl;
    }

    @Override
    public void run() {
        CruiseModeHandler.access$100(this.this$0).updateCruiseMode(this.val$active);
    }
}

