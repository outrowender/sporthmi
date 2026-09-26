/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.combi;

import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.combi.CombiBAPServiceHandler;
import de.audi.tv.app.combi.CombiBAPServiceHandler$1;

class CombiBAPServiceHandler$EventListener
extends TVEventDefaultListener {
    private final /* synthetic */ CombiBAPServiceHandler this$0;

    private CombiBAPServiceHandler$EventListener(CombiBAPServiceHandler combiBAPServiceHandler) {
        this.this$0 = combiBAPServiceHandler;
    }

    @Override
    public void onMuGotTvAudioFocus() {
        if (!CombiBAPServiceHandler.access$800(this.this$0)) {
            CombiBAPServiceHandler.access$1200(this.this$0, CombiBAPServiceHandler.access$700(this.this$0));
            CombiBAPServiceHandler.access$802(this.this$0, true);
        }
    }

    @Override
    public void onMuLostTvAudioFocus() {
        CombiBAPServiceHandler.access$802(this.this$0, false);
    }

    @Override
    public void onTunerAvailable() {
        CombiBAPServiceHandler.access$1302(this.this$0, true);
        CombiBAPServiceHandler.access$1400(this.this$0);
        if (CombiBAPServiceHandler.access$800(this.this$0)) {
            if (CombiBAPServiceHandler.access$1500(this.this$0) == null) {
                CombiBAPServiceHandler.access$1502(this.this$0, new CombiBAPCurrentStationInfo(CombiBAPServiceHandler.access$1600((CombiBAPServiceHandler)this.this$0).getTunedService().name, 71));
            }
            CombiBAPServiceHandler.access$1200(this.this$0, CombiBAPServiceHandler.access$700(this.this$0));
        }
    }

    @Override
    public void onTunerUnavailable() {
        CombiBAPServiceHandler.access$1302(this.this$0, false);
        if (CombiBAPServiceHandler.access$800(this.this$0)) {
            CombiBAPServiceHandler.access$1200(this.this$0, CombiBAPServiceHandler.access$700(this.this$0));
        }
        CombiBAPServiceHandler.access$1400(this.this$0);
    }

    @Override
    public void onMuteChange(boolean bl) {
        try {
            CombiBAPServiceHandler.access$900(this.this$0).updateMuteState(bl);
        }
        catch (Exception exception) {
            CombiBAPServiceHandler.access$1000((CombiBAPServiceHandler)this.this$0).lcCombi.log(10000, "%1", (Throwable)exception);
        }
    }

    @Override
    public void onFocusedListChanged(int n) {
        try {
            CombiBAPServiceHandler.access$900(this.this$0).updatePreferredList(n == 0 ? 1 : 2);
        }
        catch (Exception exception) {
            CombiBAPServiceHandler.access$1000((CombiBAPServiceHandler)this.this$0).lcCombi.log(10000, "%1", (Throwable)exception);
        }
    }

    /* synthetic */ CombiBAPServiceHandler$EventListener(CombiBAPServiceHandler combiBAPServiceHandler, CombiBAPServiceHandler$1 combiBAPServiceHandler$1) {
        this(combiBAPServiceHandler);
    }
}

