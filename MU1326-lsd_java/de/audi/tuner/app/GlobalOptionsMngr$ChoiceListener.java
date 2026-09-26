/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.GlobalOptionsMngr;
import de.audi.tuner.app.GlobalOptionsMngr$1;
import de.audi.tuner.app.TunerProxyManager;

class GlobalOptionsMngr$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ GlobalOptionsMngr this$0;

    private GlobalOptionsMngr$ChoiceListener(GlobalOptionsMngr globalOptionsMngr) {
        this.this$0 = globalOptionsMngr;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        GlobalOptionsMngr.access$200(this.this$0).getChoiceModel(n).setValue(n2);
        if (n2 != GlobalOptionsMngr.access$300(this.this$0)) {
            GlobalOptionsMngr.access$302(this.this$0, n2);
            GlobalOptionsMngr.access$400(this.this$0).storePreferredImageType(GlobalOptionsMngr.access$300(this.this$0));
            TunerProxyManager.getInstance().getStationListHandler(1).setPrefImgType(GlobalOptionsMngr.access$300(this.this$0));
            TunerProxyManager.getInstance().getStationListHandler(5).setPrefImgType(GlobalOptionsMngr.access$300(this.this$0));
            TunerProxyManager.getInstance().getStationListHandler(11).setPrefImgType(GlobalOptionsMngr.access$300(this.this$0));
            TunerProxyManager.getInstance().getStationListHandler(7).setPrefImgType(GlobalOptionsMngr.access$300(this.this$0));
            GlobalOptionsMngr.access$500(this.this$0).setPreferredImgType(GlobalOptionsMngr.access$300(this.this$0));
            GlobalOptionsMngr.access$600(this.this$0).setPreferredImgType(GlobalOptionsMngr.access$300(this.this$0));
            if (GlobalOptionsMngr.access$700(this.this$0) != null) {
                GlobalOptionsMngr.access$700(this.this$0).setPreferredImgType(GlobalOptionsMngr.access$300(this.this$0));
            }
        }
    }

    /* synthetic */ GlobalOptionsMngr$ChoiceListener(GlobalOptionsMngr globalOptionsMngr, GlobalOptionsMngr$1 globalOptionsMngr$1) {
        this(globalOptionsMngr);
    }
}

