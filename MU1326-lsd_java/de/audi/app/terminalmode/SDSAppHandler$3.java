/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.SDSAppHandler;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.utils.generics.Consumer;

class SDSAppHandler$3
implements Consumer {
    private final /* synthetic */ SDSAppHandler this$0;

    SDSAppHandler$3(SDSAppHandler sDSAppHandler) {
        this.this$0 = sDSAppHandler;
    }

    public void accept(SDSService sDSService) {
        sDSService.registerStatusListener(this.this$0);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((SDSService)object);
    }
}

