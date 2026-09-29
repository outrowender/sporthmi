/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;

class EALManager$2
implements Runnable {
    private final /* synthetic */ EALManager this$0;

    EALManager$2(EALManager eALManager) {
        this.this$0 = eALManager;
    }

    @Override
    public void run() {
        IWidgetLogChannel.logChannel3DEngine.log(-2137614336, "EALManager#fireRenderEvent before render");
        boolean bl = EALManager.access$900(this.this$0).render(EALManager.access$800(this.this$0));
        IWidgetLogChannel.logChannel3DEngine.log(-2137614336, "EALManager#fireRenderEvent after render, success=%1", bl);
    }
}

