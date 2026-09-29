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
import de.audi.tuner.app.uni.UniRadioTextHistory$DSIDownListener;
import de.audi.tuner.app.uni.UniRadioTextHistory$DsiUpListener;
import de.audi.tuner.app.uni.UnifiedStationExt;

class UniRadioTextHistory
extends RadioTextHistory {
    final UniDsiUpInfo dsiUpListener = new UniRadioTextHistory$DsiUpListener(this, null);
    final UniDsiDownInfo dsiDownListener = new UniRadioTextHistory$DSIDownListener(this, null);
    private UnifiedStationExt currentStation = new UnifiedStationExt();

    UniRadioTextHistory(TunerBasics tunerBasics, RadiotextHyperlinkProcessor radiotextHyperlinkProcessor) {
        super(tunerBasics, radiotextHyperlinkProcessor, -1534590720, -796393216, -1433927424, "Uni", tunerBasics.getLogger().uniDSI);
    }

    private static boolean isRadioTextSupportedByNewStation(UnifiedStationExt unifiedStationExt) {
        boolean bl = !unifiedStationExt.isFM();
        return bl || unifiedStationExt.rds;
    }

    static /* synthetic */ boolean access$200(UnifiedStationExt unifiedStationExt) {
        return UniRadioTextHistory.isRadioTextSupportedByNewStation(unifiedStationExt);
    }

    static /* synthetic */ void access$300(UniRadioTextHistory uniRadioTextHistory, boolean bl) {
        uniRadioTextHistory.reset(bl);
    }

    static /* synthetic */ UnifiedStationExt access$402(UniRadioTextHistory uniRadioTextHistory, UnifiedStationExt unifiedStationExt) {
        uniRadioTextHistory.currentStation = unifiedStationExt;
        return uniRadioTextHistory.currentStation;
    }

    static /* synthetic */ void access$500(UniRadioTextHistory uniRadioTextHistory, String string) {
        uniRadioTextHistory.updateRadioText(string);
    }

    static /* synthetic */ void access$600(UniRadioTextHistory uniRadioTextHistory, RadioTextPlusStorage radioTextPlusStorage) {
        uniRadioTextHistory.updateRadiotextPlus(radioTextPlusStorage);
    }

    static /* synthetic */ UnifiedStationExt access$400(UniRadioTextHistory uniRadioTextHistory) {
        return uniRadioTextHistory.currentStation;
    }

    static /* synthetic */ void access$700(UniRadioTextHistory uniRadioTextHistory, boolean bl) {
        uniRadioTextHistory.reset(bl);
    }
}

