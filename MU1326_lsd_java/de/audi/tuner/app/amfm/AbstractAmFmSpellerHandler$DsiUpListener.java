/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AbstractAmFmSpellerHandler;
import de.audi.tuner.app.amfm.AbstractAmFmSpellerHandler$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import org.dsi.ifc.radio.WavebandInfo;

class AbstractAmFmSpellerHandler$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ AbstractAmFmSpellerHandler this$0;

    private AbstractAmFmSpellerHandler$DsiUpListener(AbstractAmFmSpellerHandler abstractAmFmSpellerHandler) {
        this.this$0 = abstractAmFmSpellerHandler;
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
        int n;
        if (wavebandInfoArray == null) {
            return;
        }
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        for (n = 0; n < wavebandInfoArray.length; ++n) {
            if (wavebandInfoArray[n].waveband != this.this$0.getWaveband()) continue;
            n2 = this.this$0.cutOffTrailingDigits((int)wavebandInfoArray[n].lowerLimit);
            n3 = this.this$0.cutOffTrailingDigits((int)wavebandInfoArray[n].upperLimit);
            n4 = this.this$0.cutOffTrailingDigits((int)wavebandInfoArray[n].stepWidth);
            this.this$0.processWavebandInfo(wavebandInfoArray[n]);
            break;
        }
        if (n3 > n2 && n4 > 0) {
            AbstractAmFmSpellerHandler.access$500(this.this$0);
            for (n = n2; n <= n3; n += n4) {
                AbstractAmFmSpellerHandler.access$600(this.this$0, n);
            }
        }
        AbstractAmFmSpellerHandler.access$300(this.this$0, this.this$0.spellerModel.getText());
    }

    /* synthetic */ AbstractAmFmSpellerHandler$DsiUpListener(AbstractAmFmSpellerHandler abstractAmFmSpellerHandler, AbstractAmFmSpellerHandler$1 abstractAmFmSpellerHandler$1) {
        this(abstractAmFmSpellerHandler);
    }
}

