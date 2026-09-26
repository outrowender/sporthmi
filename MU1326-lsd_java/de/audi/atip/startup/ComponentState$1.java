/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.ComponentState;
import java.util.List;

class ComponentState$1
implements Runnable {
    private final /* synthetic */ List val$queue;
    private final /* synthetic */ boolean val$startSubComponents;
    private final /* synthetic */ ComponentState this$0;

    ComponentState$1(ComponentState componentState, List list, boolean bl) {
        this.this$0 = componentState;
        this.val$queue = list;
        this.val$startSubComponents = bl;
    }

    @Override
    public void run() {
        ComponentState.access$000(this.this$0, this.val$queue, true, this.val$startSubComponents);
    }
}

