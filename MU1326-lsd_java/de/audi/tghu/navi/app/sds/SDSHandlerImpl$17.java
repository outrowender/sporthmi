/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.phone.ITelServiceListener;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl;

class SDSHandlerImpl$17
implements ITelServiceListener {
    private final /* synthetic */ SDSHandlerImpl this$0;

    SDSHandlerImpl$17(SDSHandlerImpl sDSHandlerImpl) {
        this.this$0 = sDSHandlerImpl;
    }

    @Override
    public void dialNumberResponse(int n) {
        this.this$0.logChannel.log(-2137614336, "SDSHandlerImplr#dialDetailsNumber( %1 )", (long)n);
        if (n == 0) {
            this.this$0.naviServiceListener.responseDialDetailsNumber((byte)0);
        } else {
            this.this$0.logChannel.log(10000, "SDSHandlerImpl#dialDetailsNumber( %1 ) - dial was not successful", (long)n);
            this.this$0.naviServiceListener.responseDialDetailsNumber((byte)1);
        }
    }
}

