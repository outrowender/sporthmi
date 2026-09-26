/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.interapp.navcar.ILGIServiceListener;
import de.audi.tghu.navi.app.map.handler.LGIInterAppServiceHandler;

class LGIInterAppServiceHandler$2
implements Runnable {
    private final /* synthetic */ ILGIServiceListener val$listener;
    private final /* synthetic */ LGIInterAppServiceHandler this$0;

    LGIInterAppServiceHandler$2(LGIInterAppServiceHandler lGIInterAppServiceHandler, ILGIServiceListener iLGIServiceListener) {
        this.this$0 = lGIInterAppServiceHandler;
        this.val$listener = iLGIServiceListener;
    }

    @Override
    public void run() {
        this.val$listener.updateLocalHazardInformation(LGIInterAppServiceHandler.access$000(this.this$0));
    }
}

