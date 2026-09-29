/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rse;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.rse.TabletServiceHandler;
import de.audi.tuner.app.rse.TabletServiceHandler$1;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.ifc.listener.IPdtListener;

class TabletServiceHandler$PdtListener
implements IPdtListener {
    private volatile SdarsRadioText latestSdarsRadioText = SdarsRadioText.EMPTY_RADIOTEXT;
    private final /* synthetic */ TabletServiceHandler this$0;

    private TabletServiceHandler$PdtListener(TabletServiceHandler tabletServiceHandler) {
        this.this$0 = tabletServiceHandler;
    }

    @Override
    public void updatePdt(int n, SdarsRadioText sdarsRadioText) {
        TunerObjectContainer tunerObjectContainer;
        this.latestSdarsRadioText = sdarsRadioText;
        if (this.latestSdarsRadioText == null) {
            this.latestSdarsRadioText = SdarsRadioText.EMPTY_RADIOTEXT;
        }
        if ((tunerObjectContainer = TabletServiceHandler.access$600(this.this$0)).getBand() == 7 && tunerObjectContainer.getSDARSService().sID == n) {
            TabletServiceHandler.access$500(this.this$0).updateActiveStation(TabletServiceHandler.access$800(this.this$0, tunerObjectContainer, TabletServiceHandler.access$700(this.this$0).loadPreferredImageType(), true));
        }
    }

    public void reset() {
        this.latestSdarsRadioText = SdarsRadioText.EMPTY_RADIOTEXT;
    }

    /* synthetic */ TabletServiceHandler$PdtListener(TabletServiceHandler tabletServiceHandler, TabletServiceHandler$1 tabletServiceHandler$1) {
        this(tabletServiceHandler);
    }

    static /* synthetic */ SdarsRadioText access$300(TabletServiceHandler$PdtListener tabletServiceHandler$PdtListener) {
        return tabletServiceHandler$PdtListener.latestSdarsRadioText;
    }
}

