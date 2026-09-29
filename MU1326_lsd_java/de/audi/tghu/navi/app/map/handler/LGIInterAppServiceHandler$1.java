/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.interapp.navcar.ILGIServiceListener;
import de.audi.tghu.navi.app.map.handler.LGIInterAppServiceHandler;
import org.dsi.ifc.tmc.LocalHazardInformation;

class LGIInterAppServiceHandler$1
implements Runnable {
    private final /* synthetic */ ILGIServiceListener val$listener;
    private final /* synthetic */ LocalHazardInformation[] val$events;
    private final /* synthetic */ LGIInterAppServiceHandler this$0;

    LGIInterAppServiceHandler$1(LGIInterAppServiceHandler lGIInterAppServiceHandler, ILGIServiceListener iLGIServiceListener, LocalHazardInformation[] localHazardInformationArray) {
        this.this$0 = lGIInterAppServiceHandler;
        this.val$listener = iLGIServiceListener;
        this.val$events = localHazardInformationArray;
    }

    @Override
    public void run() {
        this.val$listener.updateLocalHazardInformation(this.val$events);
    }
}

