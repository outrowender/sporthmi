/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.RadioTextHistory;
import de.audi.tuner.app.RadioTextPlusStorage;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.FmRadioTextHistory$DSIDownListener;
import de.audi.tuner.app.amfm.FmRadioTextHistory$DsiUpListener;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;

class FmRadioTextHistory
extends RadioTextHistory {
    final AMFMDsiUpInfo dsiUpListener = new FmRadioTextHistory$DsiUpListener(this, null);
    final AMFMDsiDownInfo dsiDownListener = new FmRadioTextHistory$DSIDownListener(this, null);
    private AMFMStation currentStation = new AMFMStation();

    FmRadioTextHistory(TunerBasics tunerBasics, RadiotextHyperlinkProcessor radiotextHyperlinkProcessor) {
        super(tunerBasics, radiotextHyperlinkProcessor, -1551367936, -813170432, 646447360, "Fm", tunerBasics.getLogger().amfmDSI);
    }

    private static boolean isRadioTextSupportedByNewStation(AMFMStation aMFMStation) {
        if (Utilities.isJapan()) {
            return false;
        }
        return aMFMStation.rds || aMFMStation.hd;
    }

    static /* synthetic */ boolean access$200(AMFMStation aMFMStation) {
        return FmRadioTextHistory.isRadioTextSupportedByNewStation(aMFMStation);
    }

    static /* synthetic */ void access$300(FmRadioTextHistory fmRadioTextHistory, boolean bl) {
        fmRadioTextHistory.reset(bl);
    }

    static /* synthetic */ AMFMStation access$402(FmRadioTextHistory fmRadioTextHistory, AMFMStation aMFMStation) {
        fmRadioTextHistory.currentStation = aMFMStation;
        return fmRadioTextHistory.currentStation;
    }

    static /* synthetic */ void access$500(FmRadioTextHistory fmRadioTextHistory, String string) {
        fmRadioTextHistory.updateRadioText(string);
    }

    static /* synthetic */ void access$600(FmRadioTextHistory fmRadioTextHistory, RadioTextPlusStorage radioTextPlusStorage) {
        fmRadioTextHistory.updateRadiotextPlus(radioTextPlusStorage);
    }

    static /* synthetic */ AMFMStation access$400(FmRadioTextHistory fmRadioTextHistory) {
        return fmRadioTextHistory.currentStation;
    }

    static /* synthetic */ void access$700(FmRadioTextHistory fmRadioTextHistory, boolean bl) {
        fmRadioTextHistory.reset(bl);
    }

    static /* synthetic */ void access$800(FmRadioTextHistory fmRadioTextHistory, boolean bl) {
        fmRadioTextHistory.reset(bl);
    }

    static /* synthetic */ void access$900(FmRadioTextHistory fmRadioTextHistory, boolean bl) {
        fmRadioTextHistory.reset(bl);
    }
}

