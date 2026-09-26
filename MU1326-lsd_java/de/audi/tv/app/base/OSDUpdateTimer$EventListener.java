/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.OSDUpdateTimer;
import de.audi.tv.app.base.OSDUpdateTimer$1;
import de.audi.tv.app.base.TVEventDefaultListener;
import org.dsi.ifc.tvtuner.ProgramInfo;

class OSDUpdateTimer$EventListener
extends TVEventDefaultListener {
    private final /* synthetic */ OSDUpdateTimer this$0;

    private OSDUpdateTimer$EventListener(OSDUpdateTimer oSDUpdateTimer) {
        this.this$0 = oSDUpdateTimer;
    }

    @Override
    public void onSelectedServiceDebounced(ProgramInfo programInfo) {
        if (!TVUtil.isVideoService(programInfo.serviceInfo)) {
            OSDUpdateTimer.access$100(this.this$0).log(-2137614336, "[OSDUpdateTimer.onSelectedServiceDebounced] activate timer");
            OSDUpdateTimer.access$200(this.this$0).restart();
        } else {
            OSDUpdateTimer.access$100(this.this$0).log(-2137614336, "[OSDUpdateTimer.onSelectedServiceDebounced] deactivate timer");
            OSDUpdateTimer.access$200(this.this$0).cancel();
        }
    }

    /* synthetic */ OSDUpdateTimer$EventListener(OSDUpdateTimer oSDUpdateTimer, OSDUpdateTimer$1 oSDUpdateTimer$1) {
        this(oSDUpdateTimer);
    }
}

