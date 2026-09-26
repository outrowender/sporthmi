/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.PdtInfoHandler;
import de.audi.tuner.app.sdars.PdtInfoHandler$1;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import org.dsi.ifc.sdars.RadioText;

class PdtInfoHandler$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ PdtInfoHandler this$0;

    private PdtInfoHandler$DsiUpListener(PdtInfoHandler pdtInfoHandler) {
        this.this$0 = pdtInfoHandler;
    }

    @Override
    public void informationRadioText2(RadioText[] radioTextArray) {
        for (int i2 = 0; i2 < radioTextArray.length; ++i2) {
            PdtInfoHandler.access$500(this.this$0, radioTextArray[i2]);
        }
    }

    @Override
    public void updateSignalStatus(boolean bl) {
        PdtInfoHandler.access$600(this.this$0, bl);
    }

    /* synthetic */ PdtInfoHandler$DsiUpListener(PdtInfoHandler pdtInfoHandler, PdtInfoHandler$1 pdtInfoHandler$1) {
        this(pdtInfoHandler);
    }
}

