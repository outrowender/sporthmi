/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.RadioTextHistory;
import de.audi.tuner.app.RadioTextPlusStorage;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import org.dsi.ifc.radio.DABRadioText;

class DabRadioTextHistory
extends RadioTextHistory {
    final DABDsiUpInfo dsiUpListener = new DsiUpListener();
    final DABDsiDownInfo dsiDownListener = new DSIDownListener();

    DabRadioTextHistory(TunerBasics tunerBasics, RadiotextHyperlinkProcessor radiotextHyperlinkProcessor) {
        super(tunerBasics, radiotextHyperlinkProcessor, 100514, 100558, 100365, "Dab", tunerBasics.getLogger().dabDSI);
    }

    private class DsiUpListener
    extends DABDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateRadioText(DABRadioText dABRadioText) {
            DabRadioTextHistory.this.updateRadioText(dABRadioText.text);
        }

        public void updateRadioTextPlusInfo(RadioTextPlusStorage radioTextPlusStorage) {
            DabRadioTextHistory.this.updateRadiotextPlus(radioTextPlusStorage);
        }

        public void seekServiceStatus(boolean bl) {
            if (bl) {
                DabRadioTextHistory.this.reset(false);
            }
        }

        public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
            int n = DabRadioTextHistory.this.models.getChoiceModel(100365).getValue();
            if (n == 2 || n == 4) {
                DabRadioTextHistory.this.reset(true);
            }
        }
    }

    private class DSIDownListener
    extends DABDsiDownInfo {
        private DSIDownListener() {
        }

        public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
            DabRadioTextHistory.this.reset(true);
        }
    }
}

