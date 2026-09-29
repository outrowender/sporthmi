/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.RadioTextHistory;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import de.audi.tuner.app.sdars.PdtInfoHandler;
import de.audi.tuner.app.sdars.SdarsRadioTextHistory$DsiDownListener;
import de.audi.tuner.app.sdars.SdarsRadioTextHistory$DsiUpListener;
import de.audi.tuner.app.sdars.SdarsRadioTextHistory$PdtListener;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.ifc.listener.IPdtListener;

public class SdarsRadioTextHistory
extends RadioTextHistory {
    final SDARSDsiUpInfo dsiUpInfo = new SdarsRadioTextHistory$DsiUpListener(this, null);
    final SDARSDsiDownInfo dsiDownInfo = new SdarsRadioTextHistory$DsiDownListener(this, null);
    private final IPdtListener pdtListener = new SdarsRadioTextHistory$PdtListener(this, null);
    private final PdtInfoHandler pdtHandler;
    private int sID;

    public SdarsRadioTextHistory(TunerBasics tunerBasics, PdtInfoHandler pdtInfoHandler, RadiotextHyperlinkProcessor radiotextHyperlinkProcessor) {
        super(tunerBasics, radiotextHyperlinkProcessor, 1837695232, 1854472448, 1049035008, "SDARS", tunerBasics.getLogger().sdarsDSI);
        this.pdtHandler = pdtInfoHandler;
    }

    private void updateStation(int n) {
        if (this.sID != n) {
            this.pdtHandler.removeListener(this.sID, this.pdtListener);
            this.sID = n;
            this.reset(true);
            this.pdtHandler.addListener(this.sID, this.pdtListener, 0);
        }
    }

    static /* synthetic */ void access$300(SdarsRadioTextHistory sdarsRadioTextHistory, int n) {
        sdarsRadioTextHistory.updateStation(n);
    }

    static /* synthetic */ int access$400(SdarsRadioTextHistory sdarsRadioTextHistory) {
        return sdarsRadioTextHistory.sID;
    }

    static /* synthetic */ void access$500(SdarsRadioTextHistory sdarsRadioTextHistory, String string) {
        sdarsRadioTextHistory.updateRadioText(string);
    }
}

