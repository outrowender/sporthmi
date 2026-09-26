/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.RadioTextHistory;
import de.audi.tuner.app.RadioTextPlusStorage;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DabRadioTextHistory$DSIDownListener;
import de.audi.tuner.app.dab.DabRadioTextHistory$DsiUpListener;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;

class DabRadioTextHistory
extends RadioTextHistory {
    final DABDsiUpInfo dsiUpListener = new DabRadioTextHistory$DsiUpListener(this, null);
    final DABDsiDownInfo dsiDownListener = new DabRadioTextHistory$DSIDownListener(this, null);

    DabRadioTextHistory(TunerBasics tunerBasics, RadiotextHyperlinkProcessor radiotextHyperlinkProcessor) {
        super(tunerBasics, radiotextHyperlinkProcessor, -1568145152, -829947648, 227016960, "Dab", tunerBasics.getLogger().dabDSI);
    }

    static /* synthetic */ void access$200(DabRadioTextHistory dabRadioTextHistory, boolean bl) {
        dabRadioTextHistory.reset(bl);
    }

    static /* synthetic */ void access$300(DabRadioTextHistory dabRadioTextHistory, String string) {
        dabRadioTextHistory.updateRadioText(string);
    }

    static /* synthetic */ void access$400(DabRadioTextHistory dabRadioTextHistory, RadioTextPlusStorage radioTextPlusStorage) {
        dabRadioTextHistory.updateRadiotextPlus(radioTextPlusStorage);
    }

    static /* synthetic */ void access$500(DabRadioTextHistory dabRadioTextHistory, boolean bl) {
        dabRadioTextHistory.reset(bl);
    }

    static /* synthetic */ TunerModels access$600(DabRadioTextHistory dabRadioTextHistory) {
        return dabRadioTextHistory.models;
    }

    static /* synthetic */ void access$700(DabRadioTextHistory dabRadioTextHistory, boolean bl) {
        dabRadioTextHistory.reset(bl);
    }
}

