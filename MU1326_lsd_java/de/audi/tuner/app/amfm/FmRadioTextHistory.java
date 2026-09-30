/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.RadioTextHistory;
import de.audi.tuner.app.RadioTextPlusStorage;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import org.dsi.ifc.radio.AMFMRadioText;

class FmRadioTextHistory
extends RadioTextHistory {
    final AMFMDsiUpInfo dsiUpListener = new DsiUpListener();
    final AMFMDsiDownInfo dsiDownListener = new DSIDownListener();
    private AMFMStation currentStation = new AMFMStation();

    FmRadioTextHistory(TunerBasics tunerBasics, RadiotextHyperlinkProcessor radiotextHyperlinkProcessor) {
        super(tunerBasics, radiotextHyperlinkProcessor, 100515, 100559, 100390, "Fm", tunerBasics.getLogger().amfmDSI);
    }

    private static boolean isRadioTextSupportedByNewStation(AMFMStation aMFMStation) {
        if (Utilities.isJapan()) {
            return false;
        }
        return aMFMStation.rds || aMFMStation.hd;
    }

    private class DsiUpListener
    extends AMFMDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateRadioText(AMFMRadioText aMFMRadioText) {
            FmRadioTextHistory.this.updateRadioText(aMFMRadioText.text);
        }

        public void updateRadioTextPlus(RadioTextPlusStorage radioTextPlusStorage) {
            FmRadioTextHistory.this.updateRadiotextPlus(radioTextPlusStorage);
        }

        public void updateSelectedStation(AMFMStation aMFMStation) {
            if (Utilities.isPiIgnore()) {
                if (aMFMStation.frequency != ((FmRadioTextHistory)FmRadioTextHistory.this).currentStation.frequency || aMFMStation.serviceId != ((FmRadioTextHistory)FmRadioTextHistory.this).currentStation.serviceId || !aMFMStation.rds && !aMFMStation.hd) {
                    FmRadioTextHistory.this.reset(FmRadioTextHistory.isRadioTextSupportedByNewStation(aMFMStation));
                }
            } else if (!aMFMStation.rds || aMFMStation.pi != ((FmRadioTextHistory)FmRadioTextHistory.this).currentStation.pi) {
                FmRadioTextHistory.this.reset(FmRadioTextHistory.isRadioTextSupportedByNewStation(aMFMStation));
            }
            FmRadioTextHistory.this.currentStation = aMFMStation;
        }

        public void seekStationStatus(boolean bl) {
            if (bl) {
                FmRadioTextHistory.this.reset(false);
            }
        }
    }

    private class DSIDownListener
    extends AMFMDsiDownInfo {
        private DSIDownListener() {
        }

        public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
            FmRadioTextHistory.this.reset(FmRadioTextHistory.isRadioTextSupportedByNewStation(aMFMStation));
            FmRadioTextHistory.this.currentStation = aMFMStation;
        }
    }
}

