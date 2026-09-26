/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.EWS;
import de.audi.tv.app.EWS$1;
import de.audi.tv.app.dsi.DefaultTVListener;
import org.dsi.ifc.tvtuner.EWSInfo;
import org.dsi.ifc.tvtuner.StartUpConfig;

class EWS$TVListenerExt
extends DefaultTVListener {
    private final /* synthetic */ EWS this$0;

    private EWS$TVListenerExt(EWS eWS) {
        this.this$0 = eWS;
    }

    @Override
    public void updateEWSInfoList(EWSInfo[] eWSInfoArray) {
        if (EWS.access$700(this.this$0) && EWS.access$800(this.this$0)) {
            EWS.access$900(this.this$0, eWSInfoArray);
            EWS.access$1000(this.this$0, -1);
        }
    }

    @Override
    public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
        EWS.access$702(this.this$0, startUpConfig.ewsAvail);
    }

    /* synthetic */ EWS$TVListenerExt(EWS eWS, EWS$1 eWS$1) {
        this(eWS);
    }
}

