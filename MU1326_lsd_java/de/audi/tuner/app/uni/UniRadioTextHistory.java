/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.RadioTextHistory;
import de.audi.tuner.app.RadioTextPlusStorage;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UnifiedStationExt;
import org.dsi.ifc.radio.UnifiedRadioText;

class UniRadioTextHistory
extends RadioTextHistory {
    final UniDsiUpInfo dsiUpListener = new DsiUpListener();
    final UniDsiDownInfo dsiDownListener = new DSIDownListener();
    private UnifiedStationExt currentStation = new UnifiedStationExt();

    UniRadioTextHistory(TunerBasics tunerBasics, RadiotextHyperlinkProcessor radiotextHyperlinkProcessor) {
        super(tunerBasics, radiotextHyperlinkProcessor, 100516, 100560, 100522, "Uni", tunerBasics.getLogger().uniDSI);
    }

    private static boolean isRadioTextSupportedByNewStation(UnifiedStationExt unifiedStationExt) {
        boolean bl = !unifiedStationExt.isFM();
        return bl || unifiedStationExt.rds;
    }

    private class DsiUpListener
    extends UniDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateRadioText(UnifiedRadioText unifiedRadioText) {
            UniRadioTextHistory.this.updateRadioText(unifiedRadioText.radioText);
        }

        public void updateRadioTextPlus(RadioTextPlusStorage radioTextPlusStorage) {
            UniRadioTextHistory.this.updateRadiotextPlus(radioTextPlusStorage);
        }

        public void updateSelectedStation(UnifiedStationExt unifiedStationExt) {
            if (!unifiedStationExt.rds && unifiedStationExt.ensId == 0 || unifiedStationExt.piSId != ((UniRadioTextHistory)UniRadioTextHistory.this).currentStation.piSId) {
                UniRadioTextHistory.this.reset(UniRadioTextHistory.isRadioTextSupportedByNewStation(unifiedStationExt));
            }
            UniRadioTextHistory.this.currentStation = unifiedStationExt;
        }
    }

    private class DSIDownListener
    extends UniDsiDownInfo {
        private DSIDownListener() {
        }

        public void preTuneCommand(UnifiedStationExt unifiedStationExt) {
            UniRadioTextHistory.this.reset(UniRadioTextHistory.isRadioTextSupportedByNewStation(unifiedStationExt));
            UniRadioTextHistory.this.currentStation = unifiedStationExt;
        }
    }
}

