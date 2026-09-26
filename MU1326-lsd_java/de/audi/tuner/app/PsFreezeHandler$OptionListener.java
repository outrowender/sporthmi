/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.tuner.app.PsFreezeHandler;
import de.audi.tuner.app.PsFreezeHandler$1;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.ifc.AbstractRadioListRow;

class PsFreezeHandler$OptionListener
extends DefaultOptionListener {
    private final /* synthetic */ PsFreezeHandler this$0;

    private PsFreezeHandler$OptionListener(PsFreezeHandler psFreezeHandler) {
        this.this$0 = psFreezeHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        TunerObjectContainer tunerObjectContainer = ((AbstractRadioListRow)PsFreezeHandler.access$200(this.this$0).getBaseListModel(n2).getRow(n3)).getTOContainer();
        if (tunerObjectContainer.getType() == 3) {
            PsFreezeHandler.access$302(this.this$0, tunerObjectContainer.getAMFMService());
            PsFreezeHandler.access$402(this.this$0, Utilities.getBandIdByWaveband(PsFreezeHandler.access$300((PsFreezeHandler)this.this$0).waveband));
        } else {
            PsFreezeHandler.access$302(this.this$0, tunerObjectContainer.getUniStation().getFmStation());
            PsFreezeHandler.access$402(this.this$0, 11);
        }
        if (PsFreezeHandler.access$300(this.this$0).isPsFreezed()) {
            PsFreezeHandler.access$500(this.this$0);
        } else {
            String string = PsFreezeHandler.access$300((PsFreezeHandler)this.this$0).name;
            if (string.length() == 0) {
                string = PsFreezeHandler.access$300(this.this$0).getFrequencyString();
            }
            int n6 = Utilities.isEmpty(string) ? 0 : 1;
            PsFreezeHandler.access$200(this.this$0).getButtonModel(847708416).setStatus(n6);
            PsFreezeHandler.access$200(this.this$0).getSpellerModel(830996736).setText(string);
            PsFreezeHandler.access$200(this.this$0).getOptionModel(-1383661312).fireEvent(n5);
        }
    }

    /* synthetic */ PsFreezeHandler$OptionListener(PsFreezeHandler psFreezeHandler, PsFreezeHandler$1 psFreezeHandler$1) {
        this(psFreezeHandler);
    }
}

