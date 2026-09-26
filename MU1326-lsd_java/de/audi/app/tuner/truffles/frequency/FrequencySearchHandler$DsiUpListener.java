/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles.frequency;

import de.audi.app.tuner.truffles.frequency.FrequencySearchHandler;
import de.audi.app.tuner.truffles.frequency.FrequencySearchHandler$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import org.dsi.ifc.radio.WavebandInfo;

class FrequencySearchHandler$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ FrequencySearchHandler this$0;

    private FrequencySearchHandler$DsiUpListener(FrequencySearchHandler frequencySearchHandler) {
        this.this$0 = frequencySearchHandler;
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
        block4: for (int i2 = 0; i2 < wavebandInfoArray.length; ++i2) {
            switch (wavebandInfoArray[i2].waveband) {
                case 1: {
                    FrequencySearchHandler.access$100(this.this$0).updateBandInformation(new WavebandInfo[]{wavebandInfoArray[i2]});
                    continue block4;
                }
                case 3: {
                    FrequencySearchHandler.access$200(this.this$0).updateBandInformation(new WavebandInfo[]{wavebandInfoArray[i2]});
                    continue block4;
                }
            }
        }
    }

    /* synthetic */ FrequencySearchHandler$DsiUpListener(FrequencySearchHandler frequencySearchHandler, FrequencySearchHandler$1 frequencySearchHandler$1) {
        this(frequencySearchHandler);
    }
}

